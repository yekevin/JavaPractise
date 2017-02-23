package designPattern.facade;

/**
 * @author Kevin
 * @description
 * @date 2017/2/14
 */
public class ViewGenerator extends BaseGenerator {

    @Override
    public void generate() {
        if (allow()) {
            System.out.println("generate views.");
        }
    }

    @Override
    public boolean allow() {
        return configModel.isGenerateView();
    }
}
