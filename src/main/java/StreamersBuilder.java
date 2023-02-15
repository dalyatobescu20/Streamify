
public class StreamersBuilder {
    private Streamers streamers = new Streamers();

    public StreamersBuilder setStreamerType(Integer streamerType) {
        streamers.setStreamerType(streamerType);
        return this;
    }

    public StreamersBuilder setId(Integer id) {
        streamers.setId(id);
        return this;
    }

    public StreamersBuilder setName(String name) {
        streamers.setName(name);
        return this;
    }

    public Streamers build() {
        return streamers;
    }

}


