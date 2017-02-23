package designPattern.state1;

/**
 * @author Kevin
 * @description
 * @date 2017/2/16
 */
public interface VoteState {

    public void vote(String voteUser, String voteItem, VoteManager voteManager);
}
