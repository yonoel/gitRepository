package javabean;

import java.util.Date;

/**
 * @ClassName: Emp
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月18日 上午11:02:02
 * 
 */
public class Emp {
    private Integer id;
    private String name;
    private String job;
    private Integer mgr;
    private Date hireDate;
    private double sal;
    private double comm;
    private Integer deptNo;
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the job
     */
    public String getJob() {
        return job;
    }
    /**
     * @param job the job to set
     */
    public void setJob(String job) {
        this.job = job;
    }
    /**
     * @return the mgr
     */
    public Integer getMgr() {
        return mgr;
    }
    /**
     * @param mgr the mgr to set
     */
    public void setMgr(Integer mgr) {
        this.mgr = mgr;
    }
    /**
     * @return the hireDate
     */
    public Date getHireDate() {
        return hireDate;
    }
    /**
     * @param hireDate the hireDate to set
     */
    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }
    /**
     * @return the sal
     */
    public double getSal() {
        return sal;
    }
    /**
     * @param sal the sal to set
     */
    public void setSal(double sal) {
        this.sal = sal;
    }
    /**
     * @return the comm
     */
    public double getComm() {
        return comm;
    }
    /**
     * @param comm the comm to set
     */
    public void setComm(double comm) {
        this.comm = comm;
    }
    /**
     * @return the deptNo
     */
    public Integer getDeptNo() {
        return deptNo;
    }
    /**
     * @param deptNo the deptNo to set
     */
    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }
    /**  
    * @Title: Emp  
    * @param id
    * @param name
    * @param job
    * @param mgr
    * @param hireDate
    * @param sal
    * @param comm
    * @param deptNo    
    */
    public Emp(Integer id, String name, String job, Integer mgr, Date hireDate, double sal, double comm,
            Integer deptNo) {
        super();
        this.id = id;
        this.name = name;
        this.job = job;
        this.mgr = mgr;
        this.hireDate = hireDate;
        this.sal = sal;
        this.comm = comm;
        this.deptNo = deptNo;
    }
    /**  
    * @Title: Emp      
    */
    public Emp() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**  
    * @Title: toString  
    * @Description: TODO(这里用一句话描述这个方法的作用)  
    * @return
    * @see java.lang.Object#toString()
    */
    @Override
    public String toString() {
        return "Emp [id=" + id + ", name=" + name + ", job=" + job + ", mgr=" + mgr + ", hireDate=" + hireDate
                + ", sal=" + sal + ", comm=" + comm + ", deptNo=" + deptNo + "]";
    }
    
}
