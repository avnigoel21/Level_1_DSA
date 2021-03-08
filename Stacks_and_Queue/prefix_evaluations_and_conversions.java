import java.io.*;
import java.util.*;

public class prefix_evaluations_and_conversions{
  

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
        
        // code
        eval_infix_postfix(exp);
    }
    
    public static void eval_infix_postfix(String prefix){
        Stack<Integer>eval = new Stack<>();
        Stack<String>in = new Stack<>();
        Stack<String>post = new Stack<>();
        
        for(int i = prefix.length()-1 ; i >= 0 ; i--){
            char ch = prefix.charAt(i);
            
            if(ch >= '0' && ch <= '9'){
                eval.push(ch - '0');
                in.push(ch + "");
                post.push(ch + "");
                
            }
            else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
              // eval stack value
              char opr = ch;
              int v1 = eval.pop();
              int v2 = eval.pop();
              
              int ans = operation(opr , v1 , v2);
              eval.push(ans);
              
              //infix stack value
              String inV1 = in.pop();
              String inV2 = in.pop();
              
              String inval = "(" + inV1 + opr + inV2 + ")";
              in.push(inval);
              
              //post stack value
              String postV1 = post.pop();
              String postV2 = post.pop();
              
              String postval = postV1 + postV2 + opr;
              post.push(postval);
            }
        }
        
        System.out.println(eval.peek());
        System.out.println(in.peek());
        System.out.println(post.peek());
    }
    
      public static int operation(char opr , int v1 , int v2){
        if(opr == '+'){
            return v1 + v2 ;
        }
        else if(opr == '/'){
            return v1 / v2 ;
        }
        else if(opr == '*'){
            return v1 * v2 ; 
        }
        else if(opr == '-'){
            return v1 - v2 ;
        }
        else{
            return 0 ;
        }
    }
}