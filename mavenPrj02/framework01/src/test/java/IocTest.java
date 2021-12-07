import edu.soft2.ioc.coffee.CoffeeBean;
import edu.soft2.ioc.coffee.CoffeeMachine;
import edu.soft2.ioc.print.Printer;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IocTest {
    //ApplicationContext : 允许容器通过应用程序上下文环境创建、获取、管理bean。
    //ClassPathXmlApplicationContext : 创建的Spring 的 IOC 容器。
    //1.获取上下文(context)对象
    ApplicationContext context =
            new ClassPathXmlApplicationContext("applicationContext.xml");
    @Test
    public void coffeeTest() {
        //2.context对象(封装了BeanFactory)
//        CoffeeBean coffeeBean = (CoffeeBean) context.getBean("espressoBean");//注入
//        coffeeBean.drink();
        CoffeeMachine machine = (CoffeeMachine) context.getBean("coffeeMachine");
        machine.make();
    }
    @Test
    public void testPrinter(){
        Printer printer = (Printer) context.getBean("printer");
        printer.print();
    }
}

