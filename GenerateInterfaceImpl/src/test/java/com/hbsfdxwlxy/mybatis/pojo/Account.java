package com.hbsfdxwlxy.mybatis.pojo;

/**
 * 用户类，用于封装用户数据对象
 * @author BelieveSun
 * @version 1.0
 * @since 1.0
 */
public class Account {
    private Long id;
    private String actno;
    private Double money;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", actno='" + actno + '\'' +
                ", money=" + money +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActno() {
        return actno;
    }

    public void setActno(String actno) {
        this.actno = actno;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Account(Long id, String actno, Double money) {
        this.id = id;
        this.actno = actno;
        this.money = money;
    }

    public Account() {
    }
}
