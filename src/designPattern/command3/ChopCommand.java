package designPattern.command3;


/**
 * @author Kevin
 * @description
 * @date 2017/2/14
 */
public class ChopCommand implements Command {
    private CookApi cookApi;
    private String tableNum;

    public ChopCommand(String tableNum) {
        this.tableNum = tableNum;
    }

    @Override
    public void setCookApi(CookApi cookApi) {
        this.cookApi = cookApi;
    }

    @Override
    public void execute() {
        this.cookApi.cook(this.tableNum, "排骨");
    }

    @Override
    public String getTableNum() {
        return tableNum;
    }
}
