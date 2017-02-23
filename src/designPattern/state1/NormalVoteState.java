package designPattern.state1;

/**
 * @author Kevin
 * @description
 * @date 2017/2/16
 */
public class NormalVoteState implements VoteState {
    @Override
    public void vote(String voteUser, String voteItem, VoteManager voteManager) {
        voteManager.getMapVote().put(voteUser, voteItem);
        System.out.println("投票成功!");
    }
}
