package uga.cs.newsapplication;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class HeadlinesFragment extends Fragment implements AdapterView.OnItemClickListener {

ListView listview;
OnHeadlineSelectedListener mCallback;  //

    @Override
    public void onAttach(Context context) {
        mCallback = (OnHeadlineSelectedListener) getActivity();
        super.onAttach(context);
    }

    public HeadlinesFragment() {
        // Required empty public constructor
    }
    // Container Activity must implement this interface
    public interface OnHeadlineSelectedListener {//switchboard
        public void onArticleSelected(int position,String item);//switch
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_headlines, container, false);
        listview = view.findViewById(R.id.listview);
        listview.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        NewsarticaleFragment frg = new NewsarticaleFragment();
        String itemClicked = (String)parent.getItemAtPosition(position);
        mCallback.onArticleSelected(position, itemClicked);
//switch on
    }

}
