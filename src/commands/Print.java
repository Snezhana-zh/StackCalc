package src.commands;

import src.CalcException;
import src.Command;
import src.Context;

import java.util.Deque;

public class Print implements Command {
    @Override
    public void execute(String[] args, Context context) throws CalcException {
        Deque<Double> stack = context.getStack();
        if (stack.isEmpty()) {
            throw new CalcException("Stack is empty!");
        }
        System.out.println(stack.getFirst());
    }
}
