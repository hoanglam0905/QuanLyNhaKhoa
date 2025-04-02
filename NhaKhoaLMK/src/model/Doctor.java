package model;

import java.sql.Date;
import java.util.LinkedList;
import java.util.Queue;

class Doctor extends Employee {
    private String specialty;
    private Queue<String> patientQueue;

    public Doctor(String id, String name, Date birthDate, String address, int gender, String phoneNumber, String idCard, String username, String password, double salary, String specialty) {
        super(id, name, birthDate, address, gender, phoneNumber, idCard, username, password, salary, "Doctor");
        this.specialty = specialty;
        this.patientQueue = new LinkedList<>();
    }

    public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public Queue<String> getPatientQueue() {
		return patientQueue;
	}

	public void setPatientQueue(Queue<String> patientQueue) {
		this.patientQueue = patientQueue;
	}

	public void addPatientToQueue(String patientId) {
        patientQueue.add(patientId);
    }

    public void processNextPatient() {
        if (!patientQueue.isEmpty()) {
            System.out.println("Processing patient: " + patientQueue.poll());
        } else {
            System.out.println("No patients in queue.");
        }
    }
}
