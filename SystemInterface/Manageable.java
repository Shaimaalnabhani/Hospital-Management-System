package SystemInterface;

import java.util.List;

public interface Manageable {
    String  add(Object entity);
    String remove(String id);
    String getAll();
}
