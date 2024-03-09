package src.commands;

import src.CalcException;
import src.Command;
import src.Context;

public class Define implements Command {
    @Override
    public void execute(String[] args, Context context) throws CalcException {
        var map = context.getDefinition();
        if (args.length < 3) {
            throw new CalcException("Incorrect definition!");
        }
        map.put(args[1], Double.valueOf(args[2]));
    }
}
