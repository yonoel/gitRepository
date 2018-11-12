package com.igeek.DTO;

import com.igeek.domain.Testpaper;

/**
 * @ClassName: TestpaperDTO
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年8月9日 上午7:27:45
 * 
 */
public class TestpaperDTO extends Testpaper {
    private String dtoscore;

    /**
     * @param dtoscore
     *            the dtoscore to set
     */
    public void setDtoscore() {

        if (this.getScore() == null) {
            this.dtoscore = "0";
        } else {
            this.dtoscore = Integer.toString(this.getScore());
        }

    }

    /**
     * @return the dtoscore
     */
    public String getDtoscore() {
        return dtoscore;
    }

}
