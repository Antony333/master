package apilib.queries.users;

import apilib.QueryBuilder;

public class UsersGetQuery extends QueryBuilder {
    public UsersGetQuery() {
        super("users.get");
    }

    public UsersGetQuery userIds(String... value) {
        addParams("user_ids", value);
        return this;
    }

    
    public UsersGetQuery fields(String... value) {
        addParams("fields", value);
        return this;
    }

    
    public UsersGetQuery nameCase(String value) {
        addParams("name_case", value);
        return this;
    }
}
