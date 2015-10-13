package com.lwhiteley.reacticonify;

import android.graphics.Color;
import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.BaseViewPropertyApplicator;
import com.facebook.react.uimanager.CatalystStylesDiffMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIProp;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.views.text.ReactTextShadowNode;
import com.joanzapata.iconify.fonts.FontAwesomeIcons;
import com.joanzapata.iconify.widget.IconTextView;

import java.util.Arrays;
import java.util.List;

/**
 * Created by layton on 9/27/15.
 */
public class ReactIconTextViewManager extends SimpleViewManager<IconTextView> {
    public static final String REACT_CLASS = "RCTIconTextView";

    @UIProp(UIProp.Type.STRING)
    public static final String PROP_ICON = "text";
    @UIProp(UIProp.Type.STRING)
    public static final String PROP_COLOR = "color";
    @UIProp(UIProp.Type.STRING)
    public static final String PROP_SIZE = "fontSize";

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    public IconTextView createViewInstance(ThemedReactContext context) {
        Log.i("IconTextView", "create instance");
        return new IconTextView(context);
    }

    @Override
    public void updateView(final IconTextView view,
                           final CatalystStylesDiffMap props) {

        BaseViewPropertyApplicator.applyCommonViewProperties(view, props);
        if (props.hasKey(PROP_ICON)) {
            Log.i("IconTextView", "update view has icon");
            view.setText(props.getString(PROP_ICON));
        }
        if (props.hasKey(PROP_COLOR)) {
            view.setTextColor(props.getInt(PROP_COLOR,0));
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
