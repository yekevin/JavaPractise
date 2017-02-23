package designPattern.facade;

/**
 * @author Kevin
 * @description
 * @date 2017/2/14
 */
public abstract class BaseGenerator implements Generator {

    protected static ConfigModel configModel = ConfigManager.getInstance().getConfigModel();

}
