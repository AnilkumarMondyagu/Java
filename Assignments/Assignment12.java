import java.util.*;  
import java.util.stream.Collectors;  

class Student{  
    int id;  
    String name;  
    int year;
    String dept;
    String gender;
    int age;
    double per;  
    
    public Student(int id, String name,int age,String gender,String dept,int year, double per) {  
        this.id = id;  
        this.name = name;  
        this.age=age;
        this.gender=gender;
        this.dept=dept;
        this.year=year;
        this.per=per;
    }  
    
    public String getName() {
        return name;
    }
    
    public String getGender() {
        return gender;
    }
    
    public String getDept(){
        return dept;
    }
    
    public double getPer(){
        return per;
    }
    
    public int getAge(){
        return age;
    }
    
    public String toString(){//overriding the toString() method  
        return name+" "+gender+" "+age+" "+" "+dept+" "+year+" "+per;  
    }
}  

public class Main{

    public static void main(String[] args){
    
        List<Student> s = new ArrayList<>();
        
        //Adding Products
        s.add(new Student(111, "Jiya Brein", 17, "Female", "Computer Science", 2018, 70.8));
        s.add(new Student(122, "Paul Niksui", 18, "Male", "Mechanical", 2016, 50.2));
        s.add(new Student(133, "Martin Theron", 17, "Male", "Electronic", 2017, 90.3));
        s.add(new Student(144, "Murali Gowda", 18, "Male", "Electrical", 2018, 80));
        s.add(new Student(155, "Nima Roy", 19, "Female", "Textile", 2016, 70));
        s.add(new Student(166, "Iqbal Hussain", 18, "Male", "Security", 2016, 70));
        s.add(new Student(177, "Manu Sharma", 16, "Male", "Chemical", 2018, 70));
        s.add(new Student(188, "Wang Liu", 20, "Male", "Computer Science", 2015, 80));
        s.add(new Student(199, "Amelia Zoe", 18, "Female", "Computer Science", 2016, 85));
        s.add(new Student(200, "Jaden Dough", 18, "Male", "Security", 2015, 82));
        s.add(new Student(211, "Jasna Kaur", 20, "Female", "Electronic", 2019, 83));
        s.add(new Student(222, "Nitin Joshi", 19, "Male", "Textile", 2016, 60.4));
        s.add(new Student(233, "Jyothi Reddy", 16, "Female", "Computer Science", 2015, 45.6));
        s.add(new Student(244, "Nicolus Den", 16, "Male", "Electronic", 2017, 95.8));
        s.add(new Student(255, "Ali Baig", 17, "Male", "Electronic", 2018, 88.4));
        s.add(new Student(266, "Sanvi Pandey", 17, "Female", "Electric", 2019, 72.4));
        s.add(new Student(277, "Anuj Chettiar", 18, "Male", "Computer Science", 2017, 57.5));
        
        Set<String> r1=s.stream().map(sl->sl.dept).collect(Collectors.toSet());
        System.out.println("Departments: \n"+r1+"\n");
        
        List<String> r2 =s.stream().filter(sl->sl.year>2018).map(Student::getName).collect(Collectors.toList());
        System.out.println("Students enrolled aftrer 2018: \n"+r2+"\n");
        
        List<Student> r3=s.stream().filter(sl->sl.gender=="Male" && sl.dept=="Computer Science").collect(Collectors.toList());
        System.out.println("Male students of Computer Science: \n"+r3+"\n");
        
        Map<String, Long> r4 = s.stream().collect(Collectors.groupingBy(Student::getGender, Collectors.counting()));
        System.out.println("Male and Female students count: \n"+r4+"\n");
        
        Double r5 = s.stream().collect(Collectors.averagingDouble(sl->sl.age));
        System.out.println("Average age: \n"+r5+"\n");
        
        Student r6 = s.stream().max(Comparator.comparingDouble(Student::getPer)).get();
        System.out.println("Student with highest percentage: \n"+r6+"\n");
        
        Map<String, Long> r7 = s.stream().collect(Collectors.groupingBy(Student::getDept, Collectors.counting()));
        System.out.println("Count of students in each Department: \n"+r7+"\n");
        
        Map<String, Double> r8 = s.stream().collect(Collectors.groupingBy(Student::getDept, Collectors.averagingDouble(sl->sl.per)));
        System.out.println("Average of students of each department: \n"+r8+"\n");
        
        Student r9 = s.stream().collect(Collectors.minBy(Comparator.comparingInt(Student::getAge))).get();
        System.out.println("Youngest Student: \n"+r9+"\n");
        
        Map<String, Long> r10 = s.stream().filter(sl->sl.dept=="Computer Science").collect(Collectors.groupingBy(Student::getGender, Collectors.counting()));
        System.out.println("Count of male and female students of Computer Science: \n"+r10);
        
    }  
}
