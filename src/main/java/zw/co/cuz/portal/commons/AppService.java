package zw.co.cuz.portal.commons;

import java.util.List;
import java.util.Optional;

public interface AppService <T>{

    List<T> findAll();

     T create(T t);

     T update(T t);

     void delete(Long Id);

     Optional<T> findById(Long Id);

}
