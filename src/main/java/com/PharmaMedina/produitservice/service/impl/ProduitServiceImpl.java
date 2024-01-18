package com.PharmaMedina.produitservice.service.impl;

import com.PharmaMedina.produitservice.dao.ProduitDao;
import com.PharmaMedina.produitservice.dto.ProduitDto;
import com.PharmaMedina.produitservice.exception.EntityNotFoundException;
import com.PharmaMedina.produitservice.models.ProduitEntity;
import com.PharmaMedina.produitservice.service.facade.ProduitService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProduitServiceImpl implements ProduitService {

    private ProduitDao produitDao;
    private ModelMapper modelMapper;

    public ProduitServiceImpl(ProduitDao produitDao, ModelMapper modelMapper) {
        this.produitDao = produitDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProduitDto save(ProduitDto produitDto) {
        ProduitEntity produitEntity=modelMapper.map(produitDto, ProduitEntity.class);
        ProduitEntity saved = produitDao.save(produitEntity);
        return modelMapper.map(saved, ProduitDto.class);
    }

    @Override
    public ProduitDto findById(Integer id) {
        Optional<ProduitEntity> produitEntity = produitDao.findById(id);
        //if(produitEntity == null) return null;
        return modelMapper.map(produitEntity, ProduitDto.class);
    }

    @Override
    public List<ProduitDto> findAll() {
        return produitDao.findAll()
                .stream()
                .map(produitEntity -> modelMapper.map(produitEntity, ProduitDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProduitDto findByReference(String reference) {
        ProduitEntity produitEntity = produitDao.findByReference(reference);
        if(produitEntity == null) return null;
        return modelMapper.map(produitEntity, ProduitDto.class);
    }

    @Override
    public ProduitDto findByNom(String nom) {
        ProduitEntity produitEntity=produitDao.findByNom(nom);
        if(produitEntity == null) return null;
        return modelMapper.map(produitEntity, ProduitDto.class);
    }

    @Override
    public List<ProduitDto> findByPrixGreaterThan(BigDecimal prix) {
        List<ProduitEntity> produitEntities = produitDao.findByPrixGreaterThan(prix);
        return produitEntities
                .stream()
                .map(produitEntity -> modelMapper.map(produitEntity, ProduitDto.class))
                .collect(Collectors.toList());

    }

    @Override
    public List<ProduitDto> findByPrixLessThan(BigDecimal prix) {
        List<ProduitEntity> produitEntities = produitDao.findByPrixLessThan(prix);
        return produitEntities
                .stream()
                .map(produitEntity -> modelMapper.map(produitEntity, ProduitDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProduitDto> findByMarque(String marque) {
        List<ProduitEntity> produitEntities = produitDao.findByMarque(marque);
        return produitEntities
                .stream()
                .map(produitEntity -> modelMapper.map(produitEntity, ProduitDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        produitDao.deleteById(id);
    }

    @Override
    public ProduitDto update(ProduitDto produitDto, Integer id) {
        Optional<ProduitEntity> produitEntityOptional = produitDao.findById(id);
        if(produitEntityOptional.isPresent()){
            ProduitEntity produitEntity = modelMapper.map(produitDto, ProduitEntity.class);
            produitEntity.setId(id);
            ProduitEntity  updated = produitDao.save(produitEntity);
            return modelMapper.map(updated, ProduitDto.class);
        }else{
            throw new EntityNotFoundException("Produit Not Found");
        }
    }
}