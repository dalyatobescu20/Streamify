import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

public class User {

    private Integer id;
    private String name;
    public List<Integer> streams = new ArrayList<>();
    public User() {

    }
    public User(Integer id, String name, List<Integer> streams) {
        this.id = id;
        this.name = name;
        this.streams = streams;
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
    public List<Integer> getStreams() {
        return streams;
    }

    public void setStreams(Integer streams) {
        this.streams.add(streams);
    }

    @Override
    public String toString() {
        return "Id: " + id + " Name: " + name + " Streams: " + streams;
    }

    public static void readFromCSV(String[] args) {
        try {
            CSVReader reader = new CSVReader(new FileReader("src/main/resources/" + args[2]));
            String[] line;
            reader.readNext();
            while ((line = reader.readNext()) != null) {
                Integer[] streamsInt = Arrays.stream(line[2].split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
                            UsersList.getInstance().getUseri().add(new UsersBuilder().withId(Integer.parseInt(line[0]))
                            .withName(line[1]).withStreams(streamsInt).build());
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }

}
