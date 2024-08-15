import java.util.*;

public class hard30 {

    /**
     * 超时
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int n = words.length;
        int m = words[0].length();

        if (s.length() < n * m) { return res; }


        HashSet<String> set = new HashSet<>();
        boolean[] used = new boolean[n];
        backtrack(words,used, new StringBuilder(), n, m, set);

        for (int i = 0; i < s.length() - n * m + 1; i++) {
            String sub = s.substring(i, i+n*m);
            if (set.contains(sub)) {
                res.add(i);
            }
        }

        return res;
    }

    private void backtrack(String[] word, boolean[] used, StringBuilder sb, int n, int m, HashSet<String> set) {
        if (sb.length() == n * m) {
            set.add(sb.toString());
        }

        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                sb.append(word[i]);
                used[i] = true;
                backtrack(word,used,sb,n,m,set);
                used[i] = false;
                sb.delete(sb.length() - m, sb.length());
            }
        }

    }

    public List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int wordLen = words[0].length();
        int wordNum = words.length;
        int len = s.length();
        if (len < wordNum * wordLen) { return res; }
        HashMap<String, Integer> map = new HashMap<>();
        for (String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (int winStart = 0; winStart < wordLen; winStart++) {
            int winLeft = winStart;
            int winRight = winStart;
            HashMap<String, Integer> winMap = new HashMap<>();
            while (winRight + wordLen <= len) {
                String winStr = s.substring(winRight, winRight + wordLen);
                winMap.put(winStr, winMap.getOrDefault(winStr, 0 ) + 1);
                winRight = winRight + wordLen;

                while (winMap.getOrDefault(winStr,0) > map.getOrDefault(winStr,0)) {
                    String leftStr = s.substring(winLeft, winLeft + wordLen);
                    winMap.put(leftStr, winMap.getOrDefault(leftStr, 0) - 1);
                    winLeft = winLeft + wordLen;
                }

                if (winRight - winLeft == wordNum * wordLen) {
                    res.add(winLeft);
                }

            }

        }
        return res;

    }


    class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            int wordLength = words[0].length();
            int wordNum = words.length;

            int len = s.length();
            List<Integer> result = new ArrayList<>();
            Map<String, Integer> countMap = new HashMap<>();
            // 先统计Words数组中单词出现的次数
            for(String word: words) {
                countMap.put(word, countMap.getOrDefault(word, 0) + 1);
            }

            // 使用滑动窗口,统计每个窗口内单词出现的次数, 滑动窗口的起点可以固定位一个单词的长度, 因为一个单词之后的窗口都是重复的
            for(int windowStart=0; windowStart<wordLength; windowStart ++) {
                int windLeft = windowStart;
                int windRight = windowStart;

                Map<String, Integer> windowMap = new HashMap<>();
                // 这里要保证右边界能移动到最后一个字母, 所以要有等号
                while(windRight + wordLength <= len) {
                    /*
                     * 窗口右边界持续往后移动, 同时将经过的单词统计次数
                     */
                    String word = s.substring(windRight, windRight + wordLength);
                    windowMap.put(word, windowMap.getOrDefault(word, 0) + 1);
                    windRight += wordLength;

                    /*
                     * 接下来是对左边界的移动处理了
                     * 因为按照设想, 如果窗口内出现了不满足条件的单词, 我们是需要将其踢出去的, 这个时候就移动左边界
                     * 判断条件就是用windowMap和countMap比较, 不满足条件有两种情况
                     * 一:
                     *      单词不在words数组中
                     * 二:
                     *      单词属于words数组中, 但是出现次数比words数组中的次数多
                     * 因此条件可以为: windowMap.getOrDefault(word,0)>countMap.getOrDefault(word,0)
                     * 此时, 我们就需要移动左边界开始剔除单词直到满足条件
                     * 另外, 如果上述if条件不满足, 就说明windRight经过的单词是满足串联子串条件的,
                     *       最终只要总的单词数量满足条件(windRight经过的单词数和words数组中的单词数相等)了,
                     *       那么windowLeft和windRight中间的字符串就是满足条件的子串
                     * windRight经过的单词数 (windRight-windLeft) / wordLength
                     */
                    while(windowMap.getOrDefault(word,0)>countMap.getOrDefault(word,0)) {
                        String leftWord = s.substring(windLeft, windLeft + wordLength);
                        windowMap.put(leftWord, windowMap.getOrDefault(leftWord, 0) - 1);
                        windLeft += wordLength;
                    }

                    // 窗口内 单词总数
                    int wordNumInWindow = (windRight-windLeft) / wordLength;
                    if(wordNumInWindow == wordNum) {
                        result.add(windLeft);
                    }
                }
            }
            return result;
        }
    }
}
