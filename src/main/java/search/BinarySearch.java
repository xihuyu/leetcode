package search;

/**
 * @ClassNameBinarySearch
 * @Description 二分查找
 * @Author fenggaopan
 * @Date2020/7/15 10:42 下午
 * @Version V1.0
 **/
public class BinarySearch {

    public static void main(String[] args) {
        int []arr = {1, 8 , 10, 89, 1000, 1234};

        int resIndex = binarySearch(arr, 0, arr.length, 10);
        System.out.println("找到数字的位置为:" + resIndex);
    }

    /**
     * 二分查找
     * @param arr
     * @param left
     * @param right
     * @param findVal
     * @return
     */
    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if(findVal > midVal) {
            return binarySearch(arr, mid+1,  right, findVal);
        } else if(findVal < midVal) {
            return binarySearch(arr, left, mid-1, findVal);
        } else {
            return mid;
        }
    }
}
