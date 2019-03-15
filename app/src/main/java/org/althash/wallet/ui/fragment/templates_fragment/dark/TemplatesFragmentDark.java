package org.althash.wallet.ui.fragment.templates_fragment.dark;

import org.althash.wallet.model.ContractTemplate;
import org.althash.wallet.ui.fragment.templates_fragment.TemplatesFragment;

import java.util.List;

public class TemplatesFragmentDark extends TemplatesFragment {

    @Override
    protected int getLayout() {
        return org.althash.wallet.R.layout.fragment_templates;
    }

    @Override
    public void setUpTemplateList(List<ContractTemplate> contractTemplateList) {
        initializeRecyclerView(contractTemplateList, org.althash.wallet.R.layout.item_template);
    }
}
