package designPattern.adapter;

/**
 * @author Kevin
 * @description
 * @date 2017/2/11
 */
public class Mp4Player implements AdvancedMediaPlayer {

    @Override
    public void playAdvanced(String fileName) {
        System.out.println("playing mp4 with " + fileName);
    }
}
