package org.springframework.samples;

/**  
* @ClassName: PetStoreServiceImpl  
* @Description: TODO(这里用一句话描述这个类的作用)
* @date 2018年7月13日 下午6:08:24    
*    
*/
public class PetStoreServiceImpl implements PetStoreService{
    private JpaAccountDao accountDao;
    private JpaItemDao itemDao;
    /**
     * @return the accountDao
     */
    public JpaAccountDao getAccountDao() {
        return accountDao;
    }
    /**
     * @param accountDao the accountDao to set
     */
    public void setAccountDao(JpaAccountDao accountDao) {
        this.accountDao = accountDao;
    }
    /**
     * @return the itemDao
     */
    public JpaItemDao getItemDao() {
        return itemDao;
    }
    /**
     * @param itemDao the itemDao to set
     */
    public void setItemDao(JpaItemDao itemDao) {
        this.itemDao = itemDao;
    }
    /**  
    * @Title: PetStoreServiceImpl  
    * @param accountDao
    * @param itemDao    
    */
    public PetStoreServiceImpl(JpaAccountDao accountDao, JpaItemDao itemDao) {
        super();
        this.accountDao = accountDao;
        this.itemDao = itemDao;
    }
    /**  
    * @Title: PetStoreServiceImpl      
    */
    public PetStoreServiceImpl() {
        super();
        // TODO Auto-generated constructor stub
    }
    
}
