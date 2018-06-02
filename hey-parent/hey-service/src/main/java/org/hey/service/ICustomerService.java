package org.hey.service;

import java.util.List;

import org.hey.modle.UserInfo;

public interface ICustomerService {
	
	//根据账号查询客户信息
	List<UserInfo>  queryCustomerInfoByAccount(String account);
	//根据季度查询该季度数剧是否已经导入
	boolean queryQuerter(String quarter);
}
