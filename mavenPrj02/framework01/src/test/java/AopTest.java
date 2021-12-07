import edu.soft2.pojo.User;
import edu.soft2.service.UserService;
import edu.soft2.service.impl.HelloworldService;
import edu.soft2.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class AopTest {
    int expected;//预期结果
    String name;//方法参数
    String pwd;//方法参数
    public  AopTest(int expected,String name,String pwd){
        this.expected = expected;
        this.name = name;
        this.pwd = pwd;
    }
    @Parameterized.Parameters
    public static Collection<Object[]> t() {//测试数据
        return Arrays.asList(new Object[][]{
                {1,"peter","123"},
                {1,"john","456"},
                {1,"steven","789"}
        });
    }
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    @Test
    public void helloworldTest() {
        HelloworldService helloworldService = (HelloworldService) context.getBean("helloworldService");
        helloworldService.sayHello();//调用
        helloworldService.sayHi();
    }

    @Test
    public void helloworldServiceTest() {
        HelloworldService helloworldService
                = (HelloworldService) context.getBean("helloworldService");//注入对象
        helloworldService.sayHi();//调用方法
        helloworldService.sayHello();//调用方法
    }

    @Test
    public void userServiceTest() {
        String id = "1";
        String name = "peter";
        String pwd = "123";
        UserService service = (UserService) context.getBean(UserServiceImpl.class);
        User user = (User) context.getBean(User.class);
        user.setName(name); user.setPwd(pwd);
        /**
         * 添加用户
         */
     /*   if (service.addUser(user) == 1) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }*/
       /* int result = service.addUser(user);
        System.out.println(result);*/

        /**
 * 删除用户
 */
    /*    if (service.deleteUser(user) == 1) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }*/
        /**
 * 修改用户
 */
       /* if (service.updateUser(user) == 1) {
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }*/
        /**
 * 查找用户
 */
       User user1 = service.findAllUser();
        System.out.println(user1);
    }
}
