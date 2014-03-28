package com.knutryager.math;

import java.util.ArrayList;

public class Constant extends Expression{

	private String name;
	private double value;
	
	public Constant(String name){
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
		return new Value(0);
	}

	@Override
	public String getType() {
		return "CONSTANT";
	}

	@Override
	public String toMathJax() {
		return name;
	}

	@Override
	public Expression clean() {
		return this;
	}

	@Override
	public boolean isIdentic(Expression e) {
		return (e instanceof Constant && ((Constant) e).name == name);
	}

	@Override
	public boolean containsVariable(String var) {
		return false;
	}

}
