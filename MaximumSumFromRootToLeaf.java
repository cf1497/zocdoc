package Algorithm;
import data.TreeNode;


public class MaximumSumFromRootToLeaf {
	
	public static void main(String[] args){
		TreeNode n5 = new TreeNode(5);
		TreeNode n2 = new TreeNode(2);
		TreeNode n1 = new TreeNode(1);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		TreeNode n10 = new TreeNode(10);
		
		n5.left = n2;
		n5.right = n1;
		n2.left=n7;
		n2.right=n8;
		n1.right=n10;
		
		System.out.println(sum(n5));
		
	}
	
	public static int sum(TreeNode root){
		
		rec(root);
		return max;
	}
	
	public static int max = 0;
	
	public static void rec(TreeNode root){
		if(root==null) return;
		
		if(root.left==null && root.right==null){
			max = Math.max(max, root.val);
		}
		
		if(root.left!=null) root.left.val = root.val+root.left.val;
		if(root.right!=null) root.right.val = root.val+root.right.val;
		rec(root.left);
		rec(root.right);
	}

}
