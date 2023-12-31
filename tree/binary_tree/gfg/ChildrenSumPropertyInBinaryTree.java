package com.company.tree.binary_tree.gfg;

// https://www.geeksforgeeks.org/check-for-children-sum-property-in-a-binary-tree/

// Java program to check children sum property

/* A binary tree node has data, pointer to left child
and a pointer to right child */

class ChildrenSumPropertyInBinaryTree {
    static class Node {
        int data;
        Node left, right;

        public Node(int d)
        {
            data = d;
            left = right = null;
        }
    }

    Node root;

    /* returns 1 if children sum property holds for the
    given node and both of its children*/
    int isSumProperty(Node node)
    {

		/* left_data is left child data and right_data is
		for right child data*/
        int left_data = 0, right_data = 0;

		/* If node is NULL or it's a leaf node then
		return true */
        if (node == null
                || (node.left == null && node.right == null))
            return 1;
        else {

			/* If left child is not present then 0 is used
			as data of left child */
            if (node.left != null)
                left_data = node.left.data;

			/* If right child is not present then 0 is used
			as data of right child */
            if (node.right != null)
                right_data = node.right.data;

			/* if the node and both of its children satisfy
			the property return 1 else 0*/
            if ((node.data == left_data + right_data)
                    && (isSumProperty(node.left) != 0)
                    && isSumProperty(node.right) != 0)
                return 1;
            else
                return 0;
        }
    }

    /* Driver code */
    public static void main(String[] args)
    {
        ChildrenSumPropertyInBinaryTree tree = new ChildrenSumPropertyInBinaryTree();
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(2);

        // Function call
        if (tree.isSumProperty(tree.root) != 0)
            System.out.println("The given tree satisfies children" + " sum property");
        else
            System.out.println("The given tree does not satisfy children" + " sum property");
    }
}
