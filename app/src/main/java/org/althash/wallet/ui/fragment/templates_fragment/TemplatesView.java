package org.althash.wallet.ui.fragment.templates_fragment;

import org.althash.wallet.model.ContractTemplate;
import org.althash.wallet.ui.base.base_fragment.BaseFragmentView;

import java.util.List;

public interface TemplatesView extends BaseFragmentView {
    void setUpTemplateList(List<ContractTemplate> contractTemplateList);
}
