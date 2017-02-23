package designPattern.state1;

/**
 * @author Kevin
 * @description
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
