// default package
package book;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * bookpages entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see .bookpages
 * @author MyEclipse Persistence Tools
 */
public class bookpagesDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(bookpagesDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String WEBSITE_ID = "websiteId";
	public static final String SUBURL = "suburl";

	public void save(bookpages transientInstance) {
		log.debug("saving bookpages instance");
		try {
			Transaction tx = getSession().beginTransaction();
			getSession().save(transientInstance);
			tx.commit();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(bookpages persistentInstance) {
		log.debug("deleting bookpages instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public bookpages findById(java.lang.Integer id) {
		log.debug("getting bookpages instance with id: " + id);
		try {
			bookpages instance = (bookpages) getSession().get("bookpages", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(bookpages instance) {
		log.debug("finding bookpages instance by example");
		try {
			List results = getSession().createCriteria("bookpages")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding bookpages instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from bookpages as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByWebsiteId(Object websiteId) {
		return findByProperty(WEBSITE_ID, websiteId);
	}

	public List findBySuburl(Object suburl) {
		return findByProperty(SUBURL, suburl);
	}

	public List findAll() {
		log.debug("finding all bookpages instances");
		try {
			String queryString = "from bookpages";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public bookpages merge(bookpages detachedInstance) {
		log.debug("merging bookpages instance");
		try {
			bookpages result = (bookpages) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(bookpages instance) {
		log.debug("attaching dirty bookpages instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(bookpages instance) {
		log.debug("attaching clean bookpages instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}