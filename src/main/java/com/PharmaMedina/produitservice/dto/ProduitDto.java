package com.PharmaMedina.produitservice.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProduitDto {

    @NotBlank(message = "la référence est obligatoire !")
    @Pattern(regexp = "^([A-Z]{3})([0-9]{4})$", message = "Format invalide !")
    private String reference;

    @NotBlank(message = "la marque est obligatoire !")
    private String marque;

    @NotBlank(message = "la categorie est obligatoire !")
    private String categorie;

    @NotBlank(message = "le nom est obligatoire !")
    private String nom;

    @NotNull(message = "le prix est obligatoire !")
    private BigDecimal prix;

    @NotNull(message = "la quantité du stock est obligatoire !")
    private double quantite_stock;

    @NotBlank(message = "la description est obligatoire !")
    private String description;

    @NotBlank(message = "les indications est obligatoire !")
    private String indications;

    @NotBlank(message = "le mode d'emploi est obligatoire !")
    private String mode_emploi;

    @NotBlank(message = "la composition est obligatoire !")
    private String composition;
}
