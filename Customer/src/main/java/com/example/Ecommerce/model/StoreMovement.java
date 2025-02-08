package com.example.Ecommerce.model;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "store_movement")
public class StoreMovement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "device_name", nullable = false)
    private String deviceName;

    @Column(name = "device_serial_number", nullable = false, unique = true)
    private String deviceSerialNumber;

    @Column(name = "loan_date")
    private LocalDate loanDate;

    @Column(name = "loan_time")
    private LocalTime loanTime;

    @Column(name = "return_date")
    private LocalDate returnDate;

    @Column(name = "return_time")
    private LocalTime returnTime;

    @Column(name = "loaner_admin")
    private String loanerAdmin;

    @Column(name = "receiver_admin")
    private String receiverAdmin;

    @Column(name = "client")
    private String client;

    @Column(name = "device_project")
    private String deviceProject;

    @Column(name = "device_official_name")
    private String deviceOfficialName;

    @Column(name = "super_visor_admin")
    private String superVisorAdmin;

    @Column(name = "device_notes", columnDefinition = "TEXT")
    private String deviceNotes;

    @Column(name = "store_number")
    private String storeNumber;

    // Constructors
    public StoreMovement() {
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceSerialNumber() {
        return deviceSerialNumber;
    }

    public void setDeviceSerialNumber(String deviceSerialNumber) {
        this.deviceSerialNumber = deviceSerialNumber;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalTime getLoanTime() {
        return loanTime;
    }

    public void setLoanTime(LocalTime loanTime) {
        this.loanTime = loanTime;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public LocalTime getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(LocalTime returnTime) {
        this.returnTime = returnTime;
    }

    public String getLoanerAdmin() {
        return loanerAdmin;
    }

    public void setLoanerAdmin(String loanerAdmin) {
        this.loanerAdmin = loanerAdmin;
    }

    public String getReceiverAdmin() {
        return receiverAdmin;
    }

    public void setReceiverAdmin(String receiverAdmin) {
        this.receiverAdmin = receiverAdmin;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getDeviceProject() {
        return deviceProject;
    }

    public void setDeviceProject(String deviceProject) {
        this.deviceProject = deviceProject;
    }

    public String getDeviceOfficialName() {
        return deviceOfficialName;
    }

    public void setDeviceOfficialName(String deviceOfficialName) {
        this.deviceOfficialName = deviceOfficialName;
    }

    public String getSuperVisorAdmin() {
        return superVisorAdmin;
    }

    public void setSuperVisorAdmin(String superVisorAdmin) {
        this.superVisorAdmin = superVisorAdmin;
    }

    public String getDeviceNotes() {
        return deviceNotes;
    }

    public void setDeviceNotes(String deviceNotes) {
        this.deviceNotes = deviceNotes;
    }

    public String getStoreNumber() {
        return storeNumber;
    }

    public void setStoreNumber(String storeNumber) {
        this.storeNumber = storeNumber;
    }
}