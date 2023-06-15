void main()
{
  print("\nSTRING \n");
  String str1 = 'App development ';
  String str2 = "Cyber security";
  String str3 = '''Computer Engineering ''';
  String str4 = """combines the fields of electrical engineering and computer science.
  A computer engineer is involved in both the design of computer architecture and the design of hardware and software. """; 
  String str5 = " Software Engineering";
  print(str1);
  print(str2);
  print(str3);
  print(str4);

  print(" \nCONCATENATION \n");

  print("The CS is ${str3 + str4} ");
  String con = str1 + str2;
  print("The courses are $con");

  print("\nFUNCTIONS \n");
  print("toLowerCase = ${str2.toLowerCase()}");

  print("toUpperCase = ${str3.toUpperCase()}");

  print("Trim = ${str5.trim()}");
  print("Trim left = ${str5.trimLeft()}");
  print("Trim Right = ${str5.trimRight()}");

  
}