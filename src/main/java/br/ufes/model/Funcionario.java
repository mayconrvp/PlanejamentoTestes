package br.ufes.model;

import java.util.ArrayList;

public class Funcionario {

    private String nome;
    private double salarioBase;
    private double salarioTotal;
    private Integer distanciaMoradia;
    private Integer faltas;
    private String cargo;
    private final ArrayList<Bonus> bonusRecebidos;

    public Funcionario(String nome, double salarioBase, String cargo) throws Exception {
        String exceptions = "";
        
        try{
            this.setNome(nome);
        }catch(Exception ex){
            exceptions = exceptions.concat("\n").concat(ex.getMessage());
        }
        
        try{
            this.setCargo(cargo);
        }catch(Exception ex){
            exceptions = exceptions.concat("\n").concat(ex.getMessage());
        }
        
        try{
            this.setSalarioBase(salarioBase);
        }catch(Exception ex){
            exceptions = exceptions.concat("\n").concat(ex.getMessage());
        }

        if (exceptions.length() > 0) {
            throw new Exception(exceptions);
        }
        
        this.bonusRecebidos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception {
        if(nome == null || nome.strip().equals("")){
            throw new Exception("#1 Informe um nome válido");
        }
        
        this.nome = nome;
    }

    public double getSalarioBase() {
        return this.salarioBase;
    }

    public void setSalarioBase(double salarioBase) throws Exception{
         if(salarioBase < 998.0){
            throw new Exception("#3 O salário base deve ser >= R$ 998,00");
        }
        this.salarioBase = salarioBase;
    }

    public Integer getFaltas() {
        return faltas;
    }

    public void setFaltas(Integer faltas) throws Exception{
        if(faltas < 0){
            throw new Exception("#4 O número de faltas deve ser >= 0");
        }
        this.faltas = faltas;
    }

    public Integer getDistanciaMoradia() {
        return distanciaMoradia;
    }

    public void setDistanciaMoradia(Integer distanciaMoradia) throws Exception{
        if(distanciaMoradia < 0){
            throw new Exception("#5 A distancia deve ser >= 0");
        }
        this.distanciaMoradia = distanciaMoradia;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) throws Exception{
        if(cargo == null || cargo.strip().equals("")){
            throw new Exception("#2 Informe um cargo válido");
        }
        
        this.cargo = cargo;
    }

    public double getSalario() {
        return this.calculaSalario();
    }

    private double calculaSalario() {
        this.salarioTotal = this.salarioBase + this.calculaTotalBonus();
        return this.salarioTotal;
    }

    public void addBonus(Bonus bonus) {
        this.bonusRecebidos.add(bonus);
    }

    public double calculaTotalBonus() {
        double totalBonus = 0;
        for (Bonus bonus : bonusRecebidos) {
            totalBonus += bonus.getValor();
        }

        return totalBonus;
    }
    
    public void limparBonus(){
        this.bonusRecebidos.clear();
    }

    @Override
    public String toString() {
        String strBonusRecebidos = "";
        for (Bonus bonusRecebido : bonusRecebidos) {
            strBonusRecebidos += "\n\t" + bonusRecebido;
        }
        String strFuncionario = "Funcionario {"
                + "nome: " + this.nome + ", "
                + "salarioBase: " + this.salarioBase + ", "
                + "totalBonus: " + this.calculaTotalBonus() + ", "
                + "salarioTotal: " + this.getSalario()
                + '}';

        if (bonusRecebidos.size() > 0) {
            strFuncionario += "\nBonus recebidos: " + strBonusRecebidos;
        }

        return strFuncionario;
    }
}
