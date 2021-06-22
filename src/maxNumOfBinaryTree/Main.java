package maxNumOfBinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class TreeNode{
    int val;
    TreeNode left, right;
    TreeNode(int x){
        this.val = x;
    }
}

public class Main {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(1);
        tree.right = new TreeNode(4);
        tree.left.left = new TreeNode(5);
        tree.left.right = new TreeNode(8);
        tree.left.left.left = new TreeNode(7);
        Main a = new Main();
        //System.out.println(a.MaxDepth(tree));
        //System.out.println(a.dfs(tree));
        //System.out.println(a.bfs(tree));
    }

    public int bfs(TreeNode root){
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int max = 1;
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if(temp.left != null){
                queue.offer(temp.left);
            }
            if(temp.right != null){
                queue.offer(temp.right);
            }
            if(temp.left != null || temp.right != null)
                max++;

        }
        return max;
    }

    public int dfs(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> valueStack = new Stack<>();
        stack.push(root);
        valueStack.push(1);
        int max = 0;
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            int count = valueStack.pop();
            max = count;
            if(node.left != null){
                stack.push(node.left);
                valueStack.push(count+1);
            }
            if(node.right != null){
                stack.push(node.right);
                valueStack.push(count+1);
            }
        }
        return max;
    }

    public int MaxDepth(TreeNode root){
        if(root == null)
            return 0;
        int leftMax=MaxDepth(root.left);
        int rightMax=MaxDepth(root.right);
        return Math.max(leftMax,rightMax)+1;
    }
}
