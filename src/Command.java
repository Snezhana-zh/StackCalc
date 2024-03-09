package src;
public interface Command {
    void execute(String[] args, Context context) throws CalcException;
}
