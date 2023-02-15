import java.util.ArrayList;

public interface Operations {

    String convertData(Streams streams);

    String convertTime(Streams streams);

    void sortStreams(ArrayList<Streams> s);

    ArrayList<Streamers> newArrayOfStreamers(User user);

    void simplify(String streamerName, ArrayList<POJO> array, Streams stream);
    public void findStreamByStreamer(String[] l, ArrayList<POJO> array);
    public void findStreamByUser(String[] l, ArrayList<POJO> array);

}
