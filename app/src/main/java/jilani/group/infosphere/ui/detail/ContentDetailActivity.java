package jilani.group.infosphere.ui.detail;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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

public class ContentDetailActivity extends AppCompatActivity {
    private ImageView imageViewDetail;
    private TextView textViewTitleDetail;
    private TextView textViewContentDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_detail);

        // Liaison avec les vues
        imageViewDetail = findViewById(R.id.imageViewDetail1);
        textViewTitleDetail = findViewById(R.id.textViewTitleDetail1);
        textViewContentDetail = findViewById(R.id.textViewContentDetail1);

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
