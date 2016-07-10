package dhbk.android.todomvp;

/**
 * Created by huynhducthanhphong on 7/10/16.
 */

public interface TaskItemListener {

    void onTaskClick(Task clickedTask);

    void onCompleteTaskClick(Task completedTask);

    void onActivateTaskClick(Task activatedTask);
}