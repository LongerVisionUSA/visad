package visad.data.hdfeos;

import java.util.*;
import java.lang.*;
import java.rmi.*;
import experiment.*;
import visad.*;

class metaFlatFieldSimple extends fileData {

   int struct_id;
   metaDomain domainSet;
   variable range_var;

   MathType M_type = null;

   namedDimension n_dim;
   int v_rank;
   int num_type;
   String F_name;
   dimensionSet d_set;

   int[] start;
   int[] edge;
   int[] stride;

  public metaFlatFieldSimple( int struct_id, metaDomain m_dom, variable range_var )  
  {

    super();

    this.struct_id = struct_id;
    this.domainSet = m_dom;
    this.range_var = range_var;

    v_rank = range_var.getRank();
    num_type = range_var.getNumberType();
    F_name = range_var.getName();
    d_set = range_var.getDimSet();

    start = new int[ v_rank ];

    edge = new int[ v_rank ];
    stride = new int[ v_rank ];

    for ( int ii = 0; ii < v_rank; ii++ ) {

      n_dim = range_var.getDim(ii);

      start[ii] = 0;
      edge[ii] = n_dim.getLength();
      stride[ii] = 1;

    }

  }

  public DataImpl getVisADDataObject( indexSet i_set ) throws VisADException, RemoteException
  {
    int ii;

    Set D_set = this.domainSet.getVisADSet( i_set );
   
    FunctionType F_type = (FunctionType) getVisADMathType();

    FlatField F_field = new FlatField( F_type, D_set );

    int stat;
    int samples = 1;

    if ( i_set != null ) {

      for ( ii = 0; ii < i_set.getSize(); ii++ ) {

        n_dim = i_set.getDim(ii);

        if ( d_set.isMemberOf( n_dim ) ) {
          
          start[ii] = i_set.getIndex( n_dim );
          edge[ii] = 1;
        }
        else {
                // Exception

        }
      }

    }

    for ( ii = 0; ii < v_rank; ii++ ) {

      samples = samples*edge[ii];
    }


    float[][] data = new float[ 1 ][ samples ];

    stat = eos.SWreadfield( struct_id, F_name, start, stride, edge, num_type, data[0] );

    F_field.setSamples( data );

    return F_field; 

  }

  public MathType getVisADMathType() throws VisADException 
  {

    MathType M_type = null;

    if ( this.M_type != null ) 
    {
      return this.M_type;
    }
    else
    {

      MathType D_type = domainSet.getVisADMathType();

      String name = range_var.getName();
      RealType R_type = new RealType( name, null, null );

      FunctionType F_type = new FunctionType( D_type, R_type );

      this.M_type = (MathType) F_type;
      return  (MathType)F_type;
     }
  }

}
