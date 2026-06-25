import math

def f(expression,x):
    return eval(expression)

def bisection (expression,a,b, tolerance):
    if f(expression,a)*f(expression,b)>=0:
        print("Invalid interval, No sign change detected")
        return
    
    iteration = 0

    print("\nIter\ta\t\tb\t\tc\t\tf(c)")
    print("-"*70)
    
    while (b-a)/2>tolerance:
        iteration += 1
        c= (a+b)/2

        fc = f(expression,c)
        
        print(
            f"{iteration}\t"
            f"{a: .6f}\t"
            f"{b: .6f}\t"
            f"{c: .6f}\t"
            f"{fc: .6f}"
        )

        if fc==0:
            break

        if f(expression, a)*fc<0:
            b=c
        else:
            a=c

    root = (a + b)/ 2

    print("\nRoot = ", root)
    print("\nIterations = ", iteration)

# for taking inputs
expression = input("Enter the given function in X:: ")
a = float(input("Enter a:: "))
b = float(input("Enter b:: "))
tolerance = float(input("Enter precision points/signifant figures like 0.0001:: "))

bisection(expression, a, b, tolerance)
