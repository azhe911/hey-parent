package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.hey.modle.CmsResult;
import org.hey.modle.UserInfo;
import org.hey.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import util.CommonUntl;


@Controller
@RequestMapping("/")
public class UploadFileController {
	
	@Autowired
	private ICustomerService customerService;

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	@ResponseBody
	public CmsResult uploadFile(@RequestParam("file") MultipartFile file,@RequestParam("marker")String marker) {
		//校验输入的季度是否合法，出于安全问题，放在后台校验
		if (marker == null || marker.equals("")) {
			//code暂时不定义
			return CommonUntl.getCmsResult(false, "季度不能为空", null);
		} else {
			boolean isExit = customerService.queryQuerter(marker);
			if (!isExit) {
				return CommonUntl.getCmsResult(false, "季度已存在,请重新输入!", null);
			}
		}
		
		
		List<UserInfo> lst = null;
		InputStream input = null;
		BufferedReader reader = null;
		try {
			lst = new ArrayList<UserInfo>();
			input = file.getInputStream();
			reader = new BufferedReader(new InputStreamReader(input,"GBK"));
			String line = null;
			while ((line = reader.readLine()) != null) {
				List<String> filed = new ArrayList<String>();
				String[] arr = line.split(" ");
				for(String str : arr) {
					if (str!=null && !str.equals("")) {
						filed.add(str);
					}
				}
				UserInfo userInfo = new UserInfo();
				Integer index = 0;
				for (String str:filed) {
					if (index == 0) {
						userInfo.setAreaCode(str);
					} else if (index == 1) {
						userInfo.setOrgCode(str);
					} else if (index == 2) {
						userInfo.setCardCode(str);
					} else if (index == 3) {
						userInfo.setAccount(str);
					} else if (index == 4) {
						userInfo.setUserName(str);
					} else if (index == 5) {
						userInfo.setBalance(str);
					} else if (index == 6) {
						userInfo.setInterestBase(str);
					} else if (index == 7) {
						userInfo.setInterestBalance(str);
					}
					index++;
				}
				lst.add(userInfo);
				//每轮赋值成功后，将对象置为null，便于gc回收，避免出现内存溢出
				userInfo = null;
				index = null;
			}
		}catch (Exception e) {
			return  CommonUntl.getCmsResult(false, "导入异常", null);
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
			}
		}
		System.out.println(lst.get(9086).toString());
		return CommonUntl.getCmsResult(true, "导入成功!", null);
	}
}
