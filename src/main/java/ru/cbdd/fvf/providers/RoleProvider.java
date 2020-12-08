package ru.cbdd.fvf.providers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import ru.cbdd.fvf.entitys.Role;
import ru.cbdd.fvf.entitys.User;
import ru.cbdd.fvf.interfaces.iproviders.IRoleProvider;

import java.util.List;

@Component
public class RoleProvider implements IRoleProvider {
    private final Sql2o sql2o;

    private static final String SELECT_ROLE = "select * from roles where name = :r_name";

    private static final String SELECT_ROLE_ALL = "select * from roles";

    private static final String SELECT_ROLE_BY_USER_ID = "select roles.* from roles join users_roles where users_roles.user_id = :u_id and users_roles.role_id = roles.id";

    private static final String INSERT_ROLE = "insert into users_roles(user_id, role_id) values(:userId, :roleId)";

    public RoleProvider(@Autowired Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public Role findOneByName(String roleName) {
        try (Connection connection = sql2o.open()) {
            return connection.createQuery(SELECT_ROLE, false)
                    .addParameter("r_name", roleName)
                    .setColumnMappings(Role.COLUMN_MAPPINGS)
                    .executeAndFetchFirst(Role.class);
        }
    }

    @Override
    public List<Role> findByUserId(Long id) {
        try (Connection connection = sql2o.open()) {
            return connection.createQuery(SELECT_ROLE_BY_USER_ID, false)
                    .addParameter("u_id", id)
                    .setColumnMappings(Role.COLUMN_MAPPINGS)
                    .executeAndFetch(Role.class);
        }
    }

    @Override
    public List<Role> findAll() {
        try (Connection connection = sql2o.open()) {
            return connection.createQuery(SELECT_ROLE_ALL, false)
                    .setColumnMappings(Role.COLUMN_MAPPINGS)
                    .executeAndFetch(Role.class);
        }
    }

    @Override
    public void save(Long userId, Long roleId) {
        try (Connection connection = sql2o.open()) {
            connection.createQuery(INSERT_ROLE, true)
                    .addParameter("userId", userId)
                    .addParameter("roleId",roleId)
                    .setColumnMappings(Role.COLUMN_MAPPINGS)
                    .executeUpdate();
        }
    }
}
