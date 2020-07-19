package search;

import java.util.ArrayList;
import java.util.List;

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

         findAll(arr, 0, arr.length, 10);
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

    //思考:int []arr = {1, 8 , 10, 89, 1000, 1234, 1000};
    //查找所有的1000的位置加入到arrlist
    public static void findAll(int[] arr, int left, int right, int findVal) {
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if(findVal > midVal) {
            binarySearch(arr, mid+1,  right, findVal);
        } else if(findVal < midVal) {
            binarySearch(arr, left, mid-1, findVal);
        } else {
            List<Integer> indexList = new ArrayList<Integer>();
            int temp = mid -1;

            //左扫描
            while(true) {
                if(temp < 0 || arr[temp] !=findVal) {
                    break;
                }

                indexList.add(temp);
                temp -=1;
            }
            indexList.add(mid);


            //右边扫描
            temp = mid +1;
            while(true) {
                if(temp > arr.length || arr[temp] !=findVal) {
                    break;
                }

                indexList.add(temp);
                temp +=1;
            }
            System.out.println(indexList.toArray().toString());
        }
    }

}
