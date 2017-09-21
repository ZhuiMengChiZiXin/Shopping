package com.dhxy.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dhxy.entity.InDepot;
import com.dhxy.entity.Supplier;
/**
 * 供应�?
 * @author QiuShuang_pc
 *
 */
public class SupplierDao extends DataBaseDao {
	public List<Supplier> chaxun() throws ClassNotFoundException, SQLException {// 查找�?有用户信息方�?
		load();
		List<Supplier> arrayList = new ArrayList();// 用户信息存到集合
		ResultSet rs = stmt.executeQuery("SELECT * FROM Supplier");// mysql语句
		Supplier supplier = null;// 定义User变量
		while (rs.next()) {
			supplier = new Supplier();
			supplier.setSuppliername(rs.getString("suppliername"));
			supplier.setSphonenum(rs.getInt("sphonenum"));
			supplier.setFactory(rs.getString("factory"));
		}
		closeAll();
		return arrayList;// 放回ArrayList集合
	}
}
