package sample;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.seasar.doma.jdbc.DomaAbstractConfig;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.dialect.StandardDialect;

public class DomaConfig extends DomaAbstractConfig {

    private static Dialect dialect = new StandardDialect();

    @Override
    public DataSource getDataSource() {
        try {
            return InitialContext.doLookup("jdbc/__default");
        } catch (NamingException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Dialect getDialect() {
        return dialect;
    }
}
