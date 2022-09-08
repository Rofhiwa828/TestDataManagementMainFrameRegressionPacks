import com.jagacy.util.JagacyException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainFrameTest {

    private static Object JagecyClass;

    @Test
    public void LoginTest() throws JagacyException, InterruptedException {

        System.setProperty("sessionA.window", "true");
        JagecyClass login = new JagecyClass();
        login.open();
        Assert.assertTrue(login.userLogin("ab020xd","absarm06"));
    }

}
