package designPattern.adapter;

/**
 * @author Kevin
 * @description
 * @date 2017/2/11
 */
public class VlcPlayer implements AdvancedMediaPlayer {

    @Override
    public void playAdvanced(String fileName) {
        System.out.println("playing vlc with " + fileName);
    }
}
