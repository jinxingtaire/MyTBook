package jim.mytbook.model;

import java.util.List;

import jim.mytbook.entity.Books;

public interface IStoreModel {
	public void getHotBooks(GetCallBack callback);
	public void getNewBooks(GetCallBack callback);
	public void getRecommandBooks(GetCallBack callback);
}
