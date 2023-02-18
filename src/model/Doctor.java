package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User {

    private String speciality;
    private ArrayList<AvaliableAppointment> avaliableAppointments = new ArrayList<>();

    public Doctor(String name, String email){
        super(name, email);
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return super.toString() + "speciality: " + speciality + "\n"+
                "Available: " + getAvaliableAppointments() +"\n";
    }

    @Override
    public void showDataUser() {
        System.out.println("Empleado del hospital: Cruz Roja");
        System.out.println("Departamento : Cancerología");
    }


    public void addAvaliableAppointment(String date, String time){
        avaliableAppointments.add( new Doctor.AvaliableAppointment(date,time));
    }

    public ArrayList<AvaliableAppointment> getAvaliableAppointments(){
        return avaliableAppointments;
    }

    public static class AvaliableAppointment {
        private int id;
        private Date date;
        private String time;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        public AvaliableAppointment(String date, String time) {
            try {
                this.date = format.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            this.time = time;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Date getDate(String DATE) {
            return date;
        }

        public String getDate(){
            return format.format(date);
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String toString() {
            return "AvaliableAppointment \n" +
                    "Date: " + date +"\n "+
                    "Time: " + time +"\n ";
        }
    }
}
