
/**
 * @ClassNameMyData
 * @Description  线程可见效的代码演示
 * @Author fenggaopan
 * @Date2020/7/11 6:47 下午
 * @Version V1.0
 **/
class Mydata1 {

    volatile int number = 0;
    public void addT60() {
        this.number = 60;
    }
}

/**
 * 验证volatile可见性
 * 1.1加入int number = 0,number没有被volatile修饰
 */
public class VolatileDemo {

    public static void main(String[] args) {
        Mydata1 mydata = new Mydata1();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "come in");
            try {
                Thread.sleep(3);

                //改变值
                mydata.addT60();
                System.out.println(Thread.currentThread().getName() + "update data value" + mydata.number);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"aaa").start();

        //第二个线程就是main线程
        while(mydata.number == 0) {
            //main一只在等待循环，直到
        }

        //如果不加volatile他永远不知道number的值变化了，因为没有可见性
        System.out.println(Thread.currentThread().getName() + "mydata值发生了变化");
    }
}
