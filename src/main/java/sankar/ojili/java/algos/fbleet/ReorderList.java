package sankar.ojili.java.algos.fbleet;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReorderList {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		//head.next.next = new ListNode(3);
		//head.next.next.next = new ListNode(6);
		//head.next.next.next.next = new ListNode(5);
		ReorderListSol sol = new ReorderListSol();
		sol.reorderList(head);
		while(head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
	
}

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

class ReorderListSol {
    public void reorderList(ListNode head) {
        Deque<ListNode> nodes = new ArrayDeque<ListNode>();
        while(head != null) {
            nodes.add(head);
            head = head.next;
        }
        ListNode prev = null;
       while(!nodes.isEmpty()) {
           ListNode node1 = nodes.removeFirst();
           if(prev != null) {
               prev.next = node1;
           }
           ListNode node2 = null;
           if(!nodes.isEmpty()) {
              node2 = nodes.removeLast();
           } 
           node1.next = node2;
           prev = node2;
           if(prev != null)
            prev.next = null;
       }    
       
    }
}