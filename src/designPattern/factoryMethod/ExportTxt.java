package designPattern.factoryMethod;

/**
 * @author Kevin
 * @description
 * @date 2017/2/13
 */
public class ExportTxt implements FileExportApi {
    @Override
    public boolean export(String data) {
        System.out.println("export data " + data + " to txt");
        return true;
    }
}
