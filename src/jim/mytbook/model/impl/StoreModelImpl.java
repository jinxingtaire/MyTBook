package jim.mytbook.model.impl;

import java.util.List;

import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

import jim.mytbook.app.MyApplication;
import jim.mytbook.entity.Books;
import jim.mytbook.entity.Resp;
import jim.mytbook.model.GetCallBack;
import jim.mytbook.model.IStoreModel;
import jim.mytbook.util.URLFactory;

public class StoreModelImpl implements IStoreModel{

	@Override
	public void getHotBooks(final GetCallBack callback) {
		RequestQueue queue=MyApplication.getRequestQueue();

		StringRequest sr=new StringRequest(URLFactory.getHotBookUrl(),
				new Listener<String>() {

					@Override
					public void onResponse(String response) {
						Log.i("info",  "�ɹ���"+response);
						Gson gson=new Gson();
						Resp resp=gson.fromJson(response, Resp.class);
						//�õ���Books�ļ���
						Log.i("info", resp.getData().get(0).getAuthor());
						callback.callBack(resp.getData());
					}
				}, new ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {
						Log.i("info",  "ʧ�ܣ�"+error.getMessage());
						
					}
				});
		queue.add(sr);
	}

	@Override
	public void getNewBooks(final GetCallBack callback) {
		RequestQueue queue=MyApplication.getRequestQueue();

		StringRequest sr=new StringRequest(URLFactory.getNewBookUrl(),
				new Listener<String>() {

					@Override
					public void onResponse(String response) {
						Log.i("info",  "�ɹ���"+response);
						Gson gson=new Gson();
						Resp resp=gson.fromJson(response, Resp.class);
						//�õ���Books�ļ���
						Log.i("info", resp.getData().get(0).getAuthor());
						callback.callBack(resp.getData());
					}
				}, new ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {
						Log.i("info",  "ʧ�ܣ�"+error.getMessage());
						
					}
				});
		queue.add(sr);
	}

	@Override
	public void getRecommandBooks(final GetCallBack callback) {
		RequestQueue queue=MyApplication.getRequestQueue();

		StringRequest sr=new StringRequest(URLFactory.getCommendBooksUrl(),
				new Listener<String>() {

					@Override
					public void onResponse(String response) {
						Log.i("info",  "�ɹ���"+response);
						Gson gson=new Gson();
						Resp resp=gson.fromJson(response, Resp.class);
						//�õ���Books�ļ���
						Log.i("info", resp.getData().get(0).getAuthor());
						callback.callBack(resp.getData());
					}
				}, new ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {
						Log.i("info",  "ʧ�ܣ�"+error.getMessage());
						
					}
				});
		queue.add(sr);
	}

}
