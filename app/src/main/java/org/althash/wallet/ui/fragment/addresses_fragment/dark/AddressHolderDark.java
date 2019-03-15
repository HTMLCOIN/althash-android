package org.althash.wallet.ui.fragment.addresses_fragment.dark;

import android.support.v4.content.ContextCompat;
import android.view.View;

import org.althash.wallet.R;
import org.althash.wallet.datastorage.KeyStorage;
import org.althash.wallet.ui.fragment.addresses_fragment.AddressHolder;
import org.althash.wallet.ui.fragment.addresses_fragment.OnAddressClickListener;

public class AddressHolderDark extends AddressHolder {

    AddressHolderDark(View itemView, OnAddressClickListener listener) {
        super(itemView, listener);

        defaultTextColor = ContextCompat.getColor(mTextViewAddress.getContext(), R.color.colorPrimary);
        selectedTextColor = ContextCompat.getColor(mTextViewAddress.getContext(), R.color.background);
    }

    public void bindAddress(String address, int position) {
        if (position == KeyStorage.getInstance().getCurrentKeyPosition()) {
            mImageViewCheckIndicator.setVisibility(View.VISIBLE);
            mTextViewAddress.setTextColor(selectedTextColor);
            mLinearLayoutAddress.setBackgroundColor(ContextCompat.getColor(mLinearLayoutAddress.getContext(), R.color.accent_red_color));
        } else {
            mImageViewCheckIndicator.setVisibility(View.GONE);
            mTextViewAddress.setTextColor(defaultTextColor);
            mLinearLayoutAddress.setBackgroundColor(ContextCompat.getColor(mLinearLayoutAddress.getContext(), android.R.color.transparent));
        }
        mTextViewAddress.setText(address);
    }
}
