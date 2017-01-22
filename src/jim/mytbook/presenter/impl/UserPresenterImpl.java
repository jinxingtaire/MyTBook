package jim.mytbook.presenter.impl;


import jim.mytbook.entity.User;
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
				view.showResult();
			}
			
			@Override
			public void onError(Object error) {
				view.showResult(error);
			}
		});
	}


	@Override
	public void loadRegiseter(User user,String code) {
		model.register(user, code, new AsyncCallback() {
			
			@Override
			public void onSuccess(Object success) {
				view.showResult();
			}
			
			@Override
			public void onError(Object error) {
				view.showResult(error);
			}
		});
	}


	@Override
	public void loadCode() {
		model.getCode(new AsyncCallback() {
			
			@Override
			public void onSuccess(Object success) {
				view.showImage(success);
			}
			
			@Override
			public void onError(Object error) {
				// TODO Auto-generated method stub
				
			}
		});
	}

}
