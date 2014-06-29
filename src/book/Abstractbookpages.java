// default package
package book;


/**
 * Abstractbookpages entity provides the base persistence definition of the bookpages entity. @author MyEclipse Persistence Tools
 */

public abstract class Abstractbookpages extends com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource implements java.io.Serializable {


    // Fields    

     private Integer bookId;
     private String name;
     private Integer websiteId;
     private String suburl;


    // Constructors

    /** default constructor */
    public Abstractbookpages() {
    }

	/** minimal constructor */
    public Abstractbookpages(Integer bookId) {
        this.bookId = bookId;
    }
    
    /** full constructor */
    public Abstractbookpages(Integer bookId, String name, Integer websiteId, String suburl) {
        this.bookId = bookId;
        this.name = name;
        this.websiteId = websiteId;
        this.suburl = suburl;
    }

   
    // Property accessors

    public Integer getBookId() {
        return this.bookId;
    }
    
    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Integer getWebsiteId() {
        return this.websiteId;
    }
    
    public void setWebsiteId(Integer websiteId) {
        this.websiteId = websiteId;
    }

    public String getSuburl() {
        return this.suburl;
    }
    
    public void setSuburl(String suburl) {
        this.suburl = suburl;
    }
   








}