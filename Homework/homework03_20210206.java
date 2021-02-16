/*
643. 子数组最大平均数 I
-----------------
想法：
①	当长度k已知，求最大平均数相当于求定长子数组的最大和
②	For循环从第一个到第length-k+1个（索引号为0到length-k，包括最后一个，左右两边界都包括），然后再用一个for循环求包括它到后面k个元素的和。找出最大的和，求平均
*/
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double result = 0.0;
        int sum = -2147483648; // int类型中最小的数，最大的是2147483647
        int len = nums.length;
        for (int i=0; i<=len-k; i++){ 
// 是包括len-k的，不然数组只有一个数的时候出错。每次都要考虑特殊边界。比如数组只有一个元素的情况，循环到第一个数/最后一个数的情况，数组为空的情况
            int sum1 = 0;
            for (int j=0; j<k; j++){
                sum1 = sum1 + nums[i+j];
            }
            if (sum1 > sum){
                sum = sum1;
            }
        }
        result = (double)sum/k;
        return result;
    }
}

/*
1590. 使数组和能被 P 整除
-----------------
想法：
①	计算数组和，如果结果小于p返回-1；如果结果≥p，用结果%p，如果余数为0返回0；如果余数≠0，应该去掉余数+np（n为非负整数）
②	问题就变成了数组中有没有子数组的和减去余数后%p结果为0，而且要是最短的
③	外部for循环，子数组长度L从1开始到数组总长（不包括数组总长），遍历
④	内部for循环，索引从0到[数组总长-子数组长度L]（可以等于），计算长为L的子数组的数字和。每一个和计算完，减去余数再%p，如果结果为0，返回L。
⑤	直到循环结束还没有，返回-1
*/
// 碰到很长很长的输入超时了
class Solution {
    public int minSubarray(int[] nums, int p) {
        int len = nums.length;
        long sum = 0L; // 因为1 <= nums[i] <= 10^9，加起来已经超出int范围，所以要用long
        
        for (int i=0; i<len;i++){
            sum = sum + nums[i];
        }

        if (sum < p){
            // System.out.print(sum); 之前int溢出的时候为了测试是哪里出错
            return -1;
        }

        else{
            long remain = sum % p; // 因为和sum计算，所以也要是long
            if (remain == 0){
                return 0;
            }

            else{
                for (int sublen=1; sublen<len; sublen++){
                    for (int i=0; i<=len-sublen; i++){
                        int subsum = 0;
                        for (int j=i; j<i+sublen; j++){
                            subsum = subsum + nums[j];
                        }

                        if ((subsum-remain)%p == 0){
                            return sublen;
                        }
                    }
                }
            }
        }
        return -1;
    }
}

/**
1733. 需要教语言的最少人数
-------------------------
想法：
示例 2：
输入：n = 3, languages = [[2],[1,3],[1,2],[3]], friendships = [[1,4],[1,2],[3,4],[2,3]]
输出：2
解释：教用户 1 和用户 3 第三门语言，需要教 2 名用户。
--------------------------
对friendship中每一对查找对应的language，如果双方没有相同的语言（单独写一个函数判断两个人有没有相同语言），将这对存入一个动态数组ArrayList里。如上例，除了[2,3]有相同的语言，[1,4],[1,2],[3,4]都语言不通，所以设置一个ArrayList放[[1,4],[1,2],[3,4]]
将每一对语言不通的朋友会说的语言放到一起成一个ArrayList，然后判断每种语言在所有语言ArrayList中出现了多少次，上面列表的语言为：
[2] [3]		→	[2, 3]
[2] [1, 3]		→	[2, 1, 3]
[1, 2] [3]		→	[1, 2, 3]
选择在所有list中出现最多次的语言来教，将所有最多的语言加入一个list，遍历，将所有语言不通的人加入一个数组，（写一个某序号的人会不会某语言的函数，返回boolean），看遍历到的语言有多少人不会，遇到一个不会的教的次数就+1，最后返回不会的人最少的语言
 */
