package com.PharmaMedina.produitservice.controllers;

import com.PharmaMedina.produitservice.dto.ProduitDto;
import com.PharmaMedina.produitservice.service.facade.ProduitService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("produits")
public class ProduitController {
    private ProduitService produitService;
    public ProduitController(ProduitService produitService){
        this.produitService = produitService;
    }

    @GetMapping("")
    public ResponseEntity<List<ProduitDto>> getProduits(){
        return ResponseEntity.ok(produitService.findAll());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ProduitDto> getProduit(@PathVariable("id") Integer id){
        return ResponseEntity.ok(produitService.findById(id));
    }

    @GetMapping("/Ref/{Ref}")
    public ResponseEntity<ProduitDto> getProduitByReference(@PathVariable("Ref") String reference){
        return ResponseEntity.ok(produitService.findByReference(reference));
    }

    @GetMapping("/Nom/{Nom}")
    public ResponseEntity<ProduitDto> getProduitByNom(@PathVariable("Nom") String Nom){
        return ResponseEntity.ok(produitService.findByNom(Nom));
    }

    @GetMapping("/PrixSup/{Prix}")
    public ResponseEntity<List<ProduitDto>> getProduitGreaterThan(@PathVariable("Prix") BigDecimal prix){
        return ResponseEntity.ok(produitService.findByPrixGreaterThan(prix));
    }

    @GetMapping("/PrixInf/{Prix}")
    public ResponseEntity<List<ProduitDto>> getProduitLessThan(@PathVariable("Prix") BigDecimal prix){
        return ResponseEntity.ok(produitService.findByPrixLessThan(prix));
    }

    @GetMapping("/Marque/{Marque}")
    public ResponseEntity<List<ProduitDto>> getProduitByMarque(@PathVariable("Marque") String marque){
        return ResponseEntity.ok(produitService.findByMarque(marque));
    }

    @PostMapping("")
    public ResponseEntity<ProduitDto> save(@Valid @RequestBody() ProduitDto produitDto){
        ProduitDto saved = produitService.save(produitDto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        produitService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<ProduitDto> update(@RequestBody() ProduitDto produitDto, @PathVariable("id") Integer id){
        ProduitDto updated = produitService.update(produitDto, id);
        return ResponseEntity.accepted().body(updated);
    }
}