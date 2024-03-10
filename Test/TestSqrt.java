package Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import src.CalcException;
import src.CommandFactory;
import src.Context;

public class TestSqrt {
    @Test
    public void test1() throws CalcException {
        CommandFactory factory = CommandFactory.getInstance();
        Context context = new Context();
        var command = factory.findCommand("sqrt");
        context.getStack().add(484.0);
        command.execute(null, context);
        Assert.assertEquals(22.0, context.getStack().pop());
    }
    @Test
    public void testException() {
        CommandFactory factory = CommandFactory.getInstance();
        Context context = new Context();
        var command = factory.findCommand("sqrt");
        context.getStack().add(-1.0);
        Assert.assertThrows(CalcException.class, () -> command.execute(null, context));
    }
    @Test
    public void testException2() throws CalcException {
        CommandFactory factory = CommandFactory.getInstance();
        Context context = new Context();
        var command = factory.findCommand("sqrt");
        Assert.assertThrows(CalcException.class, () -> command.execute(null, context));
    }
}
