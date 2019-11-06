package webappli.models;

public class Categories extends BaseModelORM {

    private Integer id;
    private String nom;
    private String tableName;

    public Integer getId() {
        return id;
    }

    public Categories setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getNom() {
        return nom;
    }

    public Categories setNom(String nom) {
        this.nom = nom;
        return this;
    }
    @Override
    public String getTableName() {
        this.tableName = "brcategories";
        return this.tableName;
    }

}
