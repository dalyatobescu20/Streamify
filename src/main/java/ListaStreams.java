import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListaStreams {

    private static ListaStreams streams;

    private ArrayList<Streams> streamsList;

    public ListaStreams() {
        this.streamsList = new ArrayList<>();
    }

    public static ListaStreams getInstance() {
        if (streams == null) {
            streams = new ListaStreams();
        }
        return streams;
    }

    public static Streams findStream(String id) {
        for(Streams s: ListaStreams.getInstance().streamsList) {
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
        ListaStreams.getInstance().streamsList.sort(Comparator.comparing(Streams::getDateAdded));
        Collections.reverse(ListaStreams.getInstance().streamsList);
        for(int i = 0; i < ListaStreams.getInstance().streamsList.size();i++) {
            for(int j = i+1; j < ListaStreams.getInstance().streamsList.size();j++) {
                if(ListaStreams.getInstance().streamsList.get(i).getDateAdded().equals(ListaStreams.getInstance().streamsList.get(j).getDateAdded()) &&
                        ListaStreams.getInstance().streamsList.get(i).getNoOfStreams().compareTo(ListaStreams.getInstance().streamsList.get(j).getNoOfStreams()) < 0)  {
                    {
                        Collections.swap(ListaStreams.getInstance().streamsList, i, j);

                    }
                }
            }
        }
    }


}
