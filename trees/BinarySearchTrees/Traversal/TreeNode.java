package trees.BinarySearchTrees.Traversal;

public class TreeNode {

    private int data;
    private TreeNode leftChild;
    private TreeNode rightChild;

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

    public void traverseInOrder() {
        //Traversing the binary search tree in order of Left child-->Root(parent)-->Right child

        if (leftChild != null) {
            //If there is a left child, we will traverse it before the root(parent)
            leftChild.traverseInOrder();
        }
        System.out.print(data + ", ");//Then visiting the current node i.e., root(parent)
        if (rightChild != null) {
            //If there is a right child, we traverse it after traversing the Root(parent)
            rightChild.traverseInOrder();
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
