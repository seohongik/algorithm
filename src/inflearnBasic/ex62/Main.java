package inflearnBasic.ex62;

import java.util.LinkedList;
import java.util.Queue;

//BFS
class Solution {

    public Node root;
    public int solution(int start , Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        while(!q.isEmpty()) {
            Node cur = q.poll();
            int size = q.size();
            for (int i=0; i<size; i++){

                if(cur.left==null&& cur.right==null){
                    return level;
                }

                if(cur.left != null) {
                    q.add(cur.left);
                }
                if(cur.right != null) {
                    q.add(cur.right);
                }
            }
            level++;
        }
        return level;
    }

    public int BFS(Node root) {
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        int L = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                Node cur = Q.poll();
                if (cur.left == null && cur.right == null) return L;
                if (cur.left != null) Q.offer(cur.left);
                if (cur.right != null) Q.offer(cur.right);
            }
            L++;
        }
        return 0;
    }

    public Solution(){}
}


class Node{
    int data;
    Node left, right;
    public Node(int data) {
        this.data=data;
        left=null;
        right=null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}


class Main{

    public static void main(String[] args){ // 예상결과 2

        Solution tree = new Solution();
        tree.root=new Node(1);
        tree.root.left=new Node(2);
        tree.root.left.left=new Node(4);
        tree.root.left.right=new Node(5);
        tree.root.right = new Node(3);

        System.out.println(tree.solution(0, tree.root));

    }
}