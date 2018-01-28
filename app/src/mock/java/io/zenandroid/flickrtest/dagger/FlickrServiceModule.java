package io.zenandroid.flickrtest.dagger;

import dagger.Binds;
import dagger.Module;
import io.zenandroid.flickrtest.service.FlickrService;
import io.zenandroid.flickrtest.service.MockFlickrService;

/**
 * created by acristescu
 */
@Module
public abstract class FlickrServiceModule {

	@Binds
	abstract FlickrService provideBBCService(MockFlickrService bbcService);
}
