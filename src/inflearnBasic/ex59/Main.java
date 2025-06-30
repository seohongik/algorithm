package inflearnBasic.ex59;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
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


class Solution {

    Node root;

    Solution() {
        root = null;
    }

    // 삽입 연산
    void insert(int data) {
        root = insertRec(root, data);
    }

    boolean search(int data) {
        return searchRec(root, data);
    }

    boolean searchRec(Node root, int data) {
        if (root == null) {
            return false;
        }

        if (data == root.data) {
            return true;
        }

        return data < root.data ? searchRec(root.left, data) : searchRec(root.right, data);
    }

    public void bfs(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.println(current);
            System.out.print(current.data + " "); // 노드 방문 처리

            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
    }

    Node insertRec(Node root, int data) {

        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

}

class Main{

    public static void main(String[] args){
        Solution sol = new Solution();
        sol.root = new Node(1);
        sol.root.left = new Node(2);
        sol.root.right = new Node(3);
        sol.root.left.left = new Node(4);
        sol.root.left.right = new Node(5);
        sol.root.right.left = new Node(6);
        sol.root.right.right = new Node(7);

        System.out.println();
        sol.bfs(sol.root);

    }
}