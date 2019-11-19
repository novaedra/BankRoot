package com.utils.controllers;


import com.models.Clients;
import com.models.Conditions;
import com.models.Historique;
import com.models.Produits;
import com.utils.database.Database;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenOffer {
    public static void main(String[] args) {

        Conditions conditions = new Conditions();
        Clients clients = new Clients();
//        Produits produits = new Produits();
        Historique historique = new Historique();
        ArrayList<String> f = new ArrayList<>();

        f.add("*");


        List<Conditions> selCond = Database.select(conditions, f);
        List<Clients> selCli = Database.select(clients, f);
//        List<Produits> selProd = Database.select(produits, f);
        List<Historique> selHisto = Database.select(historique, f);

        for (Historique _histo : selHisto) {
            Integer id_produit = _histo.getId_produit();
            Integer id_client = _histo.getId_client();
            boolean statut = _histo.getStatut();

            if (!statut) {
                for (Clients client : selCli) {
                    Integer _age = Math.round(client.getAge());
                    String age = String.valueOf(_age);
                    String note = client.getNoteEp();
                    Integer _revenus = client.getRevenus();
                    String revenus = String.valueOf(_revenus);


                    String[] colArg = new String[]{"age", "note", "revenus"};
                    String[] valArg = new String[]{age, note, revenus};

                    for (int i = 0; i < colArg.length; i++) {
                        List<String> argumList = Arrays.asList(colArg);
                        List<String> valList = Arrays.asList(valArg);
                        for (Conditions condition : selCond) {

                            String argCond = condition.getArgument();
                            String operateur = condition.getOperateur();
                            String valeur = condition.getValeur();

                            if (argumList.contains(argCond)) {
                                System.out.println("step 2.");
                                System.out.println(valArg[i]);
                            } else {
                                //  System.out.println("echec.");
                            }

                        }
                    }


                }

            }

        }
    }
}