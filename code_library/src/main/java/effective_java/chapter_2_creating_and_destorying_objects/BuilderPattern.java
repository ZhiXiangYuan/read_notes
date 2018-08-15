package effective_java.chapter_2_creating_and_destorying_objects;

/**
 * <p> 构建器模式 </p>
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
            this.param_1 = param_1;
            this.param_2 = param_2;
        }

        public Builder param_3(int val){
            param_3 = val;
            return this;
        }

        public Builder param_4(int val){
            param_4 = val;
            return this;
        }

        public BuilderPattern build(){
            return new BuilderPattern(this);
        }
    }

}
