package com.example.recycleviewtest;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.GridLayout;


import java.util.ArrayList;

public class MainActivity extends Activity {

    RecyclerView recyclerView;
    private ArrayList<Dog> dogs = new ArrayList<>();
    int[] dogsIds = {R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four, R.drawable.five
            , R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four, R.drawable.five
            , R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four, R.drawable.five};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setdate();
        init();

    }

    private void setdate() {
        for (int i = 0; i < dogsIds.length; i++) {
            Dog dog = new Dog();
            dog.setImageId(dogsIds[i]);
            dog.setName(dogsIds + "号");
            dogs.add(dog);
        }
    }

    private void init() {
        recyclerView = (RecyclerView) findViewById(R.id.myrecycleview);
        MyRecycleViewAdapter myrecycleview = new MyRecycleViewAdapter(dogs);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, GridLayout.VERTICAL));
        recyclerView.addItemDecoration(new SpaceItemDecoration(6));
        recyclerView.setAdapter(myrecycleview);

    }

    class SpaceItemDecoration extends RecyclerView.ItemDecoration {
        int space;

        public SpaceItemDecoration(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.left = space;
            outRect.right = space;
            outRect.top = space;
            outRect.bottom = space;
        }
    }


}
