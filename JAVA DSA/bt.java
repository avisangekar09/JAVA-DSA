import java.util.*;
class bt{
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

    static class binarytree{

        static int idx = -1;
        public static Node binaryt(int[] nodes){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }

            Node newnode = new Node(nodes[idx]);
            newnode.left = binaryt(nodes);
            newnode.right = binaryt(nodes);

            return newnode;
        }
    }

    public static void preorder(Node root){
        if(root == null) return;

        System.out.print(root.data+" ");
        preorder(root.left);
       
        preorder(root.right);
        
    }

    public static void inorder(Node root){
        if(root == null) return;

        
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
        
    }

    public static void postorder(Node root){
        if(root == null) return;

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }
 
    public static void levelorder(Node root){
        if(root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node curr = q.remove();
            if(curr == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }
            else{
                q.add(null);
            }
        }else{
            System.out.print(curr.data+" ");

            if(curr.left != null) q.add(curr.left);

            if(curr.right != null) q.add(curr.right);
        }
    }
    }
 
    public static int height(Node root){
        if(root == null) return 0;

        int lefth = height(root.left);
        int righth = height(root.right);

        return Math.max(lefth, righth) + 1;
    }

    public static int countofnodes(Node root){
        if(root == null) return 0;

        int leftc = countofnodes(root.left);
        int rightc = countofnodes(root.right);

        return leftc+rightc+1;
    }

    public static int sumofnodes(Node root){
        if(root == null) return 0;

        int leftsum = sumofnodes(root.left);
        int rightsum = sumofnodes(root.right);

        return leftsum + rightsum + root.data;
    }

    public static int diameter(Node root){
        if(root == null) return 0;

        int diam1 = height(root.left) + height(root.right) +1;
        int diam2 = diameter(root.left);
        int diam3 = diameter(root.right);

        return Math.max(diam1, Math.max(diam2, diam3));
    }
    public static void main(String args[]){
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
       //int nodes[] = {1,2,4,5,3,-6};

        binarytree tree = new binarytree();

        Node root = tree.binaryt(nodes);
        System.out.println(root.data);
        preorder(root);
System.out.println();
        inorder(root);
        System.out.println();
        postorder(root);
        System.out.println();
        levelorder(root);
        System.out.println(height(root));
        System.out.println(countofnodes(root));
        System.out.println(sumofnodes(root));
        System.out.println(diameter(root));
    }
}