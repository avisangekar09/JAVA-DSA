public class circularqueuearr {
    static class queue{
        static int arr[];
        static int size;
        static int front = -1;
        static int rear = -1;

        queue(int size){
            this.size = size;
            arr = new int[size];
        }

        public static boolean isEmpty(){
            return front==-1 && rear==-1;
        }

        public static boolean isfull(){
            return (rear+1)%size == front;
        }

        public static void add(int data){
            if(isfull()){
                System.out.println("queue is overflow");
                return;
            }
            if(front == -1) front = 0;

            rear = (rear+1)%size;

            arr[rear] = data;
        }

        public static int remove(){
            if(isEmpty()){
                System.out.println("queue is underflow");
                return -1;
            }
            int top = arr[front];
            if(front==rear){
                front = rear = -1;
            }else
            front = (front+1)%size;

            return top;
        }
        public static int peek(){
            if(isEmpty()){
                System.out.println("queue underflow");
                return -1;
            }
            return arr[front];
        }
    }

    public static void main(String args[]){
        queue q = new queue(5);

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
