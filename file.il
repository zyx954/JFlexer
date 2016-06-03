.assembly extern mscorlib{}
.assembly extern JDK{}
.assembly Example{}
.class public Example.Example extends [mscorlib]System.Object
{
   .field private static int32    z
   .method public static void main(string[] args) 
   {
      .entrypoint
      .locals init ([0] int32 x)
      ldc.i4   42
      stloc.0
      // Expression statement x=local[0], y=local[1], y = x + 4;
      ldloc.0
      ldc.i4   3
      add
      stsfld  int32 nullnull
      ldsfld          class [JDK]java.lang.out1 [JDK]java.lang.System::out1
      ldloc.0
      callvirt          instance void [JDK]java.lang.out1::println(int32)
      ret
   }
}
