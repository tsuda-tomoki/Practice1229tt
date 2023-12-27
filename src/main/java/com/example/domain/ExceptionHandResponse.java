package com.example.domain;

import java.util.List;

public record ExceptionHandResponse(String code, String message, List<Details> detailsList) {
}
