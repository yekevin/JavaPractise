package designPattern.visitor;

/**
 * @author Kevin
 * @description
 * @date 2017/2/22
 */
public class PersonalCustomer extends Customer {

    private String telephone;
    private int age;

    @Override
    public void accept(Visitor visitor) {
        visitor.visitPersonalCustomer(this);
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
