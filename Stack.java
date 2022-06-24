import java.util.Arrays;

public class Stack {
    private int count = 0; // effective size of array
    private int[] items = new int[10];

    // doubles size of an array so stack can grow as need be
    private void doubleSize() {
        int[] doubled = new int[count*2];
        for(int i = 0; i< items.length; i++){
            doubled[i] = items[i];
        }
        items = doubled;
    }

    public void push(int item){
        if(count == items.length) doubleSize();
        items[count++] = item;
    }

    public int pop(){
        if(count == 0) throw new IllegalStateException();
        int item = items[count-1];// count is always one ahead, so minus 1
        items[--count] = 0;
        return item;
    }

    public int peek(){
        if(count == 0) throw new IllegalStateException();
        return items[count-1];
    }

    // Prints the array out to console
    public void printStack(){
        //Will omit zeroes
//        var content = Arrays.copyOfRange(items, 0, count);
//        System.out.println(Arrays.toString(content));
        // Will show zeroes
        System.out.println(Arrays.toString(items));
    }

    @Override // returns string of items in stack
    public String toString(){
        String str = "Stack: "+items[0];
    for(int i=1; i<count; i++){
        str+=", " + items[i];
    }
    return str;
    }

    public boolean isEmpty(){
        return count == 0;
    }


}
