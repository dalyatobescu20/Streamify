import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.util.*;

public abstract class Commands {
    public abstract void executa(String[] l) throws IOException;
}

class ComandaAdaugare extends Commands {
    @Override
    public void executa(String[] l) {
        StringBuilder name1 = new StringBuilder();
        for (int i = 0; i < l.length; ++i) {
            name1.append(l[i]);
        }
        String str = name1.toString();
        Streams streams = new StreamsBuilder().withStreamType(l[2])
                .withId(l[3]).withStreamGenre(l[4]).withNoOfStreams("0").withStreamerId(l[0])
                .withLength(l[5]).withDateAdded("0").withName(str).build();
        ListaStreams.getInstance().getStreams().add(streams);
    }
}

class ComandaStergere extends  Commands {
    public void executa(String[] l) {
        Streams s = ListaStreams.findStream(l[2]);
        ListaStreams.getInstance().getStreams().remove(s);
        for (User user : ListaUseri.getInstance().getUseri()) {
            for (int i = 0; i < user.streams.size(); i++) {
                if (user.streams.get(i).equals(s.getId())) {
                    user.streams.remove(i);
                }
            }
        }
    }
}
class ComandaAfisare extends  Commands {
    public void executa(String[] l) throws  IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<POJO> array = new ArrayList<>();
        Fatade fatade = new Fatade();

        if (ListaStreameri.findStreamers(l[0]) != null) {
            fatade.findStreamByStreamer(l, array);
            Collections.reverse(array);
        } else {
            fatade.findStreamByUser(l, array);
        }
        String json = objectMapper.writeValueAsString(array);
        System.out.println("" + json + "");
    }
}

class ComandaAscultare extends Commands {
    public void executa(String[] l) {
        User user1 = ListaUseri.findUser(l[0]);
        user1.streams.add(Integer.parseInt(l[2]));
        Streams str = ListaStreams.findStream(l[2]);
        if(str!= null) {
            str.setNoOfStreams(str.getNoOfStreams() + 1);
        }
    }
}
class ComandaRecomandari extends Commands {
    public void executa(String[] l) throws IOException {
        String name = "";
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<POJO> array1 = new ArrayList<>();
        ArrayList<Streams> temp = new ArrayList<>();

        for (Integer id : Objects.requireNonNull(ListaUseri.findUser(l[0])).streams) {
            Streams stream = ListaStreams.findStream(String.valueOf(id));
            name = ListaStreameri.getStreamerName(stream.getStreamerId());

            for (Streams s : ListaStreams.getInstance().getStreams()) {
                assert stream != null;
                if (s.getStreamerId().equals(stream.getStreamerId()) && (!s.equals(stream)) &&
                        s.getStreamType().equals(Integer.parseInt(String.valueOf(Streams.codificareType(l[2]))))) {
                    temp.add(s);
                }
            }
            temp.sort(Comparator.comparing(Streams :: getNoOfStreams));
            int i = 0;
            for(Streams streams : temp) {
                if(i < 5) {
                    Fatade fatade = new Fatade();
                    fatade.simplify(name, array1, streams);
                }
                i++;
            }

        }
        String j = objectMapper.writeValueAsString(array1);
        System.out.println("" + j + "");
    }
}
class ComandaSurpriza extends Commands {
    public void executa(String[] l) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<POJO> array2 = new ArrayList<>();
        Fatade fatade = new Fatade();
        ListaStreams.sort();
        ArrayList<Streams> arrayStreams = new ArrayList<>();

        for (Streamers streamers : fatade.newArrayOfStreamers(Objects.requireNonNull(ListaUseri.findUser(l[0])))) {
            for (Streams s1 : ListaStreams.getInstance().getStreams()) {
                if (s1.getStreamerId().equals(streamers.getId()) && s1.getStreamType()
                        .equals(Integer.parseInt(String.valueOf(Streams.codificareType(l[2]))))) {
                    arrayStreams.add(s1);
                }
            }
        }
        fatade.sortStreams(arrayStreams);
        for (int i = 0; i < arrayStreams.size(); i++) {
            if (i < 3) {
                String streamerName = ListaStreameri.getStreamerName(arrayStreams.get(i).getStreamerId());
                fatade.simplify(streamerName, array2, arrayStreams.get(i));
            }
        }

        String j = objectMapper.writeValueAsString(array2);
        System.out.println("" + j + "");

    }
}





