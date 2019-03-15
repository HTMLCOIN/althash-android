package org.althash.wallet.ui.fragment.profile_fragment.dark;

import org.althash.wallet.R;
import org.althash.wallet.ui.fragment.profile_fragment.DividerItemDecoration;
import org.althash.wallet.ui.fragment.profile_fragment.PrefAdapter;
import org.althash.wallet.ui.fragment.profile_fragment.light.PrefAdapterLight;
import org.althash.wallet.ui.fragment.profile_fragment.ProfileFragment;

public class ProfileFragmentDark extends ProfileFragment {

    @Override
    protected int getLayout() {
        return R.layout.lyt_profile_preference;
    }

    @Override
    public void initializeViews() {
        super.initializeViews();
        dividerItemDecoration = new DividerItemDecoration(getContext(), R.drawable.color_primary_divider, R.drawable.section_setting_divider, getPresenter().getSettingsData());
        showBottomNavView(R.color.colorPrimary);
        adapter = new PrefAdapterLight(getPresenter().getSettingsData(), this, R.layout.lyt_profile_pref_list_item);
        prefList.addItemDecoration(dividerItemDecoration);
        prefList.setAdapter(adapter);
    }

}
