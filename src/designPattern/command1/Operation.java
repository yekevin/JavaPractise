package designPattern.command1;

/**
 * @author Kevin
 * @description
 * @date 2017/2/13
 */
public class Operation implements OperateApi {

    private int result;

    @Override
    public int getResult() {
        return this.result;
    }

    @Override
    public void setResult(int num) {
        this.result = num;
    }

    @Override
    public void add(int num) {
        this.result += num;
    }

    @Override
    public void substract(int num) {
        this.result -= num;
    }
}
