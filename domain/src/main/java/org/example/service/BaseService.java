package org.example.service;


import java.util.List;

public abstract class BaseService<DTO, ID> {

    public abstract List<DTO> getAll();

    public abstract DTO getById(ID id);

    public abstract DTO save(DTO dto);

    public abstract DTO update(ID id, DTO dto);

    public abstract void delete(ID id);
}