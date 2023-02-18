import model.Doctor;
import model.Patient;

import static ui.UIMenu.showMenu;

public class Main {
    public static void main(String[] args) {

        Doctor myDoctor = new Doctor("Cristian Ovalle","cristian@mail.com");
        /*myDoctor.addAvaliableAppointment(new Date(),"10am");
        myDoctor.addAvaliableAppointment(new Date(),"11am");
        myDoctor.addAvaliableAppointment(new Date(),"2pm");
        System.out.println(myDoctor);

        for (Doctor.AvaliableAppointment aA: myDoctor.getAvaliableAppointments()){
            System.out.println(aA.getDate() +" "+ aA.getTime());
        }

        User user = new Doctor("Cristian Ovalle","cristian@mail.com");
        user.showDataUser();

        User userpatient = new Patient("Cristian Ovalle","cristian@mail.com");
        userpatient.showDataUser();*/


        showMenu();

        /*Patient patient = new Patient("Sara Morales", "sara@mail.com");
        patient.setWeight(54.6);
        patient.setPhoneNumber("98765432");
        System.out.println(patient);*/
    }
}