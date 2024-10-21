//Ethan Wight

import java.io.File;
import static java.lang.Character.isDigit;
import java.util.*;

public class RPN {

    //Method to ask the user whether the want submit the equation directly to the console or through a text file
    public static String input(String rpn)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Press 1 to input rpn expression\npress 2 to input rpn expression from file");
        int choice = sc.nextInt();sc.nextLine();
        if(choice == 1)
        {
            System.out.println("Enter rpn expression: ");
            rpn = sc.nextLine();
        }
        else if(choice == 2)
        {
            try{
                System.out.println("Enter file directory: ");
                File file = new File(sc.nextLine());
                Scanner scf = new Scanner(file);
                rpn = scf.nextLine();
                System.out.println(rpn);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        return rpn;
    }

    //Method for determining whether the string is an RPN algorithm
    public static boolean verify(String rpn)
    {
        boolean b = true;
        int count=0;
        int len=rpn.length();
        int i=0;
        while(i<len)
        {
            if(isDigit(rpn.charAt(i)))
            {
                count++;
            }
            else if(rpn.charAt(i)=='+' ||rpn.charAt(i)=='-'||rpn.charAt(i)=='*'||rpn.charAt(i)=='/'||rpn.charAt(i)=='^')
            {
                count--;
            }
            else if(rpn.charAt(i)==' '){}
            else
            {
                b = false;
                break;
            }
            i++;
        }
        if(count!=1)
            b = false;

        return b;
    }

    //Method for RPN Algorithm
    public static int evaluateExpr(String expr)
    {
        Stack<Integer> stack = new Stack<Integer>();
        int i=0;
        int src, src1, src2;
        int len = expr.length();
        while(i<len)
        {

            if(isDigit(expr.charAt(i)))
            {

                src = Integer.parseInt(expr.charAt(i)+"");
                stack.push(src);
            }
            else
            {

                src2 = stack.pop();
                src1 = stack.pop();
                char ch = expr.charAt(i);
                if(ch == '+')
                {
                    stack.push(src1 + src2);
                }
                else if(ch == '-')
                {
                    stack.push(src1 - src2);
                }
                else if(ch == '*')
                {
                    stack.push(src1 * src2);
                }
                else if(ch == '/')
                {
                    stack.push(src1/src2);
                }
                else if(ch=='^')
                {
                    stack.push((int)Math.pow(src1*1.0, src2*1.0));
                }
            }
            i++;
        }
        return stack.pop();
    }

    //main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String rpn = null;

        rpn = input(rpn);

        boolean check = verify(rpn);

        if(check)
        {
            int value = evaluateExpr(rpn);
            System.out.println("RPN value = "+value);
        }
        else
        {
            System.out.println("Invalid Expression!!");
        }
    }

}