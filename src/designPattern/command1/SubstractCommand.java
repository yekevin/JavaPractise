package designPattern.command1;

/**
 * @author Kevin
 * @description
 * @date 2017/2/13
 */
public class SubstractCommand implements Command {

    private OperateApi operateApi;
    private int operateNum;

    public SubstractCommand(OperateApi operateApi, int operateNum) {
        this.operateApi = operateApi;
        this.operateNum = operateNum;
    }

    @Override
    public void execute() {
        this.operateApi.substract(this.operateNum);
    }

    @Override
    public void undo() {
        this.operateApi.add(this.operateNum);
    }
}
