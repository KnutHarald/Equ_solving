package com.knutryager.math;

public abstract class BinaryOperator extends Operator{
	
	Expression arg1;
	Expression arg2;
	boolean associative;
	boolean commutative;
	
	
	@Override
	public String toString() {
		return "(" + arg1.toString() + "" + getOp() + "" + arg2.toString() + ")";
	}
	
	public int getArgCount(){
		return 2;
	}
	
	public Expression getArg(int index){
		if(index == 0)
			return arg1;
		else
			return arg2;
	}
	
	public String toMathJax(){
		return arg1.toMathJax() + getMathJaxSymbol() + arg2.toMathJax();
	}
	
	public String getOperatorDegree(){
		return "BINARY";
	}
	
	

	
	

}
