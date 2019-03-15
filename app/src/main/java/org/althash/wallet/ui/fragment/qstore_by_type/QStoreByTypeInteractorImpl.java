package org.althash.wallet.ui.fragment.qstore_by_type;

import android.content.Context;

import org.althash.wallet.dataprovider.rest_api.althash.AlthashService;
import org.althash.wallet.model.gson.qstore.QSearchItem;

import java.lang.ref.WeakReference;
import java.util.List;

import rx.Observable;

public class QStoreByTypeInteractorImpl implements QStoreByTypeInteractor {

    private WeakReference<Context> mContext;

    public QStoreByTypeInteractorImpl(Context context) {
        mContext = new WeakReference<>(context);
    }

    @Override
    public Observable<List<QSearchItem>> searchContractsObservable(int searchOffset, String mType, String tag, boolean byTag) {
        return AlthashService.newInstance().searchContracts(searchOffset, mType, tag, byTag);
    }
}
