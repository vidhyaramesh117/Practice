

class Employee {
 var empName = "mukul";
 var empAge = 24;
 var empSalary = 500;

 String get employeeName {
 return empName;
 } 

 void set employeeName(String name) {
 this.empName = name;
 }

 void set employeeAge(int age) {
 if(age<= 18) {
 print("Employee Age should be greater than 18 Years.");
 } else {
 this.empAge = age;
 }
 }

 int get employeeAge {
 return empAge;
 }

 void set employeeSalary(int salary) {
 if(salary<= 0) {
 print("Salary cannot be less than 0");
 } else {
 this.empSalary = salary;
 }
 }

 int get employeeSalary {
 return empSalary;
 }
}
void main() { 
 Employee emp = new Employee();
 emp.employeeName = 'Rahul';
 emp.employeeAge = 25;
 emp.employeeSalary = 2000;
 print("Employee's Name is : ${emp.employeeName}");
 print("Employee's Age is : ${emp.employeeAge}");
 print("Employee's Salary is : ${emp.employeeSalary}");
}


// void main()
// {
//   Student s1 = new Student();
//   s1.stud_name = "MARK";
//   s1.stud_age = 0;
//   print(s1.stud_name);
//   print(s1.stud_age);
// }
// class Student
// {
//   String name;
//   int age;
//   String get stud_name
//   {
//     return name;
//   }
//   void set stud_name(String name)
//   {
//     this.name = name;
//   }
//   void set stud_age(int age)
//   {
//     if(age <= 0)
//     {
//       print("Age should be greater than 5");
//     }
//     else
//     {
//       this.age = age;
//     }
//   }
//   int get stud_age
//   {
//     return age;
//   }
// }