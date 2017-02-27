package designPattern.state1;

/**
 * @author Kevin
 * @description 允许一个对象在其内部状态改变时改变他的行为。对象看起来似乎修改了他的类。
 * 把每个状态所对应的功能处理封装在一个独立的类里面，这样选择不同处理的时候，其实就是在选择不同的状态处理类。
 * 定义一个状态接口来约束它们，这样外部就可以面向这个统一的状态接口编程，而无需关心具体的状态类实现了。
 * @date 2017/2/16
 */
public class Client {

    public static void main(String[] args) {
        VoteManager voteManager = new VoteManager();
        voteManager.vote("kevin","1");
        voteManager.vote("kevin","1");
        voteManager.vote("kevin","1");
        voteManager.vote("kevin","1");
        voteManager.vote("kevin","1");
        voteManager.vote("kevin","1");
        voteManager.vote("kevin","1");
        voteManager.vote("kevin","1");
        voteManager.vote("kevin","1");
    }
}
