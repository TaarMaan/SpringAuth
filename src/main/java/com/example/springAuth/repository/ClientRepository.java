package com.example.springAuth.repository;

import com.example.springAuth.dao.ClientEntity;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository
        extends CrudRepository<ClientEntity, String> {
    /**
     * Репозиторий для обращений в базу данных
     */
}
