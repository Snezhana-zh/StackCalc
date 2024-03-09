package src.commands;

import src.CalcException;
import src.Command;
import src.Context;

public class Push implements Command {
    @Override
    public void execute(String[] args, Context context) throws CalcException {
        if(Character.isAlphabetic(args[1].charAt(0))) {
            var v = context.getDefinition().get(args[1]);
            if (v == null) throw new CalcException("Can't find definition!");
            context.getStack().add(v);
        }
        else {
            context.getStack().add(Double.valueOf(args[1]));
        }
    }
}
