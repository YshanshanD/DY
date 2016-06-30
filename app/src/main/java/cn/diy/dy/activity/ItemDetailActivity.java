package cn.diy.dy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import cn.diy.dy.R;
import cn.diy.dy.entity.CurrentUser;
import cn.diy.dy.entity.MovieEntity;
import cn.diy.dy.entity.User;
import cn.diy.dy.utils.StorageUtils;

/**
 * An activity representing a single Item detail screen. This
 * activity is only used narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a {@link ItemListActivity}.
 */
public class ItemDetailActivity extends AppCompatActivity {

    private String title;
    private String url;
    private StorageUtils storageUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);
        storageUtils = new StorageUtils(this);

        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // savedInstanceState is non-null when there is fragment state
        // saved from previous configurations of this activity
        // (e.g. when rotating the screen from portrait to landscape).
        // In this case, the fragment will automatically be re-added
        // to its container so we don't need to manually add it.
        // For more information, see the Fragments API guide at:
        //
        // http://developer.android.com/guide/components/fragments.html
        //
        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            Bundle arguments = getIntent().getExtras();
            url = arguments.getString("url");
            MovieEntity.ResultBean bean = arguments.getParcelable("item");
            title = bean.getTitle();
            ItemDetailFragment fragment = new ItemDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.item_detail_container, fragment)
                    .commit();
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getIntent().getIntExtra("mid", -1) <= 0) {
                    Toast.makeText(ItemDetailActivity.this, "资源不存在", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(ItemDetailActivity.this, PlayActivity.class);
                    intent.putExtra("url", getIntent().getStringExtra("url"));
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.share_item_activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            navigateUpTo(new Intent(this, ItemListActivity.class));
            return true;
        }
        if (id == R.id.action_share) {
            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.putExtra(Intent.EXTRA_TEXT, "this movie is pretty good, I want to share it to you" + url);
            shareIntent.setType("text/plain");
            startActivity(shareIntent.createChooser(shareIntent, "分享到"));//分享界面的弹出
        }
        if (id == R.id.action_collection) {
            if (!CurrentUser.LoginFlag) {
                Intent intent = new Intent(ItemDetailActivity.this, GuigeActivity.class);
                startActivity(intent);
            } else {
                CurrentUser.user.getTitleList().add(title);
                User user = null;
                String value = new String(storageUtils.readFileFromInternal("use_info"));
                List<User> ps = new Gson().fromJson(value, new TypeToken<List<User>>() {}.getType());
                for(User bean:ps){
                    if(bean.getName().equals(CurrentUser.user.getName())){
                        user = bean;
                        continue;
                    }
                }
                ps.remove(user);
                ps.add(CurrentUser.user);
                String valueString = new Gson().toJson(ps);
                storageUtils.writeFileToInternal("use_info",valueString.getBytes());
                Toast.makeText(ItemDetailActivity.this, "收藏成功", Toast.LENGTH_SHORT).show();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
