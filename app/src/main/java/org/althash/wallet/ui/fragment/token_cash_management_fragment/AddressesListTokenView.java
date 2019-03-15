package org.althash.wallet.ui.fragment.token_cash_management_fragment;

import android.os.Handler;

import org.althash.wallet.dataprovider.services.update_service.UpdateService;
import org.althash.wallet.model.AddressWithTokenBalance;
import org.althash.wallet.ui.base.base_fragment.BaseFragmentView;

import java.util.List;

public interface AddressesListTokenView extends BaseFragmentView {
    void updateAddressList(List<AddressWithTokenBalance> deterministicKeyWithBalance, String currency);

    UpdateService getSocketInstance();

    Handler getHandler();

    void hideTransferDialog();

    void goToSendFragment(AddressWithTokenBalance keyWithTokenBalanceFrom, AddressWithTokenBalance keyWithBalanceTo, String amountString, String contractAddress);
}
