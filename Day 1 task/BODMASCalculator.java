import java.util.Scanner;
import java.util.Stack;
public class BODMASCalculator {
    
    public static int evaluateExpression(String Expression){
        char arr[]=Expression.toCharArray();
        Stack<Integer> operands=new Stack<>();
        Stack<Character> operator=new Stack<>();
        int l=arr.length;
        for(int i=0;i<l;i++){
            if(arr[i]==' '){
                continue;
            }
            else if(arr[i]>='0'&& arr[i]<='9' ){
                StringBuilder sb=new StringBuilder();
                while(i<arr.length && arr[i]>='0'&& arr[i]<='9'){
                    sb.append(arr[i++]);
                    
                }
                i--;
                operands.push(Integer.parseInt(sb.toString()));
            }
            else if(arr[i]=='('){
                operator.push(arr[i]);
            }
            else if( arr[i]==')'){
                while(operator.peek()!='('){
                    // char op=operator.pop();
                    // int val1=operands.pop();
                    // int val2=operands.pop();
                    operands.push(calculate(operator.pop(),operands.pop(),operands.pop()));
                }
                operator.pop();
            }
            else if(arr[i]=='+'|| arr[i]=='-'|| arr[i]=='*'|| arr[i]=='/'|| arr[i]=='A'|| arr[i]=='S'|| arr[i]=='M'|| arr[i]=='D'){
                while (!operator.empty() && isHigherPrecedence(arr[i],operator.peek())) {
                  
                    operands.push(calculate(operator.pop(),operands.pop(),operands.pop()));
                }
                operator.push(arr[i]);
            }
            // System.out.println(i);
        } 
        System.out.println(operator.size()+" "+operands+" "+operator);
            
        while(!operator.empty()){
            // char op=operator.pop();
            // int val1=operands.pop();
            // int val2=operands.pop();
            System.out.println(operator.size()+" "+operands+" "+operator);
            operands.push(calculate(operator.pop(),operands.pop(),operands.pop()));
            }
            System.out.println(operator.size()+" "+operands+" "+operator);
           
            int result= operands.pop();
            return result;
        
    }
    public static int calculate(char op,int v2,int v1){
        switch(op){
            case '+','A': return v1+v2;
            case '-','S': return v1-v2;
            case '*','M': return v1*v2;
            case '/','D': if(v2==0)
            throw new ArithmeticException("Division with Zero Results Not Defined");
            return v1/v2;
        }
     return 0;
    } 
    public static boolean isHigherPrecedence(char op1 , char op2){
        if(op2=='('|| op2==')')
        return false;
       else if((op1=='*'|| op1=='/') && (op2=='+'|| op2=='-')){
            // System.out.println(op1 + );
           return false;
       }
      
        else
        return true;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Expression evaluated");
        String s=sc.nextLine();
       int result= evaluateExpression(s);
       System.out.println("RESULT "+result);
    }
}
