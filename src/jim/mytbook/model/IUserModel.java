package jim.mytbook.model;

import com.android.volley.RequestQueue;

public interface IUserModel {
	

	void login(String email,String pws,AsyncCallback callback);
}
