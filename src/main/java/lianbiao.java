/**
 * Created by ljfeng on 2017/8/11.
 */
public class lianbiao {

    class linkNode<T>{//双向链表链节点
        T data;//数据域
        linkNode<T> pre;//前一节点
        linkNode<T> next;//后一节点
        linkNode(T data){
            this.data = data;
        }
    }

    class doublyLinkedeList<T>{
        private linkNode<T> head;//首节点
        private linkNode<T> rear;//尾节点

        public doublyLinkedeList(){
        }

        public T peekHead(){
            if (head != null){
                return head.data;
            }
            return null;
        }
        public T peekRear(){
            if (rear != null){
                return rear.data;
            }
            return null;
        }
        public boolean isEmpty(){
            return head == null;
        }


    }


    public static class Node<T>{
        T data;
        Node<T> next;
        public Node(T data){
            this.data = data;
        }
        public T getData(){
            return data;
        }
        public void setData(T data){
            this.data = data;
        }
        public Node getNext(){
            return next;
        }
        public void setNext(Node next){
            this.next = next;
        }
    }

    public static Node linkReverse(Node current){
        //非递归实现
        Node pre = null;
        Node Next = null;
       while (current != null){
           Next = current.next;
           current.next = pre;
           pre = current;
           current = Next;
       }
       return pre;
    }

    public static Node reverse(Node current){
        //递归实现
        // 若为空链或者当前结点在尾结点，则直接返回
        if (current == null || current.next == null){
            return current;
        }
        Node next = current.getNext();
        Node reverseNode = reverse(next);// 先反转当前节点的后续节点
        current.getNext().setNext(current);// 将当前结点的指针域指向前一结点
        current.setNext(null);// 前一结点的指针域令为null;
        return reverseNode;// 反转后新链表的头结点
    }

    public static void main(String[] args) {
        //验证单链表反转
        Node head = new Node<Integer>(1);
        Node node1 = new Node<Integer>(2);
        Node node2 = new Node<Integer>(3);
        Node node3 = new Node<Integer>(4);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        Node head1 = head;
        while (null != head) {
            System.out.print(head.getData() + " ");
            head = head.getNext();
        }
        System.out.println("\n----------------------");
        Node cur = linkReverse(head1);
        while(null != cur){
            System.out.print(cur.getData()+" ");
            cur = cur.getNext();
        }
        Node anotherhead = new Node<Integer>(1);
        Node anothernode1 = new Node<Integer>(2);
        Node anothernode2 = new Node<Integer>(3);
        Node anothernode3 = new Node<Integer>(4);
        anotherhead.setNext(anothernode1);
        anothernode1.setNext(anothernode2);
        anothernode2.setNext(anothernode3);
        Node anotherhead1 = anotherhead;
        System.out.println("\n----------------------");
        Node reverseNode = reverse(anotherhead1);
        while(null != reverseNode){
            System.out.print(reverseNode.getData()+" ");
            reverseNode = reverseNode.getNext();
        }

    }


}
