package DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import BO.State;
import Connection.DBConnection;

public class StateDAO {
    public boolean addState(State state){
        String query = "INSERT INTO tbestado (siga,descricao) VALUES (?,?)";

        DBConnection db = new DBConnection();
        if(db.getConnection()){
            try (PreparedStatement stmt = db.connection.prepareStatement(query)){

                stmt.setString(1, state.getSigla());
                stmt.setString(2, state.getDescricao());
                
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

    public List<State> listStates(){
        List<State> states = new ArrayList<>();
        String query = "SELECT * FROM tbestado";

        DBConnection db = new DBConnection();
        if(db.getConnection()){
            try (PreparedStatement stmt = db.connection.prepareStatement(query)){

                ResultSet rs = stmt.executeQuery();
                while (rs.next()){
                    State state = new State();
                    state.setSigla(rs.getString("siga"));
                    state.setDescricao(rs.getString("descricao"));
                    states.add(state);
                }
            }catch (SQLException e){
                JOptionPane.showMessageDialog(null,"Error! Try again."
                        +e.toString());
                return null;
            }
        }
        return states;
    }

    public boolean updateState(State state){
        String query = "UPDATE tbestado SET descricao = ? WHERE siga = ?";
        DBConnection db = new DBConnection();
        if(db.getConnection()){
            try(PreparedStatement stmt = db.connection.prepareStatement(query)){
                stmt.setString(1, state.getDescricao());
                stmt.setString(2, state.getSigla());
                stmt.executeUpdate();
                db.connection.close();
                return true;
            }catch(SQLException e){
                System.out.println("Error while trying to update state: "+e.getMessage());
            }
        }
        return false;
    }

    public boolean deleteState(String sigla){
        String query = "DELETE FROM tbestado WHERE siga = ?";
        DBConnection db = new DBConnection();
        if(db.getConnection()){
            try(PreparedStatement stmt = db.connection.prepareStatement(query)){
                stmt.setString(1, sigla);
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
