package designPattern.command2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kevin
 * @description
 * @date 2017/2/14
 */
public class MenuCommand implements Command {
    private List<Command> commandList = new ArrayList<>();

    public void addCommand(Command command) {
        this.commandList.add(command);
    }

    @Override
    public void execute() {
        for (int i = 0; i < commandList.size(); i++) {
            commandList.get(i).execute();
        }
    }
}
