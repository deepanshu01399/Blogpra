package com.deepanshu.android.blogpra;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ProgressBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @VisibleForTesting
    protected static final String ROW_TEXT = "ROW_TEXT";
    private RecyclerView recyclerView;
    Boolean isSrolling = false;
    int currentItems, totalItems, scroolOutItems;
    LinearLayoutManager manager;
    ArrayList<Blog> arrablog;
    String whn, ON1, des, imgUrl;
    String authorName1;
    RecyclerViewAdapter adapter;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arrablog = new ArrayList<>();
        String authorName = "Dr.Reatha Padmore ";
        whn = "1 day";
        String ON = "Transform global health";
        des = "World Sight Day, held on the second Thursday of October every year," +
                " aims to focus global attention on vision impairment and blindness. There is a different theme every year, with many of" +
                " those who mark the Day taking the opportunity to both celebrate achievements to date and advocate for increasing attention" +
                " towards eye care. Globally,the International Agency for the Prevention of Blindness has a leadership role in preparing the annual World Sight Day.";
        imgUrl = "https://www.sciencealert.com/images/2018-03/processed/HPVVirus_web_600.jpg";

        authorName1 = "Dr Vachel luces ";
        String whn1 = "2 day";
        String ON1 = "Transform global health";
        String des1 = "Breast cancer is one of the most common kinds of cancer in women." +
                " About 1 in 8 women born today in the United States will get breast cancer at some point.\n" +
                "The good news is that most women can survive breast cancer if it’s found and treated early." +
                " A mammogram – the screening test for breast cancer –" +
                " can help find breast cancer early when it’s easier to treat.\n" +
                "National Breast Cancer Awareness Month is a chance to raise awareness about the importance of finding breast cancer early. ";
        String imgUrl1 = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT9BWboOI5PSjUpKrwgQ_EEUZnb_yNjix-lpRl3KOH19ONyy3MB";


        arrablog.add(new Blog("World Global health", whn + " ago by ", authorName + " via ", ON + "", des + "", imgUrl + ""));
        arrablog.add(new Blog("Breast Cancer Awareness month ", whn1 + " ago by ", authorName1 + " via ", ON1 + "", des1 + "", imgUrl1 + ""));
        arrablog.add(new Blog("World Global health", whn + " ago by ", authorName + " via ", ON + "", des + "", imgUrl + ""));
        arrablog.add(new Blog("Breast Cancer Awareness month ", whn1 + " ago by ", authorName1 + " via ", ON1 + "", des1 + "", imgUrl1 + ""));
        arrablog.add(new Blog("World Global health", whn + " ago by ", authorName + " via ", ON + "", des + "", imgUrl + ""));
        arrablog.add(new Blog("Breast Cancer Awareness month ", whn1 + " ago by ", authorName1 + " via ", ON1 + "", des1 + "", imgUrl1 + ""));
        arrablog.add(new Blog("World Global health", whn + " ago by ", authorName + " via ", ON + "", des + "", imgUrl + ""));
        arrablog.add(new Blog("Breast Cancer Awareness month ", whn1 + " ago by ", authorName1 + " via ", ON1 + "", des1 + "", imgUrl1 + ""));
        arrablog.add(new Blog("World Global health", whn + " ago by ", authorName + " via ", ON + "", des + "", imgUrl + ""));
        arrablog.add(new Blog("Breast Cancer Awareness month ", whn1 + " ago by ", authorName1 + " via ", ON1 + "", des1 + "", imgUrl1 + ""));
        arrablog.add(new Blog("World Global health", whn + " ago by ", authorName + " via ", ON + "", des + "", imgUrl + ""));
        arrablog.add(new Blog("Breast Cancer Awareness month ", whn1 + " ago by ", authorName1 + " via ", ON1 + "", des1 + "", imgUrl1 + ""));
        arrablog.add(new Blog("World Global health", whn + " ago by ", authorName + " via ", ON + "", des + "", imgUrl + ""));
        arrablog.add(new Blog("Breast Cancer Awareness month ", whn1 + " ago by ", authorName1 + " via ", ON1 + "", des1 + "", imgUrl1 + ""));
        recyclerView = findViewById(R.id.my_recycler_view);
        progressBar = findViewById(R.id.progressbar);
        adapter = new RecyclerViewAdapter(arrablog, this);
        recyclerView.setAdapter(adapter);
        manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                    //state change or not scrool bar ki
                    isSrolling = true;
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                //to fectch new data
                currentItems = manager.getChildCount();
                totalItems = manager.getItemCount();
                scroolOutItems = manager.findFirstVisibleItemPosition();
                if (isSrolling && (currentItems + scroolOutItems == totalItems)) {
                    //data fecthc if ewqul to toal item
                    isSrolling = false;
                    fetchData();
                }
            }
        });

    }

    private void fetchData() {
        // wati for  3sec
        progressBar.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    arrablog.add(new Blog("World Global health", whn + " ago by ", authorName1 + " via ", ON1 + "", des + "", imgUrl + ""));
                    adapter.notifyDataSetChanged();
                }
                progressBar.setVisibility(View.GONE);
            }
        }, 3000);
    }
}
