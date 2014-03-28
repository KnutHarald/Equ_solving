package com.knutryager.math;

public abstract class Operator extends Expression {
	public abstract String getOp();
	public abstract int getArgCount();
	public abstract Expression getArg(int index);
	
	@Override
	public boolean canDifferentiate() {
		boolean can = true;
		for(int i = 0; i < getArgCount(); i++){
			can = can && getArg(i).canDifferentiate();
		}
		return can;
	}
	
	@Override
	public boolean evaluable() {
		boolean can = true;
		for(int i = 0; i < getArgCount(); i++){
			can = can && getArg(i).evaluable();
		}
		return can;
	}
	
	public boolean containsVariable(String var){
		for(int i = 0; i < getArgCount(); i++){
			if(getArg(i).containsVariable(var))
				return true;
		}
		return false;
	}
	
	@Override
	public boolean isIdentic(Expression e){
		if(getType() != e.getType() || !(e instanceof Operator) || ((Operator) e).getArgCount() != getArgCount())
			return false;
		Operator e2 = (Operator) e;
		boolean is = true;
		for(int i = 0; i < getArgCount(); i++){
			is = is && getArg(i).isIdentic(e2.getArg(i));
		}
		return is;
	}
	
	public String getType(){
		return getOperatorDegree() + ":" + getOp();
	}
	
	public abstract String getOperatorDegree();
	
	public abstract String getMathJaxSymbol();
	
}
