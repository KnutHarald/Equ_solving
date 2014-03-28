package com.knutryager.math;

import java.util.ArrayList;

public class Mult extends BinaryOperator {
	
	public Mult(Expression arg1, Expression arg2){
		this.arg1 = arg1;
		this.arg2 = arg2;
	}
	
	@Override
	public double getValue() {
		return arg1.getValue() * arg2.getValue();
	}


	@Override
	public Expression getDifferential() {
		return new Plus(new Mult(arg1.getDifferential(),arg2),new Mult(arg1,arg2.getDifferential()));
	}


	@Override
	public String getOp() {
		return "*";
	}

	@Override
	public String getMathJaxSymbol() {
		if(arg1 instanceof Value){
			if(arg2 instanceof Value)
				return "*";
			else
				return "";
		}
		else if(arg2 instanceof Value)
			return "*";
		else
			return "";
	}
	

	@Override
	public Expression clean() {
		Expression new_arg1 = arg1.clean();
		Expression new_arg2 = arg2.clean();
		if(new_arg1 instanceof Value && new_arg1.getValue() == 0)
			return new Value(0);
		if(new_arg1 instanceof Value && new_arg1.getValue() == 1)
			return new_arg2;
		if(new_arg2 instanceof Value && new_arg2.getValue() == 0)
			return new Value(0);
		if(new_arg2 instanceof Value && new_arg2.getValue() == 1)
			return new_arg1;
		return new Mult(new_arg1,new_arg2);
	}
	
	@Override
	public Factors toFactors(){
		Factors ary1 = arg1.toFactors();
		Factors ary2 = arg2.toFactors();
		ArrayList<Expression> args = (ArrayList<Expression>) ary1.args.clone();
		args.addAll(ary2.args);
		return new Factors(args);
	}
	
}
