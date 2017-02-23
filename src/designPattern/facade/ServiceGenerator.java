package designPattern.facade;

/**
 * @author Kevin
 * @description
 * @date 2017/2/14
 */
public class ServiceGenerator extends BaseGenerator {

    @Override
    public void generate() {
        if (allow()) {
            System.out.println("generate services.");
        }
    }

    @Override
    public boolean allow() {
        return configModel.isGenerateService();
    }
}
