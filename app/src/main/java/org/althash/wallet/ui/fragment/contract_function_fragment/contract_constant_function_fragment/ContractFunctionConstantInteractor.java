package org.althash.wallet.ui.fragment.contract_function_fragment.contract_constant_function_fragment;

import org.althash.wallet.model.contract.Contract;
import org.althash.wallet.model.contract.ContractMethod;
import org.althash.wallet.model.contract.ContractMethodParameter;
import org.althash.wallet.model.gson.SendRawTransactionResponse;
import org.althash.wallet.model.gson.UnspentOutput;

import java.math.BigDecimal;
import java.util.List;

import rx.Observable;

public interface ContractFunctionConstantInteractor {
    List<ContractMethod> getContractMethod(String contractTemplateUiid);

    BigDecimal getFeePerKb();

    int getMinGasPrice();

    Observable<ContractFunctionConstantInteractorImpl.CallSmartContractRespWrapper> callSmartContractObservable(String methodName,
                                                                                                        List<ContractMethodParameter> contractMethodParameterList,
                                                                                                        Contract contract);

    Contract getContractByAddress(String address);
}
