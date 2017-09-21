package com.dhxy.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dhxy.entity.Commodity;
import com.dhxy.entity.InDepot;
/**
 * 入库  进货
 * @author QiuShuang_pc
 *
 */
public class IndepotDao extends DataBaseDao {
	public List<InDepot> chaxun() throws ClassNotFoundException, SQLException {// 查找�?有用户信息方�?
		load();
		List<InDepot> arrayList = new ArrayList();// 用户信息存到集合
		ResultSet rs = stmt.executeQuery("SELECT * FROM Indepot");// mysql语句
		InDepot indepot = null;// 定义User变量
		while (rs.next()) {
			indepot = new InDepot();
			indepot.setComnumber(rs.getInt("comnumber"));
			indepot.setIndenum(rs.getInt("indenum"));
			indepot.setIndepottime(rs.getDate("indepottime"));
			indepot.setSuppliernum(rs.getInt("suppliernum"));
			indepot.setInprice(rs.getDouble("inprice"));
		}
		closeAll();
		return arrayList;// 放回ArrayList集合
	}
}
