public class BinaryTree {
    private BinaryTreeNode root;

    public void insert(int value) {
        if (root == null) {
            root = new BinaryTreeNode(value);
        } else {
            root.insert(value);
        }
    }

    public int getHeight() {
        if (root == null) return 0;
        return root.getHeight();
    }

    public boolean contains(int value) {
        if (root == null) return false;
        return root.contains(value);
    }

    public String toString() {
        if (root == null) return "Empty Tree";
        return root.toString();
    }
}
