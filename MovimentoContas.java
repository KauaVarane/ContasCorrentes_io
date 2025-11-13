/*
. codContaM | ValorMovimentoM | TipoMovimentoM |statusM     .
.............................................................................................................
   int          double              int             int

 */
package ContasCorrentes_io;
class MovimentoContas 
{
    int CodContaM;
    double ValorMovimento;
    int TipoMovimento;
    int Status;
    MovimentoContas()
    {
        this(0,0.0,0,0);
    }
    MovimentoContas(int codcontaM,double valormovimentomM,int tipomovimentoM,int statusM )
    {
    CodContaM = ( codcontaM );
    ValorMovimento = ( valormovimentomM );
    TipoMovimento = ( tipomovimentoM );
    Status = ( statusM );
    }
}
