package com.utils.controllers;


import com.models.Clients;
import com.models.Conditions;
import com.models.Produits;
import com.utils.database.Database;

import java.util.ArrayList;
import java.util.List;

public class GenOffer {
    public void genOffer() {

        Conditions conditions = new Conditions();
        Clients clients = new Clients();
        Produits produits = new Produits();
        ArrayList f = new ArrayList();
        f.add("*");

        List selCond = Database.select(conditions, f);
        List selCli = Database.select(clients, f);
        List selProd = Database.select(produits, f);


    }
}