package com.ykhdzr.bartender;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;

/**
 * Created by ykhdzr on 10/5/17.
 */

public class Bartender {

    private final ActionBar actionBar;

    private final int backgroundColor;

    private final Drawable customIndicator;

    private final Drawable logo;

    private final boolean withHomeAsUpIndicator;

    private Bartender(Builder builder) {
        this.actionBar = builder.actionBar;
        this.customIndicator = builder.customIndicator;
        this.withHomeAsUpIndicator = builder.withHomeAsUpIndicator;
        this.logo = builder.logo;
        this.backgroundColor = builder.color;
        apply();
    }

    private void apply() {
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(withHomeAsUpIndicator);
        actionBar.setHomeAsUpIndicator(customIndicator);
        actionBar.setLogo(logo);
        actionBar.setBackgroundDrawable(new ColorDrawable(backgroundColor));
    }

    public static Builder with(ActionBar actionBar) {
        return new Builder(actionBar);
    }

    public static class Builder {

        private ActionBar actionBar;

        private int color;

        private Drawable customIndicator;

        private Drawable logo;

        private boolean withHomeAsUpIndicator;

        private Builder(ActionBar actionBar) {
            this.actionBar = actionBar;
        }

        public Builder homeIndicator() {
            this.withHomeAsUpIndicator = true;
            return this;
        }

        public Builder homeIndicator(Drawable customIndicator) {
            this.withHomeAsUpIndicator = true;
            this.customIndicator = customIndicator;
            return this;
        }

        public Builder logo(Drawable logo) {
            this.logo = logo;
            return this;
        }

        public Builder background(int color) {
            this.color = color;
            return this;
        }

        public Bartender apply() {
            return new Bartender(this);
        }
    }

}
