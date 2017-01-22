package jim.mytbook.view;

public interface IUserView {
	/**
	 * 成功
	 *  @param success
	 */
	void showResult();
	/**
	 * 失败
	 * @param error
	 */
	void showResult(Object error);
	/**
	 * 验证码
	 * @param success
	 */
	void showImage(Object success);
}
