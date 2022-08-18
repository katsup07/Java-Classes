public class Tree {
    private class Node{
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value){
            this.value = value;
        }

        @Override
        public String toString(){
            return "Node="+value;
        }
    }
    private Node root;

    /* Inserts a node into Tree*/
    public void insert(int value){
        if(root == null){
            root = new Node(value);
            return;
        }

        Node current = root;
        while(true) {
            if (value < current.value) {
                if(current.leftChild == null) {
                    current.leftChild = new Node(value);
                    break;
                }
                else current = current.leftChild;
            } else if( value > current.value) {
                        if(current.rightChild == null) {
                            current.rightChild = new Node(value);
                            break;
                        } else {
                            current = current.rightChild;
                        }
            }
             else {
                // do nothing, since value == current.value and is already in tree
             }
            }

    }

    /*Checks if there is a node already in Tree*/
    public boolean find(int value) {
        if (root == null) {
            return false;
        }

        var current = root;
        while (true) {
            if( value == current.value){
                return true;
            }
            else if (value < current.value) {
                if (current.leftChild == null) {
                    return false;
                }
                current = current.leftChild;
            } else {
                if (current.rightChild == null) {
                    return false;
                }
                current = current.rightChild;
            }
        }

    }
        }
