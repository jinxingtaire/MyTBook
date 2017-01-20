package jim.mytbook.presenter.impl;

import java.util.List;

import jim.mytbook.entity.Books;
import jim.mytbook.model.GetCallBack;
import jim.mytbook.model.IStoreModel;
import jim.mytbook.model.impl.StoreModelImpl;
import jim.mytbook.presenter.IStorePresenter;
import jim.mytbook.view.IStoreView;

public class StrorePresenterImpl implements IStorePresenter{

	private IStoreModel model;
	private IStoreView view;
	public StrorePresenterImpl(IStoreView view) {
		this.view=view;
		model=new StoreModelImpl();
	}
	@Override
	public void loadRecommandBooks() {
		model.getRecommandBooks(new GetCallBack() {
			
			@Override
			public void callBack(List<Books> list) {
				view.showRecommandList(list);
			}
		});
	}
	@Override
	public void loadHotBooks() {
		model.getHotBooks(new GetCallBack() {
			
			@Override
			public void callBack(List<Books> list) {
				view.showHotList(list);
			}
		});
		
	}
	@Override
	public void loadNewBooks() {
		model.getNewBooks(new GetCallBack() {
			
			@Override
			public void callBack(List<Books> list) {
				view.showNewList(list);
			}
		});
		
	}


}
