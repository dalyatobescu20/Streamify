import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StreamsList {

    private static StreamsList streams;

    private ArrayList<Streams> streamsList;

    public StreamsList() {
        this.streamsList = new ArrayList<>();
    }

    public static StreamsList getInstance() {
        if (streams == null) {
            streams = new StreamsList();
        }
        return streams;
    }

    public static Streams findStream(String id) {
        for(Streams s: StreamsList.getInstance().streamsList) {
                if(s.getId().equals(Integer.parseInt(id))) {
                    return s;
            }
        }
        return null;
    }

    public ArrayList<Streams> getStreams() {
        return this.streamsList;
    }

    public static void sort() {
        StreamsList.getInstance().streamsList.sort(Comparator.comparing(Streams::getDateAdded));
        Collections.reverse(StreamsList.getInstance().streamsList);
        for(int i = 0; i < StreamsList.getInstance().streamsList.size(); i++) {
            for(int j = i+1; j < StreamsList.getInstance().streamsList.size(); j++) {
                if(StreamsList.getInstance().streamsList.get(i).getDateAdded().equals(StreamsList.getInstance().streamsList.get(j).getDateAdded()) &&
                        StreamsList.getInstance().streamsList.get(i).getNoOfStreams().compareTo(StreamsList.getInstance().streamsList.get(j).getNoOfStreams()) < 0)  {
                    {
                        Collections.swap(StreamsList.getInstance().streamsList, i, j);

                    }
                }
            }
        }
    }


}
