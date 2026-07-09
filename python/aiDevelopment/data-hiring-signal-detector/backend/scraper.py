import os
import httpx
from typing import Any
from urllib.parse import quote_plus

BRIGHT_DATA_API_KEY = os.getenv("BRIGHT_DATA_API_KEY")
LINKEDIN_JOBS_DATASET_ID = "gd_l1vikfnt1wgvvqz95w"
BASE_URL = "https://api.brightdata.com/datasets/v3"


def _headers() -> dict:
    if not BRIGHT_DATA_API_KEY:
        raise RuntimeError("BRIGHT_DATA_API_KEY is not set. Add it to .env and restart the server.")

    return {
        "Authorization": f"Bearer {BRIGHT_DATA_API_KEY}",
        "Content-Type": "application/json",
    }


def _build_linkedin_company_urls(company: str, location: str = "United States") -> list[str]:
    """Build LinkedIn job-search URLs used as Bright Data scrape inputs."""
    company_query = quote_plus(company.strip())
    location_query = quote_plus(location.strip())

    urls = []
    if location_query:
        urls.append(
            f"https://www.linkedin.com/jobs/search/?keywords={company_query}&location={location_query}"
        )
    urls.append(f"https://www.linkedin.com/jobs/search/?keywords={company_query}")
    return urls


def _normalize_job(record: dict[str, Any], company: str) -> dict[str, Any]:
    """Normalize provider field variants before passing jobs to the analyzer."""
    normalized = dict(record)
    normalized.setdefault("company_name", record.get("company") or company)
    normalized.setdefault("job_title", record.get("title") or record.get("position") or "")
    normalized.setdefault("job_location", record.get("location") or "")
    normalized.setdefault("job_function", record.get("function") or "")
    normalized.setdefault("job_seniority_level", record.get("seniority") or "")
    normalized.setdefault("job_posted_date", record.get("posted") or record.get("date_posted") or "")
    normalized.setdefault("job_employment_type", record.get("employment_type") or "")
    return normalized


def fetch_jobs_for_company(company: str, location: str = "United States") -> list[dict[str, Any]]:
    """Scrape current LinkedIn job listings for a company and return normalized records."""
    url = f"{BASE_URL}/scrape?dataset_id={LINKEDIN_JOBS_DATASET_ID}&notify=false&include_errors=true"
    payload = {
        "input": [{"url": url} for url in _build_linkedin_company_urls(company, location)],
        "limit_per_input": None,
    }

    with httpx.Client(timeout=60) as client:
        try:
            resp = client.post(url, json=payload, headers=_headers())
            resp.raise_for_status()
        except httpx.HTTPStatusError as exc:
            body = exc.response.text[:500]
            raise RuntimeError(
                f"Bright Data returned {exc.response.status_code}: {body}"
            ) from exc
        records = resp.json()

    jobs = [_normalize_job(record, company) for record in records if isinstance(record, dict)]
    return [job for job in jobs if job.get("job_title")]
