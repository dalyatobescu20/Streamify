public class StreamsBuilder {

    private Streams streams = new Streams();

    public StreamsBuilder withStreamType(String streamType) {
        streams.setStreamType(Integer.parseInt(streamType));
        return this;
    }

    public StreamsBuilder withId(String id) {
        streams.setId(Integer.parseInt(id));
        return this;
    }

    public StreamsBuilder withStreamGenre(String streamGenre) {
        streams.setStreamGenre(Integer.parseInt(streamGenre));
        return this;
    }

    public StreamsBuilder withNoOfStreams(String noOfStreams) {
        streams.setNoOfStreams(Long.parseLong(noOfStreams));
        return this;
    }

    public StreamsBuilder withStreamerId(String streamerId) {
        streams.setStreamerId(Integer.parseInt(streamerId));
        return this;
    }

    public StreamsBuilder withLength(String length) {
        streams.setLength(Long.parseLong(length));
        return this;
    }

    public StreamsBuilder withDateAdded(String dateAdded) {
        streams.setDateAdded(Long.parseLong(dateAdded));
        return this;
    }

    public StreamsBuilder withName(String name) {
        streams.setName(name);
        return this;
    }

    public Streams build() {
        return streams;
    }
}
