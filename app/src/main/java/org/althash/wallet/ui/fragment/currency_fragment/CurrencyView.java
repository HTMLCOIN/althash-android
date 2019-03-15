package org.althash.wallet.ui.fragment.currency_fragment;

import org.althash.wallet.model.Currency;
import org.althash.wallet.ui.base.base_fragment.BaseFragmentView;

import java.util.List;

public interface CurrencyView extends BaseFragmentView {
    void setCurrencyList(List<Currency> currencyList);
}
