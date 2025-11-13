/*
 .          ContasCorrentes                                                                                                .
...........................................................................................................................
. codContaC | nomeClientesC | saldoContaC | LimitecontaC |tipoContaC      .
..........................................................................................................................
   int        String            double        int          int

 */
package ContasCorrentes_io;
class ContasCorrentes 
{
    int CodContaC;
    String NomeClientes;
    double SaldoConta;
    int Limiteconta;
    int TipoConta; 
    ContasCorrentes()
    {
        this(0,"",0.0,0,0);
    }
    ContasCorrentes(int codcontaC,String nomeclientesC,double saldocontaC,int limitecontaC,int tipocontaC )
    {
    CodContaC = ( codcontaC );
    NomeClientes = ( nomeclientesC );
    SaldoConta = ( saldocontaC );
    Limiteconta = ( limitecontaC );
    TipoConta = ( tipocontaC ); 
    }
}
