package jim.mytbook.model.impl;

import java.util.Iterator;
import java.util.List;

import android.util.Log;
import jim.mytbook.app.MyApplication;
import jim.mytbook.entity.Books;
import jim.mytbook.entity.Cart;
import jim.mytbook.entity.CartItem;
import jim.mytbook.model.cratmodel.ICartItemModel;

public class CartItemModelImpl implements ICartItemModel{

	
	/**
	 * 获取购物车
	 */
	@Override
	public Cart getCart() {
		// TODO Auto-generated method stub
		return MyApplication.getCart();
	}

	/**
	 * 购买商品
	 * 	1，如果已经加入购物车，数量加1
	 * 		1.1使用迭代器遍历
	 * 	2，如果购物车中没有此商品，则加入购物车
	 */

	@Override
	public void buy(Books book) {
		//循环标记为false。判断购物车中是否已存在此商品
		boolean flag=false;
		Cart cart=MyApplication.getCart();
		List<CartItem> list=cart.getList();
		Iterator it=list.iterator();
		int id=book.getId();

		for(int position=0;position<list.size();position++){
			if(id==list.get(position).getBook().getId()){
				MyApplication.addCount(position);
				//循环标记为true
				flag=true;
				break;
			}
		}
		//判断循环标记，false为不存在，true为存在
		if(flag==false){
			MyApplication.addCartItem(book);
		}
		
	}

	@Override
	public float getTotalPrice(float price) {
		Cart cart=MyApplication.getCart();
		List<CartItem> list=cart.getList();
		Log.i("info",list.size()+"个商品");
		for(CartItem cartitem:list){
			price=(cartitem.getBook().getFixedPrice())*((float)cartitem.getCount());
			Log.i("info",price+"元");
		}
		return price;
	}

	


}
