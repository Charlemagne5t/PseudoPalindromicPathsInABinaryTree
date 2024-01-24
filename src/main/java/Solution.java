class Solution {
    public int pseudoPalindromicPaths (TreeNode root) {
        int mask = 1 << root.val;
        int[] res = new int[1];
        dfs(root, mask, res);
        return res[0];

    }
    private void dfs(TreeNode root, int mask, int[] res){
        if(root.left == null && root.right == null){
            if(Integer.bitCount(mask) < 2){
                res[0]++;
            }
            return;
        }


        if(root.left != null){
            mask ^= 1 << root.left.val;
            dfs(root.left, mask, res);
            mask ^= 1 << root.left.val;
        }
        if(root.right != null){
            mask ^= 1 << root.right.val;
            dfs(root.right, mask, res);
        }

    }
}