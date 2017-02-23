package designPattern.command3;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Kevin
 * @description
 * @date 2017/2/14
 */
public class MenuCommand implements Command {
    private List<Command> commandList = new ArrayList<>();

    public List<Command> getCommandList() {
        return commandList;
    }

    public void addCommand(Command command) {
        this.commandList.add(command);
    }

    @Override
    public void execute() {
        CommandQueue.addMenum(this);
    }

    @Override
    public String getTableNum() {
        return null;
    }

    @Override
    public void setCookApi(CookApi cookApi) {

    }
}
