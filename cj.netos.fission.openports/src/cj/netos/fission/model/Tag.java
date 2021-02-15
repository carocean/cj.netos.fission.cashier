package cj.netos.fission.model;

public class Tag {
    String id;
    String name;
    String opposite;
    int sort;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOpposite() {
        return opposite;
    }

    public void setOpposite(String opposite) {
        this.opposite = opposite;
    }
}
