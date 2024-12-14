package jilani.group.infosphere.ui.detail;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

import jilani.group.infosphere.R;

public class DetailActivity extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Liaison avec la WebView
        webView = findViewById(R.id.webView);

        // Configurer la WebView
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);

        // Récupérer l'URL passée via l'intent
        Intent intent = getIntent();
        if (intent != null) {
            String url = intent.getStringExtra("url");
            if (url != null) {
                webView.loadUrl(url); // Charger l'URL dans la WebView
            }
        }
    }
}

/*
public class DetailActivity extends AppCompatActivity {
    private ImageView imageViewDetail;
    private TextView textViewTitleDetail;
    private TextView textViewContentDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Liaison avec les vues
        imageViewDetail = findViewById(R.id.imageViewDetail);
        textViewTitleDetail = findViewById(R.id.textViewTitleDetail);
        textViewContentDetail = findViewById(R.id.textViewContentDetail);

        // Récupérer les données de l'intent
        Intent intent = getIntent();
        if (intent != null) {
            String title = intent.getStringExtra("title");
            String content = intent.getStringExtra("content");
            String imageUrl = intent.getStringExtra("imageUrl");

            // Mettre à jour l'interface utilisateur
            textViewTitleDetail.setText(title);
            textViewContentDetail.setText(content);
            Glide.with(this).load(imageUrl).into(imageViewDetail);
        }
    }
}*/
