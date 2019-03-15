package org.althash.wallet.ui.fragment.store_categories;

import org.althash.wallet.model.gson.QstoreContractType;
import org.althash.wallet.ui.base.base_fragment.BaseFragmentView;

import java.util.List;

public interface StoreCategoriesView extends BaseFragmentView {
    void setUpCategoriesList(List<QstoreContractType> list, StoreCategoryViewHolder.OnCategoryClickListener listener);
}
