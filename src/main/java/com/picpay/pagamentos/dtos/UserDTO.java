package com.picpay.pagamentos.dtos;

import com.picpay.pagamentos.domain.enums.UserType;

import java.math.BigDecimal;

public record UserDTO(String firstName, String lastName, String document, String email, String password, UserType type, BigDecimal amount) {
}
