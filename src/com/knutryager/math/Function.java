package com.knutryager.math;

public abstract class Function {
	Expression func;
	int inputs;
	
	public abstract Expression evaluate(Expression expr);
}
