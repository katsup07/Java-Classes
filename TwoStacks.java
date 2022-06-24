import java.util.Arrays;
public class TwoStacks {
    private int count1 = 0; // section of array that is used for stack1
    private int count2 = 0;// section of array that is used for stack2
    //Note: stack1 ranges from 0 to (count1 - 1) // stack2 ranges from count1 to (count2 - 1)

    private int[] items = new int[10];

    // doubles size of an array so stack can grow if it becomes full
    private void doubleSize() {
        int[] doubled = new int[(bothStacksLength())*2];
        for(int i = 0; i<= bothStacksLength(); i++){
            doubled[i] = items[i];
        }
        items = doubled;
    }

    public void push1(int item){
        if(bothStacksLength() == items.length) doubleSize();//grow array size if full
        shiftStackNumber2RightByOne();// shift stack2 right to make a space for stack1 to grow
@@ -53,6 +44,11 @@ public int peek2(){
        return items[(count1+count2)-1];
    }

    public void printStack(){
        System.out.println(Arrays.toString(items));
    }

    /* Helper methods */
    // shift stack2 right by one to make space for stack1 to grow
    private void shiftStackNumber2RightByOne(){
        if(bothStacksLength()+2 == items.length) doubleSize();
@@ -72,9 +68,13 @@ private int bothStacksLength(){
        return count1 + count2;
    }



    public void printStack(){
        System.out.println(Arrays.toString(items));
    // doubles size of an array so stack can grow if it becomes full
    private void doubleSize() {
        int[] doubled = new int[(bothStacksLength())*2];
        for(int i = 0; i<= bothStacksLength(); i++){
            doubled[i] = items[i];
        }
        items = doubled;
    }

}
