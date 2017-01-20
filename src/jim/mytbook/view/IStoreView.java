package jim.mytbook.view;

import java.util.List;

import jim.mytbook.entity.Books;

public interface IStoreView {
	
	void showRecommandList(List<Books> list);
	void showHotList(List<Books> list);
	void showNewList(List<Books> list);

}
