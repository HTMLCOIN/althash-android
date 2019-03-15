package org.althash.wallet.ui.fragment.template_library_fragment.dark;

import org.althash.wallet.model.ContractTemplate;
import org.althash.wallet.ui.fragment.template_library_fragment.TemplateLibraryFragment;

import java.util.List;

public class TemplateLibraryFragmentDark extends TemplateLibraryFragment {

    @Override
    protected int getLayout() {
        return org.althash.wallet.R.layout.fragment_template_library;
    }

    @Override
    public void setUpTemplateList(List<ContractTemplate> contractTemplateList) {
        initializeRecyclerView(contractTemplateList, org.althash.wallet.R.layout.item_template);
    }
}
