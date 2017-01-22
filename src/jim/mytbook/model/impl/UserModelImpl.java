package jim.mytbook.model.impl;

import java.util.HashMap;
import java.util.Map;

import org.xutils.image.ImageOptions;

import jim.mytbook.app.MyApplication;
import jim.mytbook.entity.User;
import jim.mytbook.entity.UserInfo;
import jim.mytbook.model.AsyncCallback;
import jim.mytbook.model.IUserModel;
import jim.mytbook.request.MyRequest;
import jim.mytbook.util.URLFactory;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;


public class UserModelImpl implements IUserModel {

	private  RequestQueue queue;

	public UserModelImpl() {
		super();
		queue=MyApplication.getRequestQueue();
	}
	
	/**
	 * 登陆业务
	 */
	@Override
	public void login(final String email, final String pws, 
			final AsyncCallback callback) {
		String url=URLFactory.URL_USER_LOGIN;
		MyRequest request=new MyRequest(Request.Method.POST,url, new Listener<String>() {

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
				String errorMessage=error.getMessage();
				callback.onError(errorMessage);

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
	/**
	 * 注册业务
	 */
	@Override
	public void register(final User user, final String code,
			final AsyncCallback callback) {
		String url=URLFactory.URL_USER_REGIST;
		MyRequest request=new MyRequest(Request.Method.POST,
				url,
				new Listener<String>() {

					@Override
					public void onResponse(String response) {
						callback.onSuccess(response);
					}
				}, new ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {
						String errorMessage=error.getMessage();
						MyApplication.user=null;
						callback.onError(errorMessage);
					}
				}){
			@Override
			protected Map<String, String> getParams()
					throws AuthFailureError {
				HashMap<String,String> map=new HashMap<String, String>();
				map.put("user.email",user.getEmail());
				map.put("user.nickname",user.getNickname());
				map.put("user.password", user.getPassword());
				map.put("number", code);
				return map;
			}
		};
		queue.add(request);
	}
	/**
	 * 获取验证码
	 */
	@Override
	public void getCode(final AsyncCallback callback) {
		String url=URLFactory.URL_GET_IMAGE_CODE;
		ImageRequest request=new ImageRequest(url,
				new Listener<Bitmap>() {
					@Override
					public void onResponse(Bitmap response) {
						callback.onSuccess(response);
					}
				}, 
				130,
				50, 
				Config.RGB_565,
				new ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
					String errorMessage=error.getMessage();
					callback.onError(errorMessage);
					}
				}){
			@Override
			protected Response<Bitmap> parseNetworkResponse(
					NetworkResponse response) {
				Map<String,String> headers=response.headers;
				String sessionid=headers.get("Set-Cookie");
				if(sessionid!=null){
					MyRequest.JSESSIONID = sessionid.split(";")[0];
				}
				return super.parseNetworkResponse(response);
			}
		};
		queue.add(request);
	}
}
