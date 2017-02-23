package designPattern.command1;

/**
 * @author Kevin
 * @description
 * 命令模式的关键之处就是把请求封装成为对象，也就是命令对象，
 * 并定义了统一的执行操作的接口，这个命令对象可以被存储、转发、记录、处理、撤销等，
 * 整个命令模式都是围绕这个对象在进行。
 * @date 2017/2/13
 */
public class Client {
    public static void main(String[] args) {
        Caculator caculator = new Caculator();
        OperateApi operateApi = new Operation();
        Command command1 = new AddCommand(operateApi, 5);
        Command command2 = new SubstractCommand(operateApi, 2);
        caculator.setAddCommand(command1);
        caculator.setSubstractCommand(command2);

        caculator.addPressed();
        System.out.println("after addPressed result = " + operateApi.getResult());

        caculator.substractPressed();
        System.out.println("after substractPressed result = " + operateApi.getResult());

        caculator.undoPressed();
        System.out.println("after undoPressed result = " + operateApi.getResult());

        caculator.undoPressed();
        System.out.println("after undoPressed result = " + operateApi.getResult());

        caculator.redoPressed();
        System.out.println("after redoPressed result = " + operateApi.getResult());

        caculator.redoPressed();
        System.out.println("after redoPressed result = " + operateApi.getResult());
    }
}
