package sankar.ojili.java.algos.fbleet;

public class LowestCommonAncestor {

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

class LowestCommonAncestorSolution {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if ((right != null && left != null) || root.val == p.val || root.val == q.val) {
			return root;
		}
		return left != null ? left : right;
	}
}
