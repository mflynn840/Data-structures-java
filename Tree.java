

public class Tree{

  
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
      
        public TreeNode(int val){this.val = val;);
        public TreeNode(int val, int left, int right){this.val = val, this.left = left, this.right = right});
                            
    }

    TreeNode root;

    public Tree(int rootValue){

        this.root = new TreeNode(rootValue);
      
    }

    
}

  
