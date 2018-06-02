package dao;

import java.util.List;

import org.hey.modle.UserInfo;

public interface ICustomerDao {
	List<UserInfo>  queryCustomerInfoByAccount(String account);
	
	UserInfo queryQuarter(String quarter);
}
