# leetcode2024年刷题

# 一些工具类方法

## Collections

### [排序操作](https://javaguide.cn/java/collection/java-collection-questions-02.html#排序操作)

```java
void reverse(List list)//反转
void shuffle(List list)//随机排序
void sort(List list)//按自然排序的升序排序
void sort(List list, Comparator c)//定制排序，由Comparator控制排序逻辑
void swap(List list, int i , int j)//交换两个索引位置的元素
void rotate(List list, int distance)//旋转。当distance为正数时，将list后distance个元素整体移到前面。当distance为负数时，将 list的前distance个元素整体移到后面
```

### 查找替换操作

```java
int binarySearch(List list, Object key)//对List进行二分查找，返回索引，注意List必须是有序的
int max(Collection coll)//根据元素的自然顺序，返回最大的元素。 类比int min(Collection coll)
int max(Collection coll, Comparator c)//根据定制排序，返回最大元素，排序规则由Comparatator类控制。类比int min(Collection coll, Comparator c)
void fill(List list, Object obj)//用指定的元素代替指定list中的所有元素
int frequency(Collection c, Object o)//统计元素出现次数
int indexOfSubList(List list, List target)//统计target在list中第一次出现的索引，找不到则返回-1，类比int lastIndexOfSubList(List source, list target)
boolean replaceAll(List list, Object oldVal, Object newVal)//用新元素替换旧元素
```

## System.arraycopy()函数

## 一维数组排序

使用stream流的方式来进行排序

```java
Arrays.stream(arr).boxed().sorted(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            int count1 = CalBit(o1);
            int count2 = CalBit(o2);
            if (count1 == count2) return Integer.compare(o1,o2);
            return Integer.compare(count1,count2);
        }
    }).mapToInt(Integer::intValue).toArray();
```







# 1.数组

## 1.1 做题总结与技巧

**对于数组的题目，大多使用双指针法、快慢指针法、滑动窗口方法。还有的题目需要模拟过程，要注意区间的选择，是左闭右开还是左闭右闭等。**

### 二分查找

### 双指针法

### 快慢指针法

### 滑动窗口

所谓滑动窗口，**就是不断的调节子序列的起始位置和终止位置，从而得出我们要想的结果**。

