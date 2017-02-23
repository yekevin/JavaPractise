package designPattern.factoryMethod;

/**
 * @author Kevin
 * @description
 * @date 2017/2/13
 */
public class ExportTxtOperate extends ExportOperate {
    @Override
    public FileExportApi factoryMethod() {
        return new ExportTxt();
    }
}
