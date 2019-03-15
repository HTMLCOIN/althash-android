package org.althash.wallet.ui.fragment.subscribe_tokens_fragment;

import org.althash.wallet.model.contract.Token;
import org.althash.wallet.ui.base.base_fragment.BaseFragmentPresenter;

import java.util.List;

public interface AddressesListTokenPresenter extends BaseFragmentPresenter {
    void onSubscribeChanged(Token token);
}
