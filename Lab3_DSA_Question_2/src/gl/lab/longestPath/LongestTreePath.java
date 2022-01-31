package gl.lab.longestPath;
import java.util.ArrayList;

/* Program to find longest path in a binary tree.
 * Note 1. Node class is enclosed within driver class.
 */
public class LongestTreePath {

	public static void main(String[] args) {
		
		//creating tree
		Node root = new Node(100);
		root.left = new Node(20);
		root.left.left = new Node(10);
		root.left.right = new Node(50);
		root.left.left.left = new Node(5);
		root.right = new Node(130);
		root.right.left = new Node(110);
		root.right.right  = new Node(140);

		// finding longest path
		ArrayList<Integer> longest = traverse(root);
		
		// printing longest path
		display(longest);
	}
	
	static void display(ArrayList<Integer> lngst) {
		for (int i = lngst.size()-1; i >= 0; i--) {
			System.out.print(lngst.get(i) + " ");
			if (i > 0)
				System.out.print("->" + " ");
		}
	}
	
	// method finds the longest root by accepting the root node as parameter 
	// and returns array list of longest path
	static ArrayList<Integer> traverse(Node root) {
		ArrayList<Integer> rslt = new ArrayList<Integer>();
		if (root == null)
			return rslt;
		
		ArrayList<Integer> left = traverse(root.left);
		ArrayList<Integer> right = traverse(root.right);
		
		if (left.size() > right.size()) {
			left.add(root.data);
		}
		else {
			right.add(root.data);
		}
		rslt = left.size()>right.size()? left : right;
		return rslt;
	}
	
	// Class node
	static class Node{
		int data;
		Node left;
		Node right;
		
		Node(int data){
			this.data = data;
			left = right = null;
		}
	}

}

