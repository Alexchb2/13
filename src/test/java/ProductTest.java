import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductTest {
    public ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);
    public Product item1 = new Book(1, "Война и мир", 3000, "Толстой");
    public Product item2 = new Smartphone(2, "Iphone 13", 90000, "Apple");
    public Product item3 = new Smartphone(3, "Iphone 12", 80000, "Apple");
    private ProductManager manger;


    @BeforeEach
    public void setUp() {
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
//        manager.add(item1);
//        manager.add(item2);
//        manager.add(item3);

    }

    @Test
    public void test() {

        repo.findAll();

        Product[] expected = {item1, item2, item3};
        Product[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test2() {
        repo.findAll();
        Product[] expected = {item1, item2, item3};
        Assertions.assertArrayEquals(expected, repo.getItems());
    }

    @Test
    public void test3() {
        repo.removeById(2);
        Product[] expected = {item1, item3};
        Assertions.assertArrayEquals(expected, repo.getItems());
    }

    @Test
    public void test4() {
        Product[] expected = {item1};
        Product[] actual = manger.searchBy("Война и мир");

        Assertions.assertArrayEquals(expected, actual);
    }

}

