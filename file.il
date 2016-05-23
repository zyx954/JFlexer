.assembly extern mscorlib{}
.assembly Example{}
.class  public Example.Example extends [mscorlib]System.Object
{
   .method public static void main(string[] args) 
   {
      .entrypoint
      .locals init ( [0] int32 x)
      ldc.i4.s   42
      stloc.0
      ret
   }
}
