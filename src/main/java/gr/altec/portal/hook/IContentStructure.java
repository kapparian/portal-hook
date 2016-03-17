/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.altec.portal.hook;

/**
 *
 * @author bats-pc
 */
public interface IContentStructure {
    /**
     *
     * The XML Content Structure of each Structure of Liferay Web Contnent
     * @return 
     */
    public  String generateContentStructure();
    
    /**
     * 
     * @return 
     * Populates a content Structure with CDATA stuff for each 
     */
    public String populateContentStructure();
}
