package ioc;

/**
 * @author Kevin
 * @description
 * @date 2017/3/9
 */
public class IocTest {

    private static Container container = new SimpleContainer();

    public static void main(String[] args) {
        container.registBean(TestController.class);
        container.initWired();

        TestController controller = container.getBean(TestController.class);
        controller.controller();
    }

    public static class TestController {
        // 指定class方式
        // @Autowired(value = TestService.class)
        // 指定名称方式
        // @Autowired(name = "testService")
        // 默认根据字段类型注入
        @Autowired
        private TestService testService;

        public void controller() {
            System.out.println("test controller is invoke");
            testService.service();
        }
    }

    public static class TestService {
        public void service() {
            System.out.println("test service is invoke");
        }
    }
}
