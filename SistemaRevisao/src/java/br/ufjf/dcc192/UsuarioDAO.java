package br.ufjf.dcc192;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO {
    
    private static Connection conexao;
    private static UsuarioDAO instancia;
    private Statement comando;
    private ResultSet resultado;
    
    public static UsuarioDAO getInstance() {
        if(instancia == null) {
            instancia = new UsuarioDAO();
        }
        return instancia;
    }
    
    public UsuarioDAO() {
        if(conexao == null) {
            try {
                conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/SistemaRevisao", "root", "");
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
