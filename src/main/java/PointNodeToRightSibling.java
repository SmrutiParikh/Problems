import sun.misc.Queue;

import java.util.Objects;

//Input Tree
//        A
//        / \
//        B   C
//        / \   \
//        D   E   F
//
//
//        Output Tree
//        A--->NULL
//        / \
//        B-->C-->NULL
//        / \   \
//        D-->E-->F-->NULL
class PointNodeToRightSibling {
    static class Node {
        private Node left;
        private Node right;
        private Node rightSibling;
        private Integer depth;
        private String value;

        public Node(Node left, Node right, String value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" +
                    " value='" + value + '\'' +
                    " -->=" + rightSibling +
                    '}';
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getRightSibling() {
            return rightSibling;
        }

        public void setRightSibling(Node rightSibling) {
            this.rightSibling = rightSibling;
        }

        public Integer getDepth() {
            return depth;
        }

        public void setDepth(Integer depth) {
            this.depth = depth;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    static void run(){
        Node F = new Node(null, null, "F");
        Node C = new Node(null, F, "C");
        Node E = new Node(null, null, "E");
        Node D = new Node(null, null, "D");
        Node B = new Node(D, E, "B");
        Node A = new Node(B, C, "A");
//        try {
            System.out.println("Initial Tree : ");
            printBinaryTree(A, 0);
            pointToRightSibling(A);
            System.out.println("\nProcessed Tree : ");
            printBinaryTree(A, 0);
//        }catch (InterruptedException e ){
//            e.printStackTrace();
//        }
    }

    private static void pointToRightSibling(Node root) {
        Queue<Node> queue = new Queue<>();
        root.setDepth(0);
        queue.enqueue(root);
        Node current = null;
        while ( !queue.isEmpty()) {
            try {
                if(Objects.isNull(current)){
                    current = queue.dequeue();
                }
                int depth = current.getDepth();
                if(Objects.nonNull(current.getLeft())) {
                    current.getLeft().setDepth(depth + 1);
                    queue.enqueue(current.getLeft());
                }
                if(Objects.nonNull(current.getRight())) {
                    current.getRight().setDepth(depth + 1);
                    queue.enqueue(current.getRight());
                }
                if(!queue.isEmpty()) {
                    Node next = queue.dequeue();
                    current.setRightSibling(next.getDepth().equals(current.getDepth()) ? next : null);
                    current = next;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

//    private static void printTree(Node root) throws InterruptedException {
//        Queue<Node> queue = new Queue<>();
//        queue.enqueue(root);
//        int level = 0;
//        while(!queue.isEmpty()){
//            Node current = queue.dequeue();
//            System.out.print(current.toString() + " ");
//            if( Objects.nonNull(current.getDepth()) && current.getDepth() != level ){
//                level = current.getDepth();
//                System.out.println();
//            }
//            if(Objects.nonNull(current.getLeft())){
//                queue.enqueue(current.getLeft());
//            }
//            if(Objects.nonNull(current.getRight())){
//                queue.enqueue(current.getRight());
//            }
//        }
//        System.out.println();
//    }

        private static void printBinaryTree(Node root, int level){
            if(root==null)
                return;
            printBinaryTree(root.getRight(), level+1);
            if(level!=0){
                for(int i=0;i<level-1;i++)
                    System.out.print("|\t");
                String rightSibling = null;
                if(root.getRightSibling() != null){
                    rightSibling = root.rightSibling.getValue();
                }
                System.out.println("|── "+root.getValue() + " -->" + rightSibling);
            }
            else
                System.out.println(root.getValue());
            printBinaryTree(root.getLeft(), level+1);
        }
}

