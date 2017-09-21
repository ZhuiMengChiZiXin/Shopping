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
import com.dhxy.entity.User;
/**
 * 商品
 * @author QiuShuang_pc
 *
 */
public class CommodityDao extends DataBaseDao {
	public List<Commodity> chaxun() throws ClassNotFoundException, SQLException {// 查找�?有用户信息方�?
		load();
		List<Commodity> arrayList = new ArrayList();// 用户信息存到集合
		ResultSet rs = stmt.executeQuery("SELECT * FROM Commodity;");// mysql语句
		Commodity commodtiy = null;// 定义User变量
		while (rs.next()) {
			commodtiy = new Commodity();
			commodtiy.setComname(rs.getString("comname"));
			commodtiy.setStandard(rs.getString("standard"));
			commodtiy.setPrice(rs.getDouble("price"));
			commodtiy.setStock(rs.getInt("stock"));
			commodtiy.setIndepottime(rs.getDate("indepottime"));
			commodtiy.setLife(rs.getInt("life"));
		}
		closeAll();
		return arrayList;// 放回ArrayList集合
	}
}
