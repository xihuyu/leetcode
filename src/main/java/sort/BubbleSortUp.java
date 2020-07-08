package sort;

import java.util.Arrays;

/**
 * @ClassNameBubbleSort
 * @Description 冒泡排序 优化
 * @Author fenggaopan
 * @Date2020/7/8 9:10 下午
 * @Version V1.0
 **/
public class BubbleSortUp {
    public static void main(String[] args) {

        int arr[] = {3, 9 , -1, 10 , -2};
        int temp = 0;
        boolean flag = false;
        //第一趟就是将最大的排到最后，只需要比较四次
        for(int i=0; i< arr.length; i++) {
            for(int j = 0; j<arr.length -1-i ; j++) {
                if(arr[j] > arr[j+1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if(!flag) {
                break;
            } else {
                flag = false;
            }
            System.out.printf("第%d趟排序后的数组", i);
            System.out.println(Arrays.toString(arr));
        }

    }
}
