package Exercise05;

import java.util.LinkedList;
import java.util.Queue;

public class Node {

 public Node up, left, right;
 

 // assume the existence of a reasonable constructor, etc.

 public boolean isLeft() {

 return (up != null && this == up.left);

 }

 public boolean isRight() {

 return (up != null && this == up.right);

 }

 
public Node nextInorder() {

// if there is a right subtree,

// return inorder-first descendant of right subtree

 if (right != null) {

 Node cur = right;

 while (cur.left != null)
 cur = cur.left;

 return cur;

 }


 // otherwise, find the parent of lowest ancestor that

 // is a left child, or null if there is no such ancestor

 Node anc = this;

 while (anc.isRight())
 anc = anc.up;

 return anc.up;
 
}

	//Question1
	public Node nextPreorder() {

		if (left != null) {
			return left;
		}
		
		else if (right != null) {
			return right;
		}
		else {
			Node anc = this;
			
			while (anc.up != null) {
				if (anc.isLeft()) {
					if (anc.up.right != null) {
						return anc.up.right;
					}
					else {
						anc = anc.up;
					}	
				}
				else {
					if (anc.up.up == null) {
						return null;
					}
					else if (anc.up.isLeft()) {
						if (anc.up.up.right != null) {
							return anc.up.up.right;
						}
						else {
							anc = anc.up;
						}
					}
					else {
						anc = anc.up;
					}
				}
			}
			
			return null;
		}
	}

	//Question2
	public Node nextPostOrder() {

		
		Node anc = this;
		
		while (anc.up != null) {
			if (anc.isLeft()) {
				if (anc.up.right != null) {
					Node cur = anc.up.right;
					while (cur.left != null || cur.right != null) {
						if (cur.left != null) {
							cur = cur.left;
						}
						else {
							cur = cur.right;
						}
					}

					return cur;				
					
				}
				else
					return anc.up;
			}
			else {
				return anc.up;	
			}
		}
		
		return null;
		
	}
	
	//Question3
	public Node nextLevelOrder() {
		
		int count = 0;
		Node cur = this;
		
		if (cur.up == null) {
			return firstDesc(1);
		}
		
		while (cur != null) {
			if (cur.isLeft()) {
				if (cur.up.right != null) {
					if (cur.up.right.firstDesc(count) == null) {
						cur = cur.up;
						count++;
					}
					else {
						return cur.up.right.firstDesc(count);
					}
				}
				else {
					cur = cur.up;
					count++;
				}
			}
			else if (cur.isRight()){
				cur = cur.up;
				count++;
			}
			else {
				count++;
				return cur.firstDesc(count);
			}
		}
		
		return null;
		
	}
	
	
	public Node firstDesc(int depth) {
		Node cur = this;
		if (depth < 0) {
			throw new IllegalArgumentException("The depth can not be less than 0");
		}
		
		while (depth != 0) {
			if (cur.left != null) {
				cur = cur.left;
			}
			else if (cur.right != null)
				cur = cur.right;
			else 
				return null;
			depth--;
		}
		
		return cur;
	}
	
}