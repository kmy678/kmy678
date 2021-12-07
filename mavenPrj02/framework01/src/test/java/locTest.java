import edu.soft2.ioc.print.Printer;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class locTest {
    ApplicationContext context =
            new ClassPathXmlApplicationContext("applicationContext.xml");
    @Test
//    public void testCoffee(){
//        CoffeeMachine mach/ine = (CoffeeMachine) context.getBean("coffeeMachine");
//        machine.make();
//    }
    public void testPrinter(){
        Printer printer = (Printer) context.getBean("printer");
        printer.print();
    }
}
