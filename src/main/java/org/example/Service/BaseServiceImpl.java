package org.example.Service;


import jakarta.transaction.Transactional;
import org.example.Entities.Base;
import org.example.Repository.BaseRepository;

import java.io.Serializable;
import java.util.Optional;

public abstract class BaseServiceImpl <E extends Base, ID extends Serializable> implements BaseService <E,ID> {

    protected BaseRepository<E,ID> baseRepository;

    @Override
    @Transactional
    public E findById(ID id) throws Exception {
        try {
            Optional<E> entityOptional = baseRepository.findById(id);
        } catch (Exception e) {
            throw new Exception("Error al buscar por ID: " + id + ": " + e.getMessage(), e);
        }
        return null;
    }


}
