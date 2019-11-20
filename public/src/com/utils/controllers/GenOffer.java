package com.utils.controllers;


import com.models.Clients;
import com.models.Conditions;
import com.models.Historique;
import com.utils.database.Database;

import java.lang.reflect.Array;
import java.util.*;

public class GenOffer {
    public static void main(String[] args) {

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
                Integer produit_condition = 0;
                String argCond = "";
                String operateur = "";
                String valeur = "";
                ArrayList<Integer> tabCondPro = new ArrayList<>();
                HashMap<Integer, Integer> tab = new HashMap<Integer, Integer>();
                for (Conditions condition : selCond) {
                    produit_condition = condition.getProduit_has_condition();
                    argCond = condition.getArgument();
                    operateur = condition.getOperateur();
                    valeur = condition.getValeur();
                    tabCondPro.add(produit_condition);
                }
                long resultat = Collections.frequency(tabCondPro, produit_condition);
                System.out.println(tabCondPro);
                System.out.println(resultat);
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


                        Integer _valeur = Integer.parseInt(valeur);
                        if (argumList.contains(argCond)) {
                            while (colArg[i].equals(argCond)) {
                                if (!Conditions.operateur(intArg[i], operateur, _valeur)) {

                                }
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
}
