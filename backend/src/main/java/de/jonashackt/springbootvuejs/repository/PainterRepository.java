package de.jonashackt.springbootvuejs.repository;

import de.jonashackt.springbootvuejs.domain.Painter;
import org.springframework.data.repository.CrudRepository;

public interface PainterRepository extends CrudRepository<Painter,Long> {
}
