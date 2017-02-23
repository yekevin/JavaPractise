package designPattern.adapter;

/**
 * @author Kevin
 * @description
 * @date 2017/2/11
 */
public class MediaAdapter implements MediaPlayer {
    private AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String audioType) {
        if ("vlc".equalsIgnoreCase(audioType)) {
            advancedMediaPlayer = new VlcPlayer();
        } else if ("mp4".equalsIgnoreCase(audioType)) {
            advancedMediaPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if (advancedMediaPlayer != null) {
            advancedMediaPlayer.playAdvanced(fileName);
        }
    }
}
