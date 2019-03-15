package org.althash.wallet.ui.fragment.althash_cash_management_fragment;

import org.althash.wallet.model.AddressWithBalance;
import org.althash.wallet.ui.base.base_fragment.BaseFragmentView;

import java.util.List;

public interface AddressListView extends BaseFragmentView {
    void updateAddressList(List<AddressWithBalance> deterministicKeyWithBalance);
}
