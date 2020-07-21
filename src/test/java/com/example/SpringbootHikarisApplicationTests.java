package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.*;

@SpringBootTest
class SpringbootHikarisApplicationTests {


    @Autowired
    public DataSource masterDataSource;

    @Autowired
    public DataSource slaveDataSource;
    @Test
    void contextLoads() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = masterDataSource.getConnection();
            DatabaseMetaData metaData = conn.getMetaData();
            System.out.println(metaData.getURL());
            stmt = conn.createStatement();
            rs = stmt.executeQuery(("SELECT * FROM TB_DEPT"));
            while(rs.next()){
                System.out.println(rs.getString(2)+"\t"+rs.getString(3));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(null != conn){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    void datasource2(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = slaveDataSource.getConnection();
            DatabaseMetaData metaData = conn.getMetaData();
            System.out.println(metaData.getURL());
            stmt = conn.createStatement();
            rs = stmt.executeQuery(("SELECT * FROM TB_DEPT"));
            while(rs.next()){
                System.out.println(rs.getString(2)+"\t"+rs.getString(3));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(null != conn){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
