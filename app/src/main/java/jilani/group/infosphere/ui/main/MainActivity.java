package jilani.group.infosphere.ui.main;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import jilani.group.infosphere.R;
import jilani.group.infosphere.models.Article;
import jilani.group.infosphere.models.NewsResponse;
import jilani.group.infosphere.network.ApiClient;
import jilani.group.infosphere.network.NewsApiService;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private NewsAdapter newsAdapter;
    private static final String API_KEY = "a2b3a1ef92e74419b62da9895f793e2b";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialise l'adaptateur vide avant de charger les données
        newsAdapter = new NewsAdapter(new ArrayList<>(), this);
        recyclerView.setAdapter(newsAdapter);

        fetchNews();
        tet();
    }

    public void tet(){
        NewsApiService apiService = ApiClient.getClient().create(NewsApiService.class);

        Call<NewsResponse> call = apiService.getTopHeadlines("us", "business", API_KEY);
        call.enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.d("API_SUCCESS", "Articles: " + response.body().getArticles().size());
                } else {
                    Log.e("API_ERROR", "Response code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                Log.e("API_FAILURE", t.getMessage());
            }
        });
    }

    private void fetchNews() {
        NewsApiService apiService = ApiClient.getClient().create(NewsApiService.class);
        Call<NewsResponse> call = apiService.getTopHeadlines("us", "technology", "a2b3a1ef92e74419b62da9895f793e2b");

        call.enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                if (response.isSuccessful()) {
                    List<Article> articles = response.body().getArticles();
                    if (articles != null && !articles.isEmpty()) {
                        newsAdapter.updateData(articles);
                    }
                    else {
                        List<Article> mockArticles = new ArrayList<>();
                        Article a1 = new Article();
                        a1.setTitle("Title 1");
                        a1.setDescription("Description 1");
                        a1.setUrlToImage("https://example.com/image1.jpg");

                        mockArticles.add(a1);
                        Article a2 = new Article();
                        a2.setTitle("Title 2");
                        a2.setDescription("Description 2");
                        a2.setUrlToImage("https://example.com/image2.jpg");
                        mockArticles.add(a2);

                        newsAdapter.updateData(mockArticles);

                        Log.e("MainActivity", "No articles found");
                    }
                } else {
                    Log.e("MainActivity", "Error fetching data, Response Code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                Log.e("MainActivity", "Error fetching news: " + t.getMessage());
            }
        });
    }


}
/*
public class MainActivity extends AppCompatActivity {
    private static final String API_KEY = "a2b3a1ef92e74419b62da9895f793e2b";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NewsApiService apiService = ApiClient.getClient().create(NewsApiService.class);

        Call<NewsResponse> call = apiService.getTopHeadlines("us", "business", API_KEY);
        call.enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.d("API_SUCCESS", "Articles: " + response.body().getArticles().size());
                } else {
                    Log.e("API_ERROR", "Response code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                Log.e("API_FAILURE", t.getMessage());
            }
        });
    }
}*/