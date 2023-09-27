package com.MicroserviceProject.productservice.dto;

public class TableDB {
   private String table_name;
    private String owner;
    private String tablespace_name;

    @Override
    public String toString() {
        return "TableDB{" +
                "table_name='" + table_name + '\'' +
                ", owner='" + owner + '\'' +
                ", tablespace_name='" + tablespace_name + '\'' +
                '}';
    }

    public String getTable_name() {
        return table_name;
    }

    public void setTable_name(String table_name) {
        this.table_name = table_name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getTablespace_name() {
        return tablespace_name;
    }

    public void setTablespace_name(String tablespace_name) {
        this.tablespace_name = tablespace_name;
    }
}
