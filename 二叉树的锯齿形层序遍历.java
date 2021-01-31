import java.util.ArrayList;
import java.util.List;

public class 二叉树的锯齿形层序遍历 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> oneFloor = new ArrayList<>();
        oneFloor.add(root.val);
        result.add(oneFloor);
        while (true){
            List<Integer> eFloor = new ArrayList<>();
            eFloor.add(root.right.val);
            eFloor.add(root.left.val);
            break;
        }

        return null;
    }
    private void leftProcess(TreeNode root , List<Integer> result){
        if (root == null){
            return;
        }
        result.add(root.val);
        leftProcess(root.left ,result);
        leftProcess(root.right,result);
    }
    private void rigthProcess(TreeNode root , List<Integer> result){
        if (root == null){
            return;
        }
        result.add(root.val);
        rigthProcess(root.left ,result);
        rigthProcess(root.right,result);
    }
}



