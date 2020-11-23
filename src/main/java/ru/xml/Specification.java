package ru.xml;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDateTime;

@Entity
@Table
@Component
@XmlRootElement(name = "specification")
public class Specification {
    @Id
    @XmlElement(name = "serialnumb", required = true)
    private String serialnumb;
    @XmlElement(name = "name", required = true)
    private String name;
    @XmlElement(name = "specific", required = true)
    private String specific;
    @XmlElement(name = "createdate", required = true)
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    private LocalDateTime createdate;
    @Override
    public String toString() {
        return "[serialnumb: " + serialnumb + "; name: " + createdate.toString() + "]";
    }

    public String getSerialnumb() {
        return serialnumb;
    }

    public String getName() {
        return name;
    }

    public String getSpecific() {
        return specific;
    }

    public LocalDateTime getCreatedate() {
        return createdate;
    }
}