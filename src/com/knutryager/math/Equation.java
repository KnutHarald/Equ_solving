package com.knutryager.math;

public class Equation extends BinaryOperator{
	
	public Equation(Expression arg1,Expression arg2){
		this.arg1 = arg1;
		this.arg2 = arg2;
	}

	@Override
	public String getOp() {
		return "=";
	}

	@Override
	public String getMathJaxSymbol() {
		return "=";
	}

	@Override
	public double getValue() {
		if(arg1.evaluable())
			return arg1.getValue();
		else if(arg2.evaluable())
			return arg2.getValue();
		else return Double.NaN;
	}
	
	@Override
	public boolean evaluable(){
		return arg1.evaluable() || arg2.evaluable();
	}

	@Override
	public Expression getDifferential() {
		return new Equation(arg1.getDifferential(),arg2.getDifferential());
	}
	
	@Override
	public Expression add(Expression e){
		return new Equation(new Plus(arg1,e),new Plus(arg2,e));
	}
	
	@Override
	public Expression subtract(Expression e){
		return new Equation(new Minus(arg1,e),new Minus(arg2,e));
	}
	
	@Override
	public Expression mult(Expression e){
		return new Equation(new Mult(arg1,e),new Mult(arg2,e));
	}
	
	@Override
	public Expression div(Expression e){
		return new Equation(new Div(arg1,e),new Div(arg2,e));
	}

	@Override
	public Expression clean() {
		return new Equation(arg1.clean(),arg2.clean());
	}
	
	/*@Override
	public boolean isEqual(Expression e){
		if(e instanceof Equation){
			Equation eq = (Equation) e;
			return arg1.isEqual(eq.arg1) || arg1.isEqual(eq.arg2)
					|| arg2.isEqual(eq.arg1) ||arg2.isEqual(eq.arg2);
		}
		return arg1.isEqual(e) || arg2.isEqual(e);
	}*/
	
}
