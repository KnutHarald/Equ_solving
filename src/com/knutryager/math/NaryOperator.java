package com.knutryager.math;
import java.util.ArrayList;



public abstract class NaryOperator extends Operator{
	ArrayList<Expression> args;

	public NaryOperator(ArrayList<Expression> args){
		this.args = args;
	}
	
	@Override
	public int getArgCount() {
		return args.size();
	}

	@Override
	public Expression getArg(int index) {
		return args.get(index);
	}

	@Override
	public String getOperatorDegree() {
		return "NARY";
	}
	
	@Override
	public String getMathJaxSymbol() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toMathJax() {
		// TODO Auto-generated method stub
		return null;
	}
}
