package jim.mytbook.model.impl;

import java.util.HashMap;
import java.util.Map;

import jim.mytbook.app.MyApplication;
import jim.mytbook.entity.User;
import jim.mytbook.entity.UserInfo;
import jim.mytbook.model.AsyncCallback;
import jim.mytbook.model.IUserModel;
import jim.mytbook.util.URLFactory;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;


public class UserModelImpl implements IUserModel {

	private  RequestQueue queue;

	public UserModelImpl() {
		super();
		queue=MyApplication.getRequestQueue();
	}

	@Override
	public void login(final String email, final String pws, 
			final AsyncCallback callback) {
		String url=URLFactory.URL_USER_LOGIN;
		StringRequest request=new StringRequest(Request.Method.POST,url, new Listener<String>() {

			@Override
			public void onResponse(String response) {
				
				Gson gson=new Gson();
				UserInfo userInfo=gson.fromJson(response, UserInfo.class);
				MyApplication.setUsers(userInfo.getUser());
				callback.onSuccess(userInfo);
			}
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				Log.i("info", "Ê§°Ü"+error.toString());

			}
		}){
			@Override
			protected Map<String, String> getParams() throws AuthFailureError {
				// TODO Auto-generated method stub
		        Map<String, String> map = new HashMap<String, String>();  
		        map.put("email", email);  
		        map.put("password", pws);  
		        return map; 
			}
		};
		queue.add(request);

	}

}
