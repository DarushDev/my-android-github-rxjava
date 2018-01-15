package com.example.myandroidgithubrxjava;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Darush on 1/15/2018.
 */

public class GithubRepoAdapter extends BaseAdapter {

    private List<GithubRepo> githubRepoList = new ArrayList<>();

    @Override
    public int getCount() {
        return githubRepoList.size();
    }

    @Override
    public GithubRepo getItem(int position) {
        if(position < 0 || position >= githubRepoList.size()) {
            return null;
        } else {
            return githubRepoList.get(position);
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        final View view = (convertView != null ? convertView : createView(viewGroup));
        final GithubRepoViewHolder viewHolder = (GithubRepoViewHolder) view.getTag();
        viewHolder.setGithubRepo(getItem(position));
        return view;
    }

    public void setGithubRepos(@Nullable List<GithubRepo> repos) {
        if(repos == null) {
            return;
        }
        githubRepoList.clear();
        githubRepoList.addAll(repos);
        notifyDataSetChanged();
    }

    private View createView(ViewGroup parent) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View view = inflater.inflate(R.layout.item_githubrepo, parent, false);
        final GithubRepoViewHolder viewHolder = new GithubRepoViewHolder(view);
        view.setTag(viewHolder);
        return view;
    }

    private static class GithubRepoViewHolder {

        private TextView textRepoName;
        private TextView textRepoDescription;
        private TextView textLanguage;
        private TextView textStars;

        public GithubRepoViewHolder(View view) {
            textRepoName = view.findViewById(R.id.text_githubrepo_reponame);
            textRepoDescription = view.findViewById(R.id.text_githubrepo_repodescription);
            textLanguage = view.findViewById(R.id.text_githubrepo_language);
            textStars = view.findViewById(R.id.text_githubrepo_stars);
        }

        public void setGithubRepo(GithubRepo githubRepo) {
            textRepoName.setText(githubRepo.name);
            textRepoDescription.setText(githubRepo.description);
            textLanguage.setText("Language: " + githubRepo.language);
            textStars.setText("Stars: " + githubRepo.starGazersCount);
        }
    }
}
