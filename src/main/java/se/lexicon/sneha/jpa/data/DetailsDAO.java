package se.lexicon.sneha.jpa.data;

import se.lexicon.sneha.jpa.model.Details;

import java.util.Collection;
import java.util.Optional;

public interface DetailsDAO{

    Details create(Details details);
    Details findById(int id);
    Collection<Details> findAll();
    Details update(Details details);
    void delete(int id);
}
