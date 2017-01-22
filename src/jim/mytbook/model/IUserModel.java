package jim.mytbook.model;

import jim.mytbook.entity.User;

import com.android.volley.RequestQueue;

public interface IUserModel {
	

	void login(String email,String pws,AsyncCallback callback);
	void register(User user,String code,AsyncCallback callback);
	void getCode(AsyncCallback callback);
}
