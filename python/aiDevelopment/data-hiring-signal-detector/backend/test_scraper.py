import unittest
from unittest.mock import MagicMock, patch

import backend.scraper as scraper

class TestScraper(unittest.TestCase):
    def test_build_linkedin_company_urls(self):
        urls = scraper._build_linkedin_company_urls("IBM")

        self.assertEqual(urls[0], "https://www.linkedin.com/jobs/search/?keywords=IBM&location=United+States")
        self.assertEqual(urls[1], "https://www.linkedin.com/jobs/search/?keywords=IBM")
        self.assertTrue(all(url.startswith("https://www.linkedin.com/jobs/search/?keywords=") for url in urls))

    @patch("backend.scraper.httpx.Client")
    def test_fetch_jobs_for_company_uses_scrape_endpoint(self, mock_client_class):
        mock_response = MagicMock()
        mock_response.raise_for_status.return_value = None
        mock_response.json.return_value = [
            {
                "company": "Stripe",
                "job_title": "Senior Engineer",
                "job_description": "Build infrastructure",
            }
        ]

        mock_client = MagicMock()
        mock_client.post.return_value = mock_response
        mock_client.__enter__.return_value = mock_client
        mock_client.__exit__.return_value = None
        mock_client_class.return_value = mock_client

        with patch.object(scraper, "BASE_URL", "https://api.brightdata.com/datasets/v3"), patch.object(
            scraper, "LINKEDIN_JOBS_DATASET_ID", "gd_l1vikfnt1wgvvqz95w"
        ), patch.object(scraper, "BRIGHT_DATA_API_KEY", "token"):
            jobs = scraper.fetch_jobs_for_company("Stripe", "United States")

        self.assertEqual(len(jobs), 1)
        self.assertEqual(jobs[0]["company_name"], "Stripe")
        self.assertEqual(jobs[0]["job_title"], "Senior Engineer")

        expected_url = (
            "https://api.brightdata.com/datasets/v3/scrape?dataset_id=gd_l1vikfnt1wgvvqz95w&notify=false&include_errors=true"
        )
        mock_client.post.assert_called_once()
        called_url, kwargs = mock_client.post.call_args[0][0], mock_client.post.call_args[1]
        self.assertEqual(called_url, expected_url)
        self.assertIn("json", kwargs)
        self.assertEqual(kwargs["json"]["limit_per_input"], None)
        self.assertEqual(len(kwargs["json"]["input"]), 2)
        self.assertTrue(kwargs["json"]["input"][0]["url"].startswith("https://www.linkedin.com/jobs/search/?keywords="))

if __name__ == "__main__":
    unittest.main()
