package org.example.infrastructure_springdata.portimpl;

import org.example.dto.UserDTO;
import org.example.infrastructure_springdata.entity.UserEntity;
import org.example.infrastructure_springdata.repository.UserRepository;
import org.example.port.UserPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserPort {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDTO> getAll() {
        return userRepository.findAll().stream()
                .map(userEntity -> new UserDTO(userEntity.getId(), userEntity.getName(), userEntity.getMail()))
                .toList();
    }

    @Override
    public UserDTO getById(Long id) {
        return userRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    @Override
    public UserDTO save(UserDTO user) {
        UserEntity userEntity = convertToEntity(user);
        userEntity = userRepository.save(userEntity);
        return convertToDTO(userEntity);
    }

    @Override
    public UserDTO update(Long id, UserDTO userDTO) {
        if (userRepository.existsById(id)) {
            UserEntity userEntity = convertToEntity(userDTO);
            userEntity.setId(id);
            return convertToDTO(userRepository.save(userEntity));
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    private UserDTO convertToDTO(UserEntity userEntity) {
        return new UserDTO(userEntity.getId(), userEntity.getName(), userEntity.getMail());
    }

    private UserEntity convertToEntity(UserDTO userDTO) {
        return UserEntity.builder()
                .name(userDTO.getName())
                .mail(userDTO.getMail())
                .build();
    }
}