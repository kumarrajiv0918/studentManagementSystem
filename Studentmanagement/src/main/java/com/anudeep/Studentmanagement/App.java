package com.anudeep.Studentmanagement;

import java.util.*;
import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.anudeep.MasterEmpAPP.Employee;
import com.mysql.cj.xdevapi.SessionFactory;
public class App 
{

	static EntityManagerFactory emf  =  Persistence.createEntityManagerFactory("SachinPamar");
	
  	static EntityManager em  = emf.createEntityManager() ;
	static Scanner sc=new Scanner(System.in);
    public static void main( String[] args )
    
    {
    	
    	LoginDetails ld= new LoginDetails();
    	System.out.println("Enter the username");
    	String userName=sc.next();
    	String idname=null;
    	String idpass = null;
		javax.persistence.Query queryd = em.createQuery("select name from LoginDetails");
		List<String> listd=queryd.getResultList();
		for(String ss: listd)
		{
			if(userName.equals(ss))
			{
				//System.out.println(ss);
			    idname=ss;
				break;
			}
		}
    	System.out.println("Enter the password");
    	String password=sc.next();
    	Query q=em.createQuery("select pass from LoginDetails");
		List<String> listp=q.getResultList();
		for(String ss: listp)
		{
			if(password.equals(ss))
			{
				//System.out.println(ss);
					idpass=ss;
					break;
			}
		}
    	
	if(userName.equals(idname) && password.equals(idpass))
			
		{
	     boolean flg=true;
	     while(flg)
	     {
	    	System.out.println("");
	    	System.out.println("1 for insert student  data ");
	    	System.out.println("2 for delete student data ");
	    	System.out.println("3 show the all data is student name");
	    	System.out.println("4 find the single student data ");
	    	System.out.println("5 for update the student data ");
	    	System.out.println("6 for show all student details");
	    	System.out.println("7 for Enter course id name and details");
	    	System.out.println("8 for show all course details");
	    	System.out.println("9 set new admin login details");
	    	System.out.println("10 show the all data adminlogin details");
	    	System.out.println("0 for Exit");
	    	int num=sc.nextInt();
	    	sc.nextLine();
	    	
	    	switch(num)
	    	{
	    	
	    	case 1:
	    		System.out.println("Enter the id ");
	    		 String id=sc.nextLine();
	    		 System.out.println("Enter the name ");
	    		 String name1 =sc.nextLine();
	    		 System.out.println("Enter the your city");
	    		 String city=sc.nextLine();
	    		 System.out.println("Enter the your course");
	    		 String course=sc.nextLine();
			     Student s= new Student(id,name1,city,course);
			     System.out.println(s);
			  	em.getTransaction().begin();
			  	
			  	em.persist(s);
			  	
			  	em.getTransaction().commit();
				
			  	break;
			  	
	    	case 2:
			  
			  	System.out.println("Enter roll to delete ");
			  	int roll=sc.nextInt();
			  	sc.nextLine();
			  	Student student= em.find(Student.class, roll);
			  	if(student != null){
			  	em.getTransaction().begin();
			  	em.remove(student);
			  	em.getTransaction().commit();
			  	System.out.println("Student removed....");
			  	}else
			  	System.out.println("Student not found...");
			  	System.out.println("done");
			  
			  	break;
	    	case 3:
	    		
	    		System.out.println("show all student name");
	    		javax.persistence.Query query = em.createQuery("select name from Student");
	    		List<String> list=query.getResultList();
	    		for(String ss: list)
	    		{
	    			System.out.println(ss);
	    		}
	    		em.getTransaction().begin();
	    		em.getTransaction().commit();
	    	  	
	    		break;
	    	
	    		
	    	case 4:
	    	  	System.out.println("Enter roll to find student Details ");
			  	int roll1=sc.nextInt();
			  	Student studentSingleData= em.find(Student.class, roll1);
				if(studentSingleData != null){
				  	em.getTransaction().begin();
				  	System.out.println(studentSingleData);
				  	em.getTransaction().commit();
				}
				else 
				{
					System.out.println("Roll nomber is not inserted pls re enter ");
				}
				break;
			  	
	    	case 5:
	    		Scanner sc=new Scanner(System.in);
	    		System.out.println("Enter roll to change student name and city");
	    		int roll11=sc.nextInt();
	    		sc.nextLine();
	    		Student student1=em.find(Student.class, roll11); //if it returns the obj then the obj will be in p.state
	    		if(student1 == null){
	    		System.out.println("Student does not exist..");
	    		}
	    		else
	    		{
	    		
	    		System.out.println("Enter the name ");
	    		String name11=sc.nextLine();
	    		System.out.println("Enter the address ");
	    		String address=sc.nextLine();
	    		System.out.println("Enter the course ");
	    		String course1=sc.nextLine();
	    		
	    		em.getTransaction().begin();
	    		student1.setName(name11);
	    		student1.setAddress(address);
	    		student1.setCourse(course1);
	    		em.getTransaction().commit();
	    		System.out.println("change  name, course and city ");
	    		}
	    		
	    		System.out.println("done");
	    		break;
	    
	    	case 6:
	    		System.out.println("show  all table student details");
	    		javax.persistence.Query query1 = em.createQuery("select s from Student s");
	    		List<Student> list1=query1.getResultList();
	    		for(Student ss: list1)
	    		{
	    			System.out.println(ss);
	    		}
	    		em.getTransaction().begin();
	    		em.getTransaction().commit();
	    	  
	    		break;
	    	case 7:
	    		Scanner sc1=new Scanner(System.in);
	    		System.out.println("Enter corse id");
	    		String cid=sc1.nextLine();
	    		System.out.println("Enter corse name");
	    		String cname=sc1.nextLine();
	    		System.out.println("Enter corse details");
	    		String cdetails=sc1.nextLine();
	    		 CourseDetails cd=new CourseDetails();
	    		 cd.setCid(cid);
	    		 cd.setCourseName(cname);
	    		 cd.setCourseDetails(cdetails);
	    		 System.out.println(cd);
			  	em.getTransaction().begin();
			  	
			  	em.persist(cd);
			  	
			  	em.getTransaction().commit();
				
				break;
	    	case 8:
	    		System.out.println("Show all couse ");
	    		javax.persistence.Query query11 = em.createQuery("select cd from CourseDetails cd");
	    		List<CourseDetails> list11=query11.getResultList();
	    		for(CourseDetails c: list11)
	    		{
	    			System.out.println(c);
	    		}
	    		em.getTransaction().begin();
	    		em.getTransaction().commit();
	    	  	
	    		break;
	       case 9: 
	    	    Scanner sc11=new Scanner(System.in);
	    		System.out.println("set  new admin ");
	    		String adminName=sc11.next();
				System.out.println("set password ");
				String adminPass=sc11.next();
				em.getTransaction().begin();
				ld.setName(adminName);
				ld.setPass(adminPass);
				em.persist(ld);
			  	
			  	em.getTransaction().commit();
				
			  	break;
	    	case 10:
	    		System.out.println("show all admin name");
	    		javax.persistence.Query queryld = em.createQuery("select s from LoginDetails s");
	    		List<LoginDetails> listld=queryld.getResultList();
	    		for(LoginDetails ss: listld)
	    		{
	    			System.out.println(ss);
	    		}
	    		em.getTransaction().begin();
	    		em.getTransaction().commit();
	    	  	
	    		break;
	    		
	    		
	    	case 0:
	    		flg=false;
	    		System.out.println("Program closed ");
	    		em.close();
	    		break;
	    		}
	         }
	  
       	}
		else
		{
			System.out.println("Wrong password");
		}
    }
}
