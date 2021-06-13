package org.vs.ctci.domain;

import java.math.BigInteger;

public class Party {
    private BigInteger orderId;
    private BigInteger partyId;
    private String name;

    public Party(BigInteger orderId, BigInteger partyId, String name) {
        this.orderId = orderId;
        this.partyId = partyId;
        this.name = name;
    }

    public BigInteger getOrderId() {
        return orderId;
    }

    public BigInteger getPartyId() {
        return partyId;
    }

    public String getName() {
        return name;
    }
}
