package com.xiaoming.simplezhihu.jokelist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.xiaoming.simplezhihu.R;
import com.xiaoming.simplezhihu.base.BaseFragment;
import com.xiaoming.simplezhihu.bean.JuheJokeBean;
import com.xiaoming.simplezhihu.utils.TimeUtil;
import com.xiaoming.simplezhihu.utils.ToastUtil;

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

public class JokeListFragment extends BaseFragment {


    @Bind(R.id.id_lv_jokes)
    ListView lvJokes;

    private List<JuheJokeBean.ResultBean> jokeBeanList = new ArrayList<>();

    @Override
    public int getContentView() {
        return R.layout.fragment_joke_list;
    }

    @Override
    public void init() {
        lvJokes.setAdapter(jokeAdapter);
        loadJokeList();
    }

    private void loadJokeList() {
        //judge joke time stamp
        long lastJokeTimeStamp = TodayJokeRecorder.getInstance(getContext()).getTimeStamp();
        //load local jokes
        if (!TimeUtil.isAfterDays(System.currentTimeMillis(), lastJokeTimeStamp)) {
            List<JuheJokeBean.ResultBean> resultBeanList = TodayJokeRecorder.getInstance(getContext())
                    .getResultBeanList();
            jokeBeanList.clear();
            jokeBeanList.addAll(resultBeanList);
            jokeAdapter.notifyDataSetChanged();
        } else {
            JuHeGenerator.getJuHeJoke(getContext(), new Callback<JuheJokeBean>() {
                @Override
                public void onResponse(Call<JuheJokeBean> call, Response<JuheJokeBean> response) {
                    Timber.e(response.body().toString());
                    if (!response.isSuccessful() || response.body() == null
                            || response.body().getError_code() != 0) {
                        ToastUtil.showCommonWrong(getContext());
                        return;
                    }
                    jokeBeanList.clear();
                    jokeBeanList.addAll(response.body().getResult());
                    jokeAdapter.notifyDataSetChanged();
                    //save jokes to local
                    TodayJokeRecorder.getInstance(getContext()).setTimeStamp(System.currentTimeMillis());
                    TodayJokeRecorder.getInstance(getContext()).setJokeResultBeanList(jokeBeanList);
                }

                @Override
                public void onFailure(Call<JuheJokeBean> call, Throwable t) {
                    Timber.e("error: %s", t.getMessage());
                    ToastUtil.showCommonWrong(getContext());
                }
            });
        }
    }

    private BaseAdapter jokeAdapter = new BaseAdapter() {
        @Override
        public int getCount() {
            return jokeBeanList.size();
        }

        @Override
        public Object getItem(int position) {
            return jokeBeanList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                viewHolder = new ViewHolder();
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_joke, parent, false);
                viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.id_tv_joke_title);
                viewHolder.tvContent = (TextView) convertView.findViewById(R.id.id_tv_joke_content);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            //set value
            viewHolder.tvContent.setText(jokeBeanList.get(position).getContent());
            return convertView;
        }
    };

    private static class ViewHolder {
        TextView tvTitle;
        TextView tvContent;
    }

}
