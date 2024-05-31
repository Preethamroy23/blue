import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
class stacktwoque{
    Queue q1=new LinkedList<>();
    Queue q2=new LinkedList<>();
    void push(int n){
        q2.add(n);
        while(!q1.isEmpty()){
            q2.add(q1.poll());
        }
        Queue <Integer> temp= q1;
        q1=q2;
        q2=temp;
    } 
    int pop(){
       return (int) q1.poll(); 
    }
    int peek(){
        return (int) q1.peek();
    }
    boolean isEmpty(){
        return q1.isEmpty();
    }
}
public class queue1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        stacktwoque st=new stacktwoque();
        st.push(1);
        st.push(2);
        st.push(0);
        st.push(7);
        System.out.println(st.pop());
        st.push(9);
        System.out.println(st.peek());
        System.out.println(st.isEmpty());
    }
}