import com.caoyuanwai.spring.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
    @Test
    public void testAccount() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();
    }
}
