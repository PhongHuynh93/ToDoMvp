package dhbk.android.todomvp.tasks;

import dhbk.android.todomvp.data.Task;

/**
 * Created by huynhducthanhphong on 7/10/16.
 */

public interface TaskItemListener {

    void onTaskClick(Task clickedTask);

    void onCompleteTaskClick(Task completedTask);

    void onActivateTaskClick(Task activatedTask);
}