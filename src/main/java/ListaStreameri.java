import java.util.ArrayList;
public class ListaStreameri {

    private static ListaStreameri streamers;

   private ArrayList<Streamers> streamersList;

    public ListaStreameri() {
        this.streamersList = new ArrayList<>();
    }

    public static ListaStreameri getInstance() {
        if (streamers == null) {
            streamers = new ListaStreameri();
        }
        return streamers;
    }
    public static Streamers findStreamers(String id) {
        for(Streamers s: ListaStreameri.getInstance().streamersList) {
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
        for(Streamers s: ListaStreameri.getInstance().streamersList) {
            if(s.getId().equals(id)) {
                return s.getName();
            }
        }
        return null;
    }

}
