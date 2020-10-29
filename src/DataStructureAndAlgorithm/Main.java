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
        Stack<String> ReversePostfix = new Stack<String>();
        Stack<Double> ResultStack = new Stack <Double>();
        Stack<Character> Operator = new Stack<Character>();
        Queue<String> Operands = new LinkedList<>();
        Queue<String> Postfix = new LinkedList<>();
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

        //System.out.println("Forcal = (stack)"+Forcal);
        //re arrange stack
        while(!Forcal.isEmpty()){
            ReversePostfix.push(Forcal.pop());
        }
        System.out.println("ReversePostFix = (before)(Stack)"+ReversePostfix);
        while(!ReversePostfix.isEmpty()){
            Postfix.add(ReversePostfix.pop());
        }
        System.out.println("Postfix = (after)(queue)"+Postfix);
        System.out.println("ResultStack = "+ResultStack);
        //calculating part






            
        }
}