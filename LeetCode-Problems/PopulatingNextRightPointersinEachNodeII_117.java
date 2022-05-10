// 117. Populating Next Right Pointers in Each Node II
// https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/


/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

// Using constant space (Without Queue)
class Solution {
    public Node connect(Node root) {
        
        if (root == null) {
            return root;
        }
        
        Node head = root;
        
        while (head != null) {
            Node dummy = new Node(0);
            Node temp = dummy;
            
            while (head != null) {
                if (head.left != null) {
                    temp.next = head.left;
                    temp = temp.next;
                }
                if (head.right != null) {
                    temp.next = head.right;
                    temp = temp.next;
                }
                head = head.next;
            }
            head = dummy.next;
        }
        
        return root;
    }
}

/*
// Using Queue
class Solution {
    public Node connect(Node root) {
        
        if (root == null) {
            return root;
        }
        
        root.next = null;
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while (q.isEmpty() == false) {
            int len = q.size();
            
            for (int i = 0; i < len; i++) {
                Node temp = q.poll();
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
                if (i == len - 1) {
                    temp.next = null;
                }
                else {
                    Node curr = q.peek();
                    temp.next = curr;
                }
            }
        }
        
        return root;
    }
}
*/
