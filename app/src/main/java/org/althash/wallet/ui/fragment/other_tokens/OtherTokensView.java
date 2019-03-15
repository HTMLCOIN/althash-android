package org.althash.wallet.ui.fragment.other_tokens;

import org.althash.wallet.model.contract.Token;
import org.althash.wallet.ui.base.base_fragment.BaseFragmentView;

import java.util.List;

public interface OtherTokensView extends BaseFragmentView {
    void setTokensData(List<Token> tokensData);

    void updateTokensData(List<Token> tokensData);
}
