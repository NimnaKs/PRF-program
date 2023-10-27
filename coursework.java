import java.util.*;
class coursework{
	static String[] stuid=new String[0];
	static String[] studentName=new String[0];
	static int[] prfMarks=new int[0];
	static int[] dbmsMarks=new int[0];
	static int[] total;
	static char ch='|';
	public static void main(String args[]){
		WelcomeGdseMarkmanagementsystem();
	}
	public static void WelcomeGdseMarkmanagementsystem(){
		Scanner scanner=new Scanner(System.in);
		clearConsole();
		underscore(80);
		String str="WELCOME TO GDSE MARKS MANAGEMENT SYSTEM";
		System.out.printf("%-1c%57s%22c\n",ch,str,ch);
		underscore(80);
		System.out.println("\n[1] Add New Student\t\t\t[2]  Add New Student With Marks");
		System.out.println("[3] Add Marks\t\t\t\t[4]  Update Student Details");
		System.out.println("[5] Update Marks\t\t\t[6]  Delete Student");
		System.out.println("[7] Print Student Details\t\t[8]  Print Student Ranks");
		System.out.println("[9] Best in Programming Fundamentals\t[10] Best in Database Management System");
		System.out.print("\nEnter an option to continue > ");
		int option=scanner.nextInt();
		clearConsole();
		L1:switch(option){
			case 1 :addNewStudent(scanner);break;
			case 2 :addNewStudentWithMarks(scanner);break;
			case 3 :addMarks(scanner);break;
			case 4 :updateStudentDetails(scanner);break;
			case 5 :updateMarks(scanner);break;
			case 6 :deleteStudent(scanner);break;
			case 7 :printStudentDetails(scanner);break;
			case 8 :printStudentRanks(scanner);break;
			case 9 :bestInProgrammingFundamentals(scanner);break;
			case 10:bestInDatabaseManagementSystem(scanner);break;
			default:System.out.println("Wrong input.Try Again..");
			}
	}
	public static void addNewStudent(Scanner scanner ){
		L5:while(true){
			underscore(80);
			String str="ADD NEW STUDENT";
			System.out.printf("%-1c%45s%34c\n",ch,str,ch);
			underscore(80);
			L2:do{
					System.out.print("\nEnter Student Id   : ");
					String stuId=scanner.next();
					if(!stuIdValidation(stuId)){
						System.out.println("Invalid Student ID.");
						continue L2;
					}
					if(stuIdDublication(stuId)){
						System.out.println("The Student ID already exists");
						continue L2;
					}
					System.out.print("Enter Student Name : ");
					String stuname=scanner.next();
					stuIdandstuNameinsert(stuId,stuname);
					prfAndDbmsinsert(-1,-1);
					break;
				}while(true);
			System.out.print("\nStudent has been added successfully. Do you want to add a new student (Y/n) ");
			String yes=scanner.next();
			yesOrNo(yes);
		}
	}
	public static void addNewStudentWithMarks(Scanner scanner){
		L4:while(true){
			underscore(80);
			String str="ADD NEW STUDENT WITH MARKS";
			System.out.printf("%-1c%51s%28c\n",ch,str,ch);
			underscore(80);
			L1:do{
				System.out.print("\nEnter Student Id   : ");
				String stuId=scanner.next();
				if(!stuIdValidation(stuId)){
					System.out.println("Invalid Student ID.");
					continue L1;
				}
				if(stuIdDublication(stuId)){
						System.out.println("The Student ID already exists");
						continue L1;
				}
				System.out.print("Enter Student Name : ");
				String stuname=scanner.next();
				int prfmarks=0,dbmsmarks=0;
				L3:while(true){
						System.out.print("\nProgramming Fundamental Marks :");
						prfmarks=scanner.nextInt();
						if(!marksbetween0and100(prfmarks)){
							System.out.println("Invalid marks.please enter correct marks.");
							continue L3;
						}else{break;}
					}
				L2:while(true){
						System.out.print("DataBase Management System Marks :");
						dbmsmarks=scanner.nextInt();
						if(!marksbetween0and100(dbmsmarks)){
							System.out.println("Invalid marks.please enter correct marks.\n");
							continue L2;
						}else{break;}
					}
				stuIdandstuNameinsert(stuId,stuname);
				prfAndDbmsinsert(prfmarks,dbmsmarks);
				break;
			}while(true);
			System.out.print("\nStudent has been added successfully. Do you want to add a new student (Y/n) ");
			String yes=scanner.next();
			yesOrNo(yes);
		}
	} 
	public static void addMarks(Scanner scanner){
		L4:while(true){
			underscore(80);
			String str="ADD MARKS";
			System.out.printf("%-1c%40s%39c\n",ch,str,ch);
			underscore(80);
			int index=0;
			L6:do{
				System.out.print("\nEnter Student Id   : ");
				String stuId=scanner.next();
				L7:for(int i=0;i<stuid.length;i++){
					if(!stuId.equals(stuid[i])){
						continue L7;
						}else{index=i;break L6;}
					}
					System.out.print("Invalid Student ID.Do you want to search again? (Y/n) ");
					String yes=scanner.next();
					switch(yes){
						case ("n"):WelcomeGdseMarkmanagementsystem();
						case ("Y"):continue L6;
					}
				}while(true);
				System.out.print("Student Name       : "+studentName[index]+"\n");
			if (prfMarks[index]!=-1 && dbmsMarks[index]!=-1 ){
				System.out.println("This student's marks have been already added.\nIf you want to update the marks,please use[4] Update Marks option.\n");
				System.out.print("Do you want to add marks for another student? (Y/n) ");
				String yes=scanner.next();
				yesOrNo(yes);
				if("Y".equals(yes)){continue L4;}
			}
			int prfmarks,dbmsmarks;
			L3:while(true){
					System.out.print("\nProgramming Fundamental Marks :");
					prfmarks=scanner.nextInt();
					if(!marksbetween0and100(prfmarks)){
						System.out.print("Invalid marks.please enter correct marks.\n");
						continue L3;
					} else{break;}
				}
			L2:while(true){
					System.out.print("DataBase Management System Marks :");
					dbmsmarks=scanner.nextInt();
					if(!marksbetween0and100(dbmsmarks)){
						System.out.println("Invalid marks.please enter correct marks.\n");
						continue L2;
					}else{break;}
				}
			prfMarks[index]=prfmarks;
			dbmsMarks[index]=dbmsmarks;
			System.out.print("Marks have been added.Do you want to add marks for another student ? (Y/n) ");
			String yes=scanner.next();
			yesOrNo(yes);	
		}
	  }
	public static void updateStudentDetails(Scanner scanner){
		L9:while(true){
			underscore(80);
			String str="UPDATE STUDENT DETAILS";
			System.out.printf("%-1c%48s%31c\n",ch,str,ch);
			underscore(80);
			int index=0;
			L8:do{
					System.out.print("\nEnter Student Id   : ");
					String stuId=scanner.next();
					L7:for(int i=0;i<stuid.length;i++){
						if(!stuId.equals(stuid[i])){
							continue L7;
							}else{index=i;break L8;}
						}
						System.out.print("Invalid Student ID.Do you want to search again? (Y/n) ");
						String yes=scanner.next();
						switch(yes){
							case ("n"):WelcomeGdseMarkmanagementsystem();
							case ("Y"):continue L8;
						}
				}while(true);
			System.out.print("Student Name       : "+studentName[index]+"\n");
			System.out.print("\nEnter new student name : ");
			String name=scanner.next();
			studentName[index]=name;
			System.out.print("\nStudent details has been updated successfully.\nDo you want to update another student datails? (Y/n) ");
			String yes=scanner.next();
			yesOrNo(yes);	
		}
	}
	public static void updateMarks(Scanner scanner){
		L9:while(true){
			underscore(80);
			String str="UPDATE MARKS";
			System.out.printf("%-1c%43s%36c\n",ch,str,ch);
			underscore(80);
			int index=0;
			L8:do{
					System.out.print("\nEnter Student Id   : ");
					String stuId=scanner.next();
					L7:for(int i=0;i<stuid.length;i++){
						if(!stuId.equals(stuid[i])){
							continue L7;
							}else{index=i;break L8;}
						}
						System.out.print("Invalid Student ID.Do you want to search again? (Y/n) ");
						String yes=scanner.next();
						switch(yes){
							case ("n"):WelcomeGdseMarkmanagementsystem();
							case ("Y"):continue L8;
						}
				}while(true);
			System.out.println("Student Name       : "+studentName[index]+"\n");
			if(prfMarks[index]==-1 && dbmsMarks[index]==-1 ){
				System.out.print("This student's marks yet to be added.\nDo you want to update the marks of another student? (Y/n) : ");
				String yes=scanner.next();
				yesOrNo(yes);
				if("Y".equals(yes)){continue L9;}
			}else{
				System.out.println("Programming Fundamentals Marks   : "+prfMarks[index]);
				System.out.println("Database Management System Marks : "+dbmsMarks[index]+"\n\n");
				int prfmarks,dbmsmarks;
				L3:while(true){
					System.out.print("Enter new Programming Fundamental Marks :");
					prfmarks=scanner.nextInt();
					if(!marksbetween0and100(prfmarks)){
						System.out.println("Invalid marks.please enter correct marks.\n");
						continue L3;
					}else{break;}
					}
				L2:while(true){
					System.out.print("Enter new DataBase Management System Marks :");
					dbmsmarks=scanner.nextInt();
					if(!marksbetween0and100(dbmsmarks)){
						System.out.println("Invalid marks.please enter correct marks.\n");
						continue L2;
					}else{break;}
					}
				prfMarks[index]=prfmarks;
				dbmsMarks[index]=dbmsmarks;
		    }
			System.out.print("Marks have been updated successfully.\nDo you want to update another student? (Y/n): ");
			String yes=scanner.next();
			yesOrNo(yes);
		}
	}
	public static void deleteStudent(Scanner scanner){
		L9:while(true){
			underscore(80);
			String str="DELETE STUDENT";
			System.out.printf("%-1c%45s%34c\n",ch,str,ch);
			underscore(80);
			int index=0;
			L8:do{
					System.out.print("\nEnter Student Id   : ");
					String stuId=scanner.next();
					L7:for(int i=0;i<stuid.length;i++){
						if(!stuId.equals(stuid[i])){
							continue L7;
							}else{index=i;break L8;}
						}
					System.out.print("Invalid Student ID.Do you want to search again? (Y/n) ");
					String yes=scanner.next();
					switch(yes){
					case ("n"):WelcomeGdseMarkmanagementsystem();
					case ("Y"):continue L8;
						}
			}while(true);
			deletestudentFromArray(index);
			System.out.print("Student has been deleted successfully.\nDo you want to delete another student? (Y/n): ");
			String yes=scanner.next();
			yesOrNo(yes);
		}
	}
	public static void printStudentDetails(Scanner scanner){
		L9:do{
			underscore(57);
			String str="PRINT STUDENT DETAILS";
			System.out.printf("%-1c%38s%18c\n",ch,str,ch);
			underscore(57);
			int index=0,newindex=0;String stuId="";	
			L8:do{
					System.out.print("\nEnter Student Id   : ");
					stuId=scanner.next();
					L7:for(int i=0;i<stuid.length;i++){
						if(!stuId.equals(stuid[i])){
							continue L7;
							}else{index=i;break L8;}
						}
					System.out.print("Invalid Student ID.Do you want to search again? (Y/n) ");
					String yes=scanner.next();
					switch(yes){
						case ("n"):WelcomeGdseMarkmanagementsystem();
						case ("Y"):continue L8;
					}
				}while(true);
			System.out.println("Student Name       : "+studentName[index]);
			if(prfMarks[index]==-1 && dbmsMarks[index]==-1 ){
				System.out.print("\nMarks yet to be added.\n\nDo you want to search another student? (Y/n) ");
				String yes=scanner.next();
				yesOrNo(yes);
				if("Y".equals(yes)){continue L9;}
			}
			String[] copystuid=Arrays.copyOf(stuid,stuid.length);
			totalmarksofstudent();
			sortArrays(total);
			L12:for(int i=0;i<stuid.length;i++){
						if(!stuId.equals(stuid[i])){
							continue L12;
							}else{newindex=i;break L12;}
			}
			String str1="Programming Fundamentals Marks",str2="Database Management System Marks",str3="Total Marks",str4="Avg. Marks",str5="Rank";
			tabel3();
			System.out.printf("\n|%-4s%5c%20d|",str1,ch,prfMarks[newindex]);
			System.out.printf("\n|%-4s%3c%20d|",str2,ch,dbmsMarks[newindex]);
			System.out.printf("\n|%-4s%24c%20d|",str3,ch,(total[newindex]));
			System.out.printf("\n|%-4s%25c%20.2f|",str4,ch,(total[newindex])/2.0);
			System.out.printf("\n|%-4s%31c%12d%8s|\n",str5,ch,(newindex+1),studentRanks(newindex));
			tabel3();
			System.out.print("\n\nDo you want to search another student details? (Y/n) : ");
			String yes=scanner.next();
			yesOrNo(yes);
		}while(true);
	}
	public static void printStudentRanks(Scanner scanner){
		L9:do{
			underscore(57);
			String str="PRINT STUDENT'S RANKS";
			System.out.printf("%-1c%38s%18c\n",ch,str,ch);
			underscore(57);
			totalmarksofstudent();
			sortArrays(total);
			System.out.print("\n");
			tabel();
			String str1="Rank",str2="ID",str3="Name",str4="Total Marks",str5="Avg. Marks";
			System.out.printf("|%-5s|%-5s|%-20s|%-11s|%-10s|\n",str1,str2,str3,str4,str5);
			tabel();
			L10:for (int i = 0; i < total.length; i++){
				if(total[i]==-2){break L10;}
				System.out.printf("|%-5d|%-5s|%-20s|%11d|%10.2f|\n",(i+1),stuid[i],studentName[i],total[i],(total[i]/2.0));
			}
			tabel();
			System.out.print("\nDo you want to go back to main menu? (Y/n) ");
			String yes=scanner.next();
			yesOrNo(yes);
		}while(true);
	}
	public static void bestInProgrammingFundamentals(Scanner scanner){
		L9:do{
			underscore(50);
			String str="BEST IN PROGRAMMING FUNDAMENTALS";
			System.out.printf("%-1c%39s%10c\n",ch,str,ch);
			underscore(50);
			totalmarksofstudent();
			sortArrays(prfMarks);
			System.out.print("\n");
			tabel1();
			String str1="ID",str2="Name",str3="PRF Marks",str4="DBMS Marks";
			System.out.printf("\n|%-5s|%-21s|%-9s|%-10s|\n",str1,str2,str3,str4);
			tabel1();
			L10:for (int i = 0; i < prfMarks.length; i++){
				if(prfMarks[i]==-1){break L10;}
				System.out.printf("\n|%-5s|%-21s|%-9d|%-10d|",stuid[i],studentName[i],prfMarks[i],dbmsMarks[i]);
			}
			System.out.print('\n');
			tabel1();
			System.out.print("\n\nDo you want to go back to main menu? (Y/n) : ");
			String yes=scanner.next();
			yesOrNo2(yes);
		}while(true);
	}
	public static void bestInDatabaseManagementSystem(Scanner scanner){
		L9:do{
			underscore(50);
			String str="BEST IN DATABASE MANAGEMENT SYSTEM";
			char ch='|';
			System.out.printf("%-1c%41s%8c\n",ch,str,ch);
			underscore(50);
			totalmarksofstudent();
			sortArrays(dbmsMarks);
			System.out.print("\n");
			tabel2();
			String str1="ID",str2="Name",str3="PRF Marks",str4="DBMS Marks";
			System.out.printf("\n|%-5s|%-21s|%-10s|%-9s|\n",str1,str2,str4,str3);
			tabel2();
			L10:for (int i = 0; i < dbmsMarks.length; i++){
				if(dbmsMarks[i]==-1){break L10;}
				System.out.printf("\n|%-5s|%-21s|%-10d|%-9d|",stuid[i],studentName[i],dbmsMarks[i],prfMarks[i]);
			}
			System.out.print('\n');
			tabel2();
			System.out.print("\n\nDo you want to go back to main menu? (Y/n) : ");
			String yes=scanner.next();
			yesOrNo2(yes);
		}while(true);
	}
	public static void tabel(){
		System.out.print("+");
			for (int i = 0; i < 5; i++){
				System.out.print("-");
			}
			System.out.print("+");
			for (int i = 0; i < 5; i++){
				System.out.print("-");
			}
			System.out.print("+");
			for (int i = 0; i < 20; i++){
				System.out.print("-");
			}
			System.out.print("+");
			for (int i = 0; i < 11; i++){
				System.out.print("-");
			}
			System.out.print("+");
			for (int i = 0; i < 10; i++){
				System.out.print("-");
			}
			System.out.print("+\n");
		}
	public static void tabel1(){
		System.out.print("+");
		for (int i = 0; i < 5; i++){
			System.out.print("-");
		}
		System.out.print("+");
		for (int i = 0; i < 21; i++){
			System.out.print("-");
		}
		System.out.print("+");
		for (int i = 0; i < 9; i++){
			System.out.print("-");
		}
		System.out.print("+");
		for (int i = 0; i < 10; i++){
			System.out.print("-");
		}
		System.out.print("+");
	}
	public static void tabel2(){
		System.out.print("+");
		for (int i = 0; i < 5; i++){
			System.out.print("-");
		}
		System.out.print("+");
		for (int i = 0; i < 21; i++){
			System.out.print("-");
		}
		System.out.print("+");
		for (int i = 0; i < 10; i++){
			System.out.print("-");
		}
		System.out.print("+");
		for (int i = 0; i < 9; i++){
			System.out.print("-");
		}
		System.out.print("+");
	}
	public static void tabel3(){
		System.out.print("+");
			for (int i = 0; i < 34; i++){
				System.out.print("-");
			}
			System.out.print("+");
			for (int i = 0; i < 20; i++){
				System.out.print("-");
			}
			System.out.print("+");
		}
	public static void underscore(int k){
		for (int i = 0; i <k; i++){
			System.out.print("-");
		}
		System.out.println();
	}
	public final static void clearConsole() { 
		try {
		final String os = System.getProperty("os.name");
		if (os.contains("Windows")) {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); 
		} else {
			System.out.print("\033[H\033[2J");
			System.out.flush(); 
		}
		} catch (final Exception e) { 
			e.printStackTrace();
		} 
	}
	public static boolean stuIdValidation(String stuId){
		boolean isValid=false;
		if(stuId.length()==4  && stuId.charAt(0)=='S'){
			isValid=true;
		}
		String sNum=stuId.substring(1);
		char[] chars=sNum.toCharArray();
		for (int i = 0; i < chars.length; i++){
			if(!Character.isDigit(chars[i])){
				isValid=false;	
			}
		}
		return isValid;
	}
	public static boolean stuIdDublication(String stuId){
		boolean isCopy=false;
		for(int i=0;i<stuid.length;i++){
			if(stuId.equals(stuid[i])){
				isCopy=true;
			}
		}
		return isCopy;
	}
	public static void yesOrNo(String yes){
		switch(yes){
			case ("n"):WelcomeGdseMarkmanagementsystem();break;
			case ("Y"):clearConsole();break;
			default :WelcomeGdseMarkmanagementsystem();
		}	
	}
	public static void yesOrNo2(String yes){
		switch(yes){
			case ("Y"):WelcomeGdseMarkmanagementsystem();break;
			case ("n"):clearConsole();break;
			default :WelcomeGdseMarkmanagementsystem();
		}	
	}
	public static void stuIdandstuNameinsert(String stuId,String stuname){
		String[] temp=new String[stuid.length+1];
		String[] temp1=new String[studentName.length+1];
		for (int j = 0; j < stuid.length; j++){
			temp[j]=stuid[j];
			temp1[j]=studentName[j];
		}
		stuid=temp;
		studentName=temp1;
		stuid[stuid.length-1]=stuId;
		studentName[studentName.length-1]=stuname;
	}
	public static void prfAndDbmsinsert(int mprf,int mdbms){
		int[] temp2=new int[prfMarks.length+1];
		int[] temp3=new int[dbmsMarks.length+1];
		for (int j = 0; j < prfMarks.length; j++){
			temp2[j]=prfMarks[j];
			temp3[j]=dbmsMarks[j];		
		}
		prfMarks=temp2;
		dbmsMarks=temp3;
		prfMarks[prfMarks.length-1]=mprf;
		dbmsMarks[dbmsMarks.length-1]=mdbms;
	}
	public static boolean marksbetween0and100(int marks){
		boolean validMarks=true;
		if(marks<0 || marks>100){
			validMarks=false;
		}
		return validMarks;
	}
	public static void deletestudentFromArray(int index){
		String[] temp=new String[stuid.length-1];
			String[] temp1=new String[studentName.length-1];
			int[] temp2=new int[prfMarks.length-1];
			int[] temp3=new int[dbmsMarks.length-1];
			for (int j = 0,i=0; j < temp.length; j++,i++){
				if(i==index){i++;}
				temp[j]=stuid[i];
				temp1[j]=studentName[i];
				temp2[j]=prfMarks[i];
				temp3[j]=dbmsMarks[i];		
			}
			stuid=temp;
			studentName=temp1;
			prfMarks=temp2;
			dbmsMarks=temp3;
	}
	public static void totalmarksofstudent(){
		total=new int[stuid.length];
		for (int i = 0; i < stuid.length; i++){
			total[i]=prfMarks[i]+dbmsMarks[i];
		}
	}
	public static void sortArrays(int[] a){
		for (int j = a.length-1; j >0; j--){
				for (int i = 0; i <j ; i++){
					if(a[i]<a[i+1]){
						int temp=prfMarks[i];
						int temp3=dbmsMarks[i];
						String temp1=stuid[i];
						String temp2=studentName[i];
						int temp4=total[i];
						prfMarks[i]=prfMarks[i+1];
						stuid[i]=stuid[i+1];
						studentName[i]=studentName[i+1];
						dbmsMarks[i]=dbmsMarks[i+1];
						total[i]=total[i+1];
						prfMarks[i+1]=temp;
						stuid[i+1]=temp1;
						studentName[i+1]=temp2;
						dbmsMarks[i+1]=temp3;
						total[i+1]=temp4;
					}
				}	
			}
	}
	public static String studentRanks(int a){
		String str="";
		switch(a){
			case 0:str="(First)";break;
			case 1:str="(Second)";break;
			case 2:str="(Third)";break;
			case 3:str="(Fourth)";break;
			case 4:str="(Fifth)";break;
		}
		return str;
	}
}
