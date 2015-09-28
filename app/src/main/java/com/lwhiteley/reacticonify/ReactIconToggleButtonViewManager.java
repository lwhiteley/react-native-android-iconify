package com.lwhiteley.reacticonify;

import android.graphics.Color;
import android.util.Log;

import com.facebook.react.uimanager.BaseViewPropertyApplicator;
import com.facebook.react.uimanager.CatalystStylesDiffMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIProp;
import com.facebook.react.views.text.ReactTextShadowNode;
import com.joanzapata.iconify.widget.IconButton;
import com.joanzapata.iconify.widget.IconToggleButton;

/**
 * Created by layton on 9/27/15.
 */
public class ReactIconToggleButtonViewManager extends SimpleViewManager<IconToggleButton> {
    public static final String REACT_CLASS = "RCTIconToggleButton";
    @UIProp(UIProp.Type.STRING)
    public static final String PROP_ICON = "text";
    @UIProp(UIProp.Type.STRING)
    public static final String PROP_ON = "textOn";
    @UIProp(UIProp.Type.STRING)
    public static final String PROP_OFF = "textOff";
    @UIProp(UIProp.Type.STRING)
    public static final String PROP_COLOR = "color";
    @UIProp(UIProp.Type.STRING)
    public static final String PROP_SIZE = "fontSize";

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    public IconToggleButton createViewInstance(ThemedReactContext context) {
        Log.i("IconTextView", "create instance");
        return new IconToggleButton(context);
    }

    @Override
    public void updateView(final IconToggleButton view,
                           final CatalystStylesDiffMap props) {

        BaseViewPropertyApplicator.applyCommonViewProperties(view, props);
        if (props.hasKey(PROP_ICON)) {
            Log.i("IconTextView", "update view has icon");
            view.setText(props.getString(PROP_ICON));
        }
        if (props.hasKey(PROP_ON)) {
            Log.i("IconTextView", "update view has icon");
            view.setTextOn(props.getString(PROP_ON));
        }
        if (props.hasKey(PROP_OFF)) {
            Log.i("IconTextView", "update view has icon");
            view.setTextOff(props.getString(PROP_OFF));
        }
        if (props.hasKey(PROP_COLOR)) {
            view.setTextColor(Color.parseColor(props.getString(PROP_COLOR)));
        }
        if (props.hasKey(PROP_SIZE)) {
            view.setTextSize(props.getFloat(PROP_SIZE, 0.0f));
        }
        Log.i("IconTextView", "updateview finish");
        super.updateView(view, props);
    }

    @Override
    public ReactTextShadowNode createCSSNodeInstance() {
        return new ReactTextShadowNode(false);
    }
}
