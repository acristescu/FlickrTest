package io.zenandroid.flickrtest.base;

/**
 * created by acristescu
 */

public interface View<T extends Presenter> {

	void showErrorMessage(String message);

	void showProgressDialog();

	void dismissProgressDialog();
}
