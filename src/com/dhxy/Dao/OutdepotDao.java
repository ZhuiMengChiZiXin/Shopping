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
import com.dhxy.entity.OutDepot;
/**
 * 出库
 * @author QiuShuang_pc
 *
 */
public class OutdepotDao extends DataBaseDao {
	public List<OutDepot> chaxun() throws ClassNotFoundException, SQLException {// 查找�?有用户信息方�?
		load();
		List<OutDepot> arrayList = new ArrayList();// 用户信息存到集合
		ResultSet rs = stmt.executeQuery("SELECT * FROM outdepot");// mysql语句
		OutDepot outdepot = null;// 定义User变量
		while (rs.next()) {
			outdepot = new OutDepot();
			outdepot.setComnumber(rs.getInt("comnumber"));
			outdepot.setOutdenum(rs.getInt("outdenum"));
			outdepot.setOutdepottime(rs.getDate("outdepottime"));
			outdepot.setUnumber(rs.getInt("unumber"));
		}
		closeAll();
		return arrayList;// 放回ArrayList集合
	}
}
