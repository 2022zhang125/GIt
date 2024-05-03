package com.hbsfdxwlxy.mvc.dao;

import com.hbsfdxwlxy.mvc.bean.Account;
import com.hbsfdxwlxy.mvc.exception.NullAccountException;
import com.hbsfdxwlxy.mvc.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author BelieceSun
 * @version 1.0
 * @since 1.0
 *
 * 该类用于处理数据库的CRUD操作，将其封装为方法
 */
public class ActDao {
    /**
     * 数据库插入操作
     * @param act Account对象
     * @return 返回插入的条数
     */
    public int insert(Account act){
        // 连接数据库，插入数据
        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;// 禁用自动提交
        try {
            conn = DBUtils.getConnection();
            String sql = "insert into t_act(actno,balance) values(?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,act.getActno());
            ps.setDouble(2,act.getBalance());
            count = ps.executeUpdate();
            // 手动提交事务
            conn.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtils.close(conn,ps,null);
        }
        return count;
    }

    /**
     * 数据库删除操作,根据id删除对应的记录条数
     * @param id id
     * @return 返回成功条数
     */
    public int deleteById(String id){
        int count = 0;
        Connection conn = null;
        PreparedStatement ps =null;
        try {
            conn =DBUtils.getConnection();
            String sql = "delete from t_act where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,id);
            count = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtils.close(conn,ps,null);
        }
        return count;
    }

    /**
     * 根据Account对象来更新数据
     * @param act Account对象
     * @return 返回更新条数
     */
    public int update(Account act){
        int count = 0;
        Connection conn = null;
        PreparedStatement ps =null;
        try {
            conn =DBUtils.getConnection();
            String sql = "update t_act set actno = ?,balance = ? where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,act.getActno());
            ps.setDouble(2,act.getBalance());
            ps.setLong(3,act.getId());
            count = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtils.close(conn,ps,null);
        }
        return count;
    }

    /**
     * 通过Actno进行查询
     * @param actno 用户名
     * @return 返回查询后的用户对象
     */
    public Account selectFromActno(String actno){
        Connection conn = null;
        PreparedStatement ps =null;
        ResultSet rs = null;
        Account act = null;
        try {
            conn =DBUtils.getConnection();
            String sql = "select * from t_act where actno = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,actno);
            rs = ps.executeQuery();
            if (rs.next()) {
                Long id = rs.getLong("id");
                Double balance = rs.getDouble("balance");
                act = new Account(id, actno, balance);
            }else{
                // 数据库中没有这个对象
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtils.close(conn,ps,null);
        }
        return act;
    }

    /**
     * 直接查询出所有的Account对象
     * @return 返回所有用户对象数组
     */
    public List<Account> selectAll(){
        Connection conn = null;
        PreparedStatement ps =null;
        ResultSet rs = null;
        Account act = null;
        List<Account> list = new ArrayList<>();
        try {
            conn =DBUtils.getConnection();
            String sql = "select * from t_act";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Long id = rs.getLong("id");
                String actno = rs.getString("actno");
                Double balance = rs.getDouble("balance");
                act = new Account(id, actno, balance);
                list.add(act);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtils.close(conn,ps,null);
        }
        return list;
    }
}
