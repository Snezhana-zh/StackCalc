package Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import src.CalcException;
import src.CommandFactory;
import src.Context;

public class TestMul {
    @Test
    public void test1() throws CalcException {
        CommandFactory factory = CommandFactory.getInstance();
        Context context = new Context();
        var command = factory.findCommand("*");
        context.getStack().add(500.0);
        context.getStack().add(0.05);
        command.execute(null, context);
        Assert.assertEquals(25.0, context.getStack().pop());
    }
    @Test
    public void testException() {
        CommandFactory factory = CommandFactory.getInstance();
        Context context = new Context();
        var command = factory.findCommand("*");
        context.getStack().add(500.0);
        Assert.assertThrows(CalcException.class, () -> command.execute(null, context));
    }
    @Test
    public void testException2() throws CalcException {
        CommandFactory factory = CommandFactory.getInstance();
        Context context = new Context();
        var command = factory.findCommand("*");
        Assert.assertThrows(CalcException.class, () -> command.execute(null, context));
    }
}
