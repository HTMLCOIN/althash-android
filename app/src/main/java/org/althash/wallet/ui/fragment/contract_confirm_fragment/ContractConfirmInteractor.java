package org.althash.wallet.ui.fragment.contract_confirm_fragment;

import org.althash.wallet.model.TransactionHashWithSender;
import org.althash.wallet.model.contract.ContractMethodParameter;
import org.althash.wallet.model.gson.SendRawTransactionRequest;
import org.althash.wallet.model.gson.SendRawTransactionResponse;
import org.althash.wallet.model.gson.UnspentOutput;

import java.math.BigDecimal;
import java.util.List;

import rx.Observable;

public interface ContractConfirmInteractor {
    Observable<String> createAbiConstructParams(List<ContractMethodParameter> contractMethodParameterList, String uiid);

    Observable<List<UnspentOutput>> getUnspentOutputsForSeveralAddresses();

    Observable<SendRawTransactionResponse> sendRawTransaction(SendRawTransactionRequest sendRawTransactionRequest);

    void saveContract(String txid, String contractTemplateUiid, String contractName, String senderAddress);

    TransactionHashWithSender createTransactionHash(String abiParams, List<UnspentOutput> unspentOutputs, int gasLimit, int gasPrice, String fee, String passphrase);

    BigDecimal getFeePerKb();

    int getMinGasPrice();
}
