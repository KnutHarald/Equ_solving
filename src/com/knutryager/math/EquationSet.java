package com.knutryager.math;

import java.util.ArrayList;

public class EquationSet {
	ArrayList<Equation> equations;
	ArrayList<String> variables;
	ArrayList<ArrayList<String>> equationVariables;

	/*public EquationSet(ArrayList<Equation> equations) {
		this.equations = equations;
		variables = new ArrayList<String>();
		equationVariables = new ArrayList<ArrayList<String>>(equations.size());
		ArrayList<String> tempVars;
		ArrayList<String> dupsMovedVars;
		for(int i = 0; i < equations.size(); i++){
			tempVars = equations.get(i).getVariables();
			//need to remove duplicates
			dupsMovedVars = new ArrayList<String>();
			for(int i3 = 0; i3 < tempVars.size(); i3++){
				if(!dupsMovedVars.contains(tempVars.get(i3)))
					dupsMovedVars.add(tempVars.get(i3));
			}
			for(int i2 = 0; i2 < dupsMovedVars.size(); i2++){
				if(!variables.contains(dupsMovedVars.get(i2)))
				   variables.add(dupsMovedVars.get(i2));
			}
			equationVariables.set(i,dupsMovedVars);
		}
	}
	
	public void addEquation(Equation e){
		//should check if it's already there, and what new vars.
		for(int i = 0; i < equations.size(); i++){
			if(e.isIdentic(equations.get(i)))
				return;
		}
		ArrayList<String> vars = e.getVariables();
		for(int i = 0; i < vars.size(); i++){
			if(variables.indexOf(vars.get(i)) == -1)
				variables.add(vars.get(i));
		}
		equationVariables.add(vars);
	}
	
	public Expression solve(String v,ArrayList<String > from){
		if(!containsVariable(v))
			return null;
		for(int i = 0; i < from.size(); i++){
			if(!containsVariable(from.get(i)))
				return null;
		}
		//have all vars. now start looking for relevant equations
		
		return null;
		
	}
	
	public boolean containsVariable(String variable){
		return variables.indexOf(variable) != -1;
	}
	
	
	public String toString(){
		String str = "";
		for(int i = 0; i < equations.size(); i++){
			str += equations.get(i).toString() + "\n";
		}
		return str;
	}
	
	public ArrayList<String> getVariables(){
		return variables;
	}*/
	
}
