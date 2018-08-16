package effective_java_editor_2.chapter_2_creating_and_destorying_objects.item_2_many_paramters_condition;

/**
 * <p> 重叠构造器模式 </p>
 *
 * <p>
 *     优点：
 *          1. 在参数较少时（比如：1～2个参数）可以方便的实现多参数构造
 *     缺点：
 *          1. 如果参数中有可选参数也会被设置
 *          2. 参数稍微多一点就会出现很多的构造函数，难以使用、维护和增加参数
 *          3. 在大量使用过后难以转换成 BuilderPattern
 *          4. 参数顺序难以确定，依然导致使用体验极差
 * </p>
 *
 * @author zhixiang.yuan
 * @create 2018/08/16 17:09
 */
class Client_2{

    public static void main(String[] args) {
        // 模拟客户端调用
        new TelescopingConstructorPattern(1);
    }

}

public class TelescopingConstructorPattern {

    /** required parameters */
    private final int param_1;
    /** optional parameters - initialized to default values */
    private final int param_2;
    /** optional parameters - initialized to default values */
    private final int param_3;

    public TelescopingConstructorPattern(int param_1){
        this(param_1, 0,0);
    }

    public TelescopingConstructorPattern(int param_1, int param_2){
        this(param_1, param_2, 0);
    }

    public TelescopingConstructorPattern(int param_1, int param_2, int param_3){
        this.param_1 = param_1;
        this.param_2 = param_2;
        this.param_3 = param_3;
    }

}
