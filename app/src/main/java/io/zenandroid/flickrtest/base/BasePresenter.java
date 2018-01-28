package io.zenandroid.flickrtest.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * created by acristescu
 */

public abstract class BasePresenter implements Presenter {

	private View view;
	private CompositeDisposable compositeDisposable = new CompositeDisposable();

	public BasePresenter(View view) {
		this.view = view;
	}

	protected void onError(Throwable throwable) {
		view.dismissProgressDialog();
		view.showErrorMessage(throwable.getMessage());
	}

	protected void addDisposable(Disposable disposable) {
		compositeDisposable.add(disposable);
	}

	@Override
	public void unsubscribe() {
		compositeDisposable.clear();
	}
}
