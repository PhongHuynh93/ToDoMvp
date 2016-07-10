package dhbk.android.todomvp;

/**
 * Created by huynhducthanhphong on 7/10/16.
 */

// TODO 4 this parent class to set the presenter to fragment
public interface BaseView<T> {
    void setPresenter(T presenter);

}