package webappli.models;

public class Relations extends BaseModelORM {

    private Integer id;
    private Integer id_clients;
    private Integer id_categories;
    private String tableName;

    public Integer getId_clients() {
        return id_clients;
    }

    public Relations setId_clients(Integer id_clients) {
        this.id_clients = id_clients;
        return this;
    }

    public Integer getId_categories() {
        return id_categories;
    }

    public Relations setId_categories(Integer id_categories) {
        this.id_categories = id_categories;
        return this;
    }

    @Override
    public String getTableName() {
        this.tableName = "br_relations";
        return this.tableName;
    }
}
