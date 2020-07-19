package 哈希;

import java.util.Scanner;

/**
 * @ClassNameMyHashTable
 * @Description 自定义hashtable
 * @Author fenggaopan
 * @Date2020/7/19 10:29 下午
 * @Version V1.0
 **/
public class MyHashTable {

    public static void main(String[] args) {
        HashTable hashTable = new HashTable(7);

        //写一个简单菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入.....");
        while(true) {
            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("添加雇员");
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    Emp emp = new Emp(id, name);
                    hashTable.add(emp);
                    break;

                case "list":
                    System.out.println("遍历列表");
                    hashTable.list();
                    break;

                case "exit":
                    System.out.println("退出系统");
                    System.exit(0);
                    break;
            }
        }
    }

}

class Emp{
    public Integer id;
    public String name;
    public Emp next;
    public Emp(Integer id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}


class HashTable {
    private EmpLinedList[] empLinedLists ;
    private int size; //容量

    //构造器
    public HashTable(int size) {
        this.size = size;
        //初始化
        empLinedLists = new EmpLinedList[size];
        //每个都要初始化
        for(int i=0; i< size; i++) {
            empLinedLists[i] = new EmpLinedList();
        }

    }

    //添加雇员
    public void add(Emp emp) {
        //根据id决定添加到哪个链表
        int empNo = hashFun(emp.id);

        //将emp添加到对应的链表
        empLinedLists[empNo].add(emp);
    }

    //遍历链表
    public void list() {
        for(int i=0; i< size; i++ ) {
            empLinedLists[i].list(i);
        }
    }

    //散列函数
    public int hashFun(int id) {
        return id%size;
    }

}

class EmpLinedList {
    //头指针，指向第一个雇员的，head
    private Emp head;

    //添加雇员到列表
    //假定id是自增的，我们将该雇员加入到最后
    public void add(Emp emp) {
        //如果是添加第一个雇员
        if(head == null) {
            head = emp;
            return ;
        }

        //如果不是第一个，使用辅助指针
        Emp curEmp = head;
        while(true) {
            if(curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;
        }

        //将emp加入到最后即可
        curEmp.next = emp;
    }

    //遍历雇员信息
    public void list(int no) {
        if(head == null) {
            System.out.println("第" + no + "条链表为空");
            return ;
        }
        System.out.print("第" + no + "条链表信息为:");
        Emp curEmp = head;
        while(true) {
            System.out.printf("=>id=%d name=%s\t", curEmp.id, curEmp.name);
            System.out.println();
            if(curEmp.next == null) {
                //说明已经是最后节点
                break;
            }
            //后移遍历
            curEmp = curEmp.next;
        }


    }
}
