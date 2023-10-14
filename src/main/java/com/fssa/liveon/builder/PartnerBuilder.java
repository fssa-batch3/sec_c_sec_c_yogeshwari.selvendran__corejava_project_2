package com.fssa.liveon.builder;

import java.util.List;
import com.fssa.liveon.model.Partners;

public class PartnerBuilder {
    private int partnerIdForBuilder;
    private String partnerFirstNameForBuilder;
    private String partnerLastNameForBuilder;
    private String partnerGenderForBuilder;
    private String partnerEmailForBuilder;
    private long partnerNumberForBuilder;
    private String partnerPasswordForBuilder;

    public PartnerBuilder buildPartnerId(int partnerId) {
        this.partnerIdForBuilder = partnerId;
        return this;
    }


    public PartnerBuilder buildPartnerFirstName(String firstName) {
        this.partnerFirstNameForBuilder = firstName;
        return this;
    }

    public PartnerBuilder buildPartnerLastName(String lastName) {
        this.partnerLastNameForBuilder = lastName;
        return this;
    }

    public PartnerBuilder buildPartnerGender(String gender) {
        this.partnerGenderForBuilder = gender;
        return this;
    }

    public PartnerBuilder buildPartnerEmail(String email) {
        this.partnerEmailForBuilder = email;
        return this;
    }

    public PartnerBuilder buildPartnerNumber(long number) {
        this.partnerNumberForBuilder = number;
        return this;
    }

    public PartnerBuilder buildPartnerPassword(String password) {
        this.partnerPasswordForBuilder = password;
        return this;
    }

    public Partners build() {
        Partners partner = new Partners();
        partner.setPartnerId(partnerIdForBuilder);
        partner.setFirstName(partnerFirstNameForBuilder);
        partner.setLastName(partnerLastNameForBuilder);
        partner.setGender(partnerGenderForBuilder);
        partner.setEmail(partnerEmailForBuilder);
        partner.setNumber(partnerNumberForBuilder);
        partner.setPassword(partnerPasswordForBuilder);
        return partner;
    }
}
