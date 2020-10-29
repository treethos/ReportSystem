package DataStructureAndAlgorithm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Test {

    private static final String ADD = "+"; 
    private static final String SUB = "-";
    private static final String MUL = "*";
    private static final String DIV = "/";

    public void calculateFile(String fileName) throws IOException {
        BufferedReader br = null;
        StringBuilder sb = null;
        try {
            FileReader fileReader = new FileReader(fileName);
            br = new BufferedReader(fileReader);

            sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }

            String input = sb.toString();
            System.out.println(input + " = " + calculate(input));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            br.close();
        }
    }

    private int calculate(String input) {
        SinglyLinkedListStack<Integer> stack = new SinglyLinkedListStack<>();

        String[] inputs = input.split(" ");

        return handleCalculation(stack, inputs);
    }

    private static int handleCalculation(SinglyLinkedListStack<Integer> stack, String[] el) 
    {
        int operand1, operand2;

        for(int i = 0; i < el.length; i++) 
        {
            if( el[i].equals(ADD) || el[i].equals(SUB) || el[i].equals(MUL) || el[i].equals(DIV) ) 
            {
                operand2 = stack.pop();
                operand1 = stack.pop();
                switch(el[i]) {
                    case ADD: {
                        int local = operand1 + operand2;
                        stack.push(local);
                        break;
                    }

                    case SUB: {
                        int local = operand1 - operand2;
                        stack.push(local);
                        break;
                    }

                    case MUL: {
                        int local = operand1 * operand2;
                        stack.push(local);
                        break;
                    }

                    case DIV: {
                        int local = operand1 / operand2;
                        stack.push(local);
                        break;
                    }
                }
            } else {
                stack.push(Integer.parseInt(el[i]));
            }
        }

        return stack.pop();
    }

}