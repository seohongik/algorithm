package programus;


import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "[" + val+ "]";
    }
}



public class MergeTwoList {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null) {
            return null;
        }
        //List<Integer> list = new ArrayList<>();

        ListNode dummy = new ListNode(0);
        ListNode result = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                result.next = list1;
                list1 = list1.next;
                result = result.next;
            }else {
                result.next = list2;
                list2 = list2.next;
                result = result.next;
            }
            //list.add(result.val);
        }

        if(list1 != null) {
            while(list1 != null) {
                result.next = list1;
                list1 = list1.next;
                result = result.next;
            }
        }
        if(list2 != null) {
            while(list2 != null) {
                result.next = list2;
                list2 = list2.next;
                result = result.next;
            }
        }

        return dummy.next;
    }

    /*
    public ListNode createLinkedList(List<Integer> arr) {
        if (arr == null || arr.isEmpty()) return null;

        // 시작점을 잡기 위한 가짜(dummy) 노드
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (int val : arr) {
            // 새 노드를 생성하여 현재 노드의 다음에 연결
            current.next = new ListNode(val);
            // 다음 칸으로 이동
            current = current.next;
        }
        // dummy의 다음 노드가 실제 리스트의 시작점(head)입니다.
        return dummy.next;
    }*/

    public static void main(String[] args) {

        MergeTwoList mergeTwoList = new MergeTwoList();
        ListNode list1 = new ListNode(-9);
        list1.next = new ListNode(3);


        ListNode list2 = new ListNode(5);
        list2.next = new ListNode(7);

        System.out.println("aaaa"+mergeTwoList.mergeTwoLists(list1, list2));

        //System.out.println(new MergeTwoList().mergeTwoLists(null, null));

    }
}
