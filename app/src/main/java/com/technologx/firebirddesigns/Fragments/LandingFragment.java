package com.technologx.firebirddesigns.Fragments;

import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import com.technologx.firebirddesigns.R;
import com.technologx.firebirddesigns.Util.CustomTabActivityHelper;
import com.technologx.firebirddesigns.Util.WebviewFallback;

/**
 * Created by ry on 12/10/16.
 */

public class LandingFragment extends Fragment {

    public static final String ARGS_INSTANCE = "com.technologx.firebirddesigns.argsInstance";

    public static LandingFragment newInstance(int instance) {
        Bundle args = new Bundle();
        args.putInt(ARGS_INSTANCE, instance);
        LandingFragment fragment = new LandingFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.landing_fragment, container, false);
        setHasOptionsMenu(true);

        MobileAds.initialize(getActivity(), "ca-app-pub-1326270243329202/4721398177");

        AdView mAdView = (AdView) v.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        Button facebook = (Button) v.findViewById(R.id.f_button);
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomTabsIntent.Builder intentBuilder = new CustomTabsIntent.Builder();
                intentBuilder.setToolbarColor(getResources().getColor(R.color.toolbar));
                intentBuilder.setSecondaryToolbarColor(getResources().getColor(R.color.accent));
                CustomTabActivityHelper.openCustomTab(
                        getActivity(), intentBuilder.build(), Uri.parse("https://www.facebook.com/Technologx2013"), new WebviewFallback());
            }
        });

        Button gplus = (Button) v.findViewById(R.id.g_button);
        gplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomTabsIntent.Builder intentBuilder = new CustomTabsIntent.Builder();
                intentBuilder.setToolbarColor(getResources().getColor(R.color.toolbar));
                intentBuilder.setSecondaryToolbarColor(getResources().getColor(R.color.accent));
                CustomTabActivityHelper.openCustomTab(
                        getActivity(), intentBuilder.build(), Uri.parse("https://plus.google.com/communities/107127799636840814852"), new WebviewFallback());
            }
        });

        return v;
    }
}