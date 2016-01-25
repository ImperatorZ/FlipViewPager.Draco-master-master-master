package com.yalantis.flip.sample.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.yalantis.flip.sample.FourFilm.MainActivityFour;
import com.yalantis.flip.sample.OneFilm.MainActivityOne;
import com.yalantis.flip.sample.R;
import com.yalantis.flip.sample.SixFilm.MainActivitySix;
import com.yalantis.flip.sample.Utils;
import com.yalantis.flip.sample.model.Friend;
import com.yalantis.flipviewpager.adapter.BaseFlipAdapter;
import com.yalantis.flipviewpager.utils.FlipSettings;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Yalantis
 */
public class FriendsActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);
        final ListView friends = (ListView) findViewById(R.id.friends);

//        Intent intent = new Intent(this,LifeActivity.class);

        FlipSettings settings = new FlipSettings.Builder().defaultPage(1).build();
        friends.setAdapter(new FriendsAdapter(this, Utils.friends, settings));
        friends.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Friend f = (Friend) friends.getAdapter().getItem(position);

                if (f.getNickname().equals("Выживший")){
                    Intent intent = new Intent(getApplicationContext(),MainActivitySix.class);
                    startActivity(intent);
                }

                if (f.getNickname().equals("Статус: Свободен")){
                    Intent intent = new Intent (getApplicationContext(), MainActivityFour.class);
                    startActivity(intent);
                }

                if (f.getNickname().equals("Иван Царевич\nи Серый Волк 3")){
                    Intent intent = new Intent(getApplicationContext(), MainActivityOne.class);
                    startActivity(intent);
                }
//                Toast.makeText(FriendsActivity.this, f.getNickname(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    class FriendsAdapter extends BaseFlipAdapter<Friend> {

        private final int PAGES = 3;
        private int[] IDS_INTEREST = {R.id.interest_1, R.id.interest_2};

        public FriendsAdapter(Context context, List<Friend> items, FlipSettings settings) {
            super(context, items, settings);
        }

        @Override
        public View getPage(int position, View convertView, ViewGroup parent, Friend friend1, Friend friend2) {
            final FriendsHolder holder;

            if (convertView == null) {
                holder = new FriendsHolder();
                convertView = getLayoutInflater().inflate(R.layout.friends_merge_page, parent, false);
                holder.leftAvatar = (ImageView) convertView.findViewById(R.id.first);
                holder.rightAvatar = (ImageView) convertView.findViewById(R.id.second);
                holder.infoPage = getLayoutInflater().inflate(R.layout.friends_info, parent, false);
                holder.nickName = (TextView) holder.infoPage.findViewById(R.id.nickname);

                for (int id : IDS_INTEREST)
                    holder.interests.add((TextView) holder.infoPage.findViewById(id));

                convertView.setTag(holder);
            } else {
                holder = (FriendsHolder) convertView.getTag();
            }

            switch (position) {
                // Merged page with 2 friends
                case 1:
                    holder.leftAvatar.setImageResource(friend1.getAvatar());
                    if (friend2 != null)
                        holder.rightAvatar.setImageResource(friend2.getAvatar());
                    break;
                default:
                    fillHolder(holder, position == 0 ? friend1 : friend2);
                    holder.infoPage.setTag(holder);
                    return holder.infoPage;
            }
            return convertView;
        }

        @Override
        public int getPagesCount() {
            return PAGES;
        }

        private void fillHolder(FriendsHolder holder, Friend friend) {
            if (friend == null)
                return;
            Iterator<TextView> iViews = holder.interests.iterator();
            Iterator<String> iInterests = friend.getInterests().iterator();
            while (iViews.hasNext() && iInterests.hasNext())
                iViews.next().setText(iInterests.next());
            holder.infoPage.setBackgroundColor(getResources().getColor(friend.getBackground()));
            holder.nickName.setText(friend.getNickname());
        }

        class FriendsHolder {
            ImageView leftAvatar;
            ImageView rightAvatar;
            View infoPage;

            List<TextView> interests = new ArrayList<>();
            TextView nickName;
        }
    }
}
