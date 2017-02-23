package designPattern.state2;

/**
 * @author Kevin
 * @description
 * @date 2017/2/16
 */
public class BlackVoteState implements VoteState {
    @Override
    public void vote(String voteUser, String voteItem, VoteManager voteManager) {
        //黑名单
        //记入黑名单中，禁止登录系统了
        System.out.println("进入黑名单，将禁止登录和使用本系统");
    }
}
