package 面试准备.锁;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @ClassNameReadWriteLock
 * @Description 读写锁案例
 * @Author fenggaopan
 * @Date2020/7/18 9:45 下午
 * @Version V1.0
 **/
class MyCache {
    private volatile Map<String, Object> map = new HashMap<>();

    //
    public void put(String key, Object value) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "   正在写入" + key);
        TimeUnit.SECONDS.sleep(1);
        map.put(key, value);
        System.out.println(Thread.currentThread().getName() + "  写入完成" + key);
    }
}
public class ReadWriteLock {

    public static void main(String[] args) {

    }
}
