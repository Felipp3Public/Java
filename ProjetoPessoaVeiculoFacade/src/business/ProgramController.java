package business;

import exceptions.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

public class ProgramController {

    GestorPessoas gestorPessoas;
    GestorVeiculos gestorVeiculos;

    public ProgramController() throws SQLException, IOException {
        gestorPessoas = new GestorPessoas();
        gestorVeiculos = new GestorVeiculos();
    }



    // Pessoas

    public void adicionarPessoa(Pessoa pessoa) throws SQLException, MoreThanThreeVehiclesException {
        gestorPessoas.adicionarPessoa(pessoa);
        gestorPessoas = new GestorPessoas();
    }

    public void removerPessoa(String nif) throws EmptyHashtableException, PersonNotFoundException, SQLException {
        gestorVeiculos.removerVeiculosPessoa(nif);
        gestorVeiculos = new GestorVeiculos();
        gestorPessoas.removerPessoa(nif);
        gestorPessoas = new GestorPessoas();
    }

    public Pessoa getPessoa(String nif) throws EmptyHashtableException, PersonNotFoundException {
        return gestorPessoas.getPessoa(nif);
    }

    public Collection<Pessoa> getPessoas() throws EmptyHashtableException {
        return gestorPessoas.getPessoas();
    }



    // Veiculos

    public void adicionarVeiculoCombustao(String nif, String matricula, String marca, String modelo, String chassi, int cilindrada, String lugares, String portas)
            throws MoreThanThreeVehiclesException, SQLException {
        gestorVeiculos.adicionarVeiculoCombustao(nif, matricula, marca, modelo, chassi, cilindrada, lugares, portas);
        gestorPessoas = new GestorPessoas();
        gestorVeiculos = new GestorVeiculos();
    }

    public void adicionarVeiculoEletrico(String nif, String matricula, String marca, String modelo, String chassi, String lugares, String portas)
            throws MoreThanThreeVehiclesException, SQLException {
        gestorVeiculos.adicionarVeiculoEletrico(nif, matricula, marca, modelo, chassi, lugares, portas);
        gestorPessoas = new GestorPessoas();
        gestorVeiculos = new GestorVeiculos();
    }

    public void removerVeiculo(String matricula)
            throws EmptyHashtableException, VehicleNotFoundException, SQLException {
        gestorVeiculos.removerVeiculo(matricula);
        gestorVeiculos = new GestorVeiculos();
        gestorPessoas = new GestorPessoas();
    }

    public Veiculo getVeiculo(String matricula) throws EmptyHashtableException, VehicleNotFoundException {
        return gestorVeiculos.getVeiculo(matricula);
    }

    public Collection<Veiculo> getVeiculos() throws EmptyHashtableException {
        return gestorVeiculos.getVeiculos();
    }
}
