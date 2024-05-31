import java.util.Scanner;
import java.util.Stack;

class Main {
    static int operation(int a, char op, int b) {
        int res = 0;
        switch (op) {
            case '+':
                res = a + b;
                break;
            case '-':
                res = a - b;
                break;
            case '*':
                res = a * b;
                break;
            case '/':
                res = a / b;
                break;
        }
        return res;
    }

    static int Evaluation(String str) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isDigit(ch))
                st.push(ch - '0'); // Convert char to int correctly
            else {
                int b = st.pop();
                int a = st.pop();
                char op = str.charAt(i);
                st.push(operation(a, op, b));
            }
        }
        return st.peek();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine(); 
        for (int t = 0; t < T; t++) {
            String str = sc.nextLine();
            System.out.println(Evaluation(str)); 
        }
        sc.close();
    }
}