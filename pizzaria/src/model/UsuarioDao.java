package model;

import java.sql.*;

import error.MessageError;

public class UsuarioDao {

	public void inserirUsuario(UsuarioBean usuario) throws Exception{
		Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("insert into TB_Cliente(nome,sobrenome,celular,email,senha) values(?, ?, ?, ?, ?)");            
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getSobrenome());              
            ps.setString(3, usuario.getCelular());
            ps.setString(4, usuario.getEmail());
            ps.setString(5, usuario.getSenha());
            
            ps.executeUpdate();        
        }
        catch(SQLException e) {
        	String messageError = MessageError.get(e);
        	throw new SQLException(messageError);        
        } finally {
        	con.close();
        }
	}
}

