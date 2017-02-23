package designPattern.state1;

/**
 * @author Kevin
 * @description
 * @date 2017/2/16
 */
public class RepeatVoteState implements VoteState {
    @Override
    public void vote(String voteUser, String voteItem, VoteManager voteManager) {
        System.out.println("请不要重复投票");
    }
}
