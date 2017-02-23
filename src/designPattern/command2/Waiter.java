package designPattern.command2;

/**
 * @author Kevin
 * @description
 * @date 2017/2/14
 */
public class Waiter {

    private MenuCommand menuCommand = new MenuCommand();
    private CookApi hotCook = new HotCook();
    private CookApi coolCook = new CoolCook();

    public void orderDish(Command command) {
        if (command instanceof ChopCommand) {
            ((ChopCommand) command).setCookApi(hotCook);
        } else if (command instanceof DuckCommand) {
            ((DuckCommand) command).setCookApi(hotCook);
        } else if (command instanceof IceCommand) {
            ((IceCommand) command).setCookApi(coolCook);
        }
        menuCommand.addCommand(command);
    }

    public void orderOver() {
        menuCommand.execute();
    }
}
