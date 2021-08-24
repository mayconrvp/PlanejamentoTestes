package br.ufes.projetos01;

import br.ufes.calculodebonus.ProcessadoraBonus;
import br.ufes.model.Funcionario;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 *
 * Link da planilha original:
 * https://docs.google.com/spreadsheets/d/1kWf0JLfYjsdoAxqHmqO5hAxkCbFEoIhgqFXptL6J7y4/edit?usp=sharing
 * Link da planilha de correção:
 * https://docs.google.com/spreadsheets/d/1F413YpukWVL8QXu7qoo5YyijwCCshomAhUacHehVPl4/edit?usp=sharing
 *
 */
public class FuncionarioBonusTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void CT001() throws Exception {
        //Arrange
        String nome = "Fulano";
        double salarioBase = 2500;
        String cargo = "Gerente Financeiro";
        Funcionario funcionario = new Funcionario(nome, salarioBase, cargo);
        double salarioEsperado = 2600.00;

        //Act
        ProcessadoraBonus pb = new ProcessadoraBonus();
        pb.processar(funcionario);

        //Assert
        assertEquals(nome, funcionario.getNome());
        assertEquals(salarioBase, funcionario.getSalarioBase(), 0.001);
        assertEquals(cargo, funcionario.getCargo());
        assertNull(funcionario.getFaltas());
        assertNull(funcionario.getDistanciaMoradia());
        assertEquals(cargo, funcionario.getCargo());
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }

    @Test
    public void CT002() throws Exception {
        //Arrange
        Funcionario funcionario = new Funcionario("Fulano", 2500.00, "Gerente Adminstrativo");
        funcionario.setDistanciaMoradia(101);
        double salarioEsperado = 2900.00;

        //Act
        ProcessadoraBonus pb = new ProcessadoraBonus();
        pb.processar(funcionario);

        //Assert
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }

    @Test
    public void CT003() throws Exception {
        //Arrange
        Funcionario funcionario = new Funcionario("Fulano", 2500.00, "Gerente");
        funcionario.setDistanciaMoradia(151);
        double salarioEsperado = 3100.00;

        //Act
        ProcessadoraBonus pb = new ProcessadoraBonus();
        pb.processar(funcionario);

        //Assert
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }

    @Test
    public void CT004() throws Exception {
        //Arrange
        Funcionario funcionario = new Funcionario("Fulano", 2500.00, "Gerente");
        funcionario.setDistanciaMoradia(51);
        double salarioEsperado = 2750.00;

        //Act
        ProcessadoraBonus pb = new ProcessadoraBonus();
        pb.processar(funcionario);

        //Assert
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }

    @Test
    public void CT005() throws Exception {
        //Arrange
        Funcionario funcionario = new Funcionario("Fulano", 2500.00, "Gerente");
        funcionario.setDistanciaMoradia(50);
        double salarioEsperado = 2600.00;

        //Act
        ProcessadoraBonus pb = new ProcessadoraBonus();
        pb.processar(funcionario);

        //Assert
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }

    @Test
    public void CT006() throws Exception {
        //expect
        thrown.expect(Exception.class);
        thrown.expectMessage("\n#3 O salário base deve ser >= R$ 998,00");

        //Arrange
        String nome = "João";
        String cargo = "Surpevisor Financeiro";
        double salarioBase = 997.00;

        //Act
        new Funcionario(nome, salarioBase, cargo);
    }

    @Test
    public void CT007() throws Exception {
        //expect
        thrown.expect(Exception.class);
        thrown.expectMessage("\n#1 Informe um nome válido");

        //Arrange
        String nome = "";
        String cargo = "Surpevisor Operacional";
        double salarioBase = 2000.00;

        //Act
        new Funcionario(nome, salarioBase, cargo);
    }

    @Test
    public void CT008() throws Exception {
        //expect
        thrown.expect(Exception.class);
        thrown.expectMessage("\n#1 Informe um nome válido");

        //Arrange
        String nome = null;
        String cargo = "Surpevisor Adminstrativo";
        double salarioBase = 2000.00;

        //Act
        new Funcionario(nome, salarioBase, cargo);
    }

    @Test
    public void CT009() throws Exception {
        //expect
        thrown.expect(Exception.class);
        thrown.expectMessage("\n#2 Informe um cargo válido");

        //Arrange
        String nome = "João";
        String cargo = "";
        double salarioBase = 2000.00;

        //Act
        new Funcionario(nome, salarioBase, cargo);
    }

    @Test
    public void CT010() throws Exception {
        //expect
        thrown.expect(Exception.class);
        thrown.expectMessage("\n#2 Informe um cargo válido");

        //Arrange
        String nome = "João";
        String cargo = null;
        double salarioBase = 2000.00;

        //Act
        new Funcionario(nome, salarioBase, cargo);
    }

    @Test
    public void CT011() throws Exception {
        //expect
        thrown.expect(Exception.class);
        thrown.expectMessage("\n#1 Informe um nome válido\n#2 Informe um cargo válido\n#3 O salário base deve ser >= R$ 998,00");

        //Arrange
        String nome = null;
        String cargo = null;
        double salarioBase = 800;

        //Act
        new Funcionario(nome, salarioBase, cargo);
    }

    @Test
    public void CT012() throws Exception {
        //Arrange
        String nome = "João";
        String cargo = "Supervisor Financeiro";
        double salarioBase = 2000.00;
        double salarioEsperado = 2180.00;
        Funcionario funcionario = new Funcionario(nome, salarioBase, cargo);
        funcionario.setFaltas(0);

        //Act
        ProcessadoraBonus pb = new ProcessadoraBonus();
        pb.processar(funcionario);

        //Assert
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }

    @Test
    public void CT013() throws Exception {
        //Arrange
        String nome = "João";
        String cargo = "Supervisor Operacional";
        double salarioBase = 2000.00;
        double salarioEsperado = 2120.00;
        Funcionario funcionario = new Funcionario(nome, salarioBase, cargo);
        funcionario.setFaltas(5);

        //Act
        ProcessadoraBonus pb = new ProcessadoraBonus();
        pb.processar(funcionario);

        //Assert
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }

    @Test
    public void CT014() throws Exception {
        //Arrange
        String nome = "João";
        String cargo = "Supervisor Adminstrativo";
        double salarioBase = 2000.00;
        double salarioEsperado = 2100.00;
        Funcionario funcionario = new Funcionario(nome, salarioBase, cargo);
        funcionario.setFaltas(10);

        //Act
        ProcessadoraBonus pb = new ProcessadoraBonus();
        pb.processar(funcionario);

        //Assert
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }

    @Test
    public void CT015() throws Exception {
        //Arrange
        String nome = "João";
        String cargo = "Supervisor";
        double salarioBase = 2000.00;
        double salarioEsperado = 2080.00;
        Funcionario funcionario = new Funcionario(nome, salarioBase, cargo);
        funcionario.setFaltas(11);
        funcionario.setDistanciaMoradia(0);

        //Act
        ProcessadoraBonus pb = new ProcessadoraBonus();
        pb.processar(funcionario);

        //Assert
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }

    @Test
    public void CT016() throws Exception {
        //Arrange
        String nome = "João";
        String cargo = "Datilógrafo";
        double salarioBase = 2000.00;
        double salarioEsperado = 2000.00;
        Funcionario funcionario = new Funcionario(nome, salarioBase, cargo);

        //Act
        ProcessadoraBonus pb = new ProcessadoraBonus();
        pb.processar(funcionario);

        //Assert
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }

    @Test
    public void CT017() throws Exception {
        //Arrange
        String nome = "João";
        String cargo = "Programador front-end";
        double salarioBase = 2000.00;
        double salarioEsperado = 2240.00;
        Funcionario funcionario = new Funcionario(nome, salarioBase, cargo);
        funcionario.setFaltas(2);
        funcionario.setDistanciaMoradia(51);

        //Act
        ProcessadoraBonus pb = new ProcessadoraBonus();
        pb.processar(funcionario);

        //Assert
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }

    @Test
    public void CT018() throws Exception {
        //expect
        thrown.expect(Exception.class);
        thrown.expectMessage("#4 O número de faltas deve ser >= 0");
        
        //Arrange
        String nome = "João";
        String cargo = "Supervisor";
        double salarioBase = 2000.00;
        Funcionario funcionario = new Funcionario(nome, salarioBase, cargo);

        //Act
        funcionario.setFaltas(-1);
        
    }

    @Test
    public void CT019() throws Exception {
        //expect
        thrown.expect(Exception.class);
        thrown.expectMessage("#5 A distancia deve ser >= 0");
        
        //Arrange
        String nome = "João";
        String cargo = "Supervisor";
        double salarioBase = 2000.00;
        Funcionario funcionario = new Funcionario(nome, salarioBase, cargo);

        //Act
        funcionario.setDistanciaMoradia(-1);
        
    }

    @Test
    public void CT020() throws Exception {
        //expect
        thrown.expect(Exception.class);
        thrown.expectMessage("#1 Informe um nome válido");

        //Arrange
        String nome = "Fulano";
        String cargo = "Gerente Financeiro";
        double salarioBase = 2500.00;
        Funcionario funcionario = new Funcionario(nome, salarioBase, cargo);

        //Act
        funcionario.setNome("");

    }

    @Test
    public void CT021() throws Exception {
        //expect
        thrown.expect(Exception.class);
        thrown.expectMessage("#1 Informe um nome válido");

        //Arrange
        String nome = "Fulano";
        String cargo = "Gerente Financeiro";
        double salarioBase = 2500.00;
        Funcionario funcionario = new Funcionario(nome, salarioBase, cargo);

        //Act
        funcionario.setNome(null);

    }

    @Test
    public void CT022() throws Exception {
        //expect
        thrown.expect(Exception.class);
        thrown.expectMessage("#3 O salário base deve ser >= R$ 998,00");

        //Arrange
        String nome = "Fulano";
        String cargo = "Gerente Financeiro";
        double salarioBase = 2500.00;
        Funcionario funcionario = new Funcionario(nome, salarioBase, cargo);

        //Act
        funcionario.setSalarioBase(800);

    }

    @Test
    public void CT023() throws Exception {
        //expect
        thrown.expect(Exception.class);
        thrown.expectMessage("#2 Informe um cargo válido");

        //Arrange
        String nome = "Fulano";
        String cargo = "Gerente Financeiro";
        double salarioBase = 2500.00;
        Funcionario funcionario = new Funcionario(nome, salarioBase, cargo);

        //Act
        funcionario.setCargo("");

    }

    @Test
    public void CT024() throws Exception {
        //expect
        thrown.expect(Exception.class);
        thrown.expectMessage("#2 Informe um cargo válido");

        //Arrange
        String nome = "Fulano";
        String cargo = "Gerente Financeiro";
        double salarioBase = 2500.00;
        Funcionario funcionario = new Funcionario(nome, salarioBase, cargo);

        //Act
        funcionario.setCargo(null);

    }

    @Test
    public void CT025() throws Exception {
        //Arrange
        String nome = "Fulano";
        String cargo = "Programador Assembly";
        double salarioBase = 2000.00;
        double salarioEsperado = 2450;
        Funcionario funcionario = new Funcionario(nome, salarioBase, cargo);
        funcionario.setFaltas(0);
        funcionario.setDistanciaMoradia(130);

        //Act
        ProcessadoraBonus pb = new ProcessadoraBonus();
        pb.processar(funcionario);
        pb.processar(funcionario);

        //Assert
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);

    }

}
