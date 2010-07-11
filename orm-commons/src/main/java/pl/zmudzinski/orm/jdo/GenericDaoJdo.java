package pl.zmudzinski.orm.jdo;

import pl.zmudzinski.orm.GenericDao;

import java.io.Serializable;
import java.util.List;

/**
 * User: lukasz.zmudzinski
 * Date: 2010-07-11
 * Time: 12:43:09
 */
public class GenericDaoJdo<T, PK extends Serializable> implements GenericDao<T, PK> {

    @Override
    public T load(PK id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public T get(PK id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<T> getAll() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }


}
