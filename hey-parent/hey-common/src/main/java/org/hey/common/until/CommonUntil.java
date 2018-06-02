package org.hey.common.until;

public class CommonUntil {

	/**
	 * 判断字符串是否为空
	 * @param str
	 * @return
	 */
	public boolean isNull(String str) {
		if (str == null || str.equals("")) {
			return false;
		} else {
			return true;
		}
	}
}
