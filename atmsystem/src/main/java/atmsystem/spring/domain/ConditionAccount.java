package atmsystem.spring.domain;

import java.util.Date;

/**
 * @ClassName: ConditionAccount
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月11日 下午7:30:59
 * 
 */
public class ConditionAccount extends Account {
    private double draw;
    private double save;

    /**
     * @Title: ConditionAccount
     * @param name
     * @param id
     * @param password
     * @param cash
     * @param birthday
     */
    public ConditionAccount(String name, Integer id, Integer password, double cash, Date birthday) {
        super(name, id, password, cash, birthday);
    }

    /**
     * @return the draw
     */
    public double getDraw() {
        return draw;
    }

    /**
     * @param draw
     *            the draw to set
     */
    public void setDraw(double draw) {
        this.draw = draw;
    }

    /**
     * @return the save
     */
    public double getSave() {
        return save;
    }

    /**
     * @param save
     *            the save to set
     */
    public void setSave(double save) {
        this.save = save;
    }

    /**
     * @Title: ConditionAccount
     */
    public ConditionAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

}
