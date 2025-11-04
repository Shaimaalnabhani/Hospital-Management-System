package SystemInterface;

import java.util.List;

public interface Searchable {
    List<Object> search(String keyword);

    Object  searchById(String id);
}
