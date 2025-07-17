package org.example.Service;


import jakarta.transaction.Transactional;
import org.example.Entities.Base;
import org.example.Repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseServiceImpl <E extends Base, ID extends Serializable> implements BaseService <E,ID> {
    @Autowired
    protected BaseRepository<E,ID> baseRepository;

    @Override
    @Transactional
    public E findById(ID id) throws Exception {
        try {
            return baseRepository.findById(id)
                    .orElseThrow(() -> new Exception("Entidad no encontrada con ID: " + id));
        } catch (Exception e) {
            throw new Exception("Error al buscar por ID: " + id + ": " + e.getMessage(), e);
        }
    }

    public List<E> findAll() throws Exception{
        try{
            List<E> entities = baseRepository.findAll();
            return entities;
        }catch (Exception e){
            throw new Exception("Surgio un error: "+e.getMessage());
        }
    }
    public E save(E entity) throws Exception{
        try{
            entity = baseRepository.save(entity);
            return entity;
        }catch (Exception e){
            throw new Exception("No se pudo guardar: "+ e.getMessage() + entity.getId());
        }
    }
    @Override
    @Transactional
    public E update(ID id, E entity) throws Exception {
        try {
            if (!baseRepository.existsById(id)) {
                throw new Exception("No se encontró la entidad con ID: " + id);
            }
            entity.setId((Long) id); // Asumiendo que el ID es Long
            return baseRepository.save(entity);
        } catch (Exception e) {
            throw new Exception("Error al actualizar la entidad con ID: " + id + ": " + e.getMessage(), e);
        }
    }

    @Override
    @Transactional
    public boolean delete(ID id) throws Exception {
        try {
            if (!baseRepository.existsById(id)) {
                throw new Exception("No se encontró la entidad con ID: " + id);
            }
            baseRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new Exception("Error al eliminar entidad con ID: " + id + ": " + e.getMessage(), e);
        }
    }



}
