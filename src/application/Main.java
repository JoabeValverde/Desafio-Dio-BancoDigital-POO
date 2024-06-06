package application;

import entities.Cliente;
import entities.Conta;
import entities.ContaCorrente;
import entities.ContaPoupanca;

public class Main {

    public static void main(String[] args) {
        Cliente fulano = new Cliente();
        fulano.setNome("Fulano");

        Conta cc = new ContaCorrente(fulano);
        Conta cp = new ContaPoupanca(fulano);

        cc.depositar(100);
        cc.transferir(100, cp);

        cc.imprimirExtrato();
        cp.imprimirExtrato();

    }
}
