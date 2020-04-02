/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a, b) ->  a.val - b.val);
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for(ListNode list : lists) {
            if(list != null) {
                queue.add(list);
            }
        }
        while(!queue.isEmpty()) {
            cur.next = queue.poll();
            cur = cur.next;
            if(cur.next != null) {
                queue.add(cur.next);
            }
        }
        return dummy.next;
    }
    
    // Got StackOverflowError
    public ListNode mergeKLists2(ListNode[] lists) {
        // Time: O(n logk)
        // Space: Space O(n)
        
        //1. Device and concer
        if(lists == null || lists.length == 0) return null;
        return sort(lists, 0, lists.length - 1);
    }
    
    private ListNode sort(ListNode[] lists, int lo, int hi) {
        if(lo >= hi) return lists[0];
        int mid = (hi + lo) >>> 1;
        ListNode l1 = sort(lists, lo, mid);
        ListNode l2 = sort(lists, mid + 1, hi);
        return merge(l1, l2);
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val <= l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }
}