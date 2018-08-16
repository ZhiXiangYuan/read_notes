package effective_java_editor_2.chapter_2_creating_and_destorying_objects.item_2_many_paramters_condition;

/**
 * <p> JavaBean 模式 </p>
 *
 * <p>
 *     优点：
 *          1. 创建对象容易，代码易读
 *     缺点：
 *          1. 构造过程被分开了，非常危险
 *          2. 哪怕 set 方法返回 this 也不能生成不可变对象，
 *              final 变量会在 new 的时候被初始化赋值，之后无法更改
 * </p>
 * @author zhixiang.yuan
 * @create 2018/08/16 18:09
 */
class Client_3{

    public static void main(String[] args) {
        JavaBeanPattern javaBeanPattern = new JavaBeanPattern();
        javaBeanPattern.setParam_1(1);
        javaBeanPattern.setParam_2(2);
        javaBeanPattern.setParam_3(3);
        javaBeanPattern.setParam_4(4);
    }

}

public class JavaBeanPattern {

    private int param_1;
    private int param_2;
    private int param_3;
    private int param_4;

    public void setParam_1(int param_1) {
        this.param_1 = param_1;
    }

    public void setParam_2(int param_2) {
        this.param_2 = param_2;
    }

    public void setParam_3(int param_3) {
        this.param_3 = param_3;
    }

    public void setParam_4(int param_4) {
        this.param_4 = param_4;
    }
}
