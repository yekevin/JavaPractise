package designPattern.command1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kevin
 * @description
 * @date 2017/2/13
 */
public class Caculator {
    private Command addCommand;
    private Command substractCommand;
    private List<Command> undoList = new ArrayList<>();
    private List<Command> redoList = new ArrayList<>();

    public void setAddCommand(Command addCommand) {
        this.addCommand = addCommand;
    }

    public void setSubstractCommand(Command substractCommand) {
        this.substractCommand = substractCommand;
    }

    public void addPressed() {
        this.addCommand.execute();
        this.undoList.add(this.addCommand);
    }

    public void substractPressed() {
        this.substractCommand.execute();
        this.undoList.add(this.substractCommand);
    }

    public void undoPressed() {
        if (undoList.size() > 0) {
            Command cmd = undoList.get(undoList.size() - 1);
            cmd.undo();
            this.undoList.remove(cmd);
            this.redoList.add(cmd);
        } else {
            System.out.println("have no undo command1.");
        }
    }

    public void redoPressed() {
        if (redoList.size() > 0) {
            Command cmd = redoList.get(redoList.size() - 1);
            cmd.execute();
            this.redoList.remove(cmd);
            this.undoList.add(cmd);
        } else {
            System.out.println("have no redo command1.");
        }
    }
}
