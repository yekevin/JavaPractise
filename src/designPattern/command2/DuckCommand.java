package designPattern.command2;

/**
 * @author Kevin
 * @description
 * @date 2017/2/14
 */
public class DuckCommand implements Command {

    private CookApi cookApi;

    public void setCookApi(CookApi cookApi) {
        this.cookApi = cookApi;
    }

    @Override
    public void execute() {
        this.cookApi.cook("烤鸭");
    }
}
