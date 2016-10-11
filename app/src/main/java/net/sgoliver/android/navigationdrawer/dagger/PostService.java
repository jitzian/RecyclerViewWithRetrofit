package net.sgoliver.android.navigationdrawer.dagger;

import net.sgoliver.android.navigationdrawer.model.Post;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by User on 10/11/2016.
 */

public interface PostService {
    @GET("/posts")
    Observable<List<Post>> getPostList();
}
