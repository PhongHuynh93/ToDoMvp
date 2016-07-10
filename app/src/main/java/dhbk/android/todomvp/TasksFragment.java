package dhbk.android.todomvp;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


// TODO: 7/10/16 2
/**
 * A simple {@link Fragment} subclass.
 */

public class TasksFragment extends Fragment implements TasksContract.View{
    // declare presenter
    private TasksContract.Presenter mPresenter;

    // declare listview
    private TasksAdapter mListAdapter;
    private TextView mFilteringLabelView; //
    private LinearLayout mTasksView;


    // declare no task layout
    private View mNoTasksView;
    private ImageView mNoTaskIcon;
    private TextView mNoTaskMainView;
    private TextView mNoTaskAddView;


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
        View root = inflater.inflate(R.layout.tasks_frag, container, false);


        // Set up listview + label below listview + linearlayout that contains label and listview
        ListView listView = (ListView) root.findViewById(R.id.tasks_list);
        listView.setAdapter(mListAdapter);
        mFilteringLabelView = (TextView) root.findViewById(R.id.filteringLabel);
        mTasksView = (LinearLayout) root.findViewById(R.id.tasksLL);



        // Set up  no tasks view
        mNoTasksView = root.findViewById(R.id.noTasks);
        mNoTaskIcon = (ImageView) root.findViewById(R.id.noTasksIcon);
        mNoTaskMainView = (TextView) root.findViewById(R.id.noTasksMain);
        mNoTaskAddView = (TextView) root.findViewById(R.id.noTasksAdd);
        mNoTaskAddView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddTask();
            }
        });


        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }
}
