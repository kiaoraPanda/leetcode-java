


public class 求根到叶子节点数字之和 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Integer result = 0;
    StringBuffer leafSum = new StringBuffer();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(3);
        TreeNode root3 = new TreeNode(4);
        root.left = root1;
        root.right = root2;
        求根到叶子节点数字之和 a = new 求根到叶子节点数字之和();
        int r = a.sumNumbers(root);
        System.out.println(r);
    }

    public int sumNumbers(TreeNode root) {
        return dfs(root,0);
    }
    private int dfs(TreeNode root ,int prevSum) {
        if (root == null) {
            return 0;
        }
        int sum = prevSum *10 + root.val;
        if (root.left == null || root.right == null){
            return sum;
        }else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }
}
