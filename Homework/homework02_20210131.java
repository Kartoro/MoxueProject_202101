/*
125. 验证回文串
-------------------------
想法：
①	是把所有空格和标点符号去掉，提取字母和数字成array或者list。然后用一个for循环，list[0]=list[length-1], list[1]=list[length-2]，遍历整个字符串
②	去掉非字母和数字依旧形成一个字符串，用charAt直接定位字符串的第几个字母/数字
③	把字符串反向输出后判断是否和输入前相等也可以
--------------------
空字符串可以单独写个if
需要注意全部转换成大写或小写
*/
// 想法2
class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) return true;
        s = s.toLowerCase();
        // string中所有不是字母和数字的替换为null
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        for(int i=0; i<s.length(); i++){
            if (s.charAt(i) != s.charAt(s.length()-i-1)){
                return false;
            }
        }
        return true;
    }
}

/*
387. 字符串中的第一个唯一字符
------------------
想法：
①	嵌套for循环，外层遍历字符串，内层跳过被选中的字母遍历字符串。如果没有一样的返回当前索引；如果有一样的，外层循环进行下一个，当字符串遍历完，返回-1。
②	建立字典，字符串中每个值为key，对应的value是出现次数。遍历字符串，查找对应value，返回第一个value为1的字母的索引。
*/
// 想法1
// 比较慢
class Solution {
    public int firstUniqChar(String s) {
        if (s == null) return -1;
        for (int i=0; i<s.length(); i++){
            for (int j=0; j<s.length(); j++){
// s.charAt(i) == s.charAt(j)，如果i≠j，说明i不符合条件，break，去下一个i
// 如果i=j也分两种，如果是i=j=s.length()-1，已经循环到最后一个字符，之前都没有出现重复，则说明最后一个字符符合条件，返回i，函数结束
// 如果i=j但不是最后一个字符，跳过，j++
// 如果s.charAt(i) ≠ s.charAt(j)，j++，直到j已经循环到了最后一个，说明前面没有break，说明没有重复，i符合条件，返回i，函数结束
                if (s.charAt(i) == s.charAt(j)){
// 如果只写i == s.length()-1或j == s.length()-1，过不了"cc"用例
                    if (i == s.length()-1 && j == s.length()-1){
                        return i;
                    }
                    else if (i == j){
                        continue;
                    }
                    else{
                        break;
                    }
                }
                else if (j == s.length()-1){
                    return i;
                }
            }
        }
        return -1;
    }
}

/*
17. 电话号码的字母组合
------------------------
想法：
①	用for循环和charAt定位对应数字，用switch从2列到9，写出对应字母的list
②	或者用字典，key为数字，value为对应的字母list（采用）
③	如果明确知道输入数字有多长就不难，有几个数字就套几层for循环。像小学排列组合所用的方法，比如三位数有多少可能，固定前两位11，最后一位从0-9，再把第二位换到2，前两位12，第三位再从0-9，以此类推
④	所以既然字符串长度只有01234这几种，可以分别列出这几种，对每一种长度用上面的方法。分别列出的方法可以用switch，也可以用if…else if…else
*/
class Solution {
    public List<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<String>();
        int len = digits.length();
        if (len == 0){
            return result;
        }

        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        // 也可以在前面先ArrayList<String> list2 = new ArrayList<String>()，从list2到list9建立完之后再在这里赋值
        map.put("2", new ArrayList<String>(){{add("a");add("b");add("c");}}); 
        map.put("3", new ArrayList<String>(){{add("d");add("e");add("f");}});
        map.put("4", new ArrayList<String>(){{add("g");add("h");add("i");}});
        map.put("5", new ArrayList<String>(){{add("j");add("k");add("l");}});
        map.put("6", new ArrayList<String>(){{add("m");add("n");add("o");}});
        map.put("7", new ArrayList<String>(){{add("p");add("q");add("r");add("s");}});
        map.put("8", new ArrayList<String>(){{add("t");add("u");add("v");}});
        map.put("9", new ArrayList<String>(){{add("w");add("x");add("y");add("z");}});

