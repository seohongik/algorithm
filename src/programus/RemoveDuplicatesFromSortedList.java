package programus;

public class RemoveDuplicatesFromSortedList {

    /*https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/*/
    public ListNodeA deleteDuplicates(ListNodeA head) {

        ListNodeA curr = head;

        while (head != null && head.next != null) {

            if (head.val == head.next.val) {
                head.next = head.next.next;
            }else {
                head = head.next;
            }
        }

        return curr;
    }

    public static void main(String[] args) {
        ListNodeA head = new ListNodeA(0);
        head= new ListNodeA(1);
        head.next=new ListNodeA(2);
        head.next.next= new ListNodeA(3);
        head.next.next.next= new ListNodeA(4);
        RemoveDuplicatesFromSortedList removeDuplicates = new RemoveDuplicatesFromSortedList();
        ListNodeA temp = removeDuplicates.deleteDuplicates(head);
        System.out.println(temp);

    }
    static class ListNodeA {
        int val;
        ListNodeA next;

        ListNodeA() {
        }

        ListNodeA(int val) {
            this.val = val;
        }

        ListNodeA(int val, ListNodeA next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNodeA{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
