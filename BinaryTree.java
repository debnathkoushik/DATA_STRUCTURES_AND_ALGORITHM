class Node
{
	int key;
	Node left, right, predecessor;

	Node(int item, Node previous_node_address)
	{
		key = item;
		predecessor = previous_node_address;
		left = right = null;
	}

}

class BinaryTree
{
	// Root of Binary Tree
	Node root;

	BinaryTree()
    {
        root = null;
    }


	void treeInsert(Node new_node)
	{
		Node temp_1 = null;
		Node temp_2 = root;

		new_node.key = 12;

		while (temp_2 != null)
		{
			temp_1 = temp_2;
			if (new_node.key < temp_2.key)
			{
				temp_2 = temp_2.left;
			}

			else
			{
				temp_2 = temp_2.right;
			}
		}

		new_node.predecessor = temp_1;

		if (temp_1 == null)
		{
			root = new_node;
		}

		else if (new_node.key < temp_1.key)
		{
			temp_1.left = new_node;
		}

		else
		{
			temp_1.right = new_node;
		}
	}


	void delete(int key)
	{
		Node node = treeSearch(root, key);

		if (node.left == null)
		{
			transplant(node , node.right);
		}

		else if (node.right == null)
		{
			transplant(node, node.left);
		}

		else
		{
			Node new_node = treeMinimum(node.right);

			if (new_node.predecessor != node)
			{
				transplant(new_node, new_node.right);
				new_node.right = node.right;
				new_node.right.predecessor = new_node;
			}
			
			transplant(node, new_node);
			new_node.left = node.left;
			new_node.left.predecessor = new_node;
		}
	}


	Node treeSearch(Node node, int value)
	{
		Node starting_node = node;

		if (starting_node  == null || value == starting_node .key)
		{
			return starting_node ;
		}

		if (value < starting_node.key )
		{
			return treeSearch(starting_node.left, value);
		}

		else
		{
			return treeSearch(starting_node.right, value);
		}
		
	}


	void transplant (Node node_1, Node node_2)
	{
		if (node_1.predecessor == null)
		{
			root = node_2;
		}

		else if (node_1 == node_1.predecessor.left)
		{
			node_1.predecessor.left = node_2;
		}

		else
		{
			node_1.predecessor.right = node_2;
		}

		if (node_2 != null)
		{
			node_2.predecessor = node_1.predecessor;
		}
	}


	Node treeMinimum(Node node)
	{
		while (node.left != null)
		{
			node = node.left;
		}

		return node;
	}


	/* Given a binary tree, print its nodes according to the
	"bottom-up" postorder traversal. */
	void printPostorder(Node node)
	{
		if (node == null)
            return;

		// first recur on left subtree
		printPostorder(node.left);

		// then recur on right subtree
		printPostorder(node.right);

		// now deal with the node
		System.out.print(node.key + " ");
	}

	/* Given a binary tree, print its nodes in inorder*/
	void printInorder(Node node)
	{
		if (node == null)
			return;

		/* first recur on left child */
		printInorder(node.left);

		/* then print the data of node */
		System.out.print(node.key + " ");

		/* now recur on right child */
		printInorder(node.right);
	}

	/* Given a binary tree, print its nodes in preorder*/
	void printPreorder(Node node)
	{
		if (node == null)
			return;

		/* first print data of node */
		System.out.print(node.key + " ");

		/* then recur on left subtree */
		printPreorder(node.left);

		/* now recur on right subtree */
		printPreorder(node.right);
	}

	// Wrappers over above recursive functions
	void printPostorder()
    {
        printPostorder(root);
    }

	void printInorder()
    {
        printInorder(root);
    }

	void printPreorder()
    {
        printPreorder(root);
    }

	// Driver method
	public static void main(String[] args)
	{
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(10, null);
		tree.root.left = new Node(8, tree.root);
		tree.root.right = new Node(13, tree.root);
		tree.root.left.left = new Node(4, tree.root.left);
		tree.root.left.right = new Node(10, tree.root.left);

		Node new_node = new Node(12, null);
		tree.treeInsert(new_node);

		tree.delete(4);
		tree.treeMinimum(tree.root);

		System.out.println("Preorder traversal of binary tree is ");
		tree.printPreorder();

		System.out.println("\nInorder traversal of binary tree is ");
		tree.printInorder();

		System.out.println("\nPostorder traversal of binary tree is ");
		tree.printPostorder();
	}
}
