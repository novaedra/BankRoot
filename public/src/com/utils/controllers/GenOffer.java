package com.utils.controllers;


import com.fasterxml.jackson.databind.util.ISO8601Utils;
import com.models.Clients;
import com.models.Conditions;
import com.models.Historique;
import com.utils.database.Database;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenOffer {
    private static String Offre;

    public static String Offre() {
        String offre = "";
        Conditions conditions = new Conditions();
        Clients clients = new Clients();
        Historique historique = new Historique();
        ArrayList<String> f = new ArrayList<>();
        f.add("*");
        List<Conditions> selCond = Database.select(conditions, f);
        List<Clients> selCli = Database.select(clients, f);
        List<Historique> selHisto = Database.select(historique, f);
        for (Historique _histo : selHisto) {
            Integer id_produit = _histo.getId_produit();
            Integer id_client = _histo.getId_client();
            boolean statut = _histo.getStatut();
            if (!statut) {
                for (Clients client : selCli) {
                    String client_nom = client.getNom();
                    Integer _age = Math.round(client.getAge());
                    String age = String.valueOf(_age);
                    String note = client.getNoteEp();
                    Integer noteEp = client.getNoteInt();
                    Integer _revenus = client.getRevenus();
                    String revenus = String.valueOf(_revenus);
                    String[] colArg = new String[]{"age", "note", "revenus"};
                    String[] valArg = new String[]{age, note, revenus};
                    Integer[] intArg = new Integer[]{_age, noteEp, _revenus};
                    for (int i = 0; i < colArg.length; i++) {
                        List<String> argumList = Arrays.asList(colArg);
                        List<String> valList = Arrays.asList(valArg);
                        for (Conditions condition : selCond) {
                            Integer produit_condition = condition.getProduit_has_condition();

                            String argCond = condition.getArgument();
                            String operateur = condition.getOperateur();
                            String valeur = condition.getValeur();
                            Integer _valeur = Integer.parseInt(valeur);
                            if (argumList.contains(argCond)) {
                                while (colArg[i].equals(argCond)) {
                                    if (!Conditions.operateur(intArg[i], operateur, _valeur)) {
                                        Offre = (client.getId() + " " + client.getPrenom() + " " + client.getNom());
                                        System.out.println(client.getPrenom() + " " + client.getNom() + " " + valArg[i] + operateur + valeur + " " + produit_condition);

                                    }
                                    break;

                                }
                            }
                        }
                    }
                }
            }
        }
        return Offre;
    }
}