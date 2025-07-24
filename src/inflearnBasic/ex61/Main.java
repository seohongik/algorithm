package inflearnBasic.ex61;
//DFS
class Solution {

    public Node root;


    public int solution(int start , Node root) {

        if (root == null) return Integer.MAX_VALUE;
        //if(root.left != null) { // left자체가 null일수 있음 널포인트 익셉
           // solution(start + 1, root.left);
        //}

        // 말단 노드이면 현재 depth 반환
        if (root.left == null && root.right == null) {
            return start;
        }
        //if(root.right != null) { // right 자체가 null일수 있음 널포인트 익셉
           // solution(start + 1, root.right);
        //}
        int left = solution(start+ 1, root.left);
        int right = solution(start + 1, root.right);
        return Math.min(left, right);
    }

    public int DFS(int ans, Node root){
        if(root.left==null && root.right==null) return ans;
        else return Math.min(DFS(ans+1, root.left), DFS(ans+1, root.right));
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
        tree.root.right=new Node(3);
        tree.root.left.left=new Node(4);
        tree.root.left.right=new Node(5);
        tree.root.right.left=new Node(6);
        tree.root.right.right=new Node(7);
        tree.root.right.left.left=new Node(8);
        tree.root.right.left.right=new Node(9);
        tree.root.right.right.left=new Node(10);
        System.out.println(tree.solution(0, tree.root));

    }
}