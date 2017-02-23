package designPattern.visitor;

/**
 * @author Kevin
 * @description
 * @date 2017/2/22
 */
public interface Visitor {

    public void visitEnterpriseCustomer(EnterpriseCustomer customer);

    public void visitPersonalCustomer(PersonalCustomer customer);
}
