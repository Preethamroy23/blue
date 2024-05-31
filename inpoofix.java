import java.util.Scanner;
import java.util.Stack;
public class inpoofix {
    static int pre(char op){
        if(op=='^')
        return 3;
        else if(op=='*'|| op=='/')
        return 2;
        else
        return 1;
    }
    static String inprefix(String str){
        StringBuilder sb=new StringBuilder("");
        sb.reverse();
        char[] rev= sb.toString().toCharArray();
        for(int i=0;i<rev.length;i++){
            if(rev[i]=='('){
                rev[i]=')';
            }
            else if(rev[i]==')'){
                rev[i]='(';
            }
        }
        String midstr=convert(rev.toString());
        StringBuilder fpre=new StringBuilder("");
        return fpre.reverse().toString();
    }

    static String convert(String str){
        String result="";
        Stack<Character> st=new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch==')'){
                while(!st.isEmpty() && st.peek()!='(')
                result=result+st.pop();
                st.pop();
            }
            else if(Character.isLetterOrDigit(ch)){
                result=result+ch;
            }
            else if(ch=='('){
                st.push(ch);
            }
            else if(st.isEmpty() || st.peek()=='('){
                st.push(ch);
            }
            else{
                while (!st.isEmpty() && (pre(ch) <= pre(st.peek()) && st.peek()!='('))
                {
                    result=result+st.pop();
                    
                }
                st.push(ch);
            }
            }
            while(!st.isEmpty()){
            result+=st.pop();
            }
            return result;
        }

    public static void main(String...args){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        System.out.println(convert(str));
        System.out.println(inprefix(str));
    }
}
