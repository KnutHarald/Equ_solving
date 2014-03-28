package com.knutryager.math;

import java.util.ArrayList;

public class Plus extends BinaryOperator{

	public Plus(Expression arg1, Expression arg2){
		this.arg1 = arg1;
		this.arg2 = arg2;
	}
	
	@Override
	public double getValue() {
		return arg1.getValue() + arg2.getValue();
	}


	@Override
	public Expression getDifferential() {
		return new Plus(arg1.getDifferential(),arg2.getDifferential());
	}


	@Override
	public String getOp() {
		return "+";
	}

	@Override
	public String getMathJaxSymbol() {
		return "+";
	}
	

	@Override
	public Expression clean() {
		Expression new_arg1 = arg1.clean();
		Expression new_arg2 = arg2.clean();
		if(new_arg1 instanceof Value && new_arg1.getValue() == 0)
			return new_arg2;
		if(new_arg2 instanceof Value && new_arg2.getValue() == 0)
			return new_arg1;
		return new Minus(new_arg1,new_arg2);
	}
	
	@Override
	public Terms toTerms(){
		Terms ary1 = arg1.toTerms();
		Terms ary2 = arg2.toTerms();
		ArrayList<Expression> args = (ArrayList<Expression>) ary1.args.clone();
		args.addAll(ary2.args);
		ArrayList<Boolean> addyModes = (ArrayList<Boolean>) ary1.modes.clone();
		addyModes.addAll(ary2.modes);
		return new Terms(args,addyModes);
	}
	
	@Override
	public int termCount(){
		return arg1.termCount() + arg2.termCount();
	}

}
