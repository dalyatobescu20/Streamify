import java.io.*;

public class Main {
    public static void main(String[] args) {
        if (args == null) {
            System.out.println("Nothing to read here");

        } else {
            try {
                BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/" + args[3]));
                makeLists lists = new makeLists();
                lists.executa(null, args);
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] l = line.split(" ");
                    FactoryCommands factory = new FactoryCommands();
                    Commands comm = factory.choose(l[1]);
                    comm.executa(l);
                }
                reader.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            clearData clear = new clearData();
            clear.executa(null, args);
        }

    }

}
