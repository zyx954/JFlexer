.assembly extern mscorlib{}
.assembly Example{}
.class  public Example.Example extends [mscorlib]System.object
{
   .method public static void main(string[] args) 
   {
   .entrypoint
   .locals init (   [0]   int32   [1]   int32   )      // Expression statement x=local[0], y=local[1], y = x + 2;
      ldc.i4   4
      ldloc.0
      add
      stloc.1
      ldloc.1
   }
}
