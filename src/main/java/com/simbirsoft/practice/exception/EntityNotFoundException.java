package com.simbirsoft.practice.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EntityNotFoundException extends Exception{
    private String entityName;
}
