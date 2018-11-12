package jsr303.jsr349.Java.Bean.Validation;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**  
* @ClassName: Book  
* @Description: TODO(这里用一句话描述这个类的作用)
* @date 2018年7月24日 上午9:04:58    
*    
*/
public class Book {
    private long id;
    @NotEmpty(message="书名不能为空")
    private String bookName;
    @NotNull(message="ISBN不能为空")
    private String BookIsbn;
    @DecimalMin(value="0.1",message="最低价0.1")
    private double price;
    /**
     * @return the id
     */
    public long getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }
    /**
     * @return the bookName
     */
    public String getBookName() {
        return bookName;
    }
    /**
     * @param bookName the bookName to set
     */
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    /**
     * @return the bookIsbn
     */
    public String getBookIsbn() {
        return BookIsbn;
    }
    /**
     * @param bookIsbn the bookIsbn to set
     */
    public void setBookIsbn(String bookIsbn) {
        BookIsbn = bookIsbn;
    }
    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }
    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }
    
}
