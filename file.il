.assembly extern mscorlib{}
.assembly Example{}
.class  public Example.Example extends [mscorlib]System.object
{
   .field private   int32   z
   .method public static void main(string[] args) 
   {
      ldc.i4   4
      ldloc.0
      add
      stloc.1
      ref
   }
}
