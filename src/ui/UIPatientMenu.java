package ui;

import model.Doctor;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UIPatientMenu {
    public static void showPatientMenu(){

        int response = 0;
            do {
                System.out.println("\n");
                System.out.println("Patient");
                System.out.println("Welcome " + UIMenu.patientlooged.getName());
                System.out.println("1. Book an appointment");
                System.out.println("2. My appointments");
                System.out.println("0. Return");

                Scanner sc = new Scanner(System.in);
                response = Integer.valueOf(sc.nextLine());

                switch (response){
                    case 1:
                        showBookAppointmentsMenu();
                        break;
                    case 2:
                        showPatientMyAppointments();
                        break;
                    case 0:
                        UIMenu.showMenu();
                        break;
            }
        }while (response != 0);

    }

    private static void showBookAppointmentsMenu(){
        int response = 0;
        do{
            System.out.println(":: Book an appointment");
            System.out.println(":: Select date :");
            //<Numeracion>,<numeracion fechas disponibles
            Map<Integer, Map<Integer, Doctor>> doctors = new TreeMap<>();
            int k = 0;
            for (int i = 0; i < UIDoctorMenu.doctorsAvaliableAppointments.size(); i++) {
                ArrayList<Doctor.AvaliableAppointment> avaliableAppointments
                        = UIDoctorMenu.doctorsAvaliableAppointments.get(i).getAvaliableAppointments();

                Map<Integer, Doctor> doctorAppointments = new TreeMap<>();

                for (int j = 0; j < avaliableAppointments.size(); j++) {
                    k++;
                    System.out.println(k +". " + avaliableAppointments.get(j).getDate() +" "+ avaliableAppointments.get(j).getTime());
                    doctorAppointments.put(Integer.valueOf(j),UIDoctorMenu.doctorsAvaliableAppointments.get(i));
                    doctors.put(Integer.valueOf(k), doctorAppointments);
                }
            }

            Scanner sc = new Scanner(System.in);
            int responseDateSelected = Integer.valueOf(sc.nextLine());
            Map<Integer, Doctor> doctorAvailableSelected = doctors.get(responseDateSelected);
            int indexDate = 0;
            Doctor doctorSelected = new Doctor("","");

            for (Map.Entry<Integer,Doctor> doc :doctorAvailableSelected.entrySet())
            {
                indexDate = doc.getKey();
                doctorSelected = doc.getValue();
            }

            System.out.println("\nDate : " +
                    doctorSelected.getAvaliableAppointments().get(indexDate).getDate()+
                    "\nTime : " +
                    doctorSelected.getAvaliableAppointments().get(indexDate).getTime()+
                    "\nDoctor: " + doctorSelected.getName());

            System.out.println("Confirm your appointment: \n1. Yes \n2. No Change Date");
            response = Integer.valueOf(sc.nextLine());

            if (response == 1){
                UIMenu.patientlooged.addAppointmentDoctors(
                        doctorSelected,
                        doctorSelected.getAvaliableAppointments().get(indexDate).getDate(null),
                        doctorSelected.getAvaliableAppointments().get(indexDate).getTime());
                showPatientMenu();
            }

        }while (response != 0);
    }

    private static void showPatientMyAppointments(){
        int response = 0;
        do {
            System.out.println("\n");
            System.out.println(":: My appointments");

            if (UIMenu.patientlooged.getAppointmentDoctors().size() == 0){
                System.out.println("Don't have appointments");
                break;
            }

            for (int i = 0; i < UIMenu.patientlooged.getAppointmentDoctors().size(); i++) {
                int j = i + 1;
                System.out.println(j +
                        "Date: "+ UIMenu.patientlooged.getAppointmentDoctors().get(i).getDate() +
                        "\nTime: "+ UIMenu.patientlooged.getAppointmentDoctors().get(i).getTime() +
                        "\nDoctor: "+ UIMenu.patientlooged.getAppointmentDoctors().get(i).getDoctor().getName());
            }

            System.out.println("0. Return");

        }while (response != 0);

    }
 }

