package com.smartdroidesign.interactivestory.presenter;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.smartdroidesign.interactivestory.R;
import com.smartdroidesign.interactivestory.model.Page;
import com.smartdroidesign.interactivestory.model.Story;

import java.util.Stack;

public class StoryActivity extends AppCompatActivity {

    public static final String TAG = StoryActivity.class.getSimpleName();

    private Story story;
    private ImageView storyImageView;
    private TextView storyTextView;
    private Button choice1Button;
    private Button choice2Button;
    private String name;
    private Stack<Integer> pageStack = new Stack<Integer>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        storyImageView = findViewById(R.id.storyImageView);
        storyTextView = findViewById(R.id.storyTextView);
        choice1Button = findViewById(R.id.choice1Button);
        choice2Button = findViewById(R.id.choice2Button);

        Intent intent = getIntent();
        name = intent.getStringExtra(getString(R.string.key_name));
        if (name == null || name.isEmpty()) {
            name = "Friend";
        }
        Log.d(TAG, name);

        story = new Story();
        loadPage(0);


    }

    private void loadPage(int pageNumber) {
        pageStack.push(pageNumber);

        final Page page = story.getPage(pageNumber);

        Drawable image = ContextCompat.getDrawable(this, page.getImageId());
        storyImageView.setImageDrawable(image);

        String pageText = getString(page.getTextId());
        // Add name if placeholder included. Won't add if not
        pageText = String.format(pageText, name);
        storyTextView.setText(pageText);

        if (page.isFinalPage()) {
            choice1Button.setVisibility(View.INVISIBLE);
            choice2Button.setText(R.string.play_again_button);
            choice2Button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    loadPage(0);
                }
            });
        } else {

            loadButtons(page);
//            Animation fadeIn = new AlphaAnimation(0, 1);
//            fadeIn.setInterpolator(new DecelerateInterpolator()); //add this
//            fadeIn.setDuration(1000);
//
//            Animation fadeOut = new AlphaAnimation(1, 0);
//            fadeOut.setInterpolator(new AccelerateInterpolator()); //and this
//            fadeOut.setStartOffset(1000);
//            fadeOut.setDuration(1000);
//
//            AnimationSet animation = new AnimationSet(false); //change to false
//            animation.addAnimation(fadeIn);
//            animation.addAnimation(fadeOut);
//            storyImageView.setAnimation(animation);


            // Custom animation on image



//            ObjectAnimator fadeOut = ObjectAnimator.ofFloat(storyImageView, "alpha",  1f, .3f);
//            fadeOut.setDuration(2000);
//            ObjectAnimator fadeIn = ObjectAnimator.ofFloat(storyImageView, "alpha", .3f, 1f);
//            fadeIn.setDuration(2000);
//
//            final AnimatorSet mAnimationSet = new AnimatorSet();
//
//            mAnimationSet.play(fadeIn).after(fadeOut);
//
//            mAnimationSet.addListener(new AnimatorListenerAdapter() {
//                @Override
//                public void onAnimationEnd(Animator animation) {
//                    super.onAnimationEnd(animation);
//                    mAnimationSet.start();
//                }
//            });
//            mAnimationSet.start();
        }
    }

    private void loadButtons(final Page page) {
        choice1Button.setVisibility(View.VISIBLE);
        choice1Button.setText(page.getChoice1().getTextId());
        choice1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int nextPage = page.getChoice1().getNextPage();
                loadPage(nextPage);
            }
        });

        choice2Button.setVisibility(View.VISIBLE);
        choice2Button.setText(page.getChoice2().getTextId());
        choice2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int nextPage = page.getChoice2().getNextPage();
                loadPage(nextPage);
            }
        });
    }

    @Override
    public void onBackPressed() {
        pageStack.pop();
        if (pageStack.isEmpty()) {
            super.onBackPressed();
        } else {
            loadPage(pageStack.pop());
        }
        super.onBackPressed();
    }
}
