package org.bnsplits.model.entities;

import org.bnsplits.util.HashUtil;

public class Utilisateur {
    private int idUtilisateur;
    private String login;
    private String motDePasse;

    public Utilisateur(){};

    public Utilisateur(int idUtilisateur, String login, String motDePasse) {
        this.idUtilisateur = idUtilisateur;
        this.login = login;
        this.motDePasse = HashUtil.sha256Hash(motDePasse);
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public String getLogin() {
        return login;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = HashUtil.sha256Hash(motDePasse);
    }
}
