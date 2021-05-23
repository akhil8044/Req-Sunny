package com.demo.Model;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.UUID;

@Data
@AllArgsConstructor
public class Plans {
private String planName;
private String planDescription;
private Price totalPrice;
private Benefits benefits;

private UUID id;
}
