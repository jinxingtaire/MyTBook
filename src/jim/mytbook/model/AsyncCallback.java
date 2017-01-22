package jim.mytbook.model;

public interface AsyncCallback {

	void onSuccess(Object success);

	void onError(Object error);
}
