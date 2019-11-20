package com.utils.database;

import com.models.BaseModelORM;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private static Connection dbConnection;
    private static String database = "bankroot";
    private static String user = "postgres";
    private static String password = "rootroot";
    private static String url = "jdbc:postgresql://localhost:5432/";

    public static void connect() {
        if (dbConnection == null) {
            System.out.println("[DB] Entering Database Connect.");
            try {
                Class.forName("org.postgresql.Driver");
                System.out.println("[DB] Driver OK.");
                dbConnection = DriverManager.getConnection(url + database, user, password);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void close() {
        if (dbConnection != null) {
            System.out.println("[DB] Closing database connection.");
            try {
                dbConnection.close();

                dbConnection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static Integer insert(BaseModelORM _object) {

        Integer _newId = null;

        System.out.println("[DB] Entering INSERT.");

        connect();

        if (dbConnection != null) {
            System.out.println("[DB] Got connection. Preparing statement.");

            PreparedStatement _insertQuery = _object.getInsertQuery(dbConnection);

            try {
                _insertQuery.executeUpdate();

                System.out.println("[DB] Statement ran. Picking last inserted ID.");

                // ... yeah. Bit strange, but works, so ...
                ResultSet keys = _insertQuery.getGeneratedKeys();
                keys.next();

                _newId = keys.getInt(1);

                System.out.println("[DB] Got last inserted ID. Setting it in object ( maybe for future 'UPDATE' query ? )");

                _object.setId(_newId);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        close();

        System.out.println("[DB] Exiting INSERT.");

        return _newId;

    }

    public static void update(BaseModelORM _object) {

        System.out.println("[DB] Entering UPDATE.");

        connect();

        if (dbConnection != null) {
            System.out.println("[DB] Got connection. Preparing statement.");

            PreparedStatement _updateQuery = _object.getUpdateQuery(dbConnection);

            try {
                _updateQuery.execute();

                System.out.println("[DB] Statement ran.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        close();

        System.out.println("[DB] Exiting UPDATE.");

    }

    public static List select(BaseModelORM _object, ArrayList<String> fields) {

        System.out.println("[DB] Entering SELECT");

        connect();

        List resultat = new ArrayList<>();

        if (dbConnection != null) {
            System.out.println("[DB] Got connection , Preparing statement");

            PreparedStatement _selectQuery = _object.getSelectQuery(dbConnection, fields);

            try {

                ResultSet rs = _selectQuery.executeQuery();

                while (rs.next()) {
                    BaseModelORM _newObject = (BaseModelORM) Class.forName(_object.getClass().getName()).newInstance();
                    resultat.add(_newObject.populate(rs, fields));
                }

                System.out.println("[DB] Statement ran.");

            } catch (Exception e) {

                e.printStackTrace();
            }

            close();

            System.out.println("[DB] Exiting Select");
        }
        return resultat;
    }

    public static List select(BaseModelORM _object, ArrayList<String> fields, ArrayList<String> filter) {

        System.out.println("[DB] Entering SELECT");

        connect();

        List resultat = new ArrayList<>();

        if (dbConnection != null) {
            System.out.println("[DB] Got connection , Preparing statement");

            PreparedStatement _selectQuery = _object.getSelectQuery(dbConnection, fields, filter);

            try {

                ResultSet rs = _selectQuery.executeQuery();

                while (rs.next()) {
                    BaseModelORM _newObject = (BaseModelORM) Class.forName(_object.getClass().getName()).newInstance();
                    resultat.add(_newObject.populate(rs, fields));
                }

                System.out.println("[DB] Statement ran.");

            } catch (Exception e) {

                e.printStackTrace();
            }

            close();

            System.out.println("[DB] Exiting Select");
        }
        return resultat;
    }

    public static void delete(BaseModelORM _object, Integer id) {

        System.out.println("[DB] Entering DELETE");

        connect();

        if (dbConnection != null) {
            System.out.println("[DB] Got to connection");

            PreparedStatement _removeQuery = _object.getDeleteQuery(dbConnection, id);

            try {
                _removeQuery.execute();

                System.out.println("[DB] Delete done.");
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        close();

        System.out.println("[DB] Databse closing");
    }

    public static void updateId(BaseModelORM _object, Integer id) {
        System.out.println("[DB] Entering UpdateId");
        connect();

        if (dbConnection != null) {
            System.out.println("[DB] Got Connection.");
            PreparedStatement _updateIdQuery = _object.getUpdateIdQuery(dbConnection, id);
            try {
                _updateIdQuery.execute();
                System.out.println("[DB] Update done.");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        close();
    }
}
