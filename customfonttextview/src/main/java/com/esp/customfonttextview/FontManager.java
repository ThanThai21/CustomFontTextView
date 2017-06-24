package com.esp.customfonttextview;

import android.content.res.AssetManager;
import android.graphics.Typeface;

import java.util.HashMap;
import java.util.Map;

public class FontManager {

    private static FontManager instance;

    private AssetManager assetManager;

    private Map<String, Typeface> fonts;

    private FontManager(AssetManager assetManager) {
        this.assetManager = assetManager;
        fonts = new HashMap<String, Typeface>();
    }

    public static void init(AssetManager assetManager) {
        instance = new FontManager(assetManager);
    }

    public static FontManager getInstance() {
        return instance;
    }

    public Typeface getFont(String fontAssets) {
        if (fonts.containsKey(fontAssets))
            return fonts.get(fontAssets);

        Typeface font = null;

        try {
            font = Typeface.createFromAsset(assetManager, fontAssets);
            fonts.put(fontAssets, font);
        } catch (Exception e) {

        }

        if (font == null) {
            try {
                String fixedAsset = fixAssetFilename(fontAssets);
                font = Typeface.createFromAsset(assetManager, fixedAsset);
                fonts.put(fontAssets, font);
                fonts.put(fixedAsset, font);
            } catch (Exception e) {

            }
        }

        return font;
    }

    private String fixAssetFilename(String asset) {
        // Empty font filename?
        // Just return it. We can't help.
        if (asset == null || asset.equals(""))
            return asset;

        // Make sure that the font ends in '.ttf' or '.ttc'
        if ((!asset.endsWith(".ttf")) && (!asset.endsWith(".ttc")))
            asset = String.format("%s.ttf", asset);

        return asset;
    }

}
