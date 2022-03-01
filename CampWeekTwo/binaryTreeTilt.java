// import javax.swing.tree.TreeNode;


 
 
class binaryTreeTilt {
    int sumOfDiff = 0;
    public int findTilt(TreeNode root) {
        helper(root);
        return sumOfDiff;
    }
    
    public int helper(TreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right == null)
            return root.val;

          int left = helper(root.left);
          int right = helper(root.right);
          sumOfDiff += Math.abs(left - right);
        return left + right + root.val;
    }
}