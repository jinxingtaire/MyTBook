package jim.mytbook.view;

public interface IUserView {
	/**
	 * �ɹ�
	 *  @param success
	 */
	void showResult();
	/**
	 * ʧ��
	 * @param error
	 */
	void showResult(Object error);
	/**
	 * ��֤��
	 * @param success
	 */
	void showImage(Object success);
}
