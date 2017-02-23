package designPattern.command3;


/**
 * @author Kevin
 * @description
 * @date 2017/2/14
 */
public class Waiter {

    private MenuCommand menuCommand = new MenuCommand();

    public void orderDish(Command command) {
        menuCommand.addCommand(command);
    }

    public void orderOver() {
        this.menuCommand.execute();
    }
}
