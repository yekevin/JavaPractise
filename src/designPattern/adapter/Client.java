package designPattern.adapter;

/**
 * @author Kevin
 * @description 将一个类的接口转换成客户希望的另一个接口，适配器模式使得原本由于接口不兼容而不能在一起工作的类可以一起工作
 * @date 2017/2/11
 */
public class Client {
    public static void main(String[] args) {
        MediaPlayer mediaPlayer = new AudioPlayer();
        mediaPlayer.play("mp3","1.mp3");
        mediaPlayer.play("mp4","2.mp4");
        mediaPlayer.play("vlc","3.vlc");

    }
}
