package trees.BinarySearchTrees.Deletion;

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

        return null;
    }

    public void delete(int value) {

        root = delete(root, value);
        //We are passing the root of the subtree that we want to search for the value
    }

    private TreeNode delete(TreeNode subTreeRoot, int value) {
        if (subTreeRoot == null) {
            //For empty tree
            return subTreeRoot;
        }

        if (value < subTreeRoot.getData()) {
            //If the value to delete is smaller than the current node, we will search the left part of the subtree
            subTreeRoot.setLeftChild(delete(subTreeRoot.getLeftChild(), value));//At the end we are replacing the subtree's left child with whatever the result of the delete method is.
        }
        else if (value > subTreeRoot.getData()) {
            //If the value to delete is greater than the current node, we will search the right part of the subtree
            subTreeRoot.setRightChild(delete(subTreeRoot.getRightChild(), value));//At the end we are replacing the subtree's right child with whatever the result of the delete method is.
        }
        else {
            // Cases 1 and 2: node to delete has 0 or 1 child
            //There are two possibilities here, one is if node is a leaf and therefore the right child is also null in this case; or it has a right child
            if (subTreeRoot.getLeftChild() == null) {

                return subTreeRoot.getRightChild();
            }
            else if (subTreeRoot.getRightChild() == null) {//vice-versa
                return subTreeRoot.getLeftChild();
            }


            // Case 3: node to delete has 2 children

            // Method-1 Using the right child

//            // Replace the value in the subtreeRoot node with the smallest value
//            // from the right subtree
//            subTreeRoot.setData(subTreeRoot.getRightChild().min());
//
//            // Delete the node that has the smallest value in the right subtree
//            subTreeRoot.setRightChild(delete(subTreeRoot.getRightChild(), subTreeRoot.getData()));

            // Method-2 Using the left child

            // Replace the value in the subtreeRoot node with the largest value
            // from the left subtree
            subTreeRoot.setData(subTreeRoot.getLeftChild().max());

            // Delete the node that has the smallest value in the left subtree
            subTreeRoot.setLeftChild(delete(subTreeRoot.getLeftChild(), subTreeRoot.getData()));
        }

        return subTreeRoot;
    }

    public int min() {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        else {
            return root.min();
        }
    }

    public int max() {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        else {
            return root.max();
        }
    }

    public void traverseInOrder() {
        System.out.print("{ ");
        if (root != null) {
            root.traverseInOrder();
        }
        System.out.println("}");
    }

}
/*
Delete Node with Two Children-

- Need to figure out what the replacement node will be.
- Want minimal disruption to the existing tree structure.
- Can take the replacement node from the left subtree, we have to take the largest value in the left subtree
- If taking it from the right subtree, we have to take the smallest value in the right subtree.
- Choose one node and then stick to it.
 */
