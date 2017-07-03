/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package DBConnection;

/**
 *
 * @author burcak
 */
public class RunCRUD {
    public static void main(String[] args) {
        DBOperations crud = new DBOperations();
        
        crud.insertData();
        
        crud.selectData();
        
        crud.updateData();
        
        crud.selectData();
        
        crud.deleteData();
    }
}
