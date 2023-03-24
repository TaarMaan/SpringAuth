package com.example.springAuth.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clients")
public class ClientEntity {
    /**
     * Data - класс, полей клиента отображающихся в бд
     * по протоколу OAuth, client- пользователь, а пароль нельзя хранить в базе открыто,
     * поэтому отображаться и хранится будет хэш
     */
    @Id
    @Column(name = "client_id")
    private String clientId;
    private String hash;
}
