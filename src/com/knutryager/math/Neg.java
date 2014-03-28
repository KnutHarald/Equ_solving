package com.knutryager.math;

public class Neg extends UnaryOperator{
	
	public Neg(Expression arg){
		arg1 = arg;
	}
	
	@Override
	public String getOp() {
		return "-";
	}
	
	@Override
	public String getMathJaxSymbol() {
		return getOp();
	}

	@Override
	public double getValue() {
		return - arg1.getValue();
	}

	@Override
	public String toString() {
		return "(-" + arg1.toString() + ")";
	}

	@Override
	public Expression getDifferential() {
		return new Neg(arg1.getDifferential());
	}

	@Override
	public String getType() {
		return "NEGATION";
	}

	@Override
	public Expression clean() {
		if(arg1 instanceof Neg)
			return ((Neg) arg1).arg1;
		else if(arg1 instanceof Value)
			return new Value(-arg1.getValue());
		//TODO: terms invert
		return this;
	}

	@Override
	public String toMathJax() {
		return "-" + arg1.toMathJax();
	}
}
