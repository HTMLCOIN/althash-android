package org.althash.wallet.ui.fragment.contract_management_fragment;

import org.althash.wallet.model.contract.Contract;
import org.althash.wallet.ui.base.base_fragment.BaseFragmentPresenter;

public interface ContractManagementPresenter extends BaseFragmentPresenter {
    Contract getContractByAddress(String contractAddress);
}
