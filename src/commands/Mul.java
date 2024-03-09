package src.commands;

import src.CalcException;
import src.Command;
import src.Context;

import java.util.Deque;

public class Mul implements Command {
    public void execute(String[] args, Context context) throws CalcException {
        Deque<Double> stack = context.getStack();
        if (stack.size() < 2) {
            throw new CalcException("Not enough args!");
        }
        else {
            double var1 = stack.removeFirst();
            double var2 = stack.removeFirst();
            stack.add(var1 * var2);
        }
    }
}
