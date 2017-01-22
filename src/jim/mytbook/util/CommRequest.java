package jim.mytbook.util;

import java.util.HashMap;
import java.util.Map;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.StringRequest;

public class CommRequest extends Request<String>{
	private final Listener<String> mListener;
	private String email;
	private String pwd;
	private String code;

	public CommRequest(int method, String url, Listener<String> listener,ErrorListener errorListener) {
		super(method, url,errorListener);
		mListener=listener;
	}
	@Override
	protected Response<String> parseNetworkResponse(NetworkResponse response) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	protected void deliverResponse(String response) {
		mListener.onResponse(response);
	}

}
