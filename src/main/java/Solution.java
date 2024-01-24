class Solution {
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] count = new int[10];
        int[] res = new int[1];
        count[root.val]++;
        dfs(root, count, res);
        return res[0];

    }
    private void dfs(TreeNode root, int[] count, int[] res){
        if(root.left == null && root.right == null){
            boolean odd = false;
            for(int i = 0; i < count.length; i++){
                if(count[i] % 2 == 1){
                    if(odd){
                        return;
                    }else odd = true;
                }
            }
            res[0]++;
            return;
        }


        if(root.left != null){
            count[root.left.val]++;
            dfs(root.left, count, res);
            count[root.left.val]--;
        }
        if(root.right != null){
            count[root.right.val]++;
            dfs(root.right, count, res);
            count[root.right.val]--;
        }



    }
}
