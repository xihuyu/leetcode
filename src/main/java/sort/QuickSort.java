package sort;

import java.util.Arrays;

/**
 * @ClassNameQuickSort
 * @Description 快速排序
 * @Author fenggaopan
 * @Date2020/7/9 10:42 下午
 * @Version V1.0
 **/
public class QuickSort {

    public static void main(String[] args) {

    }

    public static void quickSort(int arr[], int left, int right) {
        int l = left;
        int r = right;

        int temp = 0;
        //中间值
        int middle = arr[(left + right)/2];
        //比middle小的放到坐标，大的放到右边
        while(l < r) {
            while(arr[l] < middle) {
                l+=1;
            }

            while(arr[r] > middle) {
                r-=1;
            }

            //说明左右两边的值已经按照左边全部是
            //小于中间值
            if(l >= r) {
                break;
            }

            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //交换完成后，发现这个arr[l] = middle
            //r-- 前移
            if(arr[l] == middle) {
                r -= 1;
            }

            //交换完成后，发现这个arr[r] = middle
            //后移
            if(arr[r] == middle) {
                l+=1;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
