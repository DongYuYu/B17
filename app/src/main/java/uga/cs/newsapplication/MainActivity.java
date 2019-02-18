package uga.cs.newsapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements HeadlinesFragment.OnHeadlineSelectedListener{
    EditText editText;








    Button button;
    Pattern p ;
    public boolean validate(String s) {






        if (Patterns.EMAIL_ADDRESS.matcher(s).matches()) {
            return true;
        }else {
            return false;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        editText = findViewById(R.id.editText);

        button = findViewById(R.id.button);






        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {





                String s = editText.getText().toString();

                if (!validate(s)) {
                    Toast.makeText(MainActivity.this, "please enter valid.", Toast.LENGTH_LONG).show();
                };
            }
        });
    }
    @Override
    public void onArticleSelected(int position,String item){
        NewsarticaleFragment articleFrag = (NewsarticaleFragment)
                getSupportFragmentManager().findFragmentById(R.id.newsContainer);



        if (articleFrag != null) {
            // If article frag is available, we're in two-pane layout...

            // Call a method in the ArticleFragment to update its content
            articleFrag.updateArticleView(item);
        }else {

            NewsarticaleFragment newFragment = new NewsarticaleFragment();
            Bundle args = new Bundle();
            args.putString("position", item);
            newFragment.setArguments(args);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            // and add the transaction to the back stack so the user can navigate back
    //        Fragment f = getSupportFragmentManager().findFragmentById(R.id.headlinefragment);
    //        transaction.remove(f);
            transaction.replace(R.id.headlinefragment, newFragment);


            transaction.addToBackStack(null);

            // Commit the transaction
            transaction.commit();
        }
    }
}
