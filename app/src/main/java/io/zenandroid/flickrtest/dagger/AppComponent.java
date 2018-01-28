package io.zenandroid.flickrtest.dagger;

import dagger.Component;
import io.zenandroid.flickrtest.feed.FeedActivity;

/**
 * created by acristescu
 */

@Component(modules={AppModule.class, FlickrServiceModule.class})
public interface AppComponent {

	void inject(FeedActivity activity);

}
