package search;

/**
 * @ClassNameSeqSearch
 * @Description  顺序查找
 * @Author fenggaopan
 * @Date2020/7/15 10:29 下午
 * @Version V1.0
 **/
public class SeqSearch {

    public static void main(String[] args) {
        int[] arr = {1, 9, 11, -1, 34, 89};

        int index = SeqSearch(arr, 34);

        System.out.println(index);
    }

    public static int SeqSearch(int[] arr, int value) {
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
