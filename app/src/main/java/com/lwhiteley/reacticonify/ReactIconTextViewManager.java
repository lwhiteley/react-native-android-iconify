package com.lwhiteley.reacticonify;

import android.util.Log;

import com.facebook.react.uimanager.ReactProp;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewProps;
import com.joanzapata.iconify.widget.IconTextView;

import javax.annotation.Nullable;

/**
 * Created by layton on 9/27/15.
 */
public class ReactIconTextViewManager extends SimpleViewManager<IconTextView> {
    public static final String REACT_CLASS = "RCTIconTextView";

    public static final String PROP_ICON = "text";
    public static final String PROP_COLOR = "color";

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    public IconTextView createViewInstance(ThemedReactContext context) {
        Log.i("IconTextView", "create instance");
        return new IconTextView(context);
    }


    @ReactProp(name = ViewProps.FONT_SIZE, defaultInt = 0)
    public void setTextSize(IconTextView view, Integer size) {
        Log.i("IconTextView", "setTextSize: "+ size + " | " + ViewProps.FONT_SIZE);
        view.setTextSize(size);
    }

    @ReactProp(name = PROP_ICON)
    public void setText(IconTextView view, @Nullable String text) {
        Log.i("IconTextView", "setText: "+ text);
        view.setText(text);
    }

    @ReactProp(name = PROP_COLOR, customType = "Color")
    public void setTextColor(IconTextView view, @Nullable Integer color) {
        Log.i("IconTextView", "setTextColor: " + color );
        view.setTextColor(color);
    }

}
