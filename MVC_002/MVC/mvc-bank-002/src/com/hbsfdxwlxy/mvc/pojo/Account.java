package com.hbsfdxwlxy.mvc.pojo;

import java.util.Objects;

/**
 * @author BeleveSun
 * @version 1.0
 * @since 1.0
 *
 * 该类是一个简单的Javabean类，拥有Account的属性和私有方法，对账户类进行包装
 * 也叫pojo、domain
 * <p>
 * 数据库结构
 *  id bigint
 *  actno varchar(255)
 *  balance decimal
 */
public class Account {
    // 这里用引用数据结构为了防止出现空指针引用
    private Long id;
    private String actno;
    private Double balance;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) && Objects.equals(actno, account.actno) && Objects.equals(balance, account.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, actno, balance);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", actno='" + actno + '\'' +
                ", balance=" + balance +
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

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Account() {
    }

    public Account(Long id, String actno, Double balance) {
        this.id = id;
        this.actno = actno;
        this.balance = balance;
    }
}
