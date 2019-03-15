package org.althash.wallet.ui.fragment.set_your_token_fragment;

import org.althash.wallet.model.contract.ContractMethodParameter;
import org.althash.wallet.ui.base.base_fragment.BaseFragmentView;

import java.util.List;

public interface SetYourTokenView extends BaseFragmentView {
    void onContractConstructorPrepared(List<ContractMethodParameter> params);
}
