package nodes;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class scanfNode extends treeNode {

	@Override
	public Object execute() {
		//System.out.println("Printf Node Has Been Visited");
		String value = children.get(0).execute().toString();
		value = value.substring(1, value.length() - 1);
		int currentVariable = 1;
		Object currentVariableValue;
		
		for (int i = 0; i < value.length(); i++) {
			if (value.charAt(i) == '%' && i != value.length() - 1) {
				if (value.charAt(i + 1) == '%') {
					continue;
				}
				else {
					if (value.charAt(i + 1) == 'd') {
						currentVariableValue = null;
						if (!typeCheck.representsCharacter(currentVariableValue.toString()) &&
							!typeCheck.isNumeric(currentVariableValue) &&
							!variablesStorage.variables.containsKey(currentVariableValue)) {
							System.out.println("Non numeric input detected");
							return null;
						}
						
						if (typeCheck.isNumeric(currentVariableValue)) {
							Scanner sc = new Scanner(System.in);
							Double temp = sc.nextDouble();
							currentVariableValue = temp.intValue();
						}
						
						else if (typeCheck.representsCharacter(currentVariableValue.toString())) {
							Scanner sc = new Scanner(System.in);
							String temp = sc.next();
							currentVariableValue = temp.charAt(1);
							currentVariableValue = new Character(currentVariableValue.toString().charAt(0));
							currentVariableValue = (int)currentVariableValue.toString().charAt(0);
						}
						currentVariable++;
						
					}
					else if (value.charAt(i + 1) == 'x') {
						currentVariableValue = children.get(currentVariable).execute().toString();
						if (!typeCheck.representsCharacter(currentVariableValue.toString()) &&
							!typeCheck.isNumeric(currentVariableValue) &&
							!variablesStorage.variables.containsKey(currentVariableValue)) {
							System.out.println("Non numeric input detected");
							return null; 
						}
						
						if (variablesStorage.variables.containsKey(currentVariableValue)) {
							currentVariableValue = variablesStorage.variables.get(currentVariableValue.toString()).getValue();
							Double temp = Double.parseDouble(currentVariableValue.toString());
							currentVariableValue = Integer.toHexString(temp.intValue());
						}
						
						else if (typeCheck.isNumeric(currentVariableValue)) {
							Double temp = Double.parseDouble(children.get(currentVariable).execute().toString());
							currentVariableValue = Integer.toHexString(temp.intValue());
						}
						
						else if (typeCheck.representsCharacter(currentVariableValue.toString())) {
							currentVariableValue = currentVariableValue.toString().charAt(1);
							currentVariableValue = new Character(currentVariableValue.toString().charAt(0));
							currentVariableValue = (int)currentVariableValue.toString().charAt(0);
							Integer temp = Integer.parseInt(currentVariableValue.toString());
							currentVariableValue = Integer.toHexString(temp.intValue());
						}
						value = value.replaceFirst("%x", currentVariableValue.toString());
						currentVariable++;
						
					}
					else if (value.charAt(i + 1) == 'X') {
						currentVariableValue = children.get(currentVariable).execute().toString();
						if (!typeCheck.representsCharacter(currentVariableValue.toString()) &&
							!typeCheck.isNumeric(currentVariableValue) &&
							!variablesStorage.variables.containsKey(currentVariableValue)) {
							System.out.println("Non numeric input detected");
							return null; 
						}
						
						if (variablesStorage.variables.containsKey(currentVariableValue)) {
							currentVariableValue = variablesStorage.variables.get(currentVariableValue.toString()).getValue();
							Double temp = Double.parseDouble(currentVariableValue.toString());
							currentVariableValue = Integer.toHexString(temp.intValue());
						}
						
						else if (typeCheck.isNumeric(currentVariableValue)) {
							Double temp = Double.parseDouble(children.get(currentVariable).execute().toString());
							currentVariableValue = Integer.toHexString(temp.intValue());
						}
						
						else if (typeCheck.representsCharacter(currentVariableValue.toString())) {
							currentVariableValue = currentVariableValue.toString().charAt(1);
							currentVariableValue = new Character(currentVariableValue.toString().charAt(0));
							currentVariableValue = (int)currentVariableValue.toString().charAt(0);
							Integer temp = Integer.parseInt(currentVariableValue.toString());
							currentVariableValue = Integer.toHexString(temp.intValue());
						}
						currentVariableValue = currentVariableValue.toString().toUpperCase();
						value = value.replaceFirst("%X", currentVariableValue.toString());
						currentVariable++;
						
					}
					else if (value.charAt(i + 1) == 'o') {
						currentVariableValue = children.get(currentVariable).execute().toString();
						if (!typeCheck.representsCharacter(currentVariableValue.toString()) &&
							!typeCheck.isNumeric(currentVariableValue) &&
							!variablesStorage.variables.containsKey(currentVariableValue)) {
							System.out.println("Non numeric input detected");
							return null; 
						}
						
						if (variablesStorage.variables.containsKey(currentVariableValue)) {
							currentVariableValue = variablesStorage.variables.get(currentVariableValue.toString()).getValue();
							Double temp = Double.parseDouble(currentVariableValue.toString());
							currentVariableValue = Integer.toOctalString(temp.intValue());
						}
						
						else if (typeCheck.isNumeric(currentVariableValue)) {
							Double temp = Double.parseDouble(children.get(currentVariable).execute().toString());
							currentVariableValue = Integer.toOctalString(temp.intValue());
						}
						
						else if (typeCheck.representsCharacter(currentVariableValue.toString())) {
							currentVariableValue = currentVariableValue.toString().charAt(1);
							currentVariableValue = new Character(currentVariableValue.toString().charAt(0));
							currentVariableValue = (int)currentVariableValue.toString().charAt(0);
							Integer temp = Integer.parseInt(currentVariableValue.toString());
							currentVariableValue = Integer.toOctalString(temp.intValue());
						}
						currentVariableValue = currentVariableValue.toString().toUpperCase();
						value = value.replaceFirst("%o", currentVariableValue.toString());
						currentVariable++;
						
					}
					// the 'b' format specifier , not a standard feature in C language ...
					else if (value.charAt(i + 1) == 'b') {
						currentVariableValue = children.get(currentVariable).execute().toString();
						if (!typeCheck.representsCharacter(currentVariableValue.toString()) &&
							!typeCheck.isNumeric(currentVariableValue) &&
							!variablesStorage.variables.containsKey(currentVariableValue)) {
							System.out.println("Non numeric input detected");
							return null; 
						}
						
						if (variablesStorage.variables.containsKey(currentVariableValue)) {
							currentVariableValue = variablesStorage.variables.get(currentVariableValue.toString()).getValue();
							Double temp = Double.parseDouble(currentVariableValue.toString());
							currentVariableValue = Integer.toBinaryString(temp.intValue());
						}
						
						else if (typeCheck.isNumeric(currentVariableValue)) {
							Double temp = Double.parseDouble(children.get(currentVariable).execute().toString());
							currentVariableValue = Integer.toBinaryString(temp.intValue());
						}
						else if (typeCheck.representsCharacter(currentVariableValue.toString())) {
							currentVariableValue = currentVariableValue.toString().charAt(1);
							currentVariableValue = new Character(currentVariableValue.toString().charAt(0));
							currentVariableValue = (int)currentVariableValue.toString().charAt(0);
							Integer temp = Integer.parseInt(currentVariableValue.toString());
							currentVariableValue = Integer.toBinaryString(temp.intValue());
						}
						currentVariableValue = currentVariableValue.toString().toUpperCase();
						value = value.replaceFirst("%b", currentVariableValue.toString());
						currentVariable++;
						
					}
					else if (value.charAt(i + 1) == 'c') {
						currentVariableValue = children.get(currentVariable).execute().toString();
						if (!typeCheck.representsCharacter(currentVariableValue.toString()) &&
							!typeCheck.isNumeric(currentVariableValue) &&
							!variablesStorage.variables.containsKey(currentVariableValue)) {
							System.out.println("Non character input detected");
							return null;
						}
						
						if (variablesStorage.variables.containsKey(currentVariableValue)) {
							currentVariableValue = variablesStorage.variables.get(currentVariableValue).getValue();
							Character temp = new Character(currentVariableValue.toString().charAt(0));
							currentVariableValue = temp;
						}
						
						else if (typeCheck.isNumeric(currentVariableValue)) {
							Double temp = Double.parseDouble(currentVariableValue.toString());
							currentVariableValue = (char)temp.intValue();
						}
						
						else if (typeCheck.representsCharacter(currentVariableValue.toString())) {
							currentVariableValue = children.get(currentVariable).execute().toString().substring(0,2).charAt(1);
						}
						
						value = value.replaceFirst("%c", currentVariableValue.toString());
						currentVariable++;
						
					}
					else if (value.charAt(i + 1) == 'f') {
						DecimalFormat df = new DecimalFormat();
						currentVariableValue = children.get(currentVariable).execute().toString();
						if (!typeCheck.representsCharacter(currentVariableValue.toString()) &&
							!typeCheck.isNumeric(currentVariableValue) &&
							!variablesStorage.variables.containsKey(currentVariableValue)) {
								System.out.println("Non numeric input detected");
								return null;
						}
						
						else if (variablesStorage.variables.containsKey(currentVariableValue)) {
							variable info = variablesStorage.variables.get(currentVariableValue.toString());
							if (info.getType().equals("int")) {
								df.applyPattern("#.######");
								currentVariableValue = Integer.parseInt(info.getValue().toString());
							}
							else if (info.getType().equals("float")) {
								df = new DecimalFormat("#.######");
								currentVariableValue = Float.parseFloat(info.getValue().toString());
							}
							else if (info.getType().equals("double")) {
								df.applyPattern("#.###############");
								currentVariableValue = Double.parseDouble(info.getValue().toString());
							}
						}
						
						else if (typeCheck.isNumeric(currentVariableValue)) {
							Double temp = Double.parseDouble(children.get(currentVariable).execute().toString());
							currentVariableValue = temp;
						}
						
						df.setRoundingMode(RoundingMode.CEILING);
						//currentVariableValue = df.format(Double.parseDouble(currentVariableValue.toString()));
						//System.out.println(currentVariableValue);
						value = value.replaceFirst("%f", currentVariableValue.toString());
						currentVariable++;
					}
					else if (value.charAt(i + 1) == 's') {
						currentVariableValue = children.get(currentVariable).execute().toString();
						if (!typeCheck.representsString(currentVariableValue.toString()) &&
							!variablesStorage.variables.containsKey(currentVariableValue)) {
							System.out.println("Non string input detected");
							return null;
						}
						
						if (variablesStorage.variables.containsKey(currentVariableValue)) {
							currentVariableValue = variablesStorage.variables.get(currentVariableValue).getValue();
						}
						
						else if (typeCheck.representsString(currentVariableValue.toString())) {
							currentVariableValue = children.get(currentVariable).execute().toString().substring(0,2).charAt(1);
						}
						String temp = currentVariableValue.toString();
						temp = temp.toString().substring(0, temp.length() - 1);
						value = value.replaceFirst("%s", temp);
						currentVariable++;
						
					} 
				}
			} 
		}
		return null;
	}

}
