package ru.cbdd.fvf.providers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import ru.cbdd.fvf.entitys.User;
import ru.cbdd.fvf.interfaces.iproviders.IUserProvider;

import java.util.List;
import java.util.Optional;

@Component
public class UserProvider implements IUserProvider {
    private final Sql2o sql2o;

    private static final String SELECT_USER_USERNAME = "select * from users where username = :u_name";

    private static final String SELECT_USER_ID = "select * from users where id = :q_id";

    private static final String INSERT_USER = "insert into users(username, password) values(:v_username, :v_password)";

    private static final String UPDATE_USER = "update users set username = :v_username, password = :v_password where username = :u_name";

    private static final String CHECK_USER = "select username from users where username = :u_name";

    private static final String SELECT_ALL_USERS = "select * from users";


    public UserProvider(@Autowired Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    public User findByUsername(String username) {
        try (Connection connection = sql2o.open()) {
            return connection.createQuery(SELECT_USER_USERNAME, false)
                    .addParameter("u_name", username)
                    .setColumnMappings(User.COLUMN_MAPPINGS)
                    .executeAndFetchFirst(User.class);
        }
    }

    @Override
    public void save(User user) {
        try (Connection connection = sql2o.open()) {
            if(connection.createQuery(CHECK_USER, false).addParameter("u_name",
                    user.getUsername()).setColumnMappings(User.COLUMN_MAPPINGS).executeAndFetchFirst(User.class) != null){
                connection.createQuery(UPDATE_USER, false)
                        .addParameter("v_username", user.getUsername())
                        .addParameter("v_password", user.getPassword())
                        .setColumnMappings(User.COLUMN_MAPPINGS)
                        .executeUpdate();
            }else {
                connection.createQuery(INSERT_USER, true)
                        .addParameter("v_username", user.getUsername())
                        .addParameter("v_password", user.getPassword())
                        .setColumnMappings(User.COLUMN_MAPPINGS)
                        .executeUpdate();
            }
        }
    }

    @Override
    public List<User> findAll() {
        try (Connection connection = sql2o.open()){
            return connection.createQuery(SELECT_ALL_USERS, false)
                    .setColumnMappings(User.COLUMN_MAPPINGS)
                    .executeAndFetch(User.class);
        }

    }

    @Override
    public Optional<User> findById(Long id) {
        try (Connection connection = sql2o.open()) {
            return Optional.of(connection.createQuery(SELECT_USER_ID, false)
                    .addParameter("q_id", id)
                    .setColumnMappings(User.COLUMN_MAPPINGS)
                    .executeAndFetchFirst(User.class));
        }
    }
}
