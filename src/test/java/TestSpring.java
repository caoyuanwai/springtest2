import com.caoyuanwai.spring.dao.BookDao;
import com.caoyuanwai.spring.entity.Book;
import com.caoyuanwai.spring.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class TestSpring {
    @Test
    public void addBook() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");
        Book book = new Book();
        book.setName("java");
        book.setStatus("bb");
        BookService bookService = (BookService) context.getBean("bookService");
        bookService.addBook(book);
    }

    @Test
    public void update() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");
        Book book = new Book();
        book.setId(1);
        book.setName("java");
        book.setStatus("aabb");
        BookService bookService = (BookService) context.getBean("bookService");
        bookService.update(book);
    }

    @Test
    public void findtCount() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        int i = bookService.findCount();
        System.out.println(i);
    }
    @Test
    public void findOne() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Book book = bookService.findOne(2);
        System.out.println(book);
    }
    @Test
    public void findAll() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        List<Book> bookList = bookService.findAll();
        System.out.println(bookList);
    }
    @Test
    public void batchAdd() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        List<Object[]> args = new ArrayList<>();
        Object[] o1 = {"java", "a"};
        Object[] o2 = {"c++", "b"};
        Object[] o3 = {"mysql", "c"};
        args.add(o1);
        args.add(o2);
        args.add(o3);
        bookService.batchAdd(args);
    }
    @Test
    public void batchUpdate() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        List<Object[]> args = new ArrayList<>();
        Object[] o1 = {"java1", "a1", "4"};
        Object[] o2 = {"c++1", "b1", "5"};
        Object[] o3 = {"mysql1", "c1", "6"};
        args.add(o1);
        args.add(o2);
        args.add(o3);
        bookService.batchUpdate(args);
    }
    @Test
    public void batchDelete() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        List<Object[]> args = new ArrayList<>();
        Object[] o1 = {"4"};
        Object[] o2 = {"5"};
//        Object[] o3 = {"6"};
        args.add(o1);
        args.add(o2);
//        args.add(o3);
        bookService.batchDelete(args);
    }

}
