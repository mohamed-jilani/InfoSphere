package jilani.group.infosphere.ui.detail;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
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



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_partager) {
            partagerDialog();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void partagerDialog() {
        // Récupérer l'URL de l'article
        Intent intent = getIntent();
        String url = intent != null ? intent.getStringExtra("url") : null;

        if (url != null) {
            // Créer une Intent de partage
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Check out this news article: " + url);

            // Lancer le menu de partage
            startActivity(Intent.createChooser(shareIntent, "Share via"));

        } else {
            Toast.makeText(this, "No URL to share!", Toast.LENGTH_SHORT).show();
        }
    }


}

