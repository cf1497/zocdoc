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
		
		return recII(root,0);
		//return max;
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
	
	public static int recII(TreeNode root, int pre){
		if(root==null) return 0;
		pre = pre+root.val;
		if(root.left==null && root.right==null){
			return pre;
		}
		
		int leftSum = recII(root.left,pre);
		int rightSum = recII(root.right,pre);
		
		return Math.max(leftSum, rightSum);
	}

}
