package com.knutryager.math;

import java.util.ArrayList;
import java.util.Iterator;

public class Factors extends NaryOperator{
		
	public Factors(ArrayList<Expression> args){
		super(args);
	}
	
	public Expression mult(Expression e){
		ArrayList<Expression> newArgs = (ArrayList<Expression>) args.clone();
		newArgs.add(e);
		return new Factors(newArgs);
	}

	@Override
	public String getOp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getValue() {
		double value = 0;
		for(int i = 0; i < getArgCount(); i++){
			value *= args.get(i).getValue();
		}
		return value;
	}
	
	public Expression numericSimplify(){
		ArrayList<Expression> args2 = (ArrayList<Expression>) args.clone();
		double val = 1;
		for(Iterator<Expression> i = args2.iterator(); i.hasNext(); ){
			Expression e = i.next();
			if(e instanceof Value){
				val *= e.getValue();
				args2.remove(e);
			}
		}
		args2.add(0,new Value(val));
		return new Factors(args2);
	}


	@Override
	public Expression getDifferential() {
		Expression e = getArg(0);
		ArrayList<Expression> diffs = new ArrayList<Expression>();
		for(int i = 1; i < getArgCount(); i++){
			e = new Mult(e,getArg(i)).getDifferential();
			e.clean();
		}
		return e;
	}

	@Override
	public Expression clean() {
		// TODO Auto-generated method stub
		return null;
	}
}
