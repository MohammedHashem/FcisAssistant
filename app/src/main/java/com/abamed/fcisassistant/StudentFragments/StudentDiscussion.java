package com.abamed.fcisassistant.StudentFragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.abamed.fcisassistant.Grades_Charts;
import com.abamed.fcisassistant.R;

import java.util.ArrayList;

import FcisAssistant.FirebaseClass;
import FcisAssistant.Post;

public class StudentDiscussion extends Fragment {
   private RecyclerView recyclerView;
   private RecyclerView.LayoutManager layoutManager;
   private RecyclerView.Adapter adapter;
   private ArrayList<Post> posts;
    public StudentDiscussion() {
        // Required empty public constructor
    }
    public static StudentDiscussion newInstance(String param1, String param2) {
        StudentDiscussion fragment = new StudentDiscussion();
        Bundle args = new Bundle();
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
        View view = inflater.inflate(R.layout.fragment_student_discussion, container, false);
        posts= FirebaseClass.ReadPosts();
        recyclerView =view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(false);
        layoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new DiscussionAdapter(posts);
        recyclerView.setAdapter(adapter);
        return view;
    }
    class DiscussionAdapter extends RecyclerView.Adapter<StudentDiscussion.DiscussionAdapter.ViewHolder> {

        private ArrayList<Post> posts;

        DiscussionAdapter(ArrayList<Post> posts) {
            this.posts=posts;
        }
        class ViewHolder extends RecyclerView.ViewHolder{
            ImageView PosterImage;
            TextView PosterName, PostContent, PostTime;

            ViewHolder(View itemView) {
                super(itemView);
                PosterImage = (ImageView)itemView.findViewById(R.id.posterimage);
                PosterName = (TextView)itemView.findViewById(R.id.postername);
                PostContent = (TextView)itemView.findViewById(R.id.postcontent);
                PostTime=(TextView)itemView.findViewById(R.id.posttime);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override public void onClick(View v) {
                        Intent intent = new Intent(getActivity(), Grades_Charts.class);
                        startActivity(intent);
                    }
                });
            }
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.discussionpost, viewGroup, false);
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            viewHolder.PosterName.setText(posts.get(i).getPoster());
            viewHolder.PostContent.setText(posts.get(i).getPostContent());
            viewHolder.PosterImage.setImageResource(posts.get(i).getPosterImage());
            viewHolder.PostTime.setText(posts.get(i).getPostTime());
        }

        @Override
        public int getItemCount() {
            return posts.size();
        }
    }
}
