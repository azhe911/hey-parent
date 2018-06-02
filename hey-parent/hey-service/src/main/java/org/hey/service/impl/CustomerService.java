package org.hey.service.impl;

import java.util.List;

import org.hey.modle.UserInfo;
import org.hey.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ICustomerDao;

@Service
public class CustomerService implements ICustomerService{

	@Autowired
	public ICustomerDao customerDao;
	
	@Override
	public List<UserInfo> queryCustomerInfoByAccount(String account) {
		return customerDao.queryCustomerInfoByAccount(account);
	}

	/**
	 * 上传文件时，查询输入的季度是否已存在
	 */
	@Override
	public boolean queryQuerter(String quarter) {
		UserInfo userInfo = customerDao.queryQuarter(quarter);
		//查询的结果集为空，则说明当前输入的季度在数剧库中不存在
		if (userInfo == null) {
			return true;
		}
		return false;
	}

}
