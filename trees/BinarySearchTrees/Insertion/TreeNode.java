package trees.BinarySearchTrees.Insertion;

public class TreeNode {
//Class for node
    private int data;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public void insert(int value) {
        if (value == data) {
            //Means it is a duplicate value, and we don't want to insert it
            return;
        }

        if (value < data) {
            //If the value we want to insert is less than the data then it is inserted in the left side of the tree.
            if (leftChild == null) {
                //Creating a node if there is no new node
                leftChild = new TreeNode(value);
            }
            else {
                //If there is already a left child made
                leftChild.insert(value);
            }
        }
        else {
            //If the value we want to insert is greater than the data, then it is inserted in the right side of the tree.
            if (rightChild == null) {
                //Creating a node if there is no new node
                rightChild = new TreeNode(value);
            }
            else {
                //If there is already a left child made
                rightChild.insert(value);
            }
        }
    }

    public TreeNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeftChild() {

        return leftChild;

    }

    public void setLeftChild(TreeNode leftChild) {

        this.leftChild = leftChild;

    }

    public TreeNode getRightChild() {

        return rightChild;

    }

    public void setRightChild(TreeNode rightChild) {

        this.rightChild = rightChild;

    }
}
