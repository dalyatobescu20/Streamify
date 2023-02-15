import java.util.List;

import static java.util.Arrays.asList;

public class UsersBuilder {

    private User user = new User();

    public UsersBuilder withId(Integer id) {
        user.setId(id);
        return this;
    }

    public UsersBuilder withName(String name) {
        user.setName(name);
        return this;
    }

    public UsersBuilder withStreams(Integer[] streams) {
        user.getStreams().addAll(List.of(streams));
        return this;
    }

    public User build() {
        return user;
    }
}
