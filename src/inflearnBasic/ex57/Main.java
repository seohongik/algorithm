package inflearnBasic.ex57;

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

    // 중위 순회 (Inorder Traversal)
    void inorder() {
        inorderRec(root);
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    // 전위 순회 (Preorder Traversal)
    void preorder() {
        preorderRec(root);
    }

    void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    // 후위 순회 (Postorder Traversal)
    void postorder() {
        postorderRec(root);
    }

    void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.data + " ");
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
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        Solution sol = new Solution();
        sol.root = new Node(1);
        sol.root.left = new Node(2);
        sol.root.right = new Node(3);
        sol.root.left.left = new Node(4);
        sol.root.left.right = new Node(5);
        sol.root.right.left = new Node(6);
        sol.root.right.right = new Node(7);

        System.out.println();
        sol.preorder(); // 전위 순회 // 부모 -> 왼쪽 자식 -> 오른쪽 자식
        System.out.println();
        sol.inorder(); // 중위 순회 // 왼쪽 자식 -> 부모 ->  오른쪽 자식
        System.out.println();
        sol.postorder(); // 후위 순회 // 왼쪽 자식 -> 오른쪽 자식 -> 부모

    }
}