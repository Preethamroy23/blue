import java.util.LinkedList;
import java.util.Queue;

class Node{
    int data;
    Node left;
    Node right;
    Node(int n){
        data=n;
    }
}
class Tree {
    Node root; 

    void inorder(Node root){
        if (root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    void preorder(Node root){
        if (root==null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    void postorder(Node root){
        if (root==null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+ " ");
    }
    void levelorder(Node root){
        if(root==null)
            return;
        Queue <Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            Node cur=q.poll();
            System.out.print(cur.data+" ");
            if(cur.left!=null){
                q.add(cur.left); 
            }
            if(cur.right!=null){
                q.add(cur.right); 
            }
        }
    }
}

public class Binarytree {
    public static void main(String[] args) {
        Tree tr=new Tree();
        tr.root=new Node(1);
        tr.root.left=new Node(2);
        tr.root.right=new Node(3);
        tr.root.left.left=new Node(4);
        tr.root.left.right=new Node(5);
        tr.root.right.left=new Node(6);
        tr.root.right.right=new Node(7);
        System.out.print("Lopala order juyy ");
        tr.inorder(tr.root);
        System.out.printf(" \nmy name order durr ");
        tr.preorder(tr.root);
        System.out.printf("\npost order juyy ");
        tr.postorder(tr.root);
        System.out.printf("\nlevel order juyy ");
        tr.levelorder(tr.root);
    }
}

