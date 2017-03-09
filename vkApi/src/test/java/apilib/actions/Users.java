package apilib.actions;

import apilib.queries.users.UsersGetQuery;
import apilib.queries.users.UsersGetQueryTest;

public class Users {
    public UsersGetQueryTest get() {
        return new UsersGetQueryTest();
    }
}
