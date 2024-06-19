import java.util.*;

class bst{
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insert(Node root,int val){
        if(root == null){
            root = new Node(val);
            return root;
        }

        if(root.data > val){
            root.left = insert(root.left,val);
        }else{
            root.right = insert(root.right,val);
        }

        return root;
    }

    public static void inorder(Node root){
        if(root == null) return;

        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    
    public static boolean search(Node root,int k){
        if(root == null) return false;

        if(root.data > k){
            return search(root.left, k);
        }else if(root.data == k){
            return true;
        }else{
            return search(root.right,k);
        }
    }

    public static void printinrange(Node root,int x,int y){
        if(root == null) return;

        if(root.data >=x && root.data <=y){
            printinrange(root.left, x, y);
            System.out.print(root.data+" ");
            printinrange(root.right, x, y);
        }else if(root.data >= y){
            printinrange(root.left, x, y);
        }else{
            printinrange(root.right, x, y);
        }
    }

    public static void printpath(ArrayList<Integer> path){
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i)+"->");
        }
        System.out.println();
    }
    public static void roottoleaf(Node root,ArrayList<Integer> path){
        if(root == null) return;

        path.add(root.data);
        if(root.left == null && root.right == null){
            printpath(path);
        }else{
            roottoleaf(root.left, path);
            roottoleaf(root.right, path);
        }

        path.remove(path.size()-1);

    }

    public static Node delete(Node root,int val){
        if(root == null) return null;

        if(root.data > val){
            root.left = delete(root.left, val);
        }else if(root.data < val){
            root.right = delete(root.right, val);
        }

        //case 1
        else{
            if(root.left == null && root.right==null) return null;

            //case 2
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }

            //case 3

            Node is = inordersucc(root.right);
            root.data = is.data;
            root.right = delete(root.right, is.data);
        }

        return root;
    }

    public static Node inordersucc(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }
    public static void main(String args[]){
        int values[] = {5,1,3,4,2,7};
        Node root = null;

        for(int i=0;i<values.length;i++){
            root = insert(root,values[i]);
        }

        inorder(root);
        System.out.println();
        
        if(search(root,8)){
            System.out.println("key found!");
        }else{
            System.out.println("key not found !");
        }

        printinrange(root, 3, 7);
System.out.println();
        roottoleaf(root,new ArrayList<>());

        root = delete(root, 5);
        inorder(root);
    }
}