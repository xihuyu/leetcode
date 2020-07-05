package linkedlist;

/**
 * 使用单向循环列表解决约瑟夫问题
 */
public class Joseph {

    public static void main(String[] args) {
        //测试
        CircleSingleList circleSingleList = new CircleSingleList();
        Boy boy1 = new Boy(1);
        Boy boy2 = new Boy(2);
        Boy boy3 = new Boy(3);
        Boy boy4 = new Boy(4);
        Boy boy5 = new Boy(5);

        circleSingleList.addBoy(115);
        circleSingleList.list();

        //小孩出圈
        circleSingleList.countBoy(1, 2, 115);

    }

}

/**
 * 单向循环链表
 */
class CircleSingleList {

    //创建一个first节点，没有编号
    private Boy first = new Boy(-1);
    //添加节点，构成环形链表
    public void addBoy(int nums) {
        if(nums <1) {
            System.out.println("nums值不正确!");
        }

        //使用for来创建我们的环形链表
        Boy curBoy = null; //辅助指针
        for(int i=1;i<= nums;i++) {
            //根据编号创建小孩节点
            Boy boy = new Boy(i);
            //如果是第一个小孩
            if(i== 1) {
                first = boy;
                first.setNext(first);
                curBoy = first;

            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    //遍历当前环形链表
    public void list() {
        if(first == null) {
            System.out.println("空链表");
        }

        Boy currentBoy = first;
        while(true) {
            System.out.printf("小孩的编号%d", currentBoy.getNo());
            System.out.println();
            if(currentBoy.getNext() == first) {
                break;
            }
            //后移节点
            currentBoy = currentBoy.getNext();
        }
    }

    //根据用户的输入，计算出圈小孩顺序

    /**
     *
     * @param startNo 从第几个小孩数数
     * @param countNum 数几下
     * @param nums 表示最初有多少小孩
     */
    public void countBoy(int startNo, int countNum, int nums) {
        if(first == null || startNo <1 || startNo > nums) {
            System.out.println("参数输入有误，请重新输入!");
        }

        //创建一个辅助指针，帮助完成小孩出圈
        Boy helper = first;
        //指向最后节点
        while(true) {
            if(helper.getNext() == first) {
                //说明指向了最后节点
                break;
            }
            helper = helper.getNext();
        }
        //小孩报数前，让first和helper移动k-1次
        for(int j=0;j<startNo -1 ;j++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //小孩报数，让first和helper指针同时移动m-1次，然后出圈
        //这里是一个循环操作，直到圈中只有一个人
        while(true) {
            if(helper == first) {
                break;
            }

            //让fist和helper指针同时移动countNum -1
            for(int j=0;j<countNum -1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //first指向的节点，就是出圈的小孩节点
            System.out.printf("小孩%d出圈\n", first.getNo());
            //first小孩出圈
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的小孩编号%d\n", first.getNo());
    }
}

class Boy {
    private int no; //编号
    private Boy next ; //下一个节点默认为null
    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
