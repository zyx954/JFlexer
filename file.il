.assembly extern mscorlib{}
.assembly Example{}
.class  public Example.Example extends [mscorlib]System.object
{
   .field private int32    z
   .method public static void main(string[] args) 
   {
      .entrypoint
      .locals init ( [0] int32 x,
           [1] int32 y)
      ldc.i4   4
      ldloc.0
      add
      stloc.1
      ret
   }
}
