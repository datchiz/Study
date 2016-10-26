package com.example.mypc.watchyoutube.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mypc.watchyoutube.R;
import com.example.mypc.watchyoutube.fragment.ItemDetailFragment;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class ItemPlayActivity extends YouTubeBaseActivity {
    private YouTubePlayerView youTubePlayerView;
//    private Button btnPlay;
    private YouTubePlayer.OnInitializedListener onInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_play);

        final String id = getIntent().getStringExtra(ItemDetailFragment.PLAY_ITEM_ID);

        findViewByIds();

        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo(id);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Toast.makeText(ItemPlayActivity.this, youTubeInitializationResult.name(),Toast.LENGTH_LONG).show();

            }
        };

        youTubePlayerView.initialize("AIzaSyCQmuLhUm8Kk4eLKXPO2dRoIdNC8ak3kgU", onInitializedListener);

//        btnPlay.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                youTubePlayerView.initialize("AIzaSyCQmuLhUm8Kk4eLKXPO2dRoIdNC8ak3kgU", onInitializedListener);
//            }
//        });

    }

    private void findViewByIds(){
        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youTubePlayerView);
//        btnPlay           = (Button) findViewById(R.id.btnPlay);
    }
}
