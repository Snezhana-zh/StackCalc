package src.commands;

import src.CalcException;
import src.Command;
import src.Context;

import java.util.Deque;

public class Sqrt implements Command {
    public void execute(String[] args, Context context) throws CalcException {
        Deque<Double> stack = context.getStack();
        if (stack.isEmpty()) {
            throw new CalcException("Not enough args!");
        }
        else {
            double var = stack.removeFirst();
            if (var < 0) throw new CalcException("Negative value!");
            stack.add(Math.sqrt(var));
        }
    }
}
