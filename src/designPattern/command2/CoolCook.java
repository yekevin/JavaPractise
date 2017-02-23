package designPattern.command2;

/**
 * @author Kevin
 * @description
 * @date 2017/2/14
 */
public class CoolCook implements CookApi {
    @Override
    public void cook(String name) {
        System.out.println("本厨师正在做：" + name);
    }
}
