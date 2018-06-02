package controller;

import org.hey.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class QueryCustomerInfo {
	@Autowired
	public ICustomerService customerService;
	/**
	 * 
	  * queryCustomerInfo(根据账户查询用户信息)
	  * @Title: queryCustomerInfo
	  * @param @param account
	  * @param @return    设定文件
	  * @return Object    返回类型
	  * @throws
	  * @author liuhb
	 */
	@RequestMapping(value = "/queryCustomerInfo")
	@ResponseBody
	public Object queryCustomerInfo(String account) {
		return customerService.queryCustomerInfoByAccount(account);
	}
}
