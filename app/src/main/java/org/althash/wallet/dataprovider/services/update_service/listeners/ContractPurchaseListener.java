package org.althash.wallet.dataprovider.services.update_service.listeners;

import org.althash.wallet.model.gson.qstore.ContractPurchase;

public interface ContractPurchaseListener {
    void onContractPurchased(ContractPurchase purchaseData);
}
