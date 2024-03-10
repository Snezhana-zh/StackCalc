package Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import src.CalcException;
import src.CommandFactory;
import src.Context;

public class TestPop {
    @Test
    public void testException() {
        CommandFactory factory = CommandFactory.getInstance();
        Context context = new Context();
        var command = factory.findCommand("pop");
        String[] args = {"pop"};
        Assert.assertThrows(CalcException.class, () -> command.execute(args, context));
    }
}
