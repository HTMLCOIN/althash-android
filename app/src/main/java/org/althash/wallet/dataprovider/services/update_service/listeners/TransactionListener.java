package org.althash.wallet.dataprovider.services.update_service.listeners;

import org.althash.wallet.model.gson.history.History;

public interface TransactionListener {
    void onNewHistory(History history);

    boolean getVisibility();
}
