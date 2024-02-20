import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

public class Streams implements Operations {

    private  Integer streamType;
    private  Integer id;
    private Integer streamGenre;
    private  Long noOfStreams;
    private Integer streamerId;
    private  Long length;
    private Long dateAdded;
    private  String name;
    public Streams() {

    }
    public Integer getStreamType() {
        return streamType;
    }

    public void setStreamType(Integer streamType) {
        this.streamType = streamType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStreamGenre() {
        return streamGenre;
    }

    public void setStreamGenre(Integer streamGenre) {
        this.streamGenre = streamGenre;
    }

    public Long getNoOfStreams() {
        return noOfStreams;
    }

    public void setNoOfStreams(Long noOfStreams) {
        this.noOfStreams = noOfStreams;
    }

    public Integer getStreamerId() {
        return streamerId;
    }

    public void setStreamerId(Integer streamerId) {
        this.streamerId = streamerId;
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    public Long getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Long dateAdded) {
        this.dateAdded = dateAdded;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "StreamType: " + streamType + " Id: " + id + " StreamGenre: " + streamGenre + " NoOfStreams: " + noOfStreams + " StreamerId: " + streamerId + " Length: " + length + " DateAdded: " + dateAdded + " Name: " + name;
    }

    public static void readFromCSV(String[] args) {
        try {
            CSVReader reader = new CSVReader(new FileReader("src/main/resources/" + args[1]));
            String[] line;
            reader.readNext();
            while ((line = reader.readNext()) != null) {
                StreamsList.getInstance().getStreams().add( new StreamsBuilder().withStreamType(line[0])
                        .withId(line[1]).withStreamGenre(line[2]).withNoOfStreams(line[3]).withStreamerId(line[4])
                        .withLength(line[5]).withDateAdded(line[6]).withName(line[7]).build());
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }

    public static Integer codificareType(String type) {
        if(type.equals("SONG")) {
            return 1;
        } else if( type.equals("PODCAST")) {
            return 2;
        } else {
            return 3;
        }
    }

    @Override
    public String convertData(Streams s) {
        Date date = new Date(s.getDateAdded() * 1000L);
        SimpleDateFormat simpleFormat = new SimpleDateFormat("dd-MM-yyyy");
        simpleFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return  simpleFormat.format(date);
    }

    @Override
    public String convertTime(Streams streams) {
        Duration duration = Duration.ofSeconds(streams.getLength());
        String time;
        long hours = duration.toHours();
        duration = duration.minusHours(hours);
        long minutes = duration.toMinutes();
        duration = duration.minusMinutes(minutes);
        long secs = duration.getSeconds();
        if (hours != 0) {
            time = String.format("%02d:%02d:%02d", hours, minutes, secs);
        } else {
            time = String.format("%02d:%02d", minutes, secs);
        }
        return time;
    }

    @Override
    public void sortStreams(ArrayList<Streams> arrayStreams) {
        arrayStreams.sort(Comparator.comparing(Streams :: getDateAdded));
        Collections.reverse(arrayStreams);
        for(int i = 0; i < arrayStreams.size(); i ++) {
            for(int j = i+1; j < arrayStreams.size(); j++) {
                if(arrayStreams.get(i).getDateAdded().equals(arrayStreams.get(j).getDateAdded()) &&
                        arrayStreams.get(i).getNoOfStreams().compareTo(arrayStreams.get(j).getNoOfStreams()) < 0)  {
                    {
                        Collections.swap(arrayStreams, i, j);

                    }
                }
            }
        }
    }

    public ArrayList<Streamers>  newArrayOfStreamers(User user) {
        ArrayList<Streamers> newStreamers = StreamersList.getInstance().getStreamers();
        for (Integer id : user.streams) {
            Streams stream = StreamsList.findStream(String.valueOf(id));
            for (int i = 0; i < StreamersList.getInstance().getStreamers().size(); i++) {
                if (StreamersList.getInstance().getStreamers().get(i).getId().equals(stream.getStreamerId())) {
                    newStreamers.remove(i);
                }
            }
        }
        return newStreamers;
    }

    @Override
    public void simplify(String streamerName, ArrayList<POJO> array, Streams stream) {

        Facade fatade = new Facade();
        String newdate =  fatade.convertD(stream);
        String time = fatade.convertT(stream);

        POJO pojo = new POJO(String.valueOf(stream.getId()), stream.getName(), streamerName,
                String.valueOf(stream.getNoOfStreams()), time, newdate);
        if (!array.contains(pojo)) {
            array.add(pojo);
        }
    }

    public void findStreamByStreamer(String[] l, ArrayList<POJO> array) {
        Facade fatade = new Facade();
        for (Streams s : StreamsList.getInstance().getStreams()) {
            if (s.getStreamerId().equals(Integer.parseInt(l[0]))) {
                fatade.simplify(StreamersList.findStreamers(l[0]).getName(), array, s);
            }
        }
    }

    public void findStreamByUser(String[] l, ArrayList<POJO> array) {
        Facade fatade = new Facade();
        for (Integer id : Objects.requireNonNull(UsersList.findUser(l[0])).streams) {
            Streams stream = StreamsList.findStream(String.valueOf(id));
            for (Streamers s : StreamersList.getInstance().getStreamers()) {
                assert stream != null;
                if (s.getId().equals(stream.getStreamerId())) {
                    fatade.simplify(s.getName(), array, stream);
                }
            }
        }
    }
}
