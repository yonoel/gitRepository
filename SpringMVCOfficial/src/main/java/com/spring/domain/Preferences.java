package com.spring.domain;

import java.util.List;

/**
 * @ClassName: Preferences
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月10日 下午3:21:24
 * 
 */
public class Preferences {
    private List<String> likes;
    private boolean receiveNewsletter;
    private String[] selectInterests;
    private String[] interests;
    /**
     * @return the selectInterests
     */
    public String[] getSelectInterests() {
        return selectInterests;
    }

    /**
     * @param selectInterests the selectInterests to set
     */
    public void setSelectInterests(String[] selectInterests) {
        this.selectInterests = selectInterests;
    }

    private String favouriteWord;

    public boolean isReceiveNewsletter() {
        return receiveNewsletter;
    }

    public void setReceiveNewsletter(boolean receiveNewsletter) {
        this.receiveNewsletter = receiveNewsletter;
    }

    public String[] getInterests() {
        return interests;
    }

    public void setInterests(String[] interests) {
        this.interests = interests;
    }

    public String getFavouriteWord() {
        return favouriteWord;
    }

    public void setFavouriteWord(String favouriteWord) {
        this.favouriteWord = favouriteWord;
    }

    /**
     * @return the likes
     */
    public List<String> getLikes() {
        return likes;
    }

    /**
     * @param likes
     *            the likes to set
     */
    public void setLikes(List<String> likes) {
        this.likes = likes;
    }
}
