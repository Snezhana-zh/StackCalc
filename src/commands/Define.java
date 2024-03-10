package src.commands;

import src.CalcException;
import src.Command;
import src.Context;

public class Define implements Command {
    @Override
    public void execute(String[] args, Context context) throws CalcException {
        if (args.length < 3) {
            throw new CalcException("Incorrect definition!");
        }
        context.getDefinition().put(args[1], Double.valueOf(args[2]));
    }
}
