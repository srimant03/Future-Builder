import java.util.*;
import java.util.ArrayList;

class Student {
    String student_name;
    long roll_no;
    float cgpa;
    String branch;
    String status;
    public ArrayList<Company> companies_applied = new ArrayList<Company>();
    public ArrayList<Company> companies_offered = new ArrayList<Company>();

    Student(String student_name, long roll_no, float cgpa, String branch) {
        this.student_name = student_name;
        this.roll_no = roll_no;
        this.cgpa = cgpa;
        this.branch = branch;
        this.status = "Not applied";
        this.companies_offered = new ArrayList<Company>();
        this.companies_applied = new ArrayList<Company>();
    }

    public void register_placementDrive() {
        System.out.println(student_name + " registered for the placement drive at IIITD");
        System.out.println("Your details are:");
        System.out.println("Name: " + student_name);
        System.out.println("Roll No: " + roll_no);
        System.out.println("CGPA: " + cgpa);
        System.out.println("Branch: " + branch);
    }

    public void register_company() {
        this.status = "Applied";
        System.out.println("Successfully registered for the company");
    }

    public void get_availableCompanies() {

    }

    public void get_status() {
        System.out.println("Your status is: " + this.status);
    }

    public void update_cgpa(float new_cgpa) {
        this.cgpa = new_cgpa;
        System.out.println("Your CGPA has been updated to: " + this.cgpa + "by the placement cell");
    }

    public void accept_offer(Company c) {
        this.status = "Placed";
        System.out.println("Congratulations! You have been placed in " + c.company_name);
    }

    public void reject_offer() {
        this.status = "blocked";
        System.out.println("Offer rejected, you have been blocked.");
    }

}

class Placement_Cell {

    public ArrayList<Student> students_reg = new ArrayList<Student>();
    public ArrayList<Company> companies_reg = new ArrayList<Company>();

    Placement_Cell() {
        this.students_reg = new ArrayList<Student>();
        this.companies_reg = new ArrayList<Company>();
    }

    public void open_student_registration() {
        System.out.println("Fill in the details:");
        System.out.println("1) Set the opening time for student registrations");
        System.out.println("2) Set the closing time for student registrations");
    }

    public void open_company_registration() {
        System.out.println("Fill in the details:");
        System.out.println("1) Set the opening time for company registrations");
        System.out.println("2) Set the closing time for company registrations");
    }

    public int get_registered_students() {
        return students_reg.size();
    }

    public int get_registered_companies() {
        return companies_reg.size();
    }

    public void get_average_package() {

    }

    public void get_company_result(Company c) {
        System.out.println("The following students are selected:");
        for (int i = 0; i < c.students_applied.size(); i++) {
            if (c.students_applied.get(i).cgpa >= c.cgpa_cutoff && (c.students_applied.get(i).status != "Placed"
                    || c.students_applied.get(i).status != "Blocked")) {
                System.out.println(c.students_applied.get(i).student_name);
                System.out.println(c.students_applied.get(i).roll_no);
                System.out.println(c.students_applied.get(i).cgpa);
                System.out.println(c.students_applied.get(i).branch);
                c.students_applied.get(i).companies_offered.add(c);
                c.students_applied.get(i).status = "Offered";
            }
        }
    }

    public void get_company_details(String company_name) {
        for (int i = 0; i < companies_reg.size(); i++) {
            if (companies_reg.get(i).company_name.equals(company_name)) {
                System.out.println("Company name: " + companies_reg.get(i).company_name);
                System.out.println("Company role: " + companies_reg.get(i).role);
                System.out.println("Company package: " + companies_reg.get(i).ctc);
                System.out.println("Company cgpa criteria: " + companies_reg.get(i).cgpa_cutoff);
                System.out.println("The following students have been offered by" + companies_reg.get(i).company_name);
                for (int j = 0; j < companies_reg.get(i).students_offered.size(); j++) {
                    System.out.println(companies_reg.get(i).students_offered.get(j).student_name);
                    System.out.println(companies_reg.get(i).students_offered.get(j).roll_no);
                }
            }
        }
    }

    public void get_student_details(String std, long rn) {
        for (int i = 0; i < students_reg.size(); i++) {
            if (students_reg.get(i).student_name.equals(std) && students_reg.get(i).roll_no == rn) {
                System.out.println("Name: " + students_reg.get(i).student_name);
                System.out.println("Roll No: " + students_reg.get(i).roll_no);
                System.out.println("CGPA: " + students_reg.get(i).cgpa);
                System.out.println("Branch: " + students_reg.get(i).branch);
                System.out.println("Status: " + students_reg.get(i).status);
                System.out.println("Companies applied: ");
                for (int j = 0; j < students_reg.get(i).companies_applied.size(); j++) {
                    System.out.println(students_reg.get(i).companies_applied.get(j).company_name);
                }
                System.out.println("Companies offered: ");
                for (int j = 0; j < students_reg.get(i).companies_offered.size(); j++) {
                    System.out.println(students_reg.get(i).companies_offered.get(j).company_name);
                }
            }
        }
    }

}

