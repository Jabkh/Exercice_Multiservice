package org.example.infrastructure_springdata.portimpl;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class BaseServiceImpl<Entity, DTO, ID> {

    private final JpaRepository<Entity, ID> repository;

    public BaseServiceImpl(JpaRepository<Entity, ID> repository) {
        this.repository = repository;
    }

    public List<DTO> getAll() {
        return repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public DTO getById(ID id) {
        Optional<Entity> entity = repository.findById(id);
        return entity.map(this::convertToDTO).orElse(null);
    }

    public DTO save(DTO dto) {
        Entity entity = convertToEntity(dto);
        entity = repository.save(entity);
        return convertToDTO(entity);
    }

    public DTO update(ID id, DTO dto) {
        if (repository.existsById(id)) {
            Entity entity = convertToEntity(dto);
            setId(entity, id);
            entity = repository.save(entity);
            return convertToDTO(entity);
        }
        return null;
    }

    public void delete(ID id) {
        repository.deleteById(id);
    }

    protected abstract DTO convertToDTO(Entity entity);

    protected abstract Entity convertToEntity(DTO dto);

    protected abstract void setId(Entity entity, ID id);
}