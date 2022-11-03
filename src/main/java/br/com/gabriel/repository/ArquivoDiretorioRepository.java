package br.com.gabriel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import br.com.gabriel.model.ArquivoDiretorio;

public interface ArquivoDiretorioRepository extends JpaRepository<ArquivoDiretorio, Integer> {

	@Query("SELECT a FROM ArquivoDiretorio a WHERE a.profundidade <= :profundidade")
	List<ArquivoDiretorio> findByProfundidade(@Param("profundidade") Integer profundidade);

}
