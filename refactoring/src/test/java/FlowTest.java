import com.puhui.refactoring.vo.Customer;
import com.puhui.refactoring.vo.Movie;
import com.puhui.refactoring.vo.Rental;
import org.junit.Test;

/**
 * Created by wentong on 2016/5/11.
 * 流程测试
 */
public class FlowTest {

    /**
     * 整体测试，重构第一步就是先写测试用例
     */
    @Test
    public void test1() {
        Customer customer1 = new Customer("第一个顾客");
        Customer customer2 = new Customer("第一个顾客");
        Customer customer3 = new Customer("第一个顾客");
        Customer customer4 = new Customer("第一个顾客");
        Customer customer5 = new Customer("第一个顾客");

        Movie movie1 = new Movie("普通片", Movie.REGULAR);
        Movie movie2 = new Movie("儿童片", Movie.CHILDRENS);
        Movie movie3 = new Movie("新片1", Movie.NEW_RELEASE);
        Movie movie4 = new Movie("新片2", Movie.NEW_RELEASE);
        Movie movie5 = new Movie("普通片1", Movie.REGULAR);
        Movie movie6 = new Movie("儿童片1", Movie.CHILDRENS);
        Movie movie7 = new Movie("新片3", Movie.NEW_RELEASE);
        Movie movie8 = new Movie("新片4", Movie.NEW_RELEASE);

        Rental rental1 = new Rental(movie1, 4);
        Rental rental2 = new Rental(movie2, 1);
        Rental rental8 = new Rental(movie3, 2);
        Rental rental3 = new Rental(movie4, 5);
        Rental rental4 = new Rental(movie5, 6);
        Rental rental5 = new Rental(movie6, 10);
        Rental rental6 = new Rental(movie7, 11);
        Rental rental7 = new Rental(movie6, 2);

        customer1.addRental(rental1);
        customer1.addRental(rental2);
        customer1.addRental(rental3);
        customer1.addRental(rental4);
        customer1.addRental(rental5);
        customer1.addRental(rental6);
        customer1.addRental(rental7);
        customer1.addRental(rental8);

        customer2.addRental(rental1);
        customer2.addRental(rental2);
        customer2.addRental(rental3);
        customer2.addRental(rental4);
        customer2.addRental(rental5);
        customer2.addRental(rental6);
        customer2.addRental(rental7);
        customer2.addRental(rental8);

        String statement = customer1.statement();
        System.out.println(statement);
        System.out.println("==============");
        String statement1 = customer2.statement();
        System.out.println(statement1);
    }
}
