package designPattern.prototype;

/**
 * @author Kevin
 * @description
 * @date 2017/2/11
 */
public abstract class Shape implements Cloneable {
    protected String id;
    protected String type;

    @Override
    protected Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
