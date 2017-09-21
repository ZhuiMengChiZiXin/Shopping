package com.dhxy.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dhxy.entity.Cashier;
import com.dhxy.entity.User;
/**
 *  收银�?
 * @author QiuShuang_pc
 *
 */
public class CashierDao extends DataBaseDao {
	public List<Cashier> chaxun() throws ClassNotFoundException, SQLException {// 查找�?有用户信息方�?
		load();
		List<Cashier> arrayList = new ArrayList();// 用户信息存到集合
		ResultSet rs = stmt.executeQuery("SELECT * FROM user;");// mysql语句
		Cashier cahier = null;// 定义User变量
		while (rs.next()) {
			cahier = new Cashier();
			cahier.setCnumber(rs.getInt("cnumber"));
			cahier.setCname(rs.getString("cname"));
			cahier.setCpassword(rs.getString("cpassword"));
			cahier.setCphonenumber(rs.getInt("cphonenumber"));
			arrayList.add(cahier);
		}
		closeAll();
		return arrayList;// 放回ArrayList集合

	}

	public int Cashier(Cashier cashier) throws ClassNotFoundException, SQLException {
		String cname = cashier.getCname();
		String cpassword = cashier.getCpassword();
		int cphonenumber = cashier.getCphonenumber();
		String str = "INSERT INTO cashier(cname,cpassword,cphonenumber) VALUES(?,?,?);";
		return super.addAll(str, cname, cpassword, cphonenumber);
	}

}