例：[209. 长度最小的子数组](https://leetcode.cn/problems/minimum-size-subarray-sum/)

用一个for循环，那么这个循环的索引，一定是表示 **滑动窗口的终止位置**。

在本题中实现滑动窗口，主要确定如下三点：

- 窗口内是什么？
- 如何移动窗口的起始位置？
- 如何移动窗口的结束位置？

窗口就是 满足其和 ≥ target 的长度最小的 连续 子数组。

窗口的起始位置如何移动：如果当前窗口的值大于target 了，窗口就要向前移动了（也就是该缩小了）。

窗口的结束位置如何移动：窗口的结束位置就是遍历数组的指针，也就是for循环里的索引。

解题的关键在于 窗口的起始位置如何移动，如图所示：

![滑动窗口](D:\Code\JavaProject\leetcode2024\leetcode2024.assets\20210312160441942.png)

可以发现**滑动窗口的精妙之处在于根据当前子序列和大小的情况，不断调节子序列的起始位置。从而将O(n^2)暴力解法降为O(n)。**

### 旋转的题目，先转一个区域，再全旋转[数组：旋转数组](https://programmercarl.com/0189.旋转数组.html)

这类题和字符转中旋转的题是一种类型

有一点要注意！

如果k大于了数组长度怎么办？ ->   `k = k%nums.length`

## 1.2 重点题目及出错的题目等

### [34. 在排序数组中查找元素的第一个和最后一个位置](https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/)

使用二分查找

其中**确定好计算出来的左边界是不包含target的左边界，左边界同理。**

```java
public class middle34 {
    public int[] searchRange(int[] nums, int target) {

        int leftBorder = getleftBorder(nums,target);
        int rightBorder = getrightBorder(nums,target);

        if (leftBorder == -2 || rightBorder == -2) {
            return new int[]{-1,-1};
        }

        if (rightBorder - leftBorder > 1) {
            return new int[]{leftBorder + 1,rightBorder - 1};
        }

        return new int[]{-1,-1};

    }


    private int getleftBorder(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int leftBorder = -2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                // 计算出来的左边界是不包含target的左边界，左边界同理。
                right = mid - 1;
                leftBorder = right;
            }
        }
        return leftBorder;
    }

    private int getrightBorder(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int rightBorder = -2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
                rightBorder = left;
            }
        }
        return rightBorder;
    }
}
```

### [844. 比较含退格的字符串](https://leetcode.cn/problems/backspace-string-compare/)

```java
//将字符数组转为String  
String.valueOf(strChars)
// 不要使用.toString()
```

### [977. 有序数组的平方](https://leetcode.cn/problems/squares-of-a-sorted-array/)

数组其实是有序的， 只不过负数平方之后可能成为最大数了。

那么数组平方的最大值就在数组的两端，不是最左边就是最右边，不可能是中间。

此时可以考虑双指针法了，i指向起始位置，j指向终止位置。

定义一个新数组result，和A数组一样的大小，让k指向result数组终止位置。

如果`A[i] * A[i] < A[j] * A[j]` 那么`result[k--] = A[j] * A[j];` 。

如果`A[i] * A[i] >= A[j] * A[j]` 那么`result[k--] = A[i] * A[i];` 。

```java
public int[] sortedSquares(int[] nums) {
    int left = 0;
    int right = nums.length - 1;
    int k = nums.length - 1;
    int[] ans = new int[nums.length];
    while (left <= right) {
        if (Math.abs(nums[left]) > Math.abs(nums[right])) {
            ans[k--] = nums[left] * nums[left];
            left++;
        } else if (Math.abs(nums[left]) <= Math.abs(nums[right])) {
            ans[k--] = nums[right] * nums[right];
            right--;
        }
    }
    return ans;
}
```

### [209. 长度最小的子数组](https://leetcode.cn/problems/minimum-size-subarray-sum/)

**滑动窗口**案例

```java
int left = 0;
int sum = 0;
int ans = Integer.MAX_VALUE;
for (int right = 0; right < nums.length; right++) {
    sum += nums[right];
    while (sum >= target) {
        int subLength = right - left + 1;
        ans = Math.min(ans, subLength);
        sum -= nums[left];
        left++;
    }
}

return ans == Integer.MAX_VALUE ? 0 : ans;
```

### [904. 水果成篮](https://leetcode.cn/problems/fruit-into-baskets/)

滑动窗口  求最大窗口

```java
public int totalFruit(int[] fruits) {
    int left = 0;
    HashMap<Integer,Integer> map = new HashMap<>();
    int ans = 0;
    for (int right = 0; right < fruits.length; right++) {
        map.put(fruits[right],map.getOrDefault(fruits[right],0) + 1);
        while (map.size() > 2 ) {
            map.put(fruits[left],map.get(fruits[left]) - 1);
            if (map.get(fruits[left]) == 0) {
                map.remove(fruits[left]);
            }
            ++left;
        }
        ans = Math.max(ans, right - left + 1);
    }
    return ans;
}
```

### [76. 最小覆盖子串](https://leetcode.cn/problems/minimum-window-substring/)

滑动窗口  求最小窗口

**如何判断滑动窗口包含了T的所有元素？**
我们用一个字典need来表示当前滑动窗口中需要的各元素的数量，一开始滑动窗口为空，用T中各元素来初始化这个need，当滑动窗口扩展或者收缩的时候，去维护这个need字典，例如当滑动窗口包含某个元素，我们就让need中这个元素的数量减1，代表所需元素减少了1个；当滑动窗口移除某个元素，就让need中这个元素的数量加1。
记住一点：need始终记录着当前滑动窗口下，我们还需要的元素数量，我们在改变i,j时，需同步维护need。
值得注意的是，只要某个元素包含在滑动窗口中，我们就会在need中存储这个元素的数量，如果某个元素存储的是负数代表这个元素是多余的。比如当need等于{'A':-2,'C':1}时，表示当前滑动窗口中，我们有2个A是多余的，同时还需要1个C。这么做的目的就是为了步骤二中，排除不必要的元素，数量为负的就是不必要的元素，而数量为0表示刚刚好。
回到问题中来，那么如何判断滑动窗口包含了T的所有元素？结论就是当need中所有元素的数量都小于等于0时，表示当前滑动窗口不再需要任何元素。
**优化**
如果每次判断滑动窗口是否包含了T的所有元素，都去遍历need看是否所有元素数量都小于等于0，这个会耗费O(k)O(k)O(k)的时间复杂度，k代表字典长度，最坏情况下，k可能等于len(S)。
其实这个是可以避免的，我们可以维护一个额外的变量needCnt来记录所需元素的总数量，当我们碰到一个所需元素c，不仅need[c]的数量减少1，同时needCnt也要减少1，这样我们通过needCnt就可以知道是否满足条件，而无需遍历字典了。
前面也提到过，need记录了遍历到的所有元素，而只有need[c]>0大于0时，代表c就是所需元素

```java
public String minWindow(String s, String t) {
    HashMap<Character,Integer> map = new HashMap<>();
    for (int i = 0; i < t.length(); i++) {
        map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0) + 1);
    }
    //将所需要的字符加入到map中，count为所需字符的数量
    int size = Integer.MAX_VALUE;
    int left = 0, count = t.length(), start = 0;   // start为最终的开始位置
    for (int right = 0; right < s.length(); right++) {
        char c = s.charAt(right);
        //如果需要该字符就减少count
        if (map.containsKey(c) && map.get(c) > 0) {
            count--;
        }
        map.put(c, map.getOrDefault(c,0)-1);
        if (count == 0) {
            //当前窗口满了
            while (map.get(s.charAt(left)) < 0) {
                // 排除不必要的字符
                map.put(s.charAt(left),map.get(s.charAt(left)) + 1);
                left++;
            }
            // 确定最小长度
            if (right - left + 1 < size) {
                size = right - left + 1;
                start = left;
            }
            //左边减小窗口
            map.put(s.charAt(left),map.get(s.charAt(left)) + 1);
            left++;
            count++;
        }
    }
    return size == Integer.MAX_VALUE ? "" : s.substring(start,start+size);
}
```

### [59. 螺旋矩阵 II](https://leetcode.cn/problems/spiral-matrix-ii/)

```java
public int[][] generateMatrix(int n) {
    //左闭右开
    int[][] ans = new int[n][n];
    int startx = 0, starty = 0;
    int loop = n/2;  //需要循环n/2次，因为是n/2层
    int count = 1;
    int offset = 1; //记录偏移，即层数
    while (loop-- > 0) {
        int i = startx;
        int j = starty;
        for (; j < n - offset; j++) {
            ans[i][j] = count;
            count++;
        }

        for (; i < n - offset; i++) {
            ans[i][j] = count;
            count++;
        }

        for (; j > starty; j--) {
            ans[i][j] = count;
            count++;
        }

        for (; i > startx; i--) {
            ans[i][j] = count;
            count++;
        }

        startx++;
        starty++;
        offset++;
    }
    if (n % 2 != 0) {
        ans[n/2][n/2] = count;
    }
    return ans;
}
```

### [54. 螺旋矩阵](https://leetcode.cn/problems/spiral-matrix/)

注意区间的左闭右开还是左闭右闭

```java
public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> ans = new ArrayList<>();
    int m = matrix.length;
    int n = matrix[0].length;
    int loop = Math.min(m,n) / 2;
    int offset = 1;
    int startx = 0, starty = 0;

    while (loop-- > 0) {
        int i = startx;
        int j = starty;
        for (; j < n - offset; j++) {
            ans.add(matrix[i][j]);
        }
        for (; i < m - offset; i++) {
            ans.add(matrix[i][j]);
        }
        for (; j > starty; j--) {
            ans.add(matrix[i][j]);
        }
        for (; i > startx; i--) {
            ans.add(matrix[i][j]);
        }
        startx++;
        starty++;
        offset++;
    }
    if (Math.min(m,n) % 2 == 1) {
        if (m > n) {
            for (int k = 0; k < loop + m - n + 1; k++) {
                ans.add(matrix[k][loop]);
            }
        } else {
            for (int k = 0; k < loop + m - n + 1; k++) {
                ans.add(matrix[loop][k]);
            }
        }
    }
    return ans;
}

public List<Integer> spiralOrder2(int[][] matrix) {
    //左闭右闭
    int m = matrix.length, n = matrix[0].length;
    List<Integer> res = new ArrayList<>();
    //上下左右
    int u = 0, d = m - 1, l = 0, r = n - 1;

    while (true) {
        for (int i = l; i <= r; i++) {
            res.add(matrix[u][i]);
        }
        if (++u > d) break;;

        for (int i = u; i <= d; i++) {
            res.add(matrix[i][r]);
        }
        if (--r < l) break;

        for (int i = r; i >= l; i--) {
            res.add(matrix[d][i]);
        }
        if (--d < u) break;

        for (int i = d; i >= u; i--) {
            res.add(matrix[i][l]);
        }
        if (++l > r) break;
    }
    return res;
}
```

### [数组：寻找数组的中心索引](https://programmercarl.com/0724.寻找数组的中心索引.html)

1. 遍历一遍求出总和sum

2. 遍历第二遍求中心索引左半和leftSum

   - 同时根据sum和leftSum 计算中心索引右半和rightSum
   - 判断leftSum和rightSum是否相同

   leftSum和rightSum是包含中心的和。

```java
public int pivotIndex(int[] nums) {
    int sum = Arrays.stream(nums).sum();
    int leftSum = 0;
    int rightSum = 0;

    for (int i = 0; i < nums.length; i++) {
        leftSum += nums[i];
        rightSum = sum - leftSum + nums[i];
        if (leftSum == rightSum) return i;
    }
    return -1;
}
```

# 2.链表

## 2.1 做题总结与技巧

掌握好插入和删除的逻辑

### 虚拟头结点

### 翻转链表、两两交换节点

### 双指针、快慢指针

### 找中点、断开、翻转、拼接

## 2.2 重点题目及出错的题目等

### [206. 反转链表](https://leetcode.cn/problems/reverse-linked-list/)

用一个temp来存cur.next，之后用将cur.next指向pre，之后更新pre为下一个即cur，最后更新cur=temp

```java
public ListNode reverseList(ListNode head) {
    ListNode pre = null;
    ListNode cur = head;
    ListNode temp;

    while (cur != null) {
        temp = cur.next;
        cur.next = pre;
        pre = cur;
        cur = temp;
    }
    return pre;
}
```

### [24. 两两交换链表中的节点](https://leetcode.cn/problems/swap-nodes-in-pairs/)

![两两交换节点](D:\Code\JavaProject\leetcode2024\leetcode2024.assets\Snipaste_2024-03-08_15-37-23.png)

```java
public ListNode swapPairs(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode cur = dummy;
    while (cur.next != null && cur.next.next != null) {
        //记录1和3节点
        ListNode tmp = cur.next;
        ListNode tmp1 = cur.next.next.next;

        cur.next = cur.next.next;
        cur.next.next = tmp;
        cur.next.next.next = tmp1;

        cur = cur.next.next;
    }
    return dummy.next;
}
```

### [19. 删除链表的倒数第 N 个结点](https://leetcode.cn/problems/remove-nth-node-from-end-of-list/)

快慢指针，首先定义一个dummy，之后让fast先走N步，之后让fast和slow走到末尾，此时slow就是要删除节点的前一个节点

只要slow和fast之间相差N-1个节点。

```java
public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode();
    dummy.next = head;
    ListNode fast = dummy;
    ListNode slow = dummy;
    for (int i = 0; i < n && fast.next != null; i++) {
        fast = fast.next;
    }
    while (fast.next != null) {
        fast = fast.next;
        slow = slow.next;
    }
    slow.next = slow.next.next;
    return dummy.next;
}
```

**[面试题 02.07. 链表相交](https://leetcode.cn/problems/intersection-of-two-linked-lists-lcci/)**一样的类型题，这个需要算出来相差多少之后确定一个是长的链表，然后快慢指针解决。

### [142. 环形链表 II](https://leetcode.cn/problems/linked-list-cycle-ii/)

先找出环再找出环的节点，其中fast指针每次两格，slow每次一格。

https://programmercarl.com/0142.%E7%8E%AF%E5%BD%A2%E9%93%BE%E8%A1%A8II.html#%E6%80%9D%E8%B7%AF

```java
public ListNode detectCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
        if (slow == fast) {
            ListNode index1 = head;
            ListNode index2 = fast;
            while (index1 != index2) {
                index1 = index1.next;
                index2 = index2.next;
            }
            return index1;
        }
    }
    return null;
}
```

### [链表：回文链表](https://programmercarl.com/0234.回文链表.html)

**反转后半部分链表**

分为如下几步：

- 用快慢指针，快指针有两步，慢指针走一步，快指针遇到终止位置时，慢指针就在链表中间位置
- 同时用pre记录慢指针指向节点的前一个节点，用来分割链表
- 将链表分为前后均等两部分，如果链表长度是奇数，那么后半部分多一个节点
- 将后半部分反转 ，得cur2，前半部分为cur1
- 按照cur1的长度，一次比较cur1和cur2的节点数值

```java
public boolean isPalindrome(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    ListNode pre = head;
    while (fast != null && fast.next != null) {
        pre = slow;
        fast = fast.next.next;
        slow = slow.next;
    }
    pre.next = null;
    ListNode cur1 = head;
    ListNode cur2 = reverseList(slow);
    while (cur1 != null) {
        if (cur1.val != cur2.val) return false;
        cur1 = cur1.next;
        cur2 = cur2.next;
    }
    return true;
}
private ListNode reverseList(ListNode head) {
    ListNode pre = null;
    ListNode cur = head;
    ListNode tmp;
    while (cur != null) {
        tmp = cur.next;
        cur.next = pre;
        pre = cur;
        cur = tmp;
    }
    return pre;
}
```

[链表：重排链表](https://programmercarl.com/0143.重排链表.html)也是相同的题型。

找中点，断开，反转后半段，再拼接。

# 3.哈希表

## 3.1 做题总结与技巧

### **当我们遇到了要快速判断一个元素是否出现集合里的时候，就要考虑哈希法**。

### **数组、map、set**都可以作为哈希表

首先在一个集合记录出现的字符串中的字符，之后再遍历并一个字符串在集合中减掉。

## 3.2 重点题目及出错的题目等

### [49. 字母异位词分组](https://leetcode.cn/problems/group-anagrams/)

将字符串转为数组进行排序，这样相同数量的字符串就会一个样子，然后加入到map里。

```java
public List<List<String>> groupAnagrams(String[] strs) {
    HashMap<String,List<String>> map = new HashMap<>();
    for (String str : strs) {
        String changeStr = change(str);
        if (map.containsKey(changeStr)) {
            map.get(changeStr).add(str);
        } else {
            List<String> list = new ArrayList<>();
            list.add(str);
            map.put(changeStr,list);
        }
    }

    List<List<String>> ans = new ArrayList<>();
    for (Map.Entry<String, List<String>> entry : map.entrySet()) {
        ans.add(entry.getValue());
    }

    return ans;
}

private String change(String s) {
    char[] chars = s.toCharArray();
    Arrays.sort(chars);
    return String.valueOf(chars);
}

public List<List<String>> groupAnagrams2(String[] strs) {
    Map<String, List<String>> map = new HashMap<String, List<String>>();
    for(String str : strs){
        char [] array = str.toCharArray();
        Arrays.sort(array);
        String key = new String(array);
        List<String> list = map.getOrDefault(key, new ArrayList<String>());
        list.add(str);
        map.put(key,list);

    }
    return new ArrayList<List<String>>(map.values());
}
```

### [438. 找到字符串中所有字母异位词](https://leetcode.cn/problems/find-all-anagrams-in-a-string/)

使用数组作为哈希表，并使用滑动窗口。

```java
public List<Integer> findAnagrams(String s, String p) {
    //O(n2)
    char[] pChar = p.toCharArray();
    Arrays.sort(pChar);
    p = String.valueOf(pChar);

    List<Integer> ans = new ArrayList<>();
    char[] sChar = s.toCharArray();
    int len = p.length();
    for (int i = 0; i < sChar.length - len + 1; i++) {
        char[] copy = Arrays.copyOfRange(sChar, i, i + len);
        Arrays.sort(copy);
        if (String.valueOf(copy).equals(p)){
            ans.add(i);
        }
    }
    return ans;
}

// 将它转变为遍历s的时候一种“消耗品”——当“消耗品”不足，唯一可以做的就是移动左窗口释放一些出来。
public List<Integer> findAnagrams2(String s, String p) {
    //O(n)  滑动窗口
    int[] p_c = new int[26];
    for(char c : p.toCharArray()) p_c[c - 'a']++;
    int left = 0;
    int right = 0;
    List<Integer> ans = new LinkedList<>();
    while(right < s.length())
    {
        if(p_c[s.charAt(right) - 'a'] > 0){
            p_c[s.charAt(right++) - 'a']--; // 消耗了一个
            if(right - left == p.length()){
                ans.add(left); // 这里不着急移，p_c不够再移
            }
        } else{
            p_c[s.charAt(left++) - 'a']++;
        }
    }
    return ans;
}
```

### [15. 三数之和](https://leetcode.cn/problems/3sum/)

**双指针法**解决，区别于[1. 两数之和](https://leetcode.cn/problems/two-sum/)和[454. 四数相加 II](https://leetcode.cn/problems/4sum-ii/)，三数之和中的数组不是独立的，需要考虑重复问题，而另两个是独立的。

其中的去重逻辑很重要。https://programmercarl.com/0015.%E4%B8%89%E6%95%B0%E4%B9%8B%E5%92%8C.html#%E7%AE%97%E6%B3%95%E5%85%AC%E5%BC%80%E8%AF%BE

```java
public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    int left,right;

    for (int i = 0; i < nums.length; i++) {
        if (nums[i] > 0) {
            // 排序之后如果第一个元素已经大于零，那么无论如何组合都不可能凑成三元组
            return result;
        }

        // 正确去重a方法
        if (i > 0 && nums[i] == nums[i-1]) {
            continue;
        }

        left = i+1;
        right = nums.length - 1;
        while (left < right) {
            if (nums[i] + nums[left] + nums[right] > 0) right--;
            else if (nums[i] + nums[left] + nums[right] < 0) left++;
            else {
                result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                // 去重逻辑应该放在找到一个三元组之后，对b 和 c去重
                while (right > left && nums[right] == nums[right - 1]) right--;
                while (right > left && nums[left] == nums[left + 1]) left++;

                right--;
                left++;
            }
        }
    }
    return result;
}
```

### [18. 四数之和](https://leetcode.cn/problems/4sum/)

https://programmercarl.com/0018.%E5%9B%9B%E6%95%B0%E4%B9%8B%E5%92%8C.html

```java
public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] > target && nums[i] >= 0) break;
        if (i > 0 && nums[i] == nums[i-1]) continue;
        for (int j = i+1; j < nums.length; j++) {
            if (nums[i]+nums[j] > target && nums[i]+nums[j] >= 0) break;
            if (j > i+1 && nums[j] == nums[j-1]) continue;
            int left = j+1;
            int right = nums.length - 1;
            while (left < right){
                int sum = nums[i]+nums[j]+nums[left]+nums[right];
                if ( sum == target){
                    res.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                    while (left<right && nums[left] == nums[left+1]) left++;
                    while (left<right && nums[right] == nums[right-1]) right--;

                    left++;
                    right--;
                }else if (sum > target){
                    right--;
                }else {
                    left++;
                }

            }
        }
    }
    return res;
}
```

# 4.字符串

## 4.1 做题总结与技巧

### **双指针**在字符串题目中很常用

### 局部翻转和全局翻转

### **KMP算法**   [6. 实现strStr())](https://programmercarl.com/0028.实现strStr.html)

```java
//获取next数组
private void getNext(int[] next, String s) {
    int j = -1;
    next[0] = j;
    for (int i = 1; i < s.length(); i++) {
        //不匹配
        while (j >= 0 && s.charAt(i) != s.charAt(j+1)) {
            j = next[j];
        }
        //匹配
        if (s.charAt(i) == s.charAt(j+1)) {
            j++;
        }
        // 将j（前缀的长度）赋给next[i]
        next[i] = j;
    }
}

//使用next数组，用模式串匹配文本串的整体代码
int j = -1; // 因为next数组里记录的起始位置为-1
for (int i = 0; i < s.size(); i++) { // 注意i就从0开始
    while(j >= 0 && s.charAt(i) != t.charAt(j+1) { // 不匹配
        j = next[j]; // j 寻找之前匹配的位置
    }
    if (s.charAt(i) == t.charAt(j+1)) { // 匹配，j和i同时向后移动
        j++; // i的增加在for循环里
    }
    if (j == (t.size() - 1) ) { // 文本串s里出现了模式串t
        return (i - t.size() + 1);
    }
}
```

## 4.2 重点题目及出错的题目等

### [541. 反转字符串 II](https://leetcode.cn/problems/reverse-string-ii/)

**当需要固定规律一段一段去处理字符串的时候，要想想在在for循环的表达式上做做文章。**

```java
public String reverseStr(String s, int k) {
    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i=i+2*k) {
        if (i + k <= chars.length) {
            //剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符
            reverse(chars,i,i+k);
            continue;
        }
        //最后的k的字符
        reverse(chars,i,chars.length);
    }
    return String.valueOf(chars);
}

private void reverse(char[] ch, int begin, int end) {
    for (int i = begin,j=end-1; i < j; i++,j--) {
        char tmp = ch[i];
        ch[i] = ch[j];
        ch[j] = tmp;
    }
}
```

### [151. 反转字符串中的单词](https://leetcode.cn/problems/reverse-words-in-a-string/)

注意删除空格时中间单词之间要留一个空格

```java
public String reverseWords(String s) {
    char[] ch = s.toCharArray();
    ch = removeExtraSpaces(ch);
    reverse(ch,0,ch.length-1);
    int start = 0;
    for (int i = 0; i <= ch.length; i++) {
        if (i == ch.length || ch[i] == ' ') {
            reverse(ch,start,i-1);
            start = i+1;
        }
    }
    return String.valueOf(ch);
}

private void reverse(char[] ch, int start, int end){ //翻转，区间写法：左闭右闭 []
    for (int i = start, j = end; i < j; i++, j--) {
        char tmp = ch[i];
        ch[i] = ch[j];
        ch[j] = tmp;
    }
}

private char[] removeExtraSpaces(char[] ch) {
    int slow = 0;
    for (int fast = 0; fast < ch.length; fast++) {
        if (ch[fast] != ' ') {
            if (slow != 0) ch[slow++] = ' '; //手动控制空格，给单词之间添加空格。slow != 0说明不是第一个单词，需要在单词前添加空格。
            while (fast < ch.length && ch[fast] != ' '){
                ch[slow++] = ch[fast++];
            }
        }
    }
    return Arrays.copyOfRange(ch,0,slow);
}
```

### [28. 找出字符串中第一个匹配项的下标](https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/)

```java
public int strStr(String haystack, String needle) {
    if (needle.length() == 0) return 0;
    int[] next = new int[needle.length()];
    getNext(next,needle);
    int j = -1;
    for (int i = 0; i < haystack.length(); i++) {
        while (j >= 0 && haystack.charAt(i) != needle.charAt(j+1)) {
            j = next[j];
        }
        if (haystack.charAt(i) == needle.charAt(j+1)) {
            j++;
        }
        if (j == needle.length()-1) {
            return (i - needle.length() + 1);
        }
    }
    return -1;

}

private void getNext(int[] next, String s) {
    int j = -1;
    next[0] = j;
    for (int i = 1; i < s.length(); i++) {
        //不匹配
        while (j >= 0 && s.charAt(i) != s.charAt(j+1)) {
            j = next[j];
        }
        //匹配
        if (s.charAt(i) == s.charAt(j+1)) {
            j++;
        }
        // 将j（前缀的长度）赋给next[i]
        next[i] = j;
    }
}
```

### [459. 重复的子字符串](https://leetcode.cn/problems/repeated-substring-pattern/)

![](D:\Code\JavaProject\leetcode2024\leetcode2024.assets\Snipaste_2024-03-08_22-33-31.png)

```java
public boolean repeatedSubstringPattern(String s) {
    int len = s.length();
    int[] next = new int[len];
    getNext(next,s);
    if (next[len-1] ！= -1 && len % (len - (next[len-1] + 1)) == 0) {
        return true;
    }
    return false;
}

private void getNext(int[] next, String s) {
    int j = -1;
    next[0] = j;
    for (int i = 1; i < s.length(); i++) {
        while (j >= 0 && s.charAt(i) != s.charAt(j+1)) {
            j = next[j];
        }
        if (s.charAt(i) == s.charAt(j+1)) {
            j++;
        }
        next[i] = j;
    }
}
```

# 5.栈和队列

## 5.1 做题总结与技巧

### 匹配问题

### 单调队列（根据场景自己设计）

### 优先级队列

## 5.2 重点题目及出错的题目等

### [225. 用队列实现栈](https://leetcode.cn/problems/implement-stack-using-queues/)

1.两个队列实现栈，  其中一个队列用作暂存，当数据进来时，将另一个队列的poll到现在的队列，之后再交换。

```java
public void push(int x) {
    queue2.offer(x);
    while (!queue1.isEmpty()) {
        queue2.offer(queue1.poll());
    }
    Deque<Integer> queuetmp = queue1;
    queue1 = queue2;
    queue2 = queuetmp;

}
```

2.一个队列实现栈， 在pop时，将队列前的内容都重新加入到队列中

```cpp
int pop() {
        int size = que.size();
        size--;
        while (size--) { // 将队列头部的元素（除了最后一个元素外） 重新添加到队列尾部
            que.push(que.front());
            que.pop();
        }
        int result = que.front(); // 此时弹出的元素顺序就是栈的顺序了
        que.pop();
        return result;
    }
```

### [239. 滑动窗口最大值](https://leetcode.cn/problems/sliding-window-maximum/)

要自己创建一个单调队列，队列里只需保留可能是当前窗口最大值的数字

```java
class MyQueue {
    //单调队列
    Deque<Integer> deque = new LinkedList<>();

    // 每次弹出的时候，比较当前要弹出的数值是否等于队列出口元素的数值，如果相等则弹出。
    // 同时pop之前判断队列当前是否为空。
    void poll(int val) {
        if (!deque.isEmpty() && val == deque.peek()) {
            deque.poll();
        }
    }

    // 如果push的数值大于入口元素的数值，那么就将队列后端的数值弹出，直到push的数值小于等于队列入口元素的数值为止。
    // 这样就保持了队列里的数值是单调从大到小的了。
    //比如此时队列元素3,1，2将要入队，比1大，所以1弹出，此时队列：3,2
    void push(int val) {
        while (!deque.isEmpty() && val > deque.getLast()) {
            deque.removeLast();
        }
        deque.add(val);
    }

    int peek() {
        return deque.peek();
    }
}

public int[] maxSlidingWindow(int[] nums, int k) {
    MyQueue queue = new MyQueue();

    int len = nums.length - k + 1;
    int[] ans = new int[len];
    int num = 0;

    for (int i = 0; i < k; i++) {
        queue.push(nums[i]);
    }
    ans[num++] = queue.peek();

    for (int i = k; i < nums.length; i++) {
        queue.poll(nums[i-k]);
        
        queue.push(nums[i]);
        
        ans[num++] = queue.peek();
    }
    return ans;
}
```

### [347. 前 K 个高频元素](https://leetcode.cn/problems/top-k-frequent-elements/)

这道题目主要涉及到如下三块内容：

1. 要统计元素出现频率  ->  map
2. 对频率排序   ->  优先级队列
3. 找出前K个高频元素  ->  小顶堆

```java
public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }

//        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(((o1, o2) -> o1[1]-o2[1]));
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            //小顶堆
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1],o2[1]);
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(new int[]{entry.getKey(),entry.getValue()});
            } else {
                if (priorityQueue.peek()[1] < entry.getValue()) {
                    priorityQueue.poll();
                    priorityQueue.add(new int[]{entry.getKey(), entry.getValue()});
                }
            }
        }

        int[] ans = new int[k];
        for (int i = k-1; i >= 0; i--) {
            ans[i] = priorityQueue.poll()[0];
        }
        return ans;
    }
```

# 6.二叉树

## 6.1 做题总结与技巧

### 递归技巧

这里帮助大家确定下来递归算法的三个要素。**每次写递归，都按照这三要素来写，可以保证大家写出正确的递归算法！**

1. **确定递归函数的参数和返回值：** 确定哪些参数是递归的过程中需要处理的，那么就在递归函数里加上这个参数， 并且还要明确每次递归的返回值是什么进而确定递归函数的返回类型。
2. **确定终止条件：** 写完了递归算法, 运行的时候，经常会遇到栈溢出的错误，就是没写终止条件或者终止条件写的不对，操作系统也是用一个栈的结构来保存每一层递归的信息，如果递归没有终止，操作系统的内存栈必然就会溢出。
3. **确定单层递归的逻辑：** 确定每一层递归需要处理的信息。在这里也就会重复调用自己来实现递归的过程。

### 递归法

#### **前序遍历**

1. **确定递归函数的参数和返回值**：因为要打印出前序遍历节点的数值，所以参数里需要传入vector来放节点的数值，除了这一点就不需要再处理什么数据了也不需要有返回值，所以递归函数返回类型就是void，代码如下：

```java
void traversal(utils.TreeNode* cur, List<Integer> list)
```

2. **确定终止条件**：在递归的过程中，如何算是递归结束了呢，当然是当前遍历的节点是空了，那么本层递归就要结束了，所以如果当前遍历的这个节点是空，就直接return，代码如下：

```java
if (cur == NULL) return;
```

3. **确定单层递归的逻辑**：前序遍历是中左右的循序，所以在单层递归的逻辑，是要先取中节点的数值，代码如下：

```java
list.add(cur->val);    // 中
traversal(cur->left, vec);  // 左
traversal(cur->right, vec); // 右
```

完整代码：

```java
private void preorder(utils.TreeNode cur, List<Integer> result) {
    if (cur == null) {
        return;
    }

    result.add(cur.val);
    preorder(cur.left,result);
    preorder(cur.right,result);
}
```

#### 中序遍历

```java
private void inorder(utils.TreeNode cur, List<Integer> result) {
    if (cur == null) {
        return;
    }

    inorder(cur.left,result);
    result.add(cur.val);
    inorder(cur.right,result);
}
```

#### 后序遍历

```java
private void postorder(utils.TreeNode cur, List<Integer> result) {
    if (cur == null) {
        return;
    }

    postorder(cur.left,result);
    postorder(cur.right,result);
    result.add(cur.val);
}
```

### 迭代法

#### 前序遍历

前序遍历是中左右，每次先处理的是中间节点，那么**先将根节点放入栈中，然后将右孩子加入栈，再加入左孩子**。

为什么要先加入 右孩子，再加入左孩子呢？ 因为这样出栈的时候才是中左右的顺序。

```java
public List<Integer> preorderTraversal(utils.TreeNode root) {
    List<Integer> result = new ArrayList<Integer>();

    Deque<utils.TreeNode> stack = new LinkedList<>();

    if (root == null) return result;
    stack.push(root);
    while (!stack.isEmpty()) {
        utils.TreeNode node = stack.pop();
        result.add(node.val);
        if (node.right != null) stack.push(node.right);
        if (node.left != null) stack.push(node.left);
    }
    return result;
}
```

#### 后序遍历

再来看后序遍历，先序遍历是中左右，后续遍历是左右中，那么我们只需要调整一下先序遍历的代码顺序，就变成中右左的遍历顺序，然后在反转result数组，输出的结果顺序就是左右中了，如下图：

![](D:\Code\JavaProject\leetcode2024\leetcode2024.assets\Snipaste_2024-03-09_10-21-56.png)

```java
public List<Integer> postorderTraversal(utils.TreeNode root) {
    List<Integer> result = new ArrayList<Integer>();
    Deque<utils.TreeNode> stack = new LinkedList<>();
    
    if (root == null) return result;
    stack.push(root);
    
    while (!stack.isEmpty()) {
        utils.TreeNode node = stack.pop();
        result.add(node.val);
        if (node.left != null) stack.push(node.left);
        if (node.right != null) stack.push(node.right);
    }

    Collections.reverse(result);
    return result;
}
```

#### 中序遍历

**需要借用指针的遍历来帮助访问节点，栈则用来处理节点上的元素。**

```java
public List<Integer> inorderTraversal(utils.TreeNode root) {
    List<Integer> result = new ArrayList<Integer>();
    Deque<utils.TreeNode> stack = new LinkedList<>();

    if (root == null) return result;
    utils.TreeNode cur = root;

    while (cur != null || !stack.isEmpty()) {
        if (cur != null) {
            //指针来访问节点 将访问的节点放进栈   往左下访问
            stack.push(cur);
            cur = cur.left;  //左
        } else {
            // 从栈里弹出的数据，就是要处理的数据（放进result数组里的数据）
            cur = stack.pop();
            result.add(cur.val);  // 中
            cur = cur.right;    //右
        }
    }
    return result;
}
```

### 统一迭代法

我们以中序遍历为例，在[二叉树：听说递归能做的，栈也能做！ (opens new window)](https://programmercarl.com/二叉树的迭代遍历.html)中提到说使用栈的话，**无法同时解决访问节点（遍历节点）和处理节点（将元素放进结果集）不一致的情况**。

**那我们就将访问的节点放入栈中，把要处理的节点也放入栈中但是要做标记。**

如何标记呢，**就是要处理的节点放入栈之后，紧接着放入一个空指针作为标记。** 这种方法也可以叫做标记法。

```java
public List<Integer> preorderTraversal(utils.TreeNode root) {
    List<Integer> result = new ArrayList<Integer>();
    Deque<utils.TreeNode> stack = new LinkedList<>();

    if (root == null) return result;
    stack.push(root);

    while (!stack.isEmpty()) {
        utils.TreeNode node = stack.pop();
        if (node != null) {
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
            stack.push(node);
            stack.push(null);
        } else {
            node = stack.pop();
            result.add(node.val);
        }
    }
    return result;
}

public List<Integer> inorderTraversal(utils.TreeNode root) {
    List<Integer> result = new ArrayList<Integer>();
    Deque<utils.TreeNode> stack = new LinkedList<>();

    if (root == null) return result;
    stack.push(root);

    while (!stack.isEmpty()) {
        utils.TreeNode node = stack.pop();
        if (node != null) {
            if (node.right != null) stack.push(node.right);
            stack.push(node);
            stack.push(null);
            if (node.left != null) stack.push(node.left);
        } else {
            node = stack.pop();
            result.add(node.val);
        }
    }
    return result;
}

public List<Integer> postorderTraversal(utils.TreeNode root) {
    List<Integer> result = new ArrayList<Integer>();
    Deque<utils.TreeNode> stack = new LinkedList<>();

    if (root == null) return result;
    stack.push(root);

    while (!stack.isEmpty()) {
        utils.TreeNode node = stack.pop();
        if (node != null) {
            stack.push(node);
            stack.push(null);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        } else {
            node = stack.pop();
            result.add(node.val);
        }
    }
    return result;
}
```

### 层次遍历

```java
public List<List<Integer>> levelOrder(utils.TreeNode root) {
    Deque<utils.TreeNode> deque = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) return res;

    deque.offer(root);

    while (!deque.isEmpty()) {
        int size = deque.size();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            utils.TreeNode node = deque.poll();
            list.add(node.val);
            if (node.left != null) deque.offer(node.left);
            if (node.right != null) deque.offer(node.right);
        }
        res.add(list);
    }
    return res;
}
```

### 求最大最小深度可以用层次遍历和后序遍历

### 求深度适合用前序遍历，而求高度适合用后序遍历。但求根节点时均可

### 递归与回溯，典型：求二叉树的所有路径

### 递归函数返回类型判定：

- 如果需要搜索整棵二叉树且不用处理递归返回值，递归函数就不要返回值。（[113. 路径总和 II](https://leetcode.cn/problems/path-sum-ii/)）
- 如果需要搜索整棵二叉树且需要处理递归返回值，递归函数就需要返回值。 （[236. 二叉树的最近公共祖先 (opens new window)](https://programmercarl.com/0236.二叉树的最近公共祖先.html)）
- 如果要搜索其中一条符合条件的路径，那么递归一定需要返回值，因为遇到符合条件的路径了就要及时返回。（[112,路径总和](https://programmercarl.com/0112.%E8%B7%AF%E5%BE%84%E6%80%BB%E5%92%8C.html#%E7%AE%97%E6%B3%95%E5%85%AC%E5%BC%80%E8%AF%BE)）
- 其实还有一种就是后序遍历需要根据左右递归的返回值推出中间节点的状态，这种需要有返回值，例如[222.完全二叉树 (opens new window)](https://programmercarl.com/0222.完全二叉树的节点个数.html)，[110.平衡二叉树 (opens new window)](https://programmercarl.com/0110.平衡二叉树.html)

### 如果递归函数有返回值，如何区分要搜索一条边，还是搜索整个树呢？

搜索一条边的写法：

```cpp
if (递归函数(root->left)) return ;

if (递归函数(root->right)) return ;
```

搜索整个树写法：

```cpp
left = 递归函数(root->left);  // 左
right = 递归函数(root->right); // 右
left与right的逻辑处理;         // 中 
```

**在递归函数有返回值的情况下：如果要搜索一条边，递归函数返回值不为空的时候，立刻返回，如果搜索整个树，直接用一个变量left、right接住返回值，这个left、right后序还有逻辑处理的需要，也就是后序遍历中处理中间节点的逻辑（也是回溯）**。

### 构造二叉树

### 要知道中序遍历下，输出的二叉搜索树节点的数值是有序序列。

### **遇到在二叉搜索树上求什么最值，求差值之类的，都要思考一下二叉搜索树可是有序的，要利用好这一特点。**

### 在递归遍历的过程中如何记录前后两个指针[24. 二叉搜索树的最小绝对差](https://programmercarl.com/0530.二叉搜索树的最小绝对差.html)

```java
utils.TreeNode pre = null;
private void traversal(utils.TreeNode cur) {
    if (cur == null) return;

    traversal(cur.left);

    if (pre != null) {
        //处理逻辑
    }
    pre = cur;

    traversal(cur.right);
}
```

### 那么二叉树如何可以自底向上查找呢？

回溯啊，二叉树回溯的过程就是从低到上。

后序遍历（左右中）就是天然的回溯过程，可以根据左右子树的返回值，来处理中节点的逻辑。



## 6.2 重点题目及出错的题目等

### [101. 对称二叉树](https://leetcode.cn/problems/symmetric-tree/)

**正是因为要遍历两棵树而且要比较内侧和外侧节点，所以准确的来说是一个树的遍历顺序是左右中，一个树的遍历顺序是右左中。**

```java
//递归法
public boolean isSymmetric(utils.TreeNode root) {
    if (root == null) return true;
    return compare(root.left,root.right);
}

private boolean compare(utils.TreeNode left, utils.TreeNode right) {

    if ((left == null && right != null) || (left != null && right == null)) return false;
    else if (left == null && right == null) return true;
    else if (left.val != right.val) return false;
    boolean outside = compare(left.left, right.right);
    boolean inside = compare(left.right, right.left);
    boolean isSame = outside && inside;
    return isSame;
}
//迭代法
public boolean isSymmetric2(utils.TreeNode root) {
        if (root == null) return true;
        Queue<utils.TreeNode> deque = new LinkedList<>();
        deque.offer(root.left);
        deque.offer(root.right);
        while (!deque.isEmpty()) {
            utils.TreeNode leftNode = deque.poll();
            utils.TreeNode rightNode = deque.poll();
            if (leftNode == null && rightNode == null) {
                continue;
            }
            if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
                return false;
            }

            deque.offer(leftNode.left);
            deque.offer(rightNode.right);
            deque.offer(leftNode.right);
            deque.offer(rightNode.left);
        }
        return true;
    }
```

### [110. 平衡二叉树](https://leetcode.cn/problems/balanced-binary-tree/)

**求高度用前序遍历**

返回-1表示高度差大于1

```java
public boolean isBalanced(utils.TreeNode root) {
    return getHeight(root) == -1 ? false : true;
}

private int getHeight(utils.TreeNode cur) {
    if (cur == null) return 0;
    int leftHeight = getHeight(cur.left);
    if (leftHeight == -1) return -1;

    int rightHeight = getHeight(cur.right);
    if (rightHeight == -1) return -1;

    if (Math.abs(leftHeight-rightHeight) > 1) {
        return -1;
    } else {
        return Math.max(leftHeight,rightHeight) + 1;
    }
}
```

### [257. 二叉树的所有路径](https://leetcode.cn/problems/binary-tree-paths/)

**递归中包含着回溯**

采用前序遍历

1. **函数所需参数**：`utils.TreeNode cur, List<Integer> path, List<String> res`

2. **终止条件**：遇到叶子结点

3. **单层逻辑**

因为是前序遍历，需要先处理中间节点，中间节点就是我们要记录路径上的节点，先放进path中。

```
path.push_back(cur->val);
```

之后进去递归

```java
if (cur.left != null) {
        traversal(cur.left,path,res);
        path.remove(path.size()-1);
    }
if (cur.right != null) {
      	traversal(cur.right,path,res);
        path.remove(path.size()-1);
    }
```

递归完，要做回溯，因为path 不能一直加入节点，它还要删节点，然后才能加入新的节点。

**整体代码：**


```java
public List<String> binaryTreePaths(utils.TreeNode root) {
    List<Integer> path = new ArrayList<>();
    List<String> res = new ArrayList<>();
    if (root == null) return res;
    traversal(root,path,res);
    return res;
}

private void traversal(utils.TreeNode cur, List<Integer> path, List<String> res) {
    path.add(cur.val);

    if (cur.left == null && cur.right == null) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < path.size() - 1; i++) {
            sb.append(path.get(i));
            sb.append("->");
        }
        sb.append(path.get(path.size()-1));
        res.add(sb.toString());
        return;
    }

    if (cur.left != null) {
        traversal(cur.left,path,res);
        path.remove(path.size()-1);
    }
    if (cur.right != null) {
        traversal(cur.right,path,res);
        path.remove(path.size()-1);
    }
}
```

### [404. 左叶子之和](https://leetcode.cn/problems/sum-of-left-leaves/)

**判断当前节点是不是左叶子是无法判断的，必须要通过节点的父节点来判断其左孩子是不是左叶子。**

```cpp
if (node->left != NULL && node->left->left == NULL && node->left->right == NULL) {
    左叶子节点处理逻辑
}
```

**递归的遍历顺序为后序遍历（左右中），是因为要通过递归函数的返回值来累加求取左叶子数值之和。**

```java
public int sumOfLeftLeaves(utils.TreeNode root) {
    if (root == null) return 0;

    int leftSum = sumOfLeftLeaves(root.left);
    if (root.left != null && root.left.left == null && root.left.right == null) {
        leftSum = root.left.val;
    }

    int rightSum = sumOfLeftLeaves(root.right);

    return leftSum + rightSum;
}
```

### [26. 二叉树的最近公共祖先](https://programmercarl.com/0236.二叉树的最近公共祖先.html)

**归纳如下三点**：

1. 求最小公共祖先，需要从底向上遍历，那么二叉树，只能通过后序遍历（即：回溯）实现从底向上的遍历方式。
2. **在回溯的过程中，必然要遍历整棵二叉树，即使已经找到结果了，依然要把其他节点遍历完，因为要使用递归函数的返回值（也就是代码中的left和right）做逻辑判断。**
3. 要理解如果返回值left为空，right不为空为什么要返回right，为什么可以用返回right传给上一层结果。

```java
public utils.TreeNode lowestCommonAncestor(utils.TreeNode root, utils.TreeNode p, utils.TreeNode q) {
    if (root == p || root == q || root == null) return root;
    utils.TreeNode left = lowestCommonAncestor(root.left,p,q);
    utils.TreeNode right = lowestCommonAncestor(root.right,p,q);

    if (left != null && right != null) return root;

    if (left != null && right == null) return left;
    else if (left == null && right != null) return right;
    else {
        return null;
    }
}
```

### [28. 二叉搜索树的最近公共祖先](https://programmercarl.com/0235.二叉搜索树的最近公共祖先.html)

由于二叉搜索树的特性，只需要查找第一个在[p,q]之间的节点就是最近公共祖先，所以本题不需要遍历全部节点，当找到结果时即可返回。

```java
/**
 * 递归法
 * @param root
 * @param p
 * @param q
 * @return
 */
public utils.TreeNode lowestCommonAncestor(utils.TreeNode root, utils.TreeNode p, utils.TreeNode q) {
    if (root == null) return root;
    if (root.val < p.val && root.val < q.val) {
        utils.TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (right != null) {
            return right;
        }
    }

    if (root.val > p.val && root.val > q.val) {
        utils.TreeNode left = lowestCommonAncestor(root.left, p, q);
        if (left != null) {
            return left;
        }
    }

    return root;

}

/**
 * 迭代法
 * @param root
 * @param p
 * @param q
 * @return
 */
public utils.TreeNode lowestCommonAncestor2(utils.TreeNode root, utils.TreeNode p, utils.TreeNode q) {
    while (true) {
        if (root.val > p.val && root.val > q.val) {
            root = root.left;
        } else if (root.val < p.val && root.val < q.val) {
            root = root.right;
        } else {
            break;
        }
    }
    return root;
}
```

### [30. 删除二叉搜索树中的节点](https://programmercarl.com/0450.删除二叉搜索树中的节点.html)

这里就把二叉搜索树中删除节点遇到的情况都搞清楚。

有以下五种情况：

- 第一种情况：没找到删除的节点，遍历到空节点直接返回了
- 找到删除的节点
  - 第二种情况：左右孩子都为空（叶子节点），直接删除节点， 返回NULL为根节点
  - 第三种情况：删除节点的左孩子为空，右孩子不为空，删除节点，右孩子补位，返回右孩子为根节点
  - 第四种情况：删除节点的右孩子为空，左孩子不为空，删除节点，左孩子补位，返回左孩子为根节点
  - 第五种情况：左右孩子节点都不为空，则将删除节点的左子树头结点（左孩子）放到删除节点的右子树的最左面节点的左孩子上，返回删除节点右孩子为新的根节点。

```java
public utils.TreeNode deleteNode(utils.TreeNode root, int key) {
    if (root == null) return root;

    if (root.val == key) {
        if (root.left == null && root.right == null) return null;
        else if (root.left != null && root.right == null) return root.left;
        else if (root.left == null && root.right != null) return root.right;
        else {
            utils.TreeNode node = root.right;
            while (node.left != null) {
                node = node.left;
            }
            node.left = root.left;
            root = root.right;
            return root;
        }
    }

    if (root.val > key) {
        root.left = deleteNode(root.left,key);
    }

    if (root.val < key) {
        root.right = deleteNode(root.right,key);
    }

    return root;
}
```

### [31. 修剪二叉搜索树](https://programmercarl.com/0669.修剪二叉搜索树.html)

```java
public utils.TreeNode trimBST(utils.TreeNode root, int low, int high) {
    if (root == null) return null;

    if (root.val < low) {
        utils.TreeNode right = trimBST(root.right, low, high);
        return right;
    }

    if (root.val > high) {
        utils.TreeNode left = trimBST(root.left, low, high);
        return left;
    }

    root.left = trimBST(root.left,low,high);
    root.right = trimBST(root.right,low,high);

    return root;
}
```

# 7.回溯

## 7.1 做题总结与技巧

### 回溯法，一般可以解决如下几种问题：

- 组合问题：N个数里面按一定规则找出k个数的集合
- 切割问题：一个字符串按一定规则有几种切割方式
- 子集问题：一个N个数的集合里有多少符合条件的子集
- 排列问题：N个数按一定规则全排列，有几种排列方式
- 棋盘问题：N皇后，解数独等等

### **组合是不强调元素顺序的，排列是强调元素顺序**。

### 回溯的理解

**回溯法解决的问题都可以抽象为树形结构**，是的，我指的是所有回溯法的问题都可以抽象为树形结构！

因为回溯法解决的都是在集合中递归查找子集，**集合的大小就构成了树的宽度，递归的深度，都构成的树的深度**。

递归就要有终止条件，所以必然是一棵高度有限的树（N叉树）。

### 回溯法模板

- 回溯函数模板返回值以及参数

在回溯算法中，我的习惯是函数起名字为backtracking，这个起名大家随意。

回溯算法中函数返回值一般为void。

再来看一下参数，因为回溯算法需要的参数可不像二叉树递归的时候那么容易一次性确定下来，所以一般是先写逻辑，然后需要什么参数，就填什么参数。

但后面的回溯题目的讲解中，为了方便大家理解，我在一开始就帮大家把参数确定下来。

回溯函数伪代码如下：

```text
void backtracking(参数)
```

- 回溯函数终止条件

既然是树形结构，那么我们在讲解[二叉树的递归 (opens new window)](https://programmercarl.com/二叉树的递归遍历.html)的时候，就知道遍历树形结构一定要有终止条件。

所以回溯也有要终止条件。

什么时候达到了终止条件，树中就可以看出，一般来说搜到叶子节点了，也就找到了满足条件的一条答案，把这个答案存放起来，并结束本层递归。

所以回溯函数终止条件伪代码如下：

```text
if (终止条件) {
    存放结果;
    return;
}
```

- 回溯搜索的遍历过程

在上面我们提到了，回溯法一般是在集合中递归搜索，集合的大小构成了树的宽度，递归的深度构成的树的深度。

![](D:\Code\JavaProject\leetcode2024\leetcode2024.assets\Snipaste_2024-03-10_10-46-36.png)

注意图中，我特意举例集合大小和孩子的数量是相等的！

回溯函数遍历过程伪代码如下：

```text
for (选择：本层集合中元素（树中节点孩子的数量就是集合的大小）) {
    处理节点;
    backtracking(路径，选择列表); // 递归
    回溯，撤销处理结果
}
```

for循环就是遍历集合区间，可以理解一个节点有多少个孩子，这个for循环就执行多少次。

backtracking这里自己调用自己，实现递归。

大家可以从图中看出**for循环可以理解是横向遍历，backtracking（递归）就是纵向遍历**，这样就把这棵树全遍历完了，一般来说，搜索叶子节点就是找的其中一个结果了。

**回溯算法模板框架如下：**

```text
void backtracking(参数) {
    if (终止条件) {
        存放结果;
        return;
    }

    for (选择：本层集合中元素（树中节点孩子的数量就是集合的大小）) {
        处理节点;
        backtracking(路径，选择列表); // 递归
        回溯，撤销处理结果
    }
}
```

### **对于组合问题，什么时候需要startIndex呢？**

我举过例子，如果是一个集合来求组合的话，就需要startIndex，例如：[77.组合 (opens new window)](https://programmercarl.com/0077.组合.html)，[216.组合总和III (opens new window)](https://programmercarl.com/0216.组合总和III.html)。

如果是多个集合取组合，各个集合之间相互不影响，那么就不用startIndex，例如：[17.电话号码的字母组合(opens new window)](https://programmercarl.com/0017.电话号码的字母组合.html)

**注意以上我只是说求组合的情况，如果是排列问题，又是另一套分析的套路，后面我在讲解排列的时候会重点介绍**。

### 对于元素能够重复取的问题：


在[2. 组合问题](https://programmercarl.com/0077.组合.html)元素只能取一次，所以`backtracking(candidates,target-candidates[i],i+1);`中index要传`i+1`来防止元素重复

在[7. 组合总和](https://programmercarl.com/0039.组合总和.html)元素能重复取，所以`backtracking(candidates,target-candidates[i],i);`中index要传`i`来能够重复取元素

### 树层去重与树枝去重(重点！！！)

#### 树层去重和树枝去重

```text
used[i - 1] == true，说明同一树枝candidates[i - 1]使用过
used[i - 1] == false，说明同一树层candidates[i - 1]使用过
```

**树层去重：**[8. 组合总和II](https://programmercarl.com/0040.组合总和II.html)    [13. 子集II](https://programmercarl.com/0090.子集II.html)   集合里面有了重复元素，求无序的集合和子集时要去重

```cpp
if (i > 0 && candidates[i] == candidates[i - 1] && used[i - 1] == false) {
        continue;
    }
```

#### 去重需要先排序！！！！！

#### 遇到无法排序的怎么办？（[14. 递增子序列](https://programmercarl.com/0491.递增子序列.html)），在每层用set来去重。

```java
private void backtracking(int[] nums, int startIndex) {
    if (path.size() > 1) {
        res.add(new ArrayList<>(path));
    }
    HashSet<Integer> set = new HashSet<>();
    for (int i = startIndex; i < nums.length; i++) {

        if (path.size() > 0 && path.getLast() > nums[i] || set.contains(nums[i])) {
            continue;
        }

        path.add(nums[i]);
        set.add(nums[i]);
        backtracking(nums,i+1);
        path.removeLast();
    }
}
```



### 如果把 子集问题、组合问题、分割问题都抽象为一棵树的话，**那么组合问题和分割问题都是收集树的叶子节点，而子集问题是找树的所有节点！**

**所以子集问题不需要在`if(判断逻辑)`中`return`，而组合问题、分割问题需要。**

其实子集也是一种组合问题，因为它的集合是无序的，子集{1,2} 和 子集{2,1}是一样的。

**那么既然是无序，取过的元素不会重复取，写回溯算法的时候，for就要从startIndex开始，而不是从0开始！**

### 子集问题、组合问题、分割问题是无序的，取过的元素不会重复取，写回溯算法的时候，for就要从startIndex开始，而不是从0开始！（重点！！！！）

### 排列问题是有序的，取过的还可以再取，就不用使用startIndex了，但排列问题需要一个used数组，标记已经选择的元素。

#### 排列问题的不同：

- 每层都是从0开始搜索而不是startIndex
- 需要used数组记录path里都放了哪些元素了

### **一般来说：组合问题和排列问题是在树形结构的叶子节点上收集结果，而子集问题就是取树上所有节点的结果**。



## 7.2 重点题目及出错的题目等

### [2. 组合问题](https://programmercarl.com/0077.组合.html)

#### 初始

**startIndex 就是防止出现重复的组合**。

从下图中红线部分可以看出，在集合[1,2,3,4]取1之后，下一层递归，就要在[2,3,4]中取数了，那么下一层递归如何知道从[2,3,4]中取数呢，靠的就是startIndex。

![](D:\Code\JavaProject\leetcode2024\leetcode2024.assets\Snipaste_2024-03-10_11-02-17.png)

所以需要startIndex来记录下一层递归，搜索的起始位置。

```java
List<List<Integer>> res = new ArrayList<>();
LinkedList<Integer> path=  new LinkedList<>();
public List<List<Integer>> combine(int n, int k) {
    backtracking(n,k,1);
    return res;
}

private void backtracking(int n, int k, int startIndex) {
    if (path.size() == k) {
        res.add(new ArrayList<>(path));
        return;
    }

    for (int i = startIndex; i <= n; i++) {
        path.add(i);
        backtracking(n,k,i+1);
        path.removeLast();
    }
}
```

#### 剪枝优化

**所以，可以剪枝的地方就在递归中每一层的for循环所选择的起始位置**。

**如果for循环选择的起始位置之后的元素个数 已经不足 我们需要的元素个数了，那么就没有必要搜索了**。

![](D:\Code\JavaProject\leetcode2024\leetcode2024.assets\Snipaste_2024-03-10_11-04-58.png)

接下来看一下优化过程如下：

1. 已经选择的元素个数：path.size();
2. 还需要的元素个数为: k - path.size();
3. 在集合n中至多要从该起始位置 : n - (k - path.size()) + 1，开始遍历

为什么有个+1呢，因为包括起始位置，我们要是一个左闭的集合。

所以优化之后的for循环是：

```text
for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) // i为本次搜索的起始位
```

优化后整体代码：

```java
List<List<Integer>> res = new ArrayList<>();
LinkedList<Integer> path=  new LinkedList<>();
public List<List<Integer>> combine(int n, int k) {
    backtracking(n,k,1);
    return res;
}

private void backtracking(int n, int k, int startIndex) {
    if (path.size() == k) {
        res.add(new ArrayList<>(path));
        return;
    }

    for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
        path.add(i);
        backtracking(n,k,i+1);
        path.removeLast();
    }
}
```

### [8. 组合总和II](https://programmercarl.com/0040.组合总和II.html)

直接看代码随想录讲解

```java
List<List<Integer>> res = new ArrayList<>();
LinkedList<Integer> path = new LinkedList<>();
public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    boolean[] used = new boolean[candidates.length];
    backtracking(candidates,target,0,used);
    return res;
}

private void backtracking(int[] candidates, int target, int startIndex, boolean[] used) {

    if (target == 0) {
        res.add(new ArrayList<>(path));
        return;
    }

    for (int i = startIndex; i < candidates.length && target - candidates[i] >= 0; i++) {
        if (i > 0 && candidates[i] == candidates[i-1] && used[i-1] == false) {
            continue;
        }

        path.add(candidates[i]);
        used[i] = true;
        backtracking(candidates,target-candidates[i],i+1,used);
        used[i] = false;
        path.removeLast();
    }
}
```

### [9. 分割回文串](https://programmercarl.com/0131.分割回文串.html)

- 切割问题可以抽象为组合问题
- 如何模拟那些切割线
- 切割问题中递归如何终止
- 在递归循环中如何截取子串
- 如何判断回文

![](D:\Code\JavaProject\leetcode2024\leetcode2024.assets\Snipaste_2024-03-10_14-26-09.png)

```java
List<List<String>> res = new ArrayList<>();
LinkedList<String> path = new LinkedList<>();
public List<List<String>> partition(String s) {
    backtracking(s,0);
    return res;
}

private void backtracking(String s, int startIndex) {
    if (startIndex >= s.length()) {
        res.add(new ArrayList<>(path));
        return;
    }

    for (int i = startIndex; i < s.length(); i++) {
        if (huiWen(s,startIndex,i)) {
            path.add(s.substring(startIndex,i+1));
        } else {
            continue;
        }
        backtracking(s,i+1);
        path.removeLast();
    }
}

private boolean huiWen(String s, int left, int right) {
    for (int i = left,j=right; i < j; i++,j--) {
        if (s.charAt(i) != s.charAt(j)) {
            return false;
        }
    }
    return true;
}
```

### [10. 复原IP地址](https://programmercarl.com/0093.复原IP地址.html)

也是切分问题

```java
List<String> res = new ArrayList<>();
public List<String> restoreIpAddresses(String s) {
    backtracking(new StringBuilder(s),0,0);
    return res;
}

/**
 *
 * @param sb
 * @param startIndex
 * @param pointNum  记录加点的数量
 */
private void backtracking(StringBuilder sb, int startIndex, int pointNum) {
    if (pointNum == 3) {
        if (Valid(sb, startIndex, sb.length()-1)) {
            res.add(new String(sb));
        }
        return;
    }

    for (int i = startIndex; i < sb.length(); i++) {
        if (Valid(sb,startIndex,i)) {
            pointNum++;
            sb.insert(i+1,'.');
            backtracking(sb,i+2,pointNum);
            sb.deleteCharAt(i+1);
            pointNum--;
        } else continue;
    }

}

/**
 * 段位以0为开头的数字不合法
 * 段位里有非正整数字符不合法
 * 段位如果大于255了不合法
 * @param sb
 * @param start
 * @param end
 * @return
 */
private boolean Valid(StringBuilder sb, int start, int end) {
    if (start > end) {
        return false;
    }
    if (sb.charAt(start) == '0' && start != end) {
        return false;
    }

    int num = 0;
    for (int i = start; i <= end; i++) {
        if (sb.charAt(i) > '9' || sb.charAt(i) < '0') {
            return false;
        }
        num = num * 10 + sb.charAt(i) - '0';
        if (num > 255) return false;
    }
    return true;
}
```

### [14. 递增子序列](https://programmercarl.com/0491.递增子序列.html)

**遇到无法排序的怎么办？**

**在每层用set来去重。**

```java
List<List<Integer>> res = new ArrayList<>();
LinkedList<Integer> path = new LinkedList<>();
public List<List<Integer>> findSubsequences(int[] nums) {
    backtracking(nums,0);
    return res;
}

private void backtracking(int[] nums, int startIndex) {
    if (path.size() > 1) {
        res.add(new ArrayList<>(path));
    }
    HashSet<Integer> set = new HashSet<>();
    for (int i = startIndex; i < nums.length; i++) {

        if (path.size() > 0 && path.getLast() > nums[i] || set.contains(nums[i])) {
            continue;
        }

        path.add(nums[i]);
        set.add(nums[i]);
        backtracking(nums,i+1);
        path.removeLast();
    }
}
```

### [15. 全排列](https://programmercarl.com/0046.全排列.html)

处理排列问题就不用使用startIndex了。

但排列问题需要一个used数组，标记已经选择的元素，如图橘黄色部分所示:

![](D:\Code\JavaProject\leetcode2024\leetcode2024.assets\Snipaste_2024-03-10_19-16-39.png)

```java
List<List<Integer>> res = new ArrayList<>();
LinkedList<Integer> path = new LinkedList<>();
public List<List<Integer>> permute(int[] nums) {
    boolean[] used = new boolean[nums.length];
    backtracking(nums,used);
    return res;
}

private void backtracking(int[] nums, boolean[] used) {
    if (nums.length == path.size()) {
        res.add(new ArrayList<>(path));
    }

    for (int i = 0; i < nums.length; i++) {
        if (used[i] == true) continue;
        used[i] = true;
        path.add(nums[i]);
        backtracking(nums,used);
        path.removeLast();
        used[i] = false;
    }
}
```

### [19. 重新安排行程](https://programmercarl.com/0332.重新安排行程.html)

hard题

**这道题目有几个难点：**

1. 一个行程中，如果航班处理不好容易变成一个圈，成为死循环 `key为起点，value是有序的终点的列表Map<String, Map<String, Integer>> map;，其中value是航班次数，如大于0则代表该机场没飞过`
2. 有多种解法，字母序靠前排在前面，让很多同学望而退步，如何该记录映射关系呢 ？ `Map<String, Map<String, Integer>> map;`
3. 使用回溯法（也可以说深搜） 的话，那么终止条件是什么呢？  `if(res.size() == ticketNum + 1){return true;}`
4. 搜索的过程中，如何遍历一个机场所对应的所有机场。`在Map里取出当前的机场所能飞的机场`

```java
private Deque<String> res;
//key为起点，value是有序的终点的列表
private Map<String, Map<String, Integer>> map;

private boolean backTracking(int ticketNum){
    if(res.size() == ticketNum + 1){
        return true;
    }
    String last = res.getLast();
    if(map.containsKey(last)){//防止出现null
        for(Map.Entry<String, Integer> target : map.get(last).entrySet()){
            int count = target.getValue();
            if(count > 0){ // 记录到达机场是否飞过了
                res.add(target.getKey());
                target.setValue(count - 1);
                if(backTracking(ticketNum)) return true;
                res.removeLast();
                target.setValue(count);
            }
        }
    }
    return false;
}

public List<String> findItinerary(List<List<String>> tickets) {
    map = new HashMap<String, Map<String, Integer>>();
    res = new LinkedList<>();
    for(List<String> t : tickets){
        //将到达机场进行字典排序
        Map<String, Integer> temp;
        if(map.containsKey(t.get(0))){
            temp = map.get(t.get(0));
            temp.put(t.get(1), temp.getOrDefault(t.get(1), 0) + 1);
        }else{
            temp = new TreeMap<>();//升序Map
            temp.put(t.get(1), 1);
        }
        map.put(t.get(0), temp);

    }
    res.add("JFK");
    backTracking(tickets.size());
    return new ArrayList<>(res);
}
```

### [20. N皇后](https://programmercarl.com/0051.N皇后.html)和[21. 解数独](https://programmercarl.com/0037.解数独.html)

hard题

N皇后是一层for循环

解数独是两层for循环

**N皇后问题代码：**

```java
List<List<String>> res = new ArrayList<>();
public List<List<String>> solveNQueens(int n) {
    char[][] chessboard = new char[n][n];
    for (int i = 0; i < chessboard.length; i++) {
        for (int j = 0; j < chessboard[i].length; j++) {
            chessboard[i][j] = '.';
        }
    }
    backtracking(n,0,chessboard);
    return res;
}

private void backtracking(int n, int row, char[][] chessboard) {
    if (row == n) {
        res.add(Array2List(chessboard));
        return;
    }

    for (int col = 0; col < n; col++) {
        if (Valid(row,col,chessboard,n)) {
            chessboard[row][col] = 'Q';
            row++;
            backtracking(n,row,chessboard);
            row--;
            chessboard[row][col] = '.';
        }
    }
}

private boolean Valid(int row, int col, char[][] chessboard, int n) {

    for (int i = 0; i < row; i++) {
        if (chessboard[i][col] == 'Q') {
            return false;
        }
    }

    for (int i = row - 1,j = col - 1; i >= 0 && j >= 0 ; i--,j--) {
        if (chessboard[i][j] == 'Q') {
            return false;
        }
    }

    for (int i = row - 1,j = col + 1; i >= 0 && j < n ; i--,j++) {
        if (chessboard[i][j] == 'Q') {
            return false;
        }
    }
    return true;
}

private List Array2List(char[][] chessboard) {
    List<String> list = new ArrayList<>();
    for (char[] chars : chessboard) {
        list.add(String.copyValueOf(chars));
    }
    return list;
}
```

**解数独问题代码：**

```java
public void solveSudoku(char[][] board) {
    backtracking(board);
}

private boolean backtracking(char[][] board) {
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
            if (board[i][j] != '.') continue;
            for (char k = '1'; k <= '9'; k++) {
                if (isValid(i,j,k,board)) {
                    board[i][j] = k;
                    if (backtracking(board)) return true; // 如果找到合适一组立刻返回
                    board[i][j] = '.';
                }
            }
            return false; // 9个数都试完了，都不行，那么就返回false
        }
    }
    return true; // 遍历完没有返回false，说明找到了合适棋盘位置了
}

private boolean isValid(int row, int col, char val, char[][] board) {

    for (int i = 0; i < 9; i++) {
        if (board[row][i] == val) {
            return false;
        }
    }

    for (int i = 0; i < 9; i++) {
        if (board[i][col] == val) {
            return false;
        }
    }

    int x = (row / 3) * 3;
    int y = (col / 3) * 3;
    for (int i = x; i < x + 3; i++) {
        for (int j = y; j < y + 3; j++) {
            if (board[i][j] == val) {
                return false;
            }
        }
    }
    return true;
}
```

# 8. 动态规划

## 8.1 做题总结与技巧

### **对于动态规划问题，我将拆解为如下五步曲，这五步都搞清楚了，才能说把动态规划真的掌握了！**

1. 确定`dp`数组（`dp table`）以及下标的含义
2. 确定递推公式
3. `dp`数组如何初始化
4. 确定遍历顺序
5. 举例推导`dp`数组

### 背包问题预览(对于面试的话，只需掌握0-1背包、完全背包，最多可以再来一个多重背包)

![](D:\Code\JavaProject\leetcode2024\leetcode2024.assets\Snipaste_2024-03-11_09-06-41.png)

## 8.1.1.  0-1背包问题

#### 问题概念

有n件物品和一个最多能背重量为w 的背包。第i件物品的重量是`weight[i]`，得到的价值是`value[i] `。**每件物品只能用一次**，求解将哪些物品装入背包里物品价值总和最大。

#### 二维数组

#### 确定dp数组以及下标的含义

使用二维数组，**`dp[i][j]` 表示从下标为[0-i]的物品里任意取，放进容量为j的背包，价值总和最大是多少**。

#### 确定递推公式

- **不放物品i**：由`dp[i - 1][j]`推出，即背包容量为j，里面不放物品i的最大价值，此时`dp[i][j]`就是`dp[i - 1][j]`。(其实就是当物品i的重量大于背包j的重量时，物品i无法放进背包中，所以背包内的价值依然和前面相同。)
- **放物品i**：由`dp[i - 1][j - weight[i]]`推出，`dp[i - 1][j - weight[i]] `为背包容量为`j - weight[i]`的时候不放物品i的最大价值，那么`dp[i - 1][j - weight[i]] + value[i] `（物品i的价值），就是背包放物品i得到的最大价值

所以递归公式： `dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);`

#### dp数组如何初始化

```text
for (int j = 0 ; j < weight[0]; j++) {  // 当然这一步，如果把dp数组预先初始化为0了，这一步就可以省略，但很多同学应该没有想清楚这一点。
    dp[0][j] = 0;
}
// 正序遍历
for (int j = weight[0]; j <= bagweight; j++) {
    dp[0][j] = value[0];
}
```

![](D:\Code\JavaProject\leetcode2024\leetcode2024.assets\Snipaste_2024-03-11_09-13-12.png)

#### 遍历顺序

##### **先遍历物品，然后遍历背包重量**

```text
// weight数组的大小 就是物品个数
for(int i = 1; i < weight.size(); i++) { // 遍历物品
    for(int j = 0; j <= bagweight; j++) { // 遍历背包容量
        if (j < weight[i]) dp[i][j] = dp[i - 1][j];
        else dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
    }
}
```

##### **先遍历背包，再遍历物品，也是可以的！**

```text
// weight数组的大小 就是物品个数
for(int j = 0; j <= bagweight; j++) { // 遍历背包容量
    for(int i = 1; i < weight.size(); i++) { // 遍历物品
        if (j < weight[i]) dp[i][j] = dp[i - 1][j];
        else dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
    }
}
```

#### ===============================================

#### 滚动数组

#### 确定dp数组以及下标的含义

`dp[j]`表示：容量为j的背包，所背的物品价值可以最大为`dp[j]`。

#### 递推公式

```text
dp[j] = max(dp[j], dp[j - weight[i]] + value[i]);
```

#### 初始化

dp数组初始化的时候，都初始为0就可以了。

#### 遍历顺序

二维dp遍历的时候，背包容量是从小到大，而一维dp遍历的时候，背包是从大到小。

倒序遍历的原因是，本质上还是一个对二维数组的遍历，并且右下角的值依赖上一层左上角的值，因此需要保证左边的值仍然是上一层的，从右向左覆盖。

```text
for(int i = 0; i < weight.size(); i++) { // 遍历物品
    for(int j = bagWeight; j >= weight[i]; j--) { // 遍历背包容量
        dp[j] = max(dp[j], dp[j - weight[i]] + value[i]);
    }
}
```

#### 完整代码：

```java
/**
 * 二维数组
 * @param weight
 * @param value
 * @param bagSize
 * @return
 */
public int Bag0And1Problem(int[] weight, int[] value, int bagSize) {
    int[][] dp = new int[weight.length][bagSize+1];
    for (int j = weight[0]; j <= bagSize; j++) {
        dp[0][j] = value[0];
    }

    for (int i = 1; i < weight.length; i++) {
        for (int j = 0; j <= bagSize; j++) {
            if (j < weight[i]) dp[i][j] = dp[i-1][j];
            else dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight[i]] + value[i]);
        }
    }
    return dp[weight.length-1][bagSize];
}


/**
 * 滚动数组
 * @param weight
 * @param value
 * @param bagSize
 * @return
 */
public int Bag0And1Problem2(int[] weight, int[] value, int bagSize) {
    int[] dp = new int[bagSize+1];

    for (int i = 0; i < weight.length; i++) {
        for (int j = bagSize; j >= weight[i]; j--) {
            dp[j] = Math.max(dp[j], dp[j-weight[i]] + value[i]);
        }
    }

    return dp[bagSize];
}
```

#### 求具体方案：

```java
/**
 * 具体方案
 * @param weight
 * @param value
 * @param bagSize
 * @return
 */
public static int Bag0And1Problem2Plus(int[] weight, int[] value, int bagSize) {
    int[] dp = new int[bagSize+1];

    for (int i = 0; i < weight.length; i++) {
        for (int j = bagSize; j >= weight[i]; j--) {
            dp[j] = Math.max(dp[j], dp[j-weight[i]] + value[i]);
        }
    }

    // 回溯求解具体方案
    List<Integer> solution = new ArrayList<>();
    int remainingCapacity = bagSize;
    for (int i = weight.length - 1; i >= 0; i--) {
        if (remainingCapacity >= weight[i] && dp[remainingCapacity] == dp[remainingCapacity - weight[i]] + value[i]) {
            solution.add(0,(i + 1));
            remainingCapacity -= weight[i];
        }
    }
    for (int i = 0; i < solution.size(); i++) {
        System.out.print(solution.get(i) + " ");
    }

    return dp[bagSize];
}
```

### 0-1背包几种类型

#### 1.求容量为j的背包，最多能装多少。

递推公式：**`dp[j] = max(dp[j], dp[j - nums[i]] + nums[i]);`**

```java
dp[j] = max(dp[j], dp[j - nums[i]] + nums[i]);
```

#### 2.求容量为j的背包，装满有几种方法。

```java
dp[j] += dp[j-nums[i]];
```

**这个公式在后面在讲解背包解决排列组合问题的时候还会用到！**

**后面我们在讲解完全背包的时候，还会用到这个递推公式！**

#### 3.有两个维度的0-1背包。[17. 一和零](https://programmercarl.com/0474.一和零.html)

```cpp
for (int i = m; i >= zeroNum; i--) { // 遍历背包容量且从后向前遍历！
        for (int j = n; j >= oneNum; j--) {
            dp[i][j] = max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
        }
    }
```

### 此时我们讲解了0-1背包的多种应用：

- [纯 0 - 1 背包 (opens new window)](https://programmercarl.com/背包理论基础01背包-2.html)是求 给定背包容量 装满背包 的最大价值是多少。
- [416. 分割等和子集 (opens new window)](https://programmercarl.com/0416.分割等和子集.html)是求 给定背包容量，能不能装满这个背包。
- [1049. 最后一块石头的重量 II (opens new window)](https://programmercarl.com/1049.最后一块石头的重量II.html)是求 给定背包容量，尽可能装，最多能装多少。
- [494. 目标和 (opens new window)](https://programmercarl.com/0494.目标和.html)是求 给定背包容量，装满背包有多少种方法。
- [17. 一和零](https://programmercarl.com/0474.一和零.html)是求 给定背包容量，装满背包最多有多少个物品。

## 8.1.2.  完全背包问题

#### 问题概念

有N件物品和一个最多能背重量为W的背包。第i件物品的重量是weight[i]，得到的价值是value[i] 。**每件物品都有无限个（也就是可以放入背包多次）**，求解将哪些物品装入背包里物品价值总和最大。

**完全背包和01背包问题唯一不同的地方就是，每种物品有无限件**。

#### 二维数组

##### **先遍历物品，然后遍历背包重量**

```java
// weight数组的大小 就是物品个数
for(int i = 1; i < weight.size(); i++) { // 遍历物品
    for(int j = 0; j <= bagweight; j++) { // 遍历背包容量
        if (j < weight[i]) dp[i][j] = dp[i - 1][j];
        else dp[i][j] = max(dp[i - 1][j], dp[i][j - weight[i]] + value[i]);
    }
}
```

##### **先遍历背包，再遍历物品，也是可以的！**

```java
// weight数组的大小 就是物品个数
for(int j = 0; j <= bagweight; j++) { // 遍历背包容量
    for(int i = 1; i < weight.size(); i++) { // 遍历物品
        if (j < weight[i]) dp[i][j] = dp[i - 1][j];
        else dp[i][j] = max(dp[i - 1][j], dp[i][j - weight[i]] + value[i]);
    }
}
```

**注意：其中与0-1背包中的`dp[i][j] = max(dp[i - 1][j], dp[i-1][j - weight[i]] + value[i]);`不同在于完全背包的`dp[i][j] = max(dp[i - 1][j], dp[i][j - weight[i]] + value[i]);`。**

**在01背包问题中，我们使用的是`dp[i-1][j - weight[i]] + value[i]`，即上一个物品和当前物品减去其重量的价值；而在完全背包问题中，我们使用的是`dp[i][j - weight[i]] + value[i]`，即当前物品减去其重量的价值，这允许我们多次选择当前物品。**

#### ===============================================

#### 滚动数组

#### 遍历顺序

##### 完全背包的物品是可以添加多次的，所以要从小到大去遍历。

##### 先遍历物品，再遍历背包  ->组合数

```cpp
// 先遍历物品，再遍历背包
for(int i = 0; i < weight.size(); i++) { // 遍历物品
    for(int j = weight[i]; j <= bagWeight ; j++) { // 遍历背包容量
        dp[j] = max(dp[j], dp[j - weight[i]] + value[i]);
    }
}
```

完全背包中，两个for循环的先后循序，都不影响计算dp[j]所需要的值（这个值就是下标j之前所对应的dp[j]）。

##### 先遍历背包，再遍历物品  ->排列数

```cpp
// 先遍历背包，再遍历物品
for(int j = 0; j <= bagWeight; j++) { // 遍历背包容量
    for(int i = 0; i < weight.size(); i++) { // 遍历物品
        if (j - weight[i] >= 0) dp[j] = max(dp[j], dp[j - weight[i]] + value[i]);
    }
}
```

#### 完整代码：

##### （先遍历物品，再遍历背包  ->组合数）版本

```java
/**
 * 二维数组
 * @param weight
 * @param value
 * @param bagSize
 * @return
 */
public int BagAllProblem(int[] weight, int[] value, int bagSize) {
    int[][] dp = new int[weight.length][bagSize+1];
    for (int j = weight[0]; j <= bagSize; j++) {
        dp[0][j] = value[0];
    }

    for (int i = 1; i < weight.length; i++) {
        for (int j = 0; j <= bagSize; j++) {
            if (j < weight[i]) dp[i][j] = dp[i-1][j];
            else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-weight[i]] + value[i]);
        }
    }
    return dp[weight.length-1][bagSize];
}


/**
 * 滚动数组
 * @param weight
 * @param value
 * @param bagSize
 * @return
 */
public int BagAllProblem2(int[] weight, int[] value, int bagSize) {
    int[] dp = new int[bagSize+1];

    for (int i = 0; i < weight.length; i++) {
        for (int j = weight[i]; j <= bagSize; j++) {
            dp[j] = Math.max(dp[j], dp[j-weight[i]] + value[i]);
        }
    }

    return dp[bagSize];
}
```

##### （先遍历背包，再遍历物品  ->排列数）版本

```java
/**
 * 二维数组  （先遍历背包，再遍历物品  ->排列数）版本
 * @param weight
 * @param value
 * @param bagSize
 * @return
 */
public int BagAllProblem3(int[] weight, int[] value, int bagSize) {
    int[][] dp = new int[weight.length][bagSize+1];
    for (int j = weight[0]; j <= bagSize; j++) {
        dp[0][j] = value[0];
    }

    for (int j = 0; j <= bagSize; j++) {
        for (int i = 1; i < weight.length; i++) {
            if (j - weight[i] >= 0) dp[i][j] = Math.max(dp[i-1][j],dp[i][j-weight[i]] + value[i]);
            else dp[i][j] = dp[i-1][j];
        }
    }
    return dp[weight.length-1][bagSize];
}


/**
 * 滚动数组  （先遍历背包，再遍历物品  ->排列数）版本
 * @param weight
 * @param value
 * @param bagSize
 * @return
 */
public int BagAllProblem4(int[] weight, int[] value, int bagSize) {
    int[] dp = new int[bagSize+1];

    for (int j = 0; j <= bagSize; j++) {
        for (int i = 0; i < weight.length; i++) {
            if (j - weight[i] >= 0) dp[j] = Math.max(dp[j], dp[j-weight[i]] + value[i]);
        }
    }

    return dp[bagSize];
}
```

#### 求具体方案：

```java
/**
 * 求具体方案
 * @param weight
 * @param value
 * @param bagSize
 * @return
 */
public static int BagAllProblem2Plus(int[] weight, int[] value, int bagSize) {
    int[] dp = new int[bagSize+1];
    int[][] choices = new int[weight.length][bagSize + 1]; // 记录每种物品放入背包的数量

    for (int i = 0; i < weight.length; i++) {
        for (int j = weight[i]; j <= bagSize; j++) {
            if (dp[j] < dp[j - weight[i]] + value[i]) {
                dp[j] = dp[j - weight[i]] + value[i];
                choices[i][j] = choices[i][j - weight[i]] + 1; // 记录放入数量
            }
        }
    }


    // 回溯求解具体方案
    StringBuilder solution = new StringBuilder();
    int remainingCapacity = bagSize;
    for (int i = weight.length - 1; i >= 0; i--) {
        while (remainingCapacity >= weight[i] && dp[remainingCapacity] == dp[remainingCapacity - weight[i]] + value[i]) {
            int count = choices[i][remainingCapacity];
            solution.insert(0, "物品" + (i + 1) + "数量" + count + " ");
            remainingCapacity -= count * weight[i];
        }
    }
    System.out.println(solution);

    return dp[bagSize];
}
```

#### 注意：**对于纯完全背包问题，其for循环的先后循环是可以颠倒的！**但如果题目稍稍有点变化，就会体现在遍历顺序上。

如果问装满背包有几种方式的话？ 那么两个for循环的先后顺序就有很大区别了，而leetcode上的题目都是这种稍有变化的类型。

#### 遍历顺序与  求组合数、排列数  的关系

##### 如果求组合数就是外层for循环遍历物品，内层for遍历背包。

##### 如果求排列数就是外层for遍历背包，内层for循环遍历物品。

### 题目中要求个数等一般可用动态规划，而求所有组合则用回溯。

例如：[377. 组合总和 Ⅳ](https://leetcode.cn/problems/combination-sum-iv/)和[4. 组合总和III](https://programmercarl.com/0216.组合总和III.html)

### 背包问题中求组合数、求排列数、求最小数总结

求组合数：[动态规划：518.零钱兑换II (opens new window)](https://programmercarl.com/0518.零钱兑换II.html)求排列数：[动态规划：377. 组合总和 Ⅳ (opens new window)](https://programmercarl.com/0377.组合总和.html)、[动态规划：70. 爬楼梯进阶版（完全背包） (opens new window)](https://programmercarl.com/0070.爬楼梯完全背包版本.html)、[26. 单词拆分](https://programmercarl.com/0139.单词拆分.html)求最小数：[动态规划：322. 零钱兑换 (opens new window)](https://programmercarl.com/0322.零钱兑换.html)、[动态规划：279.完全平方数](https://programmercarl.com/0279.完全平方数.html)

### [背包问题总结篇](https://programmercarl.com/背包总结篇.html)

## 8.1.3.  打家劫舍问题系列

**劫舍系列简单来说就是 数组上连续元素二选一，成环之后连续元素二选一，在树上连续元素二选一，所能得到的最大价值**。

#### [打家劫舍](https://programmercarl.com/0198.打家劫舍.html)

##### 问题概述：

你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，**如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。**

给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。

##### dp定义：

**dp[i]：考虑下标i（包括i）以内的房屋，最多可以偷窃的金额为dp[i]**。

##### 递推公式：

如果偷第i房间，那么dp[i] = dp[i - 2] + nums[i] ，即：第i-1房一定是不考虑的，找出 下标i-2（包括i-2）以内的房屋，最多可以偷窃的金额为dp[i-2] 加上第i房间偷到的钱。

如果不偷第i房间，那么dp[i] = dp[i - 1]，即考 虑i-1房，（**注意这里是考虑，并不是一定要偷i-1房，这是很多同学容易混淆的点**）

然后dp[i]取最大值，即`dp[i] = max(dp[i - 2] + nums[i], dp[i - 1]);`

##### 初始化：

从递推公式dp[i] = max(dp[i - 2] + nums[i], dp[i - 1]);可以看出，递推公式的基础就是dp[0] 和 dp[1]

从dp[i]的定义上来讲，dp[0] 一定是 nums[0]，dp[1]就是nums[0]和nums[1]的最大值即：`dp[1] = max(nums[0], nums[1]);`

##### 遍历顺序：

dp[i] 是根据dp[i - 2] 和 dp[i - 1] 推导出来的，那么一定是从前到后遍历！

```java
public int rob(int[] nums) {
    if (nums.length == 1) return nums[0];
    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0],nums[1]);

    for (int i = 2; i < nums.length; i++) {
        dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
    }

    return dp[nums.length-1];
}
```

#### [打家劫舍II](https://programmercarl.com/0213.打家劫舍II.html)

##### 问题概述：

所有的房屋都 **围成一圈** 

##### 思路：

对于一个数组，成环的话需要考虑的情况：

- 情况一：考虑包含首元素，不包含尾元素

![](D:\Code\JavaProject\leetcode2024\leetcode2024.assets\Snipaste_2024-03-11_21-05-32.png)

- 情况二：考虑包含尾元素，不包含首元素

![](D:\Code\JavaProject\leetcode2024\leetcode2024.assets\Snipaste_2024-03-11_21-05-37.png)

将[打家劫舍](https://programmercarl.com/0198.打家劫舍.html)的代码抽离出来，用来处理情况一和情况二

```java
int result1 = robRange(nums, 0, nums.size() - 2); // 情况一
int result2 = robRange(nums, 1, nums.size() - 1); // 情况二
```

```java
public int rob(int[] nums) {
    if (nums.length == 0) return 0;
    if (nums.length == 1) return nums[0];

    int result1 = robRange(nums,0,nums.length-2);
    int result2 = robRange(nums,1,nums.length-1);

    return Math.max(result1,result2);
}

private int robRange(int[] nums, int left, int right) {
    if (left == right) return nums[left];
    int[] dp = new int[nums.length];
    dp[left] = nums[left];
    dp[left+1] = Math.max(nums[left],nums[left+1]);

    for (int i = left+2; i <= right; i++) {
        dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
    }

    return dp[right];
}
```

#### [打家劫舍III](https://programmercarl.com/0337.打家劫舍III.html)

##### 问题概述：

这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“**这个地方的所有房屋的排列类似于一棵二叉树**”。**如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。**

##### 树形dp的入门题目

**这道题目算是树形dp的入门题目，因为是在树上进行状态转移，我们在讲解二叉树的时候说过递归三部曲，那么下面我以递归三部曲为框架，其中融合动规五部曲的内容来进行讲解**。

##### **以递归三部曲为框架，其中融合动规五部曲的内容**

- 确定递归函数的参数和返回值

这里我们要求一个节点 偷与不偷的两个状态所得到的金钱，那么返回值就是一个长度为2的数组。

参数为当前节点，代码如下：

```java
int[] robTree(utils.TreeNode cur) {
```

其实这里的返回数组就是dp数组。

所以**dp数组（dp table）以及下标的含义：下标为0记录不偷该节点所得到的的最大金钱，下标为1记录偷该节点所得到的的最大金钱。**

**所以本题dp数组就是一个长度为2的数组！**

- 确定终止条件

在遍历的过程中，如果遇到空节点的话，很明显，无论偷还是不偷都是0，所以就返回

```java
if (cur == NULL) return new int[]{0,0};
```

这也相当于dp数组的初始化。

- 确定遍历顺序

首先明确的是使用**后序遍历**。 因为要通过递归函数的返回值来做下一步计算。

通过递归左节点，得到左节点偷与不偷的金钱。

通过递归右节点，得到右节点偷与不偷的金钱。

```cpp
// 下标0：不偷，下标1：偷
int[] left = robTree(cur->left); // 左
int[] right = robTree(cur->right); // 右
// 中

```

- 确定单层递归的逻辑

如果是偷当前节点，那么左右孩子就不能偷，`val1 = cur->val + left[0] + right[0]; `

如果不偷当前节点，那么左右孩子就可以偷，至于到底偷不偷一定是选一个最大的，所以：`val2 = max(left[0], left[1]) + max(right[0], right[1]);`

最后当前节点的状态就是{val2, val1}; 即：{不偷当前节点得到的最大金钱，偷当前节点得到的最大金钱}

代码如下：

```java
int[] left = robTree(cur->left); // 左
int[] right = robTree(cur->right); // 右

// 偷cur
int val1 = cur.val + left[0] + right[0];
// 不偷cur
int val2 = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
return new int[]{val2, val1};
```

**最后头结点就是 取下标0 和 下标1的最大值就是偷得的最大金钱**。

```java
public int rob(utils.TreeNode root) {
    if (root == null) return 0;
    int[] tree = robTree(root);
    return Math.max(tree[0], tree[1]);
}

private int[] robTree(utils.TreeNode root) {
    if (root == null) return new int[]{0,0};

    int[] left = robTree(root.left);
    int[] right = robTree(root.right);

    int val1 = root.val + left[0] + right[0];

    int val2 = Math.max(left[0],left[1]) + Math.max(right[0], right[1]);
    return new int[]{val2,val1};
}
```

## 8.1.4.   买卖股票问题系列

### [买卖股票的最佳时机](https://programmercarl.com/0121.买卖股票的最佳时机.html)

股票只能买卖一次。

#### dp定义：

`dp[i][0] `表示第i天持有股票所得最多现金

`dp[i][1] `表示第i天不持有股票所得最多现金

**注意这里说的是“持有”，“持有”不代表就是当天“买入”！也有可能是昨天就买入了，今天保持持有的状态**

#### 递推公式

如果第i天持有股票即`dp[i][0]`， 那么可以由两个状态推出来

- 第i-1天就持有股票，那么就保持现状，所得现金就是昨天持有股票的所得现金 即：`dp[i - 1][0]`
- 第i天买入股票，所得现金就是买入今天的股票后所得现金即：`-prices[i]`

那么`dp[i][0]`应该选所得现金最大的，所以`dp[i][0] = max(dp[i - 1][0], -prices[i]);`

如果第i天不持有股票即`dp[i][1]`， 也可以由两个状态推出来

- 第i-1天就不持有股票，那么就保持现状，所得现金就是昨天不持有股票的所得现金 即：`dp[i - 1][1]`
- 第i天卖出股票，所得现金就是按照今天股票价格卖出后所得现金即：`prices[i] + dp[i - 1][0]`

同样`dp[i][1]`取最大的，`dp[i][1] = max(dp[i - 1][1], prices[i] + dp[i - 1][0]);`

#### 初始化

`dp[0][0]`表示第0天持有股票，此时的持有股票就一定是买入股票了，因为不可能有前一天推出来，所以`dp[0][0] -= prices[0];`

`dp[0][1]`表示第0天不持有股票，不持有股票那么现金就是0，所以`dp[0][1] = 0;`

#### 遍历顺序

从递推公式可以看出dp[i]都是由dp[i - 1]推导出来的，那么一定是从前向后遍历。

```java
/**
 * DP方法解决
 * @param prices
 * @return
 */
public int maxProfit(int[] prices) {
    int[][] dp = new int[prices.length][2];
    dp[0][0] = -prices[0];
    dp[0][1] = 0;

    for (int i = 1; i < prices.length; i++) {
        dp[i][0] = Math.max(dp[i-1][0],-prices[i]);
        dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]+prices[i]);
    }

    return dp[prices.length-1][1];
}
```

### [买卖股票的最佳时机II](https://programmercarl.com/0122.买卖股票的最佳时机II（动态规划）.html)

本题和[121. 买卖股票的最佳时机 (opens new window)](https://programmercarl.com/0121.买卖股票的最佳时机.html)的唯一区别是本题股票可以买卖多次了（注意只有一只股票，所以再次购买前要出售掉之前的股票）

如果第i天持有股票即`dp[i][0]`， 那么可以由两个状态推出来

- 第i-1天就持有股票，那么就保持现状，所得现金就是昨天持有股票的所得现金 即：`dp[i - 1`][0]
- 第i天买入股票，所得现金就是昨天不持有股票的所得现金减去 今天的股票价格 即：`dp[i - 1][1] - prices[i]`

再来看看如果第i天不持有股票即`dp[i][1]`的情况， 依然可以由两个状态推出来

- 第i-1天就不持有股票，那么就保持现状，所得现金就是昨天不持有股票的所得现金 即：`dp[i - 1`][1]
- 第i天卖出股票，所得现金就是按照今天股票价格卖出后所得现金即：`prices[i] + dp[i - 1`][0]

```java
dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] - prices[i]);
dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i]);
```

### [买卖股票的最佳时机III](https://programmercarl.com/0123.买卖股票的最佳时机III.html)

关键在于**至多买卖两次**，这意味着可以买卖一次，可以买卖两次，也可以不买卖。

- 确定dp数组以及下标的含义

一天一共就有五个状态，

1. 没有操作 （其实我们也可以不设置这个状态）
2. 第一次持有股票
3. 第一次不持有股票
4. 第二次持有股票
5. 第二次不持有股票

`dp[i][j]`中 i表示第i天，j为 [0 - 4] 五个状态，`dp[i][j]`表示第i天状态j所剩最大现金。

- 确定递推公式

达到`dp[i][1]`状态，有两个具体操作：

- 操作一：第i天买入股票了，那么`dp[i][1] = dp[i-1][0] - prices[i]`
- 操作二：第i天没有操作，而是沿用前一天买入的状态，即：`dp[i][1] = dp[i - 1`][1]

那么`dp[i][1]`究竟选 `dp[i-1][0] - prices[i]`，还是`dp[i - 1][1]`呢？

一定是选最大的，所以 `dp[i][1] = max(dp[i-1][0] - prices[i], dp[i - 1][1]);`

同理`dp[i][2]`也有两个操作：

- 操作一：第i天卖出股票了，那么`dp[i][2] = dp[i - 1][1] + prices[i]`
- 操作二：第i天没有操作，沿用前一天卖出股票的状态，即：`dp[i][2] = dp[i - 1][2]`

所以`dp[i][2] = max(dp[i - 1][1] + prices[i], dp[i - 1][2])`

同理可推出剩下状态部分：

`dp[i][3] = max(dp[i - 1][3], dp[i - 1][2] - prices[i]);`

`dp[i][4] = max(dp[i - 1][4], dp[i - 1][3] + prices[i]);`

- dp数组如何初始化

第0天做第一次买入的操作，`dp[0][1] = -prices[0];`

第二次买入操作，初始化为：`dp[0][3] = -prices[0];`

- 确定遍历顺序

从递归公式其实已经可以看出，一定是从前向后遍历，因为dp[i]，依靠dp[i - 1]的数值。

```java
dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1] + prices[i]);
dp[i][3] = Math.max(dp[i-1][3], dp[i-1][2] - prices[i]);
dp[i][4] = Math.max(dp[i-1][4], dp[i-1][3] + prices[i]);
```

### [买卖股票的最佳时机IV](https://programmercarl.com/0188.买卖股票的最佳时机IV.html)

**最多可以完成 `k` 笔交易**

**本题和[动态规划：123.买卖股票的最佳时机III (opens new window)](https://programmercarl.com/0123.买卖股票的最佳时机III.html)最大的区别就是这里要类比j为奇数是买，偶数是卖的状态**。

```java
public int maxProfit(int k, int[] prices) {
    int[][] dp = new int[prices.length][2*k+1];
    for (int i = 1; i < 2*k+1; i=i+2) {
        dp[0][i] = -prices[0];
    }

    for (int i = 1; i < prices.length; i++) {
        dp[i][0] = dp[i-1][0];
        for (int j = 1; j < 2*k; j=j+2) {
            dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]- prices[i]);
            dp[i][j+1] = Math.max(dp[i-1][j+1], dp[i-1][j] + prices[i]);
        }
    }
    return dp[prices.length-1][2*k];
}
```

### [最佳买卖股票时机含冷冻期](https://programmercarl.com/0309.最佳买卖股票时机含冷冻期.html)

相对于[动态规划：122.买卖股票的最佳时机II (opens new window)](https://programmercarl.com/0122.买卖股票的最佳时机II（动态规划）.html)，本题加上了一个冷冻期

- 确定dp数组以及下标的含义

`dp[i][j]`，第i天状态为j，所剩的最多现金为`dp[i][j]`。

具体可以区分出如下四个状态：

- 状态一：持有股票状态（今天买入股票，或者是之前就买入了股票然后没有操作，一直持有）
- 不持有股票状态，这里就有两种卖出股票状态
  - 状态二：保持卖出股票的状态（两天前就卖出了股票，度过一天冷冻期。或者是前一天就是卖出股票状态，一直没操作）
  - 状态三：今天卖出股票
- 状态四：今天为冷冻期状态，但冷冻期状态不可持续，只有一天！

因为本题我们有冷冻期，而冷冻期的前一天，只能是 「今天卖出股票」状态，如果是 「不持有股票状态」那么就很模糊，因为不一定是 卖出股票的操作。

- 确定递推公式

**达到买入股票状态**（状态一）即：`dp[i][0]`，有两个具体操作：

- 操作一：前一天就是持有股票状态（状态一），`dp[i][0] = dp[i - 1][0]`
- 操作二：今天买入了，有两种情况
  - 前一天是冷冻期（状态四），`dp[i - 1][3] - prices[i]`
  - 前一天是保持卖出股票的状态（状态二），`dp[i - 1][1] - prices[i]`

那么`dp[i][0] = max(dp[i - 1][0], dp[i - 1][3] - prices[i], dp[i - 1][1] - prices[i]);`

**达到保持卖出股票状态**（状态二）即：`dp[i][1]`，有两个具体操作：

- 操作一：前一天就是状态二
- 操作二：前一天是冷冻期（状态四）

`dp[i][1] = max(dp[i - 1][1], dp[i - 1][3]);`

**达到今天就卖出股票状态**（状态三），即：`dp[i][2] `，只有一个操作：

昨天一定是持有股票状态（状态一），今天卖出

即：`dp[i][2] = dp[i - 1][0] + prices[i];`

**达到冷冻期状态**（状态四），即：`dp[i][3]`，只有一个操作：

昨天卖出了股票（状态三）

`dp[i][3] = dp[i - 1][2];`

```java
dp[i][0] = Math.max(dp[i-1][0], Math.max(dp[i-1][1] - prices[i],dp[i-1][3] - prices[i]));
dp[i][1] = Math.max(dp[i-1][1], dp[i-1][3]);
dp[i][2] = dp[i-1][0] + prices[i];
dp[i][3] = dp[i-1][2];
```

- 初始化

如果是持有股票状态（状态一）那么：`dp[0][0] = -prices[0]`，一定是当天买入股票。

其余状态都初始化为0；

- 确定遍历顺序

从递归公式上可以看出，dp[i] 依赖于 dp[i-1]，所以是从前向后遍历。

```java
public int maxProfit(int[] prices) {
    int[][] dp = new int[prices.length][4];
    dp[0][0] -= prices[0]; // 持股票

    for (int i = 1; i < prices.length; i++) {
        dp[i][0] = Math.max(dp[i-1][0], Math.max(dp[i-1][1] - prices[i],dp[i-1][3] - prices[i]));
        dp[i][1] = Math.max(dp[i-1][1], dp[i-1][3]);
        dp[i][2] = dp[i-1][0] + prices[i];
        dp[i][3] = dp[i-1][2];
    }

    return Math.max(dp[prices.length-1][1],Math.max(dp[prices.length-1][2],dp[prices.length-1][3]));
}
```

### [买卖股票的最佳时机含手续费](https://programmercarl.com/0714.买卖股票的最佳时机含手续费（动态规划）.html)

相对于[动态规划：122.买卖股票的最佳时机II (opens new window)](https://programmercarl.com/0122.买卖股票的最佳时机II（动态规划）.html)，本题只需要在计算卖出操作的时候减去手续费就可以了，代码几乎是一样的。

### [股票问题总结篇](https://programmercarl.com/动态规划-股票问题总结篇.html)

![](D:\Code\JavaProject\leetcode2024\leetcode2024.assets\Snipaste_2024-03-12_10-30-01.png)

## 8.1.5.   子序列问题

### **要联动起来，才能理解递增子序列怎么求，递增连续子序列又要怎么求**。概括来说：不连续递增子序列的跟前0 到 i 个状态有关，连续递增的子序列只跟前一个状态有关

[41. 最长上升子序列](https://programmercarl.com/0300.最长上升子序列.html)和[42. 最长连续递增序列](https://programmercarl.com/0674.最长连续递增序列.html)的区别

### 两个序列求公共子序列，连续子序列只需要考虑相等的情况就可以,而不连续但需要保持相对顺序需要考虑其他情况。

[43. 最长重复子数组](https://programmercarl.com/0718.最长重复子数组.html)和[44. 最长公共子序列](https://programmercarl.com/1143.最长公共子序列.html)的区别

## 8.1.6.   编辑距离问题

### 只涉及删除操作

[47. 判断子序列](https://programmercarl.com/0392.判断子序列.html)、[48. 不同的子序列](https://programmercarl.com/0115.不同的子序列.html)、[49. 两个字符串的删除操作](https://programmercarl.com/0583.两个字符串的删除操作.html)

这一类问题，基本是要分析两种情况

- 情况一：s[i - 1] 与 t[j - 1]相等
- 情况二：s[i - 1] 与 t[j - 1] 不相等

对于情况一，一般就是`dp[i][j]和dp[i-1][j-1]`相关的操作。  （ 当然根据dp定义还有其他相关的[48. 不同的子序列](https://programmercarl.com/0115.不同的子序列.html)）

对于情况二，一般就是`dp[i][j]与dp[i-1][j]、dp[i][j - 1]`的操作。

`dp[i-1][j]`相当于把`s[i-1]`删掉、`dp[i][j - 1]`相当于把`t[i-1]`删掉

### 初始化时要根据dp定义来确定

### [50. 编辑距离](https://programmercarl.com/0072.编辑距离.html)

**删除操作和上文提到的处理方法相同**

```
if (word1.charAt(i-1) == word2.charAt(j-1)) {
      dp[i][j] = dp[i-1][j-1];
} else {
      dp[i][j] = Math.min(dp[i-1][j] + 1,dp[i][j-1] + 1);
}
```

**而新增操作相当于在另一个字符串上的删除操作，所以和删除操作相当于一个情况**

替换操作则是 `dp[i][j] = dp[i - 1][j - 1] + 1;`

具体解释如下：

```
if (word1[i - 1] == word2[j - 1])` 那么说明不用任何编辑，`dp[i][j]` 就应该是 `dp[i - 1][j - 1]`，即`dp[i][j] = dp[i - 1][j - 1];
```

`if (word1[i - 1] != word2[j - 1])`，此时就需要编辑了，如何编辑呢？

- 操作一：word1删除一个元素，那么就是以下标i - 2为结尾的word1 与 j-1为结尾的word2的最近编辑距离 再加上一个操作。

即 `dp[i][j] = dp[i - 1][j] + 1;`

- 操作二：word2删除一个元素，那么就是以下标i - 1为结尾的word1 与 j-2为结尾的word2的最近编辑距离 再加上一个操作。

即 `dp[i][j] = dp[i][j - 1] + 1;`

这里有同学发现了，怎么都是删除元素，添加元素去哪了。**word2添加一个元素，相当于word1删除一个元素**。

操作三：替换元素，`word1`替换`word1[i - 1]`，使其与`word2[j - 1]`相同，此时不用增删加元素。

可以回顾一下，`if (word1[i - 1] == word2[j - 1])`的时候我们的操作 是 `dp[i][j] = dp[i - 1][j - 1]` 对吧。

那么只需要一次替换的操作，就可以让 word1[i - 1] 和 word2[j - 1] 相同。

所以 `dp[i][j] = dp[i - 1][j - 1] + 1;`

综上，当 `if (word1[i - 1] != word2[j - 1])` 时取最小的，即：`dp[i][j] = min({dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]}) + 1;`

完整代码：

```java
public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];

        for (int i = 1; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= word2.length(); j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
//                    dp[i][j] = Math.min(dp[i-1][j-1] + 1, Math.min(dp[i-1][j] + 1, dp[i][j-1] + 1));
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
```



## 8.2 重点题目及出错的题目等

### 背包问题相关题目

### [8. 整数拆分](https://programmercarl.com/0343.整数拆分.html)

```java
public int integerBreak(int n) {
    int[] dp = new int[n+1];
    dp[2] = 1;
    for (int i = 3; i <= n; i++) {
        for (int j = 1; j <= i/2; j++) {
            dp[i] = Math.max(dp[i], Math.max(j * dp[i-j], j * (i-j)));
        }
    }
    return dp[n];
}
```

### [9. 不同的二叉搜索树](https://programmercarl.com/0096.不同的二叉搜索树.html)

**`dp[i] `： 1到i为节点组成的二叉搜索树的个数为`dp[i]`**。

递推公式：`dp[i] += dp[j - 1] * dp[i - j]; `，j-1 为j为头结点左子树节点数量，i-j 为以j为头结点右子树节点数量

遍历顺序：

```java
for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= i; j++) {
        dp[i] += dp[j - 1] * dp[i - j];
    }
}
```

### [13. 分割等和子集](https://programmercarl.com/0416.分割等和子集.html)

**只有确定了如下四点，才能把01背包问题套到本题上来。**

- 背包的体积为sum / 2
- 背包要放入的商品（集合里的元素）重量为 元素的数值，价值也为元素的数值
- 背包如果正好装满，说明找到了总和为 sum / 2 的子集。
- 背包中每一个元素是不可重复放入。

**dp[j]表示 背包总容量（所能装的总重量）是j，放进物品后，背的最大重量为dp[j]**。

递推公式：`dp[j] = max(dp[j], dp[j - nums[i]] + nums[i]);`

### [14. 最后一块石头的重量II](https://programmercarl.com/1049.最后一块石头的重量II.html)

[416. 分割等和子集 (opens new window)](https://programmercarl.com/0416.分割等和子集.html)相当于是求背包是否正好装满，而本题是求背包最多能装多少。

**其中背包容量为sum/2，让背包最多装满多少，之后剩下的部分就是石头剩余的重量。**

### [16. 目标和](https://programmercarl.com/0494.目标和.html)

本题要如何使表达式结果为target，

既然为target，那么就一定有 left组合 - right组合 = target。

left + right = sum，而sum是固定的。right = sum - left

公式来了， left - (sum - left) = target 推导出 left = (target + sum)/2 。

target是固定的，sum是固定的，left就可以求出来。

此时问题就是在集合nums中找出和为left的组合。

==========================================================

这次和之前遇到的背包问题不一样了，之前都是求容量为j的背包，最多能装多少。

**本题则是装满有几种方法**。其实这就是一个组合问题了。

### [17. 一和零](https://programmercarl.com/0474.一和零.html)

**有两个维度的0-1背包**

**本题中strs 数组里的元素就是物品，每个物品都是一个！**

**而m 和 n相当于是一个背包，两个维度的背包**。

动规五部曲：

**`dp[i][j]`：最多有i个0和j个1的strs的最大子集的大小为`dp[i][j]`**。

递推公式：`dp[i][j] = max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);`

初始化：均为0；

遍历顺序：

```cpp
for (string str : strs) { // 遍历物品
    int oneNum = 0, zeroNum = 0;
    for (char c : str) {
        if (c == '0') zeroNum++;
        else oneNum++;
    }
    for (int i = m; i >= zeroNum; i--) { // 遍历背包容量且从后向前遍历！
        for (int j = n; j >= oneNum; j--) {
            dp[i][j] = max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
        }
    }
}
```

### [26. 单词拆分](https://programmercarl.com/0139.单词拆分.html)

单词就是物品，字符串s就是背包，单词能否组成字符串s，就是问物品能不能把背包装满。

**dp[i] : 字符串长度为i的话，dp[i]为true，表示可以拆分为一个或多个在字典中出现的单词**。

递推公式是 `if([j, i] 这个区间的子串出现在字典里 && dp[j]是true) 那么 dp[i] = true`。

dp[0]初始为true完全就是为了推导公式，下标非0的dp[i]初始化为false。

本题其实我们求的是排列数，所以**外层for遍历背包，内层for循环遍历物品**。

```java
public boolean wordBreak(String s, List<String> wordDict) {
    HashSet<String> set = new HashSet<>(wordDict);
    boolean[] dp = new boolean[s.length()+1];
    dp[0] = true;

    for (int j = 1; j <= s.length(); j++) {  //遍历背包
        for (int i = 0; i < j; i++) {  //遍历物品
            String word = s.substring(i,j);
            if (set.contains(word) && dp[i]) {
                dp[j] = true;
            }
        }
    }

    for (boolean b : dp) {
        System.out.print(b + " ");
    }

    return dp[s.length()];
}
```

### 子序列相关题目

### [41. 最长上升子序列](https://programmercarl.com/0300.最长上升子序列.html)

- dp[i]的定义

**dp[i]表示i之前包括i的以nums[i]结尾的最长递增子序列的长度**

- 状态转移方程

位置i的最长升序子序列等于j从0到i-1各个位置的最长升序子序列 + 1 的最大值。

所以：`if (nums[i] > nums[j]) dp[i] = max(dp[i], dp[j] + 1);`

- dp[i]的初始化

每一个i，对应的dp[i]（即最长递增子序列）起始大小至少都是1.

- 确定遍历顺序

dp[i] 是有0到i-1各个位置的最长递增子序列 推导而来，那么遍历i一定是从前向后遍历。

j其实就是遍历0到i-1，那么是从前到后，还是从后到前遍历都无所谓，只要吧 0 到 i-1 的元素都遍历了就行了。 所以默认习惯 从前向后遍历。

遍历i的循环在外层，遍历j则在内层，代码如下：

```java
for (int i = 1; i < nums.length; i++) {
    for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
            dp[i] = Math.max(dp[i], dp[j] + 1);
        }
    }
    if (dp[i] > ans) ans = dp[i];
}
```

#### 本题最关键的是要想到dp[i]由哪些状态可以推出来，并取最大值，那么很自然就能想到递推公式：`dp[i] = max(dp[i], dp[j] + 1);`

### [动态规划：最长递增子序列的个数](https://programmercarl.com/0673.最长递增子序列的个数.html)

- 确定dp数组（dp table）以及下标的含义

这道题目我们要一起维护两个数组。

dp[i]：i之前（包括i）最长递增子序列的长度为dp[i]

count[i]：以nums[i]为结尾的字符串，最长递增子序列的个数为count[i]

- 递推公式

在300.最长上升子序列 中，我们给出的状态转移是：

`if (nums[i] > nums[j]) dp[i] = max(dp[i], dp[j] + 1);`

即：位置i的最长递增子序列长度 等于j从0到i-1各个位置的最长升序子序列 + 1的最大值。

本题就没那么简单了，我们要考虑两个维度，一个是dp[i]的更新，一个是count[i]的更新。

那么如何更新count[i]呢？

以nums[i]为结尾的字符串，最长递增子序列的个数为count[i]。

那么在nums[i] > nums[j]前提下，如果在[0, i-1]的范围内，找到了j，使得dp[j] + 1 > dp[i]，说明找到了一个更长的递增子序列。

那么以j为结尾的子串的最长递增子序列的个数，就是最新的以i为结尾的子串的最长递增子序列的个数，即：`count[i] = count[j]。`

在nums[i] > nums[j]前提下，如果在[0, i-1]的范围内，找到了j，使得dp[j] + 1 == dp[i]，说明找到了两个相同长度的递增子序列。

那么以i为结尾的子串的最长递增子序列的个数 就应该加上以j为结尾的子串的最长递增子序列的个数，即：`count[i] += count[j];`

- 初始化

count[i]记录了以nums[i]为结尾的字符串，最长递增子序列的个数。

那么最少也就是1个，所以count[i]初始为1。

dp[i]记录了i之前（包括i）最长递增序列的长度。

最小的长度也是1，所以dp[i]初始为1。

- 遍历顺序

dp[i] 是由0到i-1各个位置的最长升序子序列 推导而来，那么遍历i一定是从前向后遍历。

j其实就是0到i-1，遍历i的循环里外层，遍历j则在内层，

```java
public int findNumberOfLIS(int[] nums) {
    if (nums.length <= 1) return nums.length;
    int[] dp = new int[nums.length];  //递增子序列的最长长度
    int[] count = new int[nums.length];  //自增子序列的个数
    Arrays.fill(dp,1);
    Arrays.fill(count,1);
    int maxCount = 0;
    for (int i = 1; i < nums.length; i++) {
        for (int j = 0; j < i; j++) {
            if (nums[i] > nums[j]) {
                if (dp[j] + 1 > dp[i]) { //长度增加
                    dp[i] = dp[j] + 1;
                    count[i] = count[j];
                } else if (dp[j]+1 == dp[i]) {  //长度未增，但个数增加
                    count[i] += count[j];
                }
            }
            if (dp[i] > maxCount) maxCount = dp[i];  //记录最长长度
        }
    }
    int ans = 0;
    for (int i = 0; i < nums.length; i++) {
        if (maxCount == dp[i]) ans += count[i];
    }
    return ans;
}
```

### [43. 最长重复子数组](https://programmercarl.com/0718.最长重复子数组.html)

- 确定dp数组（dp table）以及下标的含义

**`dp[i][j]` ：以下标i - 1为结尾的A，和以下标j - 1为结尾的B，最长重复子数组长度为`dp[i][j]`。 （**特别注意**： “以下标i - 1为结尾的A” 标明一定是 以A[i-1]为结尾的字符串 ）**

- 确定递推公式

根据dp[i][j]的定义，`dp[i][j]`的状态只能由`dp[i - 1][j - 1]`推导出来。

即当A[i - 1] 和B[j - 1]相等的时候，`dp[i][j] = dp[i - 1][j - 1] + 1;`

根据递推公式可以看出，遍历i 和 j 要从1开始！

- dp数组如何初始化

根据`dp[i][j]`的定义，`dp[i][0]`和`dp[0][j]`其实都是没有意义的！

但`dp[i][0]` 和`dp[0][j]`要初始值，因为 为了方便递归公式`dp[i][j] = dp[i - 1][j - 1] + 1;`

所以`dp[i][0] `和`dp[0][j]`初始化为0。

举个例子A[0]如果和B[0]相同的话，`dp[1][1] = dp[0][0] + 1`，只有`dp[0][0]`初始为0，正好符合递推公式逐步累加起来。

- 确定遍历顺序

外层for循环遍历A，内层for循环遍历B。

那又有同学问了，外层for循环遍历B，内层for循环遍历A。不行么？

也行，一样的，我这里就用外层for循环遍历A，内层for循环遍历B了。

同时题目要求长度最长的子数组的长度。所以在遍历的时候顺便把`dp[i][j]`的最大值记录下来。

```java
for (int i = 1; i <= nums1.length; i++) {
    for (int j = 1; j <= nums2.length; j++) {
        if (nums1[i-1] == nums2[j-1]) {
            dp[i][j] = dp[i-1][j-1] + 1;
        }
        if (dp[i][j] > ans) ans = dp[i][j];
    }
}
```

### [44. 最长公共子序列](https://programmercarl.com/1143.最长公共子序列.html)

- 确定dp数组（dp table）以及下标的含义

`dp[i][j]`：长度为[0, i - 1]的字符串text1与长度为[0, j - 1]的字符串text2的最长公共子序列为`dp[i][j]`

- 确定递推公式

主要就是两大情况： text1[i - 1] 与 text2[j - 1]相同，text1[i - 1] 与 text2[j - 1]不相同

如果text1[i - 1] 与 text2[j - 1]相同，那么找到了一个公共元素，所以`dp[i][j] = dp[i - 1][j - 1] + 1;`

如果text1[i - 1] 与 text2[j - 1]不相同，那就看看text1[0, i - 2]与text2[0, j - 1]的最长公共子序列 和 text1[0, i - 1]与text2[0, j - 2]的最长公共子序列，取最大的。

即：`dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);`

```java
if (text1.charAt(i-1) == text2.charAt(j-1)) {
    dp[i][j] = dp[i-1][j-1] + 1;
} else {
    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
}
```

- dp数组如何初始化

先看看`dp[i][0]`应该是多少呢？

test1[0, i-1]和空串的最长公共子序列自然是0，所以`dp[i][0] = 0;`

同理`dp[0][j]`也是0。

其他下标都是随着递推公式逐步覆盖，初始为多少都可以，那么就统一初始为0。

- 遍历顺序

为了在递推的过程中，这三个方向都是经过计算的数值，所以要从前向后，从上到下来遍历这个矩阵。

![](D:\Code\JavaProject\leetcode2024\leetcode2024.assets\Snipaste_2024-03-12_11-55-17.png)

```java
public int longestCommonSubsequence(String text1, String text2) {
    int[][] dp = new int[text1.length()+1][text2.length()+1];

    for (int i = 1; i <= text1.length(); i++) {
        for (int j = 1; j <= text2.length(); j++) {
            if (text1.charAt(i-1) == text2.charAt(j-1)) {
                dp[i][j] = dp[i-1][j-1] + 1;
            } else {
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
    }

    return dp[text1.length()][text2.length()];
}
```

### [46. 最大子序和](https://programmercarl.com/0053.最大子序和（动态规划）.html)

**dp[i]：包括下标i（以nums[i]为结尾）的最大连续子序列和为dp[i]**。

dp[i]只有两个方向可以推出来：

- dp[i - 1] + nums[i]，即：nums[i]加入当前连续子序列和
- nums[i]，即：从头开始计算当前连续子序列和

一定是取最大的，所以`dp[i] = max(dp[i - 1] + nums[i], nums[i]);`

初始化：`dp[0] = nums[0]`

递推公式中dp[i]依赖于dp[i - 1]的状态，需要从前向后遍历。

```java
/**
 * 贪心法
 * @param nums
 * @return
 */
public int maxSubArray2(int[] nums) {
    int max = Integer.MIN_VALUE;
    int sum = 0;

    for (int i = 0; i < nums.length; i++) {
        sum += nums[i];
        if (sum > max) max = sum;
        if (sum <= 0) sum = 0;
    }
    return max;
}

/**
 * DP
 * @param nums
 * @return
 */
public int maxSubArray(int[] nums) {
    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    int ans = dp[0];

    for (int i = 1; i < nums.length; i++) {
        dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
        if (dp[i] > ans) ans = dp[i];
    }

    return ans;
}
```

### 编辑距离相关题目

### [47. 判断子序列](https://programmercarl.com/0392.判断子序列.html)

可以用双指针解决

```java
/**
 * 双指针
 * @param s
 * @param t
 * @return
 */
public boolean isSubsequence(String s, String t) {
    if (s.equals("")) return true;
    int slow = 0;

    for (int fast = 0; fast < t.length(); fast++) {
        if (s.charAt(slow) == t.charAt(fast)) {
            slow++;
        }
        if (slow == s.length()) {
            return true;
        }
    }

    return false;
}
```

**这道题应该算是编辑距离的入门题目，因为从题意中我们也可以发现，只需要计算删除的情况，不用考虑增加和替换的情况。**

#### 确定dp数组（dp table）以及下标的含义

**`dp[i][j]` 表示以下标i-1为结尾的字符串s，和以下标j-1为结尾的字符串t，相同子序列的长度为`dp[i][j]`**。

#### 递推公式

在确定递推公式的时候，首先要考虑如下两种操作，整理如下：

- if (s[i - 1] == t[j - 1])
  - t中找到了一个字符在s中也出现了
- if (s[i - 1] != t[j - 1])
  - 相当于t要删除元素，继续匹配

if (s[i - 1] == t[j - 1])，那么`dp[i][j] = dp[i - 1][j - 1] + 1`;，因为找到了一个相同的字符，相同子序列长度自然要在`dp[i-1][j-1]`的基础上加1

if (s[i - 1] != t[j - 1])，此时相当于t要删除元素，t如果把当前元素t[j - 1]删除，那么dp[i][j] 的数值就是 看s[i - 1]与 t[j - 2]的比较结果了，即：`dp[i][j] = dp[i][j - 1];`

其实这里 大家可以发现和 [1143.最长公共子序列 (opens new window)](https://programmercarl.com/1143.最长公共子序列.html)的递推公式基本那就是一样的，区别就是 本题 如果删元素一定是字符串t，而 1143.最长公共子序列 是两个字符串都可以删元素。

#### 初始化

从递推公式可以看出dp[i][j]都是依赖于`dp[i - 1][j - 1] `和` dp[i][j - 1]`，所以`dp[0][0]和dp[i][0]`是一定要初始化的。

`dp[0][0]和dp[i][0]`都初始化为0；

#### 确定遍历顺序

同理从递推公式可以看出dp[i][j]都是依赖于`dp[i - 1][j - 1] 和 dp[i][j - 1]`，那么遍历顺序也应该是从上到下，从左到右

```java
public boolean isSubsequence2(String s, String t) {
    int[][] dp = new int[s.length()+1][t.length()+1];

    for (int i = 1; i <= s.length(); i++) {
        for (int j = 1; j <= t.length(); j++) {
            if (s.charAt(i-1) == t.charAt(j-1)) {
                dp[i][j] = dp[i-1][j-1] + 1;
            } else {
                dp[i][j] = dp[i][j-1];
            }
        }
    }
    return dp[s.length()][t.length()] == s.length();
}
```

### [48. 不同的子序列](https://programmercarl.com/0115.不同的子序列.html)

- 确定dp数组（dp table）以及下标的含义

**`dp[i][j]`：以i-1为结尾的s子序列中出现以j-1为结尾的t的个数为`dp[i][j]`。**

- 递推公式

这一类问题，基本是要分析两种情况

- s[i - 1] 与 t[j - 1]相等
- s[i - 1] 与 t[j - 1] 不相等

**当s[i - 1] 与 t[j - 1]相等时，`dp[i][j]`可以有两部分组成。**

**一部分是用s[i - 1]来匹配，那么个数为`dp[i - 1][j - 1]`。即不需要考虑当前s子串和t子串的最后一位字母，所以只需要 `dp[i-1][j-1]`。**

**一部分是不用s[i - 1]来匹配，个数为`dp[i - 1][j]`。**

例如： s：bagg 和 t：bag ，s[3] 和 t[2]是相同的，但是字符串s也可以不用s[3]来匹配，即用s[0]s[1]s[2]组成的bag。

当然也可以用s[3]来匹配，即：s[0]s[1]s[3]组成的bag。

**所以当s[i - 1] 与 t[j - 1]相等时，`dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];`**

**当s[i - 1] 与 t[j - 1]不相等时，`dp[i][j]`只有一部分组成，不用s[i - 1]来匹配（就是模拟在s中删除这个元素），即：`dp[i - 1][j]`**

**所以当s[i - 1] 与 t[j - 1]不相等时：`dp[i][j] = dp[i - 1][j];`**

```java
if (s.charAt(i-1) == t.charAt(j-1)) {
    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
} else {
    dp[i][j] = dp[i-1][j];
}
```

- 初始化

从递推公式`dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]; 和 dp[i][j] = dp[i - 1][j]; `中可以看出`dp[i][j] `是从上方和左上方推导而来，如图：，那么 `dp[i][0] 和dp[0][j]`是一定要初始化的。

每次当初始化的时候，都要回顾一下`dp[i][j]`的定义，不要凭感觉初始化。

`dp[i][0] `表示：以i-1为结尾的s可以随便删除元素，出现空字符串的个数。

那么`dp[i][0]`一定都是1，因为也就是把以i-1为结尾的s，删除所有元素，出现空字符串的个数就是1。

`dp[0][j]`：空字符串s可以随便删除元素，出现以j-1为结尾的字符串t的个数。

那么`dp[0][j]`一定都是0，s如论如何也变成不了t。

最后就要看一个特殊位置了，即：`dp[0][0] `应该是多少。

`dp[0][0]`应该是1，空字符串s，可以删除0个元素，变成空字符串t。

- 遍历顺序

所以遍历的时候一定是从上到下，从左到右，这样保证dp[i][j]可以根据之前计算出来的数值进行计算。

```java
public int numDistinct(String s, String t) {
    int[][] dp = new int[s.length()+1][t.length()+1];
    for (int i = 0; i < s.length(); i++) {
        dp[i][0] = 1;
    }

    for (int i = 1; i <= s.length(); i++) {
        for (int j = 1; j <= t.length(); j++) {
            if (s.charAt(i-1) == t.charAt(j-1)) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            } else {
                dp[i][j] = dp[i-1][j];
            }
        }
    }

    return dp[s.length()][t.length()];
}
```

### [49. 两个字符串的删除操作](https://programmercarl.com/0583.两个字符串的删除操作.html)

`dp[i][j]`：以i-1为结尾的字符串word1，和以j-1位结尾的字符串word2，想要达到相等，所需要删除元素的最少次数。

- 递归函数

```java
for (int i = 1; i <= word1.length(); i++) {
    for (int j = 1; j <= word2.length(); j++) {
        if (word1.charAt(i-1) == word2.charAt(j-1)) {
            dp[i][j] = dp[i-1][j-1];
        } else {
            dp[i][j] = Math.min(dp[i-1][j] + 1,dp[i][j-1] + 1);
        }
    }
}
```

- 初始化

```java
for (int i = 1; i <= word1.length(); i++) {
    dp[i][0] = i;
}

for (int j = 1; j <= word2.length(); j++) {
    dp[0][j] = j;
}
```

### [52. 回文子串](https://programmercarl.com/0647.回文子串.html)

#### 双指针法

以中间向两边扩散，其中可以作为中间点的可以是一个元素或者两个元素

```java
/**
 * 双指针
 * @param s
 * @return
 */
public int countSubstrings(String s) {
    int result = 0;

    for (int i = 0; i < s.length(); i++) {
        result += extend(s,i,i,s.length());
        result += extend(s,i,i+1,s.length());
    }

    return result;
}

private int extend(String s, int i, int j, int length) {

    if (i > j) return 0;
    int res = 0;
    for (;i >= 0 && j < length; i--,j++) {
        if (s.charAt(i) == s.charAt(j)){
            res++;
        }
    }
    return res;
}
```

#### DP方法

- 确定dp数组（dp table）以及下标的含义

**布尔类型的`dp[i][j]`：表示区间范围[i,j] （注意是左闭右闭）的子串是否是回文子串，如果是`dp[i][j]`为true，否则为false。**

- 递推公式

当s[i]与s[j]不相等，那没啥好说的了，`dp[i][j]`一定是false。

当s[i]与s[j]相等时，这就复杂一些了，有如下三种情况

- 情况一：下标i 与 j相同，同一个字符例如a，当然是回文子串
- 情况二：下标i 与 j相差为1，例如aa，也是回文子串
- 情况三：下标：i 与 j相差大于1的时候，例如cabac，此时s[i]与s[j]已经相同了，我们看i到j区间是不是回文子串就看aba是不是回文就可以了，那么aba的区间就是 i+1 与 j-1区间，这个区间是不是回文就看`dp[i + 1][j - 1]`是否为true。

```cpp
if (s[i] == s[j]) {
    if (j - i <= 1) { // 情况一 和 情况二
        result++;
        dp[i][j] = true;
    } else if (dp[i + 1][j - 1]) { // 情况三
        result++;
        dp[i][j] = true;
    }
}
```

- `dp[i][j]`初始化为false。

- 遍历顺序

**一定要从下到上，从左到右遍历，这样保证`dp[i + 1][j - 1]`都是经过计算的**。

```java
/**
 * DP方法
 * @param s
 * @return
 */
public int countSubstrings2(String s) {
    boolean[][] dp = new boolean[s.length()][s.length()];
    int res = 0;

    for (int i = s.length()-1; i >= 0; i--) {
        for (int j = i; j < s.length(); j++) {
            if (s.charAt(i) == s.charAt(j)) {
                if (j - i <= 1){
                    res++;
                    dp[i][j] = true;
                } else if (dp[i+1][j-1]) {
                    res++;
                    dp[i][j] = true;
                }
            }
        }
    }

    return res;
}
```

### [动态规划：最长回文子串](https://programmercarl.com/0005.最长回文子串.html)

与[52. 回文子串](https://programmercarl.com/0647.回文子串.html)是同一种题

```java
/**
 * 双指针法
 * @param s
 * @return
 */
public String longestPalindrome(String s) {
    if (s.length() <= 1) return s;
    int start = 0;
    int maxlen = 1;

    for (int i = 0; i < s.length(); i++) {
        int len1 = extend(s,i,i,s.length());
        int len2 = extend(s,i,i+1,s.length());
        int len = Math.max(len1,len2);
        if (maxlen < len) {
            maxlen = len;
            start = i - (maxlen - 1) / 2;
        }
    }

    return s.substring(start,start+maxlen);
}

private int extend(String s, int left, int right, int length) {
    int len = 1;

    while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
        len = right - left + 1;
        left--;
        right++;
    }

    return len;
}


/**
 * DP
 * @param s
 * @return
 */
public String longestPalindrome2(String s) {
    if (s.length() <= 1) return s;
    boolean[][] dp = new boolean[s.length()][s.length()];
    int maxlen = 1;
    int start = 0;

    for (int i = s.length()-1; i >= 0; i--) {
        for (int j = i; j < s.length(); j++) {
            if (s.charAt(i) == s.charAt(j)) {
                if (j - i <= 1) {
                    dp[i][j] = true;
                } else {
                    if (dp[i+1][j-1]) {
                        dp[i][j] = true;
                    }
                }
            }

            if (dp[i][j] && maxlen < j - i + 1) {
                maxlen = j - i + 1;
                start = i;
            }
        }
    }
    return s.substring(start,start+maxlen);

}
```

### [动态规划：分割回文串II](https://programmercarl.com/0132.分割回文串II.html)

先用一个二维数组来保存整个字符串的回文情况。就是[52. 回文子串](https://programmercarl.com/0647.回文子串.html)和[动态规划：最长回文子串](https://programmercarl.com/0005.最长回文子串.html)中的方法。

- 确定dp数组（dp table）以及下标的含义

dp[i]：范围是[0, i]的回文子串，最少分割次数是dp[i]。

- 递归公式

如果要对长度为[0, i]的子串进行分割，分割点为j。

那么如果分割后，区间[j + 1, i]是回文子串，那么dp[i] 就等于 dp[j] + 1。

[0, j]区间的最小切割数量，我们已经知道了就是dp[j]。

此时就找到了递推关系，当切割点j在[0, i] 之间时候，dp[i] = dp[j] + 1;

本题是要找到最少分割次数，所以遍历j的时候要取最小的dp[i]。

**所以最后递推公式为：dp[i] = min(dp[i], dp[j] + 1);**

- 初始化

dp[i]的最大值其实就是i，也就是把每个字符分割出来。

```cpp
for (int i = 0; i < s.size(); i++) dp[i] = i;
```

- 遍历顺序

j是在[0，i]之间，所以遍历i的for循环一定在外层，这里遍历j的for循环在内层才能通过 计算过的dp[j]数值推导出dp[i]。

```java
public int minCut(String s) {
    boolean[][] isHuiWen = new boolean[s.length()][s.length()];
    for (int i = s.length()-1; i >= 0; i--) {
        for (int j = i; j < s.length(); j++) {
            if (s.charAt(i) == s.charAt(j)) {
                if (j - i <= 1) {
                    isHuiWen[i][j] = true;
                } else if (isHuiWen[i+1][j-1]) {
                    isHuiWen[i][j] = true;
                }
            }
        }
    }
    int[] dp = new int[s.length()];
    for (int i = 0; i < s.length(); i++) {
        dp[i] = i;
    }
    for (int i = 1; i < s.length(); i++) {
        if (isHuiWen[0][i]) {
            dp[i] = 0;
            continue;
        }
        for (int j = 0; j < i; j++) {
            if (isHuiWen[j+1][i]) {
                dp[i] = Math.min(dp[i],dp[j] + 1);
            }
        }
    }
    return dp[s.length()-1];
}
```

### [53. 最长回文子序列](https://programmercarl.com/0516.最长回文子序列.html)

**`dp[i][j]`：字符串s在[i, j]范围内最长的回文子序列的长度为`dp[i][j]`**。

- 递推公式

如果s[i]与s[j]相同，那么`dp[i][j] = dp[i + 1][j - 1] + 2;`

如果s[i]与s[j]不相同，说明s[i]和s[j]的同时加入 并不能增加[i,j]区间回文子序列的长度，那么分别加入s[i]、s[j]看看哪一个可以组成最长的回文子序列。

加入s[j]的回文子序列长度为`dp[i + 1][j]。`

加入s[i]的回文子序列长度为`dp[i][j - 1]。`

那么`dp[i][j]`一定是取最大的，即：`dp[i][j] = max(dp[i + 1][j], dp[i][j - 1]);`

```java
if (s.charAt(i) == s.charAt(j)) {
    dp[i][j] = dp[i+1][j-1] + 2;
} else {
    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
}
```

- 初始化

首先要考虑当i 和j 相同的情况，从递推公式：`dp[i][j] = dp[i + 1][j - 1] + 2;` 可以看出 递推公式是计算不到 i 和j相同时候的情况。

所以需要手动初始化一下，当i与j相同，那么dp[i][j]一定是等于1的，即：一个字符的回文子序列长度就是1。

其他情况`dp[i][j]`初始为0就行，这样递推公式：`dp[i][j] = max(dp[i + 1][j], dp[i][j - 1]);` 中dp[i][j]才不会被初始值覆盖。

```
int[][] dp = new int[s.length()][s.length()];

for (int i = 0; i < s.length(); i++) {
    dp[i][i] = 1;
}
```

- 遍历顺序

**所以遍历i的时候一定要从下到上遍历，这样才能保证下一行的数据是经过计算的**。

j的话，可以正常从左向右遍历。

```java
public int longestPalindromeSubseq(String s) {
    int[][] dp = new int[s.length()][s.length()];

    for (int i = 0; i < s.length(); i++) {
        dp[i][i] = 1;
    }

    for (int i = s.length()-1; i >= 0; i--) {
        for (int j = i + 1; j < s.length(); j++) {
            if (s.charAt(i) == s.charAt(j)) {
                dp[i][j] = dp[i+1][j-1] + 2;
            } else {
                dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
            }
        }
    }

    return dp[0][s.length()-1];
}
```

# 9. 单调栈

**通常是一维数组，要寻找任一个元素的右边或者左边第一个比自己大或者小的元素的位置，此时我们就要想到可以用单调栈了**。时间复杂度为O(n)。

**单调栈的本质是空间换时间**，因为在遍历的过程中需要用一个栈来记录右边第一个比当前元素高的元素，优点是整个数组只需要遍历一次。

**更直白来说，就是用一个栈来记录我们遍历过的元素**，因为我们遍历数组的时候，我们不知道之前都遍历了哪些元素，以至于遍历一个元素找不到是不是之前遍历过一个更小的，所以我们需要用一个容器（这里用单调栈）来记录我们遍历过的元素。

1. 单调栈里存放的元素是什么？

单调栈里只需要存放元素的下标i就可以了，如果需要使用对应的元素，直接T[i]就可以获取。

1. 单调栈里元素是递增呢？ 还是递减呢？

**注意以下讲解中，顺序的描述为 从栈头到栈底的顺序**，因为单纯的说从左到右或者从前到后，不说栈头朝哪个方向的话，大家一定比较懵。

这里我们要使用递增循序（再强调一下是指从栈头到栈底的顺序），因为只有递增的时候，栈里要加入一个元素i的时候，才知道栈顶元素在数组中右面第一个比栈顶元素大的元素是i。

即：**如果求一个元素右边第一个更大元素，单调栈就是递增的，如果求一个元素右边第一个更小元素，单调栈就是递减的。**

## 9.1 做题总结与技巧

### **通常是一维数组，要寻找任一个元素的右边或者左边第一个比自己大或者小的元素的位置，此时我们就要想到可以用单调栈了**。时间复杂度为O(n)。

### 用一个栈来记录我们遍历过的元素，单调栈里只需要存放元素的下标i。

### 如果求一个元素右边第一个更大元素，单调栈就是递增的，如果求一个元素右边第一个更小元素，单调栈就是递减的。

### 注意：递增是指当进栈元素大于栈头元素时需要pop栈头，之后元素进栈；相反，递减是指进栈元素小于栈头元素时需要pop栈头，之后元素进栈

## 9.2 重点题目及出错的题目等

### [2. 下一个更大元素I](https://programmercarl.com/0496.下一个更大元素I.html)

情况三：当前遍历的元素T[i]大于栈顶元素T[st.top()]的情况

此时如果入栈就不满足递增栈了，这也是找到右边第一个比自己大的元素的时候。

判断栈顶元素是否在nums1里出现过，（注意栈里的元素是nums2的元素），如果出现过，开始记录结果。

```java
public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    HashMap<Integer,Integer> map = new HashMap<>();
    Deque<Integer> stack = new LinkedList<>();
    int[] ans = new int[nums1.length];
    Arrays.fill(ans,-1);
    for (int i = 0; i < nums1.length; i++) {
        map.put(nums1[i], i);
    }

    stack.push(0);

    for (int i = 1; i < nums2.length; i++) {
        if (nums2[i] <= nums2[stack.peek()]) {
            stack.push(i);
        } else {
            while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                if (map.containsKey(nums2[stack.peek()])){
                    Integer index = map.get(nums2[stack.peek()]);
                    ans[index] = nums2[i];
                }
                stack.pop();
            }
            stack.push(i);
        }
    }

    return ans;
}
```

### [3. 下一个更大元素II](https://programmercarl.com/0503.下一个更大元素II.html)

#### 循环数组如何模拟遍历两遍

本题变为了**循环数组**

有一个模拟循环两边数组的方法，就是取余

```java
public int[] nextGreaterElements(int[] nums) {
    Deque<Integer> stack = new LinkedList<>();
    int n = nums.length;
    int[] ans = new int[n];
    Arrays.fill(ans,-1);
    for (int i = 0; i < n * 2; i++) {  //模拟循环两边数组
        while (!stack.isEmpty() && nums[i % n] > nums[stack.peek()]) {
            ans[stack.peek()] = nums[i % n];
            stack.pop();
        }
        stack.push(i % n);
    }

    return ans;
}
```

### [4. 接雨水](https://programmercarl.com/0042.接雨水.html)

**实际上是要找当前柱子的左右第一个高的柱子。**

#### 双指针法

循环过程中每次都找左右两个柱子进行计算。

#### 双指针优化

先用两个数组（左边第一个高柱子、右边第一个高柱子）记录，然后再遍历进行计算。

#### 单调栈

在遍历的的过程中找到左右第一个高的柱子然后进行计算。

**按行计算大小。**

有以下三种情况：

- 情况一：当前遍历的元素（柱子）高度小于栈顶元素的高度 height[i] < height[st.top()]

直接进栈

- 情况二：当前遍历的元素（柱子）高度等于栈顶元素的高度 height[i] == height[st.top()]

只保留最新的，原先的出栈，新的进栈

- 情况三：当前遍历的元素（柱子）高度大于栈顶元素的高度 height[i] > height[st.top()]

此时弹出中间凹下去的那个柱子，作为mid。然后此时的栈头是左面第一个高的柱子，height[i]是右面第一个高的柱子。

积水决定于两者小的那个高度。`int h = Math.min(height[i],height[stack.peek()]) - height[mid];`

宽度只算中间的柱子。`int w = i - stack.peek() - 1;`

```java
public int trap(int[] height) {
    Deque<Integer> deque = new LinkedList<>();
    int sum = 0;
    deque.push(0);

    for (int i = 1; i < height.length; i++) {
        if (height[i] < height[deque.peek()]) {
            deque.push(i);
        } else if (height[i] == height[deque.peek()]) {
            deque.pop();
            deque.push(i);
        } else {
            while (!deque.isEmpty() && height[i] > height[deque.peek()]) {
                int mid = deque.pop();
                if (!deque.isEmpty()) {
                    int left = deque.peek();
                    int curHeight = Math.min(height[left],height[i]) - height[mid];
                    int curLen = i - left - 1;
                    sum += curHeight * curLen;
                }
            }
            deque.push(i);
        }
    }
    return sum;
}
```

### [5. 柱状图中最大的矩形](https://programmercarl.com/0084.柱状图中最大的矩形.html)

**本题与[4. 接雨水](https://programmercarl.com/0042.接雨水.html)相反，是找当前柱子的左右第一个低的柱子。**

```java
public int largestRectangleArea(int[] heights) {
    Deque<Integer> stack = new LinkedList<>();
    int res = 0;
    int[] newHeight = new int[heights.length + 2];
    System.arraycopy(heights,0,newHeight,1,heights.length);
    newHeight[0] = 0;
    newHeight[heights.length+1] = 0;

    stack.push(0);
    for (int i = 1; i < newHeight.length; i++) {
        if (newHeight[i] > newHeight[stack.peek()]) {
            stack.push(i);
        } else if (newHeight[i] == newHeight[stack.peek()]) {
            stack.pop();
            stack.push(i);
        } else {
            while (!stack.isEmpty() && newHeight[i] < newHeight[stack.peek()]) {
                int mid = stack.pop();
                if (!stack.isEmpty()) {
                    int h = newHeight[mid];
                    int w = i - stack.peek() - 1;
                    res = Math.max(res,h*w);
                }
            }
            stack.push(i);
        }
    }
    return res;
}
```

# 10.  图论

## 10.1 做题总结与技巧

### 邻接表法建图

#### 无权图

```
List<Integer>[] graph = new LinkedList[V];
for (int i = 0; i < V; i++) {
    graph[i] = new LinkedList<>();
}
```

#### 有权图

```
List<int[]>[] graph = new LinkedList[V];
for (int i = 0; i < numCourses; i++) {
    graph[i] = new LinkedList<>();
}
```

## 10.1.1   深搜三部曲（与回溯中的递归三部曲类似）

#### 确认递归函数，参数

```cpp
void dfs(参数)
```

一般情况，深搜需要 二维数组数组结构保存所有路径，需要一维数组保存单一路径，这种保存结果的数组，我们可以定义一个全局变量，避免让我们的函数参数过多。

```java
List<List<Integer>> res = new ArrayList<>(); // 保存符合条件的所有路径
LinkedList<Integer> path = new LinkedList<>(); // 起点到终点的路径
void dfs (图，目前搜索的节点)  
```

#### 确认终止条件

```cpp
if (终止条件) {
    存放结果;
    return;
}
```

终止添加不仅是结束本层递归，同时也是我们收获结果的时候。

另外，其实很多dfs写法，没有写终止条件，其实终止条件写在了， 下面dfs递归的逻辑里了，也就是不符合条件，直接不会向下递归。这里如果大家不理解的话，没关系，后面会有具体题目来讲解。

#### 处理目前搜索节点出发的路径

一般这里就是一个for循环的操作，去遍历 目前搜索节点 所能到的所有节点。

```cpp
for (选择：本节点所连接的其他节点) {
    处理节点;
    dfs(图，选择的节点); // 递归
    回溯，撤销处理结果
}
```

#### 模板题[2. 所有可能的路径](https://programmercarl.com/0797.所有可能的路径.html)

- 确认递归函数，参数

首先我们dfs函数一定要存一个图，用来遍历的，还要存一个目前我们遍历的节点，定义为x

- 终止条件

当目前遍历的节点 为 最后一个节点的时候，就找到了一条，从 出发点到终止点的路径。

当前遍历的节点，我们定义为x，最后一点节点，就是 graph.size() - 1（因为题目描述是找出所有从节点 0 到节点 n-1 的路径并输出）。

- 处理目前搜索节点出发的路径

接下来是走 当前遍历节点x的下一个节点。首先是要找到 x节点链接了哪些节点呢，接下来就是将 选中的x所连接的节点，加入到 单一路径来。

- 完整代码：

```java
List<List<Integer>> res = new ArrayList<>();
LinkedList<Integer> path = new LinkedList<>();
public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    path.add(0);
    dfs(graph,0);
    return res;
}

private void dfs(int[][] graph, int x) {
    if (x == graph.length-1) {
        res.add(new ArrayList<>(path));
        return;
    }

    for (int i = 0; i < graph[x].length; i++) {
        path.add(graph[x][i]);
        dfs(graph,graph[x][i]);
        path.removeLast();
    }
}
```

### 这种有向图路径问题，最合适使用深搜.

### 而深搜和广搜都适合解决颜色类的问题，例如岛屿系列，其实都是 遍历+标记，所以使用哪种遍历都是可以的。

#### 模板题[4. 岛屿数量.深搜版](https://programmercarl.com/0200.岛屿数量.深搜版.html)

```java
int[][] dir = {
        {0,1},{1,0},{-1,0},{0,-1}
};
public int numIslands(char[][] grid) {
    int m  = grid.length;;
    int n = grid[0].length;
    boolean[][] visited = new boolean[m][n];
    int res = 0;
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (!visited[i][j] && grid[i][j] == '1') {
                visited[i][j] = true;
                res++;
                dfs(grid,visited,i,j);
            }
        }
    }
    return res;
}

private void dfs(char[][] grid, boolean[][] visited, int x, int y) {
    for (int i = 0; i < 4; i++) {
        int nextx = x + dir[i][0];
        int nexty = y + dir[i][1];
        if (nextx < 0 || nextx >= grid.length || nexty < 0 || nexty >= grid[0].length) continue;
        if (!visited[nextx][nexty] && grid[nextx][nexty] == '1') {
            visited[nextx][nexty] = true;
            dfs(grid, visited, nextx, nexty);
        }
    }
}
```

## 10.1.2   广搜的搜索方式就适合于解决两个点之间的最短路径问题。

#### 广搜模板题[5. 岛屿数量.广搜版](https://programmercarl.com/0200.岛屿数量.广搜版.html)

```java
int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // 表示四个方向
// grid 是地图，也就是一个二维数组
// visited标记访问过的节点，不要重复访问
// x,y 表示开始搜索节点的下标
private void bfs(int[][] grid, boolean[][] visited, int x, int y) {
    Deque<int[]> deque = new LinkedList<>();
    deque.offer(new int[]{x,y});  // 起始节点加入队列
    visited[x][y] = true;   // 只要加入队列，立刻标记为访问过的节点

    while (!deque.isEmpty()) { // 开始遍历队列里的元素
        int[] cur = deque.poll();  // 从队列取元素
        int curx = cur[0];
        int cury = cur[1];  // 当前节点坐标
        for (int i = 0; i < 4; i++) { // 开始想当前节点的四个方向左右上下去遍历
            int nextx = curx + dir[i][0];
            int nexty = cury + dir[i][1]; // 获取周边四个方向的坐标
            if (nextx < 0 || nextx >= grid.length || nexty < 0 || nexty >= grid[0].length) continue;
            if (!visited[nextx][nexty]) {// 如果节点没被访问过
                deque.push(new int[]{nextx,nexty});   // 队列添加该节点为下一轮要遍历的节点
                visited[nextx][nexty] = true;  // 只要加入队列立刻标记，避免重复访问
            }
        }
    }
}
```

## 10.1.3   并查集

### 并查集常用来解决连通性问题。就是当我们需要判断两个元素是否在同一个集合里的时候，我们就要想到用并查集。以及无向图的有环无环问题。

并查集主要有两个功能：

- 将两个元素添加到一个集合中。
- 判断两个元素在不在同一个集合

我们将三个元素A，B，C （分别是数字）放在同一个集合，其实就是将三个元素连通在一起，如何连通呢。

只需要用一个一维数组来表示，即：father[A] = B，father[B] = C 这样就表述 A 与 B 与 C连通了（有向连通图）。

### 代码模板：

#### labuladong版本：

```java
public class UF {
    
    private int count;  // 连通分量个数
    public int[] father; // 父节点数组

    // 构造函数，初始化父节点数组
    public UF(int n) {
        this.count = n;
        father = new int[n];
        for (int i = 0; i < n; ++i) {
            father[i] = i;
        }
    }

    // 并查集里寻根的过程
    public int find(int u) {
        if (u == father[u]) return u;
            // 路径压缩
        else return father[u] = find(father[u]);
    }

    // 判断 u 和 v是否找到同一个根
    public boolean isSame(int u, int v) {
        u = find(u);
        v = find(v);
        return u == v;
    }

    // 将v->u 这条边加入并查集
    public void join(int u, int v) {
        u = find(u); // 寻找u的根
        v = find(v); // 寻找v的根
        if (u == v) return; // 如果发现根相同，则说明在一个集合，不用两个节点相连直接返回
        father[v] = u;
        count--;  // 两个连通分量合并成一个连通分量
    }

    // 返回图中的连通分量个数
    public int count() {
        return count;
    }
}
```

#### 代码随想录版本：

```java
public class BingChaJi {
    public int n = 1005; // n根据题目中节点数量而定，一般比节点数量大一点就好
    public int[] father = new int[n];  

    // 并查集初始化
    public void init() {
        for (int i = 0; i < n; ++i) {
            father[i] = i;
        }
    }
    // 并查集里寻根的过程
    public int find(int u) {
        if (u == father[u]) return u;
            // 路径压缩
        else return father[u] = find(father[u]);
    }

    // 判断 u 和 v是否找到同一个根
    public boolean isSame(int u, int v) {
        u = find(u);
        v = find(v);
        return u == v;
    }

    // 将v->u 这条边加入并查集
    public void join(int u, int v) {
        u = find(u); // 寻找u的根
        v = find(v); // 寻找v的根
        if (u == v) return ; // 如果发现根相同，则说明在一个集合，不用两个节点相连直接返回
        father[v] = u;
    }
}
```

### 通过模板，我们可以知道，并查集主要有三个功能。

1. 寻找根节点，函数：find(int u)，也就是判断这个节点的祖先节点是哪个
2. 将两个节点接入到同一个集合，函数：join(int u, int v)，将两个节点连在同一个根节点上
3. 判断两个节点是否在同一个集合，函数：isSame(int u, int v)，就是判断两个节点是不是同一个根节点

### 模板题[15. 寻找图中是否存在路径](https://programmercarl.com/1971.寻找图中是否存在路径.html)

```java
int[] father;
public boolean validPath(int n, int[][] edges, int source, int destination) {
    father = new int[n];
    init();
    for (int i = 0; i < edges.length; i++) {
        join(edges[i][0],edges[i][1]);
    }
    return isSame(source,destination);
}

private void init() {
    for (int i = 0; i < father.length; i++) {
        father[i] = i;
    }
}

private int find(int u) {
    if (u == father[u]) return u;
    else return father[u] = find(father[u]);
}

private boolean isSame(int u, int v) {
    u = find(u);
    v = find(v);
    return u == v;
}

private void join(int u, int v) {
    u = find(u);
    v = find(v);
    if (u == v) return;
    father[v] = u;
}
```

## 10.1.4  DFS/BFS有向图有环问题   拓扑排序

### 拓扑排序的过程

1. 找到入度为0 的节点，加入结果集
2. 将该节点从图中移除

循环以上两步，直到 所有节点都在图中被移除了。

### 判断是否有环

如果我们发现结果集元素个数 不等于 图中节点个数，我们就可以认定图中一定有 有向环！

```java
package base;

import java.util.*;

public class TuoPu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<List<Integer>> map = new ArrayList<List<Integer>>(); //记录依赖关系
        int[] indegree = new int[n]; //记录每个节点的入度

        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            map.get(from).add(to); // 记录指向哪些节点
            indegree[to]++; // to的入度加一
        }

        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) { // 入度为0的文件，可以作为开头，先加入队列
                queue.offer(i);
            }
        }

        List<Integer> result = new ArrayList<>();

        // 拓扑排序
        while (!queue.isEmpty()) {
            int cur = queue.poll();// 当前选中的节点
            result.add(cur);
            for (Integer node : map.get(cur)) {
                indegree[node]--; // cur的指向的节点入度-1
                if (indegree[node] == 0) {
                    queue.offer(node);
                }
            }
        }

        if (result.size() == n) {
            for (int i = 0; i < result.size(); i++) {
                System.out.println(result.get(i));
                if (i < result.size() - 1) {
                    System.out.println(" ");
                }
            }
        } else {
            System.out.println(-1);
        }

    }
}
```

### 经典题：[207. 课程表](https://leetcode.cn/problems/course-schedule/)

#### DFS判断是否有环

```java
boolean[] visited;  //是否访问过该节点
boolean[] onPath;  //// 记录一次递归堆栈中的节点  记录当前 traverse 经过的路径
boolean hasCycle = false; // 记录图中是否有环
public boolean canFinish(int numCourses, int[][] prerequisites) {
    List<Integer>[] graph = buildGraph(numCourses, prerequisites);
    visited = new boolean[numCourses];
    onPath = new boolean[numCourses];
    for (int i = 0; i < numCourses; i++) {
        traversal(graph,i);
    }
    return !hasCycle;
}

private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
    // 图中共有 numCourses 个节点
    List<Integer>[] graph = new LinkedList[numCourses];
    for (int i = 0; i < numCourses; i++) {
        graph[i] = new LinkedList<>();
    }

    for (int[] edge : prerequisites) {
        int from = edge[1], to = edge[0];
        // 添加一条从 from 指向 to 的有向边
        // 边的方向是「被依赖」关系，即修完课程 from 才能修课程 to
        graph[from].add(to);
    }
    return graph;
}

private void traversal(List<Integer>[] graph, int s) {
    if (onPath[s]) {
        //发现有环
        hasCycle = true;
    }
    // 从节点 s 开始 DFS 遍历，将遍历过的节点标记为 true
    if (visited[s] || hasCycle) return;

    // 将节点 s 标记为已遍历
    visited[s] = true;
    // 开始遍历节点 s
    onPath[s] = true;
    for (Integer t : graph[s]) {
        traversal(graph, t);
    }
    // 节点 s 遍历完成
    onPath[s] = false;
}
```

#### BFS判断是否有环

```java
/**
 * bfs
 * @param numCourses
 * @param prerequisites
 * @return
 */
public boolean canFinishBFS(int numCourses, int[][] prerequisites) {
    // 建图，有向边代表「被依赖」关系
    List<Integer>[] graph = buildGraph(numCourses, prerequisites);
    // 构建入度数组
    int[] indegree = new int[numCourses];
    for (int[] edge : prerequisites) {
        int from = edge[1], to = edge[0];
        // 节点 to 的入度加一
        indegree[to]++;
    }

    // 根据入度初始化队列中的节点
    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
        if (indegree[i] == 0) {
            // 节点 i 没有入度，即没有依赖的节点
            // 可以作为拓扑排序的起点，加入队列
            q.offer(i);

        }
    }

    // 记录遍历的节点个数
    int count = 0;
    // 开始执行 BFS 循环
    while (!q.isEmpty()) {
        // 弹出节点 cur，并将它指向的节点的入度减一
        int cur = q.poll();
        count++;
        for (int next : graph[cur]) {
            indegree[next]--;
            if (indegree[next] == 0) {
                // 如果入度变为 0，说明 next 依赖的节点都已被遍历
                q.offer(next);
            }
        }
    }

    // 如果所有节点都被遍历过，说明不成环
    return count == numCourses;
}
```

### 经典题：[210. 课程表 II](https://leetcode.cn/problems/course-schedule-ii/)

#### DFS实现拓扑排序

```java
boolean[] visited;
boolean[] onPath;
boolean hasCycle = false;
List<Integer> path = new ArrayList<>();
public int[] findOrder(int numCourses, int[][] prerequisites) {
    visited = new boolean[numCourses];
    onPath = new boolean[numCourses];
    List<Integer>[] graph = buildGraph(numCourses, prerequisites);

    for (int i = 0; i < numCourses; i++) {
        dfs(graph,i);
    }

    if (hasCycle) return new int[]{};
    Collections.reverse(path); // 将后序遍历的结果进行反转，就是拓扑排序的结果。


    int[] res = path.stream().mapToInt(Integer::intValue).toArray();

    return res;

}

private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
    List<Integer>[] graph = new LinkedList[numCourses];

    for (int i = 0; i < graph.length; i++) {
        graph[i] = new LinkedList<>();
    }

    for (int[] prerequisite : prerequisites) {
        int from = prerequisite[1];
        int to = prerequisite[0];
        graph[from].add(to);
    }
    return graph;
}

private void dfs(List<Integer>[] graph, int s) {
    if (onPath[s]) {
        hasCycle = true;
        return;
    }

    if (visited[s] || hasCycle) return;

    visited[s] = true;
    onPath[s] = true;

    for (Integer x : graph[s]) {
        dfs(graph,x);
    }
    path.add(s);   //访问完添加
    onPath[s] = false;
}
```

#### BFS实现拓扑排序

```java
/**
 * BFS
 * @param numCourses
 * @param prerequisites
 * @return
 */
public int[] findOrderBFS(int numCourses, int[][] prerequisites) {
    // 建图，和环检测算法相同
    List<Integer>[] graph = buildGraph(numCourses, prerequisites);
    // 计算入度，和环检测算法相同
    int[] indegree = new int[numCourses];
    for (int[] edge : prerequisites) {
        int from = edge[1], to = edge[0];
        indegree[to]++;
    }

    // 根据入度初始化队列中的节点，和环检测算法相同
    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
        if (indegree[i] == 0) {
            q.offer(i);

        }
    }

    // 记录拓扑排序结果
    int[] res = new int[numCourses];
    // 记录遍历节点的顺序（索引）
    int count = 0;
    // 开始执行 BFS 算法
    while (!q.isEmpty()) {
        int cur = q.poll();
        // 弹出节点的顺序即为拓扑排序结果
        res[count] = cur;
        count++;
        for (int next : graph[cur]) {

            indegree[next]--;
            if (indegree[next] == 0) {
                q.offer(next);
            }
        }
    }

    if (count != numCourses) {
        // 存在环，拓扑排序不存在
        return new int[]{};
    }

    return res;
}
```



## 10.1.5 二分图



## 10.1.6 Pirm算法和Kruskal算法

### Pirm算法模板

**用minDist数组来记录每次的最近边**

```java
import java.util.Arrays;
import java.util.Scanner;

public class KM53 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        int[][] graph = new int[V+1][V+1];
        for (int i = 0; i <= V; i++) {
            Arrays.fill(graph[i], 10001);
        }
        for (int i = 0; i < E; i++) {
            int from  = sc.nextInt();
            int to   = sc.nextInt();
            int k = sc.nextInt();
            graph[from][to] = k;
            graph[to][from] = k;
        }

        //记录最小生成树
        int[] parent = new int[V+1];
        Arrays.fill(parent, -1);

        int[] minDist = new int[V+1];
        Arrays.fill(minDist,10001);
        boolean[] visited = new boolean[V+1];

        for (int i = 1; i < V; i++) {
            // 1、prim三部曲，第一步：选距离生成树最近节点
            int cur = -1;
            int minVal = Integer.MAX_VALUE;
            for (int j = 1; j <= V; j++) {
                if (!visited[j] && minDist[j] < minVal) {
                    minVal = minDist[j];
                    cur = j;
                }
            }
            // 2、prim三部曲，第二步：最近节点（cur）加入生成树
            visited[cur] = true;

            // 3、prim三部曲，第三步：更新非生成树节点到生成树的距离（即更新minDist数组）
            for (int j = 1; j <= V; j++) {
                if (!visited[j] && graph[cur][j] < minDist[j]) {
                    minDist[j] = graph[cur][j];

                    parent[j] = cur; // 记录最小生成树的边 （注意数组指向的顺序很重要）
                }
            }
        }

        int res = 0;
        for (int i = 2; i <= V; i++) {
            res += minDist[i];
        }

        // 输出 最小生成树边的链接情况
        for (int i = 1; i <= V; i++) {
            System.out.println(i + "->" + parent[i]);
        }

        System.out.println(res);
    }
}

```

**用堆来记录最近边**

```java
class Prim {
    // 核心数据结构，存储「横切边」的优先级队列
    private PriorityQueue<int[]> pq;
    // 类似 visited 数组的作用，记录哪些节点已经成为最小生成树的一部分
    private boolean[] inMST;
    // 记录最小生成树的权重和
    private int weightSum = 0;
    // graph 是用邻接表表示的一幅图，
    // graph[s] 记录节点 s 所有相邻的边，
    // 三元组 int[]{from, to, weight} 表示一条边
    private List<int[]>[] graph;

    public Prim(List<int[]>[] graph) {
        this.graph = graph;
        this.pq = new PriorityQueue<>((a, b) -> {
            // 按照边的权重从小到大排序
            return a[2] - b[2];
        });
        // 图中有 n 个节点
        int n = graph.length;
        this.inMST = new boolean[n];

        // 随便从一个点开始切分都可以，我们不妨从节点 0 开始
        inMST[0] = true;
        cut(0);
        // 不断进行切分，向最小生成树中添加边
        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            int to = edge[1];
            int weight = edge[2];
            if (inMST[to]) {
                // 节点 to 已经在最小生成树中，跳过
                // 否则这条边会产生环
                continue;
            }
            // 将边 edge 加入最小生成树
            weightSum += weight;
            inMST[to] = true;
            // 节点 to 加入后，进行新一轮切分，会产生更多横切边
            cut(to);
        }
    }

    // 将 s 的横切边加入优先队列
    private void cut(int s) {
        // 遍历 s 的邻边
        for (int[] edge : graph[s]) {
            int to = edge[1];
            if (inMST[to]) {
                // 相邻接点 to 已经在最小生成树中，跳过
                // 否则这条边会产生环
                continue;
            }
            // 加入横切边队列
            pq.offer(edge);
        }
    }

    // 最小生成树的权重和
    public int weightSum() {
        return weightSum;
    }

    // 判断最小生成树是否包含图中的所有节点
    public boolean allConnected() {
        for (int i = 0; i < inMST.length; i++) {
            if (!inMST[i]) {
                return false;
            }
        }
        return true;
    }
}
```

### Kruskal算法模板

```java
package base;

import java.util.*;

public class Kruskal {
    static class Edge {
        int src, dest, weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    static class UF {
        int[] parent;

        public UF(int n) {
            parent = new int[n+1];
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
            }
        }

        public int find(int u) {
            if (u == parent[u]) return u;
            else return parent[u] = find(parent[u]);
        }

        public void join(int u, int v) {
            u = find(u);
            v = find(v);
            if (u == v) return;
            parent[v] = u;
        }

        public boolean isSame(int u, int v) {
            u = find(u);
            v = find(v);
            return u == v;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        List<Edge> edges = new ArrayList<>();
        int res_val = 0;
        List<Edge> result = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int weight = sc.nextInt();
            edges.add(new Edge(src, dest, weight));
        }

        edges.sort(Comparator.comparingInt(edge -> edge.weight));// 按边的权值对边进行从小到大排序

        UF uf = new UF(V);
        // 从头开始遍历边
        for (Edge edge : edges) {
            // 并查集，搜出两个节点的祖先
            int x = uf.find(edge.src);
            int y = uf.find(edge.dest);

            if (x != y) {// 如果祖先不同，则不在同一个集合
                result.add(edge);
                res_val += edge.weight; // 这条边可以作为生成树的边
                uf.join(x,y); // 两个节点加入到同一个集合
            }
        }

        System.out.println(res_val);

        for (Edge edge : result) {
            System.out.println(edge.src + " - " + edge.dest + " : " + edge.weight);
        }


    }

}
```



```java
public class Kruskal {

    public int minimumCost(int n, int[][] connections) {
        // 城市编号为 1...n，所以初始化大小为 n + 1
        UF uf = new UF(n + 1);
        // 对所有边按照权重从小到大排序
        Arrays.sort(connections, (a, b) -> (a[2] - b[2]));
        // 记录最小生成树的权重之和
        int mst = 0;
        for (int[] edge : connections) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            // 若这条边会产生环，则不能加入 mst
            if (uf.isSame(u, v)) {
                continue;
            }
            // 若这条边不会产生环，则属于最小生成树
            mst += weight;
            uf.join(u, v);
        }
        // 保证所有节点都被连通
        // 按理说 uf.count() == 1 说明所有节点被连通
        // 但因为节点 0 没有被使用，所以 0 会额外占用一个连通分量
        return uf.count() == 2 ? mst : -1;
    }

    class UF {
        private int count;  // 连通分量个数
        public int[] father;

        public UF(int n) {
            this.count = n;
            father = new int[n];
            for (int i = 0; i < n; ++i) {
                father[i] = i;
            }
        }

        // 并查集里寻根的过程
        public int find(int u) {
            if (u == father[u]) return u;
                // 路径压缩
            else return father[u] = find(father[u]);
        }

        // 判断 u 和 v是否找到同一个根
        public boolean isSame(int u, int v) {
            u = find(u);
            v = find(v);
            return u == v;
        }

        // 将v->u 这条边加入并查集
        public void join(int u, int v) {
            u = find(u); // 寻找u的根
            v = find(v); // 寻找v的根
            if (u == v) return; // 如果发现根相同，则说明在一个集合，不用两个节点相连直接返回
            father[v] = u;
            count--;  // 两个连通分量合并成一个连通分量
        }

        // 返回图中的连通分量个数
        public int count() {
            return count;
        }
    }
}
```



## 10.1.7 Dijkstra算法

**解决单元最短路径(无负权值)问题**

### Dijkstra算法模板

#### 1.朴素版O(n2)

```java
package base;

import java.util.Arrays;
import java.util.Scanner;

public class Dijkstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] grid = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(grid[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < m; i++) {
            int p1 = scanner.nextInt();
            int p2 = scanner.nextInt();
            int val = scanner.nextInt();
            grid[p1][p2] = val;
        }

        int start = 1;
        int end = n;

        // 存储从源点到每个节点的最短距离
        int[] minDist = new int[n + 1];
        Arrays.fill(minDist, Integer.MAX_VALUE);

        // 记录顶点是否被访问过
        boolean[] visited = new boolean[n + 1];

        minDist[start] = 0;  // 起始点到自身的距离为0

        for (int i = 1; i <= n; i++) { // 遍历所有节点

            int minVal = Integer.MAX_VALUE;
            int cur = 1;

            // 1、选距离源点最近且未访问过的节点
            for (int v = 1; v <= n; ++v) {
                if (!visited[v] && minDist[v] < minVal) {
                    minVal = minDist[v];
                    cur = v;
                }
            }

            visited[cur] = true;  // 2、标记该节点已被访问

            // 3、第三步，更新非访问节点到源点的距离（即更新minDist数组）
            for (int v = 1; v <= n; v++) {
                if (!visited[v] && grid[cur][v] != Integer.MAX_VALUE && minDist[cur] + grid[cur][v] < minDist[v]) {
                    minDist[v] = minDist[cur] + grid[cur][v];
                }
            }
        }

        if (minDist[end] == Integer.MAX_VALUE) {
            System.out.println(-1); // 不能到达终点
        } else {
            System.out.println(minDist[end]); // 到达终点最短路径
        }
    }
}
```

#### 2. 堆优化版

```java
public class Dijkstra {
    /**
     * Dijkstra 算法
     */


    class State {
        // 图节点的 id
        int id;
        // 从 start 节点到当前节点的距离
        int distFromStart;

        State(int id, int distFromStart) {
            this.id = id;
            this.distFromStart = distFromStart;
        }
    }

    // 输入一幅图和一个起点 start，计算 start 到其他节点的最短距离
    public int[] dijkstra(int start, List<int[]>[] graph) {
        // 图中节点的个数
        int V = graph.length;
        // 记录最短路径的权重，你可以理解为 dp table
        // 定义：distTo[i] 的值就是节点 start 到达节点 i 的最短路径权重
        int[] distTo = new int[V];
        // 求最小值，所以 dp table 初始化为正无穷
        Arrays.fill(distTo, Integer.MAX_VALUE);
        // base case，start 到 start 的最短距离就是 0
        distTo[start] = 0;

        // 优先级队列，distFromStart 较小的排在前面
        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> {
            return a.distFromStart - b.distFromStart;
        });

        // 从起点 start 开始进行 BFS
        pq.offer(new State(start, 0));

        while (!pq.isEmpty()) {
            State curState = pq.poll();
            int curNodeID = curState.id;
            int curDistFromStart = curState.distFromStart;

            if (curDistFromStart > distTo[curNodeID]) {
                // 已经有一条更短的路径到达 curNode 节点了
                continue;
            }
            // 将 curNode 的相邻节点装入队列
            for (int[] edge : graph[curNodeID]) {
                int nextNodeID = edge[0];
                int weight = edge[1];
                // 看看从 curNode 达到 nextNode 的距离是否会更短
                int distToNextNode = distTo[curNodeID] + weight;  //weight(curNodeID, nextNodeID);
                if (distTo[nextNodeID] > distToNextNode) {
                    // 更新 dp table
                    distTo[nextNodeID] = distToNextNode;
                    // 将这个节点以及距离放入队列
                    pq.offer(new State(nextNodeID, distToNextNode));
                }
            }
        }
        return distTo;
    }

}
```

## 10.1.8 Bellman_ford算法

### Bellman_ford算法模板

**解决单元最短路径(可有负权值)问题**

要求没有负权回路

```java
public class Bellman_ford {
    static class Edge {
        int src, dest, weight;
        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Edge> grid = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int weight = sc.nextInt();
            grid.add(new Edge(src, dest, weight));
        }

        int start = 1;
        int end = n;

        int[] minDist = new int[n+1];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[start] = 0;

        for (int i = 1; i < n; i++) { // 对所有边 松弛 n-1 次
            for (Edge edge : grid) { // 每一次松弛，都是对所有边进行松弛
                int src = edge.src;
                int dest = edge.dest;
                int weight = edge.weight;
                // 松弛操作
                // minDist[from] != INT_MAX 防止从未计算过的节点出发
                if (minDist[src] != Integer.MAX_VALUE && minDist[dest] > minDist[src] + weight) {
                    minDist[dest] = minDist[src] + weight;
                }
            }
        }
        if (minDist[end] == Integer.MAX_VALUE) {
            System.out.println("unconnected");
        } else {
            System.out.println(minDist[end]);
        }


    }
}
```

### 优化后的SPFA算法

**只需要对 上一次松弛的时候更新过的节点作为出发节点所连接的边 进行松弛就够了**。

基于以上思路，如何记录 上次松弛的时候更新过的节点呢？

用队列来记录。

```java
public class SPFA {
    static class Edge {
        int to;
        int val;
        public Edge(int to, int val) {
            this.to = to;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Edge>> graph = new ArrayList<>(n+1);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Edge>());
        }
        for (int i = 0; i < m; i++) {
            int form = sc.nextInt();
            int to = sc.nextInt();
            int val = sc.nextInt();
            graph.get(form).add(new Edge(to, val));
        }

        int start = 1;
        int end = n;

        int[] minDist = new int[n+1];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[start] = 0;

        Deque<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (Edge edge : graph.get(cur)) {
                int from = cur;
                int to = edge.to;
                int val = edge.val;
                if (minDist[to] > minDist[from] + val) {
                    minDist[to] = minDist[from] + val;
                    queue.add(to);
                }
            }
        }

        if (minDist[end] == Integer.MAX_VALUE) System.out.println("unconnected");
        else System.out.println(minDist[end]);

    }
}
```

### Bellman_ford判断负权回路

在 bellman_ford 算法中，松弛 n-1 次所有的边 就可以求得 起点到任何节点的最短路径，松弛 n 次以上，minDist数组（记录起到到其他节点的最短距离）中的结果也不会有改变

```java
public class Bellman_ford_isCycle {
    static class Edge {
        int src, dest, weight;
        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Edge> grid = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int weight = sc.nextInt();
            grid.add(new Edge(src, dest, weight));
        }

        int start = 1;
        int end = n;

        int[] minDist = new int[n+1];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[start] = 0;
        boolean flag = false;

        for (int i = 1; i <= n; i++) { // 对所有边 松弛 n-1 次
            for (Edge edge : grid) { // 每一次松弛，都是对所有边进行松弛
                int src = edge.src;
                int dest = edge.dest;
                int weight = edge.weight;
                // 松弛操作
                // minDist[from] != INT_MAX 防止从未计算过的节点出发
                if (i < n) {
                    if (minDist[src] != Integer.MAX_VALUE && minDist[dest] > minDist[src] + weight) {
                        minDist[dest] = minDist[src] + weight;
                    }
                } else { // 多加一次松弛判断负权回路
                    if (minDist[src] != Integer.MAX_VALUE && minDist[dest] > minDist[src] + weight) flag = true;
                }

            }
        }

        if (flag) System.out.println("has negative cycle");

        if (minDist[end] == Integer.MAX_VALUE) {
            System.out.println("unconnected");
        } else {
            System.out.println(minDist[end]);
        }


    }
}
```

### Bellman_ford之单源有限最短路

**起点最多经过k + 1 条边到达终点的最短距离。**

对所有边松弛一次，相当于计算 起点到达 与起点一条边相连的节点 的最短距离，那么对所有边松弛 k + 1次，就是求 起点到达 与起点k + 1条边相连的节点的 最短距离。

```java
public class Bellman_ford_limit {
    static class Edge {
        int src, dest, weight;
        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Edge> grid = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int weight = sc.nextInt();
            grid.add(new Edge(src, dest, weight));
        }

        int start = sc.nextInt();
        int end = sc.nextInt();
        int k = sc.nextInt();

        int[] minDist = new int[n+1];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[start] = 0;

        for (int i = 1; i <= k+1; i++) { // 对所有边 松弛 k+1 次
            for (Edge edge : grid) { // 每一次松弛，都是对所有边进行松弛
                int src = edge.src;
                int dest = edge.dest;
                int weight = edge.weight;
                // 松弛操作
                // minDist[from] != INT_MAX 防止从未计算过的节点出发
                if (minDist[src] != Integer.MAX_VALUE && minDist[dest] > minDist[src] + weight) {
                    minDist[dest] = minDist[src] + weight;
                }
            }
        }
        if (minDist[end] == Integer.MAX_VALUE) {
            System.out.println("unconnected");
        } else {
            System.out.println(minDist[end]);
        }


    }
}
```

## 10.1.9 Floyd算法

**多源最短路问题**

**Floyd 算法对边的权值正负没有要求，都可以处理**。

```java
public class Floyd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] graph = new int[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(graph[i], 10005);
        }

        for (int i = 0; i < m; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            int weight = scanner.nextInt();
            graph[from][to] = weight;
            graph[to][from] = weight;
        }
        
        // 开始 floyd
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        int num = scanner.nextInt();
        while (num-- > 0) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            if (graph[start][end] == 10005) System.out.println(-1);
            else System.out.println(graph[start][end]);
        }

    }
}
```

## 10.1.10 最短路问题总结

![](D:\Code\JavaProject\leetcode2024\leetcode2024.assets\Snipaste_2024-07-31_15-03-15.png)

### 场景选择：

**如果遇到单源且边为正数，直接Dijkstra**。

至于 **使用朴素版还是 堆优化版 还是取决于图的稠密度**， 多少节点多少边算是稠密图，多少算是稀疏图，这个没有量化，如果想量化只能写出两个版本然后做实验去测试，不同的判题机得出的结果还不太一样。

一般情况下，可以直接用堆优化版本。

**如果遇到单源边可为负数，直接 Bellman-Ford**，同样 SPFA 还是 Bellman-Ford 取决于图的稠密度。

一般情况下，直接用 SPFA。

**如果有负权回路，优先 Bellman-Ford**， 如果是有限节点最短路 也优先 Bellman-Ford，理由是写代码比较方便。

**如果是遇到多源点求最短路，直接 Floyd**。

除非 源点特别少，且边都是正数，那可以 多次 Dijkstra 求出最短路径，但这种情况很少，一般出现多个源点了，就是想让你用 Floyd 了。



## 10.2 重点题目及出错的题目等

### [200. 岛屿数量](https://leetcode.cn/problems/number-of-islands/)（模板题）

#### 深搜法

```java
int[][] dir = {
        {0,1},{1,0},{-1,0},{0,-1}
};
public int numIslands(char[][] grid) {
    int m  = grid.length;;
    int n = grid[0].length;
    boolean[][] visited = new boolean[m][n];
    int res = 0;
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (!visited[i][j] && grid[i][j] == '1') {
                visited[i][j] = true;
                res++;
                dfs(grid,visited,i,j);
            }
        }
    }
    return res;
}

private void dfs(char[][] grid, boolean[][] visited, int x, int y) {
    for (int i = 0; i < 4; i++) {
        int nextx = x + dir[i][0];
        int nexty = y + dir[i][1];
        if (nextx < 0 || nextx >= grid.length || nexty < 0 || nexty >= grid[0].length) continue;
        if (!visited[nextx][nexty] && grid[nextx][nexty] == '1') {
            visited[nextx][nexty] = true;
            dfs(grid, visited, nextx, nexty);
        }
    }
}
```

#### 广搜法

```java
int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

public int numIslands(char[][] grid) {
    int res = 0;
    boolean[][] visited = new boolean[grid.length][grid[0].length];
    for(int i = 0; i < grid.length; i++) {
        for(int j = 0; j < grid[0].length; j++) {
            if(!visited[i][j] && grid[i][j] == '1') {
                res++;
                bfs(grid,visited, i, j);
            }
        }
    }
    return res;
}

//将这片岛屿上的所有陆地都访问到
public void bfs(char[][] grid, boolean[][] visited, int x, int y) {
    Deque<int[]> queue = new LinkedList<>();
    queue.offer(new int[]{x, y});
    visited[x][y] = true;
    while(!queue.isEmpty()) {
        int[] cur = queue.poll();
        int curx = cur[0];
        int cury = cur[1];
        for(int i = 0; i < 4; i++) {
            int nextx = curx + dir[i][0];
            int nexty = cury + dir[i][1];
            if(nextx < 0 || nextx >= grid.length || nexty < 0 || nexty >= grid[0].length) continue;
            if(!visited[nextx][nexty] && grid[nextx][nexty] == '1') {
                queue.offer(new int[]{nextx, nexty});
                visited[nextx][nexty] = true; //只要加入队列就标记为访问
            }
        }
    }
}
```

### [7. 飞地的数量](https://programmercarl.com/1020.飞地的数量.html)

本题要求找到不靠边的陆地面积，那么我们只要从周边找到陆地然后 通过 dfs或者bfs 将周边靠陆地且相邻的陆地都变成海洋，然后再去重新遍历地图的时候，统计此时还剩下的陆地就可以了。

所以当我们遍历过程中就需要淹没陆地，即将`grid[i][j]=0;`

### [9. 太平洋大西洋水流问题](https://programmercarl.com/0417.太平洋大西洋水流问题.html)

从太平洋边上的节点 逆流而上，将遍历过的节点都标记上。 从大西洋的边上节点 逆流而长，将遍历过的节点也标记上。 然后两方都标记过的节点就是既可以流太平洋也可以流大西洋的节点。

```java
int[][] dir = {
        {0,1},{0,-1},{1,0},{-1,0}
};
public List<List<Integer>> pacificAtlantic(int[][] heights) {
    int m = heights.length;
    int n = heights[0].length;
    boolean[][] isPac = new boolean[m][n];
    boolean[][] isAtl = new boolean[m][n];
    List<List<Integer>> res = new ArrayList<>();

    for (int i = 0; i < m; i++) {
        dfs(heights,isPac,i,0);
        dfs(heights,isAtl,i,n-1);
    }
    for (int i = 0; i < n; i++) {
        dfs(heights,isPac,0,i);
        dfs(heights,isAtl,m-1,i);
    }

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (isPac[i][j] && isAtl[i][j]) res.add(List.of(i,j));
        }
    }
    return res;
}


private void dfs(int[][] height, boolean[][] visited, int x, int y) {
    if (visited[x][y]) return;
    visited[x][y] = true;

    for (int i = 0; i < 4; i++) {
        int nextx = x + dir[i][0];
        int nexty = y + dir[i][1];
        if (nextx < 0 || nextx >= height.length || nexty < 0 || nexty >= height[0].length) continue;
        if (height[x][y] > height[nextx][nexty]) continue;
        dfs(height,visited,nextx,nexty);
    }
}
```

### [10. 最大人工岛](https://programmercarl.com/0827.最大人工岛.html)

只要用一次深搜把每个岛屿的面积记录下来就好。

第一步：一次遍历地图，得出各个岛屿的面积，并做编号记录。可以使用map记录，key为岛屿编号，value为岛屿面积 第二步：在遍历地图，遍历0的方格（因为要将0变成1），并统计该1（由0变成的1）周边岛屿面积，将其相邻面积相加在一起，遍历所有 0 之后，就可以得出 选一个0变成1 之后的最大面积。

- 第一步：

![](D:\Code\JavaProject\leetcode2024\leetcode2024.assets\Snipaste_2024-03-13_14-55-47.png)

- 第二步：

![](D:\Code\JavaProject\leetcode2024\leetcode2024.assets\Snipaste_2024-03-13_14-56-28.png)

```java
int[][] dir = {
        {1,0},{-1,0},{0,1},{0,-1}
};
int count;
public int largestIsland(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    boolean[][] visited = new boolean[m][n];
    int mark = 2;
    boolean isAllGrid = true;
    HashMap<Integer,Integer> map = new HashMap<>();
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (grid[i][j] == 0) isAllGrid = false;
            if (!visited[i][j] && grid[i][j] == 1) {
                count = 1;
                visited[i][j] = true;
                grid[i][j] = mark;
                dfs(grid,visited,i,j,mark);
                map.put(mark,count);
                mark++;
            }
        }
    }

    if (isAllGrid) return m*n;

    int res = 0;
    HashSet<Integer> set = new HashSet<>();
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            int sum = 1;
            set.clear();
            if (grid[i][j] == 0) {
                for (int k = 0; k < 4; k++) {
                    int nextx = i + dir[k][0];
                    int nexty = j + dir[k][1];
                    if (nextx < 0 || nextx >= grid.length || nexty < 0 || nexty >= grid[0].length) continue;
                    if (map.containsKey(grid[nextx][nexty]) && !set.contains(grid[nextx][nexty])){
                        sum += map.get(grid[nextx][nexty]);
                        set.add(grid[nextx][nexty]);
                    }
                }
            }
            res = Math.max(res,sum);
        }
    }
    return res;
}


private void dfs(int[][] grid, boolean[][] visited, int x, int y, int mark){
    for (int i = 0; i < 4; i++) {
        int nextx = x + dir[i][0];
        int nexty = y + dir[i][1];
        if (nextx < 0 || nextx >= grid.length || nexty < 0 || nexty >= grid[0].length) continue;
        if (grid[nextx][nexty] == 1) {
            visited[nextx][nexty] = true;
            grid[nextx][nexty] = mark;
            count++;
            dfs(grid,visited,nextx,nexty,mark);
        }
    }
}
```

### [11. 单词接龙](https://programmercarl.com/0127.单词接龙.html)

本题只需要求出最短路径的长度就可以了，不用找出路径。

![](D:\Code\JavaProject\leetcode2024\leetcode2024.assets\Snipaste_2024-03-13_15-41-51.png)

所以这道题要解决两个问题：

- 图中的线是如何连在一起的
- 起点和终点的最短路径长度

首先题目中并没有给出点与点之间的连线，而是要我们自己去连，条件是字符只能差一个，所以判断点与点之间的关系，要自己判断是不是差一个字符，如果差一个字符，那就是有链接。

然后就是求起点和终点的最短路径长度，**这里无向图求最短路，广搜最为合适，广搜只要搜到了终点，那么一定是最短的路径**。因为广搜就是以起点中心向四周扩散的搜索。

另外需要有一个注意点：

- 本题是一个无向图，需要用标记位，标记着节点是否走过，否则就会死循环！
- 本题给出集合是数组型的，可以转成set结构，查找更快一些

```java
public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    HashSet<String> wordSet = new HashSet<>(wordList); //转换为hashset 加快速度
    if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
        return 0;
    }

    Deque<String> deque = new LinkedList<>();
    HashMap<String, Integer> map = new HashMap<>();
    deque.offer(beginWord);
    map.put(beginWord,1);
    while (!deque.isEmpty()) {
        String word = deque.poll();
        int path = map.get(word);
        for (int i = 0; i < word.length(); i++) {
            char[] words = word.toCharArray();
            for (char k = 'a'; k <= 'z'; k++) {
                words[i] = k;
                String newWord = new String(words);
                if (newWord.equals(endWord)) return path+1;
                if (!wordSet.contains(newWord) || map.containsKey(newWord)) continue;
                map.put(newWord,path+1);
                deque.offer(newWord);
            }
        }

    }
    return 0;
}
```

### [17. 冗余连接II](https://programmercarl.com/0685.冗余连接II.html)

那么有如下三种情况，前两种情况是出现入度为2的点，如图：

![](D:\Code\JavaProject\leetcode2024\leetcode2024.assets\Snipaste_2024-03-13_20-44-06.png)

对于情况1和情况2需要先统计入度为2点节点的边，然后再判断删除后是否是一棵树（即如果连通说明不是），之后决定删除哪个边。

第三种情况是没有入度为2的点，那么图中一定出现了有向环（**注意这里强调是有向环！**）

![](D:\Code\JavaProject\leetcode2024\leetcode2024.assets\Snipaste_2024-03-13_20-45-58.png)

```java
int[] father = new int[1001];

private void init() {
    for (int i = 0; i < father.length; i++) {
        father[i] = i;
    }
}

private int find(int u) {
    if (u == father[u]) return u;
    else return father[u] = find(father[u]);
}

private boolean isSame(int u, int v) {
    u = find(u);
    v = find(v);
    return u == v;
}

private void join(int u, int v) {
    u = find(u);
    v = find(v);
    if (u == v) return;
    father[v] = u;
}

public int[] findRedundantDirectedConnection(int[][] edges) {
    int[] inDegree = new int[1001];
    for (int i = 0; i < edges.length; i++) {
        inDegree[edges[i][1]]++;
    }

    List<Integer> list = new ArrayList<>();
    for (int i = edges.length-1; i >= 0; i--) {
        if (inDegree[edges[i][1]] == 2) {
            list.add(i);  //记录当前入度为2的节点
        }
    }

    if (list.size() > 0) {
        if (isTreeAfterRemoveEdge(edges,list.get(0))) {
            return edges[list.get(0)];
        } else {
            return edges[list.get(1)];
        }
    }

    return getRemoveEdge(edges);
}

private boolean isTreeAfterRemoveEdge(int[][] edges, Integer deleteEdge) {
    init();
    for (int i = 0; i < edges.length; i++) {
        if (i == deleteEdge) continue;
        if (isSame(edges[i][0],edges[i][1])) {
            return false;
        }else {
            join(edges[i][0],edges[i][1]);
        }
    }
    return true;
}

private int[] getRemoveEdge(int[][] edges) {
    init();
    for (int i = 0; i < edges.length; i++) {
        if (isSame(edges[i][0], edges[i][1])) {
            return edges[i];
        } else {
            join(edges[i][0], edges[i][1]);
        }
    }
    return new int[]{};
}
```

# 11.  贪心

## 11.1 做题总结与技巧

### 重叠区间问题

**首先要确定一个维度，之后排序后再去根据另一个维度进行判断。[14. 根据身高重建队列](https://programmercarl.com/0406.根据身高重建队列.html)**

[17. 用最少数量的箭引爆气球](https://programmercarl.com/0452.用最少数量的箭引爆气球.html)

[18. 无重叠区间](https://programmercarl.com/0435.无重叠区间.html)

[19. 划分字母区间](https://programmercarl.com/0763.划分字母区间.html)

[20. 合并区间](https://programmercarl.com/0056.合并区间.html)

### [贪心算法总结篇](https://programmercarl.com/贪心算法总结篇.html)

## 11.2  重点题目及出错的题目等

### [3. 摆动序列](https://programmercarl.com/0376.摆动序列.html)

找两个峰值，一个山谷，一个山顶。

在计算是否有峰值的时候，大家知道遍历的下标 i ，计算 prediff（nums[i] - nums[i-1]） 和 curdiff（nums[i+1] - nums[i]），如果`prediff < 0 && curdiff > 0` 或者 `prediff > 0 && curdiff < 0` 此时就有波动就需要统计。

这是我们思考本题的一个大题思路，但本题要考虑三种情况：

- 情况一：上下坡中有平坡

所以我们记录峰值的条件应该是： `(preDiff <= 0 && curDiff > 0) || (preDiff >= 0 && curDiff < 0)`，为什么这里允许 prediff == 0 ，就是为了 上面我说的这种情况。

- 情况二：数组首尾两端

result 初始为 1（默认最右面有一个峰值）

- 情况三：单调坡中有平坡

我们只需要在 这个坡度 摆动变化的时候，更新 prediff 就行，这样 prediff 在 单调区间有平坡的时候 就不会发生变化，造成我们的误判。

```java
public int wiggleMaxLength(int[] nums) {
    if (nums.length <= 1) return nums.length;
    int pre = 0;
    int cur = 0;
    int ans = 1;
    for (int i = 0; i < nums.length - 1; i++) {
        cur = nums[i+1] - nums[i];
        if ((pre <= 0 && cur > 0) || (pre >= 0 && cur < 0)) {
            ans++;
            pre = cur; // 注意这里，只在摆动变化的时候更新pre
        }
    }
    return ans;
}
```

### [7. 跳跃游戏](https://programmercarl.com/0055.跳跃游戏.html)

考虑**可以跳跃的覆盖范围。**

![](D:\Code\JavaProject\leetcode2024\leetcode2024.assets\Snipaste_2024-03-14_09-07-49.png)

i 每次移动只能在 cover 的范围内移动，每移动一个元素，cover 得到该元素数值（新的覆盖范围）的补充，让 i 继续移动下去。

而 cover 每次只取 max(该元素数值补充后的范围, cover 本身范围)。

如果 cover 大于等于了终点下标，直接 return true 就可以了。

### [8. 跳跃游戏II](https://programmercarl.com/0045.跳跃游戏II.html)

理解本题的关键在于：**以最小的步数增加最大的覆盖范围，直到覆盖范围覆盖了终点**，这个范围内最少步数一定可以跳到，不用管具体是怎么跳的，不纠结于一步究竟跳一个单位还是两个单位。

**这里需要统计两个覆盖范围，当前这一步的最大覆盖和下一步最大覆盖**。

移动下标达到了当前覆盖的最远距离下标时，步数就要加一，来增加覆盖距离。最后的步数就是最少步数。

这里还是有个特殊情况需要考虑，当移动下标达到了当前覆盖的最远距离下标时

- 如果当前覆盖最远距离下标不是是集合终点，步数就加一，还需要继续走。
- 如果当前覆盖最远距离下标就是是集合终点，步数不用加一，因为不能再往后走了。

```java
public int jump(int[] nums) {
    if (nums.length == 1) return 0;
    int curDistance = 0;
    int nextDistance = 0;
    int ans = 0;

    for (int i = 0; i < nums.length; i++) {
        nextDistance = Math.max(nextDistance,i+nums[i]);
        if (curDistance == i){
            ans++;
            curDistance = nextDistance;
            if (curDistance >= nums.length - 1) break;
        }
    }

    return ans;
}
```

### [11. 加油站](https://programmercarl.com/0134.加油站.html)

首先如果总油量减去总消耗大于等于零那么一定可以跑完一圈，说明 各个站点的加油站 剩油量rest[i]相加一定是大于等于零的。

每个加油站的剩余量rest[i]为gas[i] - cost[i]。

i从0开始累加rest[i]，和记为curSum，一旦curSum小于零，说明[0, i]区间都不能作为起始位置，因为这个区间选择任何一个位置作为起点，到i这里都会断油，那么起始位置从i+1算起，再从0计算curSum。

**那么局部最优：当前累加rest[i]的和curSum一旦小于0，起始位置至少要是i+1，因为从i之前开始一定不行。全局最优：找到可以跑一圈的起始位置**。

### [12. 分发糖果](https://programmercarl.com/0135.分发糖果.html)

这在leetcode上是一道困难的题目，其难点就在于贪心的策略，如果在考虑局部的时候想两边兼顾，就会顾此失彼。

那么本题我采用了两次贪心的策略：

- 一次是从左到右遍历，只比较右边孩子评分比左边大的情况。
- 一次是从右到左遍历，只比较左边孩子评分比右边大的情况。

这样从局部最优推出了全局最优，即：相邻的孩子中，评分高的孩子获得更多的糖果。

**candyVec[i]只有取最大的才能既保持对左边candyVec[i - 1]的糖果多，也比右边candyVec[i + 1]的糖果多**。

```java
public int candy(int[] ratings) {
    int[] candyVec = new int[ratings.length];
    Arrays.fill(candyVec,1);
    for (int i = 1; i < ratings.length; i++) {
        if (ratings[i] > ratings[i-1]) candyVec[i] = candyVec[i-1] + 1;
    }
    for (int i = ratings.length - 2;  i >= 0; i--) {
        if (ratings[i] > ratings[i+1]) {
            candyVec[i] = Math.max(candyVec[i],candyVec[i+1]+1);
        }
    }
    return Arrays.stream(candyVec).sum();
}
```

### [14. 根据身高重建队列](https://programmercarl.com/0406.根据身高重建队列.html)

**如果两个维度一起考虑一定会顾此失彼**。

如果按照k来从小到大排序，排完之后，会发现k的排列并不符合条件，身高也不符合条件，两个维度哪一个都没确定下来。

那么按照身高h来排序呢，身高一定是从大到小排（身高相同的话则k小的站前面），让高个子在前面。

**此时我们可以确定一个维度了，就是身高，前面的节点一定都比本节点高！**

只需要按照k为下标重新插入队列就可以了。

![](D:\Code\JavaProject\leetcode2024\leetcode2024.assets\Snipaste_2024-03-14_11-10-15.png)

此外，插入的时候可以选择LinkedList，其中的list.add(index,elemrnt)插入元素很便捷。

```java
public int[][] reconstructQueue(int[][] people) {
    Arrays.sort(people,(o1, o2) -> {
        if (o1[0] == o2[0]) {
            return o1[1] - o2[1];
        }
        return o2[0] - o1[0];
    });
    LinkedList<int[]> list = new LinkedList<>();
    for (int[] person : people) {
        list.add(person[1],person);
    }
    return list.toArray(new int[people.length][]);
}
```

### [18. 无重叠区间](https://programmercarl.com/0435.无重叠区间.html)

主要就是为了让区间尽可能的重叠。

**我来按照右边界排序，从左向右记录非交叉区间的个数。最后用区间总数减去非交叉区间的个数就是需要移除的区间个数了**。

此时问题就是要求非交叉区间的最大个数。

```java
public int eraseOverlapIntervals(int[][] intervals) {
    if (intervals.length == 1) return 0;
    Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[1],o2[1]));

    int count = 1;
    int end = intervals[0][1];
    for (int i = 1; i < intervals.length; i++) {
        if (end <= intervals[i][0]) {
            end = intervals[i][1];
            count++;
        }
    }
    return intervals.length - count;
}
```

### [19. 划分字母区间](https://programmercarl.com/0763.划分字母区间.html)

在遍历的过程中相当于是要找每一个字母的边界，**如果找到之前遍历过的所有字母的最远边界，说明这个边界就是分割点了**。此时前面出现过所有字母，最远也就到这个边界了。

可以分为如下两步：

- 统计每一个字符最后出现的位置
- 从头遍历字符，并更新字符的最远出现下标，如果找到字符最远出现位置下标和当前下标相等了，则找到了分割点

```java
public List<Integer> partitionLabels(String s) {
    List<Integer> ans = new ArrayList<>();
    int[] hash = new int[26];
    //统计每个字符最后出现的位置
    for (int i = 0; i < s.length(); i++) {
        hash[s.charAt(i) - 'a'] = i;
    }
    int left = 0;
    int right = 0;
    for (int i = 0; i < s.length(); i++) {
        right = Math.max(right, hash[s.charAt(i) - 'a']);
        //如果找到字符最远出现位置下标和当前下标相等了，则找到了分割点
        if (i == right) {
            ans.add(right - left + 1);
            left = i+1;
        }
    }
    return ans;
}
```

### [20. 合并区间](https://programmercarl.com/0056.合并区间.html)

按照左边界从小到大排序之后，如果 `intervals[i][0] <= intervals[i - 1][1]` 即intervals[i]的左边界 <= intervals[i - 1]的右边界，则一定有重叠。（本题相邻区间也算重贴，所以是<=）

其实就是用合并区间后左边界和右边界，作为一个新的区间，加入到result数组里就可以了。如果没有合并就把原区间加入到result数组。

```java
public static int[][] merge(int[][] intervals) {
    Arrays.sort(intervals,(o1, o2) -> Integer.compare(o1[0],o2[0]));
    LinkedList<int[]> list = new LinkedList<>();
    list.add(intervals[0]);

    for (int i = 1; i < intervals.length; i++) {
        if (intervals[i][0] <= list.getLast()[1]) {
            list.getLast()[1] = Math.max(list.getLast()[1],intervals[i][1]);
        } else {
            list.add(intervals[i]);
        }
    }

    return list.toArray(new int[list.size()][]);
}
```

### [23. 监控二叉树](https://programmercarl.com/0968.监控二叉树.html)

**所以我们要从下往上看，局部最优：让叶子节点的父节点安摄像头，所用摄像头最少，整体最优：全部摄像头数量所用最少！**

此时这道题目还有两个难点：

- 二叉树的遍历

要从叶子节点向根遍历，需要后序遍历

- 如何隔两个节点放一个摄像头

在后序遍历过程中返回值来表示当前节点的状态，有以下三种：

- 0：该节点无覆盖
- 1：本节点有摄像头
- 2：本节点有覆盖

其中空节点设置为2有覆盖状态，防止叶子节点占用摄像头。

```java
if (node == null) return 2;
```

主要有如下四类情况：

- 情况1：左右节点都有覆盖

```java
if (left == 2 && right == 2) return 0;
```

- 情况2：左右节点至少有一个无覆盖的情况

```java
if (left == 0 || right == 0) {
    ans++;
    return 1;
}
```

- 情况3：左右节点至少有一个有摄像头

```java
if (left == 1 || right == 1) {
    return 2;
}
```

- 情况4：头结点没有覆盖

递归结束后要判断是否头结点有没有覆盖。

```java
if (traversal(root) == 0) {
    ans++;
}
```

完整代码：

```java
/**
 * 0：该节点无覆盖
 * 1：本节点有摄像头
 * 2：本节点有覆盖
 */
int ans = 0;
public int minCameraCover(utils.TreeNode root) {
    if (root == null) return 0;
    if (traversal(root) == 0) {
        ans++;
    }
    return ans;
}
private int traversal(utils.TreeNode node) {
    if (node == null) return 2;
    int left = traversal(node.left);
    int right = traversal(node.right);

    if (left == 2 && right == 2) return 0;
    if (left == 0 || right == 0) {
        ans++;
        return 1;
    }
    if (left == 1 || right == 1) {
        return 2;
    }
    return -1;
}
```

### [贪心：Dota2参议院](https://programmercarl.com/0649.Dota2参议院.html)

**其实这是一个持续消灭的过程！** 即：如果同时存在R和D就继续进行下一轮消灭，轮数直到只剩下R或者D为止！

**所以消灭的策略是，尽量消灭自己后面的对手，因为前面的对手已经使用过权利了，而后序的对手依然可以使用权利消灭自己的同伴！**

实现代码，在每一轮循环的过程中，去过模拟优先消灭身后的对手，其实是比较麻烦的。

**这里有一个技巧，就是用一个变量记录当前参议员之前有几个敌对对手了，进而判断自己是否被消灭了。这个变量我用flag来表示。**

```java
public String predictPartyVictory(String senate) {
    char[] chars = senate.toCharArray();
    boolean R = true;  //是否还存在R
    boolean D = true;   //是否还存在D

    int flag = 0;

    while (R && D) {   //轮次
        R = false;
        D = false;
        for (int i = 0; i < chars.length; i++) {  //单轮逻辑
            if (chars[i] == 'R') {
                if (flag < 0) chars[i] = 0;
                else R = true;
                flag++;
            }
            if (chars[i] == 'D') {
                if (flag > 0) chars[i] = 0;
                else D = true;
                flag--;
            }
        }
    }

    return R == true ? "Radiant" : "Dire";
}
```





# 12. Other

## 前缀和

https://blog.csdn.net/fuxuemingzhu/article/details/120132922

**总之，如果题目要求「区间和」的时候，那么就可以考虑使用「前缀和」。**

### 模板题：[304. 二维区域和检索 - 矩阵不可变](https://leetcode.cn/problems/range-sum-query-2d-immutable/)

#### 二维前缀和模板

```java
class NumMatrix {

    private int[][] preSum;

    public NumMatrix(int[][] matrix) {
        preSum = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
           for (int j = 0; j < matrix[0].length; j++) {
               preSum[i+1][j+1] = preSum[i][j+1] + preSum[i+1][j] - preSum[i][j] + matrix[i][j];
           }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSum[row2 + 1][col2 + 1] - preSum[row2 + 1][col1] - preSum[row1][col2 + 1] + preSum[row1][col1];
    }
}
```

#### 一维前缀和模板

```java
class NumMatrix {
	private int[] preSum;

	public NumMatrix(int[] matrix) {
       	preSum = new int[matrix.length + 1];
        for (int i = 0; i < matrix.length; i++) {
             preSum[i+1] = preSum[i] + matrix[i];
        }
    }
    
	public int sumRegion(int i, int j) {
    	return preSum[j+1] - preSum[i];
	}
}
```
## 12.2  其它题目

### [模拟：下一个排列](https://programmercarl.com/0031.下一个排列.html)

![](D:\Code\JavaProject\leetcode2024\leetcode2024.assets\Snipaste_2024-03-15_15-30-19.png)

```java
public void nextPermutation(int[] nums) {
    for (int i = nums.length - 1; i >= 0; i--) {
        for (int j = nums.length - 1; j > i ; j--) {
            if (nums[j] > nums[i]) {
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
                Arrays.sort(nums,i+1,nums.length);
                return;
            }
        }
    }
    Arrays.sort(nums); // 不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
}
```

### [位运算：根据数字二进制下1的数目排序](https://programmercarl.com/1356.根据数字二进制下1的数目排序.html)

通过n&(n-1)可以清除最低位的1，从而计算出包含多少个1。

```java
public int[] sortByBits(int[] arr) {
    return Arrays.stream(arr).boxed().sorted(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            int count1 = CalBit(o1);
            int count2 = CalBit(o2);
            if (count1 == count2) return Integer.compare(o1,o2);
            return Integer.compare(count1,count2);
        }
    }).mapToInt(Integer::intValue).toArray();
}
private int CalBit(int n) {
    int count = 0;
    if (n == 0) return count;

    while (n != 0) {
        n &= (n-1);  //清除最低位的1
        count++;
    }
    return count;
}
```

### 名流问题

#### 问题描述：

给你 `n` 个人的社交关系（你知道任意两个人之间是否认识），然后请你找出这些人中的「名人」。

所谓「名人」有两个条件：

1、所有其他人都认识「名人」。

2、「名人」不认识任何其他人。

#### 解决：

**我们可以不断从候选人中选两个出来，然后排除掉一个，直到最后只剩下一个候选人，这时候再使用一个 for 循环判断这个候选人是否是货真价实的「名人」**。

```java
int findCelebrity(int n) {
    // 先假设 cand 是名人
    int cand = 0;
    for (int other = 1; other < n; other++) {
        if (!knows(other, cand) || knows(cand, other)) {
            // cand 不可能是名人，排除
            // 假设 other 是名人
            cand = other;
        } else {
            // other 不可能是名人，排除
            // 什么都不用做，继续假设 cand 是名人
        }
    }

    // 现在的 cand 是排除的最后结果，但不能保证一定是名人
    for (int other = 0; other < n; other++) {
        if (cand == other) continue;
        // 需要保证其他人都认识 cand，且 cand 不认识任何其他人
        if (!knows(other, cand) || knows(cand, other)) {
            return -1;
        }
    }

    return cand;
}
```

## 二分答案进行搜索(华为0124 code2)

## 树状数组(华为0124 code3)

```java
static class BIT {
    int[] trees;

    public BIT(int n) {
        trees = new int[n + 1];
    }

    public void update(int index, int val) {
        int i = index + 1;
        while (i < trees.length) {
            trees[i] += val;
            i += i & -i;
        }
    }

    public int query(int x) {
        int cnt = 0;
        while (x > 0) {
            cnt += trees[x];
            x -= x & -x;
        }
        return cnt;
    }

    public int queryRange(int left, int right) {
        return query(right + 1) - query(left);
    }
}
```



# 13. Hot100 

## [128. 最长连续序列](https://leetcode.cn/problems/longest-consecutive-sequence/)

```java
/**
 * 使用哈希表去重
 * 找到没有num-1的，这就说明找到了连续数中的最小值
 * 然后+1往大找连续数的个数
 * @param nums
 * @return
 */
public int longestConsecutive(int[] nums) {
    if (nums.length == 0) return 0;
    HashSet<Integer> set = new HashSet<>();
    for (int num : nums) {
        set.add(num);
    }
    int ans = 1;
    for (Integer integer : set) {
        if (!set.contains(integer-1)) {
            int curNum = integer;
            int len = 1;
            while (set.contains(curNum+1)) {
                curNum++;
                len++;
            }
            ans = Math.max(ans,len);
        }
    }
    return ans;
}
```

## [11. 盛最多水的容器](https://leetcode.cn/problems/container-with-most-water/)

```java
/**
 * 双指针
 * 每轮都计算
 * 哪边小就移动
 * @param height
 * @return
 */
public int maxArea(int[] height) {
    int left = 0;
    int right = height.length - 1;
    int ans = 0;
    while (left < right) {
        int hei = Math.min(height[left],height[right]);
        int len = right - left;
        ans = Math.max(ans,hei * len);
        if (height[left] < height[right]) {
            left++;
        } else {
            right--;
        }
    }
    return ans;
}
```

## [560. 和为 K 的子数组](https://leetcode.cn/problems/subarray-sum-equals-k/)

```java
/**
 * 前缀和+哈希表
 * 说实话没太懂
 * @param nums
 * @param k
 * @return
 */
public int subarraySum(int[] nums, int k) {
    HashMap<Integer,Integer> map = new HashMap<>();
    int ans = 0;
    int pre = 0;
    map.put(0,1);
    for (int i = 0; i < nums.length; i++) {
        pre += nums[i];
        if (map.containsKey(pre - k)) {
            ans += map.get(pre - k);
        }
        map.put(pre, map.getOrDefault(pre,0)+1);
    }
    return ans;
}
```

## [41. 缺失的第一个正数](https://leetcode.cn/problems/first-missing-positive/)

置换，将符合1-n的正数都换到他们对应的位置，然后判断位置上不等于的就是缺失的第一个正数。

```java
public static int firstMissingPositive(int[] nums) {
    int len = nums.length;
    for (int i = 0; i < nums.length; i++) {
        while (nums[i] > 0 && nums[i] <= len && nums[nums[i]-1] != nums[i]) {
            int tmp = nums[nums[i]-1];
            nums[nums[i]-1] = nums[i];
            nums[i] = tmp;
        }
    }

    for (int i = 0; i < len; i++) {
        if (nums[i] != i+1) {
            return i+1;
        }
    }
    return len+1;
}
```

## [48. 旋转图像](https://leetcode.cn/problems/rotate-image/)

先按中心线对折，再按对角线交换

```java
public static void rotate(int[][] matrix) {
    int len = matrix.length;

    int left = 0;
    int right = len - 1;
    while (left < right) {
        for (int i = 0; i < len; i++) {
            int tmp = matrix[i][left];
            matrix[i][left] = matrix[i][right];
            matrix[i][right] = tmp;
        }
        left++;
        right--;
    }

    int lenCol = len - 2;
    for (int i = 0; i <= len - 2; i++) {
        for (int j = 0; j <= lenCol; j++) {
            int tmp = matrix[i][j];
            matrix[i][j] = matrix[len - j - 1][len - i -1];
            matrix[len - j -1][len - i - 1] = tmp;
        }
        lenCol--;
    }
}
```

## [240. 搜索二维矩阵 II](https://leetcode.cn/problems/search-a-2d-matrix-ii/)

二分查找类型

从右边和上边开始找，如果target大，那就往下找，如果target小，那就往左找。

```java
public static boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length;
    int n = matrix[0].length;

    for (int i = 0; i < m; i++) {
        int num = BinFind(matrix[i],target);
        if (num < 0) {
            return false;
        }
        if (matrix[i][num] == target) return true;
    }

    return false;
}

private static int BinFind(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (target == nums[mid]) {
            return mid;
        } else if (target > nums[mid]) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return right;
}
```

```java
public boolean searchMatrix2(int[][] matrix, int target) {
    int m = matrix.length, n = matrix[0].length;
    int x = 0, y = n - 1;
    while (x < m && y >= 0) {
        if (matrix[x][y] == target) {
            return true;
        }
        if (matrix[x][y] > target) {
            --y;
        } else {
            ++x;
        }
    }
    return false;
}
```

## [21. 合并两个有序链表](https://leetcode.cn/problems/merge-two-sorted-lists/)

方法一：递归，如果list1.val大的时候，就拿list2.val的做头，然后用list2.next和list1.val进行递归构建。

方法二：创建一个新的链表头，每次都next两者小的那个。

## [25. K 个一组翻转链表](https://leetcode.cn/problems/reverse-nodes-in-k-group/)

```java
public ListNode reverseKGroup(ListNode head, int k) {
    ListNode dummy = new ListNode(0);       // 此处只是设置一个哨兵节点
    dummy.next = head;      // 哨兵节点的下一个指向首节点

    ListNode pre = dummy;       // 上一段的最后一个节点 节点初始化
    ListNode end = dummy;       // 本段最后一个节点

    while (end.next != null) {
        // 此处是为了找到其中的 k 个子节点
        for(int i = 0 ; i < k && end != null; i++){
            end = end.next;
        }

        if(end == null){        // 如果直接到头了，那就说明没有满足 k 个
            break;
        }

        ListNode start = pre.next;           // 此处是为记录原始未反转段的起始节点
        ListNode nextStart = end.next;       // 记录下一个阶段  起始点

        end.next = null;                // 此处是为了进行后面的反转操作，断开此处链接,让后面反转操作知道截断点在哪里
        pre.next = reverse(start);      // 反转操作

        start.next = nextStart;         // 反转之后，start节点实际是已经最后一个节点了，为了和后面的划分段链接，让他的下一个节点连接上下一段的起始点即可
        pre = start;                    // pre再次来到下一段的上一个节点，也就是本段的结尾点
        end = pre;                      // 结束点，准备开始下一段的循环找 k 长度的段操作

    }

    return dummy.next;           // 返回最开始的哨兵
}

private ListNode reverse(ListNode head) {
    ListNode pre = null;
    ListNode curr = head;

    while (curr != null) {        // 交换操作
        ListNode next = curr.next;
        curr.next = pre;
        pre = curr;
        curr = next;
    }

    return pre;     // 返回哨兵，此处是新的翻转序列的起始节点
}
```

## [138. 随机链表的复制](https://leetcode.cn/problems/copy-list-with-random-pointer/)

我们用哈希表记录每一个节点对应新节点的创建情况。遍历该链表的过程中，我们检查「当前节点的后继节点」和「当前节点的随机指针指向的节点」的创建情况。如果这两个节点中的任何一个节点的新节点没有被创建，我们都立刻递归地进行创建。当我们拷贝完成，回溯到当前层时，我们即可完成当前节点的指针赋值。注意一个节点可能被多个其他节点指向，因此我们可能递归地多次尝试拷贝某个节点，为了防止重复拷贝，我们需要首先检查当前节点是否被拷贝过，如果已经拷贝过，我们可以直接从哈希表中取出拷贝后的节点的指针并返回即可。

```java
HashMap<Node,Node> map = new HashMap<>();
public Node copyRandomList(Node head) {

    if (head == null) return head;

    // 先进行当前节点的拷贝，在进行next的拷贝，之后现在所有节点都拷贝完了，就可以连接random节点了。
    if (!map.containsKey(head)) {
        Node headNew = new Node(head.val);   //当前节点的拷贝
        map.put(head,headNew);  //用来记录已经拷贝的节点，在random拷贝时可以找到对应的节点
        headNew.next = copyRandomList(head.next);  //next的拷贝
        headNew.random = copyRandomList(head.random);  //random的拷贝
    }

    return map.get(head);
}
```

## [148. 排序链表](https://leetcode.cn/problems/sort-list/)

**进阶：**你可以在 `O(n log n)` 时间复杂度和常数级空间复杂度下，对链表进行排序吗？

需要用到**归并排序**的思想。

```java
/**
 * 归并排序
 * @param head
 * @return
 */
public ListNode sortList2(ListNode head) {
    if (head == null || head.next == null) {
        return head;
    }

    ListNode midNode = middleNode(head);  //左面
    ListNode rightHead = midNode.next;  //右面
    midNode.next = null;  //断链

    ListNode left = sortList2(head);
    ListNode right = sortList2(rightHead);

    return mergeTwoLists(left,right);  //合并
}

//  合并两个有序链表（21. 合并两个有序链表）
private ListNode mergeTwoLists(ListNode left, ListNode right) {
    if (left == null) return right;
    if (right == null) return left;

    ListNode dummy = new ListNode();
    ListNode cur = dummy;
    while (left != null && right != null) {
        if (left.val > right.val) {
            cur.next = right;
            right = right.next;
        } else {
            cur.next = left;
            left = left.next;
        }
        cur = cur.next;
    }

    cur.next = left != null ? left : right;

    return dummy.next;
}

// 找到链表中间节点（876. 链表的中间结点）
private ListNode middleNode(ListNode head) {
    if (head == null || head.next == null) {
        return head;
    }

    ListNode slow = head;
    ListNode fast = head.next.next;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    return slow;
}
```

## [23. 合并 K 个升序链表](https://leetcode.cn/problems/merge-k-sorted-lists/)(ac)

也是采用归并排序的思想。使用K路归并，从而两两递归合并。

```java
public ListNode mergeKLists(ListNode[] lists) {
    return mergeK(lists);
}

private ListNode mergeK(ListNode[] lists) {
    if (lists.length == 0) return null;
    // 当列表只剩下一个数组或为空时，直接返回
    if (lists.length == 1) {
        return lists[0];
    }

    // 递归地将数组列表分为两部分并合并
    int mid = lists.length / 2;
    ListNode[] left = Arrays.copyOfRange(lists,0,mid);
    ListNode[] right = Arrays.copyOfRange(lists,mid,lists.length);

    ListNode leftMerged = mergeK(left);
    ListNode rightMerged = mergeK(right);

    // 合并两个已排序的数组
    return mergeTwoLists(leftMerged, rightMerged);
}


private ListNode mergeTwoLists(ListNode left, ListNode right) {
    if (left == null) return right;
    if (right == null) return left;

    ListNode dummy = new ListNode();
    ListNode cur = dummy;
    while (left != null && right != null) {
        if (left.val > right.val) {
            cur.next = right;
            right = right.next;
        } else {
            cur.next = left;
            left = left.next;
        }
        cur = cur.next;
    }

    cur.next = left != null ? left : right;

    return dummy.next;
}
```

## [146. LRU 缓存](https://leetcode.cn/problems/lru-cache/)

`LinkedHashMap`可以实现LRU缓存。

```java
super(capacity,0.75f,true);
// 容量、加载因子、是否读取顺序排序
```

只要复写` removeEldestEntry()`函数，就能拥有我们自己的缓存策略！

## [543. 二叉树的直径](https://leetcode.cn/problems/diameter-of-binary-tree/)

与[9. 二叉树的最大深度](https://programmercarl.com/0104.二叉树的最大深度.html)有相似的思路

```
* 因为需要返回参与的节点数所以需要后序遍历
* 单层逻辑：到中间节点的时候需要就算该根节点左面到右面的最大长度
* 返回值：因为过了该中间节点只能选左右的一边，所以选更大的一面
```

```java
int res = 1;  //表示参与的节点数
public int diameterOfBinaryTree(utils.TreeNode root) {
    if (root == null) return 0;
    traversal(root);
    return res - 1;
}

/**
 * 因为需要返回参与的节点数所以需要后序遍历
 * 单层逻辑：到中间节点的时候需要就算该根节点左面到右面的最大长度
 * 返回值：因为过了该中间节点只能选左右的一边，所以选更大的一面
 * @param root
 * @return
 */
private int traversal(utils.TreeNode root) {
    if (root == null) return 0;

    int left = traversal(root.left);
    int right = traversal(root.right);

    int len = 1 + Math.max(left,right);
    res = Math.max(res, left + right + 1);
    return len;
}
```

## [124. 二叉树中的最大路径和](https://leetcode.cn/problems/binary-tree-maximum-path-sum/)(ac)

和[543. 二叉树的直径](https://leetcode.cn/problems/diameter-of-binary-tree/)直径基本相同的思想

```java
int max = Integer.MIN_VALUE;
public int maxPathSum(utils.TreeNode root) {
    if (root == null) return 0;
    traversal(root);
    return max;
}

/**
 * 后序遍历
 * 求出左右节点的最大值
 * 如果加上当前节点元素进行判断max
 * 返回上层的是当前节点+左右节点的最大值
 * @param node
 * @return
 */
private int traversal(utils.TreeNode node) {
    if(node == null) return 0;


    int left = Math.max(traversal(node.left),0);
    int right = Math.max(traversal(node.right),0);

    int sum = node.val + left + right;
    max = Math.max(max,sum);
    return node.val + Math.max(left,right);
}
```

## [114. 二叉树展开为链表](https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/)

```java
/**
 * 找到当前节点左子树的最右节点，然后将当前节点右子树跟在最右节点后面，
 * 之后把左子树放到右子树的位置，
 * 之后处理下一个节点
 * @param root
 */
public void flatten(utils.TreeNode root) {
    while (root != null) {
        if (root.left == null) {
            root = root.right;
        } else {
            utils.TreeNode pre = root.left;
            while (pre.right != null) {
                pre = pre.right;
            }
            pre.right = root.right;
            root.right = root.left;
            root.left = null;

            root = root.right;
        }
    }
}
```

## [437. 路径总和 III](https://leetcode.cn/problems/path-sum-iii/)

方法一：前序遍历，要把每个节点作为根节点都计算到

```java
public int pathSum(utils.TreeNode root, int targetSum) {
    if (root == null) return 0;
    long target = (long) targetSum;
    int ans = traversal(root,target);
    ans += pathSum(root.left,targetSum);
    ans += pathSum(root.right,targetSum);
    return ans;
}

private int traversal(utils.TreeNode node, long targetSum) {
    int sum = 0;

    if (node == null) return 0;

    if (node.val == targetSum) {
        sum++;
    }

    sum += traversal(node.left,targetSum-node.val);
    sum += traversal(node.right,targetSum-node.val);
    return sum;
}
```

方法二：前缀和

HashMap里存的key是前缀和， value是该前缀和的节点数量，记录数量是因为有出现复数路径的可能。

如果我们不做状态恢复，当遍历右子树时，左子树中A的信息仍会保留在map中，那此时节点6就会认为A, B都是可追溯到的节点，从而产生错误。

状态恢复代码的作用就是： 在遍历完一个节点的所有子节点后，将其从map中除去。

```java
/**
 * 前缀和
 * @param root
 * @param targetSum
 * @return
 */
public int pathSum2(utils.TreeNode root, int targetSum) {
    Map<Long, Integer> occurance = new HashMap<>();
    occurance.put(0L, 1);
    return dfs(root, targetSum, 0, occurance);
}

private int dfs(utils.TreeNode root, int targetSum, long sumToNow, Map<Long, Integer> occurance) {
    if (root == null) {
        return 0;
    }
    long newSumToNow = sumToNow + root.val;
    int count = occurance.getOrDefault(newSumToNow - targetSum, 0);
    occurance.put(newSumToNow, occurance.getOrDefault(newSumToNow, 0) + 1);
    int left = dfs(root.left, targetSum, newSumToNow, occurance);
    int right = dfs(root.right, targetSum, newSumToNow, occurance);
    occurance.put(newSumToNow, occurance.getOrDefault(newSumToNow, 0) - 1);
    return count + left + right;
}
```

## [994. 腐烂的橘子](https://leetcode.cn/problems/rotting-oranges/)(ac)

```java
int[][] dir = {
        {1,0},{-1,0},{0,1},{0,-1}
};
/**
 * BFS
 * 每次遍历都是1周
 * @param grid
 * @return
 */
public int orangesRotting(int[][] grid) {
    Deque<int[]> deque = new LinkedList<>();
    int count = 0;
    int times = 0;
    for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[0].length; j++) {
            if (grid[i][j] == 2) {
                deque.offer(new int[]{i,j});
            } else if (grid[i][j] == 1) {
                count++;
            }
        }
    }

    while (!deque.isEmpty() && count > 0) {
        int len = deque.size();
        times++;
        for (int j = 0; j < len; j++) {
            int[] cur = deque.poll();
            int curx = cur[0];
            int cury = cur[1];
            for (int i = 0; i < 4; i++) {
                int nextx = curx + dir[i][0];
                int nexty = cury + dir[i][1];
                if (nextx < 0 || nextx >= grid.length || nexty < 0 || nexty >= grid[0].length) continue;
                if (grid[nextx][nexty] == 1) {
                    count--;
                    grid[nextx][nexty] = 2;
                    deque.offer(new int[]{nextx,nexty});
                }
            }
        }

    }
    if (count > 0) {
        return -1;
    }
    return times;
}
```

## [208. 实现 Trie (前缀树)](https://leetcode.cn/problems/implement-trie-prefix-tree/)(类型题、模板题)

文章：https://blog.csdn.net/m0_46202073/article/details/107253959

![](D:\Code\JavaProject\leetcode2024\leetcode2024.assets\Snipaste_2024-03-27_17-19-31.png)

```java
class TrieNode {       // 节点
    boolean isWord; // 是否是终点
    TrieNode[] children = new TrieNode[26]; //存储包含的字符
}

class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /**
     *【向字典树插入单词word】
     * 思路：按照word的字符，从根节点开始，一直向下走：
     * 如果遇到null，就new出新节点；如果节点已经存在，cur顺着往下走就可以
     * @param word
     */
    public void insert(String word) {
        TrieNode cur = root;

        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if (cur.children[c] == null) {
                cur.children[c] = new TrieNode();
            }
            cur = cur.children[c];
        }
        cur.isWord = true; // 一个单词插入完毕，此时cur指向的节点即为一个单词的结尾
    }

    /**
     * 思路：按照word的字符，从根节点开始，一直向下走：
     * 如果遇到null，就是没找到，返回false;
     * 如果找到最后，判断是否是结尾isWord;
     * @param word
     * @return
     */
    public boolean search(String word) {
        TrieNode cur = root;

        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if (cur.children[c] == null) {
                return false;
            }
            cur = cur.children[c];
        }

        return cur.isWord;
    }

    /**
     * 思路：按照word的字符，从根节点开始，一直向下走：
     * 如果遇到null，就是没找到，返回false;
     * @param prefix
     * @return
     */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            int c = prefix.charAt(i) - 'a';
            if (cur.children[c] == null) {
                return false;
            }
            cur = cur.children[c];
        }
        return true;
    }
    
    /**
     * >>> 经典的search方法，是通过一个cur指针(引用)，根据word的字符，一条路走下去
     *     >>> 其实，它还有一个思路———每次判断一个节点是否配对 的【递归】写法 ：
     */
    public boolean search2(String word) {
        return match(word, root, 0);
    }

    /* macth方法
    // 基本思路是：根据word和start得到此时的字符，然后看该字符是否与此时的节点node配对————即node.children[c]有值(!=null)
    // (其实start就相当于非递归写法中的for(i)的i)，用来遍历word
    */
    public boolean match(String word, TrieNode node, int start){		// 这个三个参数直接背下来，这是模板参数
        if(start == word.length()){
            return node.isWord;					// (★) 
        }

        int c = word.charAt(start) - 'a';
        return node.children[c] != null && match(word, node.children[c], start + 1);
    }
}
```

相关题目：

[**【 Leetcode Q820 】单词的压缩编码**](https://leetcode-cn.com/problems/short-encoding-of-words/)

```java
public int minimumLengthEncoding(String[] words) {
    Arrays.sort(words, new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return Integer.compare(o2.length(),o1.length());
        }
    });
    int ans = 0;
    PreTree preTree = new PreTree();
    for (String word : words) {
        ans += preTree.insert(word);
    }
    return ans;
}

class PreNode {
    boolean isWord;
    PreNode[] children = new PreNode[26];
}

/**
 * 构建一棵倒序的前缀树
 */
class PreTree {
    PreNode root;

    public PreTree() {
        root = new PreNode();
    }

    /**
     * 如果是新词的话就统计长度
     *
     * @param word
     * @return
     */
    public int insert(String word) {
        PreNode cur = root;
        boolean isNew = false;
        for (int i = word.length() - 1; i >= 0; i--) {
            int c = word.charAt(i) - 'a';
            if (cur.children[c] == null) {
                cur.children[c] = new PreNode();
                isNew = true;
            }
            cur = cur.children[c];
        }

        cur.isWord = true;
        return isNew ? word.length() + 1 : 0;
    }
}
```

[**【 Leetcode Q17_13 】恢复空格**](https://leetcode-cn.com/problems/re-space-lcci/)

```java
/**
 * 前缀树 + DP
 * @param dictionary
 * @param sentence
 * @return
 */
public int respace(String[] dictionary, String sentence) {
    Arrays.sort(dictionary, new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return Integer.compare(o2.length(),o1.length());
        }
    });
    PreTree preTree = new PreTree();
    for (String dic : dictionary) {
        preTree.insert(dic);
    }

    int[] dp = new int[sentence.length()+1]; // 以i-1为结尾的字符串有多少个未识别

    for (int i = 1; i <= sentence.length(); i++) {
        dp[i] = dp[i-1] + 1;
        List<Integer> search = preTree.search(sentence, i - 1); //搜索以i-1为结尾的字符串匹配情况
        for (Integer j : search) {
            dp[i] = Math.min(dp[i],dp[j]);  //跟匹配上了的取最小值
        }
    }
    return dp[sentence.length()];
}


class PreNode {
    boolean isWord;
    PreNode[] children = new PreNode[26];
}

class PreTree {
    PreNode root;

    public PreTree() {
        root = new PreNode();
    }

    public void insert(String word) {
        PreNode cur = root;
        for (int i = word.length()-1; i >= 0; i--) {
            int c = word.charAt(i) - 'a';
            if (cur.children[c] == null) {
                cur.children[c] = new PreNode();
            }
            cur = cur.children[c];
        }
        cur.isWord = true;
    }

    /**
     * 找到 sentence 中以 sentence[end] 为结尾的单词(可能不止一个)，返回这些单词的开头下标 【★关键】
     * @param word
     * @return
     */
    public List<Integer> search(String word, int end) {
        List<Integer> list = new ArrayList<>();
        PreNode cur = root;
        for (int i = end; i >= 0; i--) {
            int c = word.charAt(i) - 'a';
            if (cur.children[c] == null) {
                break;
            }
            cur = cur.children[c];
            if (cur.isWord) {
                list.add(i);
            }
        }
        return list;
    }

}
```

[**【 Leetcode Q211】 添加与搜索单词-数据结构设计**](https://leetcode-cn.com/problems/add-and-search-word-data-structure-design/)

[**【 Leetcode Q676 】实现一个魔法字典**](https://leetcode-cn.com/problems/implement-magic-dictionary/)

## [79. 单词搜索](https://leetcode.cn/problems/word-search/)

DFS搜索

```java
int[][] dir = {
        {1,0},{0,1},{-1,0},{0,-1}
};
public boolean exist(char[][] board, String word) {
    boolean[][] visited = new boolean[board.length][board[0].length];

    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
            boolean flag = backtracking(board,word,i,j,0,visited);
            if (flag) return true;
        }
    }

    return false;
}

/**
 * DFS 遇到满足条件就返回
 * @param board
 * @param word
 * @param i
 * @param j
 * @param k
 * @param visited
 * @return
 */
private boolean backtracking(char[][] board, String word, int i, int j, int k, boolean[][] visited) {
    if (board[i][j] != word.charAt(k)) {
        return false;
    } else if (k == word.length() - 1) {
        return true;
    }

    visited[i][j] = true;

    for (int[] dirs : dir) {
        int newx = i + dirs[0];
        int newy = j + dirs[1];
        if (newx < 0 || newx >= board.length || newy < 0 || newy >= board[0].length) continue;
        if (!visited[newx][newy]) {
            boolean flag = backtracking(board,word,newx,newy,k+1,visited);
            if (flag) return true;
        }
    }
    visited[i][j] = false;
    return false;
}
```

## [33. 搜索旋转排序数组](https://leetcode.cn/problems/search-in-rotated-sorted-array/)(ac)

**二分查找**

```java
/**
 * 从mid中分开一定是一侧有序，另一侧可能有序
 * @param nums
 * @param target
 * @return
 */
public int search(int[] nums, int target) {
    int right = nums.length - 1;
    int left = 0;

    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] >= nums[left]) {
            //左边有序
            if (nums[mid] > target && target >= nums[left]) {
                //target在left和mid之间
                right = mid - 1;
            } else {
                //target不在left和mid之间
                left = mid + 1;
            }
        } else {
            //右边有序
            if (nums[mid] < target && target <= nums[right]) {
                //target在mid和right之间
                left = mid + 1;
            } else {
                //target不在mid和right之间
                right = mid - 1;
            }
        }
    }

    return -1;
}
```

## [153. 寻找旋转排序数组中的最小值](https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/)(ac)

**二分查找**

```java
/**
 * 找到mid左侧有序的一侧，那么min就是最left的那个，然后让left = mid + 1找mid无序的那侧
 * 如果mid右侧有序就减小空间，right = mid - 1;
 * @param nums
 * @return
 */
public int findMin(int[] nums) {
    int right = nums.length - 1;
    int left = 0;
    int min = Integer.MAX_VALUE;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] < min) {
            min = nums[mid];
        } else if (nums[mid] >= nums[left]) {
            //左边有序
            min = Math.min(min,nums[left]);
            left = mid + 1;
        } else {
            //右侧有序就减小空间
            right = mid - 1;
        }

    }
    return min;
}
```

## [394. 字符串解码](https://leetcode.cn/problems/decode-string/)(ac)

```java
/**
 * 1.仅使用一个栈来存储;
 * 2.遇到数字就判断前一个是不是数字，之后拼接压栈;
 * 3.当遇到']'时，开始构建字符串;
 * 将'['之前的字符都拿出来拼接;
 * 之后获取数字,再拼接
 * 然后再将新字符串压栈
 * 4.最后将栈里元素出栈反转
 * @param s
 * @return
 */
public String decodeString(String s) {
    StringBuilder ans = new StringBuilder();
    Deque<String> stack = new LinkedList<>();

    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (c != ']') {
            if (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0)) && Character.isDigit(c)) {
                stack.push(stack.pop()+c);
            } else {
                stack.push(String.valueOf(c));
            }
        } else {
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty() && !stack.peek().equals("[")) {
                sb.append(stack.pop());
            }
            stack.pop();
            if (!sb.isEmpty()) {
                int num = Integer.parseInt(String.valueOf(stack.pop()));
                String sbStr = sb.toString();
                for (int j = 1; j < num; j++) {
                    sb.append(sbStr);
                }
            }
            stack.push(String.valueOf(sb));
        }
    }

    while (!stack.isEmpty()) {
        ans.append(stack.pop());
    }

    return String.valueOf(ans.reverse());
}
```

## [215. 数组中的第K个最大元素](https://leetcode.cn/problems/kth-largest-element-in-an-array/)

*使用堆能够ac，但时间复杂度是O(nlogn)*

**快速选择算法+分治法**

```java
/**
 * 快速选择算法  分治法
 * @param nums
 * @param k
 * @return
 */
private int quickSelect(List<Integer> nums, int k) {
    // 随机选择基准数
    Random rand = new Random();
    int pivot = nums.get(rand.nextInt(nums.size()));
    // 将大于、小于、等于 pivot 的元素划分至 big, small, equal 中
    List<Integer> big = new ArrayList<>();
    List<Integer> equal = new ArrayList<>();
    List<Integer> small = new ArrayList<>();
    for (int num : nums) {
        if (num > pivot)
            big.add(num);
        else if (num < pivot)
            small.add(num);
        else
            equal.add(num);
    }
    // 第 k 大元素在 big 中，递归划分
    if (k <= big.size())
        return quickSelect(big, k);
    // 第 k 大元素在 small 中，递归划分
    if (nums.size() - small.size() < k)
        return quickSelect(small, k - nums.size() + small.size());
    // 第 k 大元素在 equal 中，直接返回 pivot
    return pivot;
}

public int findKthLargest2(int[] nums, int k) {
    List<Integer> numList = new ArrayList<>();
    for (int num : nums) {
        numList.add(num);
    }
    return quickSelect(numList, k);
}
```

## [295. 数据流的中位数](https://leetcode.cn/problems/find-median-from-data-stream/)(ac)

```java
class MedianFinder {
    /**
     * 大顶堆存中间值的左面
     * 小顶堆存中间值的右面
     */
    PriorityQueue<Integer> minQueue;
    PriorityQueue<Integer> maxQueue;
    public MedianFinder() {
        minQueue = new PriorityQueue<>();
        maxQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2,o1);
            }
        });
    }
    public void addNum(int num) {
        if (maxQueue.isEmpty()) {
            maxQueue.add(num);
            return;
        }

        if (num > maxQueue.peek()) {
            minQueue.add(num);
        } else {
            maxQueue.add(num);
        }
        while (maxQueue.size() - minQueue.size() > 1) {
            minQueue.add(maxQueue.poll());
        }

        while (minQueue.size() - maxQueue.size() > 1) {
            maxQueue.add(minQueue.poll());
        }

    }
    public double findMedian() {
        if (minQueue.size() == maxQueue.size()) {
            return  (double) (minQueue.peek() + maxQueue.peek()) / 2;
        } else {
            return maxQueue.size() > minQueue.size() ? (double) maxQueue.peek() : (double) minQueue.peek();
        }
    }
}
```

## [152. 乘积最大子数组](https://leetcode.cn/problems/maximum-product-subarray/)

```java
/**
 * 考虑当前位置如果是一个负数的话，
 * 那么我们希望以它前一个位置结尾的某个段的积也是个负数，这样就可以负负得正，
 * 并且我们希望这个积尽可能「负得更多」，即尽可能小。
 * 如果当前位置是一个正数的话，
 * 我们更希望以它前一个位置结尾的某个段的积也是个正数，并且希望它尽可能地大。
 * @param nums
 * @return
 */
public int maxProduct(int[] nums) {
    int[] dpmax = new int[nums.length];  // 记录最大的值
    int[] dpmin = new int[nums.length];  // 记录负数最小的值
    
    // 初始化为nums数组
    System.arraycopy(nums,0,dpmax,0,nums.length);
    System.arraycopy(nums,0,dpmin,0,nums.length);

    for (int i = 1; i < nums.length; i++) {
        dpmax[i] = Math.max(dpmax[i - 1] * nums[i], Math.max(nums[i], dpmin[i - 1] * nums[i]));
        dpmin[i] = Math.min(dpmin[i - 1] * nums[i], Math.min(nums[i], dpmax[i - 1] * nums[i]));
    }

    int ans = dpmax[0];
    for (int i = 1; i < nums.length; i++) {
        ans = Math.max(ans, dpmax[i]);
    }

    return ans;
}
```

## [32. 最长有效括号](https://leetcode.cn/problems/longest-valid-parentheses/)

`dp[i]` 表示以下标 `i` 字符结尾的最长有效括号的长度。

递推公式：

- `s[i]=‘)’ 且 s[i−1]=‘(’`，那么

`dp[i] = dp[i-2] + 2`

- `s[i]=‘)’ 且 s[i−1]=‘)’`也就是字符串形如` “……))”`

如果 `s[i−dp[i−1]−1]=‘(’`，那么
`dp[i]=dp[i−1]+dp[i−dp[i−1]−2]+2`

```java
/**
 * 栈
 * @param s
 * @return
 */
public int longestValidParentheses(String s) {
    //如果为空
    if (s == null || s.length() == 0) return 0;
    //建立一个栈
    Deque<Integer> stack = new ArrayDeque<>();
    //这一步可以防止当第一个Character是')'的时候发生越界异常
    stack.push(-1);
    //System.out.println(stack);
    //可以看到stack是[-1]
    int res = 0;
    //遍历栈找寻合适的左右括号
    for (int i = 0; i < s.length(); i++) {
        //如果找到左括号则入栈，为寻找对应右括号做铺垫
        if (s.charAt(i) == '(') stack.push(i);
        else {
            //如果是右括号则出栈
            stack.pop();
            //但是如果栈是空的话还是得（单身的）把右括号放进来
            if (stack.isEmpty()) stack.push(i);
            else {
                //当前全部人数减去剩余无法配对的人数（单身）即res
                res = Math.max(res, i - stack.peek());
            }
        }
    }
    return res;
}

/**
 * DP
 * @param s
 * @return
 */
public int longestValidParentheses2(String s) {
    int res = 0;
    int[] dp = new int[s.length()];
    for (int i = 1; i < s.length(); i++) {
        if (s.charAt(i) == ')') {
            if (s.charAt(i-1) == '(') {
                dp[i] = (i >= 2 ? dp[i-2] : 0) + 2;
            } else if (i - dp[i-1] - 1 >= 0 && s.charAt(i - dp[i-1] - 1) == '(') {
                dp[i] = dp[i-1] + 2 + ((i - dp[i-1]) >= 2 ? dp[i - dp[i-1] - 2] : 0);
            }
        }
        res = Math.max(res,dp[i]);
    }
    return res;
}
```

## [64. 最小路径和](https://leetcode.cn/problems/minimum-path-sum/)(ac)

```java
public int minPathSum(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int[][] dp = new int[m][n];
    dp[0][0] = grid[0][0];
    for (int i = 1; i < m; i++) {
        dp[i][0] = dp[i-1][0] + grid[i][0];
    }
    for (int i = 1; i < n; i++) {
        dp[0][i] = dp[0][i-1] + grid[0][i];
    }
    for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
            dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
        }
    }

    return dp[m-1][n-1];
}
```

## [136. 只出现一次的数字](https://leetcode.cn/problems/single-number/)

1. 任何数于0异或为任何数 0 ^ n => n
2. 相同的数异或为0: n ^ n => 0

例如：2 ^ 3 ^ 2 ^ 4 ^ 4等价于 2 ^ 2 ^ 4 ^ 4 ^ 3 => 0 ^ 0 ^3 => 3

```java
public int singleNumber(int[] nums) {
    int ans = 0;
    for (int i = 0; i < nums.length; i++) {
        ans ^= nums[i];
    }

    return ans;
}
```

## [169. 多数元素](https://leetcode.cn/problems/majority-element/)(ac)

```java
/**
 * 选定一个元素设置count为1，如果下一个不相同就count--，相同就count++
 * 当count小于0时，当前元素已经被消耗完，需要重新记录
 * @param nums
 * @return
 */
public int majorityElement(int[] nums) {
    int ans = nums[0];
    int count = 1;
    for (int i = 1; i < nums.length; i++) {
        if (nums[i] == ans) {
            count++;
        } else {
            count--;
        }
        if (count < 0) {
            ans = nums[i];
            count = 1;
        }
    }
    return ans;
}
```

## [75. 颜色分类](https://leetcode.cn/problems/sort-colors/)(ac)

```java
/**
 * 遇到0就排在左边，遇到1就排到右边
 * 剩下的中间都是1
 * @param nums
 */
public void sortColors(int[] nums) {
    int left = 0;
    int right = nums.length - 1;
    for (int i = 0; i <= right; ) {
        if (nums[i] == 0) {
            int tmp = nums[i];
            nums[i] = nums[left];
            nums[left] = tmp;
            left++;
            i++;
        } else if (nums[i] == 2) {
            int tmp = nums[i];
            nums[i] = nums[right];
            nums[right] = tmp;
            right--;
        } else {
            i++;
        }
    }

    for (int i = left; i <= right; i++) {
        nums[i] = 1;
    }
}
```

## [287. 寻找重复数](https://leetcode.cn/problems/find-the-duplicate-number/)

```java
/**
 * 快慢指针 -> 类似环状链表
 * @param nums
 * @return
 */
public int findDuplicate(int[] nums) {
    int slow = 0;
    int fast = 0;
    do {
        slow = nums[slow];
        fast = nums[nums[fast]];
    }while (slow != fast);

    slow = 0;
    while (slow != fast) {
         slow = nums[slow];
         fast = nums[fast];
    }
    return slow;
}
```

## [73. 矩阵置零](https://leetcode.cn/problems/set-matrix-zeroes/)

```java
/**
 * 73.矩阵置零
 * 我们可以用矩阵的第一行和第一列代替方法一中的两个标记数组，以达到 O(1) 的额外空间。
 * 但这样会导致原数组的第一行和第一列被修改，无法记录它们是否原本包含 0。
 * 因此我们需要额外使用两个标记变量分别记录第一行和第一列是否原本包含 0。
 *
 * 在实际代码中，我们首先预处理出两个标记变量，
 * 接着使用其他行与列去处理第一行与第一列，
 * 然后反过来使用第一行与第一列去更新其他行与列，
 * 最后使用两个标记变量更新第一行与第一列即可。
 *
 * @param matrix
 */
public void setZeroes(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    boolean flagRow = false;
    boolean flagCol = false;

    for (int i = 0; i < m; i++) {
        if (matrix[i][0] == 0) {
            flagCol = true;
        }
    }

    for (int j = 0; j < n; j++) {
        if (matrix[0][j] == 0) {
            flagRow = true;
        }
    }

    for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
            if (matrix[i][j] == 0) {
                matrix[i][0] = 0;
                matrix[0][j] = 0;
            }
        }
    }

    for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
            if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                matrix[i][j] = 0;
            }
        }
    }

    if (flagCol) {
        for (int i = 0; i < m; i++) {
            matrix[i][0] = 0;
        }
    }

    if (flagRow) {
        for (int j = 0; j < n; j++) {
            matrix[0][j] = 0;
        }
    }
}
```

## [230. 二叉搜索树中第K小的元素](https://leetcode.cn/problems/kth-smallest-element-in-a-bst/)

```java
public class middle230 {
    int len = 0;
    int ans = -1;
    public int kthSmallest(utils.TreeNode root, int k) {
        traversal(root,k);
        return ans;
    }

    private void traversal(utils.TreeNode root,int k) {
        if (root == null) return;

        traversal(root.left,k);

        len++;
        if (len == k) {
            ans = root.val;
            return;
        }

        traversal(root.right,k);
    }


    public int kthSmallest2(utils.TreeNode root, int k) {
        MyBst bst = new MyBst(root);
        return bst.kthSmallest(k);
    }

    class MyBst{
        utils.TreeNode root;
        HashMap<utils.TreeNode,Integer> map;

        public MyBst(utils.TreeNode root) {
            this.root = root;
            this.map = new HashMap<>();
            countNodeNum(root);
        }

        private int countNodeNum(utils.TreeNode node) {
            if (root == null) return 0;
            int left = countNodeNum(node.left);
            int right = countNodeNum(node.right);
            map.put(node,1+left+right);
            return map.get(node);
        }

        // 返回二叉搜索树中第k小的元素
        public int kthSmallest(int k) {
            utils.TreeNode node = root;
            while (node != null) {
                int left = getNodeNum(node.left);
                if (left < k-1) {
                    node = node.right;
                    k -= left+1;
                } else if (left == k-1) {
                    break;
                } else {
                    node = node.left;
                }
            }
            return node.val;
        }

        private int getNodeNum(utils.TreeNode node) {
            return map.getOrDefault(node,0);
        }
    }
```
