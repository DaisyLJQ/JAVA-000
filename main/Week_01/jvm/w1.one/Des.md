 javap -c HelloWord.class      
Compiled from "HelloWord.java"
public class com.example.corestudy.jvm.HelloWord {
  public com.example.corestudy.jvm.HelloWord();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public int add(int);
    Code:
       0: aload_0
       1: dup
       2: getfield      #2                  // Field num:I
       5: iconst_1
       6: iadd
       7: putfield      #2                  // Field num:I
      10: aload_0
      11: aload_0
      12: getfield      #3                  // Field sum:I
      15: iload_1
      16: iadd
      17: putfield      #3                  // Field sum:I
      20: aload_0
      21: getfield      #3                  // Field sum:I
      24: ireturn

  public double average(int);
    Code:
       0: aload_0
       1: dup
       2: getfield      #2                  // Field num:I
       5: iconst_1
       6: iadd
       7: putfield      #2                  // Field num:I
      10: aload_0
      11: iload_1
      12: aload_0
      13: getfield      #3                  // Field sum:I
      16: iadd
      17: putfield      #3                  // Field sum:I
      20: aload_0
      21: getfield      #3                  // Field sum:I
      24: i2d
      25: aload_0
      26: getfield      #2                  // Field num:I
      29: i2d
      30: ddiv
      31: dreturn

  public double del(int);
    Code:
       0: aload_0
       1: dup
       2: getfield      #2                  // Field num:I
       5: iconst_1
       6: iadd
       7: putfield      #2                  // Field num:I
      10: aload_0
      11: getfield      #3                  // Field sum:I
      14: iload_1
      15: isub
      16: i2d
      17: dreturn

  public double mul(int);
    Code:
       0: aload_0
       1: dup
       2: getfield      #2                  // Field num:I
       5: iconst_1
       6: iadd
       7: putfield      #2                  // Field num:I
      10: aload_0
      11: aload_0
      12: getfield      #3                  // Field sum:I
      15: iload_1
      16: imul
      17: putfield      #3                  // Field sum:I
      20: aload_0
      21: getfield      #3                  // Field sum:I
      24: i2d
      25: dreturn

  public static void main(java.lang.String[]);
    Code:
       0: new           #4                  // class com/example/corestudy/jvm/HelloWord
       3: dup
       4: invokespecial #5                  // Method "<init>":()V
       7: astore_1
       8: aload_1
       9: iconst_2
      10: invokevirtual #6                  // Method add:(I)I
      13: pop
      14: aload_1
      15: iconst_1
      16: invokevirtual #7                  // Method del:(I)D
      19: pop2
      20: aload_1
      21: iconst_3
      22: invokevirtual #8                  // Method average:(I)D
      25: pop2
      26: aload_1
      27: iconst_4
      28: invokevirtual #9                  // Method mul:(I)D
      31: pop2
      32: getstatic     #10                 // Field java/lang/System.out:Ljava/io/PrintStream;
      35: new           #11                 // class java/lang/StringBuilder
      38: dup
      39: invokespecial #12                 // Method java/lang/StringBuilder."<init>":()V
      42: ldc           #13                 // String 次数：
      44: invokevirtual #14                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      47: aload_1
      48: getfield      #2                  // Field num:I
      51: invokevirtual #15                 // Method java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
      54: ldc           #16                 // String ---------求和：
      56: invokevirtual #14                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      59: aload_1
      60: getfield      #3                  // Field sum:I
      63: invokevirtual #15                 // Method java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
      66: invokevirtual #17                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
      69: invokevirtual #18                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      72: return
}