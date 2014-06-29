// default package

package book;

/**
 * bookpages entity. @author MyEclipse Persistence Tools
 */
public class bookpages extends Abstractbookpages implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public bookpages() {
    }

	/** minimal constructor */
    public bookpages(Integer bookId) {
        super(bookId);        
    }
    
    /** full constructor */
    public bookpages(Integer bookId, String name, Integer websiteId, String suburl) {
        super(bookId, name, websiteId, suburl);        
    }
   
}
