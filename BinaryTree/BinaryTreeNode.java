public class BinaryTreeNode {
    private int value;
    private BinaryTreeNode left;
    private BinaryTreeNode right;

    BinaryTreeNode(int value) {
        this.value = value;
    }

    public void insert(int value) {
        if (this.value > value) {
            if (left == null) {
                left = new BinaryTreeNode(value);
            } else {
                left.insert(value);
            }
        } else {
            if (right == null) {
                right = new BinaryTreeNode(value);
            } else {
                right.insert(value);
            }
        }
    }

    public int getHeight() {
        if (left == null && right == null) return 1;

        int leftHeight = 0;
        int rightHeight = 0;

        if (left != null) {
            leftHeight = left.getHeight();
        }
        if (right != null) {
            rightHeight = right.getHeight();
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean contains(int value) {
        if (value < this.value) {
            if (left == null) return false;
            return left.contains(value);
        } else if (value > this.value) {
            if (right == null) return false;
            return right.contains(value);
        }

        return true;
    }

    public String toString() {
        return "{" + left + "} " + value + " { " + right + " } ";
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(0);
        root.insert(-2);
        root.insert(2);
        root.insert(1);
        System.out.println(root);

        System.out.println(root.getHeight());
        System.out.println(root.contains(-3) + " " + root.contains(2));
    }
}





