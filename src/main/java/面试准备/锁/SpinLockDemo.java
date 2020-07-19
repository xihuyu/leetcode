package 面试准备.锁;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @ClassNameSpinLockDemo
 * @Description 自旋锁,手写自旋锁
 * @Author fenggaopan
 * @Date2020/7/18 8:49 下午
 * @Version V1.0
 **/
public class SpinLockDemo {

    //原子引用线程
    AtomicReference<Thread> atomicReference = new AtomicReference<Thread>();


    public void myLock() {
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName());
        while(!atomicReference.compareAndSet(null, thread)) {

        }
    }

    public void myUnLock() {
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread, null);
        System.out.println(Thread.currentThread().getName() + "unlock");
    }

    public static void main(String[] args) throws Exception {
        final SpinLockDemo spinLockDemo = new SpinLockDemo();

        new Thread(()->{
            spinLockDemo.myLock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockDemo.myUnLock();
        }, "aaaa").start();


        new Thread(()->{
            spinLockDemo.myLock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockDemo.myUnLock();
        }, "bbbb").start();



    }
}
