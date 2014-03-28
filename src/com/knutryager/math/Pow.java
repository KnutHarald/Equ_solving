package com.knutryager.math;

public class Pow extends BinaryOperator{
	
	public Pow(Expression arg1,Expression arg2){
		this.arg1 = arg1;
		this.arg2 = arg2;
	}

	@Override
	public String getOp() {
		return "^";
	}
	

	@Override
	public String toString() {
		return "(" + arg1.toString() + getOp() + arg2.toString() + ")";
	}

	@Override
	public String getMathJaxSymbol() {
		return "";
	}
	
	@Override
	public String toMathJax(){
		return arg1.toMathJax() + "^{" + arg2.toMathJax() + "}";
	}

	@Override
	public double getValue() {
		return Math.pow(arg1.getValue(), arg2.getValue());
	}

	@Override
	public Expression getDifferential() {
		return new Mult(new Pow(arg1,new Minus(arg2,new Value(1))),new Plus(new Mult(arg2,arg1.getDifferential()),new Mult(arg1,new Mult(new Ln(arg1),arg2.getDifferential()))));

	}

	@Override
	public Expression clean() {
		// TODO Auto-generated method stub
		return this;
	}

}
