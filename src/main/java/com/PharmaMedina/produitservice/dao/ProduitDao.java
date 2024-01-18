package com.PharmaMedina.produitservice.dao;

import com.PharmaMedina.produitservice.models.ProduitEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProduitDao extends JpaRepository<ProduitEntity, Integer> {
    ProduitEntity findByReference(String Reference);
    ProduitEntity findByNom(String nom);
    List<ProduitEntity> findByPrixGreaterThan(BigDecimal prix);
    List<ProduitEntity> findByPrixLessThan(BigDecimal prix);
    List<ProduitEntity> findByMarque(String marque);
}
