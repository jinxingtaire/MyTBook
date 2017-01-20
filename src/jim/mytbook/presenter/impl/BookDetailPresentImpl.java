package jim.mytbook.presenter.impl;

import jim.mytbook.entity.Books;
import jim.mytbook.model.cratmodel.ICartItemModel;
import jim.mytbook.model.impl.CartItemModelImpl;
import jim.mytbook.presenter.IBookDetailPresenter;
import jim.mytbook.view.IBookDetailView;

public class BookDetailPresentImpl implements IBookDetailPresenter{

	private ICartItemModel model;
	private IBookDetailView view;
	
	public BookDetailPresentImpl( IBookDetailView view) {
		super();
		model=new CartItemModelImpl();
		this.view = view;
	}

	@Override
	public void addToCart(Books book) {
		model.buy(book);
		view.addToCartSuccess();
	}

}
