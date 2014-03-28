package com.knutryager.math;

public class Variable extends Expression{
	
	private String name;
	private double value;

	public Variable(String name){
		this.name = name;
		value = Double.NaN;
	}
	
	public void setValue(double value){
		this.value = value;
	}
	
	public boolean valueSet(){
		return !Double.isNaN(value);
	}
	
	
	@Override
	public double getValue() {
		return value;
	}

	@Override
	public boolean evaluable() {
		return valueSet();
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public boolean canDifferentiate() {
		return true;
	}

	@Override
	public Expression getDifferential() {
		return new Value(1);
	}

	@Override
	public String getType() {
		return "VARIABLE";
	}

	@Override
	public String toMathJax() {
		int i = name.indexOf("_");
		if(i >= 0)
			return name.substring(0, i+1) + "{" + name.substring(i+1, name.length()) + "}";
		return name;
	}

	@Override
	public Expression clean() {
		return this;
	}

	@Override
	public boolean isIdentic(Expression e) {
		return (e instanceof Variable && ((Variable) e).name == name);
	}

	@Override
	public boolean containsVariable(String var) {
		return var == name;
	}

}
