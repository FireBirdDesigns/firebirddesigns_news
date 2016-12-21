package com.technologx.firebirddesigns.Util;

/**
 * Created by ry on 12/10/16.
 */

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import com.technologx.firebirddesigns.Webview;

/**
 * A Fallback that opens a Webview when Custom Tabs is not available
 */
public class WebviewFallback implements CustomTabActivityHelper.CustomTabFallback {
    @Override
    public void openUri(Activity activity, Uri uri) {
        Intent intent = new Intent(activity, Webview.class);
        intent.putExtra(Webview.EXTRA_URL, uri.toString());
        activity.startActivity(intent);
    }
}
