package designPattern.factoryMethod;

/**
 * @author Kevin
 * @description
 * @date 2017/2/13
 */
public abstract class ExportOperate {

    public boolean export(String data) {
        FileExportApi fileExportApi = factoryMethod();
        return fileExportApi.export(data);
    }

    public abstract FileExportApi factoryMethod();
}
