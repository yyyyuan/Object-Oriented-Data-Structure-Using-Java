package structures;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable<T>> implements
		BSTInterface<T> {
	protected BSTNode<T> root;
	
	protected T[] array;
	protected BinarySearchTree<T> balanceTree;
	protected Iterator<T> inorder;
	
	public BinarySearchTree () {
		root = null;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public int size() {
		return subtreeSize(root);
	}

	protected int subtreeSize(BSTNode<T> node) {
		if (node == null) {
			return 0;
		} else {
			return 1 + subtreeSize(node.getLeft())
					+ subtreeSize(node.getRight());
		}
	}

	
	public boolean contains(T t) {
		// TODO
		if (t == null) {
			throw new NullPointerException("The input is empty!");
		}
		else {
			return (get(t) != null);
		}
		
	}

	public boolean remove(T t) {
		if (t == null) {
			throw new NullPointerException();
		}
		boolean result = contains(t);
		if (result) {
			root = removeFromSubtree(root, t);
		}
		return result;
	}

	protected BSTNode<T> removeFromSubtree(BSTNode<T> node, T t) {
		// node must not be null
		
		
		int result = t.compareTo(node.getData());
		if (result < 0) {
			node.setLeft(removeFromSubtree(node.getLeft(), t));
			return node;
		} else if (result > 0) {
			node.setRight(removeFromSubtree(node.getRight(), t));
			return node;
		} else { // result == 0
			if (node.getLeft() == null) {
				return node.getRight();
			} else if (node.getRight() == null) {
				return node.getLeft();
			} else { // neither child is null
				T predecessorValue = getHighestValue(node.getLeft());
				node.setLeft(removeRightmost(node.getLeft()));
				node.setData(predecessorValue);
				return node;
			}
		}
	}

	private T getHighestValue(BSTNode<T> node) {
		// node must not be null
		if (node.getRight() == null) {
			return node.getData();
		} else {
			return getHighestValue(node.getRight());
		}
	}

	private BSTNode<T> removeRightmost(BSTNode<T> node) {
		// node must not be null
		if (node.getRight() == null) {
			return node.getLeft();
		} else {
			node.setRight(removeRightmost(node.getRight()));
			return node;
		}
	}

	public T get(T t) {
		// TODO
		if (t == null) {
			throw new NullPointerException("The input is empty!");
		}
		else {
			return recGet(t, root);
		}
		
	}
	
	  private T recGet(T element, BSTNode<T> tree)
	  // Returns an element e from tree such that e.compareTo(element) == 0;
	  // if no such element exists, returns null.
	  {
	    if (tree == null)
	      return null;             // element is not found
	    else if (element.compareTo(tree.getData()) < 0)
	      return recGet(element, tree.getLeft());          // get from left subtree
	    else if (element.compareTo(tree.getData()) > 0)
	      return recGet(element, tree.getRight());         // get from right subtree
	    else
	      return tree.getData();  // element is found
	  }


	public void add(T t) {
		if (t == null) {
			throw new NullPointerException("wtf");
		}
		root = addToSubtree(root, new BSTNode<T>(t, null, null));
	}

	protected BSTNode<T> addToSubtree(BSTNode<T> node, BSTNode<T> toAdd) {
		if (node == null) {
			return toAdd;
		}
		int result = toAdd.getData().compareTo(node.getData());
		if (result <= 0) {
			node.setLeft(addToSubtree(node.getLeft(), toAdd));
		} else {
			node.setRight(addToSubtree(node.getRight(), toAdd));
		}
		return node;
	}

	@Override
	public T getMinimum() {
		// TODO
		if (isEmpty()) {
			return null;
		}
		else {
			BSTNode<T> cur = root; 
			while (cur.getLeft() != null) {
				cur = cur.getLeft();
			}
			
			return cur.getData();
		}
	}


	@Override
	public T getMaximum() {
		// TODO
		if (isEmpty()) {
			return null;
		}
		else {
			BSTNode<T> cur = root;
			while (cur.getRight() != null) {
				cur = cur.getRight();
			}
			
			return cur.getData();
		}
		
	}


	@Override
	public int height() {
		// TODO
		if (isEmpty()) {
			return -1;
		}
		else {
			return subtreeHeight(root);
		}
	}
	
	private int subtreeHeight(BSTNode<T> node) {
		if (node.getLeft() == null && node.getRight() == null) {
			return 0;
		}
		else if (node.getLeft() != null && node.getRight() == null) {
			return 1 + subtreeHeight(node.getLeft());
		}
		else if (node.getLeft() == null && node.getRight() != null) {
			return 1 + subtreeHeight(node.getRight());
		}
		else {
			return 1 + Math.max(subtreeHeight(node.getLeft()), subtreeHeight(node.getRight()));
		}
	}


	public Iterator<T> preorderIterator() {
		// TODO
		Queue<T> queue = new LinkedList<T>();
		preorderTraverse(queue, root);
		return queue.iterator();
	}
	
	private void preorderTraverse(Queue<T> queue, BSTNode<T> node) {
		if (node != null) {
			queue.add(node.getData());
			preorderTraverse(queue, node.getLeft());
			preorderTraverse(queue, node.getRight());
		}
	}

	public Iterator<T> inorderIterator() {
		Queue<T> queue = new LinkedList<T>();
		inorderTraverse(queue, root);
		return queue.iterator();
	}


	private void inorderTraverse(Queue<T> queue, BSTNode<T> node) {
		if (node != null) {
			inorderTraverse(queue, node.getLeft());
			queue.add(node.getData());
			inorderTraverse(queue, node.getRight());
		}
	}

	public Iterator<T> postorderIterator() {
		// TODO
		Queue<T> queue = new LinkedList<T>();
		postorderTraverse(queue, root);
		return queue.iterator();
	}

	private void postorderTraverse(Queue<T> queue, BSTNode<T> node) {
		if (node != null) {
			postorderTraverse(queue, node.getLeft());
			postorderTraverse(queue, node.getRight());
			queue.add(node.getData());
		}
	}

	@Override
	public boolean equals(BSTInterface<T> other) {
		// TODO
		if (other == null) {
			throw new NullPointerException("The input is empty!");
		}
		else {
			BSTNode<T> root1 = this.root;
			BSTNode<T> root2 = other.getRoot();
			
			return equalsHelp(root1, root2);
		}
		
	}
	
	private boolean equalsHelp(BSTNode<T> elem1, BSTNode<T> elem2) {
		if (elem1 != null && elem2 == null) {
			return false;
		}
		else if (elem1 == null && elem2 != null) {
			return false;
		}
		else if (elem1 == null && elem2 == null) {
			return true;
		}
		else {
			if (!elem1.getData().equals(elem2.getData())) {
				return false;
			}
			else {
				return equalsHelp(elem1.getLeft(), elem2.getLeft()) && equalsHelp(elem1.getRight(), elem2.getRight()); 
			}

		}
	}


	@Override
	public boolean sameValues(BSTInterface<T> other) {
		// TODO
		if (other == null) {
			throw new NullPointerException("The input is empty!");
		}
		else {
			
			Iterator<T> tree1 = this.inorderIterator();
			Iterator<T> tree2 = other.inorderIterator();
			
			
			
			while (tree1.hasNext() && tree2.hasNext()) {
				if (!(tree1.next().equals(tree2.next()))) {
					return false;
				}
			}
			
			if (tree1.hasNext() || tree2.hasNext()) {
				return false;
			}
			else {
				return true;
			}		
		}

			
	}

	@Override
	public boolean isBalanced() {
		// TODO
		if (isEmpty()) {
			return true;
		}
		else {
			
			int n = size();
			int h = height();
			
			if (Math.pow(2, h) <= n && n < Math.pow(2, h+1)) {
				return true;
			}
			else 
				return false;
		}


	}

	@Override

	public void balance() {
		// TODO
		if (!isEmpty()) {
			balanceTree = new BinarySearchTree<T>();

			
			inorder = this.inorderIterator();
			int n = size();
			array = (T[]) new Comparable[n];
			
			for (int index = 0; index < n; index++) {
				array[index] = (T) inorder.next();
			}
			
			insertTree(0, n-1);
			
			this.root = balanceTree.root;
		}

		
	}
	
	private void insertTree(int low, int high) {
		//Base case 1
		if (low == high) {
			balanceTree.add(array[low]);
		}
		//Base case 2
		else if ((low + 1) == high) {
			balanceTree.add(array[low]);
			balanceTree.add(array[high]);
		}
		else {
			int mid = (low + high)/2;
			balanceTree.add(array[mid]);
			insertTree(low, mid - 1);
			insertTree(mid + 1, high);
		}
	}


	@Override
	public BSTNode<T> getRoot() {
        // DO NOT MODIFY
		return root;
	}

	public static <T extends Comparable<T>> String toDotFormat(BSTNode<T> root) {
		// header
		int count = 0;
		String dot = "digraph G { \n";
		dot += "graph [ordering=\"out\"]; \n";
		// iterative traversal
		Queue<BSTNode<T>> queue = new LinkedList<BSTNode<T>>();
		queue.add(root);
		BSTNode<T> cursor;
		while (!queue.isEmpty()) {
			cursor = queue.remove();
			if (cursor.getLeft() != null) {
				// add edge from cursor to left child
				dot += cursor.getData().toString() + " -> "
						+ cursor.getLeft().getData().toString() + ";\n";
				queue.add(cursor.getLeft());
			} else {
				// add dummy node
				dot += "node" + count + " [shape=point];\n";
				dot += cursor.getData().toString() + " -> " + "node" + count
						+ ";\n";
				count++;
			}
			if (cursor.getRight() != null) {
				// add edge from cursor to right child
				dot += cursor.getData().toString() + " -> "
						+ cursor.getRight().getData().toString() + ";\n";
				queue.add(cursor.getRight());
			} else {
				// add dummy node
				dot += "node" + count + " [shape=point];\n";
				dot += cursor.getData().toString() + " -> " + "node" + count
						+ ";\n";
				count++;
			}

		}
		dot += "};";
		return dot;
	}

	public static void main(String[] args) {
		for (String r : new String[] { "a", "b", "c", "d", "e", "f", "g" }) {
			BSTInterface<String> tree = new BinarySearchTree<String>();
			for (String s : new String[] { "d", "b", "a", "c", "f", "e", "g" }) {
				tree.add(s);
			}
			Iterator<String> iterator = tree.inorderIterator();
			while (iterator.hasNext()) {
				System.out.print(iterator.next());
			}
			System.out.println();
			iterator = tree.preorderIterator();
			while (iterator.hasNext()) {
				System.out.print(iterator.next());
			}
			System.out.println();
			iterator = tree.postorderIterator();
			while (iterator.hasNext()) {
				System.out.print(iterator.next());
			}
			System.out.println();

			System.out.println(tree.remove(r));

			iterator = tree.inorderIterator();
			while (iterator.hasNext()) {
				System.out.print(iterator.next());
			}
			System.out.println();
		}

		BSTInterface<String> tree = new BinarySearchTree<String>();
		for (String r : new String[] { "a", "b", "c", "d", "e", "f", "g" }) {
			tree.add(r);
		}
		System.out.println(tree.size());
		System.out.println(tree.height());
		System.out.println(tree.isBalanced());
		tree.balance();
		System.out.println(tree.size());
		System.out.println(tree.height());
		System.out.println(tree.isBalanced());
	}
}