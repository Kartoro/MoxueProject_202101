/**
Q1. 最大重复子字符串

给你一个字符串 sequence ，如果字符串 word 连续重复 k 次形成的字符串是 sequence 的一个子字符串，那么单词 word 的 重复值为 k 。
单词 word 的 最大重复值 是单词 word 在 sequence 中最大的重复值。
如果 word 不是 sequence 的子串，那么重复值 k 为 0 。

给你一个字符串 sequence 和 word ，请你返回 最大重复值 k 。

示例 1：

输入：sequence = "ababc", word = "ab"
输出：2
解释："abab" 是 "ababc" 的子字符串。

示例 2：

输入：sequence = "ababc", word = "ba"
输出：1
解释："ba" 是 "ababc" 的子字符串，但 "baba" 不是 "ababc" 的子字符串。

示例 3：

输入：sequence = "ababc", word = "ac"
输出：0
解释："ac" 不是 "ababc" 的子字符串。
 
提示：
1 <= sequence.length <= 100
1 <= word.length <= 100
sequence 和 word 都只包含小写英文字母。
 */
// 但是非连续的重复也计算进来了
class Solution {
     public int maxRepeating(String sequence, String word) {
         int times = 0;
         int maxTimes = 0;
         int seqLen = sequence.length();
         int worLen = word.length();
         for (int j=0; j<(seqLen-worLen+1); j++){
             if (ifSame(sequence, word, j)){
                 times += 1; // 但是非连续的重复也计算进来了
               //   String subSequence = sequence.substring(j+worLen);
               //   maxRepeating(subSequence, word);
             } 
             // else {
             //     times = 0;
             // }
         }
         if (maxTimes < times){
             maxTimes = times;
         }
         return maxTimes;
     }
 
     public boolean ifSame(String sequence, String word, int index){
         for (int i=0; i<word.length(); i++){
             if (sequence.charAt(index+i) != word.charAt(i)){
                 return false;
             }
         }
         return true;
     }
 }




/**
Q2. 基本计算器
实现一个基本的计算器来计算一个简单的字符串表达式的值。

字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格。 整数除法仅保留整数部分。

示例 1:

输入: "3+2*2"
输出: 7

示例 2:

输入: " 3/2 "
输出: 1

示例 3:

输入: " 3+5 / 2 "
输出: 5

说明：

你可以假设所给定的表达式都是有效的。
请不要使用内置的库函数 eval。
 */

/**
Q3. 任务调度器

给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。
任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。
然而，两个相同种类的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。

你需要计算完成所有任务所需要的 *最短时间* 。

示例 1：

输入：tasks = ["A","A","A","B","B","B"], n = 2
输出：8
解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B
     在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。 

示例 2：

输入：tasks = ["A","A","A","B","B","B"], n = 0
输出：6
解释：在这种情况下，任何大小为 6 的排列都可以满足要求，因为 n = 0
["A","A","A","B","B","B"]
["A","B","A","B","A","B"]
["B","B","B","A","A","A"]
...
诸如此类

示例 3：

输入：tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
输出：16
解释：一种可能的解决方案是：
     A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> (待命) -> (待命) -> A -> (待命) -> (待命) -> A

提示：

1 <= task.length <= 104
tasks[i] 是大写英文字母
n 的取值范围为 [0, 100]
 */
