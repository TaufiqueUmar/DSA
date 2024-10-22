  class queuea{
    int f = -1;
    int r =  -1;
    int size = 0;
    int [] arr = new int[100];

    public void enque(int x){
        if(r==arr.length-1){
            System.out.println("queue is full");
        }
        if(f==-1){
        f = r = 0;
        arr[0] = x;
        }
        else{
            arr[r+1] = x;
            r++;
        }
        size++;
    }

    public int deque(){
          if(size==0){
          // if(f==-1 && r==-1){  BOTH ARE WORKING.
            System.out.println("Queue is empty");
            return -1;
          }
          size--;
          int x = arr[f];
          f++;
          return x;
    }

    public int peek(){
        if(size==0){
          System.out.println("Queue is empty");
          return -1;
        }
        return arr[f];
  }

  public boolean isEmpty(){
    if(size==0) return true;
    else  return false;
  } 

  public void display(){
    if(size==0){
        System.out.println("Queue is empty");
    }
    else{
        for(int i=f;i<=r;i++){
            System.out.print(arr[i] + " ");
        }
    }
    System.out.println();
  }
}
public class Main1{
    public static void main(String[] args) {
        queuea q = new queuea();
        q.display();
        q.enque(1);
        q.enque(2);
        q.enque(3);
        q.enque(4);
        q.display();
        q.deque();
        q.display();
        System.out.println(q.peek());
        System.out.println(q.size);
System.out.println(q.isEmpty());
    } 
}
