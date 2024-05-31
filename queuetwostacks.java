import java.io.*;
import java.util.*;
class queustack{
    Stack<Integer> s1= new Stack<>(); 
    Stack<Integer> s2= new Stack<>(); 
    void enqueue(int n){
        s1.push(n);
    }
    void dequeue(){
        if(!s2.isEmpty()){
            s2.pop();
        }
        else{
            while(!s1.isEmpty()){
            s2.add(s1.pop());
        }
        s2.pop();
        }
    }
    void peek(){
        if(!s2.isEmpty()){
            int ele=s2.peek();
            System.out.println(ele);
        }
        else{
            while(!s1.isEmpty()){
            s2.add(s1.pop());
        }
        int ele=s2.peek();
        System.out.println(ele);
    }
    }
}
public class queuetwostacks {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        queustack cl=new queustack();
        for(int i=0;i<n;i++){
            int ch=sc.nextInt();
            switch(ch){
                case 1: int num=sc.nextInt();
                cl.enqueue(num); break;
                case 2: cl.dequeue(); break;
                case 3: cl.peek(); break;
            }
        }
    }
}
