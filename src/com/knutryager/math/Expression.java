package com.knutryager.math;

import java.util.ArrayList;

public abstract class Expression {
	
	
	public abstract double getValue();
	
	public abstract boolean evaluable();
	
	public abstract String toString();
	
	public abstract boolean canDifferentiate();
	
	public abstract Expression getDifferential();
	
	public abstract String getType();
	
	public abstract boolean isIdentic(Expression e);
	
	/*public abstract boolean isEqual(Expression e);
	
	public abstract String getObjectId(boolean strict);
	
	public abstract ArrayList<String> getUniqueObjects();
	
	public abstract ArrayList<String> getVariables();*/
	
	public abstract boolean containsVariable(String var);
	
	//public abstract boolean containsExpression(Expression e);
	
	//public abstract Expression factorizeBy(Expression e)
	
	public abstract Expression clean();
	
	//public abstract Expression numericSimplify();
	
	//public abstract Expression standardize();
	
	public abstract String toMathJax();

	public Expression add(Expression e){
		return new Plus(this,e);
	}
	
	public Expression subtract(Expression e){
		return new Minus(this,e);
	}
	
	public Expression mult(Expression e){
		return new Mult(this,e);
	}
	
	public Expression div(Expression e){
		return new Div(this,e);
	}

	public int termCount(){
		return 1;
	}

	public static void main(String args[]){
		Variable x = new Variable("X");
		x.setValue(3);
		Expression e = new Plus(new Div(new Mult(new Value(2),x),new Mult(x,x)),new Value(5));
		Expression diffed = e.getDifferential();
		System.out.println(e);
		System.out.println(e.getValue());
		System.out.println(diffed);
		System.out.println(diffed.getValue());
		System.out.println(e.toMathJax());
		System.out.println(diffed.toMathJax());
	}

	public Terms toTerms() {
		ArrayList<Expression> e = new ArrayList<Expression>();
		e.add(this);
		ArrayList<Boolean> b = new ArrayList<Boolean>();
		b.add(true);
		return new Terms(e,b);
	}

	public Factors toFactors() {
		ArrayList<Expression> e = new ArrayList<Expression>();
		e.add(this);
		return new Factors(e);
	}
	
}
