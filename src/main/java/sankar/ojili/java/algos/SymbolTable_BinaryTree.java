package sankar.ojili.java.algos;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * This class is an implementation of SymbolTable based on Binary Search Tree
 * 
 * @author lojili
 *
 * @param <K>
 * @param <V>
 */
public class SymbolTable_BinaryTree<K extends Comparable<K>, V> {
	Node<K, V> root;

	/**
	 * Add the key value pair to the Table
	 */
	void put(K key, V value) {
		root = put(root, key, value);
	}

	Node<K, V> put(Node<K, V> root, K key, V value) {
		if (root == null) {
			return new Node<>(key, value, 1);
		}
		int diff = root.key.compareTo(key);
		if (diff < 0) {
			root.right = put(root.right, key, value);
		} else if (diff > 0) {
			root.left = put(root.left, key, value);
		} else {
			root.value = value;
		}
		root.size = 1 + size(root.left) + size(root.right);
		return root;
	}

	/**
	 * 
	 * @param key
	 * @return
	 */
	V get(K key) {
		return get(root, key);
	}

	private V get(Node<K, V> root, K key) {
		if (root == null) {
			return null;
		}
		int diff = root.key.compareTo(key);
		if (diff == 0) {
			return root.value;
		} else if (diff < 0) {
			return get(root.right, key);
		}
		return get(root.left, key);
	}

	/**
	 *
	 * @return number of nodes in the Table
	 */
	int size() {
		return size(root);
	}

	private int size(Node<K, V> node) {
		if (node == null) {
			return 0;
		}
		return node.size;
	}

	/**
	 * Rank of the given key in the table i.e. the number of keys that are less than
	 * the given key in the table. Returns 0 if the key is not present in the node
	 * or if the key is the lowest of the keys in the Table.
	 */
	int rank(K key) {
		return rank(root, key);
	}

	private int rank(Node<K, V> root, K key) {
		if (root == null) {
			return 0;
		}
		int cmp = root.key.compareTo(key);
		if (cmp < 0) {
			return 1 + size(root.left) + rank(root.right, key);
		} else if (cmp > 0) {
			return rank(root.left, key);
		}

		return size(root.left);
	}

	void deleteMin() throws NoSuchElementException {
		if (root == null) {
			throw new NoSuchElementException("Table is Empty");
		}
		root = deleteMin(root);
	}

	Node<K, V> deleteMin(Node<K, V> root) {
		if (root.left == null) {
			return root.right;
		}
		root.left = deleteMin(root.left);
		root.size = 1 + size(root.left) + size(root.right);
		return root;

	}

	void deleteMax() throws NoSuchElementException {
		if (root == null) {
			throw new NoSuchElementException("Table is Empty");
		}
		root = deleteMax(root);
	}

	Node<K, V> deleteMax(Node<K, V> root) {
		if (root.right == null) {
			return root.left;
		}
		root.right = deleteMax(root.right);
		root.size = 1 + size(root.left) + size(root.right);
		return root;

	}

	void delete(K key) throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException("Table is Empty");
		}
		root = delete(root, key);

	}

	Node<K, V> delete(Node<K, V> root, K key) {
		if (root == null) {
			return null;
		}
		print();
		int cmp = root.key.compareTo(key);
		if (cmp < 0) {
			root.right = delete(root.right, key);
		} else if (cmp > 0) {
			root.left = delete(root.left, key);
		} else {
			if (root.right == null) {
				return root.left;
			} else if (root.left == null) {
				return root.right;
			}
			Node<K, V> replacement = min(root.right);
			root.right = delete(root.right, replacement.key);
			root.key = replacement.key;
			root.value = replacement.value;
		}
		return root;
	}

	boolean isEmpty() {
		return root == null;
	}

	Node<K, V> min() throws NoSuchElementException {
		if (root == null) {
			throw new NoSuchElementException("Table is Empty");
		}
		return min(root);
	}

	Node<K, V> min(Node<K, V> root) {
		if (root.left == null) {
			return root;
		}
		return min(root.left);
	}

	Node<K, V> max() throws NoSuchElementException {
		if (root == null) {
			throw new NoSuchElementException("Table is Empty");
		}
		Node<K, V> start = root;
		while (start.right != null) {
			start = start.right;
		}
		return start;
	}

	K floor(K key) {
		return floor(root, key);
	}

	K floor(Node<K, V> node, K key) {
		if (node == null) {
			return null;
		}
		int cmp = node.key.compareTo(key);
		if (cmp < 0 && node.right != null && node.right.key.compareTo(key) <= 0) {
			return floor(node.right, key);
		} 
		if (cmp > 0) {
			return floor(node.left, key);
		}
		return node.key;
	}
	
	
	
	K ceiling(Node<K,V> node, K key, K ceiling) {
		if (node == null) {
			return ceiling;
		}
		int cmp = node.key.compareTo(key);
		if (cmp > 0) {
			return ceiling(node.right, key, node.key);
		} else if (cmp < 0) {
			return ceiling(node.left, key, node.key);
		}
		return node.key;
	}

	void print() {
		Queue<K> queue = new LinkedList<>();
		enqueue(root, queue);
		System.out.println(queue);
	}

	void enqueue(Node<K, V> root, Queue<K> queue) {
		if (root == null) {
			return;
		}
		enqueue(root.left, queue);
		queue.add(root.key);
		enqueue(root.right, queue);
	}

}

class Node<K extends Comparable<K>, V> {
	Node(K key, V value, int size) {
		this.key = key;
		this.value = value;
		this.size = size;
	}

	K key;
	V value;
	Node<K, V> left;
	Node<K, V> right;
	int size;
}
