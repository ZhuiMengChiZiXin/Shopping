package com.dhxy.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dhxy.entity.Admin;
import com.dhxy.entity.User;

/**
 * 管理�?
 * 
 * @author QiuShuang_pc
 *
 */
public class AdminDao extends DataBaseDao {
	// 用集合查询全�?
	public List<Admin> chaoxun() throws ClassNotFoundException, SQLException {
		load();
		List<Admin> arrayList = new ArrayList();
		ResultSet rs = stmt.executeQuery("SELECT * FROM Admin;");// mysql语句
		Admin admin = null;
		while (rs.next()) {
			admin = new Admin();
			admin.setAnumber(rs.getInt("anumber"));
			admin.setAname(rs.getString("aname"));
			admin.setApassword(rs.getString("apassword"));
			admin.setAphontnumber(rs.getInt("aphontnumber"));
			arrayList.add(admin);
		}
		closeAll();
		return arrayList;
	}

	// 添加管理�?
	public int tj(Admin admin) throws ClassNotFoundException, SQLException {
		String aname = admin.getAname();
		String apassword = admin.getApassword();
		int aphonenumber = admin.getAphontnumber();
		String str = "INSERT INTO Admin(aname,apassword,aphonenumber) VALUES(?,?,?);";
		return super.addAll(str, aname, apassword, aphonenumber);

	}

	// 按编号删除管理员
	public int delAnswerUp(Admin admin) throws ClassNotFoundException, SQLException {
		String sql = "DELETE FROM Admin WHERE anumber=?";
		return super.addAll(sql, admin.getAnumber());
	}

	// 修改管理员信�?
	public int modify(Admin admin) throws ClassNotFoundException, SQLException {
		String sql = "update Admin set aname=?,apassword=?,aphonenumber=?";
		return super.addAll(sql, admin.getAname(), admin.getApassword(), admin.getAphontnumber());

	}
}
