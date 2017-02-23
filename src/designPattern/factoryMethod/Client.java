package designPattern.factoryMethod;

/**
 * @author Kevin
 * @description 定义一个用于创建对象的接口(FileExportApi)，让(ExportDBOperate)子类决定实例化哪一个类，Factory Method使一个类的实例化延迟到其子类。
 * @date 2017/2/13
 */
public class Client {

    public static void main(String[] args) {
        ExportOperate exportOperate = new ExportDBOperate();
        exportOperate.export("Hello World!");

        exportOperate = new ExportTxtOperate();
        exportOperate.export("Hello World!");
    }
}
