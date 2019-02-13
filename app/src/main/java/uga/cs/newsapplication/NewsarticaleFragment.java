package uga.cs.newsapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsarticaleFragment extends Fragment {





    TextView textview;

    public NewsarticaleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_newsarticale, container, false);
        textview = view.findViewById(R.id.newsArticale);

        Bundle bundle = getArguments();
        if(bundle != null) {

            textview.setText(bundle.getString("position"));
        }
        return  view;

    }
    public void updateArticleView(String item) {
        textview.setText(item);

    }
}
