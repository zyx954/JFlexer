.assembly extern mscorlib{}
.assembly Example{}
.class public Example.Example extends [mscorlib]System.Object
{
   .method public static void main(string[] args) 
   {
      .entrypoint
      .locals init ([0] int32 x,
          [1] int32 y)
      ldc.i4   42
      stloc.0
      // Expression statement x=local[0], y=local[1], y = x + 4;
      ldc.i4   31
      ldloc.0
      add
      stloc.1
      ldloc.1
      ldsfld          class [JDK]java.lang.out [JDK]java.lang.System::out
      ldc.i4
      callvirt          instance void [JDK]java.lang.out::println(y)
      ret
   }
}
