package edu.pabloSalgado.practica.plataformaPeliculas.model.vo;

import java.math.BigDecimal;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public final class Money {

    private BigDecimal amount;
    private String currency;

    public Money(BigDecimal amount, String currency) {
        if (amount == null || amount.scale() > 2) {
            throw new IllegalArgumentException("El importe no puede ser nulo y debe tener como máximo 2 decimales.");
        }
        if (currency == null || currency.trim().isEmpty()) {
            throw new IllegalArgumentException("La moneda no puede ser nula o vacía.");
        }
        this.amount = amount;
        this.currency = currency;
    }

    public Money() {
        this.amount = null;
        this.currency = null;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Objects.equals(amount, money.amount) &&
                Objects.equals(currency, money.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currency);
    }

    @Override
    public String toString() {
        return amount + " " + currency;
    }
}