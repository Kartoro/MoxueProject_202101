import java.util.List;

public class H_20210314 {

    // q1
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {

        hanotaMove(A.size(), A, B, C);

    }

    public void hanotaMove(int size, List<Integer> A, List<Integer> B, List<Integer> C){
        if(size == 1){
            C.add(A.remove(A.size() - 1));
            return;
        }else{
            hanotaMove(size - 1, A, C, B);
            C.add(A.remove(A.size() - 1));
            hanotaMove( size - 1, B, A, C);
        }
    }

    // q2
    public int countStudents(int[] students, int[] sandwiches) {
        int l = students.length;
        int stuC = 0, stuS = 0;
        for(int i = 0; i < l; i++){
            if(students[i] == 0){
                stuC ++;
            }else{
                stuS ++;
            }
        }

        for(int j = 0; j < l; j++){
            if(sandwiches[j] == 0){
                if(stuC > 0){
                    stuC --;
                }else{
                    break;
                }
            }else{
                if(stuS > 0){
                    stuS --;
                }else{
                    break;
                }
            }
        }

        return stuC + stuS;

    }


    // q3


    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        
    }




    
}


