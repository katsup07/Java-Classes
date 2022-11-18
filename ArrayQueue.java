import java.util.Arrays;

public class ArrayQueue {
    // [front ---> 10, 20, 30, 40, 0 <-- rear]
    private int[] items;
    private int front = 0; // points to item in front of queue
    private int rear = 0;// points to one behind rear item in queue
    private int count = 0;

    public ArrayQueue(int capacity){
        if(capacity <= 0) throw new IllegalArgumentException();
        items = new int[capacity];
    }

    // Add item to rear
    public void enqueue(int item){ 
        if(isFull()) throw new IllegalStateException();
        items[rear] = item;
        rear = (rear + 1) % items.length; // circular array that overwrites previous item postions that have been dequeued
        count++;
    }

    // Remove element from front
    public int dequeue(){ 
        if(isEmpty()) throw new IllegalStateException();
     
        var item = items[front]; // so item can be returned at end
        items[front] = 0; // this is unnecessary, but it is useful when testing and debugging to have zeros represent nothing
        front = (front + 1) % items.length;// circular array that overwrites previous item postions that have been dequeued
        count--;
        return item;
    }
    
    public boolean isFull(){
        return count == items.length;
    }

    public int peek(){
        return items[front];
    }

    // for testing purposes only
    public int peekRear(){
        return items[rear];
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public boolean isFull(){
        return items.length == count;
    }
    @Override
    public String toString(){
        return Arrays.toString(items);
    }
}
