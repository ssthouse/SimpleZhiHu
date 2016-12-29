package com.xiaoming.simplezhihu.bean;

import java.util.List;

/**
 * Created by ssthouse on 07/12/2016.
 */

public class JuheJokeBean {

    /**
     * reason : success
     * result : [{"content":"售货员妹纸第一次谈恋爱，男友第一次吻她后，妹纸说：还需要点别的么？","hashId":"38ffd057ff979222d7b10f0371da1954","unixtime":"1425553431"},{"content":"外地上学的妹妹给我写信：姐，好想你，清明 节快 到了，我们见 面的日 子不 远了..","hashId":"e19ba962f8d7ff6634c6a27d261cf62f","unixtime":"1425553431"},{"content":"我说包里的毛爷爷。。。\r\n甲：有种东西，红变绿，绿成黄，黄变蓝，蓝变紫，最后彻 底消失。。\r\n乙：你说彩虹么？\r\n甲：不是，我说包里的毛爷爷。。。","hashId":"d386ef56cfb1de35163aa8d592b173b3","unixtime":"1425553431"},{"content":"我发朋友圈\r\n今天逛街不小心从楼梯上摔下来了，跪在地上膝盖流了好多血，正好有个帅哥看到了赶忙要把我扶起来，我痛苦的趴在地上。\r\n对帅哥说：\u201c你先别扶我，我男朋友出差了我膝盖破了我怕他误会，你拿我手机给我这个姿势拍张照，等下我发朋友圈\u201d\u2026","hashId":"93f515092389b041272c0e734b755804","unixtime":"1425553431"},{"content":"班上一女同学和一男同学打赌这场篮球赛谁输谁赢，女同学首先放狠话了: 如果我输了跟你姓\u2026\u2026男同学听了，脸红极了\u2026\u2026原来这男同学姓焦\u2026\u2026","hashId":"5d32738dfac9f0e5d592a226ea09551b","unixtime":"1425553431"},{"content":"我就买东西去了\r\n看到老同学夫妻俩个结婚都快满25年了，人家上街仍是每次上街都手牵着手。我真是羡慕嫉妒恨啊，有一次当街遇到了，就夸赞他们：\u201c你们感情真是太好了，都是老夫老妻了，还这么恩爱 啊？\u201d没想到同学的妻子说话了：\u201c你还不了解他啊；他这是怕他自己一放手，我就买东西去了。\u201d。。。","hashId":"0de91debaf6ad1663be2618aee943d43","unixtime":"1425553431"},{"content":"有人问：为何隔壁老王如此牛比，搞了那么多隔壁少妇？ 答：有那么多邻居，只能说明他有很多房产，也就说老王很有钱，我靠，恍然大悟\u2026","hashId":"3F26DB3D7346CE60F79815BF760AFD9E","unixtime":"1425553934"},{"content":"甲:兄弟，这是上次欠你的3000块钱，现在还你。 乙：我俩谁跟谁啊，没事，你先花着。 甲：欠钱一定要还，来拿着。 乙：我真不急着用钱，这钱以后再说。 劫匪：你们俩墨迹什么呢，快点把钱交出来！","hashId":"49AFEC167DF7CC9E3F2187A73F7723FB","unixtime":"1425553948"},{"content":"给老妈打电话。 我：妈，你在哪儿啊？ 妈：刚在超市买菜，现在在公交上了。 我：你和谁一起去的超市你还记得么？我在超市门口等你半个小时了！","hashId":"34024BEE2E027B5C3F15C2855F4724D1","unixtime":"1425553948"},{"content":"今天陪老婆去逛手机城，她看中一款三星手机，我觉得价格太贵不同意，这时她突然说要去上厕所让我在外面等，不一会她发了个短信\u201c老公\u2026\u2026伦家手机掉厕所里了，好伤心\u2026\u2026你不帮我买新手机我就不想出来了\u2026\u2026\u201d无奈我一边抱怨 她又这样粗心大意一边去帮她买那款手机。 然后。我突然明白了什么，当着售货员的面大叫道\u201c刚才难道是屎在跟我说话吗？\u201d","hashId":"67F48A08ED8DC9CE5B0D6564B38676DE","unixtime":"1425554524"}]
     * error_code : 0
     */

    private String reason;
    private int error_code;
    /**
     * content : 售货员妹纸第一次谈恋爱，男友第一次吻她后，妹纸说：还需要点别的么？
     * hashId : 38ffd057ff979222d7b10f0371da1954
     * unixtime : 1425553431
     */

    private List<ResultBean> result;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        private String content;
        private String hashId;
        private String unixtime;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getHashId() {
            return hashId;
        }

        public void setHashId(String hashId) {
            this.hashId = hashId;
        }

        public String getUnixtime() {
            return unixtime;
        }

        public void setUnixtime(String unixtime) {
            this.unixtime = unixtime;
        }
    }

    @Override
    public String toString() {
        return "errorCode: " + error_code
                + "reason:" + reason;
    }
}
