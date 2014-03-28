package com.knutryager.math;

public class UnaryOperator extends Operator{
	public Expression arg1;
	

	@Override
	public int getArgCount() {
		return 1;
	}

	@Override
	public Expression getArg(int index) {
		return arg1;
	}

	@Override
	public String getOp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMathJaxSymbol() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getValue() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public String getOperatorDegree(){
		return "UNARY";
	}

	@Override
	public Expression getDifferential() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toMathJax() {
		return getMathJaxSymbol() + "(" + arg1.toMathJax() + ")";
	}

	@Override
	public Expression clean() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