class Company {
    public String company_name;
    public String role;
    public float ctc;
    public float cgpa_cutoff;
    public String date_time;
    public ArrayList<Student> students_applied = new ArrayList<Student>();
    public ArrayList<Student> students_offered = new ArrayList<Student>();

    Scanner sc = new Scanner(System.in);

    Company(String company_name, String role, float ctc, float cgpa_cutoff) {
        this.company_name = company_name;
        this.role = role;
        this.ctc = ctc;
        this.cgpa_cutoff = cgpa_cutoff;
        this.date_time = "";
        this.students_applied = new ArrayList<Student>();
        this.students_offered = new ArrayList<Student>();
    }

    public void registerToInstituteDrive() {
        System.out.println("Company " + company_name + " registered for the placement drive at IIITD");
        System.out.println("Company details are:");
        System.out.println("Company Name: " + company_name);
        System.out.println("Role: " + role);
        System.out.println("CTC: " + ctc);
        System.out.println("CGPA Cutoff: " + cgpa_cutoff);
        System.out.println("Date and Time: " + date_time);
        System.out.println("REGISTERED SUCCESFULLY");
    }

    public void get_selected_students() {
        System.out.println("The following students are selected:");
        for (int i = 0; i < students_applied.size(); i++) {
            if (students_applied.get(i).cgpa >= this.cgpa_cutoff
                    && (students_applied.get(i).status != "Placed" || students_applied.get(i).status != "Offered")) {
                System.out.println(students_applied.get(i).student_name);
                System.out.println(students_applied.get(i).roll_no);
                System.out.println(students_applied.get(i).cgpa);
                System.out.println(students_applied.get(i).branch);
            }
        }
    }

    public void update_role() {
        String new_role = sc.nextLine();
        this.role = new_role;
    }

    public void update_ctc() {
        Float new_ctc = sc.nextFloat();
        this.ctc = new_ctc;
    }

    public void update_cgpa_cutoff() {
        Float new_cgpa_cutoff = sc.nextFloat();
        this.cgpa_cutoff = new_cgpa_cutoff;
    }
}

public class Main {

