package dao;

import Entity.Animal;
import Entity.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Ederley Carvalho
 */
public class AnimalDAO {

    Connection conecta = null;
    ResultSet rs = null;
    PreparedStatement sttm = null;
    public static ResultSet rsST;

    public void salvar(Animal animal) {

        animal.setIdAnimal(animal.getIdAnimal());
        try {
            conecta = DAO.ConnectionManager.getConnection();
            
            String SQL_INSERT = "insert into animal(idcliente, nome, raca, genero, tipo, observacao) values (?,?,?,?,?,?)";
            String SQL_UPDATE = "update animal set idcliente = ?, nome = ?, raca = ?, genero = ?, tipo = ?, observacao = ?  where idanimal = ?";

            if (animal.getIdAnimal() == null || animal.getIdAnimal() == 0) {
                sttm = conecta.prepareStatement(SQL_INSERT);

                sttm.setInt(1, animal.getIdCliente());
                sttm.setString(2, animal.getNome());
                sttm.setString(3, animal.getRaca());
                sttm.setString(4, animal.getGenero());
                sttm.setString(5, animal.getTipo());
                sttm.setString(6, animal.getObservacoes());

                JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            } else {
                sttm = conecta.prepareStatement(SQL_UPDATE);

                sttm.setInt(1, animal.getIdCliente());
                sttm.setString(2, animal.getNome());
                sttm.setString(3, animal.getRaca());
                sttm.setString(4, animal.getGenero());
                sttm.setString(5, animal.getTipo());
                sttm.setString(6, animal.getObservacoes());

                sttm.setInt(7, animal.getIdAnimal());
                JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            }
            sttm.executeUpdate();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex + " erro ao gravar no banco de dados!");
        }

    }

    public ArrayList<Animal> listar() {

        ArrayList<Animal> lista = new ArrayList();

        try {
            String QUERY_DETALHE = "select idanimal, idcliente, nome, raca, genero, tipo, observacao from animal order by nome ASC";

            conecta = DAO.ConnectionManager.getConnection();

            ResultSet rs = null;

            sttm = conecta.prepareStatement(QUERY_DETALHE);
            
            rs = sttm.executeQuery();

            while (rs.next()) {
                Animal animal = new Animal();
                animal.setIdAnimal(rs.getInt("idanimal"));
                animal.setIdCliente(rs.getInt("idcliente"));
                animal.setNome(rs.getString("nome"));
                animal.setRaca(rs.getString("raca"));
                animal.setGenero(rs.getString("genero"));
                animal.setTipo(rs.getString("tipo"));
                animal.setObservacoes(rs.getString("observacao"));
                lista.add(animal);
                System.out.println(animal.getNome());
            }
            //conecta.close();

        } catch (Exception ex) {
            
            JOptionPane.showMessageDialog(null, "erro ao listar!");
        }
        return lista;
    }
    
    public ArrayList<Animal> listarById(Cliente cliente) {

        ArrayList<Animal> lista = new ArrayList();

        try {
            String QUERY_DETALHE = "select idanimal, idcliente, nome, raca, genero, tipo, observacao from animal where idCliente = ?";

            conecta = DAO.ConnectionManager.getConnection();

            ResultSet rs = null;

            sttm = conecta.prepareStatement(QUERY_DETALHE);
            sttm.setInt(1, cliente.getIdCliente());
            System.out.println(cliente.getIdCliente());
            rs = sttm.executeQuery();

            while (rs.next()) {
                Animal animal = new Animal();
                animal.setIdAnimal(rs.getInt("idanimal"));
                animal.setIdCliente(rs.getInt("idcliente"));
                animal.setNome(rs.getString("nome"));
                animal.setRaca(rs.getString("raca"));
                animal.setGenero(rs.getString("genero"));
                animal.setTipo(rs.getString("tipo"));
                animal.setObservacoes(rs.getString("observacao"));
                lista.add(animal);
                System.out.println(animal.getNome());
            }
            //conecta.close();

        } catch (Exception ex) {
            
            JOptionPane.showMessageDialog(null, "erro ao listar!");
        }
        return lista;
    }
//
//    public void deletar(Usuarios usuarios) {
//
//        try {
//            conecta = ConnectionManager.getConnection();
//            String QUERY_DELETE = "delete from usuarios where idusuarios = ?";
//
//            sttm = conecta.prepareStatement(QUERY_DELETE);
//            sttm.setInt(1, usuarios.getIdUsuarios());
//
//            sttm.execute();
//            //conn.close();
//
//            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
//
//        } catch (Exception ex) {
//
//            JOptionPane.showMessageDialog(null, "erro ao excluir!");
//            JOptionPane.showMessageDialog(null, ex);
//        }
//
//    }
//
//    public Usuarios detalhe(Usuarios usuario) {
//
//        Usuarios retorno = null;
//
//        try {
//            conecta = ConnectionManager.getConnection();
//
//            String QUERY_DETALHE = "SELECT nome, senha, email from usuarios where idusuarios = ?";
//
//            sttm = conecta.prepareStatement(QUERY_DETALHE);
//            sttm.setInt(1, usuario.getIdUsuarios());
//
//            rs = sttm.executeQuery();
//
//            while (rs.next()) {
//
//                retorno = new Usuarios();
//
//                retorno.setNomeUsuarios(rs.getString("nome"));
//                retorno.setSenhaUsuarios(rs.getString("senha"));
//                retorno.setEmailUsuarios(rs.getString("email"));
//
//            }
//
//            //conecta.close();
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(null, "erro ao consultar banco de dados!");
//        } finally {
//            return retorno;
//        }
//
//    }
//
//    public void pesquisarUsuarios(Usuarios usuario) {
//
//        conecta = ConnectionManager.getConnection();
//        String sql = "select idusuarios, nome, email, perfil from usuarios where nome LIKE '%' ? '%'";
//        try {
//            sttm = conecta.prepareStatement(sql);
//            sttm.setString(1, usuario.getNomeUsuarios());
//            rsST = sttm.executeQuery();
//
//        } catch (SQLException error) {
//            JOptionPane.showMessageDialog(null, error);
//        }
//
//    }
//
//    public static TableModel setaResultadojTabela(ResultSet rs) {
//        try {
//            ResultSetMetaData metaData = rs.getMetaData();
//            int numberOfColumns = metaData.getColumnCount();
//            Vector columnNames = new Vector();
//
//            // Obter os nomes de coluna
//            for (int column = 0; column < numberOfColumns; column++) {
//                columnNames.addElement(metaData.getColumnLabel(column + 1));
//            }
//
//            // Obter todas as linhas.
//            Vector rows = new Vector();
//
//            while (rs.next()) {
//                Vector newRow = new Vector();
//
//                for (int i = 1; i <= numberOfColumns; i++) {
//                    newRow.addElement(rs.getObject(i));
//                }
//
//                rows.addElement(newRow);
//            }
//
//            return new DefaultTableModel(rows, columnNames);
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "erro ao carregar tabela!");
//            JOptionPane.showMessageDialog(null, e);
//            return null;
//        }
//    }

}
