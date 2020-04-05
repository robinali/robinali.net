/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // BFS Level Traversal + Queue
    // Reference: https://leetcode.com/problems/deepest-leaves-sum/discuss/463239/JavaC%2B%2BPython-Level-Traversal
    public int deepestLeavesSum0(TreeNode root) {
        int deepestSum = 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            deepestSum = 0;
            for(int i = queue.size() - 1; i >= 0; i--) {
                TreeNode node = queue.poll();
                deepestSum += node.val;
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
        }
        return deepestSum;
    }

    // DFS Preorder Traversal + Recursion
    // https://leetcode-cn.com/problems/deepest-leaves-sum/solution/shen-du-you-xian-sou-suo-yan-du-you-xian-sou-suo-3/
    private int deepestSum;
    private int maxLevel;
    private void deepestLeavesSum(TreeNode node, int level) {
        if(node == null) return;
        if(level == maxLevel) {
            deepestSum += node.val;
        }
        else if(level > maxLevel) {
            deepestSum = node.val;
            maxLevel = level;
        }
        deepestLeavesSum(node.left, level + 1);
        deepestLeavesSum(node.right, level + 1);
    }

    public int deepestLeavesSum1(TreeNode root) {
        this.deepestSum = 0;
        this.maxLevel = 0;
        deepestLeavesSum(root, 0);
        return deepestSum;
    }

    // DFS Preorder Traversal + Stack
    // Reference: https://leetcode.com/problems/deepest-leaves-sum/solution/
    public int deepestLeavesSum(TreeNode root) {
        int deepestSum = 0, maxDepth = 0;
        LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        stack.push(new Pair(root, 0));
        while(!stack.isEmpty()) {
            Pair<TreeNode, Integer> pair = stack.pop();
            TreeNode node = pair.getKey();
            int curDepth = pair.getValue();

            if(node.left == null && node.right == null) {
                if(maxDepth == curDepth) {
                    deepestSum += node.val;
                } else if(maxDepth < curDepth) {
                    deepestSum = node.val;
                    maxDepth = curDepth;
                }
            } else {
                if(node.left != null) {
                    stack.push(new Pair(node.left, curDepth + 1));
                }
                if(node.right != null) {
                    stack.push(new Pair(node.right, curDepth + 1));
                }
            }
        }
        return deepestSum;
    }
}