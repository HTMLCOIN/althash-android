package org.althash.wallet.ui.fragment.language_fragment;

import android.content.Context;
import android.util.Pair;

import org.althash.wallet.datastorage.AlthashSettingSharedPreference;
import org.althash.wallet.datastorage.AlthashSharedPreference;
import org.althash.wallet.datastorage.listeners.LanguageChangeListener;

import java.util.ArrayList;
import java.util.List;

class LanguageInteractorImpl implements LanguageInteractor {

    private Context mContext;
    private List<Pair<String, String>> mLanguagesList;

    LanguageInteractorImpl(Context context) {
        mContext = context;
        mLanguagesList = new ArrayList<>();
        mLanguagesList.add(new Pair<>("zh", "Chinese"));
        mLanguagesList.add(new Pair<>("da", "Danish"));
        mLanguagesList.add(new Pair<>("us", "English"));
        mLanguagesList.add(new Pair<>("fr", "French"));
        mLanguagesList.add(new Pair<>("de", "German"));
        mLanguagesList.add(new Pair<>("ko", "Korean"));
        mLanguagesList.add(new Pair<>("pt", "Portuguese"));
        mLanguagesList.add(new Pair<>("ru", "Russian"));
        mLanguagesList.add(new Pair<>("es", "Spanish"));
    }

    @Override
    public String getLanguage() {
        return AlthashSettingSharedPreference.getInstance().getLanguage(mContext);
    }

    @Override
    public void setLanguage(String language) {
        AlthashSettingSharedPreference.getInstance().saveLanguage(mContext, language);
    }

    @Override
    public List<Pair<String, String>> getLanguagesList() {
        return mLanguagesList;
    }

    @Override
    public void removeLanguageListener(LanguageChangeListener languageChangeListener) {
        AlthashSettingSharedPreference.getInstance().removeLanguageListener(languageChangeListener);
    }

    @Override
    public void addLanguageListener(LanguageChangeListener languageChangeListener) {
        AlthashSettingSharedPreference.getInstance().addLanguageListener(languageChangeListener);
    }
}
