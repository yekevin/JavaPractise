package designPattern.abstractFactory;

/**
 * @author Kevin
 * @description
 * @date 2017/2/11
 */
public class UnixFactory implements AbstractFactory {
    @Override
    public Button createButton() {
        return new UnixButton();
    }

    @Override
    public Text createText() {
        return new UnixText();
    }
}
