package net.sgoliver.android.navigationdrawer;

import android.app.Application;
import android.content.Context;

import net.sgoliver.android.navigationdrawer.rest.GitHubService;

import rx.Scheduler;
import rx.schedulers.Schedulers;

/**
 * Created by User on 10/17/2016.
 */

public class MyApp extends Application {
    public static final String TAG = MyApp.class.getName();

    private GitHubService gitHubService;
    private Scheduler defaultSubscribeScheduler;

    public static MyApp get(Context context){
        return (MyApp) context.getApplicationContext();
    }

    public GitHubService getGitHubService(){
        if(gitHubService == null){
            gitHubService = GitHubService.Factory.create();
        }
        return gitHubService;
    }

    //For setting mocks during testing
    public void setGithubService(GitHubService gitHubService) {
        this.gitHubService = gitHubService;
    }

    public Scheduler defaultSubscribeScheduler() {
        if (defaultSubscribeScheduler == null) {
            defaultSubscribeScheduler = Schedulers.io();
        }
        return defaultSubscribeScheduler;
    }

    //User to change scheduler from tests
    public void setDefaultSubscribeScheduler(Scheduler scheduler) {
        this.defaultSubscribeScheduler = scheduler;
    }

}
