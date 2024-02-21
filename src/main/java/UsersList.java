import java.util.ArrayList;

public class UsersList {

    private static UsersList users;

    private ArrayList<User> userList ;

    public UsersList() {
        this.userList = new ArrayList<>();
    }

    public static UsersList getInstance() {
        if (users == null) {
            users = new UsersList();
        }
        return users;
    }

    public ArrayList<User> getUseri() {
        return userList;
    }
    public static User findUser(String id) {
        for(User s: UsersList.getInstance().userList) {
            if(s.getId().equals(Integer.parseInt(id))) {
                return s;
            }
        }
        return null;
    }

}