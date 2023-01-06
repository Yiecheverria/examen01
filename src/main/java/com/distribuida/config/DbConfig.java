package com.distribuida.config;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.SneakyThrows;
import org.apache.commons.dbcp2.BasicDataSource;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;

import java.sql.Connection;

@ApplicationScoped
public class DbConfig {

    private static BasicDataSource pool;

    public static BasicDataSource getInstance() {
        Config config = ConfigProvider.getConfig();
        if (pool == null) {
            pool = new BasicDataSource();
            pool.setUsername(config.getValue("db.user", String.class));
            pool.setPassword(config.getValue("db.password", String.class));
            pool.setUrl(config.getValue("db.url", String.class));

        }
        return pool;
    }

    @SneakyThrows
    public static Connection getConnection () {
        return getInstance().getConnection();
    }

}