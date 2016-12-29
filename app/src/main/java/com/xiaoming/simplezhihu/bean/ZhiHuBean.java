package com.xiaoming.simplezhihu.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ssthouse on 06/12/2016.
 */

public class ZhiHuBean {


    /**
     * date : 20161206
     * stories : [{"images":["http://pic2.zhimg.com/5cd9140faaedfb9afced3708c924e2b9.jpg"],"type":0,"id":8269791,"ga_prefix":"120612","title":"大误 · 厨房区发生了一起骇人听闻的大案"},{"images":["http://pic1.zhimg.com/a80b286be75318f976a32ee58ad11de0.jpg"],"type":0,"id":9039885,"ga_prefix":"120611","title":"一夜之间，意大利把自家总理「踢」下了台"},{"images":["http://pic4.zhimg.com/b411efcdc62a2d78dc81cef3d4325b27.jpg"],"type":0,"id":9037871,"ga_prefix":"120610","title":"打字比语音输入更快是一种怎样的体验？"},{"images":["http://pic1.zhimg.com/cbad12e3ab067cd04ec2e61241145750.jpg"],"type":0,"id":9040079,"ga_prefix":"120609","title":"「精神分析」被抛弃了，这事儿要从祖师爷弗洛伊德说起"},{"images":["http://pic1.zhimg.com/2e31cf3465a69d81f0dd362a9f1b4a5c.jpg"],"type":0,"id":9036983,"ga_prefix":"120608","title":"把专卖店修成了地标，苹果的门店设计好在哪儿？"},{"images":["http://pic4.zhimg.com/bfb39d931c0bdd282c29542965653efb.jpg"],"type":0,"id":9038901,"ga_prefix":"120607","title":"生殖隔离先不管了，我们来愉快地交配吧"},{"title":"有哪些适合冬天喝的热饮？","ga_prefix":"120607","images":["http://pic1.zhimg.com/90aa56aae25341d0f6862e3981d11d68.jpg"],"multipic":true,"type":0,"id":9030573},{"images":["http://pic1.zhimg.com/d57405bab8a43b04e622a7bbc1254720.jpg"],"type":0,"id":9039718,"ga_prefix":"120607","title":"如果地震来了，你正在地铁里\u2026\u2026"},{"images":["http://pic2.zhimg.com/a4d2bd34d072f158607c8a36a5e37ced.jpg"],"type":0,"id":9040054,"ga_prefix":"120607","title":"读读日报 24 小时热门 TOP 5 · 诺兰挖下的这些坑都填平了"},{"images":["http://pic4.zhimg.com/9bd484bb870820ca8561ef3de1235afb.jpg"],"type":0,"id":9036728,"ga_prefix":"120606","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"http://pic4.zhimg.com/072648ac87c4938a9f64c13cb728f2a7.jpg","type":0,"id":9039885,"ga_prefix":"120611","title":"一夜之间，意大利把自家总理「踢」下了台"},{"image":"http://pic1.zhimg.com/738e1add50b492e39be18860007dd69c.jpg","type":0,"id":9040054,"ga_prefix":"120607","title":"读读日报 24 小时热门 TOP 5 · 诺兰挖下的这些坑都填平了"},{"image":"http://pic4.zhimg.com/51a591e35232d1c05d2b63e4141593bf.jpg","type":0,"id":9038901,"ga_prefix":"120607","title":"生殖隔离先不管了，我们来愉快地交配吧"},{"image":"http://pic4.zhimg.com/b93a268f06d3caa03be73d0c437a81b3.jpg","type":0,"id":9038853,"ga_prefix":"120517","title":"知乎好问题 · 如何顺利通过驾考科目二考试？"},{"image":"http://pic4.zhimg.com/69ac64631429ed18b6c144feb63b727b.jpg","type":0,"id":9036736,"ga_prefix":"120516","title":"等等，怎么芹菜也「杀精」了？"}]
     */

    private String date;
    /**
     * images : ["http://pic2.zhimg.com/5cd9140faaedfb9afced3708c924e2b9.jpg"]
     * type : 0
     * id : 8269791
     * ga_prefix : 120612
     * title : 大误 · 厨房区发生了一起骇人听闻的大案
     */

    private List<StoriesBean> stories;
    /**
     * image : http://pic4.zhimg.com/072648ac87c4938a9f64c13cb728f2a7.jpg
     * type : 0
     * id : 9039885
     * ga_prefix : 120611
     * title : 一夜之间，意大利把自家总理「踢」下了台
     */

    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean implements Serializable {
        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private List<String> images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
