package sort;

import java.util.Arrays;

/**
 * @ClassNameSelectSort
 * @Description 选择排序
 * @Author fenggaopan
 * @Date2020/7/8 9:56 下午
 * @Version V1.0
 **/
public class SelectSort {

    public static void main(String[] args) {
        int arr[] = {101, 34, 119, 1};
        sort(arr);
    }

    /**
     * 排序方法
     * @param arr
     */
    public static void sort(int[] arr) {
        //101 34 119 1
        //第一轮 1 34 119 101

        //总结规律
        for(int i=0; i<arr.length -1; i++) {
            int minIndex = i;
            int min = arr[i];

            for(int j= i+1; j< arr.length; j++) {
                if(min > arr[j]) {
                //重制最小值
                min = arr[j];
                minIndex = j;
               }
            }

            if(minIndex !=i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }

        System.out.println("排序后...........");
        System.out.println(Arrays.toString(arr));



//        //第一轮
//        //假定第一个元素是索引是0
//        int minIndex = 0 ;
//        int min = arr[minIndex];
//
//        for(int j = 0 +1; j< arr.length; j++) {
//            if(min > arr[j]) {
//                //重制最小值
//                min = arr[j];
//                minIndex = j;
//            }
//        }
//
//        //将最小值放到arr[0],交换值
//        arr[minIndex] = arr[0];
//        arr[0] = min;
//
//        System.out.println(min);
//        System.out.println(minIndex);
//        System.out.println(Arrays.toString(arr));
//
//
//        //第二轮
//        if(minIndex !=0) {
//            minIndex = 1;
//            min = arr[1];
//        }
//
//
//        for(int j = 1 +1; j< arr.length; j++) {
//            if(min > arr[j]) {
//                //重制最小值
//                min = arr[j];
//                minIndex = j;
//            }
//        }
//
//        //将最小值放到arr[0],交换值
//        if(minIndex !=1) {
//            arr[minIndex] = arr[1];
//            arr[1] = min;
//        }
//
//
//        //第三轮
//        minIndex = 2;
//        min = arr[2];
//        for(int j = 1 +1 +1; j< arr.length; j++) {
//            if(min > arr[j]) {
//                //重制最小值
//                min = arr[j];
//                minIndex = j;
//            }
//        }
//
//        if(minIndex !=2) {
//            arr[minIndex] = arr[2];
//            arr[2] = min;
//        }

    }
}
