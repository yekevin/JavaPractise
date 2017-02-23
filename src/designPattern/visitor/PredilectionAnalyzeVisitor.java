package designPattern.visitor;

/**
 * @author Kevin
 * @description
 * @date 2017/2/22
 */
public class PredilectionAnalyzeVisitor implements Visitor {
    @Override
    public void visitEnterpriseCustomer(EnterpriseCustomer customer) {
        System.out.println("现在对企业客户" + customer.getName()
                + "进行产品偏好分析");
    }

    @Override
    public void visitPersonalCustomer(PersonalCustomer customer) {
        System.out.println("现在对个人客户" + customer.getName()
                + "进行产品偏好分析");
    }
}
