package org.althash.wallet.dataprovider.services.update_service.listeners;

import org.althash.wallet.model.gson.token_balance.TokenBalance;

public interface TokenBalanceChangeListener {
    void onBalanceChange(TokenBalance tokenBalance);
}
