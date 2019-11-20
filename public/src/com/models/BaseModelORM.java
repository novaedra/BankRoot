package com.models;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Définissions de notre classe
public class BaseModelORM {

    //Nous définissons les variables qui seront utilisées
    private Integer id;

    private String tableName = "";
    private String insertQueryString = "INSERT INTO ";
    private String updateQueryString = "UPDATE ";
    private String selectQueryString = "SELECT ";
    private String deleteQueryString = "DELETE FROM ";
    private String updateIdQueryString = "UPDATE ";


    private String ucFirst(String string) {
        return Character.toUpperCase(string.charAt(0)) + string.substring(1);
    }

    //Voici la fonction qui va nous permettre de fabriquer l'id en bdd
    public BaseModelORM setId(Integer id) {
        this.id = id;

        return this;
    }

    //Celle qui nous récupère id
    public Integer getId() {
        return this.id;
    }

    //Fonction qui récup le nom de la table
    public String getTableName() {

        return "";
    }

    //Ici nous définissons la reqête verbale pour l'insertion
    private String getInsertString() {

        //Définissons des variables
        //On précise que les champs seront des tableaux mais les valeurs seront des chaînes de caractères
        ArrayList<String> fields = new ArrayList<String>();
        //Voila la définition des caractères qui sépareront les différents champs
        ArrayList<String> marks = new ArrayList<String>();
        //Ici nous établissons une variable qui va récupérer toute la requête
        StringBuilder total = new StringBuilder();

        //On lui intègre le début de la requête
        total.append(this.insertQueryString);
        //Insertion du nom de la Table
        total.append(this.getTableName());

        //On définit la variable f et lui dire qu'elle récupère les chamsp déclarés
        for (Field f : getClass().getDeclaredFields()) {
            try {
                //Si l'id est différents de 0 et le nom de la table aussi on continue
                if (f.getName().compareTo("id") != 0 && f.getName().compareTo("tableName") != 0) {
                    //Du coup on ajoute les champs à insérer
                    fields.add(f.getName());
                    //Ici on donne une valeur a notre variable marks
                    marks.add("?");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        //On ajoute cette fin à la requête
        total.append(" (");
        total.append(String.join(",", fields));
        total.append(")");

        total.append(" VALUES (");
        total.append(String.join(",", marks));
        total.append(")");

        System.out.println(total.toString());
        return total.toString();
    }

    //Ici pour la méthode update
    private String getUpdateString() {
        //Définition des variable utilisées lors de la fonction
        //Définition de la variable pour récupérer nos champs
        ArrayList<String> fields = new ArrayList<String>();
        //Ici on définit notre variable pour rajouter des parametres a la requete
        String where = "WHERE id = ?";
        //Variable pour effectué la requete
        StringBuilder total = new StringBuilder();

        //Début de la requete
        total.append(this.updateQueryString);
        //On ajout la table
        total.append(this.getTableName());
        //On met la variable Set pour appliquer le changement
        total.append(" SET ");

        //On définit f qui est un champs et récupérer les champs déclarés dans notre classe
        for (Field f : getClass().getDeclaredFields()) {
            try {
                //Si ni nos id ni notre nom de table est nul alors
                if (f.getName().compareTo("id") != 0 && f.getName().compareTo("tableName") != 0) {

                    //On ajout nos champs et si vide alors on met un ?
                    fields.add(f.getName() + " = ?");

                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        //Ici on fini la requete avec les chamsp a modifier et on les délimite
        total.append(String.join(",", fields));
        //On met notre variable where pour préciser un id
        total.append(where);

        return total.toString();
    }


    //Méthode pour effectuer notre requete SQL avec notre bdd
    public PreparedStatement getUpdateQuery(Connection dbConnection) {
        //On récupère notre chaîne de caractère qui est la requete et on la transmet à une variable
        String updateQueryString = this.getUpdateString();
        //On définit que statement est null car aucune requete est effectué
        PreparedStatement statement = null;

        Integer id = null;
        Integer i = 1;
        try {
            //Ici on établit la connection et on prépare notre requete
            statement = dbConnection.prepareStatement(updateQueryString, Statement.RETURN_GENERATED_KEYS);

            //Pour nos champs on les déclare avec nos varibales de notre classe/Objet
            for (Field f : getClass().getDeclaredFields()) {
                try {
                    // We are in a INSERT : no need for ID.
                    if (f.getName().compareTo("id") == 0) {
                        String fieldName = ucFirst(f.getName());
                        String targetMethod = "get" + fieldName; // "getName"

                        Method classMethod = getClass().getMethod(targetMethod);

                        id = (Integer) classMethod.invoke(this);
                    } else {
                        i = addParameter(statement, i, f);
                    }

                } catch (Exception e) {
                    System.out.println(e);
                }
            }

            statement.setInt(i, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return statement;
    }


    public PreparedStatement getInsertQuery(Connection dbConnection) {

        String insertQueryString = this.getInsertString();

        PreparedStatement statement = null;

        try {
            statement = dbConnection.prepareStatement(insertQueryString, Statement.RETURN_GENERATED_KEYS);

            Integer i = 1;

            for (Field f : getClass().getDeclaredFields()) {
                try {
                    // We are in a INSERT : no need for ID, filtered in addParameter.
                    i = addParameter(statement, i, f);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return statement;
    }

    private String getSelectQueryString(ArrayList<String> fields) {

        StringBuilder total = new StringBuilder();

        total.append(this.selectQueryString);

        total.append(String.join(",", fields));
        total.append(" FROM ");
        total.append(this.getTableName());


        return total.toString();

    }

    public PreparedStatement getSelectQuery(Connection dbConnection, ArrayList<String> fields) {

        String selectQueryString = this.getSelectQueryString(fields);
        PreparedStatement statement = null;


        try {
            statement = dbConnection.prepareStatement(selectQueryString, Statement.RETURN_GENERATED_KEYS);

            for (Field f : getClass().getDeclaredFields()) {
                try {
                    if (f.getName().compareTo("id") != 0) {

                        String fieldName = ucFirst(f.getName());
                        String targetMethod = "get" + fieldName; // On établit la méthode de la requete et du coup get avec les champs retournés

                        Method classMethod = getClass().getMethod(targetMethod);

                        classMethod.invoke(this);

                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } catch (SQLException e) {

            System.out.println(e);

        }

        return statement;
    }

    public PreparedStatement getSelectQuery(Connection dbConnection, ArrayList<String> fields, ArrayList filters) {

        String selectQueryString = this.getSelectQueryString(fields);
        PreparedStatement statement = null;

        if (filters.size() == 0) {
            return null;
        }

        selectQueryString = selectQueryString + " WHERE ";

        List<String> _parsedFilters = new ArrayList();

        for (Integer counter = 0; counter < filters.size(); counter++) {
            HashMap _filters = (HashMap) filters.get(counter);
            String _parsedTest = (String) _filters.get("col") + " " + _filters.get("operator") + " " + _filters.get("value");
            _parsedFilters.add(_parsedTest);
        }

        selectQueryString = selectQueryString + String.join("AND", _parsedFilters);

        System.out.println(selectQueryString);

        try {
            statement = dbConnection.prepareStatement(selectQueryString, Statement.RETURN_GENERATED_KEYS);

            for (Field f : getClass().getDeclaredFields()) {
                try {
                    if (f.getName().compareTo("id") != 0) {

                        String fieldName = ucFirst(f.getName());
                        String targetMethod = "get" + fieldName; // On établit la méthode de la requete et du coup get avec les champs retournés

                        Method classMethod = getClass().getMethod(targetMethod);

                        classMethod.invoke(this);

                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } catch (SQLException e) {

            System.out.println(e);

        }

        return statement;
    }

    public String getDeleteQueryString(Integer id) {

        ArrayList<String> fields = new ArrayList<String>();
        String where = " WHERE id = ";
        StringBuilder total = new StringBuilder();

        total.append(this.deleteQueryString);
        total.append(this.getTableName());

        for (Field f : getClass().getDeclaredFields()) {
            try {
                if (f.getName().compareTo("id") != 0 && f.getName().compareTo("tableName") != 0) {

                    fields.add(f.getName() + " = ?");

                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        total.append(where);
        total.append(id);

        System.out.println(total.toString());
        return total.toString();

    }

    public PreparedStatement getDeleteQuery(Connection db, Integer id) {
        String deleteQueryString = this.getDeleteQueryString(id);
        PreparedStatement statement = null;

        try {

            statement = db.prepareStatement(deleteQueryString, Statement.RETURN_GENERATED_KEYS);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return statement;
    }

    private String getUpdateIdQueryString(Integer id) {

        ArrayList<String> fields = new ArrayList<String>();
        String where = "WHERE id = ";
        StringBuilder total = new StringBuilder();

        total.append(this.updateIdQueryString);
        total.append(this.getTableName());
        total.append(" SET ");

        for (Field f : getClass().getDeclaredFields()) {
            try {
                if (f.getName().compareTo("id") != 0 && f.getName().compareTo("tableName") != 0) {

                    fields.add(f.getName() + " = ?");

                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        total.append(String.join(",", fields));
        total.append(where);
        total.append(id);

        System.out.println(total.toString());
        return total.toString();

    }

    public PreparedStatement getUpdateIdQuery(Connection db, Integer id) {
        String updateIdQueryString = this.getUpdateIdQueryString(id);
        PreparedStatement statement = null;

        Integer i = 1;
        try {

            statement = db.prepareStatement(updateIdQueryString, Statement.RETURN_GENERATED_KEYS);

            for (Field f : getClass().getDeclaredFields()) {
                try {
                    // We are in a INSERT : no need for ID.
                    if (f.getName().compareTo("id") == 0) {
                        String fieldName = ucFirst(f.getName());
                        String targetMethod = "get" + fieldName; // "getName"

                        Method classMethod = getClass().getMethod(targetMethod);

                        classMethod.invoke(this);
                    } else {
                        i = addParameter(statement, i, f);
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return statement;
    }

    private Integer addParameter(PreparedStatement statement, Integer i, Field field) {
        try {
            if (field.getName().compareTo("id") != 0 && field.getName().compareTo("tableName") != 0) {
                // Ex : "name" => "Name"
                String fieldName = ucFirst(field.getName());
                String targetMethod = "get" + fieldName; // "getName"

                Method classMethod = getClass().getMethod(targetMethod);

                if (field.getType() == Integer.class) {
                    statement.setInt(i, (Integer) classMethod.invoke(this));
                }

                if (field.getType() == String.class) {
                    statement.setString(i, (String) classMethod.invoke(this));
                }

                if (field.getType() == Timestamp.class) {
                    statement.setTimestamp(i, (Timestamp) classMethod.invoke(this));
                }
                if (field.getType() == Date.class) {
                    statement.setDate(i, (Date) classMethod.invoke(this));
                }

                if (field.getType() == Boolean.class) {
                    statement.setBoolean(i, (Boolean) classMethod.invoke(this));
                }

                i = i + 1;
            }
        } catch (Exception e) {

        }

        return i;
    }


    public BaseModelORM populate(ResultSet rs, ArrayList<String> fields) {
        for (Field f : getClass().getDeclaredFields()) {
            try {
                if (f.getName().compareTo("tableNme") != 0 && f.getName() != "tableName") {
                    if (rs.getString(f.getName()) == null) {
                        continue;
                    }

                    String fieldName = ucFirst(f.getName()); // "name"
                    String targetMethod = "set" + fieldName; // "getName"

                    Method classMethod = getClass().getMethod(targetMethod, f.getType());

                    if (f.getType() == Integer.class) {
                        classMethod.invoke(this, rs.getInt(f.getName()));
                    }

                    if (f.getType() == String.class) {
                        classMethod.invoke(this, rs.getString(f.getName()));
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return this;
    }

}