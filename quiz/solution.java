package com.gsq.service.impl;

public class solution {

    //1
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        move(A.size(), A, B, C);
    }

    private void move(int num, List<Integer> A, List<Integer> B, List<Integer> C) {
        if (num == 1) {
            C.add(A.remove(A.size() - 1));
            return;
        }

        move(num - 1, A, C, B);
        C.add(A.remove(A.size() - 1));
        move(num - 1, B, A, C);
    }

    //2
    public int countStudents(int[] students, int[] sandwiches) {
        if (students == null || students.length == 0) return 0;
        if (sandwiches == null || sandwiches.length == 0) return students.length;
        Queue<Integer> student = new LinkedList<>();
        for (int i = 0; i < students.length;i++) {
            student.offer(students[i]);
        }
        for (int i = 0; i < sandwiches.length; i++) {
            int total = student.size();
            if (total==0) {
                return total;
            }
            int count = 0;
            for (int s = 0; s < total; s++) {
                int curr = student.poll();
                if (curr != sandwiches[i]) {
                    count++;
                    student.offer(curr);
                } else
                    break;

            }
            if (count == total) {
                return total;
            }
        }
        return student.size();


    }

    //3
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node start = head;
        Map<Node, Node> map = new HashMap<>();
        while(start != null) {
            map.put(start, new Node(start.val));
            start = start.next;
        }
    }
}
