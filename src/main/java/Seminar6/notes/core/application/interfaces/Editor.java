package Seminar6.notes.core.application.interfaces;

import java.util.Collection;
import java.util.Optional;

public interface Editor<T, TypeId>{

    boolean add(T item);
    boolean edit(T item);
    boolean remove(T item);
    Optional<T> getById(TypeId id);
    Collection<T> getAll();

}
