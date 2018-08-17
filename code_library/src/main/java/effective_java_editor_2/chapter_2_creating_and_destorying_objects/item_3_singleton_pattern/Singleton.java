package effective_java_editor_2.chapter_2_creating_and_destorying_objects.item_3_singleton_pattern;

/**
 * <p> 单例模式 </p>
 *
 *  <p>
 *      书上总结的不好，这一章的内容从网上截取。
 *  </p>
 *
 * @author zhixiang.yuan
 * @create 2018/08/16 19:08
 */

import java.io.ObjectStreamException;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *     饿汉模式
 *
 *     在类加载的时候完成初始化
 * </p>
 *
 * <p>
 *     优点：
 *          1. 线程安全
 *     缺点：
 *          1. 导致类加载的速度变慢
 *          2. 没有懒加载
 * </p>
 */
class Singleton_1 {

    public static final Singleton_1 instance = new Singleton_1();

    private Singleton_1(){}

    public static Singleton_1 getInstance(){
        return instance;
    }

}

/**
 * <p> 懒汉模式 （线程不安全）</p>
 *
 * <p>
 *     优点：
 *          1. 类加载较快
 *          2. 使用时才实例化
 *     缺点：
 *          1. 线程不安全
 * </p>
 */
class Singleton_2{

    private static Singleton_2 instance;

    private Singleton_2(){}

    public static Singleton_2 getInstance(){
        if(instance==null){
            instance = new Singleton_2();
        }
        return instance;
    }
}

/**
 * <p> 懒汉模式（线程安全）</p>
 *
 * <p>
 *     优点：
 *          1. 类加载较快
 *          2. 线程安全
 *          3. 使用时才实例化
 *     缺点：
 *          1. 每次调用getInstance方法时都需要进行同步，造成不必要的同步开销
 * </p>
 */
class Singleton_3{

    private static Singleton_3 instance;

    private Singleton_3(){}

    public static synchronized Singleton_3 getInstance() {
        if(instance==null){
            instance = new Singleton_3();
        }
        return instance;
    }
}

/**
 * <p>
 *     双重检查模式 （DCL）
 *
 *     这种写法在getSingleton方法中对singleton进行了两次判空，第一次是为了不必要的同步，
 *     第二次是在singleton等于null的情况下才创建实例。在这里使用volatile会或多或少的影响性能，
 *     但考虑到程序的正确性，牺牲这点性能还是值得的。
 * </p>
 *
 * <p>
 *     优点：
 *          1. 线程安全
 *          2. 使用时才实例化
 *     缺点：
 *          1. 在某些环境下会出现 DCL 失效的问题（建议使用静态内部类单例模式替代 DCL 模式）
 * </p>
 */
class Singleton_4{

    private volatile static Singleton_4 instance;

    private Singleton_4(){}

    public static Singleton_4 getInstance(){
        if(instance==null){
            synchronized(Singleton_4.class){
                if(instance==null){
                    instance = new Singleton_4();
                }
            }
        }
        return instance;
    }

}

/**
 * <p> 静态内部类模式 （推荐使用这种）</p>
 *
 * <p>
 *     优点：
 *          1. 线程安全
 *          2. 使用时才初始化
 *     缺点：
 * </p>
 */
class Singleton_5{

    private Singleton_5(){}

    public static Singleton_5 getInstance(){
        return Singleton_5_Holder.sInstance;
    }

    private static class Singleton_5_Holder {
        private static final Singleton_5 sInstance = new Singleton_5();
    }

    // 加入此方法杜绝单例对象被反序列化时重新生成对象
    private Object readResolve() throws ObjectStreamException{
        return Singleton_5_Holder.sInstance;
    }

}

/**
 * <p> 枚举单例 </p>
 *
 * <p>
 *     优点：
 *          1. 线程安全
 *          2. 任何情况下都是单例（上述的单例在反序列化时会重新创建对象）
 *          3. 编写简单
 *     缺点：
 *          1. 可读性差（是不是我不太会懂枚举用法的原因）
 * </p>
 */
enum Singleton_6{
    INSTANCE;
    private Singleton_6(){}
}

/**
 * <p>
 *     使用容器实现单例模式
 *
 *     用 SingletonManager 将多种的单例类统一管理，在使用时根据 key 获取对象对应类型的对象。
 *     这种方式使得我们可以管理多种类型的单例，并且在使用时可以通过统一的接口进行获取操作，
 *     降低了用户的使用成本，也对用户隐藏了具体实现，降低了耦合度
 * </p>
 *
 * <p>
 *     优点：
 *          1. 降低了用户的使用成本
 *          2. 对用户隐藏了具体实现
 *          3. 降低了耦合度
 *     缺点：
 * </p>
 */
class SingletonManage{
    private static Map<String, Object> objMap = new HashMap<String, Object>();
    private SingletonManage(){}
    public static void registerService(String key, Object instance){
        if(!objMap.containsKey(key)){
            objMap.put(key, instance);
        }
    }
    public static Object getService(String key){
        return objMap.get(key);
    }
}





























