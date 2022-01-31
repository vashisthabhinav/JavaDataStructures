package trees.BinarySearchTrees.Insertion;

public class Tree {

    private TreeNode root;
    //All we need is the root for traversing
    //Not using the duplicate values

    public void insert(int value) {
        if (root == null) {
            //If the root is null, then whatever we are inserting is made the root
            root = new TreeNode(value);
        }
        else {
            //Else other children nodes are made
            root.insert(value);
        }
    }


}
