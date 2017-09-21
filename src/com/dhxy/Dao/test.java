package com.dhxy.Dao;

import java.sql.Array;
import java.sql.SQLException;
import java.util.List;

import com.dhxy.entity.User;

public class test {

	public static void main(String[] args){
		UserDao ud = new UserDao();
		List<User> userlist;
		try {
			userlist = ud.chaxun();
			for (User user : userlist) {
				System.out.println("姓名："+user.getUname()+"密码："
						+ user.getUpassword()+"手机号："
						+ user.getUphonenumber()+"地址："
						+ user.getAddress()+"积分："
						+ user.getIntegral());
			}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

}
