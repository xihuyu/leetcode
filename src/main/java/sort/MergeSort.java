package sort;

/**
 * @ClassNameMergeSort
 * @Description 归并排序
 * @Author fenggaopan
 * @Date2020/7/13 10:58 下午
 * @Version V1.0
 **/
public class MergeSort {

    public static void main(String[] args) {

        int [] arr = {8,4,5,7,1,3,6,2};

    }

    /**
     *
     * @param arr 原始数组
     * @param left 左边有序序列的索引
     * @param right 左边索引
     * @param mid  中间索引
     * @param temp 中转的数组
     */
    public static void merge(int[] arr, int left, int right, int mid, int [] temp) {
        int i = left; //初始化i
        int j = mid +1; //右边初始化索引

        int t = 0;
        //1.把左右两边的数据按照规则填充到temp数组
        while(i < mid &&  j<= right) {
            //如果发现左边有序序列当前元素小于等于右边
            //即将左边的当前元素拷贝到temp数组
            if(arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t +=1;
                i+=1;
            } else {
                //反之填充到temp
                temp[t] = arr[j];
                t+=1;
                j+=1;
            }
        }

        //2.剩余的一边一次填充到temp
        while(i <= mid) {
            //说明左边的还有剩余
            temp[t] = arr[i];
            t+=1;
            i+=1;
        }

        while(j <= right) {
            //说明左边的还有剩余
            temp[t] = arr[j];
            t+=1;
            j+=1;
        }

        //3将temp元素拷贝到arr
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft +=1;
        }

    }
}
