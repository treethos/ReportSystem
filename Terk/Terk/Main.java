package Terk;

import java.util.*;
import java.util.Queue;

import javax.rmi.ssl.SslRMIClientSocketFactory;



public class Main
{
    static Scanner sc = new Scanner(System.in);
    static int preD(String c)
    {
        switch (c)
        {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
        }
                return -1;
    }
        public static void main(String[] args) throws Exception
        {
            Stack<Double> Opt2= new Stack<Double>();
            Stack<String> Opt = new Stack<String>();
            Queue<String> Opr = new LinkedList<>();
           
            String result2 = "";
            System.out.print("Input: ");
            //String input = sc.nextLine();
            String input = "5 + 5 * 10 - 2";
            System.out.println("Input = "+input);
            String[] starr = input.split(" ");
            

            for (int i = 0; i <starr.length ; i++) 
            {
                  //เพื่อเอาไว้เช็ค ลำดับความสำคัญ
                if(preD(starr[i])>0){
                    
                    while(Opt.isEmpty()==false && preD(Opt.peek())>=preD(starr[i]))
                    {
                        while(Opr.isEmpty() == false)
                        {
                        result2 += Opr.remove()+" ";
                        }
                        
                        result2 += Opt.pop()+" ";
                    }
                                 
                    Opt.push(starr[i]);
                    }
                else if(starr[i].equals(")"))
                {
                    String x = Opt.pop();
                   
                    while(!x.equals("(")) 
                    {
                        while(Opr.isEmpty() == false)
                        {
                        result2 += Opr.remove()+" ";
                        }
                        result2 += x+" ";
                    
                        x = Opt.pop();
                    }
                }
                else if(starr[i].equals("("))
                {
                    Opt.push(starr[i]);
                }
                
                else
                {
                    Opr.add(starr[i]);
                   
                }
            }
            for (int i = 0; i <=Opt.size() ; i++) {
                while(Opr.isEmpty() == false)
                        {
                        result2 += Opr.remove()+" ";
                        }
                        
                        result2 += Opt.pop()+" ";
            }
        ////////////////////////////////////////////////////
        System.out.print(result2);
        
        String[] starr2 = result2.split(" ");

            for(int i = 0; i < starr2.length ; i++)
            {
                
                double x = 0;
                 
                 if(starr2[i].equals("+"))
                 {
                    x = Opt2.pop();
                    x = Opt2.pop()+x;                 
                    Opt2.push(x);
                }
                else if(starr2[i].equals("-")){
                    x = Opt2.pop();
                    x = Opt2.pop()-x;            
                    Opt2.push(x);                   
                }
                else if(starr2[i].equals("*")){
                    x = Opt2.pop();
                    x = Opt2.pop()*x;                  
                    Opt2.push(x);                   
                }
                else if(starr2[i].equals("/")){
                    x = Opt2.pop();
                    x = Opt2.pop()/x;                  
                    Opt2.push(x);                  
                } 
                else
                {
                   double a = Double.parseDouble(starr2[i]);
                    Opt2.push(a);
                    
                }
        }
        System.out.println(" ");
            System.out.print("result = "+Opt2.pop());
             
             
        
       
        }   
            
    }
        
        
