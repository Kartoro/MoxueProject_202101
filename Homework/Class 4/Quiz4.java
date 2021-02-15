// Leetcode.1733 需要教语言的最少人数
class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {

        ArrayList<int[]> noFriendships = new ArrayList<>();

        for (int i = 0; i < friendships.length; i++) {
            HashSet<Integer> hashSet = new HashSet<>();
            for (int each : languages[friendships[i][0] - 1]){
                hashSet.add(each);
            }
            for (int each : languages[friendships[i][1] - 1]){
                hashSet.add(each);
            }
            if (hashSet.size() == languages[friendships[i][0] - 1].length + languages[friendships[i][1] - 1].length){
                noFriendships.add(friendships[i]);
            }
        }
        for (int[] each : noFriendships) {
            for (int element : each){
                System.out.println(element);
            }
        }

        if (noFriendships == null || noFriendships.size() == 0){
            return 0;
        }
        HashSet<Integer> personSet = new HashSet<>();
        int personSetLength = 0;
        int[] countLanguageAmount = new int[n + 1];
        for (int[] twoPerson : noFriendships){
            personSet.add(twoPerson[0]);
            for (int each : languages[twoPerson[0] - 1]){
                if (personSetLength < personSet.size()){
                    countLanguageAmount[each]++;
                }
            }
            personSetLength = personSet.size();

            personSet.add(twoPerson[1]);
            for (int each : languages[twoPerson[1] - 1]){
                if (personSetLength < personSet.size()){
                    countLanguageAmount[each]++;
                }
            }
            personSetLength = personSet.size();
        }
        int maxLanguagePerson = Integer.MIN_VALUE;
        for (int each : countLanguageAmount){
            maxLanguagePerson = Math.max(maxLanguagePerson, each);
        }

        return personSet.size() - maxLanguagePerson;
    }

}