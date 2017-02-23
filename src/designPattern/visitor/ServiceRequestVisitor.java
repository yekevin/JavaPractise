package designPattern.visitor;

/**
 * @author Kevin
 * @description
 * @date 2017/2/22
 */
public class ServiceRequestVisitor implements Visitor {
    @Override
    public void visitEnterpriseCustomer(EnterpriseCustomer customer) {
        System.out.println(customer.getName() + "企业提出服务请求");
    }

    @Override
    public void visitPersonalCustomer(PersonalCustomer customer) {
        System.out.println("客户" + customer.getName() + "提出服务请求");
    }
}
