package com.knutryager.math;

public class UnaryFunction extends Function{

	public UnaryFunction(Expression expr) {
		func = expr;
	}
	
	public Expression evaluate(Expression expr){
		return func;
	}

}
