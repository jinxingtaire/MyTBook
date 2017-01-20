package jim.mytbook.util;



public class URLFactory {
	public static String getBookImage(String keyWord){
		String url="http://45.78.24.178:8080/dang/productImages/"+keyWord;
		return url;
	}

	
	public static String getCommendBooksUrl(){
		String url="http://45.78.24.178:8080/dang/main/getrecommend.action";
		return url;
	}
	public static String getHotBookUrl(){
		String url="http://45.78.24.178:8080/dang/main/gethot.action";
		return url;
	}
	public static String getNewBookUrl(){
		String url="http://45.78.24.178:8080/dang/main/getnew.action";
		return url;
	}
}
