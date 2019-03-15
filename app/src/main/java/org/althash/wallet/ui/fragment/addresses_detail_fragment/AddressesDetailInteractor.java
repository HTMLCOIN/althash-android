package org.althash.wallet.ui.fragment.addresses_detail_fragment;


import org.althash.wallet.model.gson.history.History;
import org.althash.wallet.model.gson.token_history.TokenHistory;


public interface AddressesDetailInteractor {
    History getHistory(String txHash);
    TokenHistory getTokenHistory(String txHash);
}
