class Stack{
    int [] stackArray;
    int top;
    // private int maxSize;
    public Stack(int size){
        // maxSize = size;
        // stackArray = new int[maxSize];
        stackArray = new int[size]; 
        top = -1;
    }
    
    public void push(int x){
        // if(top == maxSize)
        if(top == stackArray.length -1){
            System.out.println("Stack is Full");

        }else{
            top++;
            stackArray[top] = x;
        }
    }

    public int pop(){
       if(top == -1){
        System.out.println("Stack is empty");
       return -1;
    }
        else{
            int x = stackArray[top];
            top--;
            return x;
        }
    }
    public int peek() {
        if (top == -1) {
            System.out.println("Stack is empty.");
            return -1;
        } else {
            return stackArray[top];
        }
    }
    public int size(){
        return top + 1;
    }
    public boolean isFull() {
        return top == stackArray.length -1;
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }


    public void display() {
        // if (isEmpty()) {
        //     System.out.println("Stack is empty.");
        // } else {
            System.out.print("Stack elements: ");
            for (int i = 0; i <= top; i++) {
                System.out.print(stackArray[i] + " ");
            }
            System.out.println();
        }
    
}
public class Main{
    public static void main(String[] args) {
        Stack s = new Stack(5);
        s.push(2);
        s.push(3);
        s.push(4);
        s.display();
        s.pop();
        System.out.println("Äfter pop");
        s.display();
        // s.peek();
        System.out.println("peek value is" + s.peek());
        System.out.println("size is:" + s.size());
        // System.out.println("Is stack is full");
        // s.isFull();
        System.out.println("Is stack is full\n" + s.isFull());
        
        System.out.println("is stack is empty\n" + s.isEmpty());
        // s.isEmpty();
    }
}