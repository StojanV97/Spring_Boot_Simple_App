package de.jonashackt.springbootvuejs.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PAINTER_ART")
public class PAINTER_ART {

    private long painter_id;
    @Id
    @Column(updatable = false)
    private long art_id;

    public PAINTER_ART() {
    }

    public PAINTER_ART(long painter_id, long art_id) {
        this.painter_id = painter_id;
        this.art_id = art_id;
    }


    public long getPainter_id() {
        return painter_id;
    }

    public void setPainter_id(long painter_id) {
        this.painter_id = painter_id;
    }

    public long getArt_id() {
        return art_id;
    }

    public void setArt_id(long art_id) {
        this.art_id = art_id;
    }
}
