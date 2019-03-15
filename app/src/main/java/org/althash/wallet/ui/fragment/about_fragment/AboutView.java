package org.althash.wallet.ui.fragment.about_fragment;

import org.althash.wallet.model.Version;
import org.althash.wallet.ui.base.base_fragment.BaseFragmentView;

public interface AboutView extends BaseFragmentView {
    void updateVersion(Version version);
}
