package br.com.zup.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.modelo.Comic;

public interface ComicRepository extends JpaRepository<Comic, Long> {

	

}
