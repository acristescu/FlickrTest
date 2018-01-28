package io.zenandroid.flickrtest.dagger;

/**
 * created by acristescu
 */

import android.content.Context;
import android.support.annotation.VisibleForTesting;

public class Injector {

	private static AppComponent component;

	public static void init(Context context) {
		if (component == null) {
			component = DaggerAppComponent.builder().appModule(new AppModule()).build();
		}
	}

	public static AppComponent get() {
		return component;
	}

	@VisibleForTesting
	public static void setComponent(AppComponent component) {
		Injector.component = component;
	}
}