        switch (len){
            case 1:
               result = map.get(digits);
               break;
            case 2:
               String dig2_0 = String.valueOf(digits.charAt(0)); // 需要把char转换成string。不知道为什么用.toString()会报错
               String dig2_1 = String.valueOf(digits.charAt(1));
               ArrayList<String> list2_0 = map.get(dig2_0);
               ArrayList<String> list2_1 = map.get(dig2_1);
               int size2_0 = list2_0.size();
               int size2_1 = list2_1.size();
               for (int i=0; i<size2_0; i++){
                   for (int j=0; j<size2_1; j++){
                       String r2_0 = (list2_0.get(i)).concat(list2_1.get(j));
                       result.add(r2_0);
                   }
               }
               break;
            case 3:
               String dig3_0 = String.valueOf(digits.charAt(0)); // 不同case里也不能定义同名变量
               String dig3_1 = String.valueOf(digits.charAt(1));
               String dig3_2 = String.valueOf(digits.charAt(2));
               ArrayList<String> list3_0 = map.get(dig3_0);
               ArrayList<String> list3_1 = map.get(dig3_1);
               ArrayList<String> list3_2 = map.get(dig3_2);
               int size3_0 = list3_0.size();
               int size3_1 = list3_1.size();
               int size3_2 = list3_2.size();
               for (int i=0; i<size3_0; i++){
                   for (int j=0; j<size3_1; j++){
                       for (int k=0; k<size3_2; k++){
                           String r3_0 = (list3_0.get(i)).concat(list3_1.get(j));
                           String r3_1 = r3_0.concat(list3_2.get(k));
                           result.add(r3_1);
                       }
                   }
               }
               break;
            case 4:
               String dig4_0 = String.valueOf(digits.charAt(0));
               String dig4_1 = String.valueOf(digits.charAt(1));
               String dig4_2 = String.valueOf(digits.charAt(2));
               String dig4_3 = String.valueOf(digits.charAt(3));
               ArrayList<String> list4_0 = map.get(dig4_0);
               ArrayList<String> list4_1 = map.get(dig4_1);
               ArrayList<String> list4_2 = map.get(dig4_2);
               ArrayList<String> list4_3 = map.get(dig4_3);
               int size4_0 = list4_0.size();
               int size4_1 = list4_1.size();
               int size4_2 = list4_2.size();
               int size4_3 = list4_3.size();
               for (int i=0; i<size4_0; i++){
                   for (int j=0; j<size4_1; j++){
                       for (int k=0; k<size4_2; k++){
                           for (int l=0; l<size4_3; l++){
                                String r4_0 = (list4_0.get(i)).concat(list4_1.get(j));
                                String r4_1 = r4_0.concat(list4_2.get(k));
                                String r4_2 = r4_1.concat(list4_3.get(l));
                                result.add(r4_2);
                           }
                       }
                   }
               }
        }
        return result;
    }
}

/*
22. 括号生成
----------------
初步想法：
对于n把所有可能组合列出来，然后删除所有第一个不是左括号的组合，删除所有最后一个不是右括号的组合。
对剩下的每一种组合从左往右遍历，遇到左括号，在一个list中存入一个1，遇到右括号，从list中删除一个1，直到遍历结束。
如果遍历过程中出现右括号而list中没有数字了，删除这个组合；如果遍历结束list中还有数字，删除这个组合。剩下的就是所有符合条件的组合。
*/


/*
49. 字母异位词分组
---------------------
初步想法：
遍历所有单词，对每一个单词生成字母list，包括重复的字母，按照字母表顺序排列（能否实现？）。
生成hashmap，key为单词本身，value为生成的字母表顺序字母list。
从输入的字符串数组中第一个单词开始遍历，找到在hashmap中对应的list（外层for）。将这个单词的list和后面所有单词的list比较是否相等（如果没有现成的函数就单独写一个比较list的函数）（内层for）。
将相等的单词组成新的数组，新建一个list result，result.append存放数组。
另建立一个list，存放所有已存放的单词索引，在外层for中先判断一下，如果当前索引i已经在这个list中，continue跳过这次循环。
返回result。
*/
