package designPattern.state1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kevin
 * @description
 * @date 2017/2/16
 */
public class VoteManager {

    private VoteState voteState;
    private Map<String, String> mapVote = new HashMap<>();
    private Map<String, Integer> mapVoteCount = new HashMap<>();

    public Map<String, String> getMapVote() {
        return mapVote;
    }

    public void vote(String voteUser, String voteItem) {
        Integer voteCount = mapVoteCount.get(voteUser);
        if (voteCount == null) {
            voteCount = 0;
        }
        voteCount++;
        mapVoteCount.put(voteUser, voteCount);
        if (voteCount == 1) {
            voteState = new NormalVoteState();
        } else if (voteCount > 1 && voteCount < 5) {
            voteState = new RepeatVoteState();
        } else if (voteCount >= 5 && voteCount < 8) {
            voteState = new SpiteVoteState();
        } else if (voteCount >= 8) {
            voteState = new BlackVoteState();
        }

        voteState.vote(voteUser, voteItem, this);
    }
}
