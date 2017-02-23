package designPattern.abstractFactory;

/**
 * @author Kevin
 * @description
 * @date 2017/2/11
 */
public class WindowsFactory implements AbstractFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Text createText() {
        return new WindowsText();
    }
}
