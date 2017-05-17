/*
 * Copyright (C) 2015 Twitter, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.twitter.sdk.android.tweetui;

import com.twitter.sdk.android.core.models.HashtagEntity;
import com.twitter.sdk.android.core.models.UrlEntity;

class FormattedUrlEntity {
    int start;
    int end;
    final String displayUrl;
    final String url;
    final String expandedUrl;

    private static final String TWITTER_HASHTAG_URL = "https://twitter.com/hashtag/";

    FormattedUrlEntity(int start, int end, String displayUrl, String url, String expandedUrl) {
        this.start = start;
        this.end = end;
        this.displayUrl = displayUrl;
        this.url = url;
        this.expandedUrl = expandedUrl;
    }

    static FormattedUrlEntity createFormattedUrlEntity(UrlEntity entity) {
        return new FormattedUrlEntity(entity.getStart(), entity.getEnd(), entity.displayUrl,
                entity.url, entity.expandedUrl);
    }

    static FormattedUrlEntity createFormattedUrlEntity(HashtagEntity hashtagEntity) {
        final String url = TWITTER_HASHTAG_URL + hashtagEntity.text;
        return new FormattedUrlEntity(hashtagEntity.getStart(), hashtagEntity.getEnd(),
                "#" + hashtagEntity.text, url, url);
    }
}
