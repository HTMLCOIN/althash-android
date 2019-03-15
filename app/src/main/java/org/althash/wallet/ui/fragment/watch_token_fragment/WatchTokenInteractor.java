package org.althash.wallet.ui.fragment.watch_token_fragment;

import org.althash.wallet.model.ContractTemplate;
import org.althash.wallet.model.contract.Contract;
import org.althash.wallet.model.gson.ContractParams;

import java.util.List;

import rx.Observable;

public interface WatchTokenInteractor {
    List<ContractTemplate> getContractTemplates();

    int compareDates(String date, String date1);

    String readAbiContract(String uuid);

    boolean isValidContractAddress(String address);

    List<Contract> getContracts();

    String handleContractWithToken(String name, String address, String ABIInterface);

    String getHRC20TokenStandardAbi();

    Observable<ContractParams> getContractParams(String contractAddress);
}
