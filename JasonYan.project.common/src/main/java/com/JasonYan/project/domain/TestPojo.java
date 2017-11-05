package com.JasonYan.project.domain;

import java.io.Serializable;

/**
 * 说明:
 *
 * @author jasonyan
 * @create 2017-11-02 16:53
 */
public class TestPojo implements Serializable {

    private int id;
    private Long product_id;
    private String product_name;
    private double product_price;
    private long product_sale_qty;

    public void setId(int id) {
        this.id = id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }

    public void setProduct_sale_qty(long product_sale_qty) {
        this.product_sale_qty = product_sale_qty;
    }

    public int getId() {
        return id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public double getProduct_price() {
        return product_price;
    }

    public long getProduct_sale_qty() {
        return product_sale_qty;
    }

    public TestPojo() {
    }

    @Override
    public String toString() {
        return "TestPojo{" +
                "id=" + id +
                ", product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                ", product_price=" + product_price +
                ", product_sale_qty=" + product_sale_qty +
                '}';
    }
}
