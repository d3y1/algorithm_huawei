package simple;

import java.util.Scanner;

// 注意类名必须为 online.Main, 不要有任何 package xxx 信息
public class HJ51 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int num = in.nextInt();
        int[] value = new int[num];

        for(int i=0; i<num; i++){
            value[i] = in.nextInt();
        }

        int lastIndex = in.nextInt();
        ListNode head = new ListNode();

        for(int i=num-1; i>=0; i--){
            ListNode tmp = head.m_pNext;
            head.m_pNext = new ListNode(value[i]);
            head.m_pNext.m_pNext = tmp;
        }

        ListNode result = head;
        for (int i = 0; i <=num-lastIndex; i++) {
            result = result.m_pNext;
        }

        System.out.println(result.m_nKey);
    }

    public static class ListNode {
        int m_nKey;
        ListNode m_pNext;

        ListNode(){}

        ListNode(int key){
            this.m_nKey = key;
        }

        ListNode(int key, ListNode nextNode){
            this.m_nKey = key;
            this.m_pNext = nextNode;
        }

        ListNode(ListNode nextNode){
            this.m_pNext = nextNode;
        }
    }
}
