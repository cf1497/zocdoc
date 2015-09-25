package Algorithm;

import data.TreeNode;

public class BinaryTreeMaximumPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		
		System.out.println(maxPathSum(n5));
	}
	
	public static int maxPathSum(TreeNode root){
		rec(root);
		return maxSum;
	}
	
	public static int maxSum = Integer.MIN_VALUE;
	
	public static int rec(TreeNode root){
		if(root==null){
			return 0;
		}
		
		int leftSum = rec(root.left);
		int rightSum = rec(root.right);
		
		int allSum = root.val+leftSum+rightSum;
		
		int sumToNode = Math.max(root.val, root.val+Math.max(leftSum, rightSum));
		
		maxSum = Math.max(maxSum, Math.max(allSum, sumToNode));
		
		return sumToNode;
	}
	
	
	
	
	

}
