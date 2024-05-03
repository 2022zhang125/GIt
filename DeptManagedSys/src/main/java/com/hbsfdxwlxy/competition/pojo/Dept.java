package com.hbsfdxwlxy.competition.pojo;

import java.util.Objects;

public class Dept {
    private Long id;
    private String deptno;
    private String dname;
    private String loc;

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", deptno='" + deptno + '\'' +
                ", dname='" + dname + '\'' +
                ", loc='" + loc + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dept dept = (Dept) o;
        return Objects.equals(id, dept.id) && Objects.equals(deptno, dept.deptno) && Objects.equals(dname, dept.dname) && Objects.equals(loc, dept.loc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, deptno, dname, loc);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeptno() {
        return deptno;
    }

    public void setDeptno(String deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public Dept() {
    }

    public Dept(Long id, String deptno, String dname, String loc) {
        this.id = id;
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
    }
}
