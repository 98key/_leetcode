package _52;

/**
 * @Description: N皇后问题
 * @Author: 67ng
 * @Date: 2019/8/26 21:44
 */
public class Solution {
    static int count = -1;


    public static int totalNQueens(int n) {

        //定义一个max表示共有多少个皇后
        int max = n;
        //定义数组array, 保存皇后放置位置的结果,比如 arr = {0 , 4, 7, 5, 2, 6, 1, 3}
        int[] array = new int[max];
        check(0, array, max);

        return count;
    }

    //编写一个方法，放置第n个皇后开始实现8皇后（该方法必须从0开始）
    //特别注意： check 是每一次递归时，进入到check中都有for(int i = 0; i < max; i++)，因此会有回溯
    private static void check(int n, int[] array, int max) {
        if (n == max) {  //n = 8 , 其实8个皇后就既然放好，就得到一种放法
            count++;
            return;
        }

        //依次放入皇后，并判断是否冲突
        for (int i = 0; i < max; i++) {
            //先把当前这个皇后n , 放到该行的第1列
            array[n] = i;
            //判断当放置第n个皇后到i列时，是否冲突
            if (judge(n, array)) { // 不冲突
                //接着放n+1个皇后,即开始递归
                check(n + 1, array, max); //
            }
            //如果冲突，就继续执行 array[n] = i; 即将第n个皇后，放置在本行得后移的一个位置
        }
    }

    //查看当我们放置第n个皇后, 就去检测该皇后是否和前面已经摆放的皇后冲突

    private static boolean judge(int n, int[] array) {
        for (int i = 0; i < n; i++) {

            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(totalNQueens(1));
        System.out.println(totalNQueens(8));
        System.out.println(totalNQueens(9));
    }


}