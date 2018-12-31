package ca.lucschulz.dice.green;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Colours {

    @Id
    private Long id;

    @NotNull
    private String colour;

    private boolean isSelected;

    public Colours(String colour) {
        this.colour = colour;
    }

    @Generated(hash = 493140157)
    public Colours(Long id, @NotNull String colour, boolean isSelected) {
        this.id = id;
        this.colour = colour;
        this.isSelected = isSelected;
    }

    @Generated(hash = 413495262)
    public Colours() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColour() {
        return this.colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public boolean getIsSelected() {
        return this.isSelected;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }
}
