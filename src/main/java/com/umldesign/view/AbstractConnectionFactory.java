package com.umldesign.view;
import com.umldesign.common.Relation;

/**
 * Abstract Connection Factory interfaces the connection creation behavior in the class that implements it.
 *
 * @author praveen
 * @version 1.0
 */
public interface AbstractConnectionFactory {

	/**
	 * The getConnection creates and return the connection.
	 *
	 * @param type the type of connection to be created
	 * @param box1 the box reference among which the connection is made.
	 * @param box2 the box reference among which the connection is made.
	 * @return
	 */
	public Connection getConnection(Relation type, Box box1, Box box2);
}
