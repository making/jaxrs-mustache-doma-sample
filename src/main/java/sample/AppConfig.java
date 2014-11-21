package sample;

import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.dialect.H2Dialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import javax.inject.Inject;
import javax.sql.DataSource;

@Configuration
public class AppConfig {
    @Inject
    DataSource dataSource;

    @Bean
    public Dialect dialect() {
        return new H2Dialect();
    }

    @Bean
    public Config domaConfig() {
        return new Config() {
            @Override
            public Dialect getDialect() {
                return dialect();
            }

            @Override
            public DataSource getDataSource() {
                return new TransactionAwareDataSourceProxy(dataSource);
            }
        };
    }
}
