/*
codContaA | nomeClientesA | saldoContaA | LimitecontaA |tipoContaA                    .  
.............................................................................................................................................
   int          String          double         double             int                  


 */
package ContasCorrentes_io;
class ContasAtualizados
{
    int CodConta;
    String NomeClientes;
    double SaldoContaA;
    double LimitecontaA;
    int TipoContaA ; 
    ContasAtualizados()
    {
        this(0,"",0.0,0,0);
    }
    ContasAtualizados(int codcontaM,String nomeclientesA,double saldocontaA,double limitecontaA, int tipocontaA )
    {
    CodConta = ( codcontaM );
    NomeClientes = ( nomeclientesA );
    SaldoContaA = ( saldocontaA );
    LimitecontaA = ( limitecontaA );
    TipoContaA = (tipocontaA );
    }
}
