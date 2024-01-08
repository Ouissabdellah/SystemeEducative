package lst.tpjava.jdbc;
import lst.tpjava.controller.*;

import java.sql.*;
import java.util.ArrayList;
import lst.tpjava.models.Departement;
import lst.tpjava.models.Enseignant;


public class Deprtmt {

    public static void main(String[] args) {

        String dburl = "jdbc:mysql://localhost:3306/getionDepartement";
        String username = "username";
        String password = "passeword";
        try {
            Connection cx = DriverManager.getConnection(dburl, username, password);
            System.out.println("connecte avec succer");
        } catch (SQLException e) {
            System.out.println("une ereur se produisent");
            e.printStackTrace();
        }
    }


public static void createdepartement(Connection cx) throws SQLException {

        String sql="create table IF NOT EXISTS Departement"+"("+
                " id int auto_increment primary key " +
                " intitule varchar(30)" +
                " enseignant chef"+
                ");";
    Statement stmt =cx.createStatement();
    stmt.executeQuery(sql);
    System.out.println("votre tab est cree avec sucee");

}


    public static void insertdepartement( Departement dpt,Connection cx) throws SQLException {
        String sql="INSERT INTO departement (id,intitule,chef) Value(?,?,?)";
        PreparedStatement statement=cx.prepareStatement(sql);
        statement.setInt(1,dpt.getId());
        statement.setString(2,dpt.getIntitule());
        statement.setInt(3,dpt.getChef().getId());
        int rowslnset=statement.executeUpdate();
        if(rowslnset<0){
            System.out.println("une nouvelle departement a ete insere avec succer");
        }
    }

    public static void selectdepartement(Connection cx) throws SQLException {

   String sql ="SELECT*FROM departement";
    ArrayList< Departement>departement=new ArrayList<>();
    Statement stmt =cx.createStatement();
    ResultSet result=stmt.executeQuery(sql);
    while(result.next()){
        Departement dpt =new Departement();
        dpt.setId((result.getInt("id")));
        dpt.setIntitule((result.getString("intitule")));

        Enseignant Chef =new Enseignant();
        Chef.setId((result.getInt("id")));

        departement.add(dpt);
    }
    }

    public static void modufidepartement( Departement dpt, Connection cx) throws SQLException {

String sql="Update departement set intitule=?;  Idchef=? ;where Id= ?";
try(PreparedStatement statement =cx.prepareStatement(sql)){
    statement.setString(1,dpt.getIntitule());
    statement.setInt(2,dpt.getChef().getId());
    statement.setInt(3,dpt.getId());
    statement.executeUpdate();
    System.out.println("departement a ete modifier avec succer");
}
}
    public static void supprimerdepartement( int id, Connection cx) throws SQLException {

     String Sql="delete From departement  where id= ?" ;
        try(PreparedStatement statement =cx.prepareStatement(Sql)){
            statement.setInt(3,id);
            statement.execute();
            System.out.println(" la suppression du departement de id"+id+"fait avec suucee");

        }

    }
}


