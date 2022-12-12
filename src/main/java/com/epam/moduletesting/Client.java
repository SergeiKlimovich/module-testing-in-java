package com.epam.moduletesting;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * The type Client.
 */
@AllArgsConstructor
@Data
public class Client {
    private String addresses;

    /**
     * Gets addresses.
     *
     * @return the addresses
     */
    public String getAddresses() {
        return addresses;
    }

    /**
     * Sets addresses.
     *
     * @param addresses the addresses
     */
    public void setAddresses(String addresses) {
        this.addresses = addresses;
    }
}
