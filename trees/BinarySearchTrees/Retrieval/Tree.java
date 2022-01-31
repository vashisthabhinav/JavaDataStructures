package trees.BinarySearchTrees.Retrieval;

public class Tree {

    private TreeNode root;

    public void insert(int value) {
        if (root == null) {
            root = new TreeNode(value);
        }
        else {
            root.insert(value);
        }
    }

    public TreeNode get(int value) {
        if (root != null) {

            return root.get(value);

        }

        return null;//The tree is empty
    }

    public int min() {
        if (root == null) {
            return Integer.MIN_VALUE;//Smallest integer value
        }
        else {
            return root.min();
        }
    }

    public int max() {
        if (root == null) {
            return Integer.MAX_VALUE;//Largest integer value
        }
        else {
            return root.max();
        }
    }

    public void traverseInOrder() {
        if (root != null) {
            root.traverseInOrder();
        }
    }

}
