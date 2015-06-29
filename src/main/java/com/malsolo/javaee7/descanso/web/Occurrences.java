package com.malsolo.javaee7.descanso.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 *
 * @author jbbarquero
 */
@XmlRootElement
@XmlSeeAlso(Occurrence.class)
public class Occurrences extends ArrayList<Occurrence> {

    public Occurrences() {
    }

    public Occurrences(Collection<? extends Occurrence> c) {
        super(c);
    }

    @XmlElement(name = "book")
    public List<Occurrence> getOccurrences() {
        return this;
    }

    public void setOccurrences(List<Occurrence> occurrences) {
        this.addAll(occurrences);
    }

}
