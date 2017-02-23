package designPattern.state2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kevin
 * @description
 * @date 2017/2/16
 */
public class VoteManager {

    private Map<String, String> mapVote = new HashMap<>();
    private Map<String, Integer> mapVoteCount = new HashMap<>();
    private Map<String, VoteState> voteStateMap = new HashMap<>();

    public Map<String, String> getMapVote() {
        return mapVote;
    }

    public Map<String, Integer> getMapVoteCount() {
        return mapVoteCount;
    }

    public Map<String, VoteState> getVoteStateMap() {
        return voteStateMap;
    }

    public void vote(String voteUser, String voteItem) {
        Integer voteCount = mapVoteCount.get(voteUser);
        if (voteCount == null) {
            voteCount = 0;
        }
        voteCount++;
        mapVoteCount.put(voteUser, voteCount);

        VoteState voteState = voteStateMap.get(voteUser);
        if (voteState == null) {
            voteState = new NormalVoteState();
            voteStateMap.put(voteUser, voteState);
        }
        voteState.vote(voteUser, voteItem, this);
    }
}
