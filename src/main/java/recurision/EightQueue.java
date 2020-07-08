package recurision;

/**
 * @ClassNameEightQueue
 * @Description : 八皇后问题
 * @Author fenggaopan
 * @Date2020/7/8 7:00 下午
 * @Version V1.0
 **/
public class EightQueue {

    //定义max表示一共有多少个皇后
    int max = 8;
    //定义数组存放结果
    int[] arr = new int[max];
    static int count = 0;
    static int judgeCount = 0;
    public static void main(String[] args) {
        //测试
        EightQueue queue = new EightQueue();
        queue.check(0);
        System.out.printf("总共有%d种解法" , count);
        System.out.printf("总共判断了%d次" , judgeCount);
    }


    //放置第n个皇后
    //每一次check时候，都有for循环
    private void check(int n) {
        if(n == max) { //n==8表示前8个皇后已经放好了
            print();
            return ;
        }

        //循环放置,并判断是否冲突
        for(int j=0; j<max; j++) {
            //先把当前这个皇后n 放到该行的第一列
            arr[n] = j;
            //判断挡放置第n个皇后到i列时候，是否冲突
            if(judge(n)) {
                //不冲突
                //接着放n+1个皇后，开始递归
                check(n+1);
            }
            //冲突，继续执行arr[n] = i;放在后一个位置
        }
    }


    //查看当前放置的第n个皇后，就去检测改皇后是否和前面摆放的皇后冲突
    /**
     *
     * @param n 第n个皇后
     * @return
     */
    private boolean judge(int n) {
        judgeCount++;
        for(int i = 0 ; i< n ;i++ ) {
            //一条线或者对角线
            if(arr[i] == arr[n] || Math.abs(n-i) == Math.abs(arr[n] - arr[i])) {
                return  false;
            }
        }
        return true;
    }

    //输出位置
    public void print() {
        for(int i=0;i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        count ++;
        System.out.println();
    }
}
