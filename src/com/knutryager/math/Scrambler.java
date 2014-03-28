package com.knutryager.math;

public class Scrambler {
	
	
	public Equation getBeginnerTask(){
		Variable x = new Variable("x");
		Constant solution = new Constant("solution");
		Equation Eq = new Equation(x,solution);
		//now perform random scrambling. Some scramble suggestions:
		//x + a = b;
		//(x + a)/c = b/c
		//(x + a)/c + a = b/c + a
		//(x + 2ac)/c = b/c + a
		//example: (x+6)/2 = 5/3 + 2
		//solve: *2 , -6 -> x = 4/3
		//lesson: redundant steps in scrambling process
		
		//quadratic eqs:
		//x*x = a*x
		//x*x - b*b = a*x - b*b
		//(x+b)(x-b) = a*x - b*b
		//(x-b) = (a*x -b*b) / (x+b)
		
		//variant 2:
		//x*x = a*a
		//x*x - b*b = a*a - b*b
		//(x+b)(x-b) = a*a - b*b
		//(x-b) = (a*a -b*b) / (x+b)
		
		return Eq;
	}
}
