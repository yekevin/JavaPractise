package designPattern.state1;

/**
 * @author Kevin
 * @description
 * @date 2017/2/16
 */
public class SpiteVoteState implements VoteState {
    @Override
    public void vote(String voteUser, String voteItem, VoteManager voteManager) {
        //恶意投票
        //取消用户的投票资格，并取消投票记录
        String s = voteManager.getMapVote().get(voteUser);
        if (s != null) {
            voteManager.getMapVote().remove(voteUser);
        }
        System.out.println("你有恶意刷票行为，取消投票资格");
    }
}
