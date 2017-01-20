package jim.mytbook.fragment;

import java.util.List;

import jim.mytbook.R;
import jim.mytbook.activity.GoodsActivity;
import jim.mytbook.adapter.MyPagerAdapter;
import jim.mytbook.entity.Books;
import jim.mytbook.model.impl.StoreModelImpl;
import jim.mytbook.presenter.IStorePresenter;
import jim.mytbook.presenter.impl.StrorePresenterImpl;
import jim.mytbook.view.IStoreView;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class ShoppingFragment extends Fragment implements IStoreView,OnItemClickListener{

	private IStorePresenter presenter;
	private MyPagerAdapter adapter;
	private	List<Books> recommandList;
	private	List<Books> hotList;
	private	List<Books> newList;
	private GridView gvRecommand;
	private GridView gvHot;
	private GridView gvNew;
	//  ≈‰∆˜
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view=inflater.inflate(R.layout.fragment_store, null);
		gvRecommand=(GridView) view.findViewById(R.id.gv_recommand);
		gvHot=(GridView) view.findViewById(R.id.gv_hot);
		gvNew=(GridView) view.findViewById(R.id.gv_new);
		presenter=new StrorePresenterImpl(this);
		presenter.loadRecommandBooks();
		presenter.loadHotBooks();
		presenter.loadNewBooks();
		setListener();
		return view;
	}

	@Override
	public void showRecommandList(List<Books> list) {
		recommandList=list;
		adapter=new MyPagerAdapter(list, getActivity());
		gvRecommand.setAdapter(adapter);
		
	}
	@Override
	public void showHotList(List<Books> list) {
		hotList=list;
		adapter=new MyPagerAdapter(list, getActivity());
		gvHot.setAdapter(adapter);
		
	}
	@Override
	public void showNewList(List<Books> list) {
		newList=list;
		adapter=new MyPagerAdapter(list, getActivity());
		gvNew.setAdapter(adapter);
		
	}
	private void setListener() {
		gvRecommand.setOnItemClickListener(this);
		gvHot.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Books book=hotList.get(position);
				Intent intent=new Intent(getActivity(),GoodsActivity.class);
				Bundle bBook=new Bundle();
				bBook.putSerializable("1000001", book);
				intent.putExtras(bBook);
				startActivity(intent);
				
			}
		});
		gvNew.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Books book=newList.get(position);
				Intent intent=new Intent(getActivity(),GoodsActivity.class);
				Bundle bBook=new Bundle();
				bBook.putSerializable("1000001", book);
				intent.putExtras(bBook);
				startActivity(intent);		
			}
		});
	}
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Books book=recommandList.get(position);
		Intent intent=new Intent(getActivity(),GoodsActivity.class);
		Bundle bBook=new Bundle();
		bBook.putSerializable("1000001", book);
		intent.putExtras(bBook);
		startActivity(intent);
	}



}
