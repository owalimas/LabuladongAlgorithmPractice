package com.jungle.exam.goodme;

/**
 * @Description
 * @Author Jungle
 * @DATE 2022/10/5
 **/
public class Interview02 {
    // 通过前序遍历和中序遍历能够确认一个二叉树
    // 给我前序遍历和中序遍历的数组，输出后续遍历结果

    public static void main(String[] args) {
        int[] preOrder = new int[]{1, 2, 4, 5, 3};

    }

    public static TreeNode traverse(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd) {
        //先确定根节点，在确定左右子树
        int rootValue = preOrder[preStart];
        TreeNode root = new TreeNode(rootValue);
        //确认根节点在中序遍历中的位置
        int rootIndex = findRootIndex(inOrder, rootValue, inStart, inEnd);
        int gap = rootIndex - inStart;
        //递归构建左右子树
        TreeNode left = traverse(preOrder, preStart + 1, preStart + gap + 1, inOrder, inStart, inStart + gap);
        TreeNode right = traverse(preOrder, preStart + gap, preEnd, inOrder, rootIndex+1, inEnd);
        //模拟最后一次递归后，左右子树都确认了，只需要连接了
        root.left = left;
        root.right = right;
        return root;
    }

    //找到根的位置,中序中未找到返回-1
    private static int findRootIndex(int[] inOrder, int root, int inStart, int inEnd) {
        for (int i = inStart; i <= inEnd; i++) {
            if (inOrder[i] == root) {
                return i;
            }
        }
        return -1;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
