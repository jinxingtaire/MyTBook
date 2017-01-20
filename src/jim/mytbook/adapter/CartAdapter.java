package jim.mytbook.adapter;

import java.util.List;

import org.xutils.x;

import jim.mytbook.R;
import jim.mytbook.entity.CartItem;
import jim.mytbook.util.URLFactory;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
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

	public CartAdapter(List<CartItem> list, Context context,boolean isEdit) {
		super();
		this.list = list;
		this.context = context;
		this.isEdit=isEdit;
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
			convertView.setTag(holder);
			
		}
		convertView.getTag();
		holder.ivBookPic=(ImageView) convertView.findViewById(R.id.ivBookPic);
		x.image().bind(holder.ivBookPic, URLFactory.getBookImage(cartItem.getBook().getProduct_pic()));
		holder.tvBookName.setText(cartItem.getBook().getProductName());
		holder.tvPrice.setText(cartItem.getBook().getFixedPrice()+"");
		holder.tvCount.setText(cartItem.getCount()+"");
		if(!isEdit){
			holder.ivDel.setVisibility(View.GONE);
		}else{
			holder.ivDel.setImageResource(R.drawable.cart_ico_del);
		}

		return convertView;
	}

	class ViewHolder {

		ImageView ivBookPic;
		TextView tvBookName;
		TextView tvPrice;
		TextView tvCount;
		ImageView ivDel;

	}
}
