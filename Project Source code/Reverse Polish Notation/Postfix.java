import java.util.Arrays;
import java.util.ArrayList;
/**
 * Write a description of class Postfix here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Postfix
{
    public int evaluate (String pfx)throws StackUnderFlow{
       Stack <Integer> stack = new StackAsList <Integer>();
       String[] c = pfx.split("");
       
       int result = 0;
       int val1 = 0;
       int val2 = 0;
       
       for(int i = 0; i < c.length; i++){
           int t = 0;
           if(isOperand(c[i])){
               stack.push(Integer.parseInt(c[i]));               
           }
           else{
               val1 = (int)stack.top();
               stack.pop();
               val2 = (int)stack.top();
               stack.pop();
               
               switch(c[i]){
                   case "*": 
                        t = val1 * val2;
                        break;
                   case "-":
                        t = val1 - val2;
                        break;
                   case "/":
                        t = val1 / val2;
                        break;
                   case "+":
                        t = val1 + val2;
                        break;                   
                }
                stack.push(t);
               
           }
       }
       result = (int)stack.top();
       return result;
   }  
   
   public boolean isOperand(String c){
       try{
           Integer.parseInt(c);
       }
       catch(Exception e){
           return false;
       }
       return true;
   }   
   
   public String infixToPostfix (String ifx){
       Stack <Character> stack = new StackAsList <Character>();
       char[] s = ifx.toCharArray();
       String r = "";
       for(int i = 0; i < s.length; i++){
           if(Character.isDigit(s[i])){
               r+= Character.toString(s[i]);
           }
           else if(s[i] == '('){
               stack.push(s[i]);
           }
           else if(s[i] == ')'){
               while(stack.top() != '('){
                   r += " " + stack.top() + " ";
                   stack.pop();
               }
               stack.pop();
           }
           else{
               while(!stack.isEmpty)
           }
       }
       return r;
   }
   
}
