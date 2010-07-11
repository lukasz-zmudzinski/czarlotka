package pl.zmudzinski.orm;

import java.io.Serializable;
import java.util.List;

/**
 * User: lukasz.zmudzinski
 * Date: 2010-07-11
 * Time: 12:47:20
 */
public interface GenericDao<T, PK extends Serializable> {

    T load(PK id);

    T get(PK id);

    List<T> getAll();
}
