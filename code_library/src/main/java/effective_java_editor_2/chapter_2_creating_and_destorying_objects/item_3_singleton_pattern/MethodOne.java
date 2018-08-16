package effective_java_editor_2.chapter_2_creating_and_destorying_objects.item_3_singleton_pattern;

/**
 * <p> 单例模式实现一 </p>
 *
 *  <p>
 *      这一节主要描述了单例模式的几种实现，但是由于版本较老，想好好学还是得看博客。
 *  </p>
 *
 * @author zhixiang.yuan
 * @create 2018/08/16 19:08
 */
class Client_1{

    public static void main(String[] args) {
        MethodOne instance = MethodOne.INSTANCE;
    }

}

public class MethodOne {

    private MethodOne(){}

    public static final MethodOne INSTANCE = new MethodOne();

}
