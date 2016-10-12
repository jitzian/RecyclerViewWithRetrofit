package net.sgoliver.android.navigationdrawer.presenter;

import android.util.Log;

import net.sgoliver.android.navigationdrawer.dagger.PostService;
import net.sgoliver.android.navigationdrawer.dagger.contract.MainScreenContract;
import net.sgoliver.android.navigationdrawer.model.Post;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Retrofit;
import retrofit2.http.GET;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by User on 10/11/2016.
 */

public class MainScreenPresenter implements MainScreenContract.Presenter {
    public static final String TAG = MainScreenPresenter.class.getName();

    Retrofit retrofit;
    MainScreenContract.View mView;

    @Inject
    public MainScreenPresenter(Retrofit retrofit, MainScreenContract.View mView) {
        this.retrofit = retrofit;
        this.mView = mView;
    }

    @Override
    public void loadPost() {
        Log.d(TAG, "loadPost");
        retrofit.create(PostService.class).getPostList().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<List<Post>>() {
                    @Override
                    public void onCompleted() {
                        mView.showComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(List<Post> posts) {
                        mView.showPosts(posts);
                    }
                });
    }

    private interface PostService{
        @GET("/posts")
        Observable<List<Post>>getPostList();
    }

}
