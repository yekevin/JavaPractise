package designPattern.factoryMethod;

/**
 * @author Kevin
 * @description
 * @date 2017/2/13
 */
public class ExportDBOperate extends ExportOperate {
    @Override
    public FileExportApi factoryMethod() {
        return new ExportDB();
    }
}
