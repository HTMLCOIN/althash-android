package org.althash.wallet.ui.fragment.althash_cash_management_fragment;

import android.content.Context;

import org.althash.wallet.dataprovider.rest_api.althash.AlthashService;
import org.althash.wallet.datastorage.KeyStorage;

import org.althash.wallet.model.gson.UnspentOutput;

import java.lang.ref.WeakReference;
import java.util.List;

import rx.Observable;

public class AddressListInteractorImpl implements AddressListInteractor {

    AddressListInteractorImpl() {
    }

    @Override
    public List<String> getAddresses() {
        return KeyStorage.getInstance().getAddresses();
    }

    @Override
    public Observable<List<UnspentOutput>> getUnspentOutputs(List<String> addresses) {
        return AlthashService.newInstance().getUnspentOutputsForSeveralAddresses(addresses);
    }
}
