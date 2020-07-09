package sort;

import java.util.Arrays;

/**
 * @ClassNameShellSort
 * @Description 希尔排序
 * @Author fenggaopan
 * @Date2020/7/9 9:36 下午
 * @Version V1.0
 **/
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {8, 9 ,1 ,7, 2,3,5,4,6,0};
        shellSort2(arr);
    }


    //逐步排序，交换法
    public static void shellSort(int arr[]) {

        //使用循环处理
        int temp = 0;
        //比较法
        for(int gap = arr.length/2; gap>0;gap/=2) {
            for(int i=gap; i<arr.length; i++) {
                //计算间距为5
                for(int j=i-gap; j>=0; j-=gap) {
                    //如果当前元素>步长后的元素，交换
                    if(arr[j] > arr[j+gap]) {
                        temp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap] = temp;
                    }
                }
            }
        }


        //第一轮排序，分成五组，每组两个元素，布长5
        /*int temp = 0;
        for(int i=5; i<arr.length; i++) {
            //计算间距为5
            for(int j=i-5; j>=0; j-=5) {
                //如果当前元素>步长后的元素，交换
                if(arr[j] > arr[j+5]) {
                    temp = arr[j];
                    arr[j] = arr[j+5];
                    arr[j+5] = temp;
                }
            }
        }

        System.out.println("第一轮后排序后数组为:");
        System.out.println(Arrays.toString(arr));


        //第二轮排序，
        //将10个数据分成5/2= 2组
        for(int i=2; i<arr.length; i++) {
            //计算间距为5
            for(int j=i-2; j>=0; j-=2) {
                //如果当前元素>步长后的元素，交换
                if(arr[j] > arr[j+2]) {
                    temp = arr[j];
                    arr[j] = arr[j+2];
                    arr[j+2] = temp;
                }
            }
        }

        System.out.println("第二轮后排序后数组为:");
        System.out.println(Arrays.toString(arr));

        //第三轮
        //分成2/2=1组
        for(int i=1; i<arr.length; i++) {
            //计算间距为5
            for(int j=i-1; j>=0; j-=1) {
                //如果当前元素>步长后的元素，交换
                if(arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }*/

        System.out.println(Arrays.toString(arr));

    }

    /**
     * 使用移位法排序
     * @param arr
     */
    public static void shellSort2(int arr[]) {
        for(int gap = arr.length/2; gap>0;gap/=2) {
            //从第gap元素，逐个对其所在组排序
            for(int i=gap; i<arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if(arr[j] < arr[j-gap]) {
                    while(j-gap >=0 && temp<arr[j-gap]) {
                        //移动
                        arr[j] = arr[j-gap];
                        j-=gap;
                    }
                    //退出循环说明temp找到插入位置
                    arr[j] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }


}
