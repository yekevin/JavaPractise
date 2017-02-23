package designPattern.facade;

/**
 * @author Kevin
 * @description
 * @date 2017/2/14
 */
public class ConfigModel {

    private boolean generateView = true;

    private boolean generateController = true;

    private boolean generateService = true;

    private boolean generateDao = true;

    public boolean isGenerateView() {
        return generateView;
    }

    public void setGenerateView(boolean generateView) {
        this.generateView = generateView;
    }

    public boolean isGenerateController() {
        return generateController;
    }

    public void setGenerateController(boolean generateController) {
        this.generateController = generateController;
    }

    public boolean isGenerateService() {
        return generateService;
    }

    public void setGenerateService(boolean generateService) {
        this.generateService = generateService;
    }

    public boolean isGenerateDao() {
        return generateDao;
    }

    public void setGenerateDao(boolean generateDao) {
        this.generateDao = generateDao;
    }
}
