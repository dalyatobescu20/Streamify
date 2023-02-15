import java.util.ArrayList;

public class Fatade {

    private Operations streams;

    public Fatade() {
        streams = new Streams();
    }

    public String convertD(Streams streams) {
        return  streams.convertData(streams);
    }

    public String convertT(Streams streams) {
        return streams.convertTime(streams);
    }

    public void sortStreams(ArrayList<Streams> s) {
        streams.sortStreams(s);
    }

    public ArrayList<Streamers> newArrayOfStreamers(User user) {

        return streams.newArrayOfStreamers(user) ;
    }

    void simplify(String streamerName, ArrayList<POJO> array, Streams stream) {
        streams.simplify(streamerName, array, stream);
    }

    public void findStreamByStreamer(String[] l, ArrayList<POJO> array) {
        streams.findStreamByStreamer(l,array);
    }

    public void findStreamByUser(String[] l, ArrayList<POJO> array) {
        streams.findStreamByUser(l, array);
    }
}
