import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassNameMyData
 * @Description  线程可见效的代码演示
 * @Author fenggaopan
 * @Date2020/7/11 6:47 下午
 * @Version V1.0
 **/
class Mydata {

    volatile int number = 0;
    public void addT60() {
        this.number = 60;
    }

    public void addPlusPlus() {
        number ++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();
    public void addAtomic() {
        atomicInteger.getAndIncrement();
    }
}

/**
 * 验证volatile可见性
 * 1.1加入int number = 0,number没有被volatile修饰
 *
 *
 * 1.2验证原子性
 *  不可分割，做某个业务时候，中间不可以分割，需要整体
 *
 *  如何解决这个问题呢？
 *
 */
public class VolatileAutomicDemo {

    public static void main(String[] args) {
        Mydata mydata = new Mydata();
        for(int i=1;i<=20;i++) {
            new Thread(()->{
                for(int j=1; j<=1000; j++) {
                    mydata.addAtomic();
                }
            },String.valueOf(i)).start();
        }

        //需要的等待上面都执行完
        //1.方法1：Thread.sleep(5);
        //2.方法2：
        while(Thread.activeCount() >2) {
            Thread.yield();
        }

        System.out.println("最终结果是:" + mydata.atomicInteger);
    }


    /**
     * 线程可见性
     */
    private static void canSeeByOtherThread() {
        Mydata mydata = new Mydata();

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
