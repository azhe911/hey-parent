package util;

import org.hey.modle.CmsResult;

public class CommonUntl {

	
	//简化返回类
	public static CmsResult getCmsResult(boolean isSuccess,String message,String code)  {
		CmsResult cmsResult = BeanFactory.createBean(CmsResult.class);
		cmsResult.setCode(code);
		cmsResult.setMessage(message);
		cmsResult.setSuccess(isSuccess);
		return cmsResult;
	}
}
