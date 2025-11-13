/*
    ..........................................
    .    Consulta Cadastros                  .
    ..........................................
    . 1 - Contas Correntes                   .
    . 2 - Movimento                          .
    . 3 - Atualizado                         .
    . 9 - FIM                                .
    ..........................................
 */
package ContasCorrentes_io;
import java.io.*;
import javax.swing.*;
import java.util.Random;
public class ClasseConsulta 
{
    public void FCONSULTACONTASCORRENTES (ContasCorrentes[] contascorrentes)throws IOException
    {
        int i; 
        String fileName = "ContasCorrentes2025.txt";
        BufferedReader ConsultaCorrentes = new BufferedReader(new FileReader(fileName));
        for (i = 0; i < 5; i++) 
        {
            contascorrentes[i] = new ContasCorrentes();
        }
        for (i = 0; i < 5; i++) 
        {
            contascorrentes[i].CodContaC = Integer.parseInt(ConsultaCorrentes.readLine());	
            contascorrentes[i].NomeClientes = ConsultaCorrentes.readLine();	
            contascorrentes[i].SaldoConta = Double.parseDouble(ConsultaCorrentes.readLine());	
            contascorrentes[i].Limiteconta = Integer.parseInt(ConsultaCorrentes.readLine());	
            contascorrentes[i].TipoConta = Integer.parseInt(ConsultaCorrentes.readLine());	              
        }
        for (i = 0; i < 5; i++) 
        {
            System.out.println(contascorrentes[i].CodContaC + "|" +contascorrentes[i].NomeClientes+ "|" +contascorrentes[i].SaldoConta+ "|" +contascorrentes[i].Limiteconta+ "|" +contascorrentes[i].TipoConta);
        }
        ConsultaCorrentes.close();
    }
    public void FCONSULTAMOVIMENTO (MovimentoContas[] movimentocontas)throws IOException
    {
        int i, aux= 0 , cont; String fileName = "MovimentoContas2025.txt";
        BufferedReader ConsultaMovimentos = new BufferedReader(new FileReader(fileName));
        for (i = 0; i < 10; i++) 
        {
            movimentocontas[i] = new MovimentoContas();
        }
        for (i = 0; i < 10; i++) 
        {
            	
            movimentocontas[i].CodContaM = Integer.parseInt(ConsultaMovimentos.readLine());	
            movimentocontas[i].ValorMovimento = Double.parseDouble(ConsultaMovimentos.readLine());	
            movimentocontas[i].TipoMovimento = Integer.parseInt(ConsultaMovimentos.readLine());
            movimentocontas[i].Status = Integer.parseInt(ConsultaMovimentos.readLine());	
            
        }
        for (i = 0; i < 10; i++) 
        {
            System.out.println(movimentocontas[i].CodContaM+ "|" +movimentocontas[i].ValorMovimento+ "|" +movimentocontas[i].TipoMovimento+ "|" +movimentocontas[i].Status);
        }
        ConsultaMovimentos.close();
    }
    public void FCONSULTAATUALIZAÇÃO (ContasAtualizados[] contasatualizados)throws IOException
    {
        int i; 
        String fileName = "ContasAtualizadas2025.txt";
        BufferedReader ConsultaAtualização = new BufferedReader(new FileReader(fileName));
        for (i = 0; i < 5; i++) 
        {
            contasatualizados[i] = new ContasAtualizados();
        }
        for (i = 0; i < 5; i++) 
        {
            contasatualizados[i].CodConta = Integer.parseInt(ConsultaAtualização.readLine());	
            contasatualizados[i].NomeClientes = ConsultaAtualização.readLine();	
            contasatualizados[i].SaldoContaA = Double.parseDouble(ConsultaAtualização.readLine());	
            contasatualizados[i].LimitecontaA = Double.parseDouble(ConsultaAtualização.readLine());	
            contasatualizados[i].TipoContaA = Integer.parseInt(ConsultaAtualização.readLine());	              
        }
        for (i = 0; i < 5; i++) 
        {
            System.out.println(contasatualizados[i].CodConta+ "|" +contasatualizados[i].NomeClientes+ "|" +contasatualizados[i].SaldoContaA+ "|" +contasatualizados[i].LimitecontaA + "|" +contasatualizados[i].TipoContaA);
        }
        ConsultaAtualização.close(); 
    }
}
