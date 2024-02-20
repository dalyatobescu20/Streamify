import java.io.IOException;

public abstract class Utils {

    public abstract  void  executa(String[] l, String[] args) throws IOException;
}

class makeLists extends  Utils {
    public void executa(String[] l, String[] args) {
        Streamers.readFromCSV(args);
        Streams.readFromCSV(args);
        User.readFromCSV(args);
    }
}

class clearData extends  Utils {
    public void executa(String[] l, String[] args) {
        StreamsList.getInstance().getStreams().clear();
        StreamersList.getInstance().getStreamers().clear();
        UsersList.getInstance().getUseri().clear();

    }
}
