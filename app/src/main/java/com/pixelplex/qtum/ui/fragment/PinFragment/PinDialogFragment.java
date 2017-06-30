package com.pixelplex.qtum.ui.fragment.PinFragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.hardware.fingerprint.FingerprintManagerCompat;
import android.support.v4.os.CancellationSignal;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.alimuzaffar.lib.pin.PinEntryEditText;
import com.pixelplex.qtum.R;
import com.pixelplex.qtum.datastorage.QtumSharedPreference;
import com.pixelplex.qtum.utils.CryptoUtils;
import com.pixelplex.qtum.utils.FingerprintUtils;
import com.pixelplex.qtum.utils.FontTextView;

import javax.crypto.Cipher;

import butterknife.BindView;
import butterknife.ButterKnife;


public class PinDialogFragment extends DialogFragment {

    @BindView(R.id.til_wallet_pin)
    PinEntryEditText mWalletPin;

    @BindView(R.id.tv_toolbar_title)
    FontTextView mTextViewToolBarTitle;

    @BindView(R.id.tooltip)
    FontTextView tooltip;

    PinCallBack mPinCallBack;
    private boolean mTouchIdFlag;
    private FingerprintHelper mFingerprintHelper;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_fragment_pin, null);
        ButterKnife.bind(this, view);
        Dialog dialog = new Dialog(getContext());
        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(false);
        return dialog;
    }

    @Override
    public void onResume() {
        super.onResume();
        if(mTouchIdFlag) {
            mTextViewToolBarTitle.setText(R.string.confirm_fingerprint_or_pin);
            prepareSensor();
        } else {
            mTextViewToolBarTitle.setText(R.string.enter_pin);
        }

        mWalletPin.setOnPinEnteredListener(new PinEntryEditText.OnPinEnteredListener() {
            @Override
            public void onPinEntered(CharSequence str) {
                if (str.length() == 4) {
                    confirm(str.toString());
                }
            }
        });

        mWalletPin.setFocusableInTouchMode(true);
        mWalletPin.requestFocus();
    }

    public void setPin(String pin) {
        mWalletPin.setText(pin);
    }

    public void clearError() {
        tooltip.setText("");
        tooltip.setVisibility(View.INVISIBLE);
    }

    public void confirmError(String errorText) {
        if(getDialog()!=null) {
            mWalletPin.setText("");
            tooltip.setText(errorText);
            tooltip.setTextColor(getResources().getColor(R.color.accent_red_color));
            tooltip.setVisibility(View.VISIBLE);
        }
    }

    private void prepareSensor() {
        if (FingerprintUtils.isSensorStateAt(FingerprintUtils.mSensorState.READY, getContext())) {
            FingerprintManagerCompat.CryptoObject cryptoObject = CryptoUtils.getCryptoObject();
            if (cryptoObject != null) {
                mFingerprintHelper = new FingerprintHelper(getContext());
                mFingerprintHelper.startAuth(cryptoObject);
            } else {
                //TODO: make
                Toast.makeText(getContext(), "new fingerprint enrolled. enter pin again", Toast.LENGTH_SHORT).show();
            }

        }
    }

    public class FingerprintHelper extends FingerprintManagerCompat.AuthenticationCallback {
        private Context mContext;
        private CancellationSignal mCancellationSignal;

        FingerprintHelper(Context context) {
            mContext = context;
        }

        void startAuth(FingerprintManagerCompat.CryptoObject cryptoObject) {
            mCancellationSignal = new CancellationSignal();
            FingerprintManagerCompat manager = FingerprintManagerCompat.from(mContext);
            manager.authenticate(cryptoObject, 0, mCancellationSignal, this, null);
        }

        void cancel() {
            if (mCancellationSignal != null) {
                mCancellationSignal.cancel();
            }
        }

        @Override
        public void onAuthenticationError(int errMsgId, CharSequence errString) {
            confirmError(errString.toString());
        }

        @Override
        public void onAuthenticationHelp(int helpMsgId, CharSequence helpString) {
            confirmError(helpString.toString());
        }

        @Override
        public void onAuthenticationSucceeded(FingerprintManagerCompat.AuthenticationResult result) {
            Cipher cipher = result.getCryptoObject().getCipher();
            String encoded = QtumSharedPreference.getInstance().getTouchIdPassword(getContext());
            String decoded = CryptoUtils.decode(encoded, cipher);
            setPin(decoded);
        }

        @Override
        public void onAuthenticationFailed() {
            confirmError("try again");
        }

    }

    public void confirm(String pin){
        if (pin.equals(QtumSharedPreference.getInstance().getWalletPassword(getContext()))) {
            clearError();
            mPinCallBack.onSuccess();
            dismiss();
        } else {
            confirmError(getContext().getString(R.string.incorrect_pin));
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if(mFingerprintHelper!=null) {
            mFingerprintHelper.cancel();
        }
        dismiss();
    }

    public void addPinCallBack(PinCallBack callBack){
        mPinCallBack = callBack;
    }

    void removePinCallBack(){
        mPinCallBack = null;
    }

    public void setTouchIdFlag(boolean touchIdFlag){
        mTouchIdFlag = touchIdFlag;
    }

    public interface PinCallBack{
        void onSuccess();
        void onError();
    }

}