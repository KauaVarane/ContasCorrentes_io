/*
Em um Banco haverá arquivos de Contas, Movimento e Atualizado
- Criar um sistema que cadastre contas de 5 clientes;
- Gravar também o cadastro de movimento com 10 registros com código conta,  valor do movimento tipo de movimento e statusM;
- Após geração dos cadastros(contas e movimento), processar e gerar Contas Atualizadas, 
  assim como suas consultas.
.............................................................................................................................................
Classificar ambos os Arquivos em ordem crescente de CodConta
Gerar CadastroAtualizado a partir do Balance-line dos arquivos    ContasCorrentes e MovimentoContas 
.............................................................................................................................................
 1 Identificar a partir do codConta seu correspondente no codContaM, caso exista:
   1.1 se statusM = 1, gravar no ContasAtualizado, conforme lay-out;   
   1.2 se statusM = 2, verificar TipoMovimentoM;
       1.2.1  caso saldoContaC < ValorMovimentoM
             tipoContaC      Valor Limite
                1 .............zero
                2 .............LimitecontaC
                3 .............LimitecontaC + 50%  saldoContaC
                4 .............LimitecontaC + 100% saldoContaC
       
       1.2.2 caso saldoContaC > ValorMovimentoM
             calcular a subtração dos valores, se o resultado for negativo utilizar o
             critério do valor Limite 
 2 codConta < codContaM, gravar dados no  ContasAtualizados sem alteração;
 */
