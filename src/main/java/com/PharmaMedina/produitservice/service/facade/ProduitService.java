package com.PharmaMedina.produitservice.service.facade;

import com.PharmaMedina.produitservice.dto.ProduitDto;
import com.PharmaMedina.produitservice.models.ProduitEntity;

import java.math.BigDecimal;
import java.util.List;

public interface ProduitService {
    ProduitDto save(ProduitDto produitDto);

    ProduitDto findById(Integer id);
    List<ProduitDto> findAll();
    ProduitDto findByReference(String reference);
    ProduitDto findByNom(String nom);
    List<ProduitDto> findByPrixGreaterThan(BigDecimal prix);

    List<ProduitDto> findByPrixLessThan(BigDecimal prix);


    List<ProduitDto> findByMarque(String marque);

    void delete(Integer id);

    ProduitDto update(ProduitDto produitDto, Integer id);
}

