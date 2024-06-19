public class stackpro {
    private static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            next = null;
        }
    }

    static class stack{
        public static Node head = null;
        public static void push(int data){
            Node newnode = new Node(data);
            if(head == null){
                head = newnode;
                return;
            }

            newnode.next = head;
            head = newnode;
        }
        public static boolean isEmpty(){
            return head == null;
        }
        public static int pop(){
            if(isEmpty()){
                return -1;
            }

            Node top = head;
            head = head.next;

            return top.data;
        }
        public static int peek(){
            if(isEmpty()){
                return -1;
            }

            Node top = head;
            return top.data;
        }
    }
    public static void main(String args[]){
        stack st = new stack();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        //st.pop();

        while(!st.isEmpty()){
            System.out.println(st.peek());
            st.pop();
        }
    }
}
