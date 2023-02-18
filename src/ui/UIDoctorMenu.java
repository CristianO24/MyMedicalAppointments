package ui;

import model.Doctor;

import java.util.ArrayList;
import java.util.Scanner;

public class UIDoctorMenu {

    public static ArrayList<Doctor>  doctorsAvaliableAppointments = new ArrayList<>();

    public static void showMenuDoctor() {
        int response = 0;
        do {
            System.out.println("\n");
            System.out.println("Doctor");
            System.out.println("Welcome " + UIMenu.doctorlooged.getName());
            System.out.println("1. Add Avaliable Appointment");
            System.out.println("2. My Schedule Appointments");
            System.out.println("0. Logout");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response) {
                case 1:
                    showAddAvaliableAppointmentsMenu();
                    break;
                case 2:

                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
                default:
                    System.out.println("Please select a correct answer");
            }

        } while (response != 0);
    }    

    private static void showAddAvaliableAppointmentsMenu(){
        int response = 0;
           do {
                System.out.println("\n");
                System.out.println(":: Add Avaliable Appointment");
                System.out.println(":: Select a Month");

                for (int i = 0; i < 3; i++) {
                    int j = i + 1;
                    System.out.println(j + ". " + UIMenu.MONTHS[i]);
                }
                System.out.println("0. Return");
                Scanner sc = new Scanner(System.in);
                response = Integer.valueOf(sc.nextLine());

                if(response > 0 && response < 4){
                    System.out.println(response + ". " + UIMenu.MONTHS[response -1]);
                    System.out.println("Insert the date avaliable : [dd/mm/yyyy]");
                    String date = sc.nextLine();

                    System.out.println("Your date is: " + date + "\n1. Correct \n2. Change Date");
                    int responseDate = Integer.valueOf(sc.nextLine());
                    if (responseDate == 2) continue;

                    int responseTime = 0;
                    String time = "";
                    do{
                        System.out.println("Insert the time avaliable for date: "+ date + " format [16:00]");
                        time = sc.nextLine();
                        System.out.println("Your time is: " + time + "\n1. Correct \n2. Change Date");
                        responseTime = Integer.valueOf(sc.nextLine());
                    }while(responseTime == 2);

                    UIMenu.doctorlooged.addAvaliableAppointment(date,time);
                    checkDoctorAvaliableAppointments(UIMenu.doctorlooged);

                }else if(response == 0 ){
                    showMenuDoctor();
                }

           }while (response != 0);

    }

    public static void checkDoctorAvaliableAppointments(Doctor doctor){
        if (doctor.getAvaliableAppointments().size() > 0 && !doctorsAvaliableAppointments.contains(doctor) ){
            doctorsAvaliableAppointments.add(doctor);
        }
    }
}
