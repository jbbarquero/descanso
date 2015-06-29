/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malsolo.javaee7.descanso.web;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author jbbarquero
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class Occurrence {
    
    private Long id;
    private Long kind;
    private String value;
    private Date date;
    
}
