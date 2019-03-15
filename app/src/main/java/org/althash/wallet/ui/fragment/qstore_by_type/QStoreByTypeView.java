package org.althash.wallet.ui.fragment.qstore_by_type;

import org.althash.wallet.model.gson.qstore.QSearchItem;
import org.althash.wallet.ui.base.base_fragment.BaseFragmentView;

import java.util.List;

public interface QStoreByTypeView extends BaseFragmentView {
    void setSearchResult(List<QSearchItem> items);

    void setSearchBarText(String text);

    String getSeacrhBarText();

    String getType();

    void setUpTitle(String type);
}
