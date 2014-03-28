package com.knutryager.math;

public class Ln extends UnaryOperator{
	
	public Ln(Expression arg1){
		this.arg1 = arg1;
	}
	
	public String getMathJaxSymbol(){
		return "Ln";
	}
	
	public Expression getDifferential(){
		return new Div(arg1.getDifferential(),arg1);
	}
	
	public String getType(){
		return "LN_e";
	}
	
	public String getOp(){
		return "ln";
	}
}
