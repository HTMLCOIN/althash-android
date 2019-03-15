package org.althash.wallet.ui.fragment.store_categories;

import android.content.Context;

import org.althash.wallet.dataprovider.rest_api.althash.AlthashService;
import org.althash.wallet.model.gson.QstoreContractType;

import java.lang.ref.WeakReference;
import java.util.List;

import rx.Observable;

public class StoreCategoriesInteractorImpl implements StoreCategoriesInteractor {
    private WeakReference<Context> mContext;

    public StoreCategoriesInteractorImpl(Context context) {
        mContext = new WeakReference<>(context);
    }

    @Override
    public Observable<List<QstoreContractType>> contractTypesObservable() {
        return AlthashService.newInstance().getContractTypes();
    }
}
