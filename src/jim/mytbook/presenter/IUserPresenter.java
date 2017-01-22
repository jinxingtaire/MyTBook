package jim.mytbook.presenter;

import jim.mytbook.entity.User;
import jim.mytbook.model.AsyncCallback;

public interface IUserPresenter {
	
	void loadLogin(String email,String password);
	void loadRegiseter(User user,String code);
	void loadCode();
}