// 76 / 99 个通过测试用例
class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        ArrayList noCommonPair = new ArrayList();
        ArrayList<int[]> noCommonPairLanguages = new ArrayList();
        ArrayList<Integer> noCommonPairPerson = new ArrayList();// 如果出现object cannot convert to xxx类错误在ArrayList后面指定元素类型
        for (int i=0; i<friendships.length; i++){
            if (!commonLanguage(languages[friendships[i][0]-1], languages[friendships[i][1]-1])){
                noCommonPair.add(friendships[i]);
                for (int m=0; m<friendships[i].length; m++){
                    if (!include(noCommonPairPerson, friendships[i][m])){
                        noCommonPairPerson.add(friendships[i][m]);
                    }
                }// https://bbs.csdn.net/topics/300223587
                int[] pairLanguages = IntStream.concat(Arrays.stream(languages[friendships[i][0]-1]), Arrays.stream(languages[friendships[i][1]-1])).toArray();
                // 合并int数组 https://www.cjavapy.com/article/381/ |||| https://blog.csdn.net/weixin_39296283/article/details/105048946 https://blog.csdn.net/weixin_42617262/article/details/84777274?utm_medium=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.control&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.control ||||||| https://blog.csdn.net/liu_005/article/details/72760392?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.control
                noCommonPairLanguages.add(pairLanguages);
            }
            // noCommonPair：朋友中无共同语言的那些对，多个长度为2的int数组组成的ArrayList
            // noCommonPairLanguages：无共同语言朋友对中的两个人会说的语言集合，多个长度不定int数组组成的ArrayList
            // noCommonPairPerson：无共同语言的朋友对中出现过的人都放到一个ArrayList中
        }
        // times：每种语言在noCommonPairLanguages中出现过的次数
        int[] times = new int[n];
        for (int j=1; j<=n; j++){ // 每种语言在所有语言ArrayList中出现了多少次。建立一个list存放次数，for循环所有语言，for循环ArrayList中每一个数组，for循环遍历其中的语言与当前循环到的语言比较，如果出现了，list中此语言对应的次数+1
            for (int k=0; k<noCommonPairLanguages.size(); k++){
                int[] lans = noCommonPairLanguages.get(k);
                for (int l=0; l<lans.length; l++){
                    if (lans[l] == j){
                        times[j-1]++;
                    }
                }
            }
        }
        // mostLanguage：出现次数最多的语言组成的数组
        int[] mostLanguage = maxLanguage(times);
        int result = 99999999;
        for (int p=0; p<mostLanguage.length; p++){
            int r = 0;
            for (int q=0; q<noCommonPairPerson.size(); q++){
                if (!userSpeakLanguage(noCommonPairPerson.get(q), mostLanguage[p], languages)){
                    r ++;
                }
            }
            if (r < result){
                result = r;
            }
        }// 遍历noCommonPairPerson也就是无共同语言朋友对中出现过的人，如果有不会这个语言的，教的次数+1
        return result;

    }

    // 输入两组会的语言，其中是否有共同语言
    public boolean commonLanguage(int[] languages1, int[] languages2){
        for (int i=0; i<languages1.length; i++){
            for (int j=0; j<languages2.length; j++){
                if (languages1[i] == languages2[j]){
                    return true;
                }
            }
        }
        return false;
    } // https://blog.csdn.net/sinat_33536912/article/details/52093989

    // 一个整数的ArrayList中是否有target这个整数
    public boolean include(ArrayList al, int target){
        for (int i=0; i<al.size(); i++){
            if (Integer.parseInt(al.get(i).toString()) == target){ // 如果左边是al.get(i)右边是target是object类型和int类型比较，报错
                return true;
            }
        }
        return false;
    }// https://www.nhooo.com/java/java-examples-pass-arraylist-as-function-argument.html

    // 输入一个整数数组，返回里面所有最大元素对应的下标组成的数组
    public int[] maxLanguage(int[] inputArray){
        int max = 0;
        int size = 0;
        for (int i=0; i<inputArray.length; i++){
            if (inputArray[i] > max){
                max = inputArray[i];
            }
        }
        for (int j=0; j<inputArray.length; j++){
            if (inputArray[j] == max){
                size ++;
            }
        }
        int[] index = new int[size];
        int x = 0;
        for (int k=0; k<inputArray.length; k++){
            if (inputArray[k] == max){
                index[x] = k+1;
                x ++;
            }
        }
        return index;
    }

    // 输入用户编号、语言编号、每个用户会说的语言数组，返回该用户是否会说该语言
    public boolean userSpeakLanguage(int user, int lan, int[][] languages){
        for (int i=0; i<languages[user-1].length; i++){
            if (languages[user-1][i] == lan){
                return true;
            }
        }
        return false;
    }
}

