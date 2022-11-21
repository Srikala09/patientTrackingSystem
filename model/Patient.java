package com.example.pts.model;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Setter
@Getter
@Data
@Entity(name = "patient")
public class Patient {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "patient_generator")
    @SequenceGenerator(name="patient_generator", sequenceName = "patient_seq1")
    @Column(name = "id")
    Integer id ;

    @Column(name = "name")
    String name ;

    @Column(name = "gender")
    String gender ;

    @Column(name = "age")
    String age ;

    @Column(name = "marital_status")
    String maritalstatus ;

    @Column(name = "phone_no")
    String mobile ;

    @Column(name ="full_name")
    String fullname ;

    @Column(name="city")
    String  city ;

    @Column(name="district")
    String  district ;

    @Column(name = "state")
    String state ;

    @Column(name ="zipcode")
    String zipcode ;

    @Column(name="temperature")
    String  temperature ;

    @Column(name="bp")
    String  bp ;

    @Column(name="blood_grp")
    String  bloodgroup ;

    @Column(name = "height")
    String height ;

    @Column(name ="weight")
    String weight ;

    @Column(name="consult_doctor")
    String  consultngdoctor ;

    @Column(name="habits")
    String  habits ;

    @Column(name="type_of_patient")
    String  typeofPatient ;




}
