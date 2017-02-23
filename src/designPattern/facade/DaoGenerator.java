package designPattern.facade;

/**
 * @author Kevin
 * @description
 * @date 2017/2/14
 */
public class DaoGenerator extends BaseGenerator {
    @Override
    public void generate() {
        if (allow()) {
            System.out.println("generate daos.");
        }
    }

    @Override
    public boolean allow() {
        return configModel.isGenerateDao();
    }
}
