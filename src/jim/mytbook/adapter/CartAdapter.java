package jim.mytbook.adapter;

import java.util.List;

import org.xutils.x;

import jim.mytbook.R;
import jim.mytbook.entity.CartItem;
import jim.mytbook.fragment.CartFragment;
import jim.mytbook.model.cratmodel.ICartItemModel;
import jim.mytbook.model.impl.CartItemModelImpl;
import jim.mytbook.util.URLFactory;
import jim.mytbook.view.ICartItemView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class CartAdapter extends BaseAdapter{

	private List<CartItem> list;
	private Context context;
	private LayoutInflater inflater;
	private ViewHolder holder;
	private boolean isEdit;
	private ICartItemView view;
	private ICartItemModel model;
	private float price;

	public CartAdapter(List<CartItem> list, Context context,
			boolean isEdit,float price,ICartItemView view) {
		super();
		this.list = list;
		this.context = context;
		this.isEdit=isEdit;
		this.view=view;
		this.price=price;
		inflater=LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public CartItem getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		CartItem cartItem=list.get(position);
		if(convertView==null){
			holder =new ViewHolder();
			convertView=inflater.inflate(R.layout.item_cartinfo_lv_cartitem, null);
			holder.ivBookPic=(ImageView) convertView.findViewById(R.id.ivBookPic);
			holder.tvBookName=(TextView) convertView.findViewById(R.id.tvBookName);
			holder.tvPrice=(TextView) convertView.findViewById(R.id.tvPrice);
			holder.tvCount=(TextView) convertView.findViewById(R.id.tvCount);
			holder.ivDel=(ImageView) convertView.findViewById(R.id.ivDel);
			holder.ivm=(ImageView) convertView.findViewById(R.id.ivm);
			holder.ivp=(ImageView) convertView.findViewById(R.id.ivp);
			holder.tvNum=(TextView) convertView.findViewById(R.id.tvNum);
			//  主要是自定义adapter和自定义监听，可以实现button ，listView同时监听
			//	注意:实现同时监听，必须把button（有取得焦点的东西）设置为false，可以在xml里面设置，也可以在adapter中设置
			//	例如:holder.btn.setFocusable(false);
			holder.ivDel.setFocusable(false);
			holder.ivm.setFocusable(false);
			holder.ivp.setFocusable(false);
			//	设置监听
			setListener(position);
			convertView.setTag(holder);

		}
		convertView.getTag();
		holder.ivBookPic=(ImageView) convertView.findViewById(R.id.ivBookPic);
		x.image().bind(holder.ivBookPic, URLFactory.getBookImage(cartItem.getBook().getProduct_pic()));
		holder.tvBookName.setText(cartItem.getBook().getProductName());
		holder.tvPrice.setText(cartItem.getBook().getFixedPrice()+"");
		holder.tvCount.setText(cartItem.getCount()+"");
		//根据编辑的状态判断是否显示删除
		if(!isEdit){
			holder.ivDel.setVisibility(View.GONE);

		}else{
			holder.ivDel.setImageResource(R.drawable.cart_ico_del);
		}

		return convertView;
	}

	private void setListener(final int position) {

		holder.ivDel.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				delateGoods(list.get(position));
				
				getPresenter();
				notifyDataSetChanged(); 
				
			}
		});
		holder.ivm.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				mGoods(list.get(position));
				getPresenter();
				notifyDataSetChanged(); 

			}
		});
		holder.ivp.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				pGoods(list.get(position));
				notifyDataSetChanged(); 
				getPresenter();
			}
		});
		//更新价格

	}
	/**
	 * 商品数量减一
	 */
	protected void mGoods(CartItem cartItem) {
		if(cartItem.getCount()>1){
			cartItem.setCount((cartItem.getCount()-1));
		}else if(cartItem.getCount()<=1){
			delateGoods(cartItem);
		}
	}
	/**
	 * 商品数量加一
	 */
	protected void pGoods(CartItem cartItem) {
		cartItem.setCount((cartItem.getCount()+1));
	}

	/**
	 * 删除商品
	 */
	private void delateGoods(CartItem c){
		list.remove(c);
		c.setCount(0);
		c=null;
	}
	/**
	 * adapter充当presener。调用model与view并更新价格
	 */
	public void getPresenter(){
		model=new CartItemModelImpl();
		price=model.getTotalPrice(price);
		view.showPrice(price);
	}

	class ViewHolder {

		ImageView ivBookPic;
		TextView tvBookName;
		TextView tvPrice;
		TextView tvCount;
		ImageView ivDel;
		ImageView ivm;
		ImageView ivp;
		TextView tvNum;

	}
}
