package scientific.scientificJava;
/* 
import java.util.Scanner;
public class bisectionMethod {

    static double f(double x){
        return Math.pow(x,3)-x-2;
    }

    static double bisection(double a,double b,double tolerance){
        if (f(a)*f(b)>=0){
            throw new IllegalArgumentException("Invalid Interval");
        }

        double midpoint;

        while ((b-a)/2>tolerance){
            midpoint = (b+a)/2;

            if(f(midpoint)==0){
                return midpoint;
            }

            if(f(a)*f(midpoint)<0)
                b = midpoint;
            else
                a = midpoint;
        }
        return (a+b)/2;
    }
    public static void main(String[] args) {
        double root = bisection(1, 2, 0.0001);
        System.out.println("Root = "+ root);
    }
    
}

*/

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.ArrayList;

public class bisectionMethod{
    static class iteration {
        int number;

        double a;
        double b;
        double c;
        double fc;

        public iteration(
            int number,
            double a,
            double b,
            double c,
            double fc
        ){
            this.number=number;
            this.a=a;
            this.b=b;
            this.c=c;
            this.fc=fc;
        }
    }

    static double evaluate(String function, double x){
        Expression expression = new ExpressionBuilder(function).variable("x").build().setVariable("x",x);
        return expression.evaluate();
    }

    static void bisection(
        String function,
        double a,
        double b,
        double tolerance
    ){
        if (evaluate(function, a)*evaluate(function, b) >= 0){
            System.out.println("Invalid Interval");
            return;
        }

        ArrayList<iteration> history = new ArrayList<>();

        int iteration = 0;

        while ((b-a)/2>tolerance) {
            iteration++;

            double c= (a + b) / 2;

            double fc = evaluate(function, c);

            history.add(
                new Iteration(
                iteration, 
                b, 
                c, 
                fc));

            if (fc==0)
                break;

            if (evaluate(function, a)*fc<0)
                b=c;
            else
                a=c;
        }

        System.out.println("\nIter\t a\t\t b\t\t c\t\t f(c)");

        for (Iteration i : history){
            System.out.printf("%d\t%.6f\t%.6f\t%.6f\t%.6f%n",
                i.number,
                i.a,
                i.b,
                i.c,
                i.fc
            );
        }

        double root = (a + b)/2;

        System.out.println("\n Root = " + root);
        System.out.println("\n Iterations = " + iteration);
    }

    public static void main(String[] args) {
        bisection("x^3-x-2", 1, 2, 0.0001);
    }
}

