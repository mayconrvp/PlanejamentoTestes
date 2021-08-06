package br.ufes.projetos01;

import br.ufes.calculodebonus.ProcessadoraBonus;
import br.ufes.model.Funcionario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * Link da Planilha: https://docs.google.com/spreadsheets/d/1kWf0JLfYjsdoAxqHmqO5hAxkCbFEoIhgqFXptL6J7y4/edit?usp=sharing
 */
public class FuncionarioBonusTest {

    public FuncionarioBonusTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
    }

    @Test
    public void CT001() throws Exception {
        //Arrange
        Funcionario funcionario = new Funcionario("Fulano", 2500.00, "Gerente");
        double salarioEsperado = 2500.00;
        //Assert
        assertEquals(salarioEsperado, funcionario.getSalarioBase(), 0.001);
    }

    @Test
    public void CT002() throws Exception {
        //Arrange
        Funcionario funcionario = new Funcionario("Fulano", 2500.00, "Gerente");
        funcionario.setFaltas(2);
        double salarioEsperado = 2650.00;
        
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
        funcionario.setFaltas(2);
        funcionario.setDistanciaMoradia(101);
        double salarioEsperado = 2950.00;
        
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
        funcionario.setFaltas(2);
        funcionario.setDistanciaMoradia(151);
        double salarioEsperado = 3150.00;
        
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
        funcionario.setFaltas(2);
        funcionario.setDistanciaMoradia(51);
        double salarioEsperado = 2800.00;
        
        //Act
        ProcessadoraBonus pb = new ProcessadoraBonus();
        pb.processar(funcionario);

        //Assert
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }
    
    @Test
    public void CT006() throws Exception {
        //Arrange
        String nome = "João";
        String cargo = "Supervisor";
        double salarioBase = 997.00;
        double salarioEsperado = 0; 
        
        //Act
        Funcionario funcionario = new Funcionario (nome, salarioBase, cargo);
        
        //Assert
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);     
    }
    
    @Test
    public void CT007() throws Exception {
        //Arrange
        String nome = "";
        String cargo = "Supervisor";
        double salarioBase = 2000.00;
        double salarioEsperado = 2000.00; 
        
        //Act
        Funcionario funcionario = new Funcionario (nome, salarioBase, cargo);
        
        //Assert
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);     
    }
    
    @Test
    public void CT008() throws Exception {
        //Arrange
        String nome = null;
        String cargo = "Supervisor";
        double salarioBase = 2000.00;
        double salarioEsperado = 0; 
        Funcionario funcionario = new Funcionario (nome, salarioBase, cargo);
        
        //Act
        ProcessadoraBonus pb = new ProcessadoraBonus();
        pb.processar(funcionario);
        
        //Assert
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);     
    }
    
    @Test
    public void CT009() throws Exception {
        //Arrange
        String nome = "João";
        String cargo = "Supervisor";
        double salarioBase = 2000.00;
        double salarioEsperado = 2000.0; 
        
        //Act
        Funcionario funcionario = new Funcionario (nome, salarioBase, cargo);
        
        //Assert
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);     
    }
    
    @Test
    public void CT010() throws Exception {
        //Arrange
        String nome = "João";
        String cargo = null;
        double salarioBase = 2000.00;
        double salarioEsperado = 2000.00; 
        Funcionario funcionario = new Funcionario (nome, salarioBase, cargo);
        
        //Act
        ProcessadoraBonus pb = new ProcessadoraBonus();
        pb.processar(funcionario);
        
        //Assert
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);     
    }
    
    @Test
    public void CT011() throws Exception {
        //Arrange
        String nome = "João";
        String cargo = "Supervisor";
        double salarioBase = 2000.00;
        double salarioEsperado = 2180.00; 
        Funcionario funcionario = new Funcionario (nome, salarioBase, cargo);
        funcionario.setFaltas(0);
        
        //Act
        ProcessadoraBonus pb = new ProcessadoraBonus();
        pb.processar(funcionario);        
        
        //Assert
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);     
    }
    
     @Test
    public void CT012() throws Exception {
        //Arrange
        String nome = "João";
        String cargo = "Supervisor";
        double salarioBase = 2000.00;
        double salarioEsperado = 2120.00; 
        Funcionario funcionario = new Funcionario (nome, salarioBase, cargo);
        funcionario.setFaltas(4);
        
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
        String cargo = "Supervisor";
        double salarioBase = 2000.00;
        double salarioEsperado = 2100.00; 
        Funcionario funcionario = new Funcionario (nome, salarioBase, cargo);
        funcionario.setFaltas(9);
        
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
        String cargo = "Supervisor";
        double salarioBase = 2000.00;
        double salarioEsperado = 2580.00; 
        Funcionario funcionario = new Funcionario (nome, salarioBase, cargo);
        funcionario.setDistanciaMoradia(151);
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
        double salarioEsperado = 2380.00; 
        Funcionario funcionario = new Funcionario (nome, salarioBase, cargo);
        funcionario.setDistanciaMoradia(101);
        
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
        String cargo = "Supervisor";
        double salarioBase = 2000.00;
        double salarioEsperado = 2230.00; 
        Funcionario funcionario = new Funcionario (nome, salarioBase, cargo);
        funcionario.setDistanciaMoradia(51);
        
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
        String cargo = "Programador";
        double salarioBase = 2000.00;
        double salarioEsperado = 2080.00; 
        Funcionario funcionario = new Funcionario (nome, salarioBase, cargo);
        
        //Act
        ProcessadoraBonus pb = new ProcessadoraBonus();
        pb.processar(funcionario);        
        
        //Assert
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);     
    }
    
     @Test
    public void CT018() throws Exception {
        //Arrange
        String nome = "João";
        String cargo = "Programador";
        double salarioBase = 2000.00;
        double salarioEsperado = 2120.00; 
        Funcionario funcionario = new Funcionario (nome, salarioBase, cargo);
        funcionario.setFaltas(2);
        
        //Act
        ProcessadoraBonus pb = new ProcessadoraBonus();
        pb.processar(funcionario);        
        
        //Assert
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);     
    }
    
     @Test
    public void CT019() throws Exception {
        //Arrange
        String nome = "João";
        String cargo = "Programador";
        double salarioBase = 2000.00;
        double salarioEsperado = 2390.00; 
        Funcionario funcionario = new Funcionario (nome, salarioBase, cargo);
        funcionario.setFaltas(2);
        funcionario.setDistanciaMoradia(101);
        
        //Act
        ProcessadoraBonus pb = new ProcessadoraBonus();
        pb.processar(funcionario);        
        
        //Assert
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);     
    }
    
     @Test
    public void CT020() throws Exception {
        //Arrange
        String nome = "João";
        String cargo = "Gerente";
        double salarioBase = 0;
        double salarioEsperado = 0; 
        Funcionario funcionario = new Funcionario (nome, salarioBase, cargo);
        funcionario.setFaltas(3);
        funcionario.setDistanciaMoradia(51);
        
        //Act
        ProcessadoraBonus pb = new ProcessadoraBonus();
        pb.processar(funcionario);        
        
        //Assert
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);     
    }
    
     @Test
    public void CT021() throws Exception {
        //Arrange
        String nome = "João";
        String cargo = "Supervisor";
        double salarioBase = 2000.00;
        double salarioEsperado = 2270.00; 
        Funcionario funcionario = new Funcionario (nome, salarioBase, cargo);
        funcionario.setFaltas(-1);
        funcionario.setDistanciaMoradia(51);
        
        //Act
        ProcessadoraBonus pb = new ProcessadoraBonus();
        pb.processar(funcionario);        
        
        //Assert
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);     
    }
    
     @Test
    public void CT022() throws Exception {
        //Arrange
        String nome = "João";
        String cargo = "Supervisor";
        double salarioBase = 2000.00;
        double salarioEsperado = 2120.00; 
        Funcionario funcionario = new Funcionario (nome, salarioBase, cargo);
        funcionario.setFaltas(2);
        funcionario.setDistanciaMoradia(-1);
        
        //Act
        ProcessadoraBonus pb = new ProcessadoraBonus();
        pb.processar(funcionario);        
        
        //Assert
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);     
    }
    
}



//50 minutos planejamento
