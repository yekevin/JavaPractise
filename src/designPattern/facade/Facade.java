package designPattern.facade;

/**
 * @author Kevin
 * @description
 * @date 2017/2/14
 */
public class Facade {
    public void generate() {
        Generator viewGenerator = new ViewGenerator();
        Generator controllerGenerator = new ControllerGenerator();
        Generator serviceGenerator = new ServiceGenerator();
        Generator daoGenerator = new DaoGenerator();

        viewGenerator.generate();
        controllerGenerator.generate();
        serviceGenerator.generate();
        daoGenerator.generate();
    }
}
