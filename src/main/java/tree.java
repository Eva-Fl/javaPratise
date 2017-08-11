/**
 * Created by ljfeng on 2017/8/11.
 */
public class tree {
    public class Node<T>{//树节点
        public T data;
        public Node<T> left;
        public Node<T> right;
        public Node(T data){
            this.data = data;
            this.left = null;
            this.right = null;
        }


    }
}
