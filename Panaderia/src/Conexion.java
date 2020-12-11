import java.sql.*;

public class Conexion {
    private String bd ="bdpanaderia";
    private String url ="jdbc:mysql://localhost:3306/"+bd;
    private String user ="root";
    private String pass ="123456";
    private String msg;
    private Connection con;
    private Statement st;
        
    public Conexion(){
        msg=null;
        con=null;
            
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url,user,pass);
            st=con.createStatement();
            msg="Conexcion exitosa";
                
                
        }catch(Exception ex){
            msg="Ha ocurrido un error en la conexcion:  "+ ex.getMessage();
        }
    }
        
    public String getMessage(){
        return msg;
    }
        
    public void query(String SQL){ // INSERT, UPDATE, DELETE
        try{
            st.executeUpdate(SQL);
            msg="operacion realizada correctamente";
        }catch(Exception ex){
            msg="Ha ocurrido un error, operacion cancelada";
        }
    }
    
    public ResultSet listar(String SQL){
        try{
            ResultSet lista = st.executeQuery(SQL);
            msg="operacion realizada correctamente";
            return lista;
        }catch(Exception ex){
            msg="Ha ocurrido un error, operacion cancelada";
            return null;
        }
    }
        
    public boolean close(){
        try{
            con.close();
            msg="Desconectado de la BD";
            return true;
        }catch(Exception ex){
            msg="No se puede desconectar de la BD:  "+ ex.getMessage();
            return false;
        }
    }
}