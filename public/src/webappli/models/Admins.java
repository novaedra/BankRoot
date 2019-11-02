package webappli.models;

public class Admins extends BaseModelORM {
    private Integer id;
    private String nom;
    private String prenom;
    private String ident;
    private String password;
    private String twoFactorKey;
    private String birthday;
    private String adresse;
    private String mail;
    private String telephone;
    private Boolean supAdmin;
    private String tableName;

    public Integer getId() {
        return id;
    }


    public String getNom() {
        return nom;
    }

    public Admins setNom(String nom) {
        this.nom = nom;

        return this;
    }

    public String getPrenom() {
        return prenom;
    }

    public Admins setPrenom(String prenom) {
        this.prenom = prenom;
        return this;
    }

    public String getIdent(String ident) {
        return this.ident;
    }

    public Admins setIdent(String ident) {
        this.ident = ident;
        return this;
    }

    public String getPassword() {
        return this.password;
    }

    public Admins setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getTwoFactorKey() {
        return twoFactorKey;
    }

    public void setTwoFactorKey(String twoFactorKey) {
        this.twoFactorKey = twoFactorKey;
    }

    public String getBirthday() {
        return birthday;
    }

    public Admins setBirthday(String birthday) {
        this.birthday = birthday;
        return this;
    }

    public String getAdresse() {
        return adresse;
    }

    public Admins setAdresse(String adresse) {
        this.adresse = adresse;
        return this;
    }

    public String getMail() {
        return this.mail;
    }

    public Admins setMail(String mail) {
        this.mail = mail;
        return this;
    }

    public String getTelephone() {
        return telephone;
    }

    public Admins setTelephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    public Boolean getSupAdmin() {
        return supAdmin;
    }

    public Admins setSupAdmin(Boolean supAdmin) {
        this.supAdmin = supAdmin;
        return this;
    }

    @Override
    public String getTableName() {
        this.tableName = "bradmin";
        return this.tableName;
    }
}
