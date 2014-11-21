package sample;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

@Dao
@ConfigAutowireable
public interface MessageDao {

    @Select
    Message select(Long id);
}
