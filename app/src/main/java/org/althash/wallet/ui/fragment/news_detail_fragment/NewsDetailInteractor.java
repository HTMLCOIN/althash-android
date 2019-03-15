package org.althash.wallet.ui.fragment.news_detail_fragment;

import org.althash.wallet.model.news.News;

public interface NewsDetailInteractor {
    News getNews(int newsPosition);
}
