package org.althash.wallet.ui.fragment.contract_management_fragment;

import android.content.Context;

import org.althash.wallet.datastorage.FileStorageManager;
import org.althash.wallet.datastorage.TinyDB;
import org.althash.wallet.model.contract.Contract;
import org.althash.wallet.model.contract.ContractMethod;

import java.lang.ref.WeakReference;
import java.util.List;

public class ContractManagementInteractorImpl implements ContractManagementInteractor {

    WeakReference<Context> mContext;

    ContractManagementInteractorImpl(Context context) {
        mContext = new WeakReference<Context>(context);
    }

    @Override
    public List<ContractMethod> getContractListByAbi(String abi) {
        return FileStorageManager.getInstance().getContractMethodsByAbiString(mContext.get(), abi);
    }

    @Override
    public Contract getContractByAddress(String address) {
        TinyDB tinyDB = new TinyDB(mContext.get());
        for (Contract contract : tinyDB.getContractList()) {
            if (contract.getContractAddress().equals(address)) {
                return contract;
            }
        }
        return null;
    }

    @Override
    public List<ContractMethod> getContractListByUiid(String uiid) {
        return FileStorageManager.getInstance().getContractMethods(mContext.get(), uiid);
    }
}
