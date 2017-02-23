package designPattern.facade;

/**
 * @author Kevin
 * @description
 * @date 2017/2/14
 */
public class ConfigManager {

    public static ConfigManager configManager = null;
    private ConfigModel configModel;

    public static synchronized ConfigManager getInstance() {
        if (configManager != null) {
            return configManager;
        }
        configManager = new ConfigManager();
        // read from config file init configModel
        configManager.configModel = new ConfigModel();
        return configManager;
    }

    public ConfigModel getConfigModel() {
        return configModel;
    }
}
