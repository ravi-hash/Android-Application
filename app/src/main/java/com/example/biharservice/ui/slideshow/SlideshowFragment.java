package com.example.biharservice.ui.slideshow;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.biharservice.databinding.FragmentSlideshowBinding;

public class SlideshowFragment extends Fragment {

    private FragmentSlideshowBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        final WebView homeWebView = binding.WebViewSlideshow;
        final ProgressBar loadingPB = binding.idPBLoading;
        homeWebView.loadUrl("https://janparichay.meripehchaan.gov.in/v1/pehchaan/login.html?service=passive&active=true&rm_5=false&continue=https%3A%2F%2Fjan_com%2Fmail%2F&pp=1&scc=1&lmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin&sid=biharserviceplus-prodhocm5898cvb&lang=");
        homeWebView.setWebViewClient(new WebViewClient(){

            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon );
                loadingPB.setVisibility(View.GONE);
            }

            public void onPageFinished(WebView view, String url, Bitmap favicon) {
                super.onPageFinished(view, url);
                loadingPB.setVisibility(View.GONE);
            }

        });

        homeWebView.setOnKeyListener(new View.OnKeyListener(){
            @Override
            public boolean onKey(View v, int KeyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN){
                    switch(KeyCode){
                        case KeyEvent.KEYCODE_BACK:
                            if(homeWebView.canGoBack()){
                                homeWebView.goBack();
                            }
                    }

                }
                return false;
            }
        });
        
        
               return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}