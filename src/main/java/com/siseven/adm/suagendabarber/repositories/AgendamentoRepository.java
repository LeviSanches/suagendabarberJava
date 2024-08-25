package com.siseven.adm.suagendabarber.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siseven.adm.suagendabarber.entities.AgendamentoEntity;
import com.siseven.adm.suagendabarber.entities.ProfissionalEntity;

public interface AgendamentoRepository extends JpaRepository<AgendamentoEntity, Long>{
	
	List<AgendamentoEntity> findByData(LocalDate data);
	List<AgendamentoEntity> findByDataAndProfissional(LocalDate data, ProfissionalEntity profissional);

}
