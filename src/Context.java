package src;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Context {
    private Deque<Double> stack = new ArrayDeque<>();
    private Map<String, Double> definition = new HashMap<>();
    public Deque<Double> getStack() {
        return stack;
    }
    public Map<String, Double> getDefinition() {
        return definition;
    }
}
