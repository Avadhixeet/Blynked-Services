
package com.scolere.blynked.persistance.dao.iface;


/**
 *
 * @author admin
 */
public interface BlynkDao {

	public String getById(int userId);
	public String getAll();
	public String save();
	public String updatById(int userId);

}
