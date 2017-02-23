package designPattern.command3;

/**
 * @author Kevin
 * @description
 * @date 2017/2/14
 */
public interface Command {
    public void execute();

    public String getTableNum();

    public void setCookApi(CookApi cookApi);
}
