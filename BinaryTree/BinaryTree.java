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

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(0);
        tree.insert(2);
        tree.insert(-5);
        tree.insert(-2);
        tree.insert(-8);

        System.out.println(tree.toString());
        System.out.println(tree.getHeight());
        System.out.println(tree.contains(-2));
    }
}
