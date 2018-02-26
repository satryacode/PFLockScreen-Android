package com.beautycoder.pflockscreen.fragments;

import android.content.Context;
import android.support.annotation.IntDef;
import android.view.View;

import com.beautycoder.pflockscreen.R;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Created by aleksandr on 2018/02/14.
 */

public class PFFLockScreenConfiguration {

    private String mLeftButton = "";
    private View.OnClickListener mOnLeftButtonClickListener = null;
    private boolean mUseFingerprint = false;
    private String mTitle = "";
    private int mMode = MODE_AUTH;

    private PFFLockScreenConfiguration(Builder builder) {
        mLeftButton = builder.mLeftButton;
        mUseFingerprint = builder.mUseFingerprint;
        mTitle = builder.mTitle;
        mOnLeftButtonClickListener = builder.mOnLeftButtonClickListener;
        mMode = builder.mMode;
    }

    String getLeftButton() {
        return mLeftButton;
    }

    boolean isUseFingerprint() {
        return mUseFingerprint;
    }

    String getTitle() {
        return mTitle;
    }

    public View.OnClickListener getOnLeftButtonClickListener() {
        return mOnLeftButtonClickListener;
    }

    public @LockScreenMode int getMode() {
        return this.mMode;
    }

    public static class Builder {

        private String mLeftButton = "";
        private View.OnClickListener mOnLeftButtonClickListener = null;
        private boolean mUseFingerprint = false;
        private String mTitle = "";
        private int mMode = 0;

        public Builder(Context context) {
            mTitle = context.getResources().getString(R.string.lock_screen_title_pf);
        }

        public Builder setTitle(String title) {
            mTitle = title;
            return this;
        }

        public Builder setLeftButton(String leftButton, View.OnClickListener onClickListener) {
            mLeftButton = leftButton;
            mOnLeftButtonClickListener = onClickListener;
            return this;
        }

        public Builder setUseFingerprint(boolean useFingerprint) {
            mUseFingerprint = useFingerprint;
            return this;
        }

        public Builder setMode(@LockScreenMode int mode) {
            mMode = mode;
            return this;
        }

        public PFFLockScreenConfiguration build() {
            return new PFFLockScreenConfiguration(this);
        }



    }

    @Retention(SOURCE)
    @IntDef({MODE_CREATE, MODE_AUTH})
    public @interface PFLockScreenMode {}
    public static final int MODE_CREATE = 0;
    public static final int MODE_AUTH = 1;

}
