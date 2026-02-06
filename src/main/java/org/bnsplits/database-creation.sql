-- Create database
CREATE DATABASE IF NOT EXISTS restaurant_management;
USE restaurant_management;

-- Table: Utilisateur
CREATE TABLE utilisateur (
    id INT AUTO_INCREMENT PRIMARY KEY,
    login VARCHAR(50) NOT NULL UNIQUE,
    username VARCHAR(255) NOT NULL,
    type ENUM('ADMIN', 'GERANT', 'NORMAL') NOT NULL DEFAULT 'NORMAL',
    mot_de_passe VARCHAR(255) NOT NULL
);

-- Table: Categorie
CREATE TABLE categorie (
    id INT AUTO_INCREMENT PRIMARY KEY,
    libelle VARCHAR(100) NOT NULL UNIQUE
);

-- Table: Produit
CREATE TABLE produit (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    categorie_id INT NOT NULL,
    prix_vente DECIMAL(10, 2) NOT NULL CHECK (prix_vente > 0),
    stock_actuel INT NOT NULL DEFAULT 0 CHECK (stock_actuel >= 0),
    seuil_alerte INT NOT NULL DEFAULT 5,
    FOREIGN KEY (categorie_id) REFERENCES categorie (id) ON DELETE RESTRICT
);

-- Table: MouvementStock
CREATE TABLE mouvement_stock (
    id INT AUTO_INCREMENT PRIMARY KEY,
    produit_id INT NOT NULL,
    type ENUM('ENTREE', 'SORTIE') NOT NULL,
    quantite INT NOT NULL CHECK (quantite > 0),
    date_mouvement DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    motif VARCHAR(255),
    FOREIGN KEY (produit_id) REFERENCES produit (id) ON DELETE CASCADE
);

-- Table: Commande
CREATE TABLE commande (
    id INT AUTO_INCREMENT PRIMARY KEY,
    date_commande DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    etat ENUM('EN_COURS', 'VALIDEE', 'ANNULEE') NOT NULL DEFAULT 'EN_COURS',
    total DECIMAL(10, 2) NOT NULL DEFAULT 0
);

-- Table: LigneCommande
CREATE TABLE ligne_commande (
    id INT AUTO_INCREMENT PRIMARY KEY,
    commande_id INT NOT NULL,
    produit_id INT NOT NULL,
    quantite INT NOT NULL CHECK (quantite > 0),
    prix_unitaire DECIMAL(10, 2) NOT NULL,
    montant_ligne DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (commande_id) REFERENCES commande (id) ON DELETE CASCADE,
    FOREIGN KEY (produit_id) REFERENCES produit (id) ON DELETE RESTRICT
);
