package com.dhxy.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 数据�?
 * 
 * @author QiuShuang_pc
 *
 */
public class DataBaseDao {
	protected Connection conn = null;
	protected Statement stmt = null;
	protected PreparedStatement pstm;

	// 连接数据库
	protected void load() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping", "root", "root");
		stmt = conn.createStatement();
	}

	protected void closeAll() throws SQLException {
		if (stmt != null) {
			stmt.close();
		}
		if (conn != null) {
			conn.close();
		}
	}

	protected int addAll(String str, Object... obj) throws SQLException, ClassNotFoundException {
		load();
		pstm = conn.prepareStatement(str);
		for (int i = 0; i < obj.length; i++) {
			pstm.setObject(i + 1, obj[i]);
		}
		int count = pstm.executeUpdate();
		closeAll();
		return count;
	}

}
