package jim.mytbook.presenter.impl;

import jim.mytbook.entity.Cart;
import jim.mytbook.model.cratmodel.ICartItemModel;
import jim.mytbook.model.impl.CartItemModelImpl;
import jim.mytbook.presenter.ICartItemPresenter;
import jim.mytbook.view.ICartItemView;

public class CartItemPresenterImpl implements ICartItemPresenter{

	private ICartItemModel model;
	private ICartItemView view;
	
	public CartItemPresenterImpl( ICartItemView view) {
		super();
		this.view = view;
		model=new CartItemModelImpl();
	}

	@Override
	public void loadCartItem() {
		Cart cart =model.getCart();
		view.showList(cart.getList());
	}

	@Override
	public void loadTotalPrice(float price) {
		price=model.getTotalPrice(price);
		view.showPrice(price);
	}

}
