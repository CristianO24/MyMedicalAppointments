package ui;

import model.Doctor;
import model.Patient;
import java.util.ArrayList;
import java.util.Scanner;

public class UIMenu {

    public static final String[] MONTHS = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
    public static Doctor doctorlooged;
    public static Patient patientlooged;
    public static void showMenu(){
        System.out.println("Welcome to My Appointments");
        System.out.println("Selecciona la opción deseada");

        int response = 0;
        do {
            System.out.println("1. Doctor");
            System.out.println("2. Patient");
            System.out.println("0. Logout");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    System.out.println("Doctor");
                    authUser(1);
                    response = 0;
                    break;
                case 2:
                    System.out.println("Patient");
                    authUser(2);
                    response = 0;
                    break;
                case 0:
                    System.out.println("Thank you for your visit");
                    break;
                default:
                    System.out.println("Please select a correct answer");
            }
        }while (response != 0);
    }

    private static void authUser(int userType){
        //userType = 1 Doctor
        //userType = 2 Patient

        ArrayList<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("Cristian Ovalle","cristian@mail.com"));
        doctors.add(new Doctor("Sara Morales", "sara@mail.com"));
        doctors.add(new Doctor("Paola Lopez","sara@mail.com"));

        ArrayList<Patient> patients = new ArrayList<>();
        patients.add(new Patient("Juan Morales","juan@mail.com"));
        patients.add(new Patient("Mauricio Morales", "mauricio@mail.com"));
        patients.add(new Patient("Janneht Parra","janneth@mail.com"));

        boolean emailCorrect = false;
        do {
            System.out.println("Insert your email :");
            Scanner sc = new Scanner(System.in);
            String email = sc.nextLine();

            if(userType == 1){
                for(Doctor d: doctors){
                    if(d.getEmail().equals(email)){
                        emailCorrect = true;
                        //obtener el usuario logeado
                        doctorlooged = d;
                        UIDoctorMenu.showMenuDoctor();
                    }
                }
            }

            if(userType == 2){
                for(Patient p: patients){
                    if(p.getEmail().equals(email)){
                        emailCorrect = true;
                        //obtener el usuario logeado
                        patientlooged = p;
                        UIPatientMenu.showPatientMenu();
                    }
                }
            }

        }while (!emailCorrect);
    }
}

