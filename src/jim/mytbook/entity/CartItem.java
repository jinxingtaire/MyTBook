package jim.mytbook.entity;

public class CartItem {

	private  Books book;
	private  int count=0;
	
	public CartItem(Books book, int count) {
		super();
		this.book = book;
		this.count = count;
	}

	public CartItem (){}

	public Books getBook() {
		return book;
	}
	public void setBook(Books book) {
		this.book = book;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public void addCount(){
		this.count +=1;
	}

}
