package DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import BO.User;
import Connection.DBConnection;

public class UserDAO {
        public boolean addUser(User user){
        String query = "INSERT INTO tbcliente (cpf,nome,endereco1,endereco2,bairro,cidade,estado,cep,idade,primeira_compra,data_nascimento) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

        DBConnection db = new DBConnection();
        if(db.getConnection()){
            try (PreparedStatement stmt = db.connection.prepareStatement(query)){

                stmt.setLong(1, user.getCpf());
                stmt.setString(2, user.getNome());
                stmt.setString(3, user.getEndereco1());
                stmt.setString(4, user.getEndereco2());
                stmt.setString(5, user.getBairro());
                stmt.setString(6, user.getCidade());
                stmt.setString(7, user.getEstado());
                stmt.setInt(8, user.getCep());
                stmt.setInt(9, user.getIdade());
                stmt.setBoolean(10, false);
                stmt.setString(11, user.getData_nascimento());

                stmt.executeUpdate();
                stmt.close();
                return true;
            }catch (SQLException e){
                JOptionPane.showMessageDialog(null,"Error! Try again."
                        +e.toString());
                return false;
            }
            
        }
        return false;
    }

    public List<User> listUsers(){
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM tbcliente";

        DBConnection db = new DBConnection();
        if(db.getConnection()){
            try (PreparedStatement stmt = db.connection.prepareStatement(query)){

                ResultSet rs = stmt.executeQuery();
                while (rs.next()){
                    User user = new User();
                    user.setCpf(rs.getLong("cpf"));
                    user.setNome(rs.getString("nome"));
                    user.setEndereco1(rs.getString("endereco1"));
                    user.setEndereco2(rs.getString("endereco2"));
                    user.setBairro(rs.getString("bairro"));
                    user.setCidade(rs.getString("cidade"));
                    user.setEstado(rs.getString("estado"));
                    user.setCep(rs.getInt("cep"));
                    user.setIdade(rs.getInt("idade"));
                    user.setPrimeira_compra(rs.getBoolean("primeira_compra"));
                    user.setData_nascimento(rs.getString("data_nascimento"));
                    users.add(user);
                }
            }catch (SQLException e){
                JOptionPane.showMessageDialog(null,"Error! Try again."
                        +e.toString());
                return null;
            }
        }
        return users;
    }

    public boolean updateUser(User user){
        String query = "UPDATE tbcliente SET (nome,endereco1,endereco2,bairro,cidade,estado,cep,idade,primeira_compra,data_nascimento) VALUES (?,?,?,?,?,?,?,?,?,?) WHERE cpf = ?";
        DBConnection db = new DBConnection();
        if(db.getConnection()){
            try(PreparedStatement stmt = db.connection.prepareStatement(query)){
                stmt.setLong(1, user.getCpf());
                stmt.setString(2, user.getNome());
                stmt.setString(3, user.getEndereco1());
                stmt.setString(4, user.getEndereco2());
                stmt.setString(5, user.getBairro());
                stmt.setString(6, user.getCidade());
                stmt.setString(7, user.getEstado());
                stmt.setInt(8, user.getCep());
                stmt.setInt(9, user.getIdade());
                stmt.setBoolean(10, false);
                stmt.setString(11, user.getData_nascimento());
                stmt.executeUpdate();
                db.connection.close();
                return true;
            }catch(SQLException e){
                System.out.println("Error while trying to update state: "+e.getMessage());
            }
        }
        return false;
    }

    public boolean deleteState(int cpf){
        String query = "DELETE FROM tbcliente WHERE cpf = ?";
        DBConnection db = new DBConnection();
        if(db.getConnection()){
            try(PreparedStatement stmt = db.connection.prepareStatement(query)){
                stmt.setLong(1, cpf);
                stmt.executeUpdate();
                db.connection.close();
                stmt.close();
                System.out.println("State deleted successfully! ");
                return true;
            }catch(SQLException e){
                System.out.println("Error while trying to delete state: "+e.getMessage());
            }
        }
        return false;
    }
}
