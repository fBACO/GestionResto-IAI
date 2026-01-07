package org.bnsplits.model;

public class Utilisateur {
    private int id;
    private String login;
    private String mot_de_passe;

    public Utilisateur(int id, String login, String mot_de_passe){
        this.id = id;
        this.login = login;
        this.mot_de_passe = mot_de_passe;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }
}
