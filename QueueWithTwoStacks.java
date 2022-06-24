package com.katsup;
import java.util.*;

// A queue made by using two stacks
public class QueueWithTwoStacks {
 
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

  
    public void enqueue(int item){
        stack1.push(item);
    }

    public int dequeue(){
        if(isEmpty()) throw new IllegalStateException();

        if(stack2.isEmpty()) addToStack2();

        return stack2.pop();// 10
       
    }

    private void addToStack2(){
      
        while(!stack1.isEmpty()) stack2.push(stack1.pop());
    }

    public int peek(){
        if(stack1.isEmpty() && stack2.isEmpty()) throw new IllegalStateException();

        if(stack2.isEmpty()) addToStack2();

        return stack2.peek();
    }

    public boolean isEmpty(){
        return stack2.isEmpty() && stack1.isEmpty();
    }
}
