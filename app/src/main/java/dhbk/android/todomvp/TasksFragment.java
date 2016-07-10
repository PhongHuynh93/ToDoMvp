package dhbk.android.todomvp;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


// TODO: 7/10/16 2
/**
 * A simple {@link Fragment} subclass.
 */
public class TasksFragment extends Fragment {
    private TasksContract.Presenter mPresenter;
    private TasksAdapter mListAdapter;


    /**
     *  Listener for clicks on tasks in the ListView, pass this interface to adapter
     */
    TaskItemListener mItemListener = new TaskItemListener() {
        @Override
        public void onTaskClick(Task clickedTask) {
            mPresenter.openTaskDetails(clickedTask);
        }

        @Override
        public void onCompleteTaskClick(Task completedTask) {
            mPresenter.completeTask(completedTask);
        }

        @Override
        public void onActivateTaskClick(Task activatedTask) {
            mPresenter.activateTask(activatedTask);
        }
    };


    public TasksFragment() {
        // Required empty public constructor
    }

    public static TasksFragment newInstance() {
        return new TasksFragment();
    }


    // create an empty adapter in oncreate + pass interface to listen when item click
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mListAdapter = new TasksAdapter(new ArrayList<Task>(0), mItemListener);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.tasks_frag, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }
}
