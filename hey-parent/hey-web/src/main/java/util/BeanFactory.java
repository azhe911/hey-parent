package util;

public class BeanFactory {

	/**
	 * 传入bean实例化
	 * @author liuhb
	 * @param clz
	 * @param <T>
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Object> T createBean(Class<T> clz) {
		T result = null;
		try {
			result = (T) Class.forName(clz.getName()).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
