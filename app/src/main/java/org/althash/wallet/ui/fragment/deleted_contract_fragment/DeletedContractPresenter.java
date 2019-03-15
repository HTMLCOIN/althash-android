package org.althash.wallet.ui.fragment.deleted_contract_fragment;


import org.althash.wallet.ui.base.base_fragment.BaseFragmentPresenter;

public interface DeletedContractPresenter extends BaseFragmentPresenter {
    void onUnubscribeClick(String contractAddress);
}
