public class Quiz1 {

    public static void main (String[] args) {

        String sequence = "abcdacadabcdabcdas";
        String word = "abcd";

        Exam1.Quiz1 quiz1 = new Exam1.Quiz1();
        System.out.println(quiz1.method(sequence, word));

    }

    public int method (String sequence, String word){
        if (sequence == null || sequence.length() == 0){
            return 0;
        }

        if (word == null || word.length() == 0){
            return 0;
        }

        int i = 0;
        int j  = 0;
        int count = 0;
        int maxCount = 0;
        while (i < sequence.length()){
            if (sequence.charAt(i) == word.charAt(j)){
                while (sequence.charAt(i) == word.charAt(j)){
                    i++;
                    j++;
                    if (j == word.length()){
                        count += 1;
                        maxCount = Math.max(maxCount, count);
                        j = 0;
                    }
                }
                count = 0;
                j = 0;
            } else {
                i++;
            }
        }
        return maxCount;
    }
}