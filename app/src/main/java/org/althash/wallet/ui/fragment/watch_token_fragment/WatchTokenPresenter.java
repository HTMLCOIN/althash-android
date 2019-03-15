package org.althash.wallet.ui.fragment.watch_token_fragment;

import org.althash.wallet.model.ContractTemplate;
import org.althash.wallet.ui.base.base_fragment.BaseFragmentPresenter;

public interface WatchTokenPresenter extends BaseFragmentPresenter {

    void onOkClick(String name, String address);

    void onContractAddressEntered(String contractAddress);

}
