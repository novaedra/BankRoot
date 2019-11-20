package com.utils.database;

import java.util.HashMap;

public class Filtre {
    public static HashMap add(String operator, String col, String value) {
        HashMap _filtre = new HashMap();
        _filtre.put("operator", operator);
        _filtre.put("col", col);
        _filtre.put("value", value);

        return _filtre;
    }
}
