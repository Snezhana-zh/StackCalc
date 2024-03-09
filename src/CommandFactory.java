package src;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class CommandFactory {
    private Map<String, Command> commands = new HashMap<>();
    public Command findCommand(String key_command) {
        return commands.get(key_command);
    }
    public CommandFactory() {
        InputStream in = null;
        try {
            in = Main.class.getResourceAsStream("properties");
            Properties prop = new Properties();
            prop.load(in);
            for (String key : prop.stringPropertyNames()) {
                String class_name = prop.getProperty(key);
                var cur_command = (Command)(Class.forName(class_name).getDeclaredConstructor().newInstance());
                Command command = new Command() {
                    @Override
                    public void execute(String[] args, Context context) {
                        try {
                            cur_command.execute(args, context);
                        } catch (CalcException e) {
                            e.printStackTrace();
                        }
                    }
                };
                commands.put(key, command);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };
}
