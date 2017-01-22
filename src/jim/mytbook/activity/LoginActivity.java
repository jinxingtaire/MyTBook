package jim.mytbook.activity;

import jim.mytbook.R;
import jim.mytbook.R.layout;
import jim.mytbook.presenter.IUserPresenter;
import jim.mytbook.presenter.impl.UserPresenterImpl;
import jim.mytbook.view.IUserView;
import android.app.Activity;
import android.content.Intent;
import android.graphics.LinearGradient;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity implements IUserView {

	private EditText etEmail;
	private EditText etPassword;
	private Button btnLogin;
	private TextView tvRegister;
	private IUserPresenter presenter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		setViews();
		setListeners();
	}

	private void setViews() {
		etEmail=(EditText) findViewById(R.id.etLoginEmail);
		etPassword=(EditText) findViewById(R.id.etLoginPassword);
		btnLogin=(Button) findViewById(R.id.btnLogin);
		tvRegister=(TextView) findViewById(R.id.tvRegister);
	}


	private void setListeners() {
		btnLogin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				presenter=new UserPresenterImpl(LoginActivity.this);
				String email=etEmail.getText().toString();
				String password=etPassword.getText().toString();
				presenter.loadLogin(email, password);
			}
		});
		tvRegister.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
			}
		});
	}

	@Override
	public void showResult() {
		Toast.makeText(this,"��½�ɹ�", 0).show();
		this.finish();
	}
	@Override
	public void showResult(Object error) {
		Log.i("info", "��½ʧ��"+error);
	}

	@Override
	public void showImage(Object success) {
		// TODO Auto-generated method stub
		
	}

}
