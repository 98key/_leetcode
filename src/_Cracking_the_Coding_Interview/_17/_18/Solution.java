package _Cracking_the_Coding_Interview._17._18;

import java.util.*;

/**
 * @Description: 面试题 17.18. 最短超串
 * 假设你有两个数组，一个长一个短，短的元素均不相同。找到长数组中包含短数组所有的元素的最短子数组，其出现顺序无关紧要。
 * 返回最短子数组的左端点和右端点，如有多个满足条件的子数组，返回左端点最小的一个。若不存在，返回空数组。
 * @Date: 2020/12/31
 */

public class Solution {
    public int[] shortestSeq(int[] big, int[] small) {
        int b_len = big.length;
        if (b_len < small.length)
            return new int[0];
        HashSet<Integer> smallSet = new HashSet<>(), bigSet = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int s : small)
            smallSet.add(s);
        int len = Integer.MAX_VALUE;
        int[] ans={-1,-1};
        for (int i = 0; i < b_len; ++i) {
            if (smallSet.contains(big[i])) {
                list.add(i);
                bigSet.add(big[i]);
                if(map.containsKey(big[i]))
                    map.put(big[i],map.get(big[i])+1);
                else
                    map.put(big[i],1);

                if (bigSet.size() == smallSet.size()) {
                    int temp;
                    while (true) {
                        temp = list.remove(0);
                        int count = map.get(big[temp]) - 1;
                        map.put(big[temp], count);
                        if (count == 0) {
                            bigSet.remove(big[temp]);
                            break;
                        }
                    }
                    if (len > i - temp + 1) {
                        len = i - temp + 1;
                        ans[0] = temp;
                        ans[1] = i;
                    }
                }
            }
        }
        if(ans[0]<0)
            return new int[0];
        return ans;
    }
}
