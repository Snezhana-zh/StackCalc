package Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import src.CalcException;
import src.CommandFactory;
import src.Context;

public class TestPush {
    @Test
    public void testException() {
        CommandFactory factory = CommandFactory.getInstance();
        Context context = new Context();
        var command = factory.findCommand("push");
        String[] args = {"push", "a"};
        Assert.assertThrows(CalcException.class, () -> command.execute(args, context));
    }
    @Test
    public void testException2() throws CalcException {
        CommandFactory factory = CommandFactory.getInstance();
        Context context = new Context();
        var push = factory.findCommand("push");
        var define = factory.findCommand("define");
        String[] args = {"define", "a", "4.0"};
        define.execute(args, context);
        String[] args2 = {"push", "a"};
        push.execute(args2, context);
        Assert.assertEquals((Double)4.0, context.getStack().pop());
    }
}
