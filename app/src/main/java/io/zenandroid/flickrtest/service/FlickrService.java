package io.zenandroid.flickrtest.service;

import android.support.annotation.Nullable;

import io.reactivex.Single;
import io.zenandroid.flickrtest.model.ImageListResponse;

/**
 * created by acristescu
 */

public interface FlickrService {
	Single<ImageListResponse> getImageList(@Nullable String tags);
}
