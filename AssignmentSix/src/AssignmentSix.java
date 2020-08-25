//Kearne Permalino 9639
//Githel Suico 7852
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 * 
 * @author Kearne Permalino
 * @author Githel Suico
 */
public class AssignmentSix {
	
	public static void main(String[] args) {
		calc = new Stack();
		try
        {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String line = reader.readLine();
            while (line != null)
            {	 
            	System.out.println("Expression: " + line);
            	StringTokenizer str = new StringTokenizer(line);
            	inputStack(str);
            	System.out.println("Value: " + calc.getTop());
            	System.out.println();
            	line = reader.readLine();
            }     
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
		else if (op.equals("*")) {
			mulNums();
		}
		else if (op.equals("/")) {
			divNums();
		}
		else if (op.equals("sin") || op.equals("cos") || op.equals("tan")) {
			trigNums(op);
		} 

	}
	
	private static void addNums() {
		num2 = calc.getTop();
		calc.pop();
		n2Con = Double.valueOf(num2);
		
		num1 = calc.getTop();
		calc.pop();
		n1Con = Double.valueOf(num1);
		
		answer = n1Con + n2Con;
		ansToString = String.valueOf(answer);
		calc.push(ansToString);
	}
	
	private static void subNums() {
		num2 = calc.getTop();
		calc.pop();
		n2Con = Double.valueOf(num2);
		
		num1 = calc.getTop();
		calc.pop();
		n1Con = Double.valueOf(num1);
		
		answer = n1Con - n2Con;
		ansToString = String.valueOf(answer);
		calc.push(ansToString);
	}
	
	private static void mulNums() {
		num2 = calc.getTop();
		calc.pop();
		n2Con = Double.valueOf(num2);
		
		num1 = calc.getTop();
		calc.pop();
		n1Con = Double.valueOf(num1);
		
		answer = n1Con * n2Con;
		ansToString = String.valueOf(answer);
		calc.push(ansToString);
	}
	
	private static void divNums() {
		num2 = calc.getTop();
		calc.pop();
		n2Con = Double.valueOf(num2);
		
		num1 = calc.getTop();
		calc.pop();
		n1Con = Double.valueOf(num1);
		answer = n1Con / n2Con;
		ansToString = String.valueOf(answer);
		calc.push(ansToString);
	}
	
	private static void trigNums(String op) {
		String trig = op;
		String degrees;
		if (trig.equals("sin")) {
			degrees = calc.getTop();
			calc.pop();
			Double radians = (((Double.valueOf(degrees))*Math.PI)/180);
			answer = Math.sin(radians);
			ansToString = String.valueOf(answer);
			calc.push(ansToString);
		}
		if (trig.equals("cos")) {
			degrees = calc.getTop();
			calc.pop();
			Double radians = (((Double.valueOf(degrees))*Math.PI)/180);
			answer = Math.cos(radians);
			ansToString = String.valueOf(answer);
			calc.push(ansToString);
		}
		if (trig.equals("tan")) {
			degrees = calc.getTop();
			calc.pop();
			Double radians = (((Double.valueOf(degrees))*Math.PI)/180);
			answer = Math.tan(radians);
			ansToString = String.valueOf(answer);
			calc.push(ansToString);
		}
	}
	
	private static void inputStack(StringTokenizer str) {
		while(str.hasMoreTokens()) {
			String val = str.nextToken();
			if(val.equals("+") || val.equals("-") || val.equals("/") || val.equals("*")
				|| val.equals("sin") || val.equals("cos") || val.equals("tan")){
				evaluate(val);
			}
			else {
				calc.push(val);
			}
		}
	}
	
	private static String num1, num2, ansToString;
	private static double n1Con, n2Con, answer;
	private static Stack calc;
}
