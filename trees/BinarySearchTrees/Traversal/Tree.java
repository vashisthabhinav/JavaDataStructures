package trees.BinarySearchTrees.Traversal;


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

    public void traverseInOrder() {
        System.out.print("{ ");
        if (root != null) {
            //Traversing the root if it not null
            root.traverseInOrder();
        }
        System.out.print("}");
    }


}
