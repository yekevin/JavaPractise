package designPattern.command3;


/**
 * @author Kevin
 * @description
 * @date 2017/2/14
 */
public class HotCook implements CookApi, Runnable {
    private String cookerName;

    public HotCook(String cookerName) {
        this.cookerName = cookerName;
    }

    @Override
    public void cook(String tableNum, String name) {
        int cookTime = (int) (20 * Math.random());
        System.out.println(this.cookerName + "厨师正在为" + tableNum
                + "号桌做：" + name);
        try {
            //让线程休息这么长时间，表示正在做菜
            Thread.sleep(cookTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.cookerName + "厨师为" + tableNum
                + "号桌做好了：" + name + ",共计耗时=" + cookTime + "秒");
    }

    @Override
    public void run() {
        while (true) {
            Command cmd = CommandQueue.getOneComamnd();
            if(cmd == null){
                continue;
            }
            cmd.setCookApi(this);
            cmd.execute();
            try {
                Thread.sleep(1000L);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
