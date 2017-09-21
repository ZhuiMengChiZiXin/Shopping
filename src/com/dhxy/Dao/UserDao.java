package com.dhxy.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.dhxy.entity.Average_user;
import com.dhxy.entity.User;

/**
 * 用户信息
 * 
 * @author QiuShuang_pc
 *
 */
public class UserDao extends DataBaseDao {
	// 查找所有用户信息方法
	public List<User> chaxun() throws ClassNotFoundException, SQLException {
		load();
		List<User> arrayList = new ArrayList();// 用户信息存到集合
		ResultSet rs = stmt.executeQuery("SELECT * FROM userinfo");// mysql语句
		User user = null;// 定义User变量
		while (rs.next()) {
			user = new User();
			user.setUnumber(rs.getInt("unumber"));
			user.setUname(rs.getString("uname"));
			user.setUpassword(rs.getString("upassword"));
			user.setUphonenumber(rs.getInt("uphonenumber"));
			user.setAddress(rs.getString("address"));
			user.setIntegral(rs.getInt("integral"));
			arrayList.add(user);
		}
		closeAll();
		return arrayList;// 放回ArrayList集合

	}

	// 按照 name 和   password 查找用户
	public int inquiries(String uname, String upassword) throws ClassNotFoundException, SQLException {
		load();
		int count = 0;
		List<Average_user> arrayList = new ArrayList();
		ResultSet re = stmt
				.executeQuery("SELECT count(*) from uname where uname=" + uname + " and pwd=" + upassword + "");
		Average_user ae_user = new Average_user();
		if (re.next()) {
			count = re.getInt(1);
			System.out.println(count);
		}
		closeAll();
		return count;

	}

	// 按照编号查找
	public User number(int number) throws ClassNotFoundException, SQLException {
		load();
		ResultSet rs = stmt.executeQuery("SELECT unumber FROM User;");// mysql语句
		User user = new User();
		while (rs.next()) {
			user.setUnumber(rs.getInt("unumber"));
			user.setUname(rs.getString("uname"));
			user.setUpassword(rs.getString("upassword"));
			user.setUphonenumber(rs.getInt("uphonenumber"));
			user.setAddress(rs.getString("address"));
			user.setIntegral(rs.getInt("integral"));
		}
		closeAll();
		return user;

	}

	// 插入用户数据
	public int Uerinsert(User user) throws ClassNotFoundException, SQLException {
		load();
		String uname = user.getUname();
		String upassword = user.getUpassword();
		int uphonenumber = user.getUphonenumber();
		String address = user.getAddress();
		int integral = user.getIntegral();
		String sql = "INSERT INTO Userinfo(uname,upassword,uphonenumber,address,integral) VALUES(?,?,?,?,?);";
		return super.addAll(sql, uname, upassword, uphonenumber, address, integral);
		
		
	}

	// 普通用户单条信息
	public int getVarByUname(String Uname) throws ClassNotFoundException, SQLException {
		load();
		int count = 0;
		ResultSet re = stmt.executeQuery("SELECT count(*) from uname where uname=" + Uname + "");
		if (re.next()) {
			count = re.getInt(1);
		}
		closeAll();
		return count;
	}

	// 按照编号删除用户
	public int delAnswerUp(User user) throws ClassNotFoundException, SQLException {
		load();
		String sql = "DELETE FROM Userinfo WHERE unumber=?";
		return super.addAll(sql, user.getUnumber());
	}

	// 修改用户信息
	public int modify(User user) throws ClassNotFoundException, SQLException {
		load();
		String sql = "update Userinfo set uname=?,upassword=?,uphonenumber=?,address=?,integral=? where unumber=?;";
		return super.addAll(sql, user.getUname(), user.getUpassword(), user.getUphonenumber(), user.getAddress(),
				user.getIntegral());

	}
}
