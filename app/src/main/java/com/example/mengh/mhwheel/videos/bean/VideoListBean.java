package com.example.mengh.mhwheel.videos.bean;

import java.io.Serializable;
import java.util.List;

public class VideoListBean implements Serializable{

    private int count;
    private int total;
    private String nextPageUrl;
    private boolean adExist;
    private List<ItemListBeanX> itemList;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getNextPageUrl() {
        return nextPageUrl;
    }

    public void setNextPageUrl(String nextPageUrl) {
        this.nextPageUrl = nextPageUrl;
    }

    public boolean isAdExist() {
        return adExist;
    }

    public void setAdExist(boolean adExist) {
        this.adExist = adExist;
    }

    public List<ItemListBeanX> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemListBeanX> itemList) {
        this.itemList = itemList;
    }

    public static class ItemListBeanX implements Serializable{
        /**
         * type : horizontalScrollCard
         * data : {"dataType":"HorizontalScrollCard","itemList":[{"type":"banner2","data":{"dataType":"Banner","id":796,"title":"","description":"","image":"http://img.kaiyanapp.com/2ca238dfc04292f5fb41c321ed1eb0b4.jpeg?imageMogr2/quality/60/format/jpg","actionUrl":"eyepetizer://webview/?title=%E7%94%B5%E5%BD%B1%E6%94%BE%E6%98%A0%E5%AE%A4&url=http%3A%2F%2Fwww.eyepetizer.net%2Farticle.html%3Fnid%3D1157%26udid%3D%26uid%3D0%26utm_source%3Ddiscovery","adTrack":null,"shade":false,"label":{"text":"","card":"","detail":null},"labelList":[],"header":{"id":0,"title":null,"font":null,"subTitle":null,"subTitleFont":null,"textAlign":"left","cover":null,"label":null,"actionUrl":null,"labelList":null,"icon":null,"description":null}},"tag":null,"id":0,"adIndex":-1},{"type":"banner2","data":{"dataType":"Banner","id":797,"title":"","description":"","image":"http://img.kaiyanapp.com/6f53184af84b428853d97e67eb250e40.jpeg?imageMogr2/quality/60/format/jpg","actionUrl":"eyepetizer://webview/?title=%E7%BE%8E%E5%89%A7%E6%94%BE%E6%98%A0%E5%AE%A4&url=http%3A%2F%2Fwww.eyepetizer.net%2Farticle.html%3Fnid%3D1156%26udid%3D%26uid%3D0%26utm_source%3Ddiscovery","adTrack":null,"shade":false,"label":{"text":"","card":"","detail":null},"labelList":[],"header":{"id":0,"title":null,"font":null,"subTitle":null,"subTitleFont":null,"textAlign":"left","cover":null,"label":null,"actionUrl":null,"labelList":null,"icon":null,"description":null}},"tag":null,"id":0,"adIndex":-1},{"type":"banner2","data":{"dataType":"Banner","id":696,"title":"","description":"","image":"http://img.kaiyanapp.com/cb4fa0f645bad89694a21dfae55f94fd.jpeg?imageMogr2/quality/60/format/jpg","actionUrl":"eyepetizer://webview/?title=2018%20FIRST%20%E5%BD%B1%E5%B1%95%E7%9F%AD%E7%89%87%E5%AD%A3&url=http%3A%2F%2Fwww.eyepetizer.net%2Farticle.html%3Fnid%3D1137%26shareable%3Dtrue","adTrack":null,"shade":false,"label":{"text":"","card":"","detail":null},"labelList":[],"header":{"id":0,"title":null,"font":null,"subTitle":null,"subTitleFont":null,"textAlign":"left","cover":null,"label":null,"actionUrl":null,"labelList":null,"icon":null,"description":null}},"tag":null,"id":0,"adIndex":-1}],"count":3}
         * tag : null
         * id : 0
         * adIndex : -1
         */

        private String type;
        private DataBeanX data;
        private String tag;
        private int id;
        private int adIndex;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public DataBeanX getData() {
            return data;
        }

        public void setData(DataBeanX data) {
            this.data = data;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getAdIndex() {
            return adIndex;
        }

        public void setAdIndex(int adIndex) {
            this.adIndex = adIndex;
        }

        public static class DataBeanX implements Serializable{
            /**
             * dataType : HorizontalScrollCard
             * itemList : [{"type":"banner2","data":{"dataType":"Banner","id":796,"title":"","description":"","image":"http://img.kaiyanapp.com/2ca238dfc04292f5fb41c321ed1eb0b4.jpeg?imageMogr2/quality/60/format/jpg","actionUrl":"eyepetizer://webview/?title=%E7%94%B5%E5%BD%B1%E6%94%BE%E6%98%A0%E5%AE%A4&url=http%3A%2F%2Fwww.eyepetizer.net%2Farticle.html%3Fnid%3D1157%26udid%3D%26uid%3D0%26utm_source%3Ddiscovery","adTrack":null,"shade":false,"label":{"text":"","card":"","detail":null},"labelList":[],"header":{"id":0,"title":null,"font":null,"subTitle":null,"subTitleFont":null,"textAlign":"left","cover":null,"label":null,"actionUrl":null,"labelList":null,"icon":null,"description":null}},"tag":null,"id":0,"adIndex":-1},{"type":"banner2","data":{"dataType":"Banner","id":797,"title":"","description":"","image":"http://img.kaiyanapp.com/6f53184af84b428853d97e67eb250e40.jpeg?imageMogr2/quality/60/format/jpg","actionUrl":"eyepetizer://webview/?title=%E7%BE%8E%E5%89%A7%E6%94%BE%E6%98%A0%E5%AE%A4&url=http%3A%2F%2Fwww.eyepetizer.net%2Farticle.html%3Fnid%3D1156%26udid%3D%26uid%3D0%26utm_source%3Ddiscovery","adTrack":null,"shade":false,"label":{"text":"","card":"","detail":null},"labelList":[],"header":{"id":0,"title":null,"font":null,"subTitle":null,"subTitleFont":null,"textAlign":"left","cover":null,"label":null,"actionUrl":null,"labelList":null,"icon":null,"description":null}},"tag":null,"id":0,"adIndex":-1},{"type":"banner2","data":{"dataType":"Banner","id":696,"title":"","description":"","image":"http://img.kaiyanapp.com/cb4fa0f645bad89694a21dfae55f94fd.jpeg?imageMogr2/quality/60/format/jpg","actionUrl":"eyepetizer://webview/?title=2018%20FIRST%20%E5%BD%B1%E5%B1%95%E7%9F%AD%E7%89%87%E5%AD%A3&url=http%3A%2F%2Fwww.eyepetizer.net%2Farticle.html%3Fnid%3D1137%26shareable%3Dtrue","adTrack":null,"shade":false,"label":{"text":"","card":"","detail":null},"labelList":[],"header":{"id":0,"title":null,"font":null,"subTitle":null,"subTitleFont":null,"textAlign":"left","cover":null,"label":null,"actionUrl":null,"labelList":null,"icon":null,"description":null}},"tag":null,"id":0,"adIndex":-1}]
             * count : 3
             */

            private String dataType;
            private int count;
            private List<ItemListBean> itemList;
            private int id;
            private String title;
            private String description;
            private String library;
            private ConsumptionBean consumption;
            private String resourceType;
            private String slogan;
            private ProviderBean provider;
            private String category;
            private AuthorBean author;
            private CoverBean cover;
            private String playUrl;
            private String thumbPlayUrl;
            private int duration;
            private WebUrlBean webUrl;
            private long releaseTime;
            private Object campaign;
            private Object waterMarks;
            private Object adTrack;
            private String type;
            private String titlePgc;
            private String descriptionPgc;
            private Object remark;
            private boolean ifLimitVideo;
            private int idx;
            private Object shareAdTrack;
            private Object favoriteAdTrack;
            private Object webAdTrack;
            private long date;
            private Object promotion;
            private Object label;
            private String descriptionEditor;
            private boolean collected;
            private boolean played;
            private Object lastViewTime;
            private Object playlists;
            private Object src;
            private List<TagsBean> tags;
            private List<PlayInfoBean> playInfo;
            private List<?> labelList;
            private List<?> subtitles;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getLibrary() {
                return library;
            }

            public void setLibrary(String library) {
                this.library = library;
            }

            public ConsumptionBean getConsumption() {
                return consumption;
            }

            public void setConsumption(ConsumptionBean consumption) {
                this.consumption = consumption;
            }

            public String getResourceType() {
                return resourceType;
            }

            public void setResourceType(String resourceType) {
                this.resourceType = resourceType;
            }

            public String getSlogan() {
                return slogan;
            }

            public void setSlogan(String slogan) {
                this.slogan = slogan;
            }

            public ProviderBean getProvider() {
                return provider;
            }

            public void setProvider(ProviderBean provider) {
                this.provider = provider;
            }

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public AuthorBean getAuthor() {
                return author;
            }

            public void setAuthor(AuthorBean author) {
                this.author = author;
            }

            public CoverBean getCover() {
                return cover;
            }

            public void setCover(CoverBean cover) {
                this.cover = cover;
            }

            public String getPlayUrl() {
                return playUrl;
            }

            public void setPlayUrl(String playUrl) {
                this.playUrl = playUrl;
            }

            public String getThumbPlayUrl() {
                return thumbPlayUrl;
            }

            public void setThumbPlayUrl(String thumbPlayUrl) {
                this.thumbPlayUrl = thumbPlayUrl;
            }

            public int getDuration() {
                return duration;
            }

            public void setDuration(int duration) {
                this.duration = duration;
            }

            public WebUrlBean getWebUrl() {
                return webUrl;
            }

            public void setWebUrl(WebUrlBean webUrl) {
                this.webUrl = webUrl;
            }

            public long getReleaseTime() {
                return releaseTime;
            }

            public void setReleaseTime(long releaseTime) {
                this.releaseTime = releaseTime;
            }

            public Object getCampaign() {
                return campaign;
            }

            public void setCampaign(Object campaign) {
                this.campaign = campaign;
            }

            public Object getWaterMarks() {
                return waterMarks;
            }

            public void setWaterMarks(Object waterMarks) {
                this.waterMarks = waterMarks;
            }

            public Object getAdTrack() {
                return adTrack;
            }

            public void setAdTrack(Object adTrack) {
                this.adTrack = adTrack;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getTitlePgc() {
                return titlePgc;
            }

            public void setTitlePgc(String titlePgc) {
                this.titlePgc = titlePgc;
            }

            public String getDescriptionPgc() {
                return descriptionPgc;
            }

            public void setDescriptionPgc(String descriptionPgc) {
                this.descriptionPgc = descriptionPgc;
            }

            public Object getRemark() {
                return remark;
            }

            public void setRemark(Object remark) {
                this.remark = remark;
            }

            public boolean isIfLimitVideo() {
                return ifLimitVideo;
            }

            public void setIfLimitVideo(boolean ifLimitVideo) {
                this.ifLimitVideo = ifLimitVideo;
            }

            public int getIdx() {
                return idx;
            }

            public void setIdx(int idx) {
                this.idx = idx;
            }

            public Object getShareAdTrack() {
                return shareAdTrack;
            }

            public void setShareAdTrack(Object shareAdTrack) {
                this.shareAdTrack = shareAdTrack;
            }

            public Object getFavoriteAdTrack() {
                return favoriteAdTrack;
            }

            public void setFavoriteAdTrack(Object favoriteAdTrack) {
                this.favoriteAdTrack = favoriteAdTrack;
            }

            public Object getWebAdTrack() {
                return webAdTrack;
            }

            public void setWebAdTrack(Object webAdTrack) {
                this.webAdTrack = webAdTrack;
            }

            public long getDate() {
                return date;
            }

            public void setDate(long date) {
                this.date = date;
            }

            public Object getPromotion() {
                return promotion;
            }

            public void setPromotion(Object promotion) {
                this.promotion = promotion;
            }

            public Object getLabel() {
                return label;
            }

            public void setLabel(Object label) {
                this.label = label;
            }

            public String getDescriptionEditor() {
                return descriptionEditor;
            }

            public void setDescriptionEditor(String descriptionEditor) {
                this.descriptionEditor = descriptionEditor;
            }

            public boolean isCollected() {
                return collected;
            }

            public void setCollected(boolean collected) {
                this.collected = collected;
            }

            public boolean isPlayed() {
                return played;
            }

            public void setPlayed(boolean played) {
                this.played = played;
            }

            public Object getLastViewTime() {
                return lastViewTime;
            }

            public void setLastViewTime(Object lastViewTime) {
                this.lastViewTime = lastViewTime;
            }

            public Object getPlaylists() {
                return playlists;
            }

            public void setPlaylists(Object playlists) {
                this.playlists = playlists;
            }

            public Object getSrc() {
                return src;
            }

            public void setSrc(Object src) {
                this.src = src;
            }

            public List<TagsBean> getTags() {
                return tags;
            }

            public void setTags(List<TagsBean> tags) {
                this.tags = tags;
            }

            public List<PlayInfoBean> getPlayInfo() {
                return playInfo;
            }

            public void setPlayInfo(List<PlayInfoBean> playInfo) {
                this.playInfo = playInfo;
            }

            public List<?> getLabelList() {
                return labelList;
            }

            public void setLabelList(List<?> labelList) {
                this.labelList = labelList;
            }

            public List<?> getSubtitles() {
                return subtitles;
            }

            public void setSubtitles(List<?> subtitles) {
                this.subtitles = subtitles;
            }

            public static class ConsumptionBean implements Serializable{
                /**
                 * collectionCount : 852
                 * shareCount : 541
                 * replyCount : 16
                 */

                private int collectionCount;
                private int shareCount;
                private int replyCount;

                public int getCollectionCount() {
                    return collectionCount;
                }

                public void setCollectionCount(int collectionCount) {
                    this.collectionCount = collectionCount;
                }

                public int getShareCount() {
                    return shareCount;
                }

                public void setShareCount(int shareCount) {
                    this.shareCount = shareCount;
                }

                public int getReplyCount() {
                    return replyCount;
                }

                public void setReplyCount(int replyCount) {
                    this.replyCount = replyCount;
                }
            }

            public static class ProviderBean implements Serializable{
                /**
                 * name : 投稿
                 * alias : PGC2
                 * icon :
                 */

                private String name;
                private String alias;
                private String icon;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getAlias() {
                    return alias;
                }

                public void setAlias(String alias) {
                    this.alias = alias;
                }

                public String getIcon() {
                    return icon;
                }

                public void setIcon(String icon) {
                    this.icon = icon;
                }
            }

            public static class AuthorBean implements Serializable{
                /**
                 * id : 2763
                 * icon : http://img.kaiyanapp.com/a19402fd060bf1bb4904195a197ad278.png?imageMogr2/quality/60/format/jpg
                 * name : 电影精选
                 * description : 推荐好电影，让柔软的时光在光与影的氤氲中静静沉淀。
                 * link :
                 * latestReleaseTime : 1525154424000
                 * videoNum : 56
                 * adTrack : null
                 * follow : {"itemType":"author","itemId":2763,"followed":false}
                 * shield : {"itemType":"author","itemId":2763,"shielded":false}
                 * approvedNotReadyVideoCount : 0
                 * ifPgc : true
                 */

                private int id;
                private String icon;
                private String name;
                private String description;
                private String link;
                private long latestReleaseTime;
                private int videoNum;
                private Object adTrack;
                private FollowBean follow;
                private ShieldBean shield;
                private int approvedNotReadyVideoCount;
                private boolean ifPgc;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getIcon() {
                    return icon;
                }

                public void setIcon(String icon) {
                    this.icon = icon;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public String getLink() {
                    return link;
                }

                public void setLink(String link) {
                    this.link = link;
                }

                public long getLatestReleaseTime() {
                    return latestReleaseTime;
                }

                public void setLatestReleaseTime(long latestReleaseTime) {
                    this.latestReleaseTime = latestReleaseTime;
                }

                public int getVideoNum() {
                    return videoNum;
                }

                public void setVideoNum(int videoNum) {
                    this.videoNum = videoNum;
                }

                public Object getAdTrack() {
                    return adTrack;
                }

                public void setAdTrack(Object adTrack) {
                    this.adTrack = adTrack;
                }

                public FollowBean getFollow() {
                    return follow;
                }

                public void setFollow(FollowBean follow) {
                    this.follow = follow;
                }

                public ShieldBean getShield() {
                    return shield;
                }

                public void setShield(ShieldBean shield) {
                    this.shield = shield;
                }

                public int getApprovedNotReadyVideoCount() {
                    return approvedNotReadyVideoCount;
                }

                public void setApprovedNotReadyVideoCount(int approvedNotReadyVideoCount) {
                    this.approvedNotReadyVideoCount = approvedNotReadyVideoCount;
                }

                public boolean isIfPgc() {
                    return ifPgc;
                }

                public void setIfPgc(boolean ifPgc) {
                    this.ifPgc = ifPgc;
                }

                public static class FollowBean implements Serializable{
                    /**
                     * itemType : author
                     * itemId : 2763
                     * followed : false
                     */

                    private String itemType;
                    private int itemId;
                    private boolean followed;

                    public String getItemType() {
                        return itemType;
                    }

                    public void setItemType(String itemType) {
                        this.itemType = itemType;
                    }

                    public int getItemId() {
                        return itemId;
                    }

                    public void setItemId(int itemId) {
                        this.itemId = itemId;
                    }

                    public boolean isFollowed() {
                        return followed;
                    }

                    public void setFollowed(boolean followed) {
                        this.followed = followed;
                    }
                }

                public static class ShieldBean implements Serializable{
                    /**
                     * itemType : author
                     * itemId : 2763
                     * shielded : false
                     */

                    private String itemType;
                    private int itemId;
                    private boolean shielded;

                    public String getItemType() {
                        return itemType;
                    }

                    public void setItemType(String itemType) {
                        this.itemType = itemType;
                    }

                    public int getItemId() {
                        return itemId;
                    }

                    public void setItemId(int itemId) {
                        this.itemId = itemId;
                    }

                    public boolean isShielded() {
                        return shielded;
                    }

                    public void setShielded(boolean shielded) {
                        this.shielded = shielded;
                    }
                }
            }

            public static class CoverBean implements Serializable{
                /**
                 * feed : http://img.kaiyanapp.com/99c9f80cee5164044fb6341c939048a4.jpeg?imageMogr2/quality/60/format/jpg
                 * detail : http://img.kaiyanapp.com/99c9f80cee5164044fb6341c939048a4.jpeg?imageMogr2/quality/60/format/jpg
                 * blurred : http://img.kaiyanapp.com/9823647e2a10a4eded8593a4b5271e76.jpeg?imageMogr2/quality/60/format/jpg
                 * sharing : null
                 * homepage : http://img.kaiyanapp.com/99c9f80cee5164044fb6341c939048a4.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim
                 */

                private String feed;
                private String detail;
                private String blurred;
                private Object sharing;
                private String homepage;

                public String getFeed() {
                    return feed;
                }

                public void setFeed(String feed) {
                    this.feed = feed;
                }

                public String getDetail() {
                    return detail;
                }

                public void setDetail(String detail) {
                    this.detail = detail;
                }

                public String getBlurred() {
                    return blurred;
                }

                public void setBlurred(String blurred) {
                    this.blurred = blurred;
                }

                public Object getSharing() {
                    return sharing;
                }

                public void setSharing(Object sharing) {
                    this.sharing = sharing;
                }

                public String getHomepage() {
                    return homepage;
                }

                public void setHomepage(String homepage) {
                    this.homepage = homepage;
                }
            }

            public static class WebUrlBean implements Serializable{
                /**
                 * raw : http://www.eyepetizer.net/detail.html?vid=96737
                 * forWeibo : http://www.eyepetizer.net/detail.html?vid=96737
                 */

                private String raw;
                private String forWeibo;

                public String getRaw() {
                    return raw;
                }

                public void setRaw(String raw) {
                    this.raw = raw;
                }

                public String getForWeibo() {
                    return forWeibo;
                }

                public void setForWeibo(String forWeibo) {
                    this.forWeibo = forWeibo;
                }
            }

            public static class TagsBean implements Serializable{
                /**
                 * id : 777
                 * name : 动画电影
                 * actionUrl : eyepetizer://tag/777/?title=%E5%8A%A8%E7%94%BB%E7%94%B5%E5%BD%B1
                 * adTrack : null
                 * desc : null
                 * bgPicture : http://img.kaiyanapp.com/ce96474453286a52f0e7ed9d16e1eaf4.jpeg?imageMogr2/quality/60/format/jpg
                 * headerImage : http://img.kaiyanapp.com/ce96474453286a52f0e7ed9d16e1eaf4.jpeg?imageMogr2/quality/60/format/jpg
                 * tagRecType : IMPORTANT
                 */

                private int id;
                private String name;
                private String actionUrl;
                private Object adTrack;
                private Object desc;
                private String bgPicture;
                private String headerImage;
                private String tagRecType;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getActionUrl() {
                    return actionUrl;
                }

                public void setActionUrl(String actionUrl) {
                    this.actionUrl = actionUrl;
                }

                public Object getAdTrack() {
                    return adTrack;
                }

                public void setAdTrack(Object adTrack) {
                    this.adTrack = adTrack;
                }

                public Object getDesc() {
                    return desc;
                }

                public void setDesc(Object desc) {
                    this.desc = desc;
                }

                public String getBgPicture() {
                    return bgPicture;
                }

                public void setBgPicture(String bgPicture) {
                    this.bgPicture = bgPicture;
                }

                public String getHeaderImage() {
                    return headerImage;
                }

                public void setHeaderImage(String headerImage) {
                    this.headerImage = headerImage;
                }

                public String getTagRecType() {
                    return tagRecType;
                }

                public void setTagRecType(String tagRecType) {
                    this.tagRecType = tagRecType;
                }
            }

            public static class PlayInfoBean implements Serializable{
                /**
                 * height : 480
                 * width : 854
                 * urlList : [{"name":"aliyun","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=96737&resourceType=video&editionType=normal&source=aliyun","size":646694131},{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=96737&resourceType=video&editionType=normal&source=qcloud","size":646694131},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=96737&resourceType=video&editionType=normal&source=ucloud","size":646694131}]
                 * name : 标清
                 * type : normal
                 * url : http://baobab.kaiyanapp.com/api/v1/playUrl?vid=96737&resourceType=video&editionType=normal&source=aliyun
                 */

                private int height;
                private int width;
                private String name;
                private String type;
                private String url;
                private List<UrlListBean> urlList;

                public int getHeight() {
                    return height;
                }

                public void setHeight(int height) {
                    this.height = height;
                }

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public List<UrlListBean> getUrlList() {
                    return urlList;
                }

                public void setUrlList(List<UrlListBean> urlList) {
                    this.urlList = urlList;
                }

                public static class UrlListBean implements Serializable{
                    /**
                     * name : aliyun
                     * url : http://baobab.kaiyanapp.com/api/v1/playUrl?vid=96737&resourceType=video&editionType=normal&source=aliyun
                     * size : 646694131
                     */

                    private String name;
                    private String url;
                    private int size;

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }

                    public int getSize() {
                        return size;
                    }

                    public void setSize(int size) {
                        this.size = size;
                    }
                }
            }


            public String getDataType() {
                return dataType;
            }

            public void setDataType(String dataType) {
                this.dataType = dataType;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public List<ItemListBean> getItemList() {
                return itemList;
            }

            public void setItemList(List<ItemListBean> itemList) {
                this.itemList = itemList;
            }

            public static class ItemListBean implements Serializable{
                /**
                 * type : banner2
                 * data : {"dataType":"Banner","id":796,"title":"","description":"","image":"http://img.kaiyanapp.com/2ca238dfc04292f5fb41c321ed1eb0b4.jpeg?imageMogr2/quality/60/format/jpg","actionUrl":"eyepetizer://webview/?title=%E7%94%B5%E5%BD%B1%E6%94%BE%E6%98%A0%E5%AE%A4&url=http%3A%2F%2Fwww.eyepetizer.net%2Farticle.html%3Fnid%3D1157%26udid%3D%26uid%3D0%26utm_source%3Ddiscovery","adTrack":null,"shade":false,"label":{"text":"","card":"","detail":null},"labelList":[],"header":{"id":0,"title":null,"font":null,"subTitle":null,"subTitleFont":null,"textAlign":"left","cover":null,"label":null,"actionUrl":null,"labelList":null,"icon":null,"description":null}}
                 * tag : null
                 * id : 0
                 * adIndex : -1
                 */

                private String type;
                private DataBean data;
                private Object tag;
                private int id;
                private int adIndex;

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public DataBean getData() {
                    return data;
                }

                public void setData(DataBean data) {
                    this.data = data;
                }

                public Object getTag() {
                    return tag;
                }

                public void setTag(Object tag) {
                    this.tag = tag;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getAdIndex() {
                    return adIndex;
                }

                public void setAdIndex(int adIndex) {
                    this.adIndex = adIndex;
                }

                public static class DataBean implements Serializable{
                    /**
                     * dataType : Banner
                     * id : 796
                     * title :
                     * description :
                     * image : http://img.kaiyanapp.com/2ca238dfc04292f5fb41c321ed1eb0b4.jpeg?imageMogr2/quality/60/format/jpg
                     * actionUrl : eyepetizer://webview/?title=%E7%94%B5%E5%BD%B1%E6%94%BE%E6%98%A0%E5%AE%A4&url=http%3A%2F%2Fwww.eyepetizer.net%2Farticle.html%3Fnid%3D1157%26udid%3D%26uid%3D0%26utm_source%3Ddiscovery
                     * adTrack : null
                     * shade : false
                     * label : {"text":"","card":"","detail":null}
                     * labelList : []
                     * header : {"id":0,"title":null,"font":null,"subTitle":null,"subTitleFont":null,"textAlign":"left","cover":null,"label":null,"actionUrl":null,"labelList":null,"icon":null,"description":null}
                     */

                    private String dataType;
                    private int id;
                    private String title;
                    private String description;
                    private String image;
                    private String actionUrl;
                    private Object adTrack;
                    private boolean shade;
                    private LabelBean label;
                    private HeaderBean header;
                    private List<?> labelList;

                    public String getDataType() {
                        return dataType;
                    }

                    public void setDataType(String dataType) {
                        this.dataType = dataType;
                    }

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getDescription() {
                        return description;
                    }

                    public void setDescription(String description) {
                        this.description = description;
                    }

                    public String getImage() {
                        return image;
                    }

                    public void setImage(String image) {
                        this.image = image;
                    }

                    public String getActionUrl() {
                        return actionUrl;
                    }

                    public void setActionUrl(String actionUrl) {
                        this.actionUrl = actionUrl;
                    }

                    public Object getAdTrack() {
                        return adTrack;
                    }

                    public void setAdTrack(Object adTrack) {
                        this.adTrack = adTrack;
                    }

                    public boolean isShade() {
                        return shade;
                    }

                    public void setShade(boolean shade) {
                        this.shade = shade;
                    }

                    public LabelBean getLabel() {
                        return label;
                    }

                    public void setLabel(LabelBean label) {
                        this.label = label;
                    }

                    public HeaderBean getHeader() {
                        return header;
                    }

                    public void setHeader(HeaderBean header) {
                        this.header = header;
                    }

                    public List<?> getLabelList() {
                        return labelList;
                    }

                    public void setLabelList(List<?> labelList) {
                        this.labelList = labelList;
                    }

                    public static class LabelBean {
                        /**
                         * text :
                         * card :
                         * detail : null
                         */

                        private String text;
                        private String card;
                        private Object detail;

                        public String getText() {
                            return text;
                        }

                        public void setText(String text) {
                            this.text = text;
                        }

                        public String getCard() {
                            return card;
                        }

                        public void setCard(String card) {
                            this.card = card;
                        }

                        public Object getDetail() {
                            return detail;
                        }

                        public void setDetail(Object detail) {
                            this.detail = detail;
                        }
                    }

                    public static class HeaderBean {
                        /**
                         * id : 0
                         * title : null
                         * font : null
                         * subTitle : null
                         * subTitleFont : null
                         * textAlign : left
                         * cover : null
                         * label : null
                         * actionUrl : null
                         * labelList : null
                         * icon : null
                         * description : null
                         */

                        private int id;
                        private Object title;
                        private Object font;
                        private Object subTitle;
                        private Object subTitleFont;
                        private String textAlign;
                        private Object cover;
                        private Object label;
                        private Object actionUrl;
                        private Object labelList;
                        private Object icon;
                        private Object description;

                        public int getId() {
                            return id;
                        }

                        public void setId(int id) {
                            this.id = id;
                        }

                        public Object getTitle() {
                            return title;
                        }

                        public void setTitle(Object title) {
                            this.title = title;
                        }

                        public Object getFont() {
                            return font;
                        }

                        public void setFont(Object font) {
                            this.font = font;
                        }

                        public Object getSubTitle() {
                            return subTitle;
                        }

                        public void setSubTitle(Object subTitle) {
                            this.subTitle = subTitle;
                        }

                        public Object getSubTitleFont() {
                            return subTitleFont;
                        }

                        public void setSubTitleFont(Object subTitleFont) {
                            this.subTitleFont = subTitleFont;
                        }

                        public String getTextAlign() {
                            return textAlign;
                        }

                        public void setTextAlign(String textAlign) {
                            this.textAlign = textAlign;
                        }

                        public Object getCover() {
                            return cover;
                        }

                        public void setCover(Object cover) {
                            this.cover = cover;
                        }

                        public Object getLabel() {
                            return label;
                        }

                        public void setLabel(Object label) {
                            this.label = label;
                        }

                        public Object getActionUrl() {
                            return actionUrl;
                        }

                        public void setActionUrl(Object actionUrl) {
                            this.actionUrl = actionUrl;
                        }

                        public Object getLabelList() {
                            return labelList;
                        }

                        public void setLabelList(Object labelList) {
                            this.labelList = labelList;
                        }

                        public Object getIcon() {
                            return icon;
                        }

                        public void setIcon(Object icon) {
                            this.icon = icon;
                        }

                        public Object getDescription() {
                            return description;
                        }

                        public void setDescription(Object description) {
                            this.description = description;
                        }
                    }
                }
            }
        }
    }
}
