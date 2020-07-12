package 面试准备;

/**
 * @ClassNameSingleton
 * @Description
 * @Author fenggaopan
 * @Date2020/7/11 10:17 下午
 * @Version V1.0
 **/
public class Singleton {

    public static Singleton instance = null;

    public Singleton() {

    }

    public static Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
