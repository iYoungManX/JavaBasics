package Junit;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @BeforeEach
    public void beforeEach(){
        System.out.println("====Before Each method=====");
    }

    @AfterEach
    public void afterEach(){
        System.out.println("====After Each method=====");
    }

    @BeforeAll
    public static void beforeAll(){
        System.out.println("====Before All method=====");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("========After All method======");
    }

    @Test
    void loginName() {
        User user= new User();
        String rs= user.loginName("admin","123456");
        Assert.assertEquals("You code might be wrong","Login Successful",rs);
    }

    @Test
    void selectName() {
        User user= new User();
        user.selectName();
    }
}