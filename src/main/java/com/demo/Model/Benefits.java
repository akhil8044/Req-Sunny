package com.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Benefits {

    private String data;
    private Long calls;
    private int messages;
    private String mInclude;


}
