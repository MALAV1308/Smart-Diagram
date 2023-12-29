package com.umldesign.model;
/**
 * The UniqueIdGenerator class is responsible for generating unique id used for assigning to the Nodes.
 *
 * @author harishkumarsrinivasappa
 * @version 1.0
 */
public class UniqueIdGenerator {
    public static UniqueIdGenerator uniqueIdCreator;
    private int uId = 0;
    /**
     * The UniqueIdGenerator constructor is a private restricting outside classes from creating objects of it.
     */
    private UniqueIdGenerator(){}
    /**
     * The getInstance method is to get an instance of the uniqueIdGenerator.
     *
     * @return instance of the uniqueIdGenerator.
     */
    public static UniqueIdGenerator getInstance(){
        if(uniqueIdCreator == null)
            uniqueIdCreator = new UniqueIdGenerator();
        return uniqueIdCreator;
    }
    /**
     * The getId method returns an uniqueId on call.
     *
     * @return uniqueId is returned.
     */
    public int getId(){
        return ++uId;
    }
}
