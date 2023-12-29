package com.umldesign.view;
import com.umldesign.common.Relation;

/**
 * UMLConnection Factory helps create the connection based on the user specified type.
 *
 * @author praveen
 * @version 1.0
 */
public class UMLConnectionFactory implements AbstractConnectionFactory {

    /**
     * This method creates the connection object.
     *
     * @param type the type of connection to be created
     * @param box1 the box reference among which the connection is made.
     * @param box2 the box reference among which the connection is made.
     * @return reference to the connection object created.
     */
	@Override
	public Connection getConnection(Relation type, Box box1, Box box2) {
        ConnectionDecorator connectionDecorator = null;
        switch (type) {
            case ASSOCIATION:
                connectionDecorator = new AssociationDecorator(box1, box2);
                break;
            case COMPOSITION:
                connectionDecorator = new CompositionDecorator(box1, box2);
                break;
            case INHERITENCE:
                connectionDecorator = new InheritanceDecorator(box1, box2);
                break;
        }
        
        LineConnection lineConnection = new LineConnection(box1, box2);
        connectionDecorator.setComponent(lineConnection);
        return connectionDecorator;
	}
	
}
