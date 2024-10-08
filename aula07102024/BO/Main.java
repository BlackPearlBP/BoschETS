package BO;

import DAO.UserDAO;

public class Main {
    public static void main(String[] args) {
        System.out.println("Olá Mundo!");

        //StateDAO dao = new StateDAO();
        /* add new state
        State newState = new State();
        newState.setSigla("SP");
        newState.setDescricao("São Paulo");
        dao.addState(newState); */

        /* //add user
        UserDAO dao = new UserDAO();
        User newUser = new User();
        newUser.setNome("Teste");
        newUser.setCpf(12345678911l);
        newUser.setEndereco1("Rua dos Testes");
        newUser.setEndereco2("Rua dos Testasdores");
        newUser.setBairro("Testante");
        newUser.setCidade("Testeville");
        newUser.setEstado("SC");
        newUser.setCep(98755001);
        newUser.setIdade(54);
        newUser.setPrimeira_compra(false);
        newUser.setData_nascimento("2000-01-01");
        dao.addUser(newUser); */

        /* for(State state : dao.listStates()){
            System.out.println(state.getSigla()+" - "+state.getDescricao());

            //String result = String.format(state.getSigla(), state.getDescricao());
        } */
        /* DBConnection db = new DBConnection();
        if (db.getConnection()) {
            try {
                System.out.println("Connected");
                db.connection.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error! Try again."
                        + e.toString());
            }

        } */
       //update state
       /* State newState = new State();
       newState.setSigla("SP");
       newState.setDescricao("São Paulo 2");
       dao.updateState(newState); */

       //delete state
       //dao.deleteState("SP");
    }
}
