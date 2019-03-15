package org.althash.wallet.utils;

import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.params.HtmlcoinMainNetParams;
import org.bitcoinj.params.HtmlcoinTestNetParams;
import org.althash.wallet.BuildConfig;

public class CurrentNetParams {

    public  CurrentNetParams(){}

    public static NetworkParameters getNetParams(){
        return BuildConfig.USE_MAIN_NET? HtmlcoinMainNetParams.get() : HtmlcoinTestNetParams.get();
    }

    public static String getUrl(){
        return BuildConfig.API_URL;
    }
}
