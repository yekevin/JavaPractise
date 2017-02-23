package designPattern.command1;

/**
 * @author Kevin
 * @description
 * @date 2017/2/13
 */
public class AddCommand implements Command {

    private OperateApi operateApi;
    private int operateNum;

    public AddCommand(OperateApi operateApi, int operateNum) {
        this.operateApi = operateApi;
        this.operateNum = operateNum;
    }

    @Override
    public void execute() {
        this.operateApi.add(operateNum);
    }

    @Override
    public void undo() {
        this.operateApi.substract(operateNum);
    }
}
