import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.ArrayList;

public class Streamers {

    private Integer streamerType;
    private Integer id;
    private String name;

    public Streamers() {

    }
    public Integer getStreamerType() {
        return streamerType;
    }

    public void setStreamerType(Integer streamerType) {
        this.streamerType = streamerType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "StreamerType: " + streamerType +
                ", Id: " + id + ", Name: " + name;
    }
    public static void readFromCSV(String[] args) {
            try {
                CSVReader reader = new CSVReader(new FileReader("src/main/resources/" + args[0]));
                String[] line;
                reader.readNext();
                while ((line = reader.readNext()) != null) {
                    ListaStreameri.getInstance().getStreamers().add(new StreamersBuilder()
                            .setStreamerType(Integer.parseInt(line[0])).setId(Integer.parseInt(line[1]))
                            .setName(line[2]).build());
                }
                reader.close();
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (CsvValidationException e) {
                System.out.println("Error: " + e.getMessage());
            }
    }



}
