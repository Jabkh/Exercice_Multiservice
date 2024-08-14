package org.example.service;

import org.example.port.UserPort;
import org.example.dto.UserDTO;

import java.util.List;

public class UserService extends BaseService<UserDTO, Long> {

    private final UserPort userPort;

    public UserService(UserPort userPort) {
        this.userPort = userPort;
    }

    @Override
    public List<UserDTO> getAll() {
        return userPort.getAll();
    }

    @Override
    public UserDTO getById(Long id) {
        return userPort.getById(id);
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        return userPort.save(userDTO);
    }

    @Override
    public UserDTO update(Long id, UserDTO userDTO) {
        return userPort.update(id, userDTO);
    }

    @Override
    public void delete(Long id) {
        userPort.delete(id);
    }
}