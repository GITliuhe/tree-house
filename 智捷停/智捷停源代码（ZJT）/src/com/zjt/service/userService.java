package com.zjt.service;

import com.zjt.dao.userDao;
import com.zjt.dao.userDao;
import com.zjt.dao.userDao;
import com.zjt.entity.user;

public class userService {

	public boolean loginVerify(String userName, String password) {
		userDao userDao = new userDao();
		user user = userDao.showInfo(userName);
		
		if(user.getPasswords().equals(password)){
			      return true;
		  }
	    else{
			      return false;
		    }
	}

	public boolean registVerify(String userName, String passwd1, String passwd2) {
		if(userName.length()<12 && 3<userName.length()){
            if(passwd1.equals(passwd2)&&(passwd1.length()>8)){
            	
            	
            	return true;
            
            }
            else{
            	return false;
            }
         }
		else{
			return false;
		}
	}

	public boolean exist(String userName) {
		userDao userDao = new userDao();
		user user=userDao.showInfo(userName);
		if(user!=null){
			return false;
		}
		else{
			return true;
		}
	}

	public void addUser(user user) {
		userDao userDao = new userDao();
		user newUser = new user();
		newUser = userDao.addUser(user);
		
		
		
	}

	public com.zjt.entity.user showInfo(String userName) {
		userDao userDao = new userDao();
		return userDao.showInfo(userName);
	}

	

}
