public class queuelist {
   static class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        next = null;
    }
   } 

   static class queue{
    static Node head = null;
    static Node tail = null;

    public static boolean isEmpty(){
        return head==null && tail==null;
    }

    public static void add(int data){
        Node newnode = new Node(data);
        if(isEmpty()){
            head = tail = newnode;
        }else{
            tail.next = newnode;
            tail = newnode;
        }
    }

    public static int remove(){
        if(isEmpty()){
            System.out.println("queue underflow");
            return -1;
        }
        int front = head.data;
        if(head == tail) tail=null;
        head = head.next;
        return front;
    }

    public static int peek(){
        if(isEmpty()){
            System.out.println("queue underflow");
            return -1;
        }

        return head.data;
    }

   }
   public static void main(String args[]){
    queue q = new queue();
    q.add(1);
    q.add(2);
    q.add(3);
    q.add(4);

    while(!q.isEmpty()) {
        System.out.println(q.peek());
        q.remove();
    }
   }
}
