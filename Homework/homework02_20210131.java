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