package ContasCorrentes_io;
import java.io.*;
import javax.swing.*;
import java.util.Random;
public class ClasseMetodos 
{
    public ContasCorrentes [ ] FCADRASTRACONTASCORRENTES (ContasCorrentes[] contascorrentes)throws IOException
    {
        int i, aux= 0 , cont; String fileName = "ContasCorrentes2025.txt";
        BufferedWriter CadastraContas = new BufferedWriter(new FileWriter(fileName));
        Random random = new Random();
        String[] nomes = {"Ana", "Bruno", "Carla", "Diego", "Fernanda", "Gustavo", "Helena", "Igor", "Juliana", "Lucas"};
        for (i = 0; i < 5; i++) 
        {
            contascorrentes[i] = new ContasCorrentes();
        }
        for (i = 0; i < 5; i++) 
        {
            contascorrentes[i].CodContaC = 1000 + i;
            CadastraContas.write(Integer.toString(contascorrentes[i].CodContaC));
            CadastraContas.newLine();
            contascorrentes[i].NomeClientes = nomes[random.nextInt(nomes.length)];
            CadastraContas.write(contascorrentes[i].NomeClientes );
            CadastraContas.newLine();
            contascorrentes[i].SaldoConta = 1000 + random.nextInt(4000);
            CadastraContas.write(Double.toString(contascorrentes[i].SaldoConta));
            CadastraContas.newLine();
            contascorrentes[i].Limiteconta = 500 + random.nextInt(1000);
            CadastraContas.write(Integer.toString(contascorrentes[i].Limiteconta));
            CadastraContas.newLine();
            contascorrentes[i].TipoConta = 1 + random.nextInt(4);
            CadastraContas.write(Integer.toString(contascorrentes[i].TipoConta));
            CadastraContas.newLine();
        }
        // Classificar ambos os Arquivos em ordem crescente de CodConta
        for (cont = 0 ; cont < 10 ; cont ++)
        {
            for ( i = 0; i < 4; i++ )
            {
                if ( contascorrentes[i].CodContaC > contascorrentes[i+1].CodContaC )
                {
                    aux = ( contascorrentes[i].CodContaC );
                    contascorrentes[i].CodContaC = ( contascorrentes[i+1].CodContaC );
                    contascorrentes[i+1].CodContaC = ( aux );
                } 
            }
        }
        System.out.println("GRAVAÇÃO FEITA COM SUCESSO");
        CadastraContas.close();
        return contascorrentes;
    } 
    public MovimentoContas [ ] FCADRASTRAMOVIMENTO (MovimentoContas[] movimentocontas)throws IOException
    {
        int i, aux, cont; String fileName = "MovimentoContas2025.txt";
        BufferedWriter CadastraMovimento = new BufferedWriter(new FileWriter(fileName));
        Random random = new Random();
        for (i = 0; i < 10; i++) 
        {
            movimentocontas[i] = new MovimentoContas();
        }
        for (i = 0; i < 10; i++) 
        {
            movimentocontas[i].CodContaM = 1000 + random.nextInt(5);
            CadastraMovimento.write(Integer.toString(movimentocontas[i].CodContaM));
            CadastraMovimento.newLine();
            movimentocontas[i].ValorMovimento = 100 + random.nextInt(900);
            CadastraMovimento.write(Double.toString(movimentocontas[i].ValorMovimento));
            CadastraMovimento.newLine();
            movimentocontas[i].TipoMovimento = 1 + random.nextInt(2);
            CadastraMovimento.write(Integer.toString(movimentocontas[i].TipoMovimento));
            CadastraMovimento.newLine();
            movimentocontas[i].Status = 1 + random.nextInt(2);
            CadastraMovimento.write(Integer.toString(movimentocontas[i].Status));
            CadastraMovimento.newLine();
        }
        // Classificar ambos os Arquivos em ordem crescente de CodConta
        for (cont = 0 ; cont < 20 ; cont ++)
        {
            for ( i = 0; i < 9; i++ )
            {
                if ( movimentocontas[i].CodContaM > movimentocontas[i+1].CodContaM )
                {
                    aux = ( movimentocontas[i].CodContaM );
                    movimentocontas[i].CodContaM = ( movimentocontas[i+1].CodContaM );
                    movimentocontas[i+1].CodContaM = ( aux );
                } 
            }
        }
        System.out.println("GRAVAÇÃO FEITA COM SUCESSO");
        CadastraMovimento.close();
        return movimentocontas;
    } 
   /*
    Gerar CadastroAtualizado a partir do Balance-line dos arquivos    ContasCorrentes e MovimentoContas 
    
       
       1.2.2 caso saldoContaC > ValorMovimentoM
             calcular a subtração dos valores, se o resultado for negativo utilizar o
             critério do valor Limite 
    
    */ 
   public ContasAtualizados [ ] FGERARCONTASATUALIZADAS (ContasAtualizados[] contasatualizados, ContasCorrentes[] contascorrentes, MovimentoContas[] movimentocontas )throws IOException
   {
    int i, j; String fileName = "ContasAtualizadas2025.txt";
        BufferedWriter CadastraAtualização = new BufferedWriter(new FileWriter(fileName));
        for (i = 0; i < 5; i++) 
        {
            
            contasatualizados[i] = new ContasAtualizados();
        }
        for (i = 0; i < 10; i++) 
        {
            for (j = 0; j < 5; j++)
            {/*
                1 Identificar a partir do codConta seu correspondente == codContaM, caso exista:
                1.1 se statusM = 1, gravar no ContasAtualizado, conforme lay-out;   
                1.2 se statusM = 2, verificar TipoMovimentoM;
                1.2.1  caso saldoContaC < ValorMovimentoM
                tipoContaC      Valor Limite
                1 .............zero
                2 .............LimitecontaC
                3 .............LimitecontaC + 50%  saldoContaC
                4 .............LimitecontaC + 100% saldoContaC
                1.2.2 caso saldoContaC > ValorMovimentoM
                calcular a subtração dos valores, se o resultado for negativo utilizar o
                critério do valor Limite 
                */
                if ( contascorrentes[j].CodContaC == movimentocontas[i].CodContaM )
                {
                  if ( movimentocontas[i].Status == 1 ) 
                    {
                       contasatualizados[j].CodConta =     ( contascorrentes[j].CodContaC    );
                       contasatualizados[j].NomeClientes = ( contascorrentes[j].NomeClientes );
                       contasatualizados[j].SaldoContaA =  ( contascorrentes[j].SaldoConta   );
                       contasatualizados[j].LimitecontaA = ( contascorrentes[j].Limiteconta  );
                       contasatualizados[j].TipoContaA =   ( contascorrentes[j].TipoConta    );
                       //CadastraAtualização.write(contasatualizados[j].CodConta + "|" +contasatualizados[j].NomeClientes + "|" +contasatualizados[j].SaldoContaA + "|" +contasatualizados[j].LimitecontaA + "|" +contasatualizados[j].TipoContaA );
                    }
                  else if (movimentocontas[i].Status == 2 )
                    {
                      //Credito
                      if ( movimentocontas[i].TipoMovimento == 1 ) 
                      {
                        contascorrentes[j].SaldoConta = (contascorrentes[j].SaldoConta + movimentocontas[i].ValorMovimento);
                      }
                      //Debito
                      else if (movimentocontas[i].TipoMovimento == 2)
                      {
                          if ( contascorrentes[j].SaldoConta < movimentocontas[i].ValorMovimento )
                          {
                            switch (contascorrentes[j].TipoConta) 
                            {
                                case 1: // Física
                                    contasatualizados[j].LimitecontaA =  ( 0 );
                                    break;
                                case 2: // Conjunta
                                    contasatualizados[j].LimitecontaA = ( contascorrentes[j].Limiteconta ) ;
                                    break;
                                case 3: // Jurídica
                                    contasatualizados[j].LimitecontaA = (contascorrentes[j].Limiteconta + (0.5 * contascorrentes[j].SaldoConta));
                                    break;
                                case 4: // Especial
                                    contasatualizados[j].LimitecontaA = ( contascorrentes[j].Limiteconta + contascorrentes[j].SaldoConta );
                                    break;
                                default:
                                    contasatualizados[j].LimitecontaA = contascorrentes[j].Limiteconta;
                            }
                          } 
                          else if ( contascorrentes[j].SaldoConta > movimentocontas[i].ValorMovimento )
                          {
                            contasatualizados[j].SaldoContaA = (contascorrentes[j].SaldoConta - movimentocontas[i].ValorMovimento); 
                          }
                      }
                    }
                 
                    CadastraAtualização.write(String.valueOf(contascorrentes[j].CodContaC));
                    CadastraAtualização.newLine();
                    CadastraAtualização.write(contascorrentes[j].NomeClientes);
                    CadastraAtualização.newLine();
                    CadastraAtualização.write(String.valueOf(contascorrentes[j].SaldoConta));
                    CadastraAtualização.newLine();
                    CadastraAtualização.write(String.valueOf(contascorrentes[j].Limiteconta));
                    CadastraAtualização.newLine();  
                    CadastraAtualização.write(String.valueOf(contascorrentes[j].TipoConta));
                    CadastraAtualização.newLine();    
                }
                //2 codConta < codContaM, gravar dados no  ContasAtualizados sem alteração;
                else if ( contascorrentes[j].CodContaC < movimentocontas[i].CodContaM )
                {
                  
                    CadastraAtualização.write(String.valueOf(contascorrentes[j].CodContaC));
                    CadastraAtualização.newLine();
                    CadastraAtualização.write(contascorrentes[j].NomeClientes);
                    CadastraAtualização.newLine();
                    CadastraAtualização.write(String.valueOf(contascorrentes[j].SaldoConta));
                    CadastraAtualização.newLine();
                    CadastraAtualização.write(String.valueOf(contascorrentes[j].Limiteconta));
                    CadastraAtualização.newLine();
                    CadastraAtualização.write(String.valueOf(contascorrentes[j].TipoConta));
                    CadastraAtualização.newLine();
                    
                }
            }     
        }
        System.out.println("ATUALIZAÇÃO FEITA COM SUCESSO");
        CadastraAtualização.close();
        return contasatualizados;   
    }
}
