// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode(int x) { val = x; }
//  * }
//  */
// class Solution {
//     private int count = 0; 

//     public int kthSmallest(TreeNode root, int k) {
//         TreeNode result = helper(root, k);
//         return result != null ? result.val : 0; 
//     }

//     private TreeNode helper(TreeNode root, int k) {
//         if (root == null) return null;
//         TreeNode left = helper(root.left, k);
//         if (left != null) return left; 

//         count++; 
//         if (count == k) return root; 
//         return helper(root.right, k);
//     }
//}



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // Helper function to perform inorder traversal and store elements in an ArrayList
    public void inorder(TreeNode root, ArrayList<Integer> arr) {
        // Base case: if the node is null, return
        if (root == null) {
            return;
        }
        // Recursively visit the left subtree
        inorder(root.left, arr);
        // Add the current node's value to the list (in sorted order)
        arr.add(root.val);
        // Recursively visit the right subtree
        inorder(root.right, arr);
    }

    // Function to find the kth smallest element in a BST
    public int kthSmallest(TreeNode root, int k) {
        // Create an ArrayList to store inorder traversal elements
        ArrayList<Integer> fin = new ArrayList<>();
        // Perform inorder traversal (stores elements in sorted order)
        inorder(root, fin);
        // Return the (k-1)th element, as array index starts from 0
        return fin.get(k - 1);
    }
}