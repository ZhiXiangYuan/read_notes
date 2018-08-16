package effective_java.chapter_2_creating_and_destorying_objects.item_2_many_paramters_condition;

/**
 * <p> 构建器模式 </p>
 * <p>
 *     优点：
 *          1. 拥有多个可变参数，扩展参数和调用时都很灵活
 *     缺点：
 *          1. 创建对象先要创建 builder
 *          2. 创建 builder 需要一些额外的性能（代价很小，在对性能要求不高的情况下可忽略不计）
 * </p>
 *
 * @author zhixiang.yuan
 * @create 2018/08/16 00:16
 */
class Client{

    public static void main(String[] args) {
        // 模拟客户端调用
        BuilderPattern builderPattern = new BuilderPattern.Builder(1, 2).param_3(3).param_4(4).build();
    }

}

public class BuilderPattern {

    /** required parameters */
    private final int param_1;
    /** required parameters */
    private final int param_2;
    /** optional parameters - initialized to default values */
    private final int param_3;
    /** optional parameters - initialized to default values */
    private final int param_4;

    private BuilderPattern(Builder builder) {
        param_1 = builder.param_1;
        param_2 = builder.param_2;
        param_3 = builder.param_3;
        param_4 = builder.param_4;
    }

    public static class Builder {
        /** required parameters */
        private final int param_1;
        private final int param_2;
        /** optional parameters - initialized to default values */
        private int param_3 = 0;
        private int param_4 = 0;

        public Builder(int param_1, int param_2){
            // TODO 实际使用时添加参数检查，不符合则抛出异常
            this.param_1 = param_1;
            this.param_2 = param_2;
        }

        public Builder param_3(int val){
            // TODO 实际使用时添加参数检查，不符合则抛出异常
            param_3 = val;
            return this;
        }

        public Builder param_4(int val){
            // TODO 实际使用时添加参数检查，不符合则抛出异常
            param_4 = val;
            return this;
        }

        public BuilderPattern build(){
            return new BuilderPattern(this);
        }
    }

}
