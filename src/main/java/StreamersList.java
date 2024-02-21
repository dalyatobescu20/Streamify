import java.util.ArrayList;
public class StreamersList {

    private static StreamersList streamers;

   private ArrayList<Streamers> streamersList;

    public StreamersList() {
        this.streamersList = new ArrayList<>();
    }

    public static StreamersList getInstance() {
        if (streamers == null) {
            streamers = new StreamersList();
        }
        return streamers;
    }
    public static Streamers findStreamers(String id) {
        for(Streamers s: StreamersList.getInstance().streamersList) {
            if(s.getId().equals(Integer.parseInt(id))) {
                return s;
            }
        }
        return null;
    }

    public ArrayList<Streamers> getStreamers() {
        return this.streamersList;
    }

    public static String getStreamerName(Integer id) {
        for(Streamers s: StreamersList.getInstance().streamersList) {
            if(s.getId().equals(id)) {
                return s.getName();
            }
        }
        return null;
    }

}
