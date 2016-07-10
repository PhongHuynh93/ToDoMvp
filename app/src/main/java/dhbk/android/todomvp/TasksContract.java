package dhbk.android.todomvp;

import android.support.annotation.NonNull;

/**
 * Created by huynhducthanhphong on 7/10/16.
 */
public interface TasksContract {
    // TODO: 7/10/16 3 make a interface presenter, so class implements this becomes the presenter
    interface Presenter extends BasePresenter {

        void result(int requestCode, int resultCode);

        void loadTasks(boolean forceUpdate);

        void addNewTask();

        void openTaskDetails(@NonNull Task requestedTask);

        void completeTask(@NonNull Task completedTask);

        void activateTask(@NonNull Task activeTask);

        void clearCompletedTasks();

        void setFiltering(TasksFilterType requestType);

        TasksFilterType getFiltering();
    }
}
