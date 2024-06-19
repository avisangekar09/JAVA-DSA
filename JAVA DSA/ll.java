public class ll {
    Node head;
    private int size;

    ll(){
        size = 0;
    }

    class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
            size++;
        }
    }

    public void addfirst(int n){
        Node newnode = new Node(n);
         newnode.next = head;
         head = newnode;
    }

    public void addlast(int n){
        Node newnode = new Node(n);

        if(head == null){
            head = newnode;
            return;
        }

        Node lastnode = head;

        while(lastnode.next != null){
            lastnode = lastnode.next;
        }
        lastnode.next = newnode;
    }

    public void printlist(){
        Node temp = head;

        while(temp != null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void removefirst(){
        if(head == null) {
            System.out.print("empty list");
        }
        head = head.next;
        size--;
    }

    public void removelast(){
        if(head == null){
            System.out.print("empty list");
            return;
        }

        size--;
        if(head.next == null){
            head = null;
            return;
        }

        Node curr = head;
        Node last = head.next;

        while(last.next != null){
            last = last.next;
            curr = curr.next;
        }
        curr.next = null;
    }
    public int getsize(){
        return size;
    }
    public Node revlist(Node head){
        if(head == null || head.next == null) return head;

        Node newhead = revlist(head.next);
        head.next.next = head;
        head.next = null;
        return newhead;
    }
    public static void main(String args[]){
        ll list = new ll();

        list.addfirst(1);

        list.addlast(2);
        list.addlast(3);
        list.addlast(4);
        list.addlast(5);

        list.printlist();

        list.removefirst();
        list.printlist();
        list.removelast();
        list.printlist();
        //System.out.println(getsize());

        list.head = list.revlist(list.head);
        list.printlist();

    }
}
