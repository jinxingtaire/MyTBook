package jim.mytbook.activity;

import jim.mytbook.R;
import jim.mytbook.R.layout;
import jim.mytbook.presenter.IUserPresenter;
import jim.mytbook.presenter.impl.UserPresenterImpl;
import jim.mytbook.view.IUserView;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity implements IUserView {

	private EditText etEmail;
	private EditText etPassword;
	private Button btnLogin;
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
	}

	@Override
	public void showLoginResult() {
		Toast.makeText(this,"µÇÂ½³É¹¦", 0).show();
		this.finish();
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
	}

}
