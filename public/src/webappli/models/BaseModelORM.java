package webappli.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.lang.reflect.*;
import java.util.ArrayList;

public class BaseModelORM {
    private Integer id;

    private String tableName = "";
    private String insertQueryString = "INSERT INTO ";
    private String updateQueryString = "UPDATE ";
    private String deleteQueryString = "DELETE ";
    private String selectQueryString = "SELECT * FROM ";

    private String ucFirst(String string) {
        return Character.toUpperCase(string.charAt(0)) + string.substring(1);
    }

    public BaseModelORM setId(Integer id) {
        this.id = id;

        return this;
    }

    public Integer getId() {
        return this.id;
    }

    public String getTableName() {

        return "";
    }

    private String getInsertString() {
        ArrayList<String> fields = new ArrayList<String>();
        ArrayList<String> marks = new ArrayList<String>();
        StringBuilder total = new StringBuilder();

        total.append(this.insertQueryString);
        total.append(this.getTableName());

        for (Field f : getClass().getDeclaredFields()) {
            try {
                if (f.getName().compareTo("id") != 0 && f.getName().compareTo("tableName") != 0) {
                    fields.add(f.getName());

                    marks.add("?");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        total.append(" (");
        total.append(String.join(",", fields));
        total.append(")");

        total.append(" VALUES (");
        total.append(String.join(",", marks));
        total.append(")");

        System.out.println(total);
        return total.toString();
    }

    private String getUpdateString() {
        ArrayList<String> fields = new ArrayList<String>();
        String where = "WHERE id = ?";
        StringBuilder total = new StringBuilder();

        total.append(this.updateQueryString);
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

        return total.toString();
    }

    private String getDeleteString() {
        ArrayList<String> fields = new ArrayList<String>();
        String where = "Where id= ?";
        StringBuilder total = new StringBuilder();

        total.append(this.deleteQueryString);
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

        return total.toString();
    }

    private String getSelectString() {
        ArrayList<String> fields = new ArrayList<String>();
        String where = "WHERE id = ?";
        StringBuilder total = new StringBuilder();

        total.append(this.selectQueryString);
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
        return total.toString();
    }



    public PreparedStatement getUpdateQuery(Connection dbConnection) {
        String updateQueryString = this.getUpdateString();
        PreparedStatement statement = null;

        Integer id = null;
        Integer i = 1;
        try {
            statement = dbConnection.prepareStatement(updateQueryString, Statement.RETURN_GENERATED_KEYS);

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

    public PreparedStatement getSelectQuery(Connection dbConnection) {
        String selectQueryString = this.getSelectString();
        PreparedStatement statement = null;

        Integer id = null;
        Integer i = 1;
        try {
            statement = dbConnection.prepareStatement(selectQueryString, Statement.RETURN_GENERATED_KEYS);

            for (Field f : getClass().getDeclaredFields()) {
                try {
                    // We are in a INSERT : no need for ID.
                    if (f.getName().compareTo("id") == 0) {
                        String fieldName = ucFirst(f.getName());
                        String targetMethod = "get" + fieldName;

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

                i = i + 1;
            }
        } catch (Exception e) {

        }

        return i;
    }

}
