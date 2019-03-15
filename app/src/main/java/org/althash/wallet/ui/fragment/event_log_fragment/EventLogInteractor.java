package org.althash.wallet.ui.fragment.event_log_fragment;


import org.althash.wallet.model.gson.history.History;

public interface EventLogInteractor {
    History getHistory(String txHash);
}
