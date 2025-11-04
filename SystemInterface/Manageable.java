package SystemInterface;

import java.util.List;

public interface Manageable {
    void  add(Object entity);
    boolean  remove(String id);
    List<Object> getAll();
}
