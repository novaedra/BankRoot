package com.utils.controllers;


import com.models.Clients;
import com.models.Conditions;
import com.models.Historique;
import com.utils.database.Database;

import java.util.*;

public class GenOffer {

    public static HashMap<Integer, HashSet> Offre() {
        HashMap<Integer, HashSet> resultat = new HashMap<>();
        HashSet<Integer> resPC = new HashSet<>();
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
                    Integer id = client.getId();
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
                            String str_ProdCond = String.valueOf(produit_condition);
                            String argCond = condition.getArgument();
                            String operateur = condition.getOperateur();
                            String valeur = condition.getValeur();
                            Integer _valeur = Integer.parseInt(valeur);
                            if (argumList.contains(argCond)) {
                                while (colArg[i].equals(argCond) && i < colArg[i].length()) {
                                    if (!Conditions.operateur(intArg[i], operateur, _valeur)) {
                                        resPC.add(produit_condition);
                                        resultat.put(id, resPC);
                                        System.out.println(resultat);
                                    }
                                    break;

                                }
                            }
                        }
                    }
                }
            }
        }
        return resultat;
    }
}