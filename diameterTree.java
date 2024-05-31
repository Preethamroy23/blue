import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    int data;
    Node left;
    Node right;
    
    Node(int n) {
        data = n;
    }
}

class Tree {
    Node root; 
    
    void build(int arr[]) {
        if (arr.length == 0)
            return;
        root = new Node(arr[0]);
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int i = 1, n = arr.length;
        while (i < n && !q.isEmpty()) {
            Node cur = q.poll();
            if (arr[i] != -1) {
                cur.left = new Node(arr[i]);
                q.offer(cur.left);
            }
            i++;
            if (i < n && arr[i] != -1) {
                cur.right = new Node(arr[i]);
                q.offer(cur.right);
            }
            i++;
        }
    }
    int height(Node root){
        if(root==null) return 0;
        return Math.max(height(root.left),height(root.right))+1;
    }
    int dia(Node root){
        if(root==null) return 0;
        int ip=height(root.left)+height(root.right)+1;
        int ep=Math.max(dia(root.left),dia(root.right));
        int d=Math.max(ip,ep);
        return d;
        
    }
}

public class diameterTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Tree tr = new Tree();
        String str[] = sc.nextLine().split(" ");
        int arr[] = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        tr.build(arr); 
        System.out.println(tr.dia(tr.root));
        sc.close();
    }
}