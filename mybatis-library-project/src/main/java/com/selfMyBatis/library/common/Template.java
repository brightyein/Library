package com.selfMyBatis.library.common;

import com.selfMyBatis.library.mapper.LibraryMapper;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Template {

    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSession getSqlSession() {

        if (sqlSessionFactory == null) {

            Properties prop = new Properties();

            try {
                prop.load(new FileReader("src/main/resources/javaconfig/javaconfig.properties"));
                String driver = prop.getProperty("Driver");
                String url = prop.getProperty("url");
                String user = prop.getProperty("user");
                String password = prop.getProperty("password");

                Environment environment = new Environment(
                        "dev",
                        new JdbcTransactionFactory(),
                        new PooledDataSource(driver,url,user,password)
                );

                Configuration configuration = new Configuration(environment);
                configuration.addMapper(LibraryMapper.class);

                sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return sqlSessionFactory.openSession(false);
    }
}
