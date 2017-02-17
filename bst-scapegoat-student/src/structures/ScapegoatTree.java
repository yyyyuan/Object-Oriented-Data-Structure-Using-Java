package structures;

import java.util.Stack;

public class ScapegoatTree<T extends Comparable<T>> extends
		BinarySearchTree<T> {
	private int upperBound = 0;
	
	protected Stack<BSTNode<T>> stack = new Stack<BSTNode<T>>();
	
	
	@Override
	public void add(T t) {
		// TODO
		upperBound++;
		
		super.add(t);
		
		if (height() > Math.log(upperBound)/Math.log(1.5)) {

			BSTNode<T> parent;
			BSTNode<T> child;
			BinarySearchTree<T> balance = new BinarySearchTree<>();
			int num;
						
			num = this.secHelper(t);
			
			int index = num - 1;
						
			child = stack.get(index);
			parent = stack.get(index-1);
			
			while (3 * subtreeSize(child) <= 2 * subtreeSize(parent)) {
				index--;
				child = stack.get(index);
				parent = stack.get(index-1);
			}
			
			if (index >= 2) {
				BSTNode<T> base = stack.get(index-2);

				balance.root = parent;
				balance.balance();

				
				if (balance.root.getData().compareTo(base.getData()) <= 0) {
					base.setLeft(balance.root);
				}
				else {
					base.setRight(balance.root);
				}
			}
			else {
				
				balance.root = parent;
				balance.balance();
				
				this.root = balance.root;
			}
			

		}
	}
	
	private int secHelper(T elem) {
		stack.clear();

		BSTNode<T> cur = this.root;
		int count = 0;
		
		while (!elem.equals(cur.getData())) {
			if (elem.compareTo(cur.getData()) < 0) {
				stack.push(cur);
				cur = cur.getLeft();
				count++;
			}
			else {
				stack.push(cur);
				cur = cur.getRight();
				count++;
			}
		}
		
		stack.push(cur);
		count++;
		
		return count;

		}
		
	
	
	@Override
	public boolean remove(T element) {
		// TODO
		if (element == null) {
			throw new NullPointerException("The input is empty!");
		}
		boolean result = contains(element);
		if (result) {
			root = removeFromSubtree(root, element);
			
			int n = size();
			
			if (upperBound > 2 * n) {
				balance();
				upperBound = n;
			}
		}
		
		
		return result;
		
	}
}
