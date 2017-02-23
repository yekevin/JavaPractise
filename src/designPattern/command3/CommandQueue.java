package designPattern.command3;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Kevin
 * @description
 * @date 2017/2/14
 */
public class CommandQueue {
    private static BlockingQueue<Command> blockingQueue = new LinkedBlockingQueue<>();

    public static void addMenum(MenuCommand command) {
        List<Command> commands = command.getCommandList();
        for (int i = 0; i < commands.size(); i++) {
            blockingQueue.add(commands.get(i));
        }
    }

    public static Command getOneComamnd() {
        try {
            return blockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
