package com.siseven.adm.suagendabarber.repositories;

import com.siseven.adm.suagendabarber.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
}
