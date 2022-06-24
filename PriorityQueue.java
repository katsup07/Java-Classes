import java.util.Arrays;

public class PriorityQueue {
    private int[] items = new int[5];
    private int count = 0;

    //[ 5, 1, 7, 4]
    public void add(int x) {
        if(items.length == count) throw new IllegalStateException();
        shiftItemsRightAndAdd(x);
        count++;
    }

    private void shiftItemsRightAndAdd(int x){
        // 1, 4, 5, 7
        int i = 0;
        // This loop is only for shifting items
        for (i = count - 1; i >= 0; i--) {
            if (items[i] > x)
                items[i + 1] = items[i]; // shifts bigger than x numbers each right by one
            else
                break; // if a number is smaller than x, break and set x to be the next number
        }
        items[i+1] = x;// set x to be the next number
    }

    public int removeFromFront(){
        if(isEmpty()) throw new IllegalStateException();
        int firstItem = items[0];
        for(int i=0; i<items.length-1; i++) items[i] = items[i+1]; // shift each item forward by one
        count--;
        return firstItem;
    }

    public int removeFromBack(){
        if(isEmpty()) throw new IllegalStateException();
        return items[--count];
    }

    public boolean isEmpty(){
        return count == 0;
    }
        @Override
        public String toString() {
            return Arrays.toString(items);
        }
    }
