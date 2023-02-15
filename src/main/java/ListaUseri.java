import java.util.ArrayList;

public class ListaUseri {

    private static ListaUseri users;

    private ArrayList<User> userList ;

    public ListaUseri() {
        this.userList = new ArrayList<>();
    }

    public static ListaUseri getInstance() {
        if (users == null) {
            users = new ListaUseri();
        }
        return users;
    }

    public ArrayList<User> getUseri() {
        return userList;
    }
    public static User findUser(String id) {
        for(User s: ListaUseri.getInstance().userList) {
            if(s.getId().equals(Integer.parseInt(id))) {
                return s;
            }
        }
        return null;
    }

}