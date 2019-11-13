package com.models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Clients extends BaseModelORM {

    private Integer id;
    // Données contenues en BDD
    private String nom;
    private String prenom;
    private String mail;
    private String telephone;
    private String adresse;
    private String birthday;
    private Integer enfacharges;
    private Integer revenus;
    private Integer depenses;
    private boolean autoricnil;
    private boolean prospect;
    private Integer situtationpro;
    private String statutmatri;
    private String tableName;
    //     Méthode pour une lecture plus claire de l'âge.
    private float age;


    public String getNom() {
        return nom;
    }

    public Clients setNom(String nom) {
        this.nom = nom;
        return this;
    }

    public String getPrenom() {
        return prenom;
    }

    public Clients setPrenom(String prenom) {
        this.prenom = prenom;
        return this;
    }

    public String getMail() {
        return mail;
    }

    public Clients setMail(String mail) {
        this.mail = mail;
        return this;
    }

    public String getTelephone() {
        return telephone;
    }

    public Clients setTelephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    public String getAdresse() {
        return adresse;
    }

    public Clients setAdresse(String adresse) {
        this.adresse = adresse;
        return this;
    }

    public String getBirthday() {
        return birthday;
    }

    public Clients setBirthday(String birthday) {
        this.birthday = birthday;
        return this;
    }

    public Integer getEnfacharges() {
        return enfacharges;
    }

    public Clients setEnfacharges(Integer enfacharges) {
        this.enfacharges = enfacharges;
        return this;
    }

    public boolean isAutoricnil() {
        return autoricnil;
    }

    public Clients setAutoricnil(boolean autoricnil) {
        this.autoricnil = autoricnil;
        return this;
    }

    public boolean isProspect() {
        return prospect;
    }


    public Clients setProspect(boolean prospect) {
        this.prospect = prospect;
        return this;
    }

    public int getSitutationpro() {
        return situtationpro;
    }

    public Clients setSitutationpro(Integer situtationpro) {
        this.situtationpro = situtationpro;
        return this;
    }

    public String getStatutmatri() {
        return statutmatri;
    }

    public Clients setStatutmatri(String statutmatri) {
        this.statutmatri = statutmatri;
        return this;
    }

    public Integer getRevenus() {
        return revenus;
    }

    public Clients setRevenus(Integer revenus) {
        this.revenus = revenus;
        return this;
    }

    public Integer getDepenses() {
        return depenses;
    }

    public Clients setDepenses(Integer depenses) {
        this.depenses = depenses;
        return this;
    }


    public String getAutoriCnil() {
        String _autoriCnil = "";

        if (prospect) {
            _autoriCnil = "Oui";
        } else {
            _autoriCnil = "Non";
        }

        return _autoriCnil;
    }

    public String getProspect() {
        String _prospect = "";

        if (prospect) {
            _prospect = "Oui";
        } else {
            _prospect = "Non";
        }

        return _prospect;
    }

    public float getAge() {
        int age;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            date = dateFormat.parse(birthday);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String birthday = dateFormat.format(date);

        String[] parts = birthday.split("-");

        String part1 = parts[0];
        String part2 = parts[1];
        String part3 = parts[2];
        int year = Integer.parseInt(part1);
        int month = Integer.parseInt(part2);
        int day = Integer.parseInt(part3);
        Calendar today = Calendar.getInstance();
        int actualYear = today.get(Calendar.YEAR);
        int actualMonth = today.get(Calendar.MONTH);
        int actualDay = today.get(Calendar.DAY_OF_MONTH);

        if (month > actualMonth) {
            age = (actualYear - year) - 1;
        } else if (month == actualMonth && day > actualDay) {
            age = (actualYear - year) - 1;
        } else {
            age = actualYear - year;
        }

        return age;
    }

    public String getStatPro() {

        String statPro = "";

        if (situtationpro == 13) {
            statPro = "Fonctionnaire";
        } else if (situtationpro == 12) {
            statPro = "Cadre Supérieur";
        } else if (situtationpro == 11) {
            statPro = "Cadre";
        } else if (situtationpro == 10) {
            statPro = "Micro-Entrepreneur";
        } else if (situtationpro == 9) {
            statPro = "Auto-Entrepreneur";
        } else if (situtationpro == 8) {
            statPro = "Salarié en CDI";
        } else if (situtationpro == 7) {
            statPro = "Intérimaire";
        } else if (situtationpro == 6) {
            statPro = "Salarié en CDD";
        } else if (situtationpro == 5) {
            statPro = "Apprenti";
        } else if (situtationpro == 4) {
            statPro = "Stagiaire";
        } else if (situtationpro == 3) {
            statPro = "&Eacute;tudiant";
        } else if (situtationpro == 2) {
            statPro = "Retraité";
        } else if (situtationpro == 1) {
            statPro = "Sans Emploi";
        }

        return statPro;
    }

    public String getNoteEp() {
        String _NoteEpargnant = "";
        int restant = revenus - depenses;

        if (restant < 0.05 * revenus) {
            _NoteEpargnant = "F";
        } else if (restant < 0.1 * revenus) {
            _NoteEpargnant = "E";
        } else if (restant < 0.2 * revenus) {
            _NoteEpargnant = "D";
        } else if (restant < 0.3 * revenus) {
            _NoteEpargnant = "C";
        } else if (restant < 0.4 * revenus) {
            _NoteEpargnant = "B";
        } else if (restant > 0.5 * revenus) {
            _NoteEpargnant = "A";
        }

        return _NoteEpargnant;
    }

    @Override
    public String getTableName() {
        this.tableName = "brclients";
        return this.tableName;
    }
}
