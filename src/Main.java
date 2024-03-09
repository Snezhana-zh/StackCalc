package src;
import org.apache.commons.cli.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Options options = new Options();
        options.addOption("f", "file", true, "Input file");

        CommandLineParser parser = new BasicParser();
        InputStream in = System.in;
        try {
            CommandLine line = parser.parse(options, args);
            if (line.hasOption("file")) {
                String file = line.getOptionValue("file");
                System.out.println("Reading from " + file);
                in = new FileInputStream(file);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        Context context = new Context();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            CommandFactory factory = new CommandFactory();

            String line;
            while(null != (line = reader.readLine()) && !(line.isEmpty())) {
                if (line.startsWith("#")) {
                    continue;
                }
                var lineList = line.split(" ");
                if (lineList[0].equals("exit")) {
                    return;
                }
                var command = factory.findCommand(lineList[0]);
                if (command == null) {
                    System.out.println("Command not found");
                    continue;
                }
                command.execute(lineList, context);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CalcException e) {
            throw new RuntimeException(e);
        }
    }
}