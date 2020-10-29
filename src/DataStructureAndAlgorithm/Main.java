package DataStructureAndAlgorithm;

import java.util.*;
import java.util.Queue;

public class Main
{
    static Scanner sc = new Scanner(System.in);
    static int precedence(char c)
    {
        switch (c)
        {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return -1;
    }
    public static void main(String[] args)
    {//( ( 10 + 2 ) * 2 )
        Stack<String> Forcal = new Stack<String>();
        Stack<String> TempStack = new Stack <String>();
        Stack<Character> Operator = new Stack<Character>();
        Queue<String> Operands = new LinkedList<>();
        String result = "";
        
        System.out.print("Input: ");
        //String input = sc.nextLine();
        String input = "( ( 2 + 3 ) - 10 ) * 2 ";
        System.out.println("Input = "+input);
        String[] StringArray = input.split(" ");
        for(int i=0;i<StringArray.length;i++)
        {

            if(StringArray[i].equals("+")||StringArray[i].equals("-")||StringArray[i].equals("*")||StringArray[i].equals("/")||StringArray[i].equals("(")||StringArray[i].equals(")"))
            {
                switch (StringArray[i])
                {
                    case "+":
                        while(Operator.isEmpty()==false && precedence(Operator.peek())>=1){
                            result += Operator.pop();
                        }
                        Operator.push('+');
                              break;

                    case "-":
                        while(Operator.isEmpty()==false && precedence(Operator.peek())>=1){
                            result += Operator.pop();
                        }

                        Operator.push('-');
                              break;
                    
                    case "*":
                        while(Operator.isEmpty()==false && precedence(Operator.peek())>=2){
                            result += Operator.pop();
                        }
                        Operator.push('*');
                              break;
                    case "/":
                        while(Operator.isEmpty()==false && precedence(Operator.peek())>=2){
                            result += Operator.pop();
                        }
                        Operator.push('/');
                             break;

                    case "(":Operator.push('(');          break;

                    case ")":
                    char x = Operator.pop();
                    while(x!='(')
                    {
                        result += x;
                        while(Operands.isEmpty() == false)
                        {System.out.print(Forcal.push(Operands.remove()));}
                        System.out.print(Forcal.push(String.valueOf(x)));
                        x = Operator.pop();
                    }
                    break;
                }
            }
            else 
            {
                result += StringArray[i];
                Operands.add(StringArray[i]);
            }
        }
        for (int j = 0; j <=Operator.size() ; j++) {
            while(Operands.isEmpty() == false)
            {System.out.print(Forcal.push(Operands.remove()));}
            System.out.println(Forcal.push(String.valueOf(Operator.pop())));
        }
        //re arrange stack
        System.out.println(Forcal);
        while (!Forcal.isEmpty())
        {
            TempStack.push(Forcal.pop());
        }

        System.out.println(TempStack);

        //calculating part
        while(!TempStack.isEmpty())
        {

            double sum;
            double first = Double.parseDouble(TempStack.pop());
            double second = Double.parseDouble(TempStack.pop());
            char op = TempStack.peek().charAt(0);
                switch(op)
                {
                    case'+':
                    sum = first+second; TempStack.push(String.valueOf(sum)); break;
                    case'-':
                    sum = first-second; TempStack.push(String.valueOf(sum)); break;
                    case'*': 
                    sum = first*second; TempStack.push(String.valueOf(sum)); break;
                    case'/': 
                    sum = first/second; TempStack.push(String.valueOf(sum)); break;
                }
            
        }
        System.out.println(TempStack);
    }
}