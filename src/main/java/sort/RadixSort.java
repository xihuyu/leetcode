package sort;

import java.util.Arrays;

/**
 * @ClassNameRadixSort
 * @Description 基数排序
 * @Author fenggaopan
 * @Date2020/7/15 10:02 下午
 * @Version V1.0
 **/
public class RadixSort {

    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};
        radixSort(arr);
    }

    public static void radixSort(int[] arr) {
        //第一轮对个位数处理


        //第一个二维数组，表示10个桶，每个桶就是一个二维数组
        int [][] bucket = new int[10][arr.length];

        //为了记录每个桶存放多少数据
        int []bucketElementCounts = new int[10];


        //1.第一轮排序，个位数
        for(int j=0; j<arr.length; j++) {
            int element = arr[j] % 10;
            bucket[element][bucketElementCounts[element]] = arr[j];
            bucketElementCounts[element] ++;
        }

        //按照桶的顺序，放回原来数组
        int index = 0;
        //遍历每一个桶，并将桶中的
        for(int k=0; k< bucketElementCounts.length; k++) {
            //如果桶中有数据，才放入到原数组
            if(bucketElementCounts[k] != 0) {
                //说明有数据
                //循环这个桶
                for(int l=0; l< bucketElementCounts[k]; l++) {
                    //放入到原来的arr
                    arr[index] = bucket[k][l];
                    index ++;
                }
            }
        }

        System.out.println("================>第一轮对个位数排序后");
        System.out.println(Arrays.toString(arr));

    }
}
