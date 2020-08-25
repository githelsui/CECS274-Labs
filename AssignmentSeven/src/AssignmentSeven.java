//Kearne Permalino 9639
//Githel Suico 7852
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
/**
 * 
 * @author Kearne Permalino
 * @author Githel Suico
 */
public class AssignmentSeven {
	public static void main(String[] args) {
		
		operators = new Stack();
		operands = new Queue();
		calculate = new Stack();
		
		try
        {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String line = reader.readLine();
            while (line != null)
            {	 
            	System.out.println("Expression is: " + line);
            	StringTokenizer str = new StringTokenizer(line);
            	convertPostFix(str);
            	operands.dump("Postfix is ");
            	findOperators();
            	System.out.println("Value is " + calculate.getTop());
            	System.out.println();
            	line = reader.readLine();
            }     
            reader.close();
        }
        catch (IOException error)
        {
            System.out.println (error.getMessage());
        }         
		
	}
	
	private static void evaluate(String op) {
		if (op.equals("+")) {
			addNums();
		}
		else if (op.equals("-")) {
			subNums();
		}
	}
	
	private static void addNums() {
		num2 = calculate.getTop();
		calculate.pop();
		n2Con = Double.valueOf(num2);
		
		num1 = calculate.getTop();
		calculate.pop();
		n1Con = Double.valueOf(num1);
		
		answer = n1Con + n2Con;
		ansToString = String.valueOf(answer);
		calculate.push(ansToString);
	}
	
	private static void subNums() {
		num2 = calculate.getTop();
		calculate.pop();
		n2Con = Double.valueOf(num2);
		
		num1 = calculate.getTop();
		calculate.pop();
		n1Con = Double.valueOf(num1);
		
		answer = n1Con - n2Con;
		ansToString = String.valueOf(answer);
		calculate.push(ansToString);
	}
	
	private static void convertPostFix(StringTokenizer str) {
		while(str.hasMoreTokens()) {
			String val = str.nextToken();
			if(val.equals("(") || val.equals("+") || val.equals("-") || val.equals("/") || val.equals("*")){
				operators.push(val);
			}
			else if(val.equals(")")){
				while(!operators.getTop().equals("(")) {
					operands.add(operators.getTop());
					operators.pop();
				}
				operators.pop();
			}
			else {
				operands.add(val);;
			}
		}
	}
	
	private static void findOperators() {
		while(!operands.isEmpty()) {
			String val = operands.remove();
			if(val.equals("+") || val.equals("-") || val.equals("/") || val.equals("*")){
				evaluate(val);
			}
			else {
				calculate.push(val);
			}
		}
	}
	
	private static String num1, num2, ansToString;
	private static double n1Con, n2Con, answer;
	private static Stack operators;
	private static Queue operands;
	private static Stack calculate;
}
