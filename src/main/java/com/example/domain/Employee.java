package com.example.domain;

import static org.apache.commons.lang3.StringUtils.isEmpty;
import static org.apache.commons.lang3.StringUtils.isNumeric;

// TODO javadocを書く
public record Employee(String id, String firstName, String lastName) {
}
