package trees.BinarySearchTrees.Retrieval;

public class TreeNode {

    private int data;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode(int data) {

        this.data = data;

    }

    public void insert(int value) {
        if (value == data) {
            return;
        }

        if (value < data) {
            if (leftChild == null) {
                leftChild = new TreeNode(value);
            }
            else {
                leftChild.insert(value);
            }
        }
        else {
            if (rightChild == null) {
                rightChild = new TreeNode(value);
            }
            else {
                rightChild.insert(value);
            }
        }
    }

    public TreeNode get(int value) {
        if (value == data) {
            //We have found the value and returning the value
            return this;
        }

        if (value < data) {
            //When value is less than the data, we are going to search the left subtree
            if (leftChild != null) {
                //If we have a left child
                return leftChild.get(value);//Recalling recursively
            }
        }
        else {//When value is greater than the data, we are going to search the right subtree
            if (rightChild != null) {
                //If we have a right child
                return rightChild.get(value);//Recalling recursively
            }
        }

        return null;//It means we could not find the values which we are looking for
    }

    public int min() {
        //Only checks the leftmost node of the tree as it is the smallest
        if (leftChild == null) {
            //This is the leftmost child and hence the min
            return data;

        }
        else {
            //Keep checking the leftmost child until we have found one
            return leftChild.min();//Recalling recursively
        }
    }

    public int max() {//Only checks the rightmost node of the tree as it is the largest
        if (rightChild == null) {
            //This is the rightmost child and hence the max
            return data;
        }
        else {
            //Keep checking the rightmost child until we have found one
            return rightChild.max();//Recalling recursively
        }
    }

    public void traverseInOrder() {
        if (leftChild != null) {
            leftChild.traverseInOrder();
        }
        System.out.print(data + ", ");
        if (rightChild != null) {
            rightChild.traverseInOrder();
        }
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

    public String toString() {

        return "Data = " + data;

    }
}
