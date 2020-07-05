package linkedlist;

/**
 * 双向链表案例
 */
public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        System.out.println("双向链表测试......");
        //创建节点
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(heroNode1);
        doubleLinkedList.add(heroNode2);
        doubleLinkedList.add(heroNode3);
        doubleLinkedList.add(heroNode4);

        doubleLinkedList.list();;

        System.out.println("修改测试双向链表");
        HeroNode heroNode5 = new HeroNode(2, "孙悟空", "猴子大王");
        doubleLinkedList.update(heroNode5);

        doubleLinkedList.list();

        System.out.println("删除节点。。。。");
        doubleLinkedList.deleteNode(heroNode2);
        doubleLinkedList.list();


    }
}


/**
 * 双向链表
 */
class DoubleLinkedList {
    //初始化一个头节点
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    /**
     * 遍历列表
     */
    public void list() {
        //判断是否为空
        if(head.next == null) {
            System.out.println("链表为空");
            return ;
        }

        //头节点不动，辅助变量遍历
        HeroNode temp = head.next;

        while(true) {
            if(temp== null) {
                break;
            }
            //输出节点信息
            System.out.println(temp);
            temp = temp.next;
        }
    }

    /**
     * 添加节点
     * @param node
     */
    public void add(HeroNode node) {
        HeroNode temp = head;

        while(true) {
            if(temp.next == null) {
                break;
            }

            temp = temp.next;
        }

        //退出循环的时候就指向了链表最后
        //形成一个双向链表
        temp.next = node;
        node.pre = temp;
    }

    /**
     * 修改节点内容
     * @param node
     */
    public void update(HeroNode node) {
        HeroNode temp = head;
        if(temp.next == null) {
            System.out.println("链表为空");
            return ;
        }

        boolean flag = false;
        while(true) {
            if(temp.next == null) {
                break;
            }

            if(temp.no == node.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag) {
            temp.name = node.name;
            temp.nickName = node.nickName;
        } else {
            System.out.printf("没有找到编号 %d的节点,不能修改", node.no);
        }
    }


    /**
     * 删除节点
     * @param node
     */
    public void deleteNode(HeroNode node) {
        //判断当前链表是否为空
        if(head.next == null) {
            System.out.println("空链表，不能删除");
        }

        HeroNode temp = head;
        boolean flag = false;
        while(true) {
            if(temp == null) {
                break;
            }

            if(temp.no == node.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag) {
            temp.pre.next = temp.next ;
            //这里代码有问题最后一个元素有问题
            if(temp.next != null) {
                temp.next.pre = temp.pre;
            }
        }
    }

}


class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next; //下一个节点
    public HeroNode pre; //前一个节点

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
