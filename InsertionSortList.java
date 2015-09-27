package Algorithm;

import data.ListNode;
import data.PrintLinkedList;

public class InsertionSortList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n5 = new ListNode(5);
		ListNode n4 = new ListNode(4);
		ListNode n3 = new ListNode(3);
		ListNode n2 = new ListNode(2);
		ListNode n1 = new ListNode(1);
		
		n4.next = n1;
		n1.next = n5;
		n5.next = n3;
		n3.next = n2;
		
		PrintLinkedList.print(insertionSort(n4));

	}
	
	public static ListNode insertionSort(ListNode head){
		ListNode dummy = new ListNode(0);
		
		while(head!=null){
			ListNode cur = dummy;
			while(cur.next!=null && cur.next.val<head.val){
				cur = cur.next;
			}
			
			ListNode tmp = head.next;
			head.next = cur.next;
			cur.next = head;
		    head = tmp;
		}
		
		return dummy.next;
	}

}
