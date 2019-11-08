package webappli.models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Clients extends BaseModelORM {

    // Données contenues en BDD
    private int id;
    private String nom;
    private String prenom;
    private String mail;
    private String telephone;
    private String adresse;
    private Date birthday;
    private int enfants;
    private boolean autoCnil;
    private boolean prospect;
    private int statusPro_id;
    private int statusPerso_id;
    private String tableName;
    // Méthodes pour une lecture plus claire de l'âge et des situations pro et perso.
    private float age;


    public Integer getId() {
        return id;
    }

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

    public Date getBirthday() {
        return birthday;
    }

    public Clients setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }

    public int getEnfants() {
        return enfants;
    }

    public Clients setEnfants(int enfants) {
        this.enfants = enfants;
        return this;
    }

    public boolean isAutoCnil() {
        return autoCnil;
    }

    public Clients setAutoCnil(boolean autoCnil) {
        this.autoCnil = autoCnil;
        return this;
    }

    public boolean isProspect() {
        return prospect;
    }

    public Clients setProspect(boolean prospect) {
        this.prospect = prospect;
        return this;
    }

    public int getStatusPro_id() {
        return statusPro_id;
    }

    public Clients setStatusPro_id(int statusPro_id) {
        this.statusPro_id = statusPro_id;
        return this;
    }

    public int getStatusPerso_id() {
        return statusPerso_id;
    }

    public Clients setStatusPerso_id(int statusPerso_id) {
        this.statusPerso_id = statusPerso_id;
        return this;
    }

    public float getAge() {
        int age;
        Date date = birthday;
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
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

    public Clients setAge(float age) {
        this.age = age;
        return this;
    }

    @Override
    public String getTableName() {
        this.tableName = "brclients";
        return this.tableName;
    }
}
