package middle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * HJ48 从单向链表中删除指定值的节点
 * @author d3y1
 */
public class HJ48 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()){
            solutionArrayList(in);
//            solutionLinkedList(in);
        }
    }

    /**
     * solution 1
     * ArrayList add() remove()
     * @param in
     */
    private static void solutionArrayList(Scanner in){
        Integer num = in.nextInt();
        List<Integer> list = new ArrayList<>();
        list.add(in.nextInt());

        for(int i=1; i<num; i++){
            Integer currValue = in.nextInt();
            Integer preValue = in.nextInt();

            list.add(list.indexOf(preValue)+1, currValue);
        }

        Integer delValue = in.nextInt();
        list.remove(list.indexOf(delValue));

        for(Integer value: list){
            System.out.print(value+" ");
        }
    }


    /**
     * solution 2
     * create Node && LinkedList
     * @param in
     */
    private static void solutionLinkedList(Scanner in){
        // create LinkedList
        Integer num = in.nextInt();
        Node head = new Node(in.nextInt(), null);
        for(int i=1; i<num; i++){
            Node curr = new Node(in.nextInt());
            Integer preValue = in.nextInt();

            for(Node tail=head; tail!=null; tail=tail.next){
                if(tail.value.equals(preValue)){
                    Node tmp = tail.next;
                    tail.next = curr;
                    curr.next = tmp;
                }
            }
        }

        // delete
        Integer delValue = in.nextInt();
        if(head.value.equals(delValue)){
            head = head.next;
        }else{
            for(Node curr=head,tail=head.next; tail!=null; curr=curr.next,tail=tail.next){
                if(tail.value.equals(delValue)){
                    curr.next = tail.next;
                }
            }
        }

        // print
        for(Node curr=head; curr!=null; curr=curr.next){
            System.out.print(curr.value+" ");
        }
    }

    private static class Node {
        Integer value;
        Node next;

        private Node(Integer value){
            this.value = value;
        }

        private Node(Integer value, Node next){
            this.value = value;
            this.next = next;
        }
    }
}
