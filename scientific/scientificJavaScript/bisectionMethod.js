```function f(x){
    return x**3-x-2;
}

function bisection(a,b,tolerance){
    if (f(a)*f(b)>=0){
        throw new Error("Invalid Interval");
    }

    let midpoint;

    while ((b-a)/2>tolerance){
        midpoint = (a+b)/2;

        if (f(midpoint)==0)
            return midpoint
        if (f(a)*f(b)<0)
            b = midpoint;
        else
            a=midpoint;
    }
    return (a+b)/2;
}

const root = bisection(1,2,0.0001);
console.log("Root = ",root)```


function evaluate(expression, x){
    return Function("x", "return" + expression)(x);
}

function bisection(expression, a, b, tolerance){
    if (evaluate(expression, a)*evaluate(expression,b) >=0){
        console.log("Invalid Interval");
        return;
    }

    let iteration = 0;

    console.log("Iter\t a\t b\t\t c\t\t f(c)");

    while ((b-a)/2>tolerance){
        iteration++;

        let c = (a + b)/2;

        let fc= evaluate(expression, c);

        console.log(
            `
            ${iteration}\t
            ${a.toFixed(6)}\t
            ${b.toFixed(6)}\t
            ${c.toFixed(6)}\t
            ${fc.toFixed(6)}
            `
        );

        if (fc==0)
            break;

        if (evaluate(expression, a)*fc<0)
            b=c;
        else
            a=c;
    }

    let root = (a + b)/2

    console.log("\n Root = ", root);
    console.log("\n Iterations = ", iteration);
}

bisection("x**3-x-2", 1,2,0.0001);