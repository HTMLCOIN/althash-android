package org.althash.wallet.ui.fragment.wallet_main_fragment;

import org.althash.wallet.model.contract.Token;

import java.util.List;

import rx.Observable;

public interface WalletMainInteractor {
    Observable<List<Token>> getTokensObservable();
}
