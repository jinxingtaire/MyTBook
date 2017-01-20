package jim.mytbook.adapter;

import java.util.List;

import org.xutils.x;

import jim.mytbook.R;
import jim.mytbook.entity.Books;
import jim.mytbook.util.URLFactory;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyPagerAdapter extends BaseAdapter{
	
	private List<Books> list;
	private Context context;
	private LayoutInflater inflater;
	private ViewHolder holder;

	
	public MyPagerAdapter(List<Books> list, Context context) {
		super();
		this.list = list;
		this.context = context;		
		inflater=LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if(convertView==null){
			convertView=inflater.inflate(R.layout.item_gridview, null);
			holder=new ViewHolder();
			holder.tvName=(TextView) convertView.findViewById(R.id.tvName);
			holder.ivPhoto=(ImageView) convertView.findViewById(R.id.ivPhoto);
			convertView.setTag(holder);
			//ͼƬ
		}
		convertView.getTag();
		Books book=list.get(position);
		holder.tvName.setText(book.getProductName());
		x.image().bind(holder.ivPhoto, URLFactory.getBookImage(book.getProduct_pic()));
		return convertView;
	}
	
	class ViewHolder {
		TextView tvName;
		ImageView ivPhoto;
	}


	

}
