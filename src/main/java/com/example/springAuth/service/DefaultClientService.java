package com.example.springAuth.service;


import com.example.springAuth.dao.ClientEntity;
import com.example.springAuth.exception.LoginException;
import com.example.springAuth.exception.RegistrationException;
import com.example.springAuth.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DefaultClientService extends ClientService {
    private final ClientRepository userRepository;

    @Override
    public void register(String clientId, String clientSecret) {
        if (userRepository.findById(clientId).isPresent())
            throw new RegistrationException("Client with id: " + clientId + " already registered");

        String hash = BCrypt.hashpw(clientSecret, BCrypt.gensalt());
        userRepository.save(new ClientEntity(clientId, hash));
    }

    @Override
    public void checkCredentials(String clientId, String clientSecret) {
        Optional<ClientEntity> optionalUserEntity = userRepository.findById(clientId);
        if (optionalUserEntity.isEmpty())
            throw new LoginException("Client with id: " + clientId + " not found");

        ClientEntity clientEntity = optionalUserEntity.get();

        if (!BCrypt.checkpw(clientSecret, clientEntity.getHash()))
            throw new LoginException("Secret is incorrect");
    }
}
