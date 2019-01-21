package br.com.dizimo.repository;

import br.com.dizimo.model.Dizimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DizimoRepository extends JpaRepository<Dizimo, Integer> {

    Dizimo findDizimoById(Integer id);
}