/**
875. 爱吃香蕉的珂珂
----------------------------
想法：
如果H≤香蕉的堆数即数组的长度，K为数组中最大的数
如果H>香蕉的堆数
每次吃的根数K在1到最大一堆的香蕉个数之间
吃每一堆所要的时间为，如果香蕉数%吃的速度=0则为香蕉数/吃的速度，如果≠0则为(香蕉数/吃的速度)+1
从1开始遍历K，遍历所有堆，计算每一堆吃完的时间并相加，当总时间<=H时返回当前K
可以将piles从大到小排，然后再按顺序计算每一堆的时间，每加完一堆都先和H比较一下，如果已经大于了直接break去下一个K
 */
// 超时，113 / 115 个通过测试用例，然后碰到一个超级长的
class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        // int maxPile = Arrays.stream(piles).max().getAsInt();
        Arrays.sort(piles);
        int[] progrePiles = piles; // 从小到大排列，方便找到最大值以及从最多的堆到最少的堆计算时间
        int length = piles.length;
        int maxPile = progrePiles[length-1];
        
        if (H == length){
            return maxPile;
        }
        else {
            for (int k=1; k<=maxPile; k++){
                int timeSum = 0;
                for (int j=length-1; j>=0; j--){
                    timeSum = timeSum + onePileTime(progrePiles[j], k);
                    if (timeSum > H){
                        break;
                    }
                }
                if (timeSum <= H){
                    return k;
                }
            }
            return -1;
        }
    }

    public int onePileTime(int bananaNum, int speed){
        if (bananaNum % speed == 0){
            return (bananaNum / speed);
        }
        else {
            return ((bananaNum / speed) + 1);
        }
    }
}

/**
424. 替换后的最长重复字符
----------------------------
想法：
参考：通过此题了解一下什么是滑动窗口 Java 题解 https://leetcode-cn.com/problems/longest-repeating-character-replacement/solution/tong-guo-ci-ti-liao-jie-yi-xia-shi-yao-shi-hua-don/
假如K为0，就是寻找最长子串，它的思路为：
字符串AABBBCC
左窗口边界left，右窗口边界right，初始都是0
窗口长度为right-left+1=1
右窗口右移，如果出现更长连续序列，如上面字符串从A变成AA，窗口长度+1变成2。
再次右移，没有发现更长的序列，整个窗口右移再右移跳过当前的AA序列
右窗口右移发现更长的B，窗口长度再+1变成3
再右移发现是C，于是平移过BBB，左右窗都+3，发现到头了
返回此时的窗口长度3
----------------------------
当可以替换K个字母时，就变成了窗口内出现最多的字母的个数+K如果≥窗口长度就符合条件
建立一个int[26]的数组存放每个字母对应的出现个数
右窗口经过的字符表示进入窗口，在对应位置+1；左窗口经过的字符表示离开窗口，对应位置-1

 */
class Solution {
    private int[] map = new int[26];

    public int characterReplacement(String s, int k) {
        if (s == null) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        int historyCharMax = 0;
        for (right = 0; right < chars.length; right++) {
            int index = chars[right] - 'A';
            map[index]++;
            historyCharMax = Math.max(historyCharMax, map[index]);
            if (right - left + 1 > historyCharMax + k) {
                map[chars[left] - 'A']--;
                left++;
            }
        }
        return chars.length - left;
    }
}