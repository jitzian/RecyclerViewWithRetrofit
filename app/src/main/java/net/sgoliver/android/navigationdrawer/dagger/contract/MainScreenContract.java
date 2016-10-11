package net.sgoliver.android.navigationdrawer.dagger.contract;

import net.sgoliver.android.navigationdrawer.model.Post;

import java.util.List;

/**
 * Created by User on 10/11/2016.
 */

public interface MainScreenContract {
    interface View {
        void showPosts(List<Post>posts);
        void showError(String message);
        void showComplete();
    }
    interface Presenter{
        void loadPost();
    }
}
