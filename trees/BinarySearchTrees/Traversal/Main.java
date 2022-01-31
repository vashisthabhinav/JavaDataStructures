package trees.BinarySearchTrees.Traversal;

public class Main {

    public static void main(String[] args) {
        Tree intTree = new Tree();
        intTree.insert(25);
        intTree.insert(20);
        intTree.insert(15);
        intTree.insert(27);
        intTree.insert(30);
        intTree.insert(29);
        intTree.insert(26);
        intTree.insert(22);
        intTree.insert(32);

        intTree.traverseInOrder();
    }
}
/*
Traversal-
- Level--> Visit node on each level.
- Pre-order--> Visit the root of every subtree first.
- Post-order--> Visit the root of every subtree last.
- In-order--> Visit left child, then root, then right child.(Sorted result)
 */