package org.althash.wallet.ui.fragment.watch_contract_fragment;

import org.althash.wallet.model.ContractTemplate;

public interface OnTemplateClickListener {
    void updateSelection(int adapterPosition);

    void onTemplateClick(ContractTemplate contractTemplate);
}
