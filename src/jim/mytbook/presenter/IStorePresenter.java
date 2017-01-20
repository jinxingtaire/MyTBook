package jim.mytbook.presenter;

import java.util.List;

import jim.mytbook.entity.Books;
import jim.mytbook.view.IStoreView;

public interface IStorePresenter {
	public void loadRecommandBooks();
	public void loadHotBooks();
	public void loadNewBooks();
	
}
