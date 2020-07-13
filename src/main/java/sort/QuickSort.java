package sort;

import java.util.Arrays;

/**
 * @ClassNameQuickSort
 * @Description
 * @Author fenggaopan
 * @Date2020/7/13 9:49 下午
 * @Version V1.0
 **/
public class QuickSort {

    public static void main(String[] args) {

        int arr[] = {-9,193,78,0,23,-576,70,10};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

    /**
     * 快速排序
     * @param arr
     */
    public static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;

        //pivot是中轴
        int pivot = arr[(left + right) /2];
        //while循环的目的是让比pivot值小的放到左边，大的放到右边
        int temp = 0; //交换临时变量
        while(l<r) {


            //左边找一个大于等于pivot
            while(arr[l] < pivot) {
                l+=1;
            }

            //pivot右边找小于等于
            while(arr[r] > pivot) {
                r-=1;
            }

            //说明左边全部是小于pivot了
            while(l >= r) {
                break;
            }

            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //交换后，发现arr[l] ==  pivot值
            //前移
            if(arr[l] == pivot) {
                r -=1;
            }

            if(arr[r] == pivot) {
                l +=1;
            }
        }

        //如果l==r 必须l++, r-- 要不然死循环
        if(l == r) {
            l +=1;
            r -=1;
        }

        //向左递归
        if(left < r) {
            quickSort(arr, left, r);
        }

        //向右递归
        if(right > l) {
            quickSort(arr, l, right);
        }
    }
}
