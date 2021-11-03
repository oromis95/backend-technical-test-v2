package com.tui.proof.service.repositories;

import com.tui.proof.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,String> {
}
