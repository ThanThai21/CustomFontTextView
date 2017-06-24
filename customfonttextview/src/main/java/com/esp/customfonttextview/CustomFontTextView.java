package com.esp.customfonttextview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

public class CustomFontTextView extends TextView {
    private final static String TAG = "FontText";
    public CustomFontTextView(Context context) {
        this(context, null);
    }

    public CustomFontTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomFontTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (isInEditMode())
            return;

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.CustomFontTextView);

        if (ta != null) {
            Log.d(TAG, "CustomTextView: ");
            String fontAsset = ta.getString(R.styleable.CustomFontTextView_typefaceAssets);

            if (!(fontAsset == null || fontAsset.equals(""))) {
                FontManager.init(context.getAssets());
                Typeface tf = FontManager.getInstance().getFont(fontAsset);
                int style = Typeface.NORMAL;
                float size = getTextSize();

                if (getTypeface() != null)
                    style = getTypeface().getStyle();

                if (tf != null) {
                    setTypeface(tf, style);
                    Log.d(TAG, tf.getStyle() + "");
                } else {
                    Log.d(TAG, String.format("Could not create a font from asset: %s", fontAsset));
                }
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomFontTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