    public static ArrayList<Student> students = new ArrayList<Student>();
    public static ArrayList<Company> companies = new ArrayList<Company>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Placement_Cell pc = new Placement_Cell();
        while (true) {
            System.out.println("Welcome to future builder");
            System.out.println("Enter the application");
            System.out.println("Exit the application");
            int choice = sc.nextInt();
            if (choice == 1) {
                while (true) {
                    System.out.println("Choose the mode you want to enter in:");
                    System.out.println("1) Enter as Student mode");
                    System.out.println("2) Enter as company mode");
                    System.out.println("3) Enter as placement cell mode");
                    System.out.println("4) Return to main application");
                    int mode = sc.nextInt();
                    if (mode == 1) {
                        System.out.println("Enter student query to perform");
                        System.out.println("1) Enter as a student:");
                        System.out.println("2) Add students");
                        System.out.println(("3) Back"));
                        int query = sc.nextInt();
                        if (query == 1) {
                            String name1 = sc.next();
                            String rollno = sc.next();
                            for (int i = 0; i < students.size(); i++) {
                                if (students.get(i).student_name.equals(name1)) {
                                    Student s = students.get(i);
                                    while (true) {
                                        System.out.println("Welcome " + s.student_name);
                                        System.out.println("1) Register for placement drive");
                                        System.out.println("2) Register for company");
                                        System.out.println("3) Get all available companies");
                                        System.out.println("4) Get current status");
                                        System.out.println("5) Update CGPA");
                                        System.out.println("6) Accept offer");
                                        System.out.println("7) Reject offer");
                                        System.out.println("8) Back");
                                        int query1 = sc.nextInt();
                                        if (query1 == 1) {
                                            s.register_placementDrive();
                                            pc.students_reg.add(s);
                                        } else if (query1 == 2) {
                                            String comp_name = sc.next();
                                            s.register_company();
                                            for (int j = 0; j < companies.size(); j++) {
                                                if (companies.get(j).company_name.equals(comp_name)) {
                                                    Company c = companies.get(j);
                                                    c.students_applied.add(s);
                                                    s.companies_applied.add(c);
                                                }
                                            }
                                        } else if (query1 == 3) {
                                            System.out.println("Details of available companies:");
                                            for (int j = 0; j < companies.size(); j++) {
                                                if (companies.get(j).cgpa_cutoff <= s.cgpa) {
                                                    System.out.println(companies.get(j).company_name);
                                                    System.out.println(companies.get(j).role);
                                                    System.out.println(companies.get(j).ctc);
                                                    System.out.println(companies.get(j).cgpa_cutoff);
                                                }
                                            }
                                        } else if (query1 == 4) {
                                            s.get_status();
                                        } else if (query1 == 5) {
                                            float new_cgpa = sc.nextFloat();
                                            s.update_cgpa(new_cgpa);
                                        } else if (query1 == 6) {
                                            int k = 0;
                                            float pack = 0;
                                            for (int j = 0; j < s.companies_offered.size(); j++) {
                                                Company x = s.companies_offered.get(j);
                                                if (s.companies_offered.get(j).ctc > pack) {
                                                    pack = x.ctc;
                                                    k = j;
                                                }
                                            }
                                            Company x = s.companies_offered.get(k);
                                            s.accept_offer(x);
                                            x.students_offered.add(s);

                                        } else if (query1 == 7) {
                                            s.reject_offer();
                                        } else if (query1 == 8) {
                                            break;
                                        }
                                    }
                                }

                            }

                        } else if (query == 2) {
                            System.out.println("Enter the number of students you want to add");
                            int num1 = sc.nextInt();
                            for (int i = 0; i < num1; i++) {
                                String name = sc.next();
                                Long roll_no = sc.nextLong();
                                float cgpa = sc.nextFloat();
                                String branch = sc.next();
                                Student s1 = new Student(name, roll_no, cgpa, branch);
                                students.add(s1);
                            }
                        } else if (query == 3) {
                            break;
                        }
                    } else if (mode == 2) {
                        while (true) {
                            System.out.println("Enter company query to perform");
                            System.out.println("1) Add company and details");
                            System.out.println("2) Choose company");
                            System.out.println("3) Get available companies");
                            System.out.println("4) Back");
                            int query = sc.nextInt();
                            if (query == 1) {
                                String name = sc.next();
                                String role = sc.next();
                                float ctc = sc.nextFloat();
                                float cgpa_cutoff = sc.nextFloat();
                                Company c1 = new Company(name, role, ctc, cgpa_cutoff);
                                companies.add(c1);
                            } else if (query == 2) {
                                System.out.println("Choose to enter in avalaible company");
                                String name = sc.next();
                                for (int i = 0; i < companies.size(); i++) {
                                    if (companies.get(i).company_name.equals(name)) {
                                        Company x = companies.get(i);
                                        while (true) {
                                            System.out.println("Welcome " + x.company_name);
                                            System.out.println("1) Update Role");
                                            System.out.println("2) Update package");
                                            System.out.println("3) Update cgpa cutoff");
                                            System.out.println("4) Register to institute drive");
                                            System.out.println("5) Show selected students");
                                            System.out.println("6) Back");
                                            int query1 = sc.nextInt();
                                            if (query1 == 1) {
                                                x.update_role();
                                            } else if (query1 == 2) {
                                                x.update_ctc();
                                            } else if (query1 == 3) {
                                                x.update_cgpa_cutoff();
                                            } else if (query1 == 4) {
                                                x.registerToInstituteDrive();
                                                pc.companies_reg.add(x);
                                            } else if (query1 == 5) {
                                                x.get_selected_students();
                                            } else if (query1 == 6) {
                                                break;
                                            }
                                        }
                                    }
                                }

                            } else if (query == 3) {

                            } else if (query == 4) {
                                break;
                            }
                        }
                    } else if (mode == 3) {
                        while (true) {
                            System.out.println("Welcome to IIITD Placement Cell");
                            System.out.println("1) Open student registrations");
                            System.out.println("2) Open company registrations");
                            System.out.println("3) Get number of student registrations");
                            System.out.println("4) Get number of company registrations");
                            System.out.println("5) Get number of offered/unoffered/blocked students");
                            System.out.println("6)Get student details");
                            System.out.println("7) Get company details");
                            System.out.println("8) Get Average Package");
                            System.out.println("9) Get Company process results");
                            System.out.println("10) Back");
                            int query = sc.nextInt();
                            if (query == 1) {
                                pc.open_student_registration();
                                String startdate = sc.next();
                                System.out.println(startdate);
                                String enddate = sc.next();
                                System.out.println(enddate);
                            } else if (query == 2) {
                                pc.open_company_registration();
                                String startdate = sc.next();
                                System.out.println(startdate);
                                String enddate = sc.next();
                                System.out.println(enddate);
                            } else if (query == 3) {
                                System.out.println(pc.get_registered_students());
                            } else if (query == 4) {
                                System.out.println(pc.get_registered_companies());
                            } else if (query == 5) {

                            } else if (query == 6) {
                                String student_name = sc.next();
                                Long roll_no = sc.nextLong();
                                pc.get_student_details(student_name, roll_no);
                            } else if (query == 7) {
                                String comp = sc.next();
                                pc.get_company_details(comp);
                            } else if (query == 8) {
                                pc.get_average_package();
                            } else if (query == 9) {
                                String company_name = sc.next();
                                for (int i = 0; i < companies.size(); i++) {
                                    if (companies.get(i).company_name.equals(company_name)) {
                                        Company c = companies.get(i);
                                        pc.get_company_result(c);
                                    }
                                }
                            } else if (query == 10) {
                                break;
                            }
                        }
                    } else if (mode == 4) {
                        break;
                    }

                }
            } else {
                System.out.println("Thank you for using future builder");
                break;
            }
        }

    }
}