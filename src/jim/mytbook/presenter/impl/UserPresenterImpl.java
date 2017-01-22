package jim.mytbook.presenter.impl;

import jim.mytbook.model.AsyncCallback;
import jim.mytbook.model.IUserModel;
import jim.mytbook.model.impl.UserModelImpl;
import jim.mytbook.presenter.IUserPresenter;
import jim.mytbook.view.IUserView;

public class UserPresenterImpl implements IUserPresenter{
	
	private IUserView view;
	private IUserModel model;
	

	public UserPresenterImpl(IUserView view) {
		super();
		this.view = view;
		model=new UserModelImpl();
	}


	@Override
	public void loadLogin(String email, String password) {
		model.login(email,password, new AsyncCallback() {
			
			@Override
			public void onSuccess(Object success) {
				view.showLoginResult();
			}
			
			@Override
			public void onError(Object error) {
				// TODO Auto-generated method stub
				
			}
		});
	}

}
