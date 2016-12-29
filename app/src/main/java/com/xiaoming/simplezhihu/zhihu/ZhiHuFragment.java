package com.xiaoming.simplezhihu.zhihu;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.xiaoming.simplezhihu.R;
import com.xiaoming.simplezhihu.base.BaseFragment;
import com.xiaoming.simplezhihu.bean.ZhiHuBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

/**
 * Created by ssthouse on 06/12/2016.
 */

public class ZhiHuFragment extends BaseFragment {

    @Bind(R.id.id_swipe_refresh)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @Bind(R.id.id_lv_zhihu)
    ListView mLvZhihu;

    private List<ZhiHuBean.StoriesBean> mStoriesBeanList = new ArrayList<>();

    @Override
    public int getContentView() {
        return R.layout.fragment_zhihu;
    }

    @Override
    public void init() {
        initZhiHuData();

        mLvZhihu.setAdapter(lvAdapter);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initZhiHuData();
            }
        });
    }

    private void initZhiHuData() {
        //init zhihu data
        ZhiHuGenerator.getStories(new Callback<ZhiHuBean>() {
            @Override
            public void onResponse(Call<ZhiHuBean> call, Response<ZhiHuBean> response) {
                mStoriesBeanList.clear();
                mStoriesBeanList.addAll(response.body().getStories());
                lvAdapter.notifyDataSetChanged();
                //stop refresh
                mSwipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<ZhiHuBean> call, Throwable t) {
                mSwipeRefreshLayout.setRefreshing(false);
                Timber.e("error");
            }
        });
    }

    private AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        }
    };

    private BaseAdapter lvAdapter = new BaseAdapter() {
        @Override
        public int getCount() {
            return mStoriesBeanList.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_zhihu, parent, false);
                viewHolder = new ViewHolder();
                viewHolder.cardView = (CardView) convertView.findViewById(R.id.id_card_view);
                viewHolder.ivThumbnail = (ImageView) convertView.findViewById(R.id.id_iv_thumbnail);
                viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.id_tv_title);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ZhiHuDetailAty.start(getActivity(), mStoriesBeanList.get(position));
                }
            });
            viewHolder.tvTitle.setText(mStoriesBeanList.get(position).getTitle());
            Picasso.with(getContext())
                    .load(mStoriesBeanList.get(position).getImages().get(0))
                    .into(viewHolder.ivThumbnail);
            return convertView;
        }
    };

    private static class ViewHolder {
        CardView cardView;
        ImageView ivThumbnail;
        TextView tvTitle;
    }
}
