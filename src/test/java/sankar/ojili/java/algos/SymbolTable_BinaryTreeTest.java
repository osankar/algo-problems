package sankar.ojili.java.algos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

public class SymbolTable_BinaryTreeTest {
	@Test
	void put() {
		SymbolTable_BinaryTree<Integer, String> classUnderTest = new SymbolTable_BinaryTree<>();
		classUnderTest.put(5, "Five");
		classUnderTest.put(4, "Four");
		classUnderTest.put(6, "Six");
		classUnderTest.put(3, "Three");
		classUnderTest.put(1, "One");
		classUnderTest.print();
	}
	
	@Test
	void get() {
		SymbolTable_BinaryTree<Integer, String> classUnderTest = new SymbolTable_BinaryTree<>();
		classUnderTest.put(5, "Five");
		classUnderTest.put(4, "Four");
		classUnderTest.put(6, "Six");
		classUnderTest.put(3, "Three");
		classUnderTest.put(1, "One");
		classUnderTest.put(10, "Ten");
		assertEquals("One", classUnderTest.get(1));
		assertEquals("Six", classUnderTest.get(6));
	}
	
	@Test
	void rank() {
		SymbolTable_BinaryTree<Integer, String> classUnderTest = new SymbolTable_BinaryTree<>();
		classUnderTest.put(5, "Five");
		classUnderTest.put(4, "Four");
		classUnderTest.put(6, "Six");
		classUnderTest.put(3, "Three");
		classUnderTest.put(1, "One");
		classUnderTest.put(10, "Ten");
		assertEquals(0, classUnderTest.rank(1));
		assertEquals(5, classUnderTest.rank(10));
	}
	
	@Test 
	void deleteMin() {
		SymbolTable_BinaryTree<Integer, String> classUnderTest = new SymbolTable_BinaryTree<>();
		classUnderTest.put(5, "Five");
		classUnderTest.put(4, "Four");
		classUnderTest.put(6, "Six");
		classUnderTest.put(3, "Three");
		classUnderTest.put(1, "One");
		classUnderTest.put(10, "Ten");
		try {
			classUnderTest.deleteMin();
		} catch (NoSuchElementException e) {
		}
			
		assertNull(classUnderTest.get(1));
		assertEquals(5, classUnderTest.size());
		
		try {
			classUnderTest.deleteMin();
		} catch (NoSuchElementException e) {
		}
			
		assertNull(classUnderTest.get(3));
		assertEquals(4, classUnderTest.size());
		classUnderTest.print();
	}
	
	@Test 
	void deleteMax() {
		SymbolTable_BinaryTree<Integer, String> classUnderTest = new SymbolTable_BinaryTree<>();
		classUnderTest.put(5, "Five");
		classUnderTest.put(4, "Four");
		classUnderTest.put(6, "Six");
		classUnderTest.put(3, "Three");
		classUnderTest.put(1, "One");
		classUnderTest.put(10, "Ten");
		try {
			classUnderTest.deleteMax();
		} catch (NoSuchElementException e) {
		}
			
		assertNull(classUnderTest.get(10));
		assertEquals(5, classUnderTest.size());
		
		try {
			classUnderTest.deleteMax();
		} catch (NoSuchElementException e) {
		}
			
		assertNull(classUnderTest.get(6));
		assertEquals(4, classUnderTest.size());
		classUnderTest.print();
	}
	
	@Test
	void min() throws NoSuchElementException{
		SymbolTable_BinaryTree<Integer, String> classUnderTest = new SymbolTable_BinaryTree<>();
		classUnderTest.put(5, "Five");
		classUnderTest.put(4, "Four");
		classUnderTest.put(6, "Six");
		classUnderTest.put(3, "Three");
		classUnderTest.put(1, "One");
		classUnderTest.put(10, "Ten");
		Node<Integer, String> minNode = classUnderTest.min();
		int minKey = minNode.key;
		assertEquals(1,minKey);
		
		classUnderTest.deleteMin();
		minNode = classUnderTest.min();
		minKey = minNode.key;
		assertEquals(3,minKey);
		
	}
	
	@Test
	void max() throws NoSuchElementException{
		SymbolTable_BinaryTree<Integer, String> classUnderTest = new SymbolTable_BinaryTree<>();
		classUnderTest.put(5, "Five");
		classUnderTest.put(4, "Four");
		classUnderTest.put(6, "Six");
		classUnderTest.put(3, "Three");
		classUnderTest.put(1, "One");
		classUnderTest.put(10, "Ten");
		Node<Integer, String> maxNode = classUnderTest.max();
		int maxKey = maxNode.key;
		assertEquals(10,maxKey);
		
		classUnderTest.deleteMax();
		maxNode = classUnderTest.max();
		maxKey = maxNode.key;
		assertEquals(6,maxKey);
		
	}
	
	@Test
	void delete() throws NoSuchElementException{
		SymbolTable_BinaryTree<Integer, String> classUnderTest = new SymbolTable_BinaryTree<>();
		classUnderTest.put(5, "Five");
		classUnderTest.put(4, "Four");
		classUnderTest.put(6, "Six");
		classUnderTest.put(3, "Three");
		classUnderTest.put(1, "One");
		classUnderTest.put(10, "Ten");
		
		classUnderTest.delete(5);
		classUnderTest.print();
		
	}
	
	@Test	
	void floor() {
		SymbolTable_BinaryTree<Integer, String> classUnderTest = new SymbolTable_BinaryTree<>();
		classUnderTest.put(5, "Five");
		classUnderTest.put(4, "Four");
		classUnderTest.put(6, "Six");
		classUnderTest.put(3, "Three");
		classUnderTest.put(1, "One");
		classUnderTest.put(10, "Ten");
		Integer floor = classUnderTest.floor(11);
		System.out.println(floor);
	}
	
	@Test
	void treeTests() {
		NavigableSet<Integer> set = new TreeSet<>();
		set.add(5);
		set.add(4);
		set.add(8);
		set.add(3);
		set.add(1);
		set.add(10);
		set.add(7);
		int floor_4 = set.floor(4);
		System.out.println(floor_4);
		
	}

}
