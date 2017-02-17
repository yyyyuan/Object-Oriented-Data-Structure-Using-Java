package structures;

interface BSTNodeInterface<T extends Comparable<T>> {
	T getData();

	void setData(T data);

	BSTNode<T> getLeft();

	void setLeft(BSTNode<T> left);

	BSTNode<T> getRight();

	void setRight(BSTNode<T> right);
}
