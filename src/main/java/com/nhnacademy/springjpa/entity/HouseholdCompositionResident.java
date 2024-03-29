package com.nhnacademy.springjpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "household_composition_resident")
public class HouseholdCompositionResident {

    @EmbeddedId
    private Pk pk;

    @Column(name = "report_date")
    private LocalDateTime reportDate;

    @Column(name = "household_relationship_code")
    private String householdRelationshipCode;

    @Column(name = "household_composition_change_reason_code")
    private String householdCompositionChangeReasonCode;

    @MapsId("householdSerialNumber")
    @ManyToOne
    @JoinColumn(name = "household_serial_number")
    private Household household;

    @MapsId("residentSerialNumber")
    @ManyToOne
    @JoinColumn(name = "resident_serial_number")
    private Resident resident;

    @Getter
    @Setter
    @Embeddable
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Pk implements Serializable {

        private Integer householdSerialNumber;

        private Integer residentSerialNumber;
    }
}
