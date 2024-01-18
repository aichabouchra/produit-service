package com.PharmaMedina.produitservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data
@Table(name="produits")
@AllArgsConstructor
@NoArgsConstructor
public class ProduitEntity implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(nullable = false)
    private String reference;
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private String marque;
    @Column(nullable = false)
    private String categorie;
    @Column(nullable = false)
    private BigDecimal prix;
    @Column(nullable = false)
    private double quantite_stock;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String indications;
    @Column(nullable = false)
    private String mode_emploi;
    @Column(nullable = false)
    private String composition;

    @Lob
    @Column(name = "image_produit", nullable = true)
    private byte[] image;
    public byte[] getImageProduit() { return image; }
    public void setImageProduit(byte[] imageProduit) { this.image = imageProduit; }

    @Lob
    @Column(name = "logo_produit", nullable = true)
    private byte[] logo;
    public byte[] getLogoProduit() { return logo; }
    public void setLogoProduit(byte[] logoproduit) { this.logo = logoproduit; }

}
