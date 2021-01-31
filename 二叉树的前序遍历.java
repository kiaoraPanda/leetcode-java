import java.util.LinkedList;
import java.util.List;

public class 二叉树的前序遍历 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        eleProcess(root,result);
        return result;
    }

    private void eleProcess(TreeNode root , List<Integer> result){
        if (root == null){
            return;
        }
        result.add(root.val);
        eleProcess(root.left ,result);
        eleProcess(root.right,result);
    }
}

 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
