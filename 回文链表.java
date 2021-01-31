public class 回文链表 {
    public static void main(String[] args) {

    }
    ListNode frontPointer ;

    public boolean isPalindrome(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }

    public boolean recursivelyCheck(ListNode node){
        if (node == null){
            return true;
        } else{
            if (!recursivelyCheck(node.next)){
                return false;
            }
            if (node.val != frontPointer.val){

                return false;
            }
            frontPointer = frontPointer.next;
        }
        return true;
    }

}
class ListNode{
    ListNode next;
    Object val;
}