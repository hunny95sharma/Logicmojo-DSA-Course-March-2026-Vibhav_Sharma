package arrays;

import java.util.Stack;
public class BasicCalCulator2 {

	// isko single stack se karney ke liye
	//+ → push number
	//- → push -number
	//* / → stack top ke saath immediately calculate

	//End me stack sum kar do.

	public int calculateWithOneStack(String s) {

		Stack<Integer> stack = new Stack<>();

		int number = 0;
		char sign = '+';

		for (int i = 0; i < s.length(); i++) {

			char ch = s.charAt(i);

			if (Character.isDigit(ch)) {
				number = number * 10 + (ch - '0');
			}

			// operator OR last character
			if ((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1) {

				switch (sign) {

				case '+':
					stack.push(number);
					break;

				case '-':
					stack.push(-number);
					break;

				case '*':
					stack.push(stack.pop() * number);
					break;

				case '/':
					stack.push(stack.pop() / number);
					break;
				}

				sign = ch;
				number = 0;
			}
		}

		int result = 0;

		while (!stack.isEmpty()) {
			result += stack.pop();
		}

		return result;
	}


	public int calculateWithExtraMemory(String s) {
		Stack<Integer>operands=new Stack<>();
		Stack<Character>operators=new Stack<>();
		int number=0;
		for(int i=0;i<s.length();i++) {
			char ch=s.charAt(i);
			if(ch=='+'||ch=='-'||ch=='*'||ch=='/') {
				operands.push(number);
				number=0;
				while(!operators.isEmpty() && precedence(operators.peek())>=precedence(ch)) {

					char operator=operators.pop();
					int rightOperand=operands.pop();
					int leftOperand=operands.pop();	

					operands.push(performOperation(leftOperand,rightOperand,operator));
				}
				operators.push(ch);
			}else if(ch==' ')
				continue;
			else {
				number=number*10+ch-'0';
			}

		}
		operands.push(number);
		while(!operators.isEmpty()) {
			char operator=operators.pop();
			int rightOperand=operands.pop();
			int leftOperand=operands.pop();
			operands.push(performOperation(leftOperand,rightOperand,operator));
		}
		return operands.pop();
	}

	private static int performOperation(int leftOperand, int rightOperand, char operator) {
		switch (operator) {
		case '+':
			return leftOperand + rightOperand;
		case '-':
			return leftOperand - rightOperand;
		case '*':
			return leftOperand * rightOperand;
		case '/':
			return leftOperand / rightOperand;
		}
		return -1;
	}

	private int precedence(char op1) {
		if(op1=='+'||op1=='-')
			return 1;

		return 2;
	}

}