package com.knutryager.math;

public class Value extends Expression{
	
	private double value;
	
	public Value(double value){
		this.value = value;
	}
	
	@Override
	public double getValue() {
		return value;
	}

	@Override
	public boolean evaluable() {
		return true;
	}

	@Override
	public String toString() {
		if(value % 1 == 0)
			return Integer.toString((int) value);
		return Double.toString(value);
	}

	@Override
	public boolean canDifferentiate() {
		return true;
	}

	@Override
	public Expression getDifferential() {
		return new Value(0);
	}

	@Override
	public String getType() {
		return "VALUE";
	}

	@Override
	public String toMathJax() {
		return toString();
	}

	@Override
	public Expression clean() {
		return this;
	}

	@Override
	public boolean isIdentic(Expression e) {
		return (e instanceof Value && ((Value) e).getValue() == getValue());
	}

	@Override
	public boolean containsVariable(String var) {
		return false;
	}

}
