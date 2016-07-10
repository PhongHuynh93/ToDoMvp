package dhbk.android.todomvp;

import android.support.annotation.NonNull;

import java.util.List;

/**
 * Created by huynhducthanhphong on 7/10/16.
 */
public interface TasksContract {
    // TODO: 7/10/16 3 make a interface presenter, so class implements this becomes the presenter
    interface Presenter extends BasePresenter {

        void result(int requestCode, int resultCode);

        void loadTasks(boolean forceUpdate);

        void addNewTask();

        // 3 methods to implements the task click listener
        void openTaskDetails(@NonNull Task requestedTask);
        void completeTask(@NonNull Task completedTask);
        void activateTask(@NonNull Task activeTask);

        void clearCompletedTasks();

        void setFiltering(TasksFilterType requestType);

        TasksFilterType getFiltering();
    }


    // contains interface that a task fragment must implement
    interface View extends BaseView<Presenter> {

        void setLoadingIndicator(boolean active);

        void showTasks(List<Task> tasks);

        void showAddTask();

        void showTaskDetailsUi(String taskId);

        void showTaskMarkedComplete();

        void showTaskMarkedActive();

        void showCompletedTasksCleared();

        void showLoadingTasksError();

        void showNoTasks();

        void showActiveFilterLabel();

        void showCompletedFilterLabel();

        void showAllFilterLabel();

        void showNoActiveTasks();

        void showNoCompletedTasks();

        void showSuccessfullySavedMessage();

        boolean isActive();

        void showFilteringPopUpMenu();
    }
}
