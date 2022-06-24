package com.katsup;

import java.util.NoSuchElementException;

public class LinkedList {
    

    // nested Node class
    private class Node {
        private int value;
        private Node next;
     

        public Node(int value) {
            this.value = value;
        }
    }
    

    // LinkedList class
    private Node first;
    private Node last;
    private int size = 0;

    
    public void addLast(int item) {
        var node = new Node(item);
        // no Nodes in LinkedList yet
@@ -37,11 +39,11 @@ public void addFirst(int item){

        size++;
    }
    

    public int size(){
        return size;
    }
    

    public void removeFirst(){
        if(isEmpty()) throw new NoSuchElementException();

@@ -90,7 +92,7 @@ public int indexOf(int item){
        return -1;
    }

    

    public int getKthNodeValueFromTheEnd(int k) {
        if(isEmpty()) throw new IllegalStateException();
        Node n =first;
@@ -106,7 +108,7 @@ public int getKthNodeValueFromTheEnd(int k) {
        }
    return n.value;
    }
    

    // mutable
    public void reverse2() {
        // if list is empty
@@ -167,8 +169,56 @@ private boolean isEmpty(){
        return first == null;
    }

}
    public void printMiddle(){
        int counter = 0;
        Node n = first;
        boolean even = false;
        if(size % 2 == 0) even = true;

        while((counter < (size / 2)-1) && size!=1){
            n = n.next;
            counter++;
        }

        if(size == 0) {
            System.out.println("There are no values. This linked list is empty.");
        }
        else if(size == 1) { // one value
            System.out.println("There is only 1 middle value. It is "+ n.value+ ".");
        }
        else if(even) {  // even has two middle values
            System.out.println("There are two middle values. They are " + n.value +" and "+ n.next.value + ".");
        }
        else { // odd has one middle value. The while loop goes until one before the actual middle value, so need n.next here.
            System.out.println("There is only one middle value. It is " + n.next.value + ".");
        }
    }

    public boolean hasLoop(){
        // zero elements
        if(size == 0) return false;// must have at least one element for loop
        // one element
        if(size == 1 ) return first.next == first;
        //two or more elements
        Node fast = first.next;
        Node slow = first;
        int counter = 0;
        boolean result = false;

        while(counter <= size && fast!=null){
            if(fast.next == null || fast.next.next == null) return false; //no loop
            if(fast == slow) { // there is a loop
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;// no loop
    }

    // loops from last back to first
    public void makeLoop(){
        last.next = first;
    }

}
