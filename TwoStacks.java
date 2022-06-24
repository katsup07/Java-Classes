import java.util.Arrays;

// Use two stacks in one array.
public class TwoStacks {
    private int count1 = 0; // section of array that is used for stack1
    private int count2 = 0;// section of array that is used for stack2
    //Note: stack1 ranges from 0 to (count1 - 1) // stack2 ranges from count1 to (count2 - 1)

    private int[] items = new int[10];

    public void push1(int item){
        if(bothStacksLength() == items.length) doubleSize();//grow array size if full
        shiftStackNumber2RightByOne();// shift stack2 right to make a space for stack1 to grow
        items[count1++] = item;
    }

    public void push2(int item){
        if(bothStacksLength() == items.length) doubleSize();// grow array size if full
        items[bothStacksLength()] = item;
        count2++;
    }

    public int pop1(){
        if(count1 == 0) throw new IllegalStateException();
        int item = items[count1-1];
        items[--count1] = 0;// this line is unnecessary, but it makes it easier for debugging. Assume 0 = empty.
        count2++; // keep count2 from slipping back into stack 1 range. The net result is no change (--count1 + count2++)
        return item;
    }

    public int pop2(){
        if((count2) == 0) throw new IllegalStateException();
        int item = items[bothStacksLength()-1];
        items[count1+(--count2)] = 0;
        return item;
    }

    public int peek1(){
        if(count1 == 0) throw new IllegalStateException();
        return items[count1-1];
    }

    public int peek2(){
        if((count2) == 0) throw new IllegalStateException();
        return items[(count1+count2)-1];
    }

    public void printStack(){
        System.out.println(Arrays.toString(items));
    }

    /* Helper methods */
    // shift stack2 right by one to make space for stack1 to grow
    private void shiftStackNumber2RightByOne(){
        if(bothStacksLength()+2 == items.length) doubleSize();

        int[] shiftedItems = new int[items.length];

        for(int i = count1; i<= bothStacksLength(); i++){
         shiftedItems[i+1] = items[i];
     }
        for(int i = 0; i<count1; i++){
            shiftedItems[i] = items[i];
        }
        items = shiftedItems;
    }

    private int bothStacksLength(){
        return count1 + count2;
    }

    // doubles size of an array so stack can grow if it becomes full
    private void doubleSize() {
        int[] doubled = new int[(bothStacksLength())*2];
        for(int i = 0; i<= bothStacksLength(); i++){
            doubled[i] = items[i];
        }
        items = doubled;
    }

}
