package com.infotech.hibernate.dao;

import java.util.List;
import com.infotech.hibernate.Login;


public interface LoginDAO {
	public boolean loadUser(int ascId, String pwd);
	/*public String getRole(int ascId);*/
	public int getRole(int ascId);
	public boolean getAscIdList(int ascId);
}
