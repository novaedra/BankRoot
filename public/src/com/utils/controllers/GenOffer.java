package com.utils.controllers;


import com.models.Clients;
import com.models.Conditions;
import com.models.Historique;
import com.utils.database.Database;

import java.lang.reflect.Array;
import java.util.*;

public class GenOffer {

    public static List<Integer> Offre() {


        List<Integer> res = new ArrayList<>();

        Conditions conditions = new Conditions();
        Clients clients = new Clients();
        Historique historique = new Historique();
        ArrayList<String> f = new ArrayList<>();
        f.add("*");
        List<Conditions> selCond = Database.select(conditions, f);
        List<Clients> selCli = Database.select(clients, f);
        List<Historique> selHisto = Database.select(historique, f);
        for (Historique _histo : selHisto) {
            boolean statut = _histo.getStatut();
            if (!statut) {
                for (Clients client : selCli) {
                    Integer id = client.getId();
                    int _age = Math.round(client.getAge());
                    Integer noteEp = client.getNoteInt();
                    Integer _revenus = client.getRevenus();
                    String[] colArg = new String[]{"age", "note", "revenus"};
                    Integer[] intArg = new Integer[]{_age, noteEp, _revenus};
                    for (int i = 0; i < colArg.length; i++) {
                        List<String> argumList = Arrays.asList(colArg);
                        for (Conditions condition : selCond) {
                            Integer produit_condition = condition.getProduit_has_condition();
                            String argCond = condition.getArgument();
                            String operateur = condition.getOperateur();
                            String valeur = condition.getValeur();
                            Integer _valeur = Integer.parseInt(valeur);
                            if (argumList.contains(argCond)) {
                                if (colArg[i].equals(argCond) && i < colArg[i].length()) {
                                    if (!Conditions.operateur(intArg[i], operateur, _valeur)) {
                                        res.add(id);
                                        res.add(produit_condition);
                                    }

                                }
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}