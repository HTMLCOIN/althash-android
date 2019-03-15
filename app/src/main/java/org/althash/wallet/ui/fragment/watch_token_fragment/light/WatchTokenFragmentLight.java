package org.althash.wallet.ui.fragment.watch_token_fragment.light;

import org.althash.wallet.model.ContractTemplate;
import org.althash.wallet.ui.fragment.watch_contract_fragment.OnTemplateClickListener;
import org.althash.wallet.ui.fragment.watch_contract_fragment.TemplatesAdapter;
import org.althash.wallet.ui.fragment.watch_contract_fragment.WatchContractFragment;
import org.althash.wallet.ui.fragment.watch_token_fragment.WatchTokenFragment;
import org.althash.wallet.utils.FontManager;

import java.util.List;

public class WatchTokenFragmentLight extends WatchTokenFragment {

    @Override
    protected int getLayout() {
        return org.althash.wallet.R.layout.fragment_watch_token_light;
    }

    @Override
    public void initializeViews() {
        super.initializeViews();
        mEditTextContractName.setTypeface(FontManager.getInstance().getFont(getResources().getString(org.althash.wallet.R.string.proximaNovaSemibold)));
        mEditTextContractAddress.setTypeface(FontManager.getInstance().getFont(getResources().getString(org.althash.wallet.R.string.proximaNovaSemibold)));
    }

}
