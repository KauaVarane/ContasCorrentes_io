/*
 ......................................................
.                MENU PRINCIPAL           .
......................................................
. 1 - Cadastra Contas Correntes    . 
. 2 - Cadastra movimento              .
. 3 - Gera Contas Atualizadas       .
. 4 - Consulta cadastros                .
. 9 - FIM                                           .
....................................................

 */
package ContasCorrentes_io;
import java.io.IOException;
import javax.swing.JOptionPane;
public class MenuPrincipal  
{
  public static void main (String arg [ ]) throws IOException  
  {
    ContasCorrentes[ ] contascorrentes = new ContasCorrentes[5];	
    MovimentoContas[ ] movimentocontas = new MovimentoContas[10];	
    ContasAtualizados[ ] contasatualizados = new ContasAtualizados[5];	
    ClasseMetodos m = new ClasseMetodos(); 
    int opc=0;
    while (opc!=9)
    {
        opc = Integer.parseInt(JOptionPane.showInputDialog("1 - Cadastra Contas Correntes \n 2 - Cadastra movimento  \n 3 - Gera Contas Atualizadas \n 4 - Consulta cadastros \n  9 - FIM  "));
        switch (opc) 
        {
               case 1  : contascorrentes = m.FCADRASTRACONTASCORRENTES(contascorrentes);
                break;
                case 2 : movimentocontas = m.FCADRASTRAMOVIMENTO(movimentocontas);
                break;
                case 3 : contasatualizados = m.FGERARCONTASATUALIZADAS(contasatualizados,contascorrentes,movimentocontas);
                break;
                case 4 : FCONSULTACADASTROS(contascorrentes,movimentocontas,contasatualizados);
                break;
                case 9 : JOptionPane.showMessageDialog(null,"FINALIZADO");
                break;
                default: JOptionPane.showMessageDialog(null,"OPÇÃO INVÁLIDA");
        } 
    }  
  }  
    //............................................
    //.    Consulta Cadastros         .
    //...........................................
    //. 1 - Contas Correntes         .
    //. 2 - Movimento                   .
    //. 3 - Atualizado                    .
    //. 9 - FIM                                .
    //..........................................
  public static void FCONSULTACADASTROS(ContasCorrentes[] contascorrentes,MovimentoContas[ ] movimentocontas,ContasAtualizados[ ] contasatualizados)throws IOException
    {
        ClasseConsulta c = new ClasseConsulta ();
        int opc = 0;
        while ( opc!= 9)
        {
            opc = Integer.parseInt(JOptionPane.showInputDialog("1 – Contas Correntes o \n 2 – Movimento \n 3 – Atualizado  \n 9 - Fim"));
            switch ( opc )
            {
                case 1 : c.FCONSULTACONTASCORRENTES (contascorrentes);
                break;
                case 2 : c.FCONSULTAMOVIMENTO(movimentocontas);
                break;
                case 3 : c.FCONSULTAATUALIZAÇÃO(contasatualizados);
                break;
                case 9 : JOptionPane.showMessageDialog(null,"FINALIZADO");
                break;
                default: JOptionPane.showMessageDialog(null,"OPÇÃO INVÁLIDA");
            }
        }
    }
}




