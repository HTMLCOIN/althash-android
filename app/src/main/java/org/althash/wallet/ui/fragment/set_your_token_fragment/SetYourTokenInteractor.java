package org.althash.wallet.ui.fragment.set_your_token_fragment;

import org.althash.wallet.model.contract.ContractMethod;

public interface SetYourTokenInteractor {
    ContractMethod getContractConstructor(String uiid);
}
