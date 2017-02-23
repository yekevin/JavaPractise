package designPattern.command3;

/**
 * @author Kevin
 * @description
 * @date 2017/2/14
 */
public class DuckCommand implements Command {
    private CookApi cookApi;
    private String tableNum;

    public DuckCommand(String tableNum) {
        this.tableNum = tableNum;
    }

    @Override
    public void setCookApi(CookApi cookApi) {
        this.cookApi = cookApi;
    }

    @Override
    public void execute() {
        this.cookApi.cook(tableNum, "烤鸭");
    }

    @Override
    public String getTableNum() {
        return tableNum;
    }
}
