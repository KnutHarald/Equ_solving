package com.knutryager.math;

public class Div extends BinaryOperator{

	public Div(Expression arg1, Expression arg2){
		this.arg1 = arg1;
		this.arg2 = arg2;
	}
	
	@Override
	public String getOp() {
		return "/";
	}

	@Override
	public String getMathJaxSymbol() {
		return "";
	}

	@Override
	public double getValue() {
		return arg1.getValue() / arg2.getValue();
	}

	@Override
	public Expression getDifferential() {
		return new Div(new Minus(new Mult(arg1.getDifferential(),arg2),new Mult(arg1,arg2.getDifferential())),new Mult(arg1,arg1));
	}
	
	@Override
	public String toMathJax(){
		return "\\frac{" + arg1.toMathJax() + "}{" + arg2.toMathJax() + "}";
	}

	@Override
	public Expression clean() {
		Expression new_arg1 = arg1.clean();
		Expression new_arg2 = arg2.clean();
		if(new_arg2 instanceof Value && new_arg2.getValue() == 1)
			return new_arg1;
		return new Div(new_arg1,new_arg2);
	}

}
