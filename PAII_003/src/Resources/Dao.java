/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Resources;
import java.sql.Connection;
import java.util.List;
import java.sql.SQLException;

/**
 *
 * @author USUARIO
 */
public interface Dao {
    
    public void create(Connection c,Object o) throws SQLException ;
        public void update(Connection c,Object o)throws SQLException;
            public void delete(Connection c,int id)throws SQLException;
                public void createTable(Connection c)throws SQLException;
                     <T> List<T> getAll(Connection c) throws SQLException;
                       <T> T read(Connection c, int id) throws SQLException;
}
    

