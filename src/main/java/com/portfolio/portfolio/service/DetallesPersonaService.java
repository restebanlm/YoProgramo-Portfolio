package com.portfolio.portfolio.service;

import com.portfolio.portfolio.model.DetallesPersona;
import com.portfolio.portfolio.repository.DetallesPersonaRepository;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetallesPersonaService implements IDetallesPersonaService{

    @Autowired
    private DetallesPersonaRepository detallesPersonaRepository;
    
    @Override
    public List<DetallesPersona> getDetallesPersonas() {
        List<DetallesPersona> listaDetallesPersona = detallesPersonaRepository.findAll();
        return listaDetallesPersona;
    }

    @Override
    public void saveDetallesPersona(DetallesPersona detallesPersona) {
        detallesPersonaRepository.save(detallesPersona);
    }

    @Override
    public void deleteDetallesPersona(Long id) {
        detallesPersonaRepository.deleteById(id);
    }

    @Override
    public DetallesPersona findDetallesPersona(Long id) {
        DetallesPersona detallePersona = detallesPersonaRepository.findById(id).orElse(null);
        return detallePersona;
    }

    @Override
    public DetallesPersona getDetallesPersona(Long idPersona) {
        List<DetallesPersona> listaDetallesPersonas = detallesPersonaRepository.findAll();
        for(DetallesPersona dp : listaDetallesPersonas){
            if(Objects.equals(dp.getPersona().getId(), idPersona)){
                return dp;
            }
        }
        return null;
    }
}
