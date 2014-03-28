package com.knutryager.math;

import java.util.ArrayList;
import java.util.Iterator;

public class Terms extends NaryOperator{
	ArrayList<Boolean> modes;
	
	public Terms(ArrayList<Expression> args,ArrayList<Boolean> modes){
		super(args);
		this.modes = modes;
	}
	
	public Expression add(Expression e){
		ArrayList<Expression> newArgs = (ArrayList<Expression>) args.clone();
		ArrayList<Boolean> newModes = (ArrayList<Boolean>) modes.clone();
		newArgs.add(e);
		newModes.add(true);
		return new Terms(newArgs,newModes);
	}
	
	public Expression subtract(Expression e){
		ArrayList<Expression> newArgs = (ArrayList<Expression>) args.clone();
		ArrayList<Boolean> newModes = (ArrayList<Boolean>) modes.clone();
		newArgs.add(e);
		newModes.add(false);
		return new Terms(newArgs,newModes);
	}

	@Override
	public boolean isIdentic(Expression e){
		if(e instanceof Terms  && ((Terms) e).getOp() == getOp()){
			Terms e2 = (Terms) e;
			if(getArgCount() != e2.getArgCount())
				return false;
			boolean b = true;
			for(int i = 0; i < getArgCount(); i++){
				b = b && getArg(i).isIdentic(e2.getArg(i));
				b = b && (modes.get(i) == e2.modes.get(i));
			}
			return b;
		}
		return false;
	}

	@Override
	public String getOp() {
		return "+";
	}

	@Override
	public double getValue() {
		double value = 0;
		for(int i = 0; i < getArgCount(); i++){
			if(modes.get(i))
				value += args.get(i).getValue();
			else
				value -= args.get(i).getValue();
		}
		return value;
	}
	
	public Expression numericSimplify(){
		ArrayList<Expression> args2 = (ArrayList<Expression>) args.clone();
		ArrayList<Boolean> modes2 = (ArrayList<Boolean>) modes.clone();
		double val = 0;
		Iterator<Boolean> m = modes.iterator();
		for(Iterator<Expression> i = args2.iterator(); i.hasNext(); ){
			Expression e = i.next();
			Boolean b = m.next();
			if(e instanceof Value){
				if(b)
					val += e.getValue();
				else
					val -= e.getValue();
				args2.remove(e);
				modes2.remove(b);
			}
		}
		args2.add(0,new Value(val));
		return new Terms(args2,modes2);
	}
	

	@Override
	public int termCount(){
		int terms = 0;
		for(int i = 0; i < getArgCount(); i++){
			terms += args.get(i).termCount();
		}
		return terms;
	}

	@Override
	public String getOperatorDegree() {
		return "NARY";
	}

	@Override
	public Expression getDifferential() {
		ArrayList<Expression> newArgs = new ArrayList<Expression>();
		for(int i = 0; i < getArgCount(); i++){
			newArgs.add(args.get(i).getDifferential());
		}
		return new Terms(newArgs,(ArrayList<Boolean>) modes.clone());
	}

	@Override
	public Expression clean() {
		// TODO Auto-generated method stub
		return null;
	}

}
