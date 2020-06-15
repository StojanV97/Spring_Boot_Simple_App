package de.jonashackt.springbootvuejs.repository;

import de.jonashackt.springbootvuejs.domain.Art;
import org.springframework.data.repository.CrudRepository;

public interface ArtRepository extends CrudRepository<Art,Long> {
}
