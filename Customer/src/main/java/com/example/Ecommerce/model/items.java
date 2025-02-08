package com.example.Ecommerce.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "store_items") // Change this to your actual table name if needed
public class items {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "device_name", length = 255, nullable = false)
    private String deviceName;

    @Column(name = "device_serial_number", length = 255, nullable = false)
    private String deviceSerialNumber;

    @Column(name = "adding_date")
    @Temporal(TemporalType.DATE)
    private Date addingDate;

    @Column(name = "device_official_name", length = 255)
    private String deviceOfficialName;

    @Column(name = "device_official_serial", length = 255)
    private String deviceOfficialSerial;

    @Column(name = "device_project", length = 255)
    private String deviceProject;

    @Column(name = "device_notes", length = 255)
    private String deviceNotes;

    @Column(name = "device_image_status", length = 255)
    private String deviceImageStatus;

    @Column(name = "device_status", length = 255)
    private String deviceStatus;

    @Column(name = "rack_number", length = 255)
    private String rackNumber;

    @Column(name = "shelve_number", length = 255)
    private String shelveNumber;

    @Column(name = "store_number", length = 255)
    private String storeNumber;

    // Constructors
    public items() {
    }

    public items(String deviceName, String deviceSerialNumber, Date addingDate, String deviceOfficialName,
                  String deviceOfficialSerial, String deviceProject, String deviceNotes, String deviceImageStatus,
                  String deviceStatus, String rackNumber, String shelveNumber, String storeNumber) {
        this.deviceName = deviceName;
        this.deviceSerialNumber = deviceSerialNumber;
        this.addingDate = addingDate;
        this.deviceOfficialName = deviceOfficialName;
        this.deviceOfficialSerial = deviceOfficialSerial;
        this.deviceProject = deviceProject;
        this.deviceNotes = deviceNotes;
        this.deviceImageStatus = deviceImageStatus;
        this.deviceStatus = deviceStatus;
        this.rackNumber = rackNumber;
        this.shelveNumber = shelveNumber;
        this.storeNumber = storeNumber;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Date getAddingDate() {
        return addingDate;
    }

    public void setAddingDate(Date addingDate) {
        this.addingDate = addingDate;
    }

    public String getDeviceOfficialName() {
        return deviceOfficialName;
    }

    public void setDeviceOfficialName(String deviceOfficialName) {
        this.deviceOfficialName = deviceOfficialName;
    }

    public String getDeviceOfficialSerial() {
        return deviceOfficialSerial;
    }

    public void setDeviceOfficialSerial(String deviceOfficialSerial) {
        this.deviceOfficialSerial = deviceOfficialSerial;
    }

    public String getDeviceProject() {
        return deviceProject;
    }

    public void setDeviceProject(String deviceProject) {
        this.deviceProject = deviceProject;
    }

    public String getDeviceNotes() {
        return deviceNotes;
    }

    public void setDeviceNotes(String deviceNotes) {
        this.deviceNotes = deviceNotes;
    }

    public String getDeviceImageStatus() {
        return deviceImageStatus;
    }

    public void setDeviceImageStatus(String deviceImageStatus) {
        this.deviceImageStatus = deviceImageStatus;
    }

    public String getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(String deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    public String getRackNumber() {
        return rackNumber;
    }

    public void setRackNumber(String rackNumber) {
        this.rackNumber = rackNumber;
    }

    public String getShelveNumber() {
        return shelveNumber;
    }

    public void setShelveNumber(String shelveNumber) {
        this.shelveNumber = shelveNumber;
    }

    public String getStoreNumber() {
        return storeNumber;
    }

    public void setStoreNumber(String storeNumber) {
        this.storeNumber = storeNumber;
    }
}
