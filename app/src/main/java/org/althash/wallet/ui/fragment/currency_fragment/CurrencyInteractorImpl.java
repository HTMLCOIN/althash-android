package org.althash.wallet.ui.fragment.currency_fragment;

import android.content.Context;

import org.althash.wallet.R;
import org.althash.wallet.model.Currency;
import org.althash.wallet.model.CurrencyToken;
import org.althash.wallet.model.contract.ContractCreationStatus;
import org.althash.wallet.model.contract.Token;
import org.althash.wallet.datastorage.TinyDB;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class CurrencyInteractorImpl implements CurrencyInteractor {

    private Context mContext;

    CurrencyInteractorImpl(Context context) {
        mContext = context;
    }

    @Override
    public List<Currency> getCurrencies() {
        List<Currency> currencies = new ArrayList<>();
        List<Token> tokens = (new TinyDB(mContext)).getTokenList();
        Currency currency = new Currency("HTML " + mContext.getString(R.string.default_currency));
        currencies.add(currency);
        for (Token token : tokens) {
            if (token.getCreationStatus().equals(ContractCreationStatus.Created) && token.isSubscribe()) {

                BigDecimal tokenBalanceWithDecimalUnits = token.getTokenBalanceWithDecimalUnits();

                if(tokenBalanceWithDecimalUnits.toString().equals("0") && !token.getSupportFlag()) {
                   continue;
                }

                currency = new CurrencyToken(token.getContractName(), token);
                currencies.add(currency);
            }
        }
        return currencies;
    }
}
