package designPattern.state2;

/**
 * @author Kevin
 * @description
 * @date 2017/2/16
 */
public class RepeatVoteState implements VoteState {
    @Override
    public void vote(String voteUser, String voteItem, VoteManager voteManager) {
        System.out.println("请不要重复投票");
        if (voteManager.getMapVoteCount().get(voteUser) >= 4) {
            voteManager.getVoteStateMap().put(voteUser, new SpiteVoteState());
        }
    }
}
