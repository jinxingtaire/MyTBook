package jim.mytbook.fragment;

import org.xutils.x;

import jim.mytbook.R;
import jim.mytbook.entity.Books;
import jim.mytbook.util.URLFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class GoodsFragment extends Fragment{
	private ImageView ivBookPhoto;
	private TextView tvBookName;
	private TextView tvBookPrice;
	private TextView tvAuthor;
	private TextView tvProductName;
	private TextView tvProductTime;
	
	private Books book;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View view=inflater.inflate(R.layout.fragment_goods_main, null);
		Bundle bundle=getArguments();
		book=(Books) bundle.getSerializable(Books.key);
		setView(view);
		return view;
	}
	private void setView(View view) {
		ivBookPhoto=(ImageView) view.findViewById(R.id.iv_goods_photo);
		tvBookName=(TextView) view.findViewById(R.id.tv_goods_name);
		tvBookPrice=(TextView) view.findViewById(R.id.tv_good_price);
		tvAuthor=(TextView) view.findViewById(R.id.tv_author_name_title);
		tvProductName=(TextView) view.findViewById(R.id.tv_product_name);
		tvProductTime=(TextView) view.findViewById(R.id.tv_product_time);
		
		x.image().
		bind(ivBookPhoto, URLFactory.getBookImage(book.getProduct_pic()));
		tvBookName.setText(book.getProductName());
		tvBookPrice.setText(book.getDangPrice());
		tvAuthor.setText(book.getAuthor());
		tvProductTime.setText(book.getPrintTime());
	}
	public void getBook(Books book){
		this.book=book;
	}

}
